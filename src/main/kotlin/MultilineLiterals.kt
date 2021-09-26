val str = """
        foo
        bar
        baz
        """.trimIndent()

val str2 = """|foo
              |bar
              |baz""".trimMargin()

const val foo = "FOO!"
const val bar = "BAR!"
const val baz = "BAZ!"

val str3 = """|$foo
              |$bar
              |$baz""".trimMargin()

fun main() {
    println(str)
    println(str2)
    println(str3)
}