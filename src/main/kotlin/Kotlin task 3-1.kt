const val SECONDS_IN_MINUTE = 60
const val SECONDS_IN_HOUR = 3_600
const val SECONDS_IN_DAY = 86_400

fun main() {
    println("Введите количество секунд")
    val amount = readln().toInt()

    agoToText(amount)
}
fun amountInString(amount: Int, one: String = "минуту", few: String = "минуты", many: String = "минут"): String {

    val time = when {
        amount % 10 == 1 && amount != 11 -> one
        amount % 10 in 2..4 && amount !in 12..14 -> few
        else -> many
    }
    return time
}
fun agoToText(amount: Int) {

    when (amount) {
        in 0..SECONDS_IN_MINUTE -> println("Был в сети только что")
        in SECONDS_IN_MINUTE + 1..SECONDS_IN_HOUR -> println("Был в сети ${ amount / SECONDS_IN_MINUTE} ${amountInString(amount) } назад")
        in SECONDS_IN_HOUR + 1..SECONDS_IN_DAY -> println("Был в сети ${amount / SECONDS_IN_HOUR} ${amountInString(amount )} назад")
        in SECONDS_IN_DAY + 1..SECONDS_IN_DAY * 2 -> println("Был в сети сегодня")
        in (SECONDS_IN_DAY * 2) + 1..SECONDS_IN_DAY * 3 -> println("Был в сети вчера")
        else -> println("Был в сети давно")
    }
}

