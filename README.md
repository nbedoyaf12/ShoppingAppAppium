# ShoppingApp

This project is a mobile automation framework designed to execute end-to-end tests on an Android and iOS shopping app. The application files for both operating systems are included in the repository.

## Tecnologies:
- Appium
- Java
- POM
- TestNG

## Automated tests:
- Add More Than 1 Product to Cart.
- Remove Product From Cart.
- Increase and decrease product quantity.
- Filter Products by Price and Name.
- Checkout and Validate Order created.

## Project structure:
- apps: Contains the app files for android and iOS OS.
- src/main/java/app/pages: Contains the POM structure
- src/main/java/app/POJOS: Contains the POJOS to give structure to the data inputs.
- src/test/java/appTests/capabilities: capabilities file for android and iOS.
- src/test/java/appTests: Classes with the tests for each feature.
- src/test/resources/data: json file with the user Data.
- src/test/resources/suites: xml suites to run the tests classes.

## How to run tests:
- Clone the repo
- Make sure an emulator or real device is running. Update the capabilities file accordingly.
- run the automation tests with the next command according to the platform of the device:  mvn test -DsuiteXmlFile=src/test/resources/suites/testng.xml -Dplatform=android.
