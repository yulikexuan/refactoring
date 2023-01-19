# The Basic Guide of Refactoring

## Phase I 

- Breaking Down Complicated Chunks Into Small Pieces

- ## Step 1. A Solid Suite of Tests

- ## Step 2. Decomposing the Long Func
  - ### Try to Identify Points that Separate Different Parts of the Overall Behavior
  - ### The Conclusion is from Finding out the Core & Understanding the Core
  - ### Persist the Conclusion of the Core Part 
    - by Moving the Core Part from the Conclusion (the Understanding) into the Code Itself
      - [Extract Function](../extract-function/README.md) - Turn that Core Chunk of Code into Its Own Func, Naming It
    - after, the Code Will Tell Me what It is Doing when I Come Back Later
  - ### Test
    - > Refactoring changes the programs in small steps, so if you make a mistake, 
      > - it is easy to find where the bug is
      > - avoid the mess

- ## Step 3. Review the Extracted Func
  - Refactoring for Func Name, Param List, and Variables
  - ### Always Name the Return Value from a Func "result"
  - ### Rename Parameters and them Easy to Understand
    - > Any fool can write code that a computer can understand; good programmers write code that humans can understand.
    - Never be Afraid to Change Names to Improve Clarity
  - ### Check the Param List of the Func to see if there is Any Can Be Removed
    - If So, Remove it by Using 
      - [Inline Func](../inline-function/README.md)
      - [Change Func Declaration](../change-function-declaration/README.md)
    - Test
  - ### Or, Remove Local Variables First, then Do [Extract Function](../extract-function/README.md)
    - The Great Benefit of Removing Local Variables is that 
      - it makes it much Easier to Do Extractions
        -  since There is Less Local Scope to Deal With
  - ### Check the Code where the New Func is Called
    - to see, if It's Possible to Remove More Variables who Hold the Value from the new Func-Call

- ## Step 4. Removing More Local Variables
  - ### [Extract Function](../extract-function/README.md)
  - ### [Inline Func](../inline-function/README.md)
  - ### [Change Func Declaration](../change-function-declaration/README.md)

- ## Step 5. [Split Loop](../split-loop/README.md) to Isolate the Funcs in the Loop
  - ### To move the declaration of the variable next to the loop 
    - [Slide Statements](https://memberservices.informit.com/my_account/webedition/9780135425664/html/slidestatements.html)
  - ### Apply [Extract Function](../extract-function/README.md) for Each Separate Loop
  - ### Then Apply [Inline Variable](https://memberservices.informit.com/my_account/webedition/9780135425664/html/inlinevariable.html)
    - to Remove the Variable which Stores the Result of the new Func

## Phase II Move New Added Funcs to Domain Models


## Phase III Splitting the Phases of Different Functionalities
  - ### Start a [Split Phase](../split-phase/README.md) by Applying [Extract Function](../extract-function/README.md) 
    - to the Code that Makes up the Second Phase
    - For Example, Separate the Calculation and Presentation Code

## Phase IV Introducing a Polymorphic Calculator for the Calculation Logic Code