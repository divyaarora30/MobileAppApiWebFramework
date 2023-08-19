# Automation Testing for MobileAPP, Web & API Framework
This mobile test automation framework is a ultimate tool for all type of automation testing. This solution contains automation 
for Web, APP and API.
 
This framework used Page Object Model design using Java + Cucumber + Maven.

Technologies/Tools used in building the framework
=================================================
- IntelliJ - IDE
- Appium - v2.0.1
- Maven - 3.8.1
- Java - 11
- Cucumber - 7.0
- Gherkin 
- Extent Reports - Reporting framework


Steps for setup in MacOS:
====================
1. Install Brew
    $ /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install.sh)"

2. Check java version 
    - java -version
3. If no java version installed then install openJDK 11
4. Download and install Android Studio 
    - https://developer.android.com/studio
5. Install XCode from APP Store
6. Install command line tools for XCode
    - xcode-select --install 
7. Install Node 
    - brew install node
    - node -v
    - npm -v
8. Install Appium and WD
    - npm install -g appium
    - npm install wd
9. Install Appium Doc
    - npm install -g appium-doctor
10. Update Java home , Android Home in your profile
    - open ~/.zshrc
    -- Update required location with
        - export ANDROID_HOME=/Users/ashishtiwari/Library/Android/sdk
        - export PATH=$ANDROID_HOME/platform-tools:$PATH
        - export PATH=$ANDROID_HOME/platform-tools/bin:$PATH
        - export PATH=$ANDROID_HOME/build-tools/34.0.0:$PATH
        - export PATH=$ANDROID_HOME/build-tools/34.0.0/bin:$PATH
        - export SAP_JAVA_11_HOME=$(/usr/libexec/java_home -v11)
        - alias sapjava11='export JAVA_HOME=$SAP_JAVA_11_HOME'
    - Save and exit the file   
    - Restart the terminal   
    - echo $JAVA_HOME
    - echo $ANDROID_HOME
11. Run Below command to check the installed tools
    - appium-doctor
13. Installing Appium Plugin and driver
    - appium driver list
    - appium driver install <driver name>
    - appium plugin list
    - appium plugin install <plugin name>
    
14. Plugin and driver installed for this project
    - xcuitest@4.34.0
    - uiautomator2@2.29.4
    - images@2.1.2
    - execute-driver@3.0.15
    - relaxed-caps@1.0.5
    - universal-xml@1.0.9
        
15. Run below command to start the Appium and activate the relaxed-caps plugin
    - appium server -ka 800 --use-plugins=relaxed-caps -pa /wd/hub

16. Plugin to active the intelliJ
    - Cucumber for Java
17. Remember to enable developer options in Android device with USB debugging mode. 
    Use below command to get the device info in terminal
    - adb devices
    - <deivce ID> <device Name>
    - Update this info in GlobalParams.java, udid and deviceName
18. Below commands can be used for troubleshooting adb devices
    - adb kill-server
    - adb start-server
    and reconnect the device
19. Build the project before running
20. Run the testing from below location for various scenario
    - APP
        - ./src/test/java/com/qa/runners/MyRunnerTestMobile.java
    - API
        - ./src/test/java/com/qa/runners/MyRunnerTestApi.java
    - Web
        - ./src/test/java/com/qa/runners/MyRunnerTestWeb.java
        
    If want to run specific test case. Refer below path
        - /src/test/resources/featureFiles
            
21. Check the test result 
    - target/cucumber/cucumber-reporting/cucumber-html-reports/# MobileAppApiWebFramework
