set projectLocation=C:\Users\dell\Desktop\Selenium\Cucumber\finsys
cd %projectLocation%
mvn test -Dcucumber.options="src/test/resources/FeatureCollections"

