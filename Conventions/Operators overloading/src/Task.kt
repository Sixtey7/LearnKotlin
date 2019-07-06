import TimeInterval.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

enum class TimeInterval { DAY, WEEK, YEAR }

class RepeatedTimeInterval(val timeInterval: TimeInterval, val amount: Int);

operator fun TimeInterval.times(amount: Int): RepeatedTimeInterval = RepeatedTimeInterval(this, amount);


operator fun MyDate.plus(timeInterval: TimeInterval): MyDate {
    return this.addTimeIntervals(timeInterval, 1);

}

operator fun MyDate.plus(repeatedTimeInterval: RepeatedTimeInterval) : MyDate {
    return this.addTimeIntervals(repeatedTimeInterval.timeInterval, repeatedTimeInterval.amount);
}
fun task1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}


fun task2(today: MyDate): MyDate {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}
