# Replace Exception with Pre-Check

## Resources

- [Replace Exception with Pre-Check](https://memberservices.informit.com/my_account/webedition/9780135425664/html/replaceexceptionwithprecheck.html)
- Formerly: Replace Exception with Test

---
## Motivation

### Exceptions can be Used to Excess, when they Cease to be Pleasurable

### Exceptions should be Used for Exceptional Behavior that is an Unexpected Error

### Provide a Test for the Caller to Use Instead of Throwing an Exception
- ### If the Caller can Reasonably Check the Condition before Calling the Operation


---
## Mechanics

- ### Add a Condition that Tests the Case that Triggers the Exception
  - Move the code from the catch block into one leg of this condition
  - Put the Remaining Try Block in the Other

- ### Put an Assertion into the Catch Block and Test

- ### Remove the Try Statement and Catch Block

- ### Test