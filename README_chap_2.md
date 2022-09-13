# Chapter 2 - Principles in Refactoring 


## Defining Refactoring


### ___Refactoring (noun)___

A change made to the internal structure of software to make it
- easier to understand
- cheaper to modify
  - without changing its observable behavior


### ___Refactoring (verb)___

To restructure software by applying a series of refactorings
- without changing its observable behavior


### ___Small Behavior-Preserving Steps -> A big Change___

Refactoring is all about
- applying small behavior-preserving steps
- making a big change by stringing together a sequence of these
  behavior-preserving steps
- code doesn't spend much time in a broken state


### ___Observable Behavior___

The code should, overall, do just the same things it did before
- It doesn't mean it will work exactly the same
- nothing should change that the user should care about


### Refactoring should always make the code

- Easier to Understand
- Cheaper to Modify


## Two Hats

### Adding Functionality

### Refactoring


## Why Should We Refactor?

### Refactoring Improves the Design of Software

- Without refactoring, the internal Design (the Architecture) of Software
  Tends to Decay
- Devs change code to achieve short-term goals often without a full comprehension
  of the architecture
  - The code is losing its structure
  - The code becomes harder for devs to see the design
  - Loss of the structure of code has a cumulative effect
  - The harder it is to see the design in the code
    - the harder it is for devs to preserve it, and the more rapidly it decays

### Reducing the Amount of Code Makes Modifying Code Correctly and Easily

### Refactoring Makes Software Easier to Understand

### Refactoring Makes Software More Readable

- Programming is all about saying exactly what the author-dev wants
- But there are other-devs to be the users of the source code
  - They will try to read the source code to make some changes
- That users, who we often forget, are actually the most important
- It does really matter if it takes a dev One Week to make a change
  - that would have taken only One Hour with proper understanding of source code

### Try Not Remember Anything We Can Look Up

### Refactoring Helps Devs Find Bugs

- Help in understanding the code also means help in spotting bugs
- Refactoring helps devs be much more effective at writing robust code
  - -> Refactor Code
  - -> Work deeply on understanding what the code does
  - -> Put that new understanding right back into the code
  - -> By clarifying the structure of the program, devs can clarify certain
    assumptions they have made
  - -> Point where spotting the bugs

> I'm Not a Great Developer; I'm just a Good Developer with Great Habits

### Refactoring Helps Me Program Faster

- The Real Life of Developing Software
  - Making progress rapidly at first
  - Taking much longer to add new features after
  - Every new feature requires more and more time to understand how to fit it
    into the existing code base
  - Bugs often crop up with new added features that take even longer to fix
  - Devs wish they could start again from a blank slate (重新開始)
- Good internal design and modularity allows devs
  - to easily find how and where they need to make changes to add a new feature
  - to only have to understand a small subset of the code base to make a change
    - less likely to introduce a bug
    - the debugging effort is much easier
- Finally, the code base turns into a platform for building new features for
  its domain

> Design Stamina Hypothesis
> - By putting our effort into a good internal design
> - We increase the stamina of the software effort
> - Allowing us to go faster for longer

### Refactoring make it be possible to improve the design of existing code
- Because of code decay, it's so difficult to do a good design up-front


## When Should We Refactor?

### The Rule of Three

- The first time you do something, you just do it
- The second time you do something similar, you wince at the duplication,
  - but you do the duplicate thing anyway
- The third time you do something similar, you refactor

___Preparatory Refactoring - Making It Easier to Add a Feature___

- The best time to refactor is just before adding a new feature to the code base
- The best time to refactor is also before fixing a bug

___Comprehension Refactoring: Making Code Easier to Understand___

- Devs can see things about the design that they could not see before refactoring

> Wiping the dirt off a window so you can see beyond

___Litter-Pickup Refactoring___

- Understand what the code is doing, but realize that it's doing it badly
- Refactoring right away if it's easy
- Make a note of it and fix it when completing the immediate task
  - If it's a bit more effort to fix
- It's usually worthwhile to make it a little better

> Always leave the camp site cleaner than when you found it


### Planned and Opportunistic Refactoring

- Opportunistic Refactoring
  - Do not set aside time at the beginning to spend on refactoring
  - Refactoring as part of adding a feature or fixing a bug
  - Refactoring helps do the immediate task and also sets devs up to make future
    work easier
  - Preparatory, Comprehension, Litter-Pickup Refactoring are all Opportunistic

> You have to refactor when you run into ugly code but excellent code needs
> plenty of refactoring too

> tradeoffs: the act of balancing two things that are opposed to each other

- Whenever devs write code, they are making tradeoffs
- The programming tradeoffs devs made correctly for yesterday's feature set
  may no longer be the right ones for the new features they are adding today
- Clean code is easier to refactor when devs need to change those tradeoffs to
  reflect the new reality

> Making Changes Easy First (not easy), then Make Easy Changes

> Software Development is a Process of Accretion

> Accretion : the process of growth or increase, typically by the gradual
> accumulation of additional layers or matter

> The Fastest Way to Add a New Feature is to Change the Code to Make it Easy to Add

> Software Should Be NEVER thought of as DONE

- Planned refactoring is NOT always Wrong
  - If a team has Neglected Refactoring, it often needs dedicated time to get
    their code base into a better state for new features
  - A Week spent Refactoring now can Repay Itself over the next couple of months

> Planned Refactoring should be Rare

> Most Refactoring effort should be the Unremarkable, Opportunistic Kind


### Long-Term Refactoring

- Replace an existing library with a new one
- Pull some section of code out into a component that they can share with another team
- Fix some nasty mess of dependencies that they had allowed to build up
- etc.

> Being ___reluctant___ to have a team do dedicated refactoring

