// Buffer is under Seq hierarchy

import collection.mutable
import collection.mutable.Buffer

val buf = mutable.Buffer(1,2,3,4,5)
val fillBuf = mutable.Buffer.fill(10)(math.random)

// assign into
buf(3) = 99
// indexing
buf(2)

// When we create an array, it has a fixed size. To change the size of array, we need to create a new array
// buffer has method on them (+=) to add a new element into the bufferr
buf.trimStart(2)
// trimEnd(2) will drop from end o
buf += 7 += 8
// to prepend element into buffer (+=:)
-10 +=: buf 
// to add collection into buffer (++=)
buf ++= List(1,2,3)
// to prepend collection into buffer (++=:)
List(5,32,122) ++=: buf
// to remove element from buffer (-=)
buf -= 2
// to remove collection from buffer (--=)
buf --= List(1,2,3)
// clear the whole buffer
buf.clear
// To insert into buffer, we need to give index
buf.insert(2, 99,98,100)
// drop() on buffer creates a new buffer
buf.drop(2)
// trimStart() does similar as drop(),but it doesn't create new buffef buffer
buf.trimEnd(2)
// remove, removeCount
