# Extract Superclass


## Resources

- [Extract Variable](https://memberservices.informit.com/my_account/webedition/9780135425664/html/extractvariable.html)


---
## Motivation

### More Than One Classes Doing Similar Things
- #### Pull Their Similarities Together into a Superclass
- #### Use [Pull Up Field](https://memberservices.informit.com/my_account/webedition/9780135425664/html/pullupfield.html) to Move Common Data into the Superclass
- #### Use [Pull Up Method](https://memberservices.informit.com/my_account/webedition/9780135425664/html/pullupmethod.html) to Move the Common Behavior

### Find Common Elements which can be Pulled Together

### Extract Superclass can Lead to [Replace Superclass with Delegate](https://memberservices.informit.com/my_account/webedition/9780135425664/html/replacesuperclasswithdelegate.html)


---
## Mechanics

- ### Create an Empty Superclass
  - #### Make the Original Classes its Subclasses

- ### Test

- ### Move Common Elements to the Superclass
  - #### One by One Use
    - #### [Pull Up Constructor Body](https://memberservices.informit.com/my_account/webedition/9780135425664/html/pullupconstructorbody.html)
    - #### [Pull Up Method](https://memberservices.informit.com/my_account/webedition/9780135425664/html/pullupmethod.html)
    - #### [Pull Up Field](https://memberservices.informit.com/my_account/webedition/9780135425664/html/pullupfield.html)

- ### Examine Remaining Methods on the Subclasses to See 
  - #### If There Are Common Parts
  - #### If so, use [Extract Function](https://memberservices.informit.com/my_account/webedition/9780135425664/html/extractfunction.html) followed by [Pull Up Method]https://memberservices.informit.com/my_account/webedition/9780135425664/html/pullupmethod.html)

- ### Check Clients of the Original Classes
  - #### Consider Adjusting them to Use the Superclass Interface