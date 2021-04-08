# Week report 3

I programmed the trainer program and started to collect data for frequency analyses.

I also continued with the main program. It now accepts longer texts and handles them word by word.

## Algorithms

This week I learned and planned the weighting in my algorithm. 
As discussed in Zoom session, I started to collect data from natural language examples with my trainer program.
I am collecting falsely spelled English words from those texts, and calculating frequencies for different mistake types.
I defined the error types in a way that matches my optimal string alignment implementation: 
that is, the word that forms rows for every letter is the input and the word that forms columns for every letter is the correct one the input is compared to.

At the moment, I have 300 words and bit more spelling errors collected. 
I am going to grow my data here.
I have used the Google Blogger database [see README for further details](https://github.com/sallasal/SpellChecker/blob/main/README.md) to get natural text examples.
It is quite a good and fast way. There are varying kinds of blog texts, writes age range being 13-50+.
I have skipped the texts that do not try to be correct English, at least mostly.
I think that the quality of texts and examples is quite good for this purpose, as the spelling errors are natural ones and the genre of the text is pretty good for my program.

At the moment, it seems evitable that most common errors are missing letters (that are corrected with adding a letter). 
This is insertion type in my algorithm implementation.
Other ones, namely deletions, substitutions, and transformations, have more even frequencies.

## Programs

This week I programmed the training program. It is not perfect and the style is not the best possible, but it is good for collecting the data.
It is quite fast and easy to use.
The training program uses the same dictionary than the main Spell Checker, but this is just for convenience. It could use any other error tracker too.
Using the main Spell Checker also helps to detect bugs in the main program, so I think it was quite good solution.

The trainer program also uses simple GUI. I think that if I have time, I could use simple GUI also in main program.
Anyway, the difference would not be great, so this is not important.

Also, the main program now accepts longer texts rather than just single words.
It handles the input string with split method that creates string array.
While handling the input, the input is sanitized by deleting most common special characters, punctuation marks, tabs and new line characters.
I also added the checkstyle, did refactoring for the future, and updated the tests for maintaining high branch and instruction test coverages.

## What I learned

The idea and implementation of training program is good.
It helped me to see the actual texts and what are typical misspellings.
So it gave me better big picture while also creating more accurate frequences and weighting.

It also made me to see what actually are the main problems in natural text.
For now, it seems that the most common mistakes are not based on key location on keyboard but rather the pronounciation of the words.
So the errors seem to be more cognitive and less techical as first expected.

This is a good news in a way that the most common frequencies I am collecting should be an effective solution.
But it also is problematic, as now I should decide whether to use the location-based weighting at all or not, and if I should use it, in which cases.

I learned a lot about weighting also by reading.

## Unclear things

At the moment, it is unclear if I should use the location-based weighting at all. It does not seem to be effective with natural language examples.
Still, it perhaps could give better suggestions in cases that there are very much suggestions with small, same optimal string alignment distance.

First, I need to implement the weighting based on type frequencies. Then I perhaps could try this, but I am sceptical.

# Hours used

20. Most time was spent programming teaching program and collecting examples.
