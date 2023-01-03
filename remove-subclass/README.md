# Remove Subclass


## Resources

- [Remove Subclass](https://memberservices.informit.com/my_account/webedition/9780135425664/html/removesubclass.html)
- Inverse of: [Replace Type Code with Subclasses](https://memberservices.informit.com/my_account/webedition/9780135425664/html/replacetypecodewithsubclasses.html)
- Formerly:	Replace Subclass with Fields

---
## Motivation

### Subclasses Support Variations in Data Structure & Polymorphic Behavior
- They are a good way to program by difference

### As a Software System Evolves, Subclasses Can Lose Their Value 
- as the Variations They Support are Moved to Other Places or Removed Altogether

### Sometimes, Subclasses are Added in Anticipation of Features that ...
- Never End Up Being Built
- End Up Being Built in a way that does NOT Need the Subclasses

### A Subclass that Does Too Little Incurs a Cost in Understanding
- that is No Longer Worthwhile
- When that time comes, it's best to remove the subclass
    - replacing it with a field on its superclass


---
## Mechanics

> Make All Knowledge of the Subclasses be Safely Encased Within the Superclass 
> and the Factory Function 

- ### Use [Replace Constructor with Factory Function](https://memberservices.informit.com/my_account/webedition/9780135425664/html/replaceconstructorwithfactoryfunction.html) on the Subclass Constructor
  - If the clients of the constructors use a data field to decide which subclass to create
    - put that decision logic into a superclass factory method

- ### If any Code Tests Against the Subclass's Types
  - use [Extract Function](https://memberservices.informit.com/my_account/webedition/9780135425664/html/extractfunction.html) on the type test
  - [Move Function](https://memberservices.informit.com/my_account/webedition/9780135425664/html/movefunction.html) to Move it to the Superclass 
  - Test After Each Change 

- ### Create a Field to Represent the Subclass Type

- ### Change the Methods that Refer to the Subclass to Use the New Type Field

- ### Delete the Subclass

- ### Test

- ### Often, this Refactoring is Used On a Group of Subclasses At Once
  - carry out the steps to encapsulate them 
  - add factory function 
  - move type tests
  - then, then individually fold them into the superclass