package lessons.lesson16.homework.task4

class ShoppingCart {
    private val items = mutableMapOf<String, Int>()

    fun addToCart(itemId: String) {
        items[itemId] = (items[itemId] ?: 0) + 1
    }

    fun addToCart(itemId: String, amount: Int) {
        if (amount <= 0) return

        items[itemId] = (items[itemId] ?: 0) + amount
    }

    fun addToCart(newItems: Map<String, Int>) {
        for ((itemId, amount) in newItems) {
            addToCart(itemId, amount)
        }
    }

    fun addToCart(itemIds: List<String>) {
        for (itemId in itemIds) {
            addToCart(itemId)
        }
    }

    override fun toString(): String {
        val result = StringBuilder()

        result.appendLine("КОРЗИНА ТОВАРОВ")
        result.appendLine("------------------------------")
        result.appendLine("%-20s %s".format("Артикул", "Количество"))
        result.appendLine("------------------------------")

        for ((itemId, amount) in items) {
            result.appendLine("%-20s %d".format(itemId, amount))
        }

        result.appendLine("------------------------------")
        result.appendLine("Всего артикулов: ${items.size}")
        result.appendLine("Всего товаров: ${items.values.sum()}")

        return result.toString()
    }
}