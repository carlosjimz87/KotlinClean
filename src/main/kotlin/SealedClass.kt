/**
 * `Sealed classes` allow to set a specific number of states,
 * plus more capabilities than `Enums`
 */
sealed class Result<out T : Any>(val data: Any? = null, val message: String? = null) {
    class Success<out T : Any>(data: T) : Result<T>(data)
    class Error<out T : Any>(message: String, data: T? = null) : Result<T>(data, message)
    object Loading : Result<Nothing>()
}

/** making all `when` branches as mandatory to avoid errors */
val <T> T.exhaustive: T
    get() = this

fun main() {

    listOf(
        Result.Loading,
        Result.Success(1),
        Result.Loading,
        Result.Error("Error")
    )
        .forEach {
            handleResult(it)
        }
}

fun handleResult(result: Result<Int>) {
    when (result) {
        is Result.Success -> {
            println("Success with: ${result.data}")
        }
        is Result.Error -> {
            println("Oops! error: ${result.message}")
        }
        Result.Loading -> {
            println("Loading...")
        }
    }.exhaustive
}