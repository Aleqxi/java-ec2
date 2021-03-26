# Week report 2

This week I got ready the first working version of spell checking.
It means that the program can now check one word and suggest 0-10 best replacement options based on optimal string alignment distance.

This is kind of "minimum viable product" that could be used for actual spell checking, and it is now already extended with transpositions.

## Algorithms

This week I implemented first executable versions of Levenshtein algorithm (the basis of the optimal string alignment algorithm) and also the optimal string alignment algorithm itself.
I also started studying the alphabet-weighting of different combinations, but did not get that far yet with that.

## Program

The program has now both algorithms, basic Levenshtein and optimal string alignment distance, implemented.
It also provides 10 best suggestions for replacing the word that is not found from the resource dictionary.

The program have several testing features that are removed afterwards.
While really checking spelling, there are no need to be able to call algorithms with sample words from user interface.
At the moment it is handy tool for debugging, and that is why there are so many different options in UI.

Jacoco is working and testing is started. Still some unit test must be written, I am going to update them next (on Saturday 27th, as I also need sleep :D ).

Javadoc should be quite well up to date, and checkstyle is next on my list. Methods are quite long, I am not sure if that is a problem or not.

## What I learned?

I learned to implement both Levenshtein algorithm and also optimal string alignment algorithm in their basic forms.
Two weeks ago, I was very unsure if I could understand these during the course, but I found very good materials that explain _why_ the Levenshtein works as it does.
So the biggest thing I learned was the concept of edit distances in more depth.

The optimal string alignment was clear after I understood the Levenshtein.
Also the implementations were clear after understanding the different kind of modifications and how each of them is implemented in the table.
This is so even though it took some time to get the algorithms work in practice, but that was just coding.

## Unclear things

At the moment, alphabet-weighting the values is still very unclear for me. It is the next big issue I should implement. 
I need to read more regarding to this on week 3, as even the idea is not perfectly clear yet.

Other things are quite clear, no bigger problems this far.

## Hours used

12 hours this week.
