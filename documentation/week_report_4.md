# Week report 4

I implemented my own the ArrayDeque features I need and started to use them instead of Java default implementations.

I also calculated weights for optimal string alignment algorithm and started to use them.

## Algorithms and data structures

I am using ArrayDeque data structures in my main program for finding the best suggestions.
I implemented the methods I use myself. The implementation is the class ArrayDeqImplementation. 
Also the Java implementation imports are removed from the CheckerService.

I also calculated more accurate weights for Optimal String Alignment Distance based on my trainer program results (first 400).
The results have been better than I expected with this amount of examples, and the order of magnitudes seem to be quite correct already.
The new, weighted algorithm also works well in practice with almost all inputs.
Only very short inputs with very many options do still offer too much solution suggestions.

## Programs

I implemented the weighting and ArrayDeque myself. These were the major changes. Minor changes were also done to the user interface.

I did nothing for the trainer program, even though it is far from perfect. If someone else should use it more, there would be much to refactor.

## What I learned

I read through ArrayDeque part of the data structures and algorithms course material, and I now remember again how to do these.

I also got deeper understanding on my Optimal String Alignment distances, as I did weighting and tested all the cases.
I am happy it worked as I expected, this was the part that could have caused problems but it did not.

## Unclear things

Still the same unclear thing that last week:
I am not sure if I should use the location-based weighting at all. It does not seem to be effective with natural language examples.
Still, it perhaps could give better suggestions in cases that there are very much suggestions with small, same optimal string alignment distance.

I think that this would not be good idea. The more I get the natural language examples, 
the clearer is that the mistakes are mostly based on pronunciation rather than location on keyboard.

Earlier this week I found [this paper](http://www.diva-portal.org/smash/get/diva2:1116701/FULLTEXT01.pdf) that explains how location-based weighting is be done,
but I still start to think it would not be worth it.

# Hours used
17 (including the training hours)
