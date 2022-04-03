const val secondsInMinute = 60
const val secondsInHour = 3_600
const val secondsInDay = 86_400

fun main() {
    println("Введите количество секунд")
    val timeInSeconds = readLine()?.toInt() ?: return
    agoToText(timeInSeconds)
}

fun agoToText(timeInSeconds: Int) {

    val timeInMinutes = timeInSeconds / secondsInMinute
    val timeInHour = timeInSeconds / secondsInHour

    val timeIn = if (timeInSeconds in (secondsInMinute + 1)..secondsInHour) timeInMinutes else timeInHour

    val time = when {
        timeIn % 10 == 1 && timeIn != 11 -> 1
        timeIn % 10 in 2..4 && timeIn !in 12..14 -> 2
        else -> 3
    }

    val time3: String = when (time) {
        1 -> if (timeInSeconds in (secondsInMinute + 1) until secondsInHour) "минуту"
        else if (timeInSeconds in (secondsInHour + 1)..secondsInDay) "час"
        else " "
        2 -> if (timeInSeconds > secondsInMinute + 1 && timeInSeconds <= secondsInHour) "минуты"
        else if (timeInSeconds in (secondsInHour + 1)..secondsInDay) "часа"
        else " "
        3 -> if (timeInSeconds > secondsInMinute + 1 && timeInSeconds <= secondsInHour) "минут"
        else if (timeInSeconds in (secondsInHour + 1)..secondsInDay) "часов"
        else " "

        else -> " "
    }
    when (timeInSeconds) {
        in 0..secondsInMinute -> println("Был в сети только что")
        in secondsInMinute + 1..secondsInHour -> println("Был в сети $timeInMinutes $time3 назад")
        in secondsInHour + 1..secondsInDay -> println("Был в сети $timeInHour $time3 назад")
        in secondsInDay + 1..secondsInDay * 2 -> println("Был в сети сегодня")
        in (secondsInDay * 2) + 1..secondsInDay * 3 -> println("Был в сети вчера")
        else -> println("Был в сети давно")
    }
}

