
Demo project to find out how works Selenium and Surefire with Maven

======== PROJECT BUILD ======
** IDE **
Eclipse Juno Service Release 1 

** plugin IDE **
M2E - Maven Integration for Eclipse

** JDK compiler**
Java 1.6


** Project build instructions **
Run Maven pom.xml

----------------------------------------
Create following Maven build components:
---------------------------------------
# To install and package Maven project:
Name: test-automation-app_install
Goal: install

# To start Selenium Server (if is not already launche after the above Install goal)
Name:test-automation-app_Start_selenium_server
Goal: selenium:start-server

# To launch integration-test with Selenium plugin
test-automation-app_integration-test
Goal:integration-test

# Create Site file and folder for Surefire plugin
Name:test-automation-app_Surefire_site
Goal: site:site

#Create the report in HTML format
Name:test-automation-app_Surefire_reports
Goal surefire-report:report-only

** App Server **
Tomcat Server 6.0

** Integration Test**
Run Maven build in Eclipse :test-automation-app_integration-test

** USEFUL DOCUMENTATION **
#Selenium docs:
	http://docs.seleniumhq.org/
	http://docs.seleniumhq.org/download/maven.jsp
#Selenium WebDriver guide	
	http://docs.seleniumhq.org/docs/03_webdriver.jsp#introducing-the-selenium-webdriver-api-by-example
#Surefire docs:
	http://maven.apache.org/surefire/maven-surefire-plugin/
	http://maven.apache.org/plugins-archives/maven-surefire-plugin-2.11/test-mojo.html
#Surefire reports
	http://maven.apache.org/plugins/maven-war-plugin/surefire-report.html
