# Separate Query from Modifier


## Resources

- [Separate Query from Modifier](https://memberservices.informit.com/my_account/webedition/9780135425664/html/separatequeryfrommodifier.html)


---
## Motivation

### Side Effect Free Func
- Can be called many times
- Can be moved to other places in a calling Func
- Easier to test
- Has a lot less to worry about

### Always Clearly Signal the Difference between Funcs 
- with Side Effects and Those Without

### A Good Rule to Follow
> Any FUNC that Returns a Value Should NOT Have Observable Side Effects

### Observable Side Effects
- Internal cache variables change but they are Not Observable

### Always Try to Separate the Query from the Modifier


---
## Mechanics

- ### Copy the Func, Name It as a Query
  - Look into the function to see what is returned
  - If the query is used to Populate a Variable
    - the variable's name should provide a good clue

- ### Remove any Side Effects from the New Query Function

- ### Run Static Checks

- ### Find Each Call of the Original Method
  - If that Call Uses the Return Value, 
    - Replace the Original Call with A call to the New Query
    - and insert a call to the original method below it
    - Test after Each Change

- ### Remove Return Values from Original

- ### Test