## Studio3TCrack

English | [中文](https://github.com/linG5821/Studio3TCrack/blob/master/README.zh-CN.md)

#### Studio 3T

  Studio 3T is a powerful MongoDB database management tool that provides GUI visualization operations. It can completely let you say goodbye to the command line. The software provides the applicable version for a period of 30 days!

#### Studio3TCrack Introduce

  First of all, I would like to express my apology. This project bypasses the license test, which means Studio 3T can be used indefinitely.However, ***Pro*** and ***Enterprise*** functionality has not been modified，This program is for study and communication only,If necessary, please purchase the legitimate [Studio 3T](https://studio3t.com)

#### Other introduced

 Similarly, windows64 is also available with a.exe executable that you can Clone from this repository to get what you need.The build use [exe4j](https://www.ej-technologies.com/), which you can get from the website and build your own 32-bit executable if you need to.

#### How to Use?

1. If you choose to use ***studio-3t-start.jar***, you need to copy the changes directly to the root of the installation file and run this jar.

2. If you choose to do this installation-free, you can use the.exe executable that you've already built in your project, but you'll need to put a jre in the file directory with the name **jre**, or you'll already have the **JAVA_HOME** environment variable configured locally.

3. How the Mac version is used

   First I recommend that you install the original Studio 3 t package files in the app directory depends on all the jars is copied out, in a separate directory, and then download the Studio - 3 t - start - a MAC. Copy the jar files in the directory, and then enter the directory, run ` java -jar -XstartOnFirstThread ./ studio-3t-start-mac.jar `, of course, you can also write a bash script, Here is an example. Note that the path must be absolute

   ```bash
   # ! /bin/bash
   nohup java -jar -XstartOnFirstThread /Users/xxx/Applications/Studio3T/app/studio-3t-start-mac.jar >/dev/null 2>&1 &
   ```
#### Version Update
    studio-3t-start-2019.2.1:Updated the code implementation, using new ideas to adapt to the new version of Studio 3T version 2019.2.1
    Usage: Same as before
    Build: This time directly packaged executable jar files contain all dependency packages that can be used directly. Check release
   

