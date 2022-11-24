# Split Loop


## Resources

- [Split Loop](https://memberservices.informit.com/my_account/webedition/9780135425664/html/splitloop.html)


---
## Motivation

### If Doing Two Different Things in One single Loop
- #### Have to Understand Both of the Two Things Whenever Need to Modify that Loop

### If Doing One Single Thing in One Single Loop
- #### Ensure only Need to Understand the Behavior which Should Be Modified

### Splitting a Loop can also Make It Easier to Use
- #### A loop that Calculates a Single Value can Just Return that Value
- #### However, Loops that do Many Things 
  - need to Return Structures or Populate Local Variables

### The Loop could be executed Twice
-  The actual iteration through even a large list is rarely a bottleneck

### Splitting the Loops often Enables Other, More Powerful, Optimizations


---
## Mechanics

- ### Copy the Loop

- ### Identify and Eliminate Duplicate Side Effects

- ### Test

- ### When Done, Consider Extract Function on Each Loop