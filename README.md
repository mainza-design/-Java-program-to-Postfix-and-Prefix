# Infix to Postfix and Prefix Expression Converter
Overview
This Java program converts arithmetic expressions written in infix notation into their equivalent postfix (Reverse Polish Notation) and prefix (Polish Notation) forms. It handles operator precedence, associativity, and parentheses correctly.

## Features
#Unordered 
Converts any valid infix expression containing:
Operands (letters or digits)
Operators: +, -, *, /, ^ (exponentiation)
Parentheses ( and )
Supports both postfix and prefix conversions.
Uses stack-based algorithms for efficient parsing.
Handles operator precedence and associativity, including right-associative exponentiation.
How It Works
### Infix to Postfix Conversion
Scan the infix expression from left to right.
Append operands directly to the output.
Push '(' onto the stack.
On encountering ')', pop and append operators until '(' is found.
For operators, pop from the stack while the top operator has higher or equal precedence, then push the current operator.
After processing the entire expression, pop any remaining operators to the output.
#### Infix to Prefix Conversion
Reverse the infix expression.
Swap '(' with ')' and vice versa.
Convert the modified expression to postfix using the above method.
Reverse the postfix expression to get the prefix expression.
