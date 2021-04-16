# Backlog for Spell Checker

Updated: 16.4.2021

## Steps to be done

* Enhance the correctiveness by weighting letters next to each other on keyboard more (alphabet-weight edit distance)
* Search for other weights or other ways to increase the efficiency and precision of the algorithm
* Perhaps try to decrease the memory complexity of optimal string alignment distance (it does not need to keep all the indexes in memory all the time)
* Create implementation document
* In the end of the project, clean and finalize the user interface

## Done

* Create a definition document 13.3.2021
* Create project structure 14.3.2021
* Read in the word list resource, first to array 14.3.2021
* Create a simple text UI 14.3.2021
* Check if the word resource contains a word provided by user 14.3.2021
* Add javadoc for existing classes and methods, finished 21.3.2021
* Create first version of Levenshtein algorithm and add it as an option to the user interface 21.3.2021
* Create instructions of use 21.3.2021
* Create test files and start testing 21.3.2021
* Level-up the algorithm to be optimal string alignment distance 26.3.2021
* Provide first spell checking solutions, best first 26.3.2021
* Get results with distance 1-3, starting from 1 and adding more if results are not good enough 26.3.2021
* Create skeleton of Spell checker trainer (minimum viable product) 31.3.2021
* Finish Spell Checker trainer 3.4.2021
* Add checkstyle 5.4.2021
* Check trimming in main program: replace special characters with whitespaces before splitting 6.4.2021
* Clarify match instructions to match trainer also in main program 6.4.2021
* Extend the checking from one word to whole sentence and other longer texts 8.4.2021
* Update tests and check test coverage 8.4.2021
* Rewrite ArrayDeques with own code, write tests and check functionality 11.4.2021
* Create basic type weights based on trainer data 16.4.2021
* Create a testing document 16.4.2021
* Create implementation document 16.4.2021
