# Replace Type Code with Subclasses


## Resources

- [Replace Type Code with Subclasses](https://memberservices.informit.com/my_account/webedition/9780135425664/html/replacetypecodewithsubclasses.html)
- Inverse Of: [Remove Subclass](https://memberservices.informit.com/my_account/webedition/9780135425664/html/removesubclass.html)
- Subsumes: Replace Type Code with State / Strategy
- Subsumes: Extract Subclass

---
## Motivation

### Software Systems often Represent Different Kinds of a Similar Thing

### Two Things Enticing About Subclasses
- #### Use Polymorphism to Handle Conditional Logic
- #### Have Fields or Methods that are Only Valid for Particular Values of a Type 

### The Important Consideration before This Refactoring
- #### Whether to Apply it Directly to the Class, or to the Type Code?


---
## Mechanics

- ### Self-Encapsulate the Type Code Field

- ### Pick One Type Code Value
  - Create a Subclass for that Type Code
  - Override the Type Code Getter to Return the Literal Type Code Value

- ### Create Selector Logic to Map 
  - From the Type Code Parameter to the New Subclass
  - With Direct Inheritance, Use [Replace Constructor with Factory Function](https://memberservices.informit.com/my_account/webedition/9780135425664/html/replaceconstructorwithfactoryfunction.html) 
    - and Put the Selector Logic in the Factory
  - With indirect inheritance, the selector logic may stay in the constructor

- ### Test

- ### Repeat Creating the Subclass and Adding to the Selector Logic 
  - for Each Type Code Value
  - Test After Each Change

- ### Remove the Type Code Field

- ### Test

- ### Use [Push Down Method](https://memberservices.informit.com/my_account/webedition/9780135425664/html/pushdownmethod.html) and [Replace Conditional with Polymorphism](https://memberservices.informit.com/my_account/webedition/9780135425664/html/replaceconditionalwithpolymorphism.html) 
  - on Any Methods that Use the Type Code Accessors
  - Remove the Type Code Accessor after all Being Replaced