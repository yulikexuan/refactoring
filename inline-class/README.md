# Inline Class


## Resources

- [Inline Class](https://memberservices.informit.com/my_account/webedition/9780135425664/html/inlineclass.html)


---
## Motivation

### Inline Class is the inverse of [Extract Class](https://memberservices.informit.com/my_account/webedition/9780135425664/html/extractclass.html)

### Use Inline Class if a class 
- is no longer pulling its weight
- shouldn't be around anymore

### If there are two classes that should be refactored into a pair of classes 
- with a different allocation of features

- #### First use Inline Class to Combine them Into a single class

- #### then Extract Class to make the new separation

### Sometimes, it's better to use an inline refactoring 
- to collapse the contexts together  
- then use an extract refactoring to separate them into different elements 


---
## Mechanics

- ### In the target class, create Funcs for all the public Funcs of the src class 
  - These Funcs should just delegate to the src class

- ### Change all references to src class methods 
  - so they use the target class's delegators instead
  - Test after each change 

- ### Move all the Funcs and data from the src class into the target
  - testing after each move, until the source class is empty 

- ### Delete the source class 

- ### Test