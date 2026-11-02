package lessons.lesson16.homework.task2

import kotlin.math.PI
import kotlin.math.sin

class Triangle(val sideA: Double, val sideB: Double, val angle: Double) : Shape() {
    override fun area(): Double {
        return 0.5 * sideA * sideB * sin(angle * PI / 180)
    }
}