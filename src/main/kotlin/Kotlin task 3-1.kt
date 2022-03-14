val secondsInMinuts = 60
val secondsInHours = 60*60*60
val secondsInDays = 60*60*60*24

fun main(){
    println("Введите количество секунд")
    val timeInSeconds = readLine()?.toInt() ?: return
    agoToText(timeInSeconds)
}

fun agoToText(timeInSeconds:Int) {

    val timeInMinuts = timeInSeconds / secondsInMinuts
    val timeInHour = timeInSeconds/secondsInHours
    val timeM:String
    val timeH:String

    when {
        ((timeInMinuts % 10 == 1) && (timeInMinuts != 11)) -> timeM ="минуту"
        ((timeInMinuts % 10 == 2) && (timeInMinuts != 12)) -> timeM ="минуты"
        ((timeInMinuts % 10 == 3) && (timeInMinuts != 13)) -> timeM ="минуты"
        ((timeInMinuts % 10 == 4) && (timeInMinuts != 14)) -> timeM ="минуты"
        else -> timeM = "минут"
    }
    when {
        ((timeInHour % 10 == 1) && (timeInHour != 11)) -> timeH ="час"
        ((timeInHour % 10 == 2) && (timeInHour != 12)) -> timeH ="часа"
        ((timeInHour % 10 == 3) && (timeInHour != 13)) -> timeH ="часа"
        ((timeInHour % 10 == 4) && (timeInHour != 14)) -> timeH ="часа"
        else -> timeH = "часов"
    }

    when (timeInSeconds) {
        in 0..secondsInMinuts -> println( "Был в сети только что")
        in secondsInMinuts + 1..secondsInHours ->  println("Был в сети $timeInMinuts $timeM назад")
        in secondsInHours + 1.. secondsInDays -> println( "Был в сети $timeInHour $timeH назад")
        in secondsInDays + 1..secondsInDays * 2 -> println( "Был в сети сегодня")
        in (secondsInDays * 2) + 1..secondsInDays * 3 -> println("Был в сети вчера")
        else -> println("Был в сети давно")
    }
}
