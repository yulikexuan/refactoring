# Remove Dead Code


## Resources

- [Remove Dead Code](https://memberservices.informit.com/my_account/webedition/9780135425664/html/removedeadcode.html)


---
## Motivation

### Unused Code is a Significant Burden when 
- Trying to Understand How the Software Works

### Unused Code doesn't Carry Any Warning Signs Telling Devs that 
- they can ignore this function as it's never called anymore
  - so Devs still Have to Spend Time Understanding 
    - what it's doing 
    - why changing it doesn't seem to alter the output as they expected 

### Don't Worry that I may Need It Sometime In The Future

---
## Mechanics

### If the dead code can be referenced from outside, e.g., 
- when it's a full function, do a search to check for callers

### Remove the dead code

### Test