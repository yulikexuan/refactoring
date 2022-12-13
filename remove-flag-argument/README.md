# Remove Flag Argument 


### [Remove Flag Argument](https://memberservices.informit.com/my_account/webedition/9780135425664/html/removeflagargument.html)

### Formerly : Replace Parameter with Explicit Methods


---

## Motivation

### What is Flag Argument?

- #### A Flag Argument is a Func Argument that the Caller Uses to Indicate 
  - #### Which Logic the Called Func Should Execute
  - #### Flag Arguments can also Come As Enums
  - For example: 
    ``` 
    function bookConcert(aCustomer, isPremium) {
        if (isPremium) {
            // logic for premium booking
        } else {
            // logic for regular booking
       }
    }
    // Using Enum
    bookConcert(aCustomer, CustomerType.PREMIUM);
    ```

- ### The Disadvantage of Flag Argument
  - Flag Arguments Complicate the Process of Understanding 
    - what Func Calls are Available
    - and How to Call Them

- ### The First Route into an API is usually the List of Available Funcs
  - Flag Arguments Hide the Differences in the Func Calls that are Available
  - Once A Dev Select a Func, the Dev have to Figure Out 
    - what Values are Available for the Flag Arguments

- ### Boolean Flags are Even Worse since 
  - they ___DO DOT Convey Their Meaning___ to the Reader
  - In a Func Call, Devs CANNOT Figure Out What True Means
    - It's Clearer to Provide an Explicit Func for the Task Devs Want To Do
      ``` 
      premiumBookConcert(aCustomer);
      ```

- ### Not All Arguments like this Are Flag Arguments
  - To be a Flag Argument, the Callers must be Setting the Boolean Value to a Literal Value
    - Not Data that's Flowing Through the Program
    - The Implementation Function Must Be Using the Argument to Influence its Control Flow
      - Not As Data that it Passes to Further Functions

- ### Removing Flag Arguments Does NOT just Make the Code Clearer 
  - It also Helps the Tooling 
  - Code Analysis Tools can now more Easily See the Difference Between 
    - Calling the ``` Premium ``` logic and Calling ``` Regular Logic ```

- ### Flag Arguments can Have a Place 
  - if There's More Than One of TThem in the Func
    - since Otherwise Devs would Need Explicit Funcs for Every Combination of Their Values
  - But that's Also a Signal of a Func Doing Too Much
    - and Devs should Look For a Way to Create Simpler Functions that 
      - they can Compose for This Logic


--- 
## Mechanics

- ### Create an Explicit Func for Each Value of the Parameter
  - If the Main Function has a Clear Dispatch Conditional
    - Use [Decompose Conditional](https://memberservices.informit.com/my_account/webedition/9780135425664/html/decomposeconditional.html) to Create the Explicit Func
    - Otherwise, Create Wrapping Func

- ### For Each Caller that Uses a Literal Value for the Parameter 
  - Replace It with a Call to the Explicit Func



