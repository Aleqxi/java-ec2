# User instructions for Spell Checker and Trainer Program

Before releases, the program can be run by cloning this project from GitHub.

Project is created wiht Java and requires Java 11 or later. Maven is used.

## Running the programs

Spell Checker can be run on command line with command
```
mvn compile exec:java -Dexec.mainClass=domain.Main              
```
on the project root folder _SpellChecker_.

Trainer program can be run on command line with command
```
mvn compile exec:java -Dexec.mainClass=trainerDomain.Main 
```
on the project root folder _TrainSpellChecker_.

## Usage

The new GUI is quite self-explanatory. The only funcion it does is spell checking.

Just add the text you want to check to text area in the window and click the button.
The program lists the false words and the suggestions to replace them (best suggestions first).

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

## Code quality

Checkstyle is used to test static code quality in Spell Checker (not in the trainer program). Run checkstyle from the project root with this command:
```
mvn jxr:jxr checkstyle:checkstyle
```
The report will appear to the project location /target/site/checkstyle.html.
