package machine

import java.util.*

var currentWater = 400
var currentMilk = 540
var currentBeans = 120
var currentCups = 9
var currentDollars = 550
val scanner = Scanner(System.`in`)
fun printState() {
    println("The coffee machine has:\n" +
            "$currentWater of water\n" +
            "$currentMilk of milk\n" +
            "$currentBeans of coffee beans\n" +
            "$currentCups of disposable cups\n" +
            "\$$currentDollars of money")
}

fun changeState(water: Int, milk: Int, beans: Int, cups: Int, dollars: Int) {
    if (currentWater + water < 0) {
        println("Sorry, not enough water!")
    } else {
        currentWater += water
        currentMilk += milk
        currentBeans += beans
        currentCups += cups
        currentDollars += dollars
    }
}

fun buy() {
    print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: >")
    when (scanner.next()) {
        "1" -> changeState(-250, 0, -16, -1, 4)
        "2" -> changeState(-350, -75, -20, -1, 7)
        "3" -> changeState(-200, -100, -12, -1, 6)
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
    changeState(water, milk, beans, cups, 0)
}

fun take() {
    println("I gave you \$$currentDollars")
    changeState(0, 0, 0, 0, -currentDollars)
}

fun main() {
    do {
        print("Write action (buy, fill, take, remaining, exit): >")
        val action = scanner.next()
        when (action) {
            "buy" -> buy()
            "fill" -> fill()
            "take" -> take()
            "remaining" -> printState()
        }
    } while (action != "exit")
}
