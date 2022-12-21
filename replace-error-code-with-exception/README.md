# Replace Error Code with Exception

## Resources

- [Replace Error Code with Exception](https://memberservices.informit.com/my_account/webedition/9780135425664/html/replaceerrorcodewithexception.html)


---
## Motivation

### Exceptions provide a separate language mechanism for error handling

### Exceptions should only be used for strictly exceptional behavior 
- something that indicates an error out of range of the usual behavior of the program

### A Good Rule of Thumb is to Consider Whether the Program Would Still Work 
- if I Replace Throwing an Exception with Terminating the Program
  - If NOT, that's a sign that I shouldn't be using an exception
    - instead I should make the error detection and handling part of the regular 
      flow of the program

---
## Mechanics

- ### Create an exception handler higher up the call chain to handle the exception
  - This handler should initially just rethrow all exceptions
  - If there already is a handler that does the right thing 
    - extend it to cover the new part of the call chain

- ### Test

- ### Choose an Appropriate Marker to Distinguish the Exceptions 
  - replacing the error code from other exceptions

- ### Test

- ### Modify the Catch Clause to Perform the Error Action 
  - when it's called with the correct kind of exception and rethrow otherwise

- ### For each place that returns an error code
  - Replace it with Throwing the New Exception 
  - Test after each change

- ### When all the Points that Return Error Codes Have Been Replaced 
  - remove any code that passes the error codes up the call stack

- ### Test

