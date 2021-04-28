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

## Comparative performance testing

Performance tests are executed with two different dictionaries, with 10K and 58K+ words. 
While executing performance tests, I also checked that both dictionaries produce reasonable suggestions (and do not produce suggestions when not needed).
Of course, there are some differences between final results as the dictionaries are different, but the setting should get correct values for runtimes.

All the similar test cases, rows in the result table, are tested with exactly same inputs.
Error counts in the table are separated words at the moment, as there is no duplicate check yet when doing this.
Duplicate check will be tested later separatedly and added to the table.

Results (time unit is ns):

| Type of input                                       | Dictionary with 10K words  | Dictionary with 58K words  |
|-----------------------------------------------------|:--------------------------:|:--------------------------:|
| Simple 6-word sentence without spelling errors      | 6 691 364                  | 5 232 745                  |
| Simple 6-word sentence with two spelling errors     | 87 479 226                 | 163 629 657                |
| Short natural text example with 73 words            | 29 122 092 (2 mistakes)    | 29 550 304 (0 mistakes)    |
| Short natural text example with 73 words, corrected | 2 366 777 (0 mistakes)     | -                          |
| Medium-sized natural text example with 541 words    | 255 436 300 (22 mistakes)  | 794 809 957 (22 mistakes)  |
| Long natural language sample with 1056 words        | 440 128 607 (32 mistakes)  | 488 352 382 (7 mistakes)   |
| Very long natural language sample with 4379 words   | 3 413 549 748 (330 mist.)  | 7 977 595 831 (204 mist.)  |

It seems that using the larger dictionary does add the runtime, if the count of errors stay in the same range. But as the larger dictionary categorizes less correct words as mistakes, the results keep almost the same and are much better for the user. This is so even as the check time is quite large with very long texts, like long articles.

Of course, larger dictionary requires more space, but it enhances the user experience so much that it is definitely necessary.

It is also important to note that the less the algorithm finds the mistakes, the better. __Both dictionaries do find real errors.__ But the larger dictionary claims less correct words to be errors. This makes the larger dictionary very much easier for the user.

## User testing

The program is also tested from the user perspective regularly during the development process.
This has been very important for finding the best features in practice, such as the most effective string handling operations.
