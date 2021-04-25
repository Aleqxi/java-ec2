# Spell Checker

This program is spell checker, a course project for Data Structures and Algorithms lab course, University of Helsinki, spring 2021.

The course begins on March 2021 and the project is ready in May 2021.

## Trainer program

For finding frequences of different mistakes that my algorithm recognizes, I have written also a training program. The code is here [in its own folder](https://github.com/sallasal/SpellChecker/tree/main/TrainSpellChecker). If you want to help me with this projects, please upload the trainer program, use it (perhaps [from command line](https://github.com/sallasal/SpellChecker/blob/main/documentation/user_instructions.md#running-the-programs)) with some natural language sample texts and send me the result csv it writes to the project root. (Email: salla.salokanto at helsinki.fi)

I am analyzing a massive amount of blog texts from free corpus (see credit below) but any help is good! The more the merrier.

Results this far are collected to the [result folder under trainer program](https://github.com/sallasal/SpellChecker/tree/main/TrainSpellChecker/results).

__Trainer program is not tested or commented well, it is just for me helping to analyze the data. It is written in very few hours and is not good.__ Not to be graded, hopefully...

## Data credits

The smaller word list (10K) currently found in [project resources](https://github.com/sallasal/SpellChecker/tree/main/SpellChecker/src/main/resources) has 15 000 most common English words and is fetched from [Audience Dialogue website](http://www.audiencedialogue.net/susteng.html).

24.4.2021 I also added larger (58K+) word list in project resources.
This file has 58 110 most common English words and it is fetched from [Mieliestronk's website](http://www.mieliestronk.com/wordlist.html).

The free natural language text corpus is used to find out best weights for different kind of mistakes. The corpus [can be uploaded for free](https://u.cs.biu.ac.il/~koppel/BlogCorpus.htm) and is created for this study: 

_J. Schler, M. Koppel, S. Argamon and J. Pennebaker (2006). Effects of Age and Gender on Blogging in Proceedings of 2006 AAAI Spring Symposium on Computational Approaches for Analyzing Weblogs._

## Documentation

- [Implementation document](https://github.com/sallasal/SpellChecker/blob/main/documentation/implementation_document.md)
- [Project backlog](https://github.com/sallasal/SpellChecker/blob/main/documentation/project_backlog.md)
- [Requirements specification](https://github.com/sallasal/SpellChecker/blob/main/documentation/requirements_specification.md)
- [Test document](https://github.com/sallasal/SpellChecker/blob/main/documentation/test_document.md)
- [User instructions](https://github.com/sallasal/SpellChecker/blob/main/documentation/user_instructions.md)
- [Week report 1](https://github.com/sallasal/SpellChecker/blob/main/documentation/week_report_1.md)
- [Week report 2](https://github.com/sallasal/SpellChecker/blob/main/documentation/week_report_2.md)
- [Week report 3](https://github.com/sallasal/SpellChecker/blob/main/documentation/week_report_3.md)
- [Week report 4](https://github.com/sallasal/SpellChecker/blob/main/documentation/week_report_4.md)
- [Week report 5](https://github.com/sallasal/SpellChecker/blob/main/documentation/week_report_5.md)
