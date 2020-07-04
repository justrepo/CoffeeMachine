package machine

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    print("Write how many cups of coffee you will need: > ")
    val n = scanner.nextInt()
    print("For " + n + " cups of coffee you will need:\n"
            + n * 200 + " ml of water\n"
            + n * 50 + " ml of milk\n"
            + n * 15 + " g of coffee beans")
}