> reluctant: hesitating before doing something because you do not want to do it
> or because you are not sure that it is the right thing to do


### Refactoring in a Code Review

- Refactoring helps devs review someone else's code having the original author
  of the code present


### What Do I Tell My Manager - DO NOT TELL !!

> Managers and Customers :
> - Refactoring is just correcting errors made earlier
> - Refactoring is just work that doesn't yield valuable features
> - Especially, Less Careful Restructuring causes breakages in the code base
> - They don't have the technical awareness to know how code base health impacts
    >   productivity

- The Logic to not Tell
- A Schedule-Driven Manager wants Devs to Do Things the Fastest Way they can
- As an Expert in Programming New Capabilities Fast
  - I know the fastest way is by Refactoring
  - Therefore, I Refactor


### When Should I Not Refactor?

- Don't Refactor If I run across code that is a mess
  - but I don't need to modify it
  - then I don't need to refactor it

> Refactoring gives me benefits when I need to understand how it works

- Don't Refactor when it's easier to rewrite it than to refactor it
  - The decision to refactor or rewrite requires good judgment and experience


## Problems with Refactoring

### Slowing Down New Features

> The whole Purpose of Refactoring is to Make us Program Faster, Producing More
> Value with Less Effort

- ___Large Scale Refactoring___
  - A Large Scale Refactoring that really needs to be done
    - but the New Feature to add is So Small
  - Prefer to Add the Small New Feature and Leave the Larger Refactoring Alone

- Rarely Touched Code
  - The Cost of the Inconvenience is not something we feel very often

> In the industry, too Little Refactoring is Far More Prevalent than Too Much
> - Prevalent: Exists or is very common at a particular time or in a particular place

> We refactor because it makes us faster
> - Faster To Add Features
> - Faster To Fix Bugs

> The Economic Benefits of Refactoring should always be the Driving Factor
> and the more that is understood by developers, managers, and customers,
> the more of the Good Design Curve We'll See


### Code Ownership

- When renaming a function, use [Rename Function](https://memberservices.informit.com/my_account/webedition/9780135425664/html/changefunctiondeclaration.html)
  - retain the old declaration as a pass-through to the new one

> Recommend Against Fine-Grained Strong Code Ownership


### Branches

- The cost that feature branches impose on refactoring is excessive
- Feature Branches should be Sufficiently Short
  - and Integrate As Frequently As Possible


### Testing

- Self-testing code not only enables refactoring
  - also makes it much safer to add new features
    - since devs can quickly find and kill any bugs they introduce


### Legacy Code

- Legacy code is often complex, frequently comes with poor tests, and, above all,
  - is written by Someone Else
- Refactoring can be a fantastic tool to help understand a legacy system
- Cannot safely refactor a big legacy system with NO TESTS
  - So, Add Tests
    - A system is only easy to put under test if it's designed with testing in mind

> << Working Effectively with Legacy Code >>
> - advises you to get the system under test by finding seams in the program
    >   - where you can insert tests


### Databases

> - [Evolutionary Database Design](https://martinfowler.com/articles/evodb.html)
> - [<< Refactoring Databases >>](https://martinfowler.com/books/refactoringDatabases.html)


## Refactoring, Architecture, and Yagni

> Yagni: you aren't going to need it

> One way of Dealing With Future Changes is to put Flexibility Mechanisms
> into the software

- "Finishing Architecture Before Coding" is an Unachievable Goal
- Build software that solves only the currently understood needs
  - but make this software excellently designed for those needs
  - Use refactoring to adapt the architecture to those new demands
    - when our understanding of the users' needs changes

> [Building Evolutionary Architectures: Support Constant Change](https://www.oreilly.com/library/view/building-evolutionary-architectures/9781491986356/)


## Refactoring and the Wider Software Development Process

> In reality most "agile" projects only use the name

> To really operate in an agile way, a team has to be capable and enthusiastic
> refactorers

- The first foundation for refactoring is Self Testing Code
- Self Testing Code, Continuous Integration, and Refactoring


## Refactoring and Performance

- To make the software easier to understand, devs often make changes that will
  cause the program to run slower
- Refactoring can also make software more amenable to performance tuning

> Even if you know exactly what is going on in your system, measure performance,
> don’t speculate. You’ll learn something, and nine times out of ten, it won’t
> be that you were right!

### In most programs, most of their time is spent in a small fraction of the code

- Build program in a well-factored manner without paying attention to performance
  until beginning a deliberate performance optimization exercise
- During this performance optimization
  - Begin by running the program under a profiler that monitors the program and
    tells me where it is consuming time and space
  - Find that small part of the program where the performance hot spots lie
  - Focus on those performance hot spots and optimize
  - As in refactoring, make the changes in small steps
    - After each step I compile, test, and rerun the profiler
    - Back out the change if having not improved performance
    - Continue the process of finding and removing hot spots until I get the
      performance that satisfies my users

### Well Factored Code
- Make adding functionality more quickly
  - Giving more time to focus on performance
    - Profiling ensures devs spend that time on the right place
- Have finer granularity for the performance analysis
  - The Profiler leads devs to smaller parts of the code, which are easier to tune
  - With clearer code, devs have a better understanding of the options and of
    what kind of tuning will work

### Refactoring helps devs write Fast Software
- It slows the software in the short term while we are refactoring
  - but makes it easier to tune during optimization and end up well ahead


## Where Did Refactoring Come From?


## Automated Refactorings


## Going Further

- [Refactoring Workbook]()
- [Refactoring to Patterns](https://martinfowler.com/books/r2p.html)
- [Working Effectively with Legacy Code]()
- [refactoring.com](https://refactoring.com)
