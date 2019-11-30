//def foo(name:String, age: Int): (String, Int) = (name,age)

def foo(name:String, age: Int): (String, Int) = name+ " " +age
def foo(name:String, age: Int = 18): (String, Int) = name+ " " +age
def foo(name:String = "Dao", age: Int = 18): (String, Int) = name+ " " +age