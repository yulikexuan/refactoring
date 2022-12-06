# Replace Conditional with Polymorphism


## Resources

- [Replace Conditional with Polymorphism](https://memberservices.informit.com/my_account/webedition/9780135425664/html/replaceconditionalwithpolymorphism.html)



---
## Motivation

### Complex Conditional Logic is ONE of the HARDEST THINGS 
- to Reason About in Programming
- Devs should Look For Ways to Add Structure to Conditional Logic
  - Try to Separate the Logic Into Different Circumstances -- HIGH_LEVEL_CASES
    - To Divide the Conditions
  - Using Classes and Polymorphism can Make the Separation More Explicit

### Form a Set of Types
- Each Handling the Conditional Logic Differently
  - For example,  books, music, and food vary in how they are handled because of their type
- It's Obvious When there are Several Functions that have a Switch Statement on a Type Code
  - Remove the Duplication of the Common Switch Logic 
    - by Creating Classes For Each Case
    - Using Polymorphism to Bring Out The Type-Specific Behavior

### Another Situation: the Logic as a Base Case with Variants
- The Base Case is the Most Common or Most Straightforward
  - This Logic stays in a Superclass 
    - which allows Devs to Reason About it without Having to Worry About the Variants
- Each Variant Case will be into a Subclass
  - Expressed with Code that Emphasizes its Difference From the Base Case

### Polymorphism is Prone To Overuse
- ___Not All Examples of Conditional Logic Should Be Replaced With Polymorphism___
- Most of Conditional-Logic should Use Basic Conditional Statements
- Some Complex Conditional Logic might be Improved with Polymorphism


---
## Mechanics

- If Classes Do Not Exist for Polymorphic Behavior 
  - Create them Together with a Factory Function to Return the Correct Instance
- Use the Factory Function in Calling Code
- Move the Conditional Function to the Superclass
  - If the Conditional Logic is NOT a Self-Contained Function 
    - use Extract Function to make it so
  - Pick One of the Subclasses
    - Create a Subclass Method that Overrides the Conditional Statement Method
    - Copy the Body of That Leg of the Conditional Statement 
      - Into The Subclass Method and Adjust It to Fit
- Repeat for Each Leg of the Conditional
- Leave a Default Case for The Superclass Method
  - Or, if Superclass Should Be Abstract 
    - Declare that Method As Abstract or Throw an Error to Show 
      - it should be The Responsibility of a Subclass