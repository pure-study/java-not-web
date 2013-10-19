NOTICE:
1. add %JAVA_HOME%\jre\lib\javaws.jar to your jdk classpath.
2. add
     org.eclipse.swt.win32.win32.x86_3.7.2.v3740f.jar
     will-common-0.0.1.jar
   to your maven local repository.

command may be like this:
mvn install:install-file -Dfile=org.eclipse.swt.win32.win32.x86_3.7.2.v3740f.jar\
 -DgroupId=org.eclipse -DartifactId=swt.win32.win32.x86 -Dversion=3.7.2.v3740f -Dpackaging=jar
