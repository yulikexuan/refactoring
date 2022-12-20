# Replace Command with Function


## Resources

- [Replace Command with Function](https://memberservices.informit.com/my_account/webedition/9780135425664/html/replacecommandwithfunction.html)
- Inverse Of [Replace Function with Command](https://memberservices.informit.com/my_account/webedition/9780135425664/html/replacefunctionwithcommand.html)


---
## Motivation

### Command Objects Provide a Powerful Mechanism 
- #### for Handling Complex Computations
- #### They can easily be Broken Down Into Separate Methods 
  - Sharing Common State Through the Fields
- #### They can be Invoked Via Different Methods for Different Effects
- #### They can Have their Data Built Up in Stages

### But the Power of Command Objects Comes at a Cost
- #### Most of the Time, a Single Func is Desired, other than Using Command Obj
  - to avoid using a complex command with more trouble 


---
## Mechanics

- ### Apply [Extract Function](https://memberservices.informit.com/my_account/webedition/9780135425664/html/extractfunction.html) to the Creation of the Command 
  - and the Call to the Command's Execution Method

- ### For Each Method Called by the Command's Execution Method, 
  - Apply [Inline Function](https://memberservices.informit.com/my_account/webedition/9780135425664/html/inlinefunction.html)
  - If the Supporting Function Returns a Value, 
    - use [Extract Variable](https://memberservices.informit.com/my_account/webedition/9780135425664/html/extractvariable.html) on the Call First and then Inline Function

- ### Use Change Function Declaration 
  - to Put All the Parameters of the Constructor into the Command's Execution Method instead

- ### For Each Field, Alter the References in the Command's Execution Method 
  - to use the Parameter instead
    - Test After Each Change

- ### Inline the Constructor Call and Command's Execution Method Call 
  - into the Caller

- ### Test

- ### Apply Remove Dead Code to the Command Class

