# Split Variable


## Resources

- [Split Variable](https://memberservices.informit.com/my_account/webedition/9780135425664/html/splitvariable.html)


---
## Motivation

### Using a Variable for Two Different Things is very Confusing for the Reader
- If a VAR are Set More Than Once, it is a Sign that 
  - they have More Than One Responsibility Within the Method
- Any VAR with More Than One Responsibility should be Replaced With Multiple Variables
  - One For Each Responsibility


---
## Mechanics

- ### Change the Name of the VAR at its Declaration and First Assignment
  - Do Not Split Collecting VAR
    - Collecting VAR Form:  ``` i = i + something ``` 
    - A Collecting VAR is often Used for 
      - Calculating Sums
      - String Concatenation
      - Writing To a Stream
      - Adding To a Collection

- ### If Possible, Declare the new VAR as Immutable

- ### Change all References of the VAR up to its Second Assignment

- ### Test

- ### Repeat in Stages
  - at Each Stage Renaming the VAR At The Declaration
    - Changing References Until the Next Assignment
    - Until you Reach the Final Assignment 