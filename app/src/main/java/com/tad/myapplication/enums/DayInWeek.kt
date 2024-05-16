package com.tad.dashboard.enums

enum class DayInWeek(val value: Float) {
    MONDAY(100f),
    TUESDAY(250f),
    WEDNESDAY(400f),
    THURSDAY(550f),
    FRIDAY(700f),
    SATURDAY(850f),
    SUNDAY(1000f);

}
fun getNameDay (value: Float) : String {
    return when (value) {
        DayInWeek.MONDAY.value -> "Mon"
        DayInWeek.TUESDAY.value -> "Tue"
        DayInWeek.WEDNESDAY.value -> "Wed"
        DayInWeek.THURSDAY.value -> "Thu"
        DayInWeek.FRIDAY.value -> "Fri"
        DayInWeek.SATURDAY.value -> "Sat"
        else -> "Sun"
    }
}