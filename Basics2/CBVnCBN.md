#### Call-by-value and call-by-name
- both strategies reduce to the same final values as long as
    + the reduced expressio consists of pure functions
    + both evaluations terminate

- Call-by-value has the advantage that it evaluates every function argument only once
- Call-by-name has the advantage that a function argument is not evaluated if the corresponding is unused in the evaluation of the function body. 
- If call-by-value evaluation of an expression `e` terminates, then call-by-name evaluation of `e` terminates too.
- The other direction is not true.
    +  `def first(x: Int, y: Int) = x`
    +  consider the expression `first(1, loop)`
        *  Under CBN it terminates
        *  Under CBV it enters in loop as it evaluates all the function arguments.
- Scala normally uses call-by-value. If the type of a function parameter start with `=>` it uses call-by-name.
    + `def constOne(x: Int, y: => Int) = 1`
    + Trace the evaluations of 
        * `constOne(1+2, loop)`
        * `constOne(loop, 1+2)`

- The difference between `val` and `def` becomes apparent when the right hand side does not terminate.
    + `def loop: Boolean = loop`
    + A definition 
        * `def x = loop` is OK
        * `val x = loop` is NOT OK, it'll lead to an infinite loop