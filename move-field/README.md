# Move Field


## Resources

- [Move Field](https://memberservices.informit.com/my_account/webedition/9780135425664/html/movefield.html)


---
## Motivation

### Behavior Code will be Simple and Straightforward if 
- Having a Good Set of Data Structures that Match the Problem

### Poor Data Structures Lead to Lots of Code Dealing with the Poor Data
- Messier code is Harder to Understand
- The Data Structures Obscure What the Program is Doing

### leaving Data Structures with their Blemishes (瑕疵)
- Those Blemishes will Confuse Dev's Thinking and Complicate code far into the Future

### Pieces of Data that are always Passed To Functions Together 
- are usually best put in a single record in order to clarify their relationship

### If a Change in One Record Causes a Field in Another Record to Change too 
- that's a sign of a field in the wrong place

### If Having to Update the Same Field in Multiple Structures 
- That's a Sign that it should Move to Another Place where it only needs to be Updated Once



---
## Mechanics

- ### Ensure the Source Field is Encapsulated

- ### Test 

- ### Create a Field (and accessors) in the Target

- ### Run Static Checks

- ### Ensure there is a Reference from the Source Object to the Target Object

- ### Adjust Accessors to Use the Target Field

- ### Test

- ### Remove the source field

- ### Test