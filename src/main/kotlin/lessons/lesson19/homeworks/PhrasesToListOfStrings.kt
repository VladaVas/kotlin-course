package lessons.lesson19.homeworks

class PhrasesToListOfStrings : Mapper<String, List<String>> {
    override fun map(element: String): List<String> =
        element.split(' ').filter { it.isNotEmpty() }

    override fun mapList(elements: List<String>): List<List<String>> =
        elements.map(::map)
}
