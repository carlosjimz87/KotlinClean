fun main() {
    val originalList = (1..20).toList()

    println(originalList)
    val list1 = originalList.filter { it % 2 == 0 }
    println(list1)
}