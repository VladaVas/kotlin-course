package lessons.lesson19.homeworks

fun main() {
    println("Средний элемент: ${getMiddleElement(listOf(1, 2, 3))}")
    println("Средний элемент чётного списка: ${getMiddleElement(listOf(1, 2, 3, 4))}")

    val holder = ListHolder<String>()
    holder.add("Kotlin")
    val snapshot = holder.getAll()
    holder.add("Generics")
    println("Снимок списка: $snapshot, текущий список: ${holder.getAll()}")

    val mapper = PhrasesToListOfStrings()
    println("Слова: ${mapper.map("Привет  Kotlin")}")
    println("Списки слов: ${mapper.mapList(listOf("Привет Kotlin", "Урок 19"))}")

    println("Перестановка с повтором: ${transposition(linkedMapOf("a" to 1, "b" to 2, "c" to 1))}")

    val stringValidator = StringValidator()
    println("Проверка строк: ${listOf(null, "", "   ", "Kotlin").map(stringValidator::validate)}")

    val oddValidator = OddValidator()
    println("Проверка чётности: ${listOf(2, 3).map(oddValidator::validate)}")

    val listValidator = ListValidator<Number>()
    val lists = listOf(listOf(1, 0.5), listOf(1, null), listOf(1, -0.0))
    println("Проверка списков: ${lists.map(listValidator::validate)}")
}
