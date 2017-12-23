scala.collection.mutable
List, Array and Range are sequence type collection

Traversable[A] <- Iterable[A] <-
								Seq[A] 
									  <-- Array
									  <-
										IndexedSeq[A] (Range is IndexedSeq)
													<-
													  NumericRange[T]
													  Range extends IndexedSeq[Int]
													  StringOps
													  PagedSeq
													  Vector[A]
										LinearSeq[A] (List is LinearSeq, List should not be indexing because of slow operation)
							  						<-
							  						  List[A]
							  						  Stack[A]
							  						  Queue[A]
							  						  Stream[A]

							  <-
							  	Set[A] 
							  		  <-
							  		  	HashSet[A]
							  		  	ListSet[A]
							  		  	BitSet extends Set[Int]
							  		  	SortedSet[A] <- TreeSet[A]
							  <-
							  	Map[A,B]	
							  			<-
							  			  HashMap[A,B]
							  			  LongMap[B] extends Map[Long,B]
							  			  ListMap[A,B]
							  			  IntMap[B] extends Map[Int, B]
							  			  SortedMap[A,B] <- TreeMap[A,B]

							  	
