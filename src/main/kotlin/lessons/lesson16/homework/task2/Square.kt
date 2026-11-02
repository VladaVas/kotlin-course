package lessons.lesson16.homework.task2

class Square {
    class Square(val side: Double) : Shape() {
        override fun area(): Double {
            return side * side
        }
    }
}