## Studio3TCrack

[English](https://github.com/linG5821/Studio3TCrack/blob/master/README.md) | 中文

#### Studio 3T

  Studio 3T是一个功能强大的MongoDB数据库管理工具，它提供GUI可视化操作。它可以完全让您告别命令行。软件提供30天的适用版本!

#### Studio3TCrack介绍

  首先，我想表达我的歉意。这个项目绕过了许可证测试，这意味着Studio 3T可以无限期地使用。但是**Pro** 和**Enterprise** 企业功能没有被修改,这个程序仅供学习和交流,如果有需要,请购买正版Studio 3T](https://studio3t.com)


#### 其他介绍

 同样也提供了windows64的.exe文件。您可以Clone本仓库获得所需的内容。构建使用了[exe4j](https://www.ej-technologies.com/)，如果需要，您可以从网站获得并构建自己的可执行文件。

#### 怎么使用

1. 如果您选择使用**studio-3t-start.jar**，您可以直接复制到安装文件的根目录并运行这个jar包。

2. 如果选择免安装，则可以使用已经在项目中构建好的.exe可执行文件，但是您需要将名称为**jre**的java可执行环境放入相同目录，或者您已经在本地配置了**JAVA_HOME**环境变量。

3. Mac 版本的使用

   首先我建议您先把原本安装的Studio 3T包文件中的app目录下依赖的所有jar包全部拷贝出来，放在一个单独的目录下,然后下载studio-3t-start-mac.jar文件拷贝在该目录下，紧接着进入该目录运行 ``` java -jar -XstartOnFirstThread ./studio-3t-start-mac.jar```当然你也可以写一个bash脚本，以下是一个示例,注意这里的路径必须是绝对路径

   ```bash
   # ! /bin/bash
   nohup java -jar -XstartOnFirstThread /Users/xxx/Applications/Studio3T/app/studio-3t-start-mac.jar >/dev/null 2>&1 &
   ```
#### 版本更新:
    studio-3t-start-2019.2.1:更新了代码实现，使用了新的思路，适应Studio3T新版本2019.2.1版本
    使用方式：与以往相同
    构建：本次直接打包了可执行的jar文件包含全部依赖包，可以直接使用，请查看release
   

