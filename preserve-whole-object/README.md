# Preserve Whole Object


### [Preserve Whole Object](https://memberservices.informit.com/my_account/webedition/9780135425664/html/preservewholeobject.html)


---

## Motivation

### Code that Derives a Couple of Values from a Record 
- and then Passes These Values into a Func

### If more Data Required in the Future, the Method Signature should be Changed
- #### This Increase the Size of the Param List of the Method
- #### Make the Func Call very Difficult to Understand

### If Many Functions are Called with the Parts
- They often Duplicate the Logic that Manipulates these Parts—Logic 
  - They can often be Moved To The Whole 

### If the Param Object and Func Callers are in Different Modules
- ### Normally, do not do this refactoring

### Pulling Several Values from an Object to Do Some Logic on Them Alone 
- This is a ___Smell___
- This is a Signal that this Logic Should Be Moved into the Whole Itself

### This Refactoring is very Common after Finishing [Introduce Parameter Object](https://memberservices.informit.com/my_account/webedition/9780135425664/html/introduceparameterobject.html)
- as I Hunt Down Any Occurrences of the Original Data Clump to Replace Them with the New Object

### If Several Bits of Code only Use the Same Subset of an Object's Features
- then that may Indicate a Good Opportunity for [Extract Class](https://memberservices.informit.com/my_account/webedition/9780135425664/html/extractclass.html)

### One Case that Many People Miss is when an Object Calls Another Object 
- with Several of Its Own Data Values
- If I see this, replace those values wit ``` this ```


--- 
## Mechanics

- ### Create an Empty Function with the Desired Object Parameter
  - Give the function an easily searchable name so it can be replaced at the end

- ### Fill the Body of the New Function with a Call to the Old Function
  - Mapping from the New Parameters to the Old Ones

- ### Test

- ### Adjust Each Caller to Use the New Function
  - Testing after Each Change
  - This may mean that some code that derives the parameter isn't needed
    - so can fall to Remove Dead Code

- ### Once All Original Callers Have Been Changed 
  - Ue Inline Function on the Original Function

- ### Change the Name of the New Function and all its Callers






