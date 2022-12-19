# Replace Function with Command


## Resources

- [Replace Function with Command](https://memberservices.informit.com/my_account/webedition/9780135425664/html/replacefunctionwithcommand.html)
- Inverse Of [Replace Command with Function](https://memberservices.informit.com/my_account/webedition/9780135425664/html/replacecommandwithfunction.html)
- Formerly: Replace Method with Method Object


---
## Motivation

### Sometimes, It's Useful to Encapsulate a Func into Its Own Object
- Command Object or Command
  - Mostly, it's Built Around a Single Method
  - This Method's Request and Execution is the Purpose of the Command Object 

### A Command Offers a Greater Flexibility for txhe Control and Expression of a Func 
- than the Plain Func Mechanism

### Commands can Have Complimentary Operations, such as ``` undo ```

### Devs can Provide Methods to Build Up Their Parameters 
- to Support a Richer Lifecycle

### Command can be Customized by Using Inheritance and Hooks

### Very Useful if a Language does NOT Support First-Class Funcs

### The Complex Method can be Broken Down with other Methods and Fields
- Those other Methods and Fields can be Called Directly while Testing & Debugging

### Command Object Comes with a Price in Complexity
- Mostly, First-Class Func should be the First Choice

### Use Command Only If the Needed Facility Cannot Be Supported 
- by First-Class Func 

### Breaking Up a Complex Func is one of the Cases to use Command
- so Devs can Better Understand and Modify It
  - because all Func's Params can be Moved into the Command to be Instance Fields
  - Sections in the Original Complex Func can be Extracted into different new Methods


---
## Mechanics

- ### Create an Empty Class for the Func, and Name it Based on the Func

- ### Use [Move Func](https://memberservices.informit.com/my_account/webedition/9780135425664/html/movefunction.html) to Move The Func to the Empty Class
  - Keep the Original Func as a Forwarding Func until at least The End Of The Refactoring
  - Follow any convention the language has for naming commands

- ### Consider Making a Field for each Argument
  - and Move these Arguments to the Constructor

