package ru.skillbranch.dev_intensive_2019.extensions

import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR


fun Date.format(pattern:String="HH:mm:ss dd.MM.yy"):String{
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value:Int, units: TimeUnits = TimeUnits.SECOND) : Date{
     var time = this.time

    time +=when(units){
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}
enum class TimeUnits{
    SECOND,
    MINUTE,
    HOUR,
    DAY
}

fun Date.humanizeDiff(date: Date = Date()): String {
    //TODO("not implemented")
    var current:Long = Date().time
    var diff = current - this.time

    if (diff >= 0){
        when(diff){
            in 0..1000 -> return "только что"
            in 1000..45000 -> return "несколько секунд назад"
            in 45000..75000 -> return "минуту назад"
            in 75000..2700000 -> return "${diff / 60 / 1000} минут назад"
            in 2700000..4500000 -> return "час назад"
            in 4500000..79200000 -> when {
                (((diff / 3600000) %100)%10) == 1L -> return "${(diff / 3600000)} час назад"
                (((diff / 3600000)%100)%10) in 2..4 -> return "${(diff / 3600000)} часа назад"
                ((diff / 3600000)%100) in 10..20 -> return "${(diff / 3600000)} часов назад"
                else -> return "${(diff / 3600000)} часов назад"
            }
            in 79200000..93600000 -> return "день назад"
            in 93600000..31104000000 -> return "${diff / 86400000} дней назад"
            else -> return "более года назад"
        }
    }else{
        diff *= -1
        when(diff){
            in 0..1000 -> return "только что"
            in 1000..45000 -> return "через несколько секунд"
            in 45000..75000 -> return "через минуту"
            in 75000..2700000 -> return "через ${diff / 60 / 1000} минуты"
            in 2700000..4500000 -> return "через час"
            in 4500000..79200000 -> when {
                (((diff / 3600000) %100)%10) == 1L -> return "через ${(diff / 3600000)} час"
                (((diff / 3600000)%100)%10) in 2..4 -> return "через ${(diff / 3600000)} часа"
                ((diff / 3600000)%100) in 10..20 -> return "через ${(diff / 3600000)} часов"
                else -> return "через ${(diff / 3600000)} часов"
            }
            in 79200000..93600000 -> return "через день"
            in 93600000..31104000000 -> return "через ${diff / 86400000} дней"
            else -> return "более чем через год"
        }
    }

}
