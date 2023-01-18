# Common Refactorings for Smells

---

## [Alternative Classes with Different Interfaces](https://refactoring.guru/smells/alternative-classes-with-different-interfaces)
- ### Signs and Symptoms
  - Two Classes Perform Identical Functions but Have Different Method Names
- ### Reasons for the Problem
  - The Programmer who Created One of the Classes probably DID NOT Know that 
    - a Functionally Equivalent Class Already Existed
- ### Treatment
  - #### [Change Function Declaration](change-function-declaration/README.md)
  - #### [Move Function](move-function/README.md)
  - #### [Extract Superclass](extract-superclass/README.md)
- ### Payoff
  - Getting Rid of Unnecessary Duplicated Code
  - Making the Resulting Code Less Bulky
  - Code Becomes More Readable & Understandable

---

## [Comments](https://refactoring.guru/smells/comments)
- ### Signs and Symptoms
  - A Method is Filled with Explanatory Comments
    - > Explanatory: giving the reasons for something; intended to describe how 
      > something works or to make something easier to understand
- ### Reasons for the Problem
  - Good Comments DO NOT Repeat the Code 
  - Good Comments Tell Things which are NOT able to be Read from Code
  - Bad Comments are like a Deodorant Masking the Smell of Fishy Code 
    - that Could be Improved
- ### Treatment
  - #### [Extract Variable](extract-variable/README.md)
    - If a Comment is Intended to Explain a Complex Expression
      - the Expression should be Split into Understandable Subexpressions
  - #### [Extract Function](extract-function/README.md)
    - If a Comment Explains a Section of Code
      - this Section can be Turned Into a Separate Func
      - The Name of the New Func can be Taken from the Comment Text Itself
  - #### [Rename Func](https://refactoring.guru/rename-method)
    - If a Func has already been Extracted, but Comments are still Necessary 
      - Give the Func a Self-Explanatory Name
  - #### [Introduce Assertion](https://refactoring.guru/introduce-assertion)
- ### Payoff
  - Code Becomes More Intuitive & Obvious
  - Making Further Refactoring Possible

--- 

## [Data Class](https://refactoring.guru/smells/data-class)

- ### Signs and Symptoms
  - A Class Contains ONLY Fields & CRUD Funcs for Accessing Them (getters and setters)
  - These Classes are Simply Containers for Data Used by Other Classes
  - These Classes DO NOT Contain Any Additional Functionality
  - These Classes CANNOT Independently Operate on the Data that they Own

- ### Reasons for the Problem
  - It's a normal thing when a Newly Created Class Contains Only a Few Public Fields 
    - and maybe even a handful of getters/setters 
  - But the True Power of Objects is that they CAN Contain Behavior Types 
    - or Operations on their Data

