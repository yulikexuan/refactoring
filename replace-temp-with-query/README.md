# Replace Temp with Query


## Resources

- [Replace Temp with Query](https://memberservices.informit.com/my_account/webedition/9780135425664/html/replacetempwithquery.html)


---
## Motivation

### Temporary Local Variables 
- Capture the value of some code in order to refer to it later in a function 
- Using a Temp Variable allows to Refer to the Value while 
  - explaining its meaning  
  - avoiding repeating the code that calculates it 
- But while Using a variable is Handy, it can often be Worthwhile to Use a Func Instead

### Turn Variable Calculation into a Single Function Can
  - Avoid Passing Parameters Around
  - Set up a stronger Boundary between the Extracted Logic and the Original Func
  - Help spot and avoid Awkward Dependencies and Side Effects
  - Avoid Duplicating the Calculation logic in similar Func

### Whenever Seeing Variables Calculated in the Same Way in Different Places
- Turn Them Into a Single Func

### Only some Temporary Variables are Suitable for [Replace Temp with Query](https://memberservices.informit.com/my_account/webedition/9780135425664/html/replacetempwithquery.html)

### This refactoring works best inside a class


---
## Mechanics

### Check that the Temp Variable is Determined Entirely before it's used 

### Check the Code that Calculates the Temp Variable does Not Yield a Different Value 
- whenever it is used 

### If the Temp Variable is Not Read Only, make it be Read Only

### Test 

### Extract the Assignment of the Temp Variable into a Function

### Ensure the Extracted Func is Free of Side Effects

### Test 

### Use Inline Variable to Remove the Temp Variable

