package machine

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    print("Write how many ml of water the coffee machine has: > ")
    var canMake = scanner.nextInt() / 200
    print("Write how many ml of milk the coffee machine has: > ")
    val milk = scanner.nextInt() / 50
    if (milk < canMake) {
        canMake = milk
    }
    print("Write how many grams of coffee beans the coffee machine has: > ")
    val beans = scanner.nextInt() / 15
    if (beans < canMake) {
        canMake = beans
    }
    print("Write how many cups of coffee you will need: > ")
    val cups = scanner.nextInt()
    if (cups > canMake) {
        println("No, I can make only $canMake cups of coffee")
    } else {
        print("Yes, I can make that amount of coffee")
        println(if (canMake > cups) " (and even ${canMake - cups} more than that)" else "")
    }
}
