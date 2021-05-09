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

The program uses the 58110 word dictionary as a csv file resource. 
Dictionary is located in default maven resource folder (_src/main/resources/_).
There is also a smaller dictionary (10 000 words) that was used during development process.xz

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

## Time complexity

The time complexity of optimal string alignment distance is _O(nm)_. N is the length of the falsely spelled word and m is the length of the word it is compared to (to get the optimal string alignment distance).
This is due to the dynamic programming used.

So calculating the optimal string alignment distance between two words would require looping through the table with a cell for every letter combination, starting from the beginning of the words.

Code structure is this (all for or while loops visible here):

```
    weightedOSA(word1, word2) {   
        substringTable = [word2.length + 1][word1.length + 1];

        for (column = 0; column <= word1.length; column + 1) {
            // Create numbers in first column, no loops here
        }

        for (row = 0; row <= word2.length; row + 1) {
            // Create values in first row, no loops here
        }

        for (int row = 1; row <= word2.length(); row++) {
            for (int column = 1; column <= word1.length(); column++) {

                // Define here weights and substitution cost based on previous row and column, no loops here
                
                // Define here also smalles operation distance, no loops used
                
                // Check that distance is changed from previous row and if it is, check if the case is transposition. No loops here either.

            }
        }

```
So there happens a lot inside the for loop. Those parts are dropped out from this pseudocode, as there are only if statements and basic code there.
Those parts of code have no effect on time complexity. 
Full code can be seen [here](https://github.com/sallasal/SpellChecker/blob/main/SpellChecker/src/main/java/domain/OptimalStringAlignment.java).

As this is the case, the highest time complexity comes from two nested for loops that iterate over the substring table.
As the amounts of rows and columns come from lengths of words compared here, the time complexity really is _O(nm)_.

Typically, the time complexity is relatively small, as the lengths of n and m are limited in natural language.

## Memory complexity

The memory complexity of my optimal string alignment implementation is also _O(nm)_.
There really is created a table that has n columns and m rows, and it is dynamically filled with optimal string alignment distance values.

Memory complexity could be enhanced by noticing that only previous column and previous row are used to calculate the new values dynamically.
So only 2m and 2n memory slots would be used instead of n \* m slots. Memory slots for older rows and columns could bw overwritten.

But, again, with natural language cases n and m are relatively small, and memory complexity is not a problem without this optimization.

## Further ideas

With this program, it would be relatively easy to use **other languages** as well. 
That would only require a comprehensive dictionary that would be added as text file to program resources, and the resource path need to be changed.
It is important to notice that the dictionary must contain also inflected forms of words.
Without any modifications, this could make the dictionary too large and the program too slow, if the language has much inflected forms.
This is the reason I did not already try that with Finnish.

At the moment, the suggestions are created from three queues based on optimal string alignment distance. So the best suggestion is not necessarily the first but among perhaps three first suggestions (with just a small difference between the values).
This is so as the development process started with just integers and the osa value was always an integer.
It works now well, but it could be tried to use just one, sorted queue that all new possible suggestions would be compared to.
I am not sure if that would enhance or reduce performance, as that would require very much sorting. This should be carefully tested if tried.
