package machine

import java.util.*

val scanner = Scanner(System.`in`)
fun printState(water: Int, milk: Int, beans: Int, cups: Int, dollars: Int) {
    println("The coffee machine has:\n" +
            "${1200 + water} of water\n" +
            "${540 + milk} of milk\n" +
            "${120 + beans} of coffee beans\n" +
            "${9 + cups} of disposable cups\n" +
            "${550 + dollars} of money")
}

fun buy() {
    print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: >")
    when (scanner.nextInt()) {
        1 -> printState(-250, 0, -16, -1, 4)
        2 -> printState(-350, -75, -20, -1, 7)
        3 -> printState(-200, -100, -12, -1, 6)
    }
}

fun fill() {
    print("Write how many ml of water do you want to add: >")
    val water = scanner.nextInt()
    print("Write how many ml of milk do you want to add: >")
    val milk = scanner.nextInt()
    print("Write how many grams of coffee beans do you want to add: >")
    val beans = scanner.nextInt()
    print("Write how many disposable cups of coffee do you want to add: >")
    val cups = scanner.nextInt()
    printState(water, milk, beans, cups, 0)
}

fun take() {
    println("I gave you \$550")
    printState(0, 0, 0, 0, -550)
}

fun main() {
    printState(0, 0, 0, 0, 0)
    print("Write action (buy, fill, take): >")
    when (scanner.next()) {
        "buy" -> buy()
        "fill" -> fill()
        "take" -> take()
    }
}
