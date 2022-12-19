# Replace Constructor with Factory Function


## Resources

- [Replace Constructor with Factory Function](https://memberservices.informit.com/my_account/webedition/9780135425664/html/replaceconstructorwithfactoryfunction.html)
  - Formerly: Replace Constructor with Factory Method


---
## Motivation

### A Java Constructor Must Return An Instance of the Class It Was Called With
- which means we CANNOT Replace it with a Subclass or Proxy 
  - Depending on the Environment or Parameters

### Constructor Naming is Fixed, which Makes it Impossible for Devs 
- to Use a Name that is Clearer Than the Default

### Constructors often Require a Special Operator to Invoke ``` new ```
- which Makes Them Difficult to Use in Contexts that Expect Normal Funcs

### A Factory Function Suffers from NO Such Limitations 
- It will likely Call the constructor As Part Of Its Implementation, 
  - but Devs can freely substitute something else


---
## Mechanics

- ### Create a Factory Func, its Body Being a Call to the Constructor

- ### Replace Each Call to the Constructor with a Call to the Factory Func

- ### Test after Each Change

- ### Limit the Constructor's Visibility As Much As Possible

