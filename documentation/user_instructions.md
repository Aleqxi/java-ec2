# User instructions for Spell Checker

Before releases, the program can be run by cloning this project from GitHub.

Project is created wiht Java and requires Java 11 or later. Maven is used.

## Running the program

Program can be run on command line with command
```
mvn compile exec:java -Dexec.mainClass=domain.Main              
```
on the project root folder _SpellChecker_.

## Usage

Text user interface is quite self-explanatory. At the moment, user can select these options:

* c : check spelling! [This is the main function of the program.]
* l : this command calculates basic Levenshtein edit distance between two words inserted by user.
* o : this command calculates optimal string alignment distance between two words inserted by user.
* w : this command checks if the word inserted is in the resource dictionary.
* q : stops the execution.

The inputs should be single words without white spaces. __At the moment, inputs are not trimmed, so failures can happen if something other is inserted.__
This is because the usage of the program is not in its final form.

## Testing and test coverage

JUnit test can be run with running this command:
```
mvn test
```
in the root folder of the project.

Test coverage can be checked with running this command:
```
mvn test jacoco:report
```
in the root folder of the project. This will generate the test coverage report _index.html_ to folder _target/site/jacoco/_.
