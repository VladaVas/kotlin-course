package lessons.lesson16.homework

import lessons.lesson16.homework.task1.Animal
import lessons.lesson16.homework.task1.Bird
import lessons.lesson16.homework.task1.Cat
import lessons.lesson16.homework.task1.Dog
import lessons.lesson16.homework.task2.Circle
import lessons.lesson16.homework.task2.Shape
import lessons.lesson16.homework.task2.Square
import lessons.lesson16.homework.task2.Triangle
import lessons.lesson16.homework.task3.InkjetPrinter
import lessons.lesson16.homework.task3.LaserPrinter
import lessons.lesson16.homework.task3.Printer

fun main() {
// Задание 1. Животные
    println("=== ЖИВОТНЫЕ ===")

    val animals: List<Animal> = listOf(
        Animal(),
        Dog(),
        Cat(),
        Bird()
    )

    for (animal in animals) {
        animal.makeSound()
    }


// Задание 2. Геометрические фигуры
    println("\n=== ГЕОМЕТРИЧЕСКИЕ ФИГУРЫ ===")

    val shapes: List<Shape> = listOf(
        Circle.Circle(5.0),
        Square.Square(4.0),
        Triangle(3.0, 4.0, 90.0)
    )

    for (shape in shapes) {
        println("Площадь: %.2f".format(shape.area()))
    }


// Задание 3. Принтеры
    println("\n=== ПРИНТЕРЫ ===")

    val text = "Kotlin is a modern programming language " +
            "that supports object oriented programming " +
            "including inheritance polymorphism and abstraction"

    val printers: List<Printer> = listOf(
        LaserPrinter(),
        InkjetPrinter()
    )

    for (printer in printers) {
        println("\n${printer.javaClass.simpleName}:")
        printer.print(text)
    }


// Задание 4. Корзина товаров
    println("\n=== КОРЗИНА ===")

    val cart = ShoppingCart()

    cart.addToCart("APPLE")
    cart.addToCart("APPLE", 3)

    cart.addToCart(
        mapOf(
            "MILK" to 2,
            "BREAD" to 1,
            "APPLE" to 2
        )
    )

    cart.addToCart(
        listOf("MILK", "EGGS", "EGGS")
    )

    println(cart)


// Задание 5. Логгер
    println("\n=== ЛОГГЕР ===")

    val logger = Logger()

    logger.log("Приложение запущено")

    logger.log(LogLevel.WARNING, "Мало свободной памяти")
    logger.log(LogLevel.ERROR, "Ошибка подключения")
    logger.log(LogLevel.DEBUG, "Проверка переменной")

    logger.log(
        listOf(
            "Пользователь авторизован",
            "Данные загружены",
            "Операция завершена"
        )
    )

    logger.log(Exception("Не удалось выполнить запрос"))
}