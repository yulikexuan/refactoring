# Combine Functions into Class

## Resources

- [Combine Functions into Class](https://memberservices.informit.com/my_account/webedition/9780135425664/html/combinefunctionsintoclass.html)


---
## Motivation

### Try to Form a new Class if

- #### Seeing a Group Of Funcs that Operate Closely Together on a Common Body Of Data

  - The Common Data is usually Passed as Args to the Function Call

- #### Using a Class Makes the Common Environment (which these functions share) More Explicit

- #### Allows Devs to Simplify Function Calls Inside The Object
  - by Removing Many Of The Arguments

- #### Allows Devs to Provide a Reference to Pass Such An Object to Other Parts of the System

- #### Provides a Good Opportunity to Identify Other bits of Computation 
  - and Refactor Them into Methods on the New Class

- #### Allows Clients to Mutate the Core Data of the Object 
  - and the Derivations Remain Consistent


---
## Mechanics

### Create a Class or Record to Group Common Data Together

### Move Each Func (Using The Common Data) into the New Class

### Replace Argument List of all Moved Funcs with One Single Arg of the New Class

