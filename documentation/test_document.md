# Test document for Spell Checker

Updated 16.4.2021

## Unit testing

The testing of the project is based on JUnit library.
All the test data is located in _src/test/java/domain/_.
Unit tests can be run in NetBeans or with this command in the project root directory:
```
mvn test
```

Unit tests are created for all the classes except the simple file reader and user interface.
All the main features and their most important combinations are tested this way.

While there still are some dev methods and old algorithm implementations for comparison purposes, they are also tested with unit tests.
This is so, as they were part of the development and at the some point earlier, they have been the best feature available.
These tests will be removed as the dev methods are removed (just before final deadline).

## Integration testing

The integration testing is mostly done by testing CheckerService with JUnit.
This class does the most of feature integration, and it is the one that combines different class methods and handles them for the user interface.

## Graphical html test coverage report

Graphical test coverage report can be created with this command in the project root directory:
```
mvn test jacoco:report
```
This generates the html report to folder _target/site/jacoco/_.

## Performance testing

Performance tests are executed with two different dictionaries, with 10K and 58K+ words. 
While executing performance tests, I also checked that both dictionaries produce reasonable suggestions (and do not produce suggestions when not needed).
Of course, there are some differences between final results as the dictionaries are different, but the setting should get correct values for runtimes.

All the similar test cases are tested with exactly same sentences.

Results:

### Dictionary with 10K words

* Simple 6-word sentence without spelling errors
  * 6691364 ns
* Simple 6-word sentence with two spelling errors
  * 87479226 ns

### Dictionary with 58K+ words

* Simple 6-word sentence without spelling errors
  * 4902501 ns
* Simple 6-word sentence with two spelling errors
  * 163629657 ns

## User testing

The program is also tested from the user perspective regularly during the development process.
This has been very important for finding the best features in practice, such as the most effective string handling operations.
