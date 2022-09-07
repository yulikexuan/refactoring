# Chapter 1 - Refactoring Basics

## Resources

- [Extract Function](https://memberservices.informit.com/my_account/webedition/9780135425664/html/extractfunction.html)
- [Inline Variable](https://memberservices.informit.com/my_account/webedition/9780135425664/html/inlinevariable.html)
- [Move Function](https://memberservices.informit.com/my_account/webedition/9780135425664/html/movefunction.html)
- [Replace Conditional with Polymorphism](https://memberservices.informit.com/my_account/webedition/9780135425664/html/replaceconditionalwithpolymorphism.html)

## The First Step in Refactoring

### Before Adding a New Feature

- If the code is not structured in a convenient way
  - first refactor the program to make it easy to add the feature 
  - then add the feature

### Before you start refactoring

- Make sure you have a solid suite of tests 
- These tests must be self-checking


### Extract Function

- Look in the fragment for any variables that will no longer be in scope
  once having extracted the code into its own function
- Commit the change to the local version control system

### It's an important habit to test after every refactoring

- Refactoring changes the programs in small steps 
  - so if you make a mistake, it is easy to find where the bug is

### It's much easier to tune the performance of well-factored code
- Due to the refactoring, we can apply a more effective performance-tuning 
  enhancement instead

### Make refactoring end up with code that's both clearer and faster

### The Overall Advice on Performance with Refactoring 

- Most of the time we should ignore it 
- If refactoring introduces performance slow-downs
  - finish refactoring first
  - do performance tuning afterwards 

### Three Major Stages about basic Refactoring

- Decomposing the whole one Original Function into a set of Nested Functions 
- Using [Split Phase](https://memberservices.informit.com/my_account/webedition/9780135425664/html/splitphase.html) to Separate the Calculation and Presentation Code 
- Introducing a Polymorphic Calculator for the Calculation logic 

### A Common Sequence 

- Read and study the code 
- Gain some insight about if we need refactoring
- Use refactoring to move that insight from your head back into the code
- The clearer code then makes it easier to understand it
  - leading to deeper insights and a beneficial positive feedback loop

### The true test of good code is how easy it is to change it

- Code should be obvious 
- Code should be changed easily and quickly without introducing any errors
- A healthy code base maximizes our productivity
- A healthy code base allows us to build more features for our users both faster 
  and more cheaply 


##  The Rhythm of Refactoring

- Tiny steps make refactoring go faster and never break the code 
- Compose those tiny steps into substantial changes finally
