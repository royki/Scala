##### Pattern Matching an Option

```scala
scala> def getMiddleName(value: Option[String]): String = {
     |     value match {
     |        case Some(middleName) => middleName
     |        case None => "No middle name"
     |    }
     | }
getMiddleName: (value: Option[String])String

scala> case class Author(f: String = " ", middle: Option[String] = None, l:String = " ")

scala> val martin = Author("Martin",None,"Odersky")
martin: Author = Author(Martin,None,Odersky)

scala> getMiddleName(martin.middle)
res20: String = No middle name

scala> val jane = Author("Jane", Option("Do"), "John")
jane: Author = Author(Jane,Some(Do),John)

scala> getMiddleName(jane.middle)
res22: String = Do

scala> getMiddleName(martin)
<console>:14: error: type mismatch;
 found   : Author
 required: Option[String]
       getMiddleName(martin)

scala> def getISBN(value: Option[Int]): String = {
     |     value match {
     |        case Some(isbn) => isbn.toString
     |        case None => "Not found"
     |    }
     | }
getISBN: (value: Option[Int])String

scala> case class Books(n:String = " ", a:String, isbn: Option[Int]= None)
defined class Books

scala> val book = Books("Scala", "Martin Odersky", Option(2123))
book: Books = Books(Scala,Martin Odersky,Some(2123))    

scala> val book1 = Books("Akka", "Martin Odersky", None)
book1: Books = Books(Akka,Martin Odersky,None)

scala> getISBN(book.isbn)
res23: String = 2123

scala> getISBN(book1.isbn)
res24: String = Not found
```

