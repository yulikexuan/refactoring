# Combine Functions into Transform

## Resources

- [Combine Functions into Transform](https://memberservices.informit.com/my_account/webedition/9780135425664/html/combinefunctionsintotransform.html)


---
## Motivation

### Software often Involves Feeding Data into Programs 
- that calculate various derived information from it
- These derived values may be needed in several places 
- Those calculations are often repeated wherever the derived data is used

### Bring All of these Derivations Together 
- in order to Have a Consistent Place to Find and Update Them & Avoid any Duplicate Logic

### How to Do It?

- Create an Output Data Class which should be an Immutable
- Use a Data Transformation Function that Takes the Source Data as Input 
- Calculates all the Derivations 
- Putting Each Derived Value as a Field in the Output Data

### Using a Transform Func makes it EASY to Find and Use the Calculations


---
## Mechanics

### Create a Transformation Function that Takes the Origin Record as a Parameter 

### In the Trans Func, Transform the Origin Data into an Output Data Instance
- This will usually involve a deep copy of the Origin Data 
- It is often worthwhile to write a test to ensure the transform does not alter 
  the Origin Data

### Pick Some Logic and Move its Body into the Trans Func 
- to calculate and create a new field in the Output Data 
- change the client code to access the new field
- If the logic is complex, use Extract Function first 

### Test : Repeat for the other relevant Funcs

