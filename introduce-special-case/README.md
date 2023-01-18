# Introduce Special Case

> Formerly: Introduce Null Object

## Resources

- [Introduce Special Case](https://memberservices.informit.com/my_account/webedition/9780135425664/html/introducespecialcase.html)

---

## Motivation

### A Widespread Testing for a Special Case, Plus a Common Response 
- ### Is What Tells that It is Time FOR a Special Case Object

### ___Special Case___ is A Common Case of Duplicated Code
- #### Many Users of a Data Structure Check a Specific Value
- #### and Then Most of Them Do the Same Thing

### If Many Parts of the Code Base Having the Same Reaction to a Particular Value 
- #### Bring that Reaction Into a Single Place

### A Good Mechanism for this is the Special Case Pattern 
- where Creating a Special-Case Element that Captures All The Common Behavior
- This Allows to Replace Most of the Special-CCase Checks with Simple Calls

### A Special Case can Manifest Itself in Several Ways
- If all Needs to Do with the Object is Reading Data
  - Supply a Literal Object with All the Values Needed
- If Needing More Behavior Than Simple Values 
  - Create a Special Object with Methods for All the Common Behavior
- The SPECIAL_CASE Object can be Returned by an Encapsulating Class 
  - or Inserted Into a Data Structure with A Transform

### Null Object is a ___Special Case___ of Special Case


---
## Mechanics

### Begin with a Container Data Structure (or CLASS) 
  - that Contains a Property which is the Subject of the Refactoring
  - Clients of the Container Compare the Subject Property of the Container to 
    a SPECIAL_CASE Value
  - We wish to Replace the SPECIAL_CASE Value of the Subject with a SPECIAL CASE CLASS 
    - or Data Structure

- ### Add a Special Case Check Property to the Subject, 
  - Returning False
- ### Create a Special Case Object with only the Special Case Check Property, 
  - Returning True
- ### Apply [Extract Function](https://memberservices.informit.com/my_account/webedition/9780135425664/html/extractfunction.html) to the Special Case Comparison Code 
  - Ensure that all clients use the new function instead of directly comparing it
- ### Introduce the New Special Case Subject into the Code
  - either by returning it from a function call or by applying a transform function
- ### Change the Body of the Special Case Comparison Function 
  - so that it uses the Special Case Check Property
- ### Test
- ### Use [Combine Functions](https://memberservices.informit.com/my_account/webedition/9780135425664/html/combinefunctionsintoclass.html) into Class 
  - or [Combine Functions into Transform](https://memberservices.informit.com/my_account/webedition/9780135425664/html/combinefunctionsintotransform.html) 
  - to Move all the Common Special Case Behavior into the New Element
  - Since the Special Case Class usually Returns Fixed Values to Simple Requests
    - these may be handled by making the special case a literal record
- ### Use [Inline Function](https://memberservices.informit.com/my_account/webedition/9780135425664/html/inlinefunction.html) on the Special Case Comparison Function 
  - for the places where it's still needed