package com.ling;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Start {
    public static void main(String[] args) throws Exception {
        doStart(args);
//        t3.dataman.mongodb.app.ad.main(args);
    }

    private static void doStart(String[] args) {
        String packageName = "t3.dataman.mongodb.app";
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        String packagePath = packageName.replace(".", "/");
        URL url = loader.getResource(packagePath);
        List<String> fileNames = new ArrayList<>();
        try {
            if (url != null) {
                String type = url.getProtocol();
                if ("file".equals(type)) {
                    fileNames = getClassNameByFile(url.getPath(), null, true);
                } else if ("jar".equals(type)) {
                    fileNames = getClassNameByJar(url.getPath(), true);
                }
            }
            for (String fileName : fileNames) {
                try {
                    Class clazz =  Class.forName(fileName);
                    Method method = clazz.getMethod("main", String[].class);
                    if (method != null && !fileName.matches(".+Studio3T.+")) {
                        method.invoke(null, (Object) args);
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static List<String> getClassNameByFile(String filePath, List<String> className, boolean childPackage) {
        List<String> myClassName = new ArrayList<>();
        File file = new File(filePath);
        File[] childFiles = file.listFiles();
        for (File childFile : childFiles) {
            if (childFile.isDirectory()) {
                if (childPackage) {
                    myClassName.addAll(getClassNameByFile(childFile.getPath(), myClassName, childPackage));
                }
            } else {
                String childFilePath = childFile.getPath();
                if (childFilePath.endsWith(".class")) {
                    childFilePath = childFilePath.substring(childFilePath.indexOf("\\classes") + 9, childFilePath.lastIndexOf("."));
                    childFilePath = childFilePath.replace("\\", ".");
                    myClassName.add(childFilePath);
                }
            }
        }
        return myClassName;
    }

    private static List<String> getClassNameByJar(String jarPath, boolean childPackage) throws IOException {
        List<String> myClassName = new ArrayList<String>();
        String[] jarInfo = jarPath.split("!");
        String jarFilePath = jarInfo[0].substring(jarInfo[0].indexOf("/"));
        String packagePath = jarInfo[1].substring(1);
        JarFile jarFile = new JarFile(jarFilePath);
        Enumeration<JarEntry> entrys = jarFile.entries();
        while (entrys.hasMoreElements()) {
            JarEntry jarEntry = entrys.nextElement();
            String entryName = jarEntry.getName();
            if (entryName.endsWith(".class")) {
                if (childPackage) {
                    if (entryName.startsWith(packagePath)) {
                        entryName = entryName.replace("/", ".").substring(0, entryName.lastIndexOf("."));
                        myClassName.add(entryName);
                    }
                } else {
                    int index = entryName.lastIndexOf("/");
                    String myPackagePath;
                    if (index != -1) {
                        myPackagePath = entryName.substring(0, index);
                    } else {
                        myPackagePath = entryName;
                    }
                    if (myPackagePath.equals(packagePath)) {
                        entryName = entryName.replace("/", ".").substring(0, entryName.lastIndexOf("."));
                        myClassName.add(entryName);
                    }
                }
            }
        }
        return myClassName;
    }
}
