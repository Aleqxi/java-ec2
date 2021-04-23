# Implementation document for Spell Checker

Updated 23.4.2021

## Package structure

The program contains four packages:

* dao
* dev
* domain
* userinterface

Packace _dao_ contains the file reading methods. Dao class is used via the interface.
This solution leaves us the possibility to use other dictionaries more easily, or even choose between different dictionaries, if languages would be added later.

Package _domain_ contains all the logic that is used.
The heart of the program is CheckerService class that creates features for the user interface.
Other classes in this package are the algorithm and data structure implementations and very short Main that just calls the UI and starts the program.
This package has dependence on the package _dao_, as the classes here do use the dictionary resources.

Package _userinterface_ contains text-based user interface. Its functionalities are self-explanatory.

Package _dev_ contains all the classes and methods that are used during the development. 
There are no dependences to that class from other classes, and these are not actively used in the program.
The package also contains old text-based user interface that is replaced with GUI on week 5.

## File resources

The program uses the 15 000 word dictionary as a csv file resource. 
Dictionary is located in default maven resource folder (_src/main/resources/_).

## Algorithms and data structures

The program uses weighted Optimal String Alignment algorithm that is implemented in the class OptimalStringAlignment.
The algorithm is based on Levenshtein algorithm, and simplier dev version is implemented in Levenshtein class.

At the moment, both time and space complexities for the weighted Optimal String Alignment algorithms are O(nm) where n and m are the words that are compared.

For every word in the text input, the program
* Checks if the resource file contains the word
* If not, calculates weighted Optimal String Alignment distance (comparing the input word with all the dictionary words).

So the constant for the dictionary size is 15 000, and all of them are looped at least once for every word.
I think that this could not be enhanced easily, as the spelling error can be in first letters too and change the length of the word.
But the efficiency has been quite good with my test inputs, no extra waits.
