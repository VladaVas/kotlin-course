package org.example.lessons.lesson.homework

// 1. Событие: вечеринка
class Party(
    val location: String,
    val attendees: Int
) {
    fun details() {
        println("Вечеринка пройдёт в месте: $location. Количество гостей: $attendees.")
    }
}

// 2. Аспект реальности: эмоция
class Emotion(
    val type: String,
    val intensity: Int
) {
    fun express() {
        val description = when {
            intensity <= 0 -> "почти не ощущается"
            intensity <= 3 -> "слабая"
            intensity <= 6 -> "умеренная"
            intensity <= 8 -> "сильная"
            else -> "очень сильная"
        }
        println("Эмоция «$type»: $description (интенсивность $intensity из 10).")
    }
}

// 3. Природное явление: Луна
object Moon {
    var isVisible: Boolean = true
    var phase: String = "Full Moon"

    fun showPhase() {
        val visibility = if (isVisible) "Луна видна" else "Луна не видна"
        println("$visibility. Текущая фаза: $phase.")
    }
}

// 4. Покупка: продукт
data class Product(
    val name: String,
    val price: Double,
    val quantity: Int
)

// 5. Мероприятие: концерт
class Concert(
    val band: String,
    val venue: String,
    val ticketPrice: Double,
    val hallCapacity: Int
) {
    private var soldTickets: Int = 0

    fun printDetails() {
        println(
            "Концерт группы «$band». Место: $venue. " +
                    "Стоимость билета: $ticketPrice. Вместимость зала: $hallCapacity. " +
                    "Продано билетов: $soldTickets."
        )
    }

    fun buyTicket(): Boolean {
        if (soldTickets >= hallCapacity) {
            println("Билеты закончились: зал заполнен.")
            return false
        }
        soldTickets++
        println("Билет куплен. Продано билетов: $soldTickets.")
        return true
    }
}

// 6. Полка стеллажа
class Shelf(val capacity: Int) {
    private val items = mutableListOf<String>()

    init {
        require(capacity >= 0) { "Вместимость полки не может быть отрицательной." }
    }

    fun addItem(item: String): Boolean {
        if (!canAccommodate(item)) return false
        items.add(item)
        return true
    }

    fun removeItem(item: String): Boolean = items.remove(item)

    fun canAccommodate(item: String): Boolean = remainingCapacity() >= item.length

    fun containsItem(item: String): Boolean = items.contains(item)

    fun getItems(): List<String> = items.toList()

    fun usedCapacity(): Int = items.sumOf { it.length }

    fun remainingCapacity(): Int = capacity - usedCapacity()
}

// 6. Стеллаж
class Rack(private val maxShelves: Int) {
    private val shelves = mutableListOf<Shelf>()

    init {
        require(maxShelves >= 0) { "Количество полок не может быть отрицательным." }
    }

    fun addShelf(shelf: Shelf): Boolean {
        if (shelves.size >= maxShelves || shelves.any { it === shelf }) return false
        shelves.add(shelf)
        return true
    }

    fun removeShelf(index: Int): List<String> {
        if (index !in shelves.indices) return emptyList()
        return shelves.removeAt(index).getItems()
    }

    fun addItem(item: String): Boolean {
        for (shelf in shelves) {
            if (shelf.addItem(item)) return true
        }
        return false
    }

    fun removeItem(item: String): Boolean {
        for (shelf in shelves) {
            if (shelf.removeItem(item)) return true
        }
        return false
    }

    fun containsItem(item: String): Boolean = shelves.any { it.containsItem(item) }

    fun getShelves(): List<Shelf> = shelves.toList()

    fun printContents() {
        if (shelves.isEmpty()) {
            println("Стеллаж пуст: полок нет.")
            return
        }

        shelves.forEachIndexed { index, shelf ->
            println(
                "Полка ${index + 1}: вместимость = ${shelf.capacity}, " +
                        "занято = ${shelf.usedCapacity()}, " +
                        "свободно = ${shelf.remainingCapacity()}, " +
                        "предметы = ${shelf.getItems()}"
            )
        }
    }

    fun advancedRemoveShelf(index: Int): List<String> {
        if (index !in shelves.indices) return emptyList()

        val removedShelf = shelves[index]
        val otherShelves = shelves.filterIndexed { shelfIndex, _ -> shelfIndex != index }
        val itemsToMove = removedShelf.getItems().sortedByDescending { it.length }
        val notMoved = mutableListOf<String>()

        for (item in itemsToMove) {
            var moved = false
            for (shelf in otherShelves) {
                if (shelf.addItem(item)) {
                    moved = true
                    break
                }
            }
            if (!moved) notMoved.add(item)
        }

        // Удаляем полку независимо от того, удалось ли перенести все предметы.
        shelves.removeAt(index)
        return notMoved.toList()
    }
}

fun main() {
    println("=== Задание 1 ===")
    Party("Квартира у друзей", 12).details()

    println("\n=== Задание 2 ===")
    Emotion("Радость", 8).express()

    println("\n=== Задание 3 ===")
    Moon.isVisible = true
    Moon.phase = "Full Moon"
    Moon.showPhase()

    println("\n=== Задание 4 ===")
    val product = Product("Кофе", 349.90, 2)
    println(product)

    println("\n=== Задание 5 ===")
    val concert = Concert("The Example Band", "Большой зал", 2500.0, 2)
    concert.printDetails()
    concert.buyTicket()
    concert.buyTicket()
    concert.buyTicket()
    concert.printDetails()

    println("\n=== Задание 6 ===")
    val rack = Rack(maxShelves = 3)
    rack.addShelf(Shelf(capacity = 12))
    rack.addShelf(Shelf(capacity = 10))
    rack.addShelf(Shelf(capacity = 8))

    rack.addItem("книга")
    rack.addItem("ваза")
    rack.addItem("настольная лампа")
    rack.addItem("чашка")
    rack.addItem("альбом")
    rack.printContents()

    println("Есть ли книга: ${rack.containsItem("книга")}")
    println("Удаление вазы: ${rack.removeItem("ваза")}")

    println("Предметы, не перенесённые с полки 1: ${rack.advancedRemoveShelf(0)}")
    rack.printContents()
}
