package lessons.lesson19.homeworks

class OddValidator : Validator<Int> {
    override fun validate(element: Int): Boolean = element % 2 == 0
}
