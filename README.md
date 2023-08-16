## PeelHealthAutomatedSolutions
A [Java] based automated solution for various [Peel-Health] site navigation functionalities utilising [Selenium] in conjunction with [TestNG] framework. The build environment has been locally set to [Maven]. A page-object-model design has been explored where the test classes invoke various DSL(Domain Specific Language) wrapped methods from the page objects. In an effort to minimize boilerplate code, [Extent reports] have been configured via the TestNG adapter.

Note:
- Extent reports are generated at test-output/SparkReport/
- Screenshots are stored at test-output/screenshots/
- Debug logs are disabled for this build ref:logback-test.xml
- For older versions of Mozilla, some navigation links may not work as they have not been updated

[Peel-Health]: https://www.peelregion.ca/health/
[Java]: https://www.java.com/
[Selenium]: https://www.selenium.dev/
[TestNG]: https://testng.org/doc/
[Maven]: https://maven.apache.org/
[Extent reports]: https://www.extentreports.com/
