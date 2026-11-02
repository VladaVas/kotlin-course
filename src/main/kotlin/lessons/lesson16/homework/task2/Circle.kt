package lessons.lesson16.homework.task2
import kotlin.math.PI

class Circle {

    class Circle(val radius: Double) : Shape() {
        override fun area(): Double {
            return PI * radius * radius
        }
    }
}