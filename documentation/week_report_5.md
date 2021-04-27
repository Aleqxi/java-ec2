# Week report 5

Finalizing the algorithm with minor enhancements.

Creating GUI and refactoring the code (a lot).

Writing the peer review.

## Algorithms and data structures

My algorithm is about to be ready now. The weights can be improved a little in the future, but that is all. This is good, as there is just a little time left.

I think I am going to try larger dictionary for getting better word lists. I could compare the performance, as I need to check time complexity anyway.

## Programs

I created a new graphical user interface and replaced old text-based user interface with that.

I did much refactoring on my main program (Spell Checker). I created new package, _dev_, and moved all the unused dev classes, backups and old text UI there.
There are no dependencies in other classes or packages to that class, but all the stuff is still there if needed.
I have used dev methods and simplier classes and algorithm a lot, and all of them have been in old text-based user interface.

With the new, simplier UI and refactored code, I think that it is much easier to use and understand what is done and which parts of the code are current.

I also did some minor fixes and enhacements. For example, I checked the input strings further with regex for creating better suggestions for user.

## What I learned

It was interesting to do the peer review. I saw the trie code first time, and that was interesting. 
So I learned what a trie is (but not that deeply that I could do that myself.)

Otherwise I mainly did refactoring and graphical user interface.

## Unclear things

Is it needed to test user interface with unit tests? From Telegram I understood that that would not be necessary?

I was also thinking that it would not be necessary to test Trainer program, as it is not part of my main program.
It is not that good, it only does what is needed as well as is needed (and not any better :D), and I could use quite a time with that.
But I think that is not necessary either?

## Hours used
12
