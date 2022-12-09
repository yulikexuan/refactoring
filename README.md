# Refactoring 


## [Chapter 1 - The First Refactoring Example](ch01-a-first-example/README.md)


## [Chapter 2 - Principles in Refactoring](doc/README_chap_2.md)


## [Chapter 3 - Bad Smells in Code](doc/README_chap_3.md) 


## [Chapter 4 - Building Tests](doc/README_chap_4.md)


---

## [Extract Function](extract-function/README.md)


## [Slide Statements](https://memberservices.informit.com/my_account/webedition/9780135425664/html/slidestatements.html)


## [Introduce Assertion](https://memberservices.informit.com/my_account/webedition/9780135425664/html/introduceassertion.html)
- ### Applying Assertions is a Valuable Form of Communication
- ### Assertions are also Handy for Debugging
  - Their Communication Value Means Devs are Inclined to Leave Them In 
    - once they have fixed the error they are chasing


--- 

## [Refactoring APIs](https://memberservices.informit.com/my_account/webedition/9780135425664/html/refactoring-apis.html)

- ### Modules and their Functions are the Building Blocks of our Software

- ### APIs are the Joints that we use to Plug Them Together

- ### A Good API Clearly Separates Any Functions 
  - that Update Data from those That Only Read Data

- ### Use [Separate Query from Modifier](https://memberservices.informit.com/my_account/webedition/9780135425664/html/separatequeryfrommodifier.html) to a Func apart
  - if this Func combines Updating Data & Reading Data Together

- ### Unify Functions that only Vary Due To A Value with [Parameterize Function](https://memberservices.informit.com/my_account/webedition/9780135425664/html/parameterizefunction.html)

- ### If some Parameters are really just a Signal of an Entirely Different Behavior 
  - Excise them with [Remove Flag Argument](https://memberservices.informit.com/my_account/webedition/9780135425664/html/removeflagargument.html)

- ### Prefer to Keep Data Structure Together with [Preserve Whole Object](https://memberservices.informit.com/my_account/webedition/9780135425664/html/preservewholeobject.html)

- ### [Replace Parameter with Query](https://memberservices.informit.com/my_account/webedition/9780135425664/html/replaceparameterwithquery.html) vs [Replace Query with Parameter](https://memberservices.informit.com/my_account/webedition/9780135425664/html/replacequerywithparameter.html)
  - Decide What Should Be Passed As A Parameter
  - Decide What can be Resolved by the Called Function

- ### A ``` class ``` is a Common Form of Module

- ### Prefer to Make Instance Objects As Immutable As Possible
  - Use [Remove Setting Method](https://memberservices.informit.com/my_account/webedition/9780135425664/html/removesettingmethod.html) whenever You Can

- ### When a Caller Asks For a New Object
  - Prefer to Use [Replace Constructor with Factory Function](https://memberservices.informit.com/my_account/webedition/9780135425664/html/replaceconstructorwithfactoryfunction.html)

- ### [Replace Function with Command](https://memberservices.informit.com/my_account/webedition/9780135425664/html/replacefunctionwithcommand.html) 
  - Turn a very complex Func into an object

- ### [Replace Command with Function](https://memberservices.informit.com/my_account/webedition/9780135425664/html/replacecommandwithfunction.html)
  - Turn a Simple object into to a Func
