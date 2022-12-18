# Replace Query with Parameter


## Resources

- [Replace Query with Parameter](https://memberservices.informit.com/my_account/webedition/9780135425664/html/replacequerywithparameter.html)
  - Inverse Of [Replace Parameter with Query](https://memberservices.informit.com/my_account/webedition/9780135425664/html/replaceparameterwithquery.html)


---
## Motivation

### In a Func Body, there are References to Something in the Func's Scope
- #### It might be a Ref to a Global Var
- #### or to an Element in the Same Module which should be Moved Away
- In this scenario, the Ref can be Replaced with a Param
  - Shifting the Responsibility of Resolving the Ref to the Caller of the Func

### This is Due to the ___Wish to Alter the Dependency Relationship___ in code
- To Make the Target Func no Longer Dependent on the Referenced Element

### It's always Easier to Reason About A Func which is Referential Transparency
- The Func Always Give the Same Result when Called with Same Parameter Values
- A Common Pattern to Have Modules Consisting of Pure Functions 
  - Make Funcs be Wrapped by Logic 
    - that Handles the I/O and Other Variable Elements of a Program
- Replace Query with Parameter can Purify Parts of A Program
  - Making those Parts Easier to test and Reason About

### Replace Query with Parameter is Moving a Query to a Param
- Forcing the Caller to Figure Out How to Provide the Value
- Which Complicates Life for Callers of the Func 
- and our Other Goal is to Make Interface-Consumers' Life Easier 
  - by Designing the Interface Well

### This Boils Down to Allocation of Responsibility Around the Program 
- That's a Decision that's Neither Easy Nor Immutable 
  - which is Why this Refactoring (and Its Inverse) is One 
    - that Devs Need to Be Very Familiar With

### Replace Query with Parameter can Help Make a Class Immutable
- Because Removing Query from Func could Cause One or More Instance Fields be Removed


---
## Mechanics

- ### Use [Extract Variable](https://memberservices.informit.com/my_account/webedition/9780135425664/html/extractvariable.html) on the Query Code 
  - to Separate it From the Rest of the Function Body


- ### Apply [Extract Function](https://memberservices.informit.com/my_account/webedition/9780135425664/html/extractfunction.html) to the Body Code that is NOT the Call to the Query
  - Give the new function an easily searchable name, for later renaming

- ### Use [Inline Variable](https://memberservices.informit.com/my_account/webedition/9780135425664/html/inlinevariable.html) to Get Rid of the Variable You Just Created

- ### Apply [Inline Function](https://memberservices.informit.com/my_account/webedition/9780135425664/html/inlinefunction.html) to the original function.

- ### Rename the New Function to that of the Original

