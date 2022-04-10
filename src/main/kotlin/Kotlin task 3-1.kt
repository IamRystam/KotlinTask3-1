const val SECONDS_IN_MINUTE = 60
const val SECONDS_IN_HOUR = 3_600
const val SECONDS_IN_DAY = 86_400
fun main() {
    println("Введите количество секунд")
    val amount = readln().toInt()
    println("Введите one")
    val one = readln().toString()
    println("Введите few")
    val few = readln().toString()
    println("Введите many")
    val many = readln().toString()


    amountInString(amount = amount, one = one, few = few, many = many)
    agoToText(amount, one, few, many)
}

fun amountInString(amount: Int, one: String, few: String, many: String): String {

    val time = when {
        amount % 10 == 1 && amount != 11 -> one
        amount % 10 in 2..4 && amount !in 12..14 -> few
        else -> many
    }

    return time
}

fun agoToText(amount: Int, one: String, few: String, many: String) {
    val timeInMinutes = amount / SECONDS_IN_MINUTE
    val timeInHour = amount / SECONDS_IN_HOUR


    val time = amountInString(amount, one, few, many)
    when (amount) {
        in 0..SECONDS_IN_MINUTE -> println("Был в сети только что")
        in SECONDS_IN_MINUTE + 1..SECONDS_IN_HOUR -> println("Был в сети $timeInMinutes $time назад")
        in SECONDS_IN_HOUR + 1..SECONDS_IN_DAY -> println("Был в сети $timeInHour $time назад")
        in SECONDS_IN_DAY + 1..SECONDS_IN_DAY * 2 -> println("Был в сети сегодня")
        in (SECONDS_IN_DAY * 2) + 1..SECONDS_IN_DAY * 3 -> println("Был в сети вчера")
        else -> println("Был в сети давно")
    }
}

