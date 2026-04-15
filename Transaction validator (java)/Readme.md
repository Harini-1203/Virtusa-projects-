# FinSafe – Transaction Validator
## Project Description
FinSafe is a console-based digital wallet application that validates user transactions and prevents overdraft issues.

## Problem statement
Build a robust Transaction Processor that validates every "Spend" request against the user&#39;s
current balance and logs every action for auditing purposes.

## Features
- Deposit money into account  
- Withdraw money with validation  
- Prevent overdraft transactions  
- Store last 5 successful transactions  
- View mini statement  
- Full exception handling

---
## Tasks

### Encapsulation
- Account data (`balance`, `name`,`password`,`accountno`) is private  
- Accessed using only getters  

### Custom Exception
- `InSufficientFundsException`  
- Thrown when withdrawal exceeds available balance  

### Validation Logic
- Negative amount → `IllegalArgumentException`  
- Amount greater than balance → `InSufficientFundsException`  

### Transaction History
- Stores last 5 successful transactions with transactionID,ammount,type and prev balance
- Implemented using `ArrayList`  

---
## How to Run

1. Compile all files:
```bash
javac *.java
```
2. Run:
```bash
java main
```



