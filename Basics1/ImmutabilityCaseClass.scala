case class Player(name: String, x: Int, y: Int) 

val p = Player("Miller", 100, 120)

println(p.x +" " +p.y)

//p.x= 50 ---> not possible

def moveRight(p:Player):Player = Player(p.name, p.x+1, p.y)
moveRight(p)

//def moveRight(p:Player):Player = p.copy(x = p.x+1)
//moveRight(p)

def moveLeft(p:Player):Player = p.copy(x = p.x-1)
moveLeft(p)

