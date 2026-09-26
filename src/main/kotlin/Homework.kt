package org.example

fun main() {
    // Задание 1
    for (number in 1..5) {
        println(number)
    }

// Задание 2
    for (number in 2..10 step 2) {
        println(number)
    }

// Задание 3
    for (number in 5 downTo 1) {
        println(number)
    }

// Задание 4
    for (number in 10 downTo 1 step 2) {
        println(number)
    }

// Задание 5
    for (number in 1..9 step 2) {
        println(number)
    }

// Задание 6
    for (number in 1..20 step 3) {
        println(number)
    }

// Задание 7
    val size = 10

    for (number in 3 until size step 2) {
        println(number)
    }

// Задание 8
    var number = 1

    while (number <= 5) {
        println(number * number)
        number++
    }

// Задание 9
    var value = 10

    while (value >= 5) {
        value--
    }

    println(value)

// Задание 10
    var count = 5

    do {
        println(count)
        count--
    } while (count >= 1)

// Задание 11
    var counter = 5

    do {
        println(counter)
        counter++
    } while (counter < 10)

// Задание 12
    for (number in 1..10) {
        if (number == 6) {
            break
        }

        println(number)
    }

// Задание 13
    var currentNumber = 1

    while (true) {
        println(currentNumber)

        if (currentNumber == 10) {
            break
        }

        currentNumber++
    }

// Задание 14
    for (number in 1..10) {
        if (number % 2 == 0) {
            continue
        }

        println(number)
    }

// Задание 15
    var numberForContinue = 1

    while (numberForContinue <= 10) {

        if (numberForContinue % 3 == 0) {
            numberForContinue++
            continue
        }

        println(numberForContinue)
        numberForContinue++
    }
}