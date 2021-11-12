# Selenium

Useful scripts for tests with Selenium.

## Compiling with Selenium Server jar & TestNG jar

Compile your Java class with a classpath that points to your Selenium Server jar, TestNG jar & local Java class.

    javac -cp /opt/selenium-server.jar:/opt/testng.jar:. SeleniumTest.java

## Running with Selenium Sever jar & TestNG jar

Compile your Java class with a classpath that points to your Selenium Server jar, TestNG jar & local Java bin.

    java -cp /opt/selenium-server.jar:/opt/testng.jar:. SeleniumTest