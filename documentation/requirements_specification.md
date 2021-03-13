# Requirements specification for Spell Checker

Updated: 13.3.2021

Language of the project is English. 

The project is written on Java, and Maven is used here.

The project is part of the [Data structures and algorithms lab course] of University of Helsinki.
My study path is TKT ("_Tietojenkäsittelytieteiden kandiohjelma_", the bachelor program of Computer Science).

## Purpose of the Spell Checker

This spell checker program is used to check if the input provided is found from list of English words. 
If not, the program offers options for replacing the misspelled word based on Damerau-Levenshtein distance between words.

## Resources

The program uses a list of most common 15 000 English words. This word list is a fixed-size list saved as .txt file.
This file is placed on typical Maven resource folder in [SpellChecker/src/main/resources](https://github.com/sallasal/SpellChecker/tree/main/SpellChecker/src/main/resources).

## Algorithms and data structures

Spell checker uses __optimal string alignment distance algorithm__ as base of the spell checking.
This is an algorithm that is originally generated for spell checking, and it is based on edit distance of two strings.
The algorithm always compares two word together and does not take the language context into account.

The input word and the dictionary word the input is compared to are offered for algorithm as parameters.

The agorithm calculates optimal string alignment distance between two words based on four possible operations:
- insertion of an extra character
- deletion of a character
- substitution of a character (to another)
- transposition of two characters next to each other (but only once!)

The basic optimal string alignment distance (without weighting) is an amount of these operations needed to transform a parameter string to another parameter string.

The optimal string alignment distance is a good way to see how far the words are from each other.
For short strings, words, this should be accurate enough even when it 

Other possible algorithms could be basic Levenshtein distance or full Damerau-Levenshtein distance (allows unlimited amount of transpositions).
The first is not as accurate as the optimal string alignment distance, as it does not notice transpositions at all.
On the other hand, it seems to be the case that the full Damerau-Levenshtein does not perform much better than the optimal string alignment, but it increases the complexity.
This latter case must be looked further. Anyway, all the three algorithms mentioned have the same basis (Levenshtein), and the project can be based on that.
Other variations can be developed on that.

The actual industrial-size spell checkers of course use way more complex modelling and algorithms behind them.
They are based on massive amount of natural language analyzed and modelled. 
This kind of program is many times harder to implement than basic one based on one algorithm, and this is not the purpose of this program.

### Time and memory complexity

The optimal string alignment distance is in this case implemented with dynamic programming.
In practice, calculating the distance is started from the shortest substrings (length of one character) and continued further based on these findings.
The final distance is found when all the substring distances are known.

If length of the first input string is _m_ and the lengt of the second input string is _n_, then the time complexity of the algorithm is _O(mn)_.
This is due to that it must compare every possible substring of the input strings, and this is the amount of them.

The first version implemented here will use a table that has a cell for every substring of the two strings.
Therefore, the memory complexity will also be _O(nm)_.

These complexities are acceptable, as the maximum length of the input string is 15 characters.
But the memory complexity can be decreased by noting that calculating substring distances does only need a couple of rows and columns of the table at the time, not all of them.

### Weights

When the first minimum viable product with optimal string alignment distance is created, the weights for different situations can be added.
For example, the spell checker could weight more the cases where the swapped characters are located near each other on QWERTY keyboard.

Of course, these weights and their performance must be tested and compared with the basic case without weights.

### Word list organization

Also the word list needs to be arranged effectively for searching. 
In the first phase, the list is saved as just an array, and the optimal string alignment distance is calculated for every word (as 15 000 words is not that much).
This can be developed perhaps with some kind of tree structure or array of arrays. This can be specified later on. 

## Use of the program

In the first phase of development, the program is used via text-based user interface.
User can have one word (1-15 characters without white spaces) as an input. If the input is not found from word list, the program will provide 5-10 best alternative spelling options (based on Damerau-Levenshtein distance and other optimizations).

Later, the program can be expanded to accept full sentences and longer strings.

## References

Materials used in this project this far:

- [15 000 most common English words](http://www.audiencedialogue.net/susteng.html). Audience Dialogue website. Referenced 12.3.2021.
- __Algorithms on strings, trees, and sequences : computer science and computational biology__. Gusfield, Dan 1997. Cambridge: Cambridge University Press.
- [Damerau-Levenshtein distance](https://en.wikipedia.org/wiki/Damerau–Levenshtein_distance). Wikipedia. Referenced 13.3.2021.
- [Damerau-Levenshtein Edit Distance Explained](https://www.lemoda.net/text-fuzzy/damerau-levenshtein/). Jensen, James M., 2013. Referenced 13.3.2021.
- [Video: Edit Distance Between 2 Strings - The Levenshtein Distance](https://www.youtube.com/watch?v=MiqoA-yF-0M). Back To Back SWE, 2019. Referenced 13.3.2021.
- [Lehvenstein distance](https://en.wikipedia.org/wiki/Levenshtein_distance). Wikipedia. Referenced 13.3.2021.
