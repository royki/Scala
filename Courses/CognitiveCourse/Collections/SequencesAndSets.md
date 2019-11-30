#### _Sequence_
- `An ordered collection of data`
- `Duplicates are permitted`
- `May or may not be indexed `
- `Exm: Array, List, Vector`
- `The apply method on an instance is a lookup`

#### _Array - A fixed in size, ordered sequence of data_
  - `Very fast on the JVM`
  - `Values are contiguous in Memory`
  - `Indexed by position`

#### _List - A linked list implementation, with a value and a pointer to the next element_
 - `Theritically unbound in size`
 - `Poor performance as data could be located anywhere in memory and must be accessed via "pointer chasing"`


#### _Vetor - A linked list of 32 element arrays. It represtents both arrays and list_
  - `2.15 billion possible elements`
  - `Indexed by hashing `
  - `Every operation on vector is effectively constant time`
  - `Good performance across all operations without having to copy arrays when more space is needed`

#### _Set - A bag of data, where no duplicates are permitted_
- `Order is not guaranteed`
- `HashSet, TreeSet, BitSet, KeySet, SortedSet etc`
- `The apply method on an instance checks to see if the set contains a value`

```scala
val s = Set(1,2,3,4,5)
> scala.collection.immutable.Set[Int] = Set(1,2,3,4,5)
s.getClass
> scala.collection.immutable.HashSet$HashTrieSet
s + 6
> Set(1,2,3,6,4,5)
s + 2
> Set(1,2,3,6,4,5)
s(5)
> Boolean == true
s(7)
> Boolean == false
val s1 = s.toSeq
> Seq[Int] = ArrayBuffer(1,2,3,6,4,5)
s1.toSet
> scala.collection.immutable.Set[Int] = Set(1,2,3,6,4,5)
```