const val SECONDS_IN_MINUTE = 60
const val SECONDS_IN_HOUR = 3_600
const val SECONDS_IN_DAY = 86_400

fun main() {

    println("Введите количество секунд")
    val amount = readln().toInt()

    agoToText(amount)
}

fun amountInString(amount: Int): String {

    val timeArray =
        if (amount < SECONDS_IN_HOUR + 1) arrayOf("минуту", "минуты", "минут") else arrayOf("час", "часа", "часов")

    val timeMinuteOrHour =
        if (amount in (SECONDS_IN_MINUTE + 1)..SECONDS_IN_HOUR) amount / SECONDS_IN_MINUTE else amount / SECONDS_IN_HOUR

    val time = when {
        timeMinuteOrHour % 10 == 1 && timeMinuteOrHour != 11 -> timeArray[0]
        timeMinuteOrHour % 10 in 2..4 && timeMinuteOrHour !in 12..14 -> timeArray[1]
        else -> timeArray[2]
    }
    return time
}

fun agoToText(amount: Int) {

    when (amount) {
        in 0..SECONDS_IN_MINUTE -> println("Был в сети только что")
        in SECONDS_IN_MINUTE + 1..SECONDS_IN_HOUR -> println(
            "Был в сети ${amount / SECONDS_IN_MINUTE} ${
                amountInString(
                    amount
                )
            } назад"
        )
        in SECONDS_IN_HOUR + 1..SECONDS_IN_DAY -> println(
            "Был в сети ${amount / SECONDS_IN_HOUR} ${
                amountInString(
                    amount
                )
            } назад"
        )
        in SECONDS_IN_DAY + 1..SECONDS_IN_DAY * 2 -> println("Был в сети сегодня")
        in (SECONDS_IN_DAY * 2) + 1..SECONDS_IN_DAY * 3 -> println("Был в сети вчера")
        else -> println("Был в сети давно")
    }
}

