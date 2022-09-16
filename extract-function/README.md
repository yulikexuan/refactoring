# Extract Function

## Resources

- [Extract Function](https://memberservices.informit.com/my_account/webedition/9780135425664/html/extractfunction.html)

---
## Motivation

### When to Enclose Code in its own Function

- If Having To Spend Effort LOOKING at a FRAGMENT of CODE and Figuring Out 
  WHAT It's Doing 
  - then extracting it into a function
  - naming the function after the "WHAT" 


### Any Function with More Than Half-a-Dozen Lines of code Starts to Smell


### Optimizing Compilers often Work Better With Shorter Functions 

- #### Shorter Functions can Be Cached More Easily


### Small Functions Work If their Names Are Good

- #### Comment of the original code are often a Good Hint for the Name of The New Function


---
## Mechanics

### Create a new function

- #### Name the new Function based on the Intent of The Function
- #### Name it by What It Does, NOT By How It Does It 
  - If the code being extracted is very simple (such as a single function call) 
    - still Extract it if the name of the new function will reveal the intent 
      of the code in a better way 
    - If it's hard to come up with a more meaningful name 
      - means you shouldn't extract the code
    - Sometimes a good name only appears as working with the extraction
- #### Copy the Extracted Code from the Source Function into the New Target Function
  - Pass Variables as Parameters if they are not in new function scope 
- #### Compile after all Variables are Dealt With
- #### Replace the Extracted Code in the Source Function with a Call to The Target Function
- #### Test
- #### Look for Other Code that's the Same or Similar to The Code just Extracted 
  - Using ___Replace Inline Code with Function Call___ to call the new function