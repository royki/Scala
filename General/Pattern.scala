case class Vect3D(x:Double, y:Double, z:Double) 

def add(v1:Vect3D, v2:Vect3D): Vect3D = {
	Vect3D(v1.x+v2.x, v1.y+v2.y, v1.z+v2.z)
}

val vect1 = Vect3D(0.5,2.7,-0.5)
val vect2 = Vect3D(0.75,-3.7,0.5)

val vect3 = add(vect1,vect2)
println(vect3)

println(vect3.x+ " " +vect3.y+ " "+vect3.z)

val Vect3D(x,y,z) = add(vect1,vect2)
println(x+ " " +y+ " "+z)

val vects = Array.fill(100)(Vect3D(math.random,math.random,math.random))
for( Vect3D(x,y,z) <- vects) {
	
}

