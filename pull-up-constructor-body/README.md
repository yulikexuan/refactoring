# Pull Up Constructor Body


### [Constructor Body](https://memberservices.informit.com/my_account/webedition/9780135425664/html/pullupconstructorbody.html)


---

## Motivation

### Constructors are Tricky Things

### If this Refactoring Starts Getting Messy
- Reaching for [Replace Constructor with Factory Function](https://memberservices.informit.com/my_account/webedition/9780135425664/html/replaceconstructorwithfactoryfunction.html)


--- 
## Mechanics

- ### Define a Superclass Constructor, if One does NOT already Exist
  - Ensure it's called by subclass constructors

- ### Use [Slide Statements](https://memberservices.informit.com/my_account/webedition/9780135425664/html/slidestatements.html) to Move Any Common Statements to 
  - just after the super call

- ### Remove the Common Code from Each Subclass and Put It in the Superclass
  - Add to the Super Call Any Constructor Parameters Referenced in the Common Code

- ### Test

- ### If there is Any Common Code that CANNOT Move to the Start of the Constructor
  - use [Extract Function](https://memberservices.informit.com/my_account/webedition/9780135425664/html/extractfunction.html) followed by [Pull Up Method](https://memberservices.informit.com/my_account/webedition/9780135425664/html/pullupmethod.html)