# Week report 1

At the moment I have decided my project topic, Spell Checker. 
I have read and studied the algorithms and compared the options that could be used here.

I have also created the project structure and first runnable version of the program, but it does not do much yet. 
I have created the basis of the project documentation.

## Algorithms

I have read a lot about spell checker algorithms. All the algorithms I have studied are based on edit distance, not any kind of supervised learning.
I have mainly studied and compared these three algorithms:
* Levenshtein distance
* Damerau-Levenshtein distance
* Optimal string alignment distance

They are all based on Levenshtein distance, and all of them include comparisations of strings and substrings.
All three can be implemented with different approaches of dynamic programming, and the results can be improved with aplhabetical weighting.
Levenshtein distance is restricted one, and the others do understand character transpositions as well.

Regarding to the articles I read, the best option of comparing the natural language words would be optimal string alignment distance.
This is due to the fact that natural language words are relatively short and the edit distance more than 2 is seldom useful with them.
Optimal string alignment distance is the restricted version of Damerau-Levenshtein that allows one transposition, and this is almost always enough with natural language, if I have it right.
The full Damerau-Levenstein would add complexity, but it would not make the program significantly better, as the case is natural language.
The difference between optimal string alignment distance and full Damerau-Levenshtein is significant with longer strings, such as DNA sequences.
(Molecular biology is the main use case of full Damerau-Levenshtein.)

__So I choose to have optimal string alignment distance to be my goal.__
If needed, it should be possible to transform it to be full Damerau-Levenshtein with small edits.
(If this needs to be done during the project, the performance must be rechecked too.)

Websites, books and other materials I have studied this far are listed on [requirements specification document](https://github.com/sallasal/SpellChecker/blob/main/documentation/requirements_specification.md).
That document also contains more reflection regarding the algorithms.

## Program

At the moment, the program structure (Java + Maven) and the package structure are ready. The program can be run. 
Structures for style checks and test coverage reports are ready. The resource file that contains dictionary is read through data access object model.

At the moment, it reads the 15 000 most common English words from resource file to string array. 
When the user gives a word input, the program loops the dictionary array through and tells the user whether the string is in the array (is a correct word) or not.

## What I learned?

Most of the time was used to study the edit distance algorithms, so I learned most about them.
I learned also how the basic Levenshtein implementation could work (generally), so next I just have to do the first version with Java.

I think I learned quite a lot this week, as I knew just nothing about these beforehand.
These are interesting algorithms and it was also interesting to read more general articles regarding spell checking (and also grammar checks I do not implement here).

I think that this is a good topic for me.

## Unclear things

Nothing special, mainly it would be great to hear if I got something badly wrong while studying!

Next steps are clear, I have some project plans in my [project backlog](https://github.com/sallasal/SpellChecker/blob/main/documentation/project_backlog.md).

## Hours used

14 hours this far (including personal Zoom guidance and the start session of the course).
