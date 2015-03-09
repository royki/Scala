case class IVect3D(x:Double, y:Double, z:Double)

val pnt = IVect3D(1,2,3)


/*pnt.x = 9 --> not possible due to 'val'
println(pnt.x)*/

val Vect3D(var x: Double, var y: Double, var z: Double)

/*pnt.x = 9 --> now possible due to 'var'
println(pnt.x)*/
