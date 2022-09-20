# Extract Variable

## Resources

- [Extract Variable](https://memberservices.informit.com/my_account/webedition/9780135425664/html/extractvariable.html)


---
## Motivation

### Expressions can become very Complex and Hard to Read 

- #### Local Variables may help Break the Expression Down into Something More Manageable 

- #### By naming a part of a more complex piece of logic
  - This allows Devs to Better Understand the Purpose of What's Happening

- #### Such Variables are also Handy for Debugging 
  - since they provide an easy hook for a debugger or print statement to capture 

### Extract Variable Means to Add A Name To An Expression

- #### Also think about the context of that name


---
## Mechanics

- ### Ensure the Expression to Extract Does Not Have Side Effects

- ### Declare an Immutable Variable being Set to A Copy of the Expression

- ### Replace the Original Expression with the New Variable

- ### Test


---
## [Inline Variable](https://memberservices.informit.com/my_account/webedition/9780135425664/html/inlinevariable.html)

### Motivation

- #### Variable name for expression doesn't really communicate more than the expression itself
- #### A variable gets in the way of refactoring the neighboring code
