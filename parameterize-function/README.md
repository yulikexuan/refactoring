# Parameterize Function 


## [Parameterize Function](https://memberservices.informit.com/my_account/webedition/9780135425664/html/parameterizefunction.html)


---

## Motivation

### Two Funcs Carrying Out very Similar Logic with Different Literal Values
- In order to Increases the Usefulness of The Func (use it elsewhere with different values)
  - Remove the Duplication by Using a Single Function with Parameters for the Different Values


--- 
## Mechanics

- ### Select One of the Similar Methods

- ### Use [Change Function Declaration](https://memberservices.informit.com/my_account/webedition/9780135425664/html/changefunctiondeclaration.html)
  - to add any literals that need to turn into parameters

- ### For Each Caller of the Func, Add the Literal Value

- ### Test

- ### Change the Body of the Func to Use the New Parameters
  - Test After Each Change

- ###  For Each Similar Func, Replace the Call with a Call to the Parameterized Func
  - Test after Each One
  - If the Original Parameterized Func does NOT Work for a Similar Function
    - Adjust It for the New Func Before Moving On to the Next

- ### When Parameterizing Some Related Funcs
  - The Approach is to Take One of the Funcs and Add Parameters to it
    - with an eye to the other cases
  - With Range-Oriented Things 
    - Usually the place to start is with the middle range