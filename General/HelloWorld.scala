println("Enter value of totalSec")

val totalSec = readInt//1000000000
val secondsInDay = 24*60*60
val secondsInYear = 365*secondsInDay
val secondsInMonth = 30*secondsInDay
val years = totalSec / secondsInYear
val secondsLeftInYear = totalSec % secondsInYear
val month = secondsLeftInYear / secondsInMonth
val secondsLeftInMonth = secondsLeftInYear % secondsInMonth
val day = secondsLeftInMonth /secondsInDay

println(secondsInDay)
println(secondsInYear)
println(secondsInMonth)
println(years)
println(month)
println(day)
println("You will turn "+totalSec+" seconds at "+years+" years, "+month+" months, "+day+" day. ")
