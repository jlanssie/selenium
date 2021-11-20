# Selenium

Useful scripts for tests with Selenium.


## Selenium Server

### Compiling with Selenium Server

Compile your Java class with a classpath that points to your Selenium Server jar & local Java class.

    javac -cp /opt/selenium-server.jar:. SeleniumTest.java

### Running with Selenium Server

Run your Java class with a classpath that points to your Selenium Server jar & local Java bin.

    java -cp /opt/selenium-server.jar:. SeleniumTest


## Seleniun Server & TestNG

### Compiling with Selenium Server & TestNG

Compile your Java class with a classpath that points to your Selenium Server jar, TestNG jar & local Java class.

    javac -cp /opt/selenium-server.jar:/opt/testng.jar:. TestNGTest.java

### Running with Selenium Server & TestNG & JCommander

Run your TestNG XML class with testng scheme and a classpath that points to your Selenium Server jar, TestNG jar, JCommander jar & local Java bin

    java -cp /opt/selenium-server.jar:/opt/testng.jar:/opt/jcommander.jar:. org.testng.TestNG testng.xml

## Known issues

Running the TestNG suite causes Selenium and Chromedriver logging to be outputted despite being set to OFF and redirected to dev/null respectively.