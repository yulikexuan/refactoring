# Replace Parameter with Query


## Resources

- [Replace Parameter with Query](https://memberservices.informit.com/my_account/webedition/9780135425664/html/replaceparameterwithquery.html)
- Inverse Of [Replace Query with Parameter](https://memberservices.informit.com/my_account/webedition/9780135425664/html/replacequerywithparameter.html)
- Formerly: Replace Parameter with Method


---
## Motivation

### The Param List to a Func should Summarize the Points of Variability of the Func 
- Indicating the primary ways in which that function may behave differently

### The Func is Easier to Understand if the Param List is Short
- It's Good to Avoid any Duplication in the Param List

### If a Call Passes in a Value that the Func can just As Easily Determine For Itself (without the param)
- This is a Form of Duplication
- This Duplication unnecessarily Complicates the Caller which has to Determine 
  - the Value of a Param when it could be Freed From That Work

### The Limit on this is Suggested by the Phrase ___"Just As Easily"___

### By Removing the Param, Devs are Shifting the Responsibility for Determining 
- the Parameter Value

### When the Param is Present
- Determining its Value is the Caller's Responsibility
- otherwise, that Responsibility Shifts to the Func Body

### A Nice Habit is to Simplify Life for Callers 
- which Implies Moving Responsibility to the Func Body
- but ONLY IF that Responsibility is Appropriate There

### The Most Common Reason to Avoid Replace Parameter with Query
- It is if Removing the Param Adds an Unwanted Dependency to the Func Body
  - Forcing it to Access A Program Element that I'd Rather It Remained Ignorant Of
  - This may be anew dependency, or an existing one that I'd like to remove

### The Safest case for Replace Parameter with Query is When the Param Value 
- is Determined Merely By Querying Another Parameter in the Param List

### There's Rarely Any Point in Passing Two Parameters 
- IF One Can Be Determined From The Other

### Use Replace Parameter with Query when 
- Finishing Some Other Refactorings that Make a Param No Longer Needed


---
## Mechanics

- ### If Necessary, use [Extract Function](https://memberservices.informit.com/my_account/webedition/9780135425664/html/extractfunction.html) on the Calculation of the Param

- ### Replace References to the Param in the Func Body 
  - with References to the Expression that Yields the Param
  - Test After Each Change

- ### Use [Change Function Declaration](https://memberservices.informit.com/my_account/webedition/9780135425664/html/changefunctiondeclaration.html) to Remove the Param


