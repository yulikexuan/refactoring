# Replace Nested Conditional with Guard Clauses


## Resources

- [Replace Nested Conditional with Guard Clauses](https://memberservices.informit.com/my_account/webedition/9780135425664/html/replacenestedconditionalwithguardclauses.html)


---
## Motivation

### Guard Clause

- #### Conditional Expressions come in Two Styles
  1. The First Style, Both Legs of the Conditional are Part of Normal Behavior
  2. The second style, One Leg is Normal and the Other Indicates An unusual Condition
- #### Two Different Conditional Styles have Different Intentions 
  - Those Different Intentions Should Come through in the Code
  - If Both are Part Of Normal Behavior 
    - Use a Condition with Both of an ``` if ``` and an ``` else ``` Leg
  - If One Condition is an Unusual Condition
    - Check the Condition and Return if it's True
    - This Kink of Check is ___Guard Clause___

### The Key Point of this Refactoring is EMPHASIS
  - The ``` if ``` Leg and the ``` else ``` Leg should have Equal Weight
    - The Legs are Equally Likely and Important
  - The ___Guard Clause___ Says 
    - This IS NOT the core to this Func, and If It Happens, Do Something and Get Out

### _Having only One Entry Point and One Exit Point From A Method_ ???
- ___One Exit Point___ is really NOT a Useful Rule
- CLARITY is the Key PRINCIPLE
  - If the Method is CLEARER with More Than ONE Exit Point
    - Use More Than ONE Exit Point; Otherwise Do Not


---
## Mechanics

- ### Select Outermost Condition that Needs to be Replaced 
  - Change it Into A Guard Clause

- ### Test

- ### Repeat as Needed

- ### If All The Guard Clauses Return The Same Result 
  - Use [Consolidate Conditional Expression](https://memberservices.informit.com/my_account/webedition/9780135425664/html/consolidateconditionalexpression.html)

