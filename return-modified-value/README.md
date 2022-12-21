# Return Modified Value


## Resources

- [Return Modified Value](https://memberservices.informit.com/my_account/webedition/9780135425664/html/returnmodifiedvalue.html)


---
## Motivation

### The Worst In-Comprehensibility in code is Tracking how Data gets Modified

### Multiple Fragments Reading & Writing a Block of Data
- #### This is the Nastiest Coupling 
- #### It gets very Hard to Follow What the Flow of Modifications Means 
  - for the Flow of the Code

### Devs should Ensure any Updates of Data are Clearly Signaled
- #### So Devs can Easily See What Func is Doing What

### A Good Way to Provide This Signaling Is
- #### Make Funcs Update Variables by Returning a Value 
  - that the Caller Assigns to the Underlying Variable
- #### In this Way, Devs can Clearly See that a Var is being Updated
  - This is particularly Beneficial when the Var only Needs to be Determined Once

### This Works Best with Funcs having a Clear Purpose of Calculating a Single Value
- It is NOT Effective with Funcs who Needs to Coordinate Multiple Updates
  - It's Particularly Handy as a Preliminary Step Before [Move Function](https://memberservices.informit.com/my_account/webedition/9780135425664/html/movefunction.html)


---
## Mechanics

- ### Return the Modified Variable from the Func
  - also Assign It to that Variable in the Caller

- ### Test

- ### Declare the Returned Value within the Modifying Func

- ### Test

- ### Combine the Declaration with the Calculation
  - Make that variable be ``` final ```

- ### Test

- ### Rename the Var in the Sub-Func to Reflect its New Role

- ### Test

