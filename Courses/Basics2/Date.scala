import java.text.SimpleDateFormat
import java.util.Calendar

object Date extends App {
	
	val today = Calendar.getInstance.getTime
     
	// create the date/time formatters
	val minuteFormat = new SimpleDateFormat("mm")
	val hourFormat = new SimpleDateFormat("hh")
	val yearFormat = new SimpleDateFormat("yyyy")
	val amPmFormat = new SimpleDateFormat("a")
	 
	val currentHour = hourFormat.format(today)      // 12
	val currentMinute = minuteFormat.format(today)  // 29
	val amOrPm = amPmFormat.format(today)  

	println(currentHour)
}