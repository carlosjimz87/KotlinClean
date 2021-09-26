/**
 * Use @Deprecated annotation to document a WARNING, ERROR or HIDDEN deprecated method
 * with a replaceWith= expression to facilitate usage,
 * and imports= if some external dependency is needed
 */
@Deprecated(
    "Use strings.joinToString(sep)",
    level = DeprecationLevel.WARNING,
    replaceWith = ReplaceWith("strings.joinToString(sep)")
)
fun oldJoin(sep: String, strings: List<String>): String {
    require(sep.length < 2) { "sep is less than 2" }
    return strings.joinToString(sep)
}

fun main() {
    oldJoin(",", listOf("me", "you")) // right-click on the method name to get the replacement proposal
}