- ### Treatment
  - Use [Encapsulate Field](https://refactoring.guru/encapsulate-field) to Hide Public Fields
  - Use [Encapsulate Collection](encapsulate-collection/README.md) for Data Stored in Collections
    - Return Immutable Collection View from Getter
  - Review the Client Code that Uses the Data Class
    - Over There, you may Find Functionality that Would Be Better Located in the Data Class Itself
    - Use [Move Func](move-function/README.md) and [Extract Func](extract-function/README.md) to Migrate this Functionality to the Data Class
  - After the Class has been Filled with Well-Thought-Out-Methods 
    - Get Rid of Old Methods for Data Access 
      - which Give Overly Broad Access to the Class Data
      - For this, [Remove Setting Method](remove-setting-method/README.md) and [Hide Method](https://refactoring.guru/hide-method) May Be Helpful 

- ### Payoff
  - Improves Understanding and Organization of Code
  - Operations on particular-data are now Gathered in a Single Place
    - Instead of Haphazardly Throughout The Code
  - Helps to Spot Duplication of Client Code

---

## [Data Clumps](https://refactoring.guru/smells/data-clumps)

> Clump: A Small Group of Things or People Very Close Together, 
> especially trees or plants; a bunch of something such as grass or hair

- ### Signs and Symptoms
  - Different Parts of the Code Contain Identical Groups of Variables 
    - Such as parameters for connecting to a database 
    - These Clumps should be Turned into Their Own Classes

- ### Reasons for the Problem
  - This is Due to Poor Program Structure or Copy-Pasta-Programming
  - To Make Sure Whether Some Data is a Data Clump
    - just Delete One of the Data Value & See Whether the Other Values Still Make Sense
    - If this is NOT the Case, this is a Good Sign that 
      - this Group of Variables should be Combined Into an Object

- ### Treatment
  - If Repeating Data Comprises the Fields of a Class, 
    - Use [Extract Class](https://refactoring.guru/extract-class) to Move the Fields to Their Own Class
  - If the Same Data Clumps are Passed in the Parameters of Methods
    - use [Introduce Parameter Object](https://refactoring.guru/introduce-parameter-object) to Set Them Off as a Class
  - If Some of the Data is Passed to other methods
    - think about Passing the Entire Data Object to the Method 
      - instead of just individual fields
  - Look at the code used by these fields
    - It may be a good idea to Move This Code to A Data Class

- ### Payoff
  - Improves Understanding & Organization of Code
  - Reduce the Complexity and Code Size
  - Operations on Particular Data are now Gathered in a Single Place
    - instead of haphazardly throughout the code

- ### When to Ignore?
  - Passing an Entire Object in the Parameters of a Method
    - instead of Passing Just its Values (primitive types) 
      - may Create an Undesirable Dependency between the Two Classes

---

## [Divergent Change](https://memberservices.informit.com/my_account/webedition/9780135425664/html/smells.html#divergent-change)

> We Structure our Software to Make Change Easier
>   - Software is Meant to be Soft
>   - When Making a Change, Devs Want to Jump to a Single Clear Point in the System
>     - and Make the Change
>   - When Devs CANNOT DO THIS, we Smell one of two closely related pungencies


- ### Signs and Symptoms
  - Divergent Change Occurs when One Module is often Changed in Different Ways for Different Reasons
    - Example, I will have to change these three functions every time I get a new database
    - Example, I have to change these four functions every time there is a new financial instrument
  - Having to Change Many Unrelated Methods when Making Changes to a Class
    - For Example: When Adding a New Product Type, 
      - Have to Change the Methods for Finding, Displaying, and Ordering Products

- ### Reasons for the Problem
  - Often these Divergent Modifications are Due To Poor Program Structure 
    - or Copy-Pasta Programming

- ### Treatment
  - [Split Phase](split-phase/README.md)
  - [Move Function](move-function/README.md)
  - [Extract Function](extract-function/README.md)
  - Split Up the Behavior of the Class via [Extract Class](extract-class/README.md)
  - If Different Classes Have the Same Behavior, 
    - Combine the Classes through Inheritance 
      - [Extract Superclass](extract-superclass/README.md) and [Extract Subclass](https://refactoring.guru/extract-subclass)

- ### Payoff
  - Improves Code Organization
  - Reduces Code Duplication
  - Simplifies Support 

---

## [Duplicated Code](https://refactoring.guru/smells/duplicate-code)

- ### Signs and Symptoms
  - Two Code Fragments Look Almost Identical

- ### Reasons for the Problem
  - Multiple Programmers are Working on Different Parts of the Same Program at the Same Time
  - Specific Parts of Code Look Different But Actually Perform the Same Job
  - Copy-Paste, sometimes, Purposeful

- ### Treatment
  - #### The Same Code is Found in Two Subclasses of the Same Level
    - Use [Extract Function](extract-function/README.md) for Both Classes
      - Followed by [Pull Up Field](https://refactoring.guru/pull-up-field) for the Fields Used in the Method that you're Pulling Up
    - If the Duplicate Code is Inside a Constructor, use [Pull Up Constructor Body](pull-up-constructor-body/README.md)
    - If the Duplicate Code is Similar but not Completely Identical
      - Use [Form Template Method](https://refactoring.guru/form-template-method)
    - If Two Methods Do the Same Thing But Use Different Algorithms
      - Select the Best Algorithm and Apply [Substitute Algorithm](substitute-algorithm/README.md)
  - #### If Duplicate Code is Found in Two Different Classes
    - If the Classes are NOT Part of a Hierarchy, use [Extract Superclass](extract-superclass/README.md) to Create a Single Superclass 
      - for these Classes that Maintains all the Previous Functionality
    - If it is Difficult or Impossible to Create a Superclass 
      - use [Extract Class](extract-class/README.md) in One Class 
        - and use the New Component in the Other
  - #### If a Large Number of Conditional Expressions are Present and Perform the Same Code
    - Differing Only in their Conditions
    - Merge These Operators into a Single Condition Using [Consolidate Conditional Expression](consolidate-conditional-expression/README.md)
      - Use [Extract Func](extract-function/README.md) to Place the Condition in a Separate Method 
        - with an Easy-to-Understand Name
  - #### If the Same Code is Performed in All Branches of a Conditional Expression
    - Place the Identical Code Outside of the Condition Tree 
      - by Using [Consolidate Duplicate Conditional](consolidate-conditional-expression) Fragments

- ### Payoff
  - Merging Duplicate Code Simplifies the Structure of your Code and Makes it Shorter
  - Simplification + Shortness = Code that is Easier to Simplify and Cheaper to Support

- ### When to Ignore
  - In Very Rare Cases, Merging Two Identical Fragments of Code 
    - can Make the Code Less Intuitive and Obvious


--- 

## [Feature Envy](https://memberservices.informit.com/my_account/webedition/9780135425664/html/smells.html#feature-envy)

- [Also See](https://refactoring.guru/smells/feature-envy)

> envy /ˈenvi/ n. the feeling of wanting to be in the same situation as somebody else; the feeling of wanting something that somebody else has

> When Modularizing a Program, Devs are Trying to Separate the Code into Zones 
> - to ___Maximize the Interaction Inside a Zone___ & ___Minimize Interaction Between Zones___

> The Fundamental Rule Of Thumb is to Put Things Together That Change Together

- ### Signs and Symptoms
  - A Classic Case of Feature Envy Occurs when a Func in One Module 
    - Spends More Time Communicating with Funcs or Data Inside Another Module Than 
      - It Does within Its Own Module
  - For Example, we ___Have Lost Count Of The Times___ (記不清有多少次) 
    - we've seen A Function Invoking Half-A-Dozen Getter Methods on Another Object 
      - to Calculate Some Value
  - This Smell May Occur After Fields are Moved to a Data Class 
    - If this is the case, Move the Operations on Data to this Class As Well

- ### Reasons for the Problem

- ### Treatment
  - If Things Change at the Same Time, Keep Them in the Same Place
    - Usually Data and Funcs that Use This Data are Changed Together 
      - although Exceptions are Possible (Strategy and Visitor)
  - If a Method Clearly Should Be Moved To Another Place, use [Move Function](move-function/README.md)
  - If Only Part of a Method Accesses the Data of Another Object 
    - use [Extract Function](extract-function/README.md) to Move the Part in Question
  - If a Method Uses Funcs from Several Other Classes
    - First Determine Which Class Contains Most of the Data Used
    - Then Place the Method in this Class Along With The Other Data
    - Alternatively, use [Extract Function](extract-function/README.md) to Split The Method Into Several Parts 
      - that can be Placed In Different Places In Different Classes


- ### Payoff
  - Maximize the Interaction Inside a Zone & Minimize Interaction Between Zones

- ### When to Ignore
  - Sometimes Behavior is Purposefully Kept Separate From The Class that Holds The Data
    - The Usual Advantage of this is the Ability to Dynamically Change the Behavior 
      - see Strategy, Visitor and Other Patterns 


---

## [Global Data](https://memberservices.informit.com/my_account/webedition/9780135425664/html/smells.html#global-data)

- ### Treatment
  - [Encapsulate Variable](https://memberservices.informit.com/my_account/webedition/9780135425664/html/encapsulatevariable.html)

---

## [Insider Trading](https://memberservices.informit.com/my_account/webedition/9780135425664/html/smells.html#insider-trading)

- ### Signs and Symptoms
  - Modules that Whisper to Each Other by the Coffee Machine

- ### Reasons for the Problem
  - Bad Project Arch (Arch based on Tech other than Domain)
  - No Project Arch
  - Inheritance can often Lead to Collusion
    - Subclasses are Always going to Know More About Their Parents than
      - Their Parents Would Like Them to Know

- ### Treatment
  - Using [Move Function](move-function/README.md) and [Move Field](move-field/README.md) to Reduce the Need to Chat
  - If Modules Have Common Interests
    - Try to Create a Third Module to Keep That Commonality in a Well Regulated Vehicle
    > regulate (something) to control something by means of rules
    - or use [Hide Delegate and Remove the Middle Man](hide-delegate/README.md) to Make Another Module Act as an Intermediary
  - Inheritance can Often Lead to Collusion
    > collusion: secret agreement especially in order to do something dishonest or to trick people
    - Apply [Replace Subclass with Delegate](replace-subclass-with-delegate/README.md) or [Replace Superclass with Delegate](replace-superclass-with-delegate/README.md)

- ### Payoff
  - Have Clear Boundary

- ### When to Ignore

---

## [Large Class](https://memberservices.informit.com/my_account/webedition/9780135425664/html/smells.html#large-class)

- [See Also](https://refactoring.guru/smells/large-class)

- ### Signs and Symptoms
  - When a Class is Trying to Do Too Much, it often Shows Up As Too Many Fields
    - When a class Has Too Many Fields, Duplicated Code Cannot Be Far Behind
  - A Class Contains Many Fields / Methods / Lines of Code

- ### Reasons for the Problem
  - Classes Usually Start Small
    - But Over Time, they Get Bloated As the Program Grows
  - Devs usually Find it Mentally Less Taxing to Place a New Feature in an Existing Class 
    - than to Create a New Class for the Feature
    > taxing: needing a great amount of physical or mental effort
  - A Class with Too Much Code is a Prime Breeding Ground for Duplicated Code, Chaos, and Death

- ### Treatment
  - [Extract Class](extract-class/README.md) to Bundle a number of the Instance Vars
    - Choose Variables to Go Together in the Component that Makes Sense For Each
    - More generally, Common Prefixes or Suffixes for some Subset of the Variables in a class 
      - suggest the Opportunity for a Component
    - If the Component Makes Sense with Inheritance
      - [Extract Superclass](extract-superclass/README.md)
      - [Replace Type Code with Subclasses](replace-type-code-with-subclasses/README.md)
  - Eliminate Redundancy in the Class Itself
    - [Extract Funcs](extract-function/README.md) 
    - [Move Funcs](move-function/README.md)
  - The Clients of Such a Class are often the Best Clue for Splitting Up the Class
    - Look at Whether Clients Use a Subset of the Features of the Class
      - Each Subset is a Possible Separate Class
      - Once having Identified a Useful Subset, Break it Out with
        - [Extract Class](extract-class/README.md) 
          - This Helps if Part of the Behavior of the Large Class can be Implemented 
            - in Different Ways or is Used in Rare Cases
        - [Extract Superclass](extract-superclass/README.md) 
        - [Replace Type Code with Subclasses](replace-type-code-with-subclasses)
  - [Extract Interface](https://refactoring.guru/extract-interface) Helps 
    - if it is Necessary to Have a List of the Operations and Behaviors that the Client can Use
        

- ### Payoff
  - Refactoring of These Classes Spares Developers from Needing to Remember a Large Number 
    - of Attributes for a Class
  - In Many Cases, Splitting Large Classes into Parts Avoids Duplication of Code and Functionality

- ### When to Ignore

---

## [Lazy Element](https://memberservices.informit.com/my_account/webedition/9780135425664/html/smells.html#lazy-element)

- ### Signs and Symptoms
  - Some Added Structures ARE NOT Needed
    - A Func is Named the Same As Its Body Code Reads
    - A Class is Essentially One Simple Func
    - A Func that was Expected to Grow and Be Popular Later
      - but Never Realized Its Dreams 
    - A Class that Used To Pay Its Way 
      - but Has Been Downsized with Refactoring
    - A Class is No Longer Pulling Its Weight and should NOT Be Around Anymore
      - This is the Result of Refactoring that moves other responsibilities out of the class so there is little left
  - Such Program Elements Need to Die with Dignity

- ### Reasons for the Problem
  - Using Program Elements to Add Structure Providing Opportunities for 
    - Variation 
    - Reuse
    - or just Having More Helpful Names

- ### Treatment
  - [Inline Func](inline-function/README.md)
  - [Inline Class](inline-class/README.md)
  - With Inheritance, use [Collapse Hierarchy](collapse-hierarchy/README.md)


---

## [Long Function](https://memberservices.informit.com/my_account/webedition/9780135425664/html/smells.html#long-function)

- See Also [Long Method](https://refactoring.guru/smells/long-method)

> ### The Programs that Live Best and Longest are those with Short Funcs
>   - The Longer A Func Is, the More Difficult it is to Understand
>   - The Real Key to Making it Easy to Understand Small Funcs is Good Naming
>   - All the Payoffs of ___Indirection Explanation___, ___Sharing___, and ___Choosing___ are Supported By ___Small Funcs___
>     - All the Payoffs 所有收益 

> ### Devs Should be Much More Aggressive about Decomposing Funcs

- ### Signs and Symptoms
  - Feeling the Need to Comment Something in a Func
  - If you Have a Func with Lots of Params and Local Vars 
    - they Get In The Way of Extracting
  - A Block of Code with a Comment that Tells you What It Is Doing Can Be Replaced 
    - by a Func whose Name is Based on the Comment
  - Conditionals and Loops also Give Signs for Extractions

- ### Reasons for the Problem

- ### Treatment
  - Ninety-nine Percent of the Time, All Have to Do to Shorten a Func is [Extract Function](extract-function/README.md)
    - Find Parts of the Func that Seem to Go Nicely Together and Make A New One
  - Whenever Feeling the Need to Comment Something in a Long Func, Write a new Func Instead
    - Such a Func Contains the Code that we wanted to Comment 
      - but is Named After the Intention of the Code Rather Than the Way It Works
      - Might Do this on a Group of Lines or even on a Single Line of Code
    - We do this Even If the Func Call is Longer than the Code it Replaces, 
      - as the Long Func Name Explains the Purpose of the Code
    - The Key here is not Func Length but the Semantic Distance Between 
      - what the Func Does and How It Does It
  - If Having a Lots of Local Vars in the Long Func
    - Use [Replace Temp with Query](replace-temp-with-query/README.md) to Eliminate the Temps
  - If Having Long List of Params
    - Long Lists Of Params can be Slimmed Down with 
      - [Introduce Parameter Object](introduce-parameter-object/README.md) 
      - [Preserve Whole Object](preserve-whole-object/README.md)
  - [Replace Func with Command](replace-function-with-command/README.md) can also Help 
    - on the Situation of Long Param List
  - For Conditions 
    - Use [Decompose Conditional](decompose-conditional/README.md) to Deal With Conditional Expressions
  - For Big Switch Statements
    - Use [Extract Function](extract-function/README.md) to Make its Legs Turned Into Single Function Calls
    - If there's More Than One Switch Statement Switching on the Same Condition 
      - Apply [Replace Conditional with Polymorphism](replace-conditional-with-polymorphism/README.md)
  - For Loops, Extract the Loop and the Code within the Loop into its Own Method
    - If it's Hard to Give an Extracted Loop a Name, this might be because it's Doing Two Different Things
      - Use [Split Loop](split-loop/README.md) to Break Out The Separate Tasks

--- 

## [Long Parameter List](https://memberservices.informit.com/my_account/webedition/9780135425664/html/smells.html#long-parameter-list)

- ### [See Also](https://refactoring.guru/smells/long-parameter-list) 

> Long Parameter Lists are often Confusing In Their Own Right
> - in your own right: (本身) because of your personal qualifications or efforts, 
>   not because of your connection with somebody else

- ### Signs and Symptoms
  - More Than Three or Four Parameters for a Method

- ### Reasons for the Problem
  - A Long List of Parameters might Happen After 
    - Several Types of Algorithms are Merged in a Single Method
    - A Long List may have Been Created to Control Which Algorithm will be Run and How 
  - Long Parameter Lists may also be the Byproduct of Efforts to 
    - Make Classes More Independent of Each Other

- ### Treatment
  - If, Can Obtain One Parameter by Asking Another Parameter For It, 
    - Use [Replace Parameter with Query](replace-parameter-with-query/README.md) to Remove the Second Parameter
  - Rather Than Pulling Lots Of Data Out of an Existing Data Structure 
    - Use [Preserve Whole Object](preserve-whole-object/README.md) to Pass the Original Data Structure Instead
  - If Several Parameters Always Fit Together
    - Combine them with [Introduce Parameter Object](introduce-parameter-object/README.md)
  - If a Parameter is Used as a Flag To Dispatch Different Behavior 
    - Use [Remove Flag Argument](remove-flag-argument/README.md)
  - When Multiple Functions Share Several Parameter Values
    - Use [Combine Functions into Class](combine-functions-into-class/README.md) 
      - to Capture Those Common Values As Fields


- ### Payoff
  - More Readable, Shorter Code
  - Refactoring may Reveal Previously Unnoticed Duplicate Code

- ### When to Ignore
  - Don't Get Rid of Parameters if Doing So Would Cause Unwanted Dependency Between Classes

---

## [Loops](https://memberservices.informit.com/my_account/webedition/9780135425664/html/smells.html#loops)

- ### Signs and Symptoms

- ### Reasons for the Problem
  - Logic in Loop Body is Much Difficult to Follow

- ### Treatment
  - Use [Replace Loop with Pipeline](replace-loop-with-pipeline/README.md)

- ### Payoff
  - Logic is Much Easier to Follow
  - Can then Read From Top To Bottom to See How Objects Flow Through the Pipeline

- ### When to Ignore

---

## [Message Chains](https://memberservices.informit.com/my_account/webedition/9780135425664/html/smells.html#message-chains)

- [See Also](https://refactoring.guru/smells/message-chains)

- ### Signs and Symptoms
  - You see Message Chains when a Client Asks One Object For Another Object
    - which the Client Then Asks For Yet Another Object
    - Which The Client Then Asks For Yet Another Another Object
      - and So On
  - In code you see A Series Of Calls Resembling ``` $a->b()->c()->d() ```

- ### Reasons for the Problem
  - Navigating this Way Means the Client is Coupled to the Structure of the Navigation
  - Any Change to the Intermediate Relationships Causes the Client to Have To Change

- ### Treatment
  - Use [Hide Delegate](hide-delegate/README.md)
    - See What the Resulting Object is Used For 
    - See Whether you Can Use [Extract Function](extract-function/README.md) to Take a Piece of the Code that Uses It
      - then [Move Function](move-function/README.md) to Move it to the Beginning of the Chain

- ### Payoff
  - Reduces dependencies between classes of a chain
  - Reduces the amount of bloated code

- ### When to Ignore
  - Overly Aggressive Delegate Hiding can Cause Code in which it's Hard to See 
    - Where the Functionality is Actually Occurring
    - Which is Another Way of Saying, Avoid the [Middle Man](https://memberservices.informit.com/my_account/webedition/9780135425664/html/smells.html#middle-man) Smell as well

---

## [Middle Man](https://memberservices.informit.com/my_account/webedition/9780135425664/html/smells.html#middle-man)

- [See Also](https://refactoring.guru/smells/middle-man)

- ### Signs and Symptoms
  - If a Class Performs Only One Action, Delegating Work To Another Class
    - Why Does It Exist At All ???
  - Delegation Can Go Too Far ...
    - Half of the Methods of a Class are Delegating To Another Class

- ### Reasons for the Problem
  - This Smell can be the Result of Overzealous Elimination of [Message Chains](#message-chains)
  - It Can Be the Result of the Useful Work of a Class Being Gradually Moved to Other Classes
    - The Class Remains as an Empty Shell that does NOT Do Anything Other Than Delegate

- ### Treatment
  - Use [Remove Middle Man](https://memberservices.informit.com/my_account/webedition/9780135425664/html/removemiddleman.html) and Talk to the Object that Really Knows What's Going On
  - If only A Few Methods are NOT Doing Much, Use [Inline Function](inline-function/README.md) to Inline Them Into The Caller
  - If there is Additional Behavior, to Extend Behavior without Chasing all that Delegation
    - Use [Replace Superclass with Delegate](replace-superclass-with-delegate/README.md) 
    - or [Replace Subclass with Delegate]() to Fold the Middle Man into the Real Object

- ### Payoff
  - Less Bulky Code

- ### When to Ignore
  - Do Not Delete Middle Man that Have Been Created for a Reason
    - A Middle Man may have Been Added to Avoid Inter-Class Dependencies
    - Some Design Patterns Create Middle Man On Purpose (such as Proxy or Decorator)

---

## [Mutable Data](https://memberservices.informit.com/my_account/webedition/9780135425664/html/smells.html#mutable-data)

- ### Signs and Symptoms
- ### Reasons for the Problem
> Changes to Data can often Lead to Unexpected Consequences & Tricky Bugs

> A Failure that's Particularly Hard to Spot If it Only Happens Under Rare Conditions

> Mutable Data that Can Be Calculated Elsewhere is Particularly Pungent
> - It is NOT just a Rich Source of Confusion, Bugs 
>   - it's Also Unnecessary

> Functional Programming is Based on the Notion that:
> - Data Should Never Change
> - Updating a Data Structure Should Always Return a New Copy of the Structure with the Change
    >   - Leaving the Old Data Pristine

> pristine: not developed or changed in any way; left in its original condition

- ### Treatment
  - Use Encapsulate Variable to Ensure that All Updates Occur Through Narrow Functions 
    - that can be Easier to Monitor & Evolve
  -  If a Variable is Being Updated to Store Different Things
     - use [Split Variable](split-variable/README.md) Both to Keep them Separate and Avoid the Risky Update
  - Try As Much As Possible to Move Logic Out of Code that Processes the Update 
    - by using [Slide Statements](slide-statements/README.md) and [Extract Function](extract-function/README.md) 
      - to Separate the SIDE EFFECT FREE Code from Anything that Performs the Update
  - In APIs, Use [Separate Query from Modifier](separate-query-from-modifier) to Ensure Callers 
    - do NOT Need to Call Code that Has Side Effects Unless They Really Need To
  - Use [Remove Setting Method](remove-setting-method/README.md) As Soon As We Can 
    - sometimes, just Trying to Find Clients of a Setter Helps Spot Opportunities 
      - to Reduce the Scope of a Variable
  - If Mutable Data is Calculated Elsewhere
    - [Replace Derived Variable with Query](replace-derived-variable-with-query/README.md) 
  - Mutable Data is NOT A Big Problem when it's a Variable whose Scope is just a Couple of Lines 
    - but Its Risk Increases As Its Scope Grows
    - Use [Combine Functions into Class](combine-functions-into-class/README.md) or [Combine Functions into Transform](combine-functions-into-transform/README.md)
      - to Limit How Much Code Needs to Update a Variable
  - If a Var Contains Some Data with Internal Structure
    - it's usually better to replace the entire structure rather than modify it in place
      - using [Change Reference to Value](change-reference-to-value/README.md)

- ### Payoff

- ### When to Ignore

--- 

## [Mysterious Name](https://memberservices.informit.com/my_account/webedition/9780135425664/html/smells.html#mysterious-name)

> Code Needs to be Mundane & Clear
> - mundane: /mʌnˈdeɪn/ not interesting or exciting

> One of the Most Important Parts of Clear Code is Good Names

- ### Signs and Symptoms
  - When you can't think of a good name for something, 
    - it's often a sign of a deeper design malaise
    - > malaise: [məˈleɪz] n. a general feeling of being ill, unhappy or not satisfied, 
      > - or that something is wrong in society, without being able to explain or identify what is wrong

- ### Reasons for the Problem

- ### Treatment
  - [Change Function Declaration](change-function-declaration/README.md)
  - [Rename Field](rename-field/README.md)
  - [Rename Variable](https://memberservices.informit.com/my_account/webedition/9780135425664/html/renamevariable.html)

- ### Payoff

- ### When to Ignore

---

## [Primitive Obsession](https://memberservices.informit.com/my_account/webedition/9780135425664/html/smells.html#primitive-obsession)

> obsession 痴迷

- ### [See Also](https://refactoring.guru/smells/primitive-obsession)

- ### Signs and Symptoms
  - Just a Field for Storing SOME DATA 
  - Calculations that Treat Monetary Amounts as Plain Numbers
  - Calculations of Physical Quantities that Ignore Units (Adding Inches to Millimeters)
  - Lots of Code Doing ``` if (a < upper && a > lower) ```
  - Groups of Primitives that Commonly Appear Together are Data Clumps
  - Strings are Particularly Common Petri Dishes (培養皿) for this Kind of Odor
    - A Proper Type can often Include Consistent Display Logic 
      - for when it Needs to be Displayed in a User Interface
    - Representing Such Types As Strings is Such a Common Stench that 
      - People Call Them "stringly typed" Variables
  - Use of constants for coding information
    - Such as a Constant ``` USER_ADMIN_ROLE = 1 ``` for Referring to Users With Administrator Rights
  - Use of String Constants as Field Names for Use in Data Arrays

- ### Reasons for the Problem
  - Primitive Obsessions are Born in Moments of Weakness 
    - "___Just a field for storing some data!___ " the Programmer Said
    - Creating a Primitive Field is so Much Easier than Making a Whole New Class and so It's Done
      - Then Another Field was Needed and Added in the Same Way 
      - Lo and behold, the Class Became Huge & Unwieldy
        - > behold: behold somebody/something, to look at or see somebody/something
        - > unwieldy: difficult to control or organize because it is very large or complicated
  - Primitives are often used to Simulate Types 
    - So Instead of a Separate Data Type, you have A Set Of Numbers or Strings 
      - that Form the List of Allowable Values for Some Entity
        - Easy-to-Understand Names are then Given to These Specific Numbers and Strings 
          - via Constants which is Why they're Spread Wide & Far
  - Another Example of Poor Primitive Use is Field Simulation
    - The Class Contains a Large Array of Diverse (各色各樣) Data and String Constants 
      - (which are specified in the class) are Used as Array Indices for Getting this Data

- ### Treatment
  - [Replace Primitive with Object](replace-primitive-with-object/README.md)
  - [Replace Type Code with Subclasses](replace-type-code-with-subclasses/README.md)
    - Followed By [Replace Conditional with Polymorphism](replace-conditional-with-polymorphism/README.md)
  - If Groups of Primitives that Commonly Appear Together
    - [Extract Class](extract-class/README.md)
    - [Introduce Parameter Object](introduce-parameter-object/README.md) 

- ### Payoff
  - Easier Finding of Duplicate Code
  - Code becomes more flexible thanks to use of objects instead of primitives
  - Better understandability and organization of code
    - Operations on particular data are in the same place, instead of being scattered
    - No More Guessing About the Reason for All These Strange Constants 
      - and why they're in an array

- ### When to Ignore

---

## [Refused Bequest](https://memberservices.informit.com/my_account/webedition/9780135425664/html/smells.html#refused-bequest)

- ### [See Also](https://refactoring.guru/smells/refused-bequest)

- ### Signs and Symptoms
  - A Subclass Uses Only Some of the Methods and Properties Inherited from its Parents
    - the Hierarchy is off-kilter
    - > off-kilter: not perfectly straight or balanced; not in line with something else
    - The Unneeded Methods May Simply Go Unused or be Redefined and Give Off Exceptions
    - Means the Hierarchy Is Wrong
  - The Smell of Refused Bequest is Much Stronger if the Subclass is Reusing Behavior 
    - but Does Not Want to Support the Interface of the Superclass
    - Refusing Interface Gets Us On Our High Horses
      - > be/get on your high horse 傲慢
        > - to behave in a way that shows you think you are better than other people

- ### Reasons for the Problem
  - Someone was Motivated to Create Inheritance Between Classes Only By the Desire to 
    - Reuse the Code in a Superclass 
    - But the Superclass and Subclass are Completely Different 
      - it is NOT "IS-A" Relationship

- ### Treatment
  - If Inheritance Makes No Sense & the Subclass Has Nothing In Common With the Superclass
    - Eliminate Inheritance In Favor Of [Replace Superclass with Delegation](replace-superclass-with-delegate/README.md)
    - Eliminate Inheritance In Favor Of [Replace Subclass with Delegation](replace-subclass-with-delegate/README.md)
  - If Inheritance is Appropriate, Get Rid Of Unneeded Fields & Methods in the Subclass
    - Extract All Fields and Methods Needed By the Subclass from the Superclass
      - Put Them In A New Superclass
      - Set Both Classes to Inherit From It
      - [Extract Superclass](extract-superclass/README.md) 

- ### Payoff
  - Improves Code Clarity & Organization
    - You will No Longer Have To Wonder Why the Dog class is Inherited from the Chair class
      - (even though they both have 4 legs)

- ### When to Ignore


---

## [Repeated Switches](https://memberservices.informit.com/my_account/webedition/9780135425664/html/smells.html#repeated-switches)

- ### Signs and Symptoms
  - The Same Conditional Switching Logic 
    - Either in a ``` switch / case ``` Statement Or in a Cascade of ``` if / else ``` Statements 
      - Pops Up in Different Places


- ### Reasons for the Problem
  - Whenever you Add a New Clause, you have to Find All the ``` switches ``` and Update Them


- ### Treatment
  - Against the Dark Forces of Such Repetition, Polymorphism Provides an Elegant Weapon 
    - for a More Civilized Codebase

- ### Payoff


- ### When to Ignore


---

## [Shotgun Surgery](https://memberservices.informit.com/my_account/webedition/9780135425664/html/smells.html#shotgun-surgery)

- [See Also](https://refactoring.guru/smells/shotgun-surgery)

- ### Signs and Symptoms
  - Making any Modifications Requires that you Make Many Small Changes to Many Different Classes
  - Different from [Divergent Change](#divergent-change)
    - Divergent Change: occurs when one module is often changed in different ways for different reasons

- ### Reasons for the Problem
  - When the Changes are All Over The Place
    - they are Hard to Find
    - and it is Easy to Miss an Important Change

- ### Treatment
  - Put All the Changes into a Single Module by Means of
    - [Move Function](move-function/README.md)
    - [Move Field](move-field/README.md)
  - If you Have a Bunch of Functions Operating on Similar Data
    - use [Combine Functions into Class](combine-functions-into-class/README.md)
  - If Having Functions that are Transforming or Enriching a Data Structure
    - use [Combine Functions into Transform](combine-functions-into-transform/README.md)
  - If the Common Functions can Combine their Output for a Consuming Phase of Logic
    - Use [Split Phase](split-phase/README.md)
  - A Useful Tactic for Shotgun Surgery, To Pull Together Poorly Separated Logic
    - Use Inlining Refactorings
      - [Inline Function](inline-function/README.md)
      - [Inline Class](inline-class/README.md)
    - End Up With a Long Method or a Large Class
      - then Use Extractions to Break It Up Into More Sensible Pieces
      - NOT Afraid of Creating Something Large as an Intermediate Step to Reorganization


- ### Payoff


- ### When to Ignore

---

## [Speculative Generality](https://memberservices.informit.com/my_account/webedition/9780135425664/html/smells.html#speculative-generality)

> speculative [ˈspekjələtɪv] n. 
> - based on guessing or on opinions that have been formed without knowing all the facts

> generality: a statement that discusses general principles or issues rather than details or particular examples

- ### [See Also](https://refactoring.guru/smells/speculative-generality)


- ### Signs and Symptoms
  - There's an Unused Class, Method, Field or Parameter

- ### Reasons for the Problem
  - Sometimes Code is Created "Just In Case" to Support Anticipated Future Features that
    - Never Get Implemented
    - Add All Sorts of Hooks & Special Cases to Handle Things that are NOT Required
    - As a Result, Code Becomes Hard to Understand & Support & Maintain
    - > ___"Oh, I think we'll need the ability to do this kind of thing someday"___

- ### Treatment
  - For Removing Unused Abstract Classes
    - Try [Collapse Hierarchy](collapse-hierarchy/README.md)
  - Unnecessary Delegation Can Be Removed With
    - [Inline Func](inline-function/README.md)
    - [Inline Class](inline-class/README.md)
  - To Remove Any Unneeded Parameters
    - [Change Func Declaration](change-function-declaration/README.md)
  - Unused Fields can be Simply Deleted

- ### Payoff
  - Slimmer Code
  - Easier Support

- ### When to Ignore
  - If Working on a Framework, it’s Eminently Reasonable to Create Functionality 
    - NOT Used in the Framework Itself 
    - As Long As the Functionality is Needed by the Frameworks' Users
  - Before Deleting Elements, Make Sure that they are NOT Used in Unit Tests 
    - This Happens if Tests Need a Way to Get Certain Internal Information from a Class 
      - or Perform Special Testing-Related Actions

---

## [Temporary Field](https://memberservices.informit.com/my_account/webedition/9780135425664/html/smells.html#temporary-field)

- ### [See Also](https://refactoring.guru/smells/temporary-field)

- ### Signs and Symptoms
  - Temporary Fields Get Their Values (and thus are needed by objects) Only Under Certain Circumstances 
    - Outside of These Circumstances, they are Empty

- ### Reasons for the Problem
  - Oftentimes, Temporary Fields are Created for Use In An Algorithm 
    - that Requires a Large amount of Inputs
    - So Instead of Creating a Large Number of Parameters in the Method 
      - the Programmer Decides to Create Fields for this Data in the Class
      - These Fields are Used Only in the Algorithm and Go Unused The Rest Of The Time
  - Such code is Difficult to Understand
    - because you Expect an Object to Need All Its Fields
  - Trying to Understand Why A Field is There when it does NOT Seem to be Used can 
    - Drive Devs Nuts
  - You Expect to See Data in Object Fields but for some reason 
    - They are almost Always Empty

- ### Treatment
  - Use [Extract Class](extract-class/README.md) to Create a Home for the Poor Orphan Fields
    - Use [Move Func](move-function/README.md) to Put All The Code that Concerns the Fields into This New Class
  - To Create an Alternative Class for when the Fields are NOT Valid
    - also Eliminate Conditional Code
    - Use [Introduce Special Case](introduce-special-case/README.md)
  - Introduce [Null Object](https://refactoring.guru/introduce-null-object) 
    - and Integrate it in place of the Conditional Code which was Used 
      - to Check the Temporary Field Values for Existence

- ### Payoff
  - Better Code Clarity & Organization



