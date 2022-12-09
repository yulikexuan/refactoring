# Replace Conditional with Polymorphism


## Resources

- [Replace Control Flag with Break](https://memberservices.informit.com/my_account/webedition/9780135425664/html/replacecontrolflagwithbreak.html)



---
## Motivation

### Control Flags are Variables Used to Alter the Behavior of Some Code
- They are Computed In One Place, then Tested Inside Conditionals Elsewhere
- They are always to be SMELL
- They are Common in ___Convoluted Code___ 
- that ___is Ripe for___ Simplification with Some Refactoring

> Convoluted: Extremely Complicated & Difficult to Follow

> be Ripe: fully grown and ready to be eaten

### Control Flags Seem to Breed is Inside Loops
- They are used by people unfamiliar with break or continue statements
- or by those who try to avoid multiple return statements in a function

> Never agree with ___"shouldn't have more than one return statement in a function"___

> Once Knowing a Function is Done, use ``` return ``` to clearly say so


---
## Mechanics

- ### Consider Using [Extract Function](https://memberservices.informit.com/my_account/webedition/9780135425664/html/extractfunction.html) on the Code that Uses the Control Flag
  - If It Needs

- ### For Each Update of the Control Flag, Replace the Update 
  - with an Appropriate Control Statement
  - These are usually return, break, or continue
  - Test After Each Change

- ### Once all the Updates are Done, Remove The Control Flag

