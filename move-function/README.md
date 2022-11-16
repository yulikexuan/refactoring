# Move Function


## Resources

- [Move Function](https://memberservices.informit.com/my_account/webedition/9780135425664/html/movefunction.html)



---
## Motivation

### The Heart of a Good Software Design is its Modularity 
- which is the Ability to Make Most Modifications to an App while only having to 
  - Understand a Small Part of the App
- Ensure that Related Software Elements are Grouped Together 
  - and the Links Between Them are Easy to Find and Understand

### To Reflect the Growing Understanding of the App
- Some Elements should be Moved Around

### One of the Most Straightforward Reasons to Move A Function 
- When Referencing Elements In Other Contexts More Than the One It Currently Resides In
- Moving it Together with Those Elements often Improves Encapsulation 
  - Allowing other Parts of the Software to be Less Dependent on the Details of this Module 



---
## Mechanics

### Examine all the App Elements used by the Chosen Func in its Current Context
- Consider whether they should move too
  - If having one, move it first 
  - Moving a clusters of functions begins with the one that has the least dependency 
    - on the others in the group 
  - If a High-Level Func is the only caller of sub-funcs 
    - Inline those Funcs into the High-Level Func
    - Move
    - Re-Extract at the Destination 

### Check if the Chosen Func is a Polymorphic Method
- take account of super-class and subclass declarations

### Copy the Func to the Target Context
- Adjust it to fit in its new home
- If the Func Body uses Elements in the Source Context 
  - Either Pass those Elements as Parameters
  - or pass a reference to that source context 
- Moving a Func often means coming up with a Different Name 
  - that works Better in the new context

### Perform Static Analysis

### Figure out how to Reference the Target Func from the Source Context

### Turn the Source Func into a Delegating Func

### Test

### Consider Inline Function on the Source Func
- The Source Func can stay indefinitely as a Delegating Func 
  - But if its callers can just as easily reach the target directly
    - Remove the middle man