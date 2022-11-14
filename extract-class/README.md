# Extract Class


## Resources

- [Extract Class](https://memberservices.informit.com/my_account/webedition/9780135425664/html/extractclass.html)


---
## Motivation

### In Practice, Classes Grow and Become too Complicated, Crispy, and Fragile

### Where to Split a Big Class?
- Sign 1: a subset of the data and a subset of the methods seem to go together
- Sign 2: subsets of data that usually change together
- Sign 3: subsets of data that are particularly dependent on each other

### How to Test the Signs of Splitting 
- What would happen if removing a piece of data or a method
- What other fields and methods would become nonsense 

---
## Mechanics

### Decide how to split the responsibilities of the class

### Create a new child class to express the split-off (分離的) responsibilities
- Rename the parent class 
  - if the responsibilities of the original parent class no longer match its name

### Create an instance of the child class when constructing the parent 
- add a link from parent to child

### Use [Move Field](https://memberservices.informit.com/my_account/webedition/9780135425664/html/movefield.html) on each field you wish to move

### Use [Move Function](https://memberservices.informit.com/my_account/webedition/9780135425664/html/movefunction.html) to move methods to the new child
- Start with lower-level methods (those being called rather than calling)

### Review the interfaces of both classes
- remove unneeded methods 
- change names to better fit the new circumstances

### Decide whether to expose the new child
- If so, consider applying [Change Reference to Value](https://memberservices.informit.com/my_account/webedition/9780135425664/html/changereferencetovalue.html) to the child class
