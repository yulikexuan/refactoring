# Replace Derived Variable with Query


## Resources

- [Replace Derived Variable with Query](https://memberservices.informit.com/my_account/webedition/9780135425664/html/replacederivedvariablewithquery.html)


---
## Motivation

### One of the Biggest Sources of Problems in Software is Mutable Data

### Advocate Minimizing the Scope of Mutable Data As Much As Possible

### Removing any Variables which could be Easily Calculated

### A Calculation often Makes it Clearer the Meaning of the Data

### A Calculation is Protected from Being Corrupted 
- when Failing to Update the Variable as the Source Data Changes


---
## Mechanics

- ### Identify All Points of Update for the Variable 
  - If necessary, use [Split Variable](https://memberservices.informit.com/my_account/webedition/9780135425664/html/splitvariable.html) to Separate Each Point of Update

- ### Create a Function that Calculates the Value of the Variable

- ### Use [Introduce Assertion](https://memberservices.informit.com/my_account/webedition/9780135425664/html/introduceassertion.html) to Assert that the Variable and the Calculation 
  - are Giving the Same Result Whenever the Variable is Used
  - If necessary, use [Encapsulate Variable](https://memberservices.informit.com/my_account/webedition/9780135425664/html/encapsulatevariable.html) to provide a home for the assertion

- ### Test

- ### Replace any Reader of the Variable with a Call to the New Function

- ### Test

- Apply [Remove Dead Code](https://memberservices.informit.com/my_account/webedition/9780135425664/html/removedeadcode.html) to the Declaration and Updates to the Variable
