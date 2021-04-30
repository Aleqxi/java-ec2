# Week report 5

Added larger dictionary to resources.

Compared performance between smaller and larger dictionaries.

Fixed features in main program.

Wrote the peer review 2.

## Algorithms and data structures

Only some minor fixes in the algorithm this week.

Next week I will add the duplicate check so that algorithm checks every error only once.
I think this will improve the performance, as in most texts, some of the errors (names etc.) do occurr regularly.
There is no need to check any word more than once.

I will also add the possibility to suggest words with larger distance, as <2 seems to be too little for rare long words that are badly misspelled.
This should not lower the quality of the suggestions for easier words as this will be done only if necessary.
(This is, when suggestions can't be created with smaller distances.)

## Programs

Main thing was that I started to use larger dictionary (58K+ words instead of 15K words).
This required some minor changes in program, but now changing between dictionaries is as simply as changing the size of the dictionary and path of the resoure file.

I also started comparison tests between the dictionaries.
This required some print methods in the program.

I finalized JavaDoc and fixed tests so that they work with both dictionaries. 

I also decided to skip all the one-letter words as they were always OK in sample input. 
With these, the quality of the suggestions can not be good, as I do not check the context at all.

Also, I did some further refactoring and separated CheckerService functions better from GUI methods.

## What I learned

Now it was interesting to test and compare the dictionaries.
This testing made it clear that using larger dictionary is better for the user.
It is not that effective, of course, but the user experience is much better now.

## Unclear things

Nothing special, all seems to be clear.

## Hours used
18
