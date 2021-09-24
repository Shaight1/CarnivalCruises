# Carnival Cruises

This project uses TestNG as a testing framework as we can see on the file located on: 

	../testng.xml


This project has 4 abstraction layers called: 
*	Features
*	StepDefinitions
*	Tasks
*	Page Object
Each layer has a higher detail level than the former to make it easier to give maintain to the code.

# You need
In order to run your tests, you will need:
*	Java 1.8 (Don't forget to add java to environment variables)
*	Chrome 94.0.4606.xx
*   Maven

# Feature 
The feature is located on: 

	../src/test/resource/funtionalTestFeatures/SmokeTesting.feature

# Running the tests
For the tests to be executed all the new scenarios within the features should have the tag "@EXECUTE".
You should navigate towards the root project directory and run the following command:

	mvn clean test

that will make the scenarios within the features to run.


