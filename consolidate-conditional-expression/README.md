# Consolidate Conditional Expression

> consolidate: to join things together into one; to be joined into one

## Resources

- [Consolidate Conditional Expression](https://memberservices.informit.com/my_account/webedition/9780135425664/html/consolidateconditionalexpression.html)


---
## Motivation

### A Series of Conditional Checks where Each Check is Different 
- YET the Resulting Action Is The Same
- Use ``` && ``` and ``` || ``` Operators to Consolidate Them into a Single Conditional Check with a Single Result

### Consolidating the Conditional Code is IMPORTANT for Two Reasons

1. #### Making a Single Check Combining Other Checks -- More Clearer
2. #### Preparing for [Extract Function](https://memberservices.informit.com/my_account/webedition/9780135425664/html/extractfunction.html)
   - #### Extracting a Condition Replaces a Statement of WHAT It's Doing with WHY It's Doing It 

> set somebody up: to make somebody healthier, stronger, more lively, etc.

### Before Doing this Refactoring
- Check if they are truly Independent Checks which should not be thought of as a Single Check 


---
## Mechanics

- ### Ensure that NONE of the Conditionals Have Any Side Effects
  - If any do, use [Separate Query from Modifier](https://memberservices.informit.com/my_account/webedition/9780135425664/html/separatequeryfrommodifier.html) ON Them First

- ### Take TWO of the Conditional Statements and Combine their Conditions 
  - Using a Logical Operator
  - Sequences Combine with ``` || ```, Nested ``` if ``` Statements Combine With ``` && ```

- ### Test

- ### Repeat Combining Conditionals until they are All In One Single Condition

- ### Consider using [Extract Function](https://memberservices.informit.com/my_account/webedition/9780135425664/html/extractfunction.html) on the resulting condition

