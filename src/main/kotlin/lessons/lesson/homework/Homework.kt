package org.example.lessons.lesson.homework

abstract class GeometricFigure(
    open val name: String,
    open val color: String
)

open class Polygon(
    override val name: String,
    override val color: String,
    open val sides: Int
) : GeometricFigure(name, color)

class Circle(
    override val color: String,
    val radius: Double
) : GeometricFigure("Круг", color)

class Triangle(
    override val color: String,
    val sideA: Double,
    val sideB: Double,
    val sideC: Double
) : Polygon("Треугольник", color, 3)

class Quadrilateral(
    override val color: String,
    val sideA: Double,
    val sideB: Double,
    val sideC: Double,
    val sideD: Double
) : Polygon("Четырёхугольник", color, 4)

// 2. Учебные заведения
open class EducationalInstitution(
    open val name: String,
    open val address: String
)

open class School(
    override val name: String,
    override val address: String,
    val studentCount: Int,
    val gradeCount: Int
) : EducationalInstitution(name, address)

class ArtSchool(
    override val name: String,
    override val address: String,
    val studentCount: Int,
    val gradeCount: Int,
    val artSpecializations: List<String>
) : School(name, address, studentCount, gradeCount)

class University(
    override val name: String,
    override val address: String,
    val facultyCount: Int,
    val studentCount: Int
) : EducationalInstitution(name, address)

class MedicalUniversity(
    override val name: String,
    override val address: String,
    val facultyCount: Int,
    val studentCount: Int,
    val hospitalAttached: Boolean
) : University(name, address, facultyCount, studentCount)

// 3. Иерархия мебели
open class Furniture(
    open val name: String,
    open val material: String,
    open val color: String
)

open class SeatingFurniture(
    override val name: String,
    override val material: String,
    override val color: String,
    open val seatCount: Int
) : Furniture(name, material, color)

class Chair(
    override val material: String,
    override val color: String,
    val hasArmrests: Boolean
) : SeatingFurniture("Стул", material, color, 1)

class Sofa(
    override val material: String,
    override val color: String,
    override val seatCount: Int,
    val isFoldable: Boolean
) : SeatingFurniture("Диван", material, color, seatCount)

open class StorageFurniture(
    override val name: String,
    override val material: String,
    override val color: String,
    open val shelfCount: Int
) : Furniture(name, material, color)

class Wardrobe(
    override val material: String,
    override val color: String,
    override val shelfCount: Int,
    val doorCount: Int
) : StorageFurniture("Шкаф", material, color, shelfCount)

// 4–7. Контейнеры материалов
abstract class Materials {
    protected val materials = mutableListOf<String>()

    open fun addMaterial(material: String) {
        materials.add(material)
    }

    fun extractMaterials(): List<String> {
        val extracted = materials.toList()
        materials.clear()
        return extracted
    }

    fun printContainer() {
        materials.forEachIndexed { index, layer ->
            println("[$index]: $layer")
        }
    }

    fun getMaterials(): List<String> = materials.toList()
}

// 4. Добавляет материал на дно: индекс 0
class BottomMaterials : Materials() {
    override fun addMaterial(material: String) {
        materials.add(0, material)
    }
}

// 5. Вставляет элементы списка в индексы 0, 2, 4 и т. д.
class InterleavedMaterials : Materials() {
    fun addMaterials(newMaterials: List<String>) {
        newMaterials.forEachIndexed { index, material ->
            materials.add(index * 2, material)
        }
    }
}

// 6. После добавления сортирует все материалы по алфавиту
class SortedMaterials : Materials() {
    override fun addMaterial(material: String) {
        materials.add(material)
        materials.sort()
    }
}

// 7. Ключи идут в начало в обратном порядке, значения — в конец
class DictionaryMaterials : Materials() {
    fun addMaterials(materialsMap: Map<String, String>) {
        val keys = materialsMap.keys.toList()
        val values = materialsMap.values.toList()
        materials.addAll(0, keys.reversed())
        materials.addAll(values)
    }
}

fun main() {
    // 1. Геометрические фигуры
    val triangle = Triangle("Красный", 3.0, 4.0, 5.0)
    val circle = Circle("Синий", 2.5)
    println("Фигура: ${triangle.name}, сторон: ${triangle.sides}, цвет: ${triangle.color}")
    println("Фигура: ${circle.name}, радиус: ${circle.radius}, цвет: ${circle.color}")

    // 2. Учебные заведения
    val artSchool = ArtSchool("Школа искусств", "ул. Центральная, 1", 300, 11, listOf("Живопись", "Музыка"))
    val medicalUniversity = MedicalUniversity("Медицинский университет", "ул. Университетская, 10", 8, 5000, true)
    println("${artSchool.name}: учеников ${artSchool.studentCount}, направления: ${artSchool.artSpecializations}")
    println("${medicalUniversity.name}: факультетов ${medicalUniversity.facultyCount}, есть клиника: ${medicalUniversity.hospitalAttached}")

    // 3. Мебель
    val chair = Chair("Дерево", "Коричневый", true)
    val sofa = Sofa("Ткань", "Серый", 3, true)
    val wardrobe = Wardrobe("ДСП", "Белый", 5, 2)
    println("${chair.name}: материал ${chair.material}, подлокотники: ${chair.hasArmrests}")
    println("${sofa.name}: мест ${sofa.seatCount}, раскладной: ${sofa.isFoldable}")
    println("${wardrobe.name}: полок ${wardrobe.shelfCount}, дверей ${wardrobe.doorCount}")

    // 4. Добавление на дно контейнера
    val bottomContainer = BottomMaterials()
    bottomContainer.addMaterial("Дерево")
    bottomContainer.addMaterial("Стекло")
    bottomContainer.addMaterial("Металл")
    println("\nМатериалы на дне:")
    bottomContainer.printContainer()

    // 5. Вставка списка на позиции 0, 2, 4...
    val interleavedContainer = InterleavedMaterials()
    interleavedContainer.addMaterial("Существующий 1")
    interleavedContainer.addMaterial("Существующий 2")
    interleavedContainer.addMaterial("Существующий 3")
    interleavedContainer.addMaterials(listOf("Новый 1", "Новый 2"))
    println("\nЧередование материалов:")
    interleavedContainer.printContainer()

    // 6. Сортировка после добавления
    val sortedContainer = SortedMaterials()
    sortedContainer.addMaterial("Стекло")
    sortedContainer.addMaterial("Дерево")
    sortedContainer.addMaterial("Бумага")
    println("\nОтсортированные материалы:")
    sortedContainer.printContainer()

    // 7. Словарь: ключи в начало, значения в конец
    val dictionaryContainer = DictionaryMaterials()
    dictionaryContainer.addMaterial("Существующий материал 1")
    dictionaryContainer.addMaterial("Существующий материал 2")
    dictionaryContainer.addMaterials(linkedMapOf("A" to "Материал A", "B" to "Материал B", "C" to "Материал C"))
    println("\nМатериалы из словаря:")
    dictionaryContainer.printContainer()
}
