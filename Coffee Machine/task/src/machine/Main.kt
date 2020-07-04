package machine

import java.util.*

val scanner = Scanner(System.`in`)

class CoffeeMachine {
    var currentWater = 400
    var currentMilk = 540
    var currentBeans = 120
    var currentCups = 9
    var currentDollars = 550

    enum class State {
        IDLE,
        BUY,
        FILL_WATER,
        FILL_MILK,
        FILL_BEANS,
        FILL_CUPS,
        OFF
    }

    var currentState: State = State.IDLE

    val defaultMessage = "Write action (buy, fill, take, remaining, exit): >"

    var currentMessage = defaultMessage
        private set

    fun isOn(): Boolean {
        return currentState != State.OFF
    }

    fun handleInput(input: String) {
        when (currentState) {
            State.IDLE -> when (input) {
                "buy" -> buy()
                "fill" -> fill()
                "take" -> take()
                "remaining" -> remaining()
                "exit" -> exit()
            }
            State.BUY -> handleInputWhenBuying(input)
            State.FILL_WATER -> handleInputWhenFillingWater(input)
            State.FILL_MILK -> handleInputWhenFillingMilk(input)
            State.FILL_BEANS -> handleInputWhenFillingBeans(input)
            State.FILL_CUPS -> handleInputWhenFillingCups(input)
            else -> Unit
        }
    }

    fun buy() {
        currentMessage = "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: >"
        currentState = State.BUY
    }

    fun handleInputWhenBuying(input: String) {
        val changeStateMessage = when (input) {
            "1" -> changeState(-250, 0, -16, -1, 4)
            "2" -> changeState(-350, -75, -20, -1, 7)
            "3" -> changeState(-200, -100, -12, -1, 6)
            else -> ""
        }

        currentMessage = changeStateMessage + defaultMessage
        currentState = State.IDLE
    }

    var waterToFill = 0
    var milkToFill = 0
    var beansToFill = 0
    var cupsToFill = 0

    fun fill() {
        currentMessage = "Write how many ml of water do you want to add: >"
        currentState = State.FILL_WATER
    }

    fun handleInputWhenFillingWater(input: String) {
        waterToFill = input.toInt()

        currentMessage = "Write how many ml of milk do you want to add: >"
        currentState = State.FILL_MILK
    }

    fun handleInputWhenFillingMilk(input: String) {
        milkToFill = input.toInt()

        currentMessage = "Write how many grams of coffee beans do you want to add: >"
        currentState = State.FILL_BEANS
    }

    fun handleInputWhenFillingBeans(input: String) {
        beansToFill = input.toInt()

        currentMessage = "Write how many disposable cups of coffee do you want to add: >"
        currentState = State.FILL_CUPS
    }

    fun handleInputWhenFillingCups(input: String) {
        cupsToFill = input.toInt()

        val changeStateMessage = changeState(waterToFill, milkToFill, beansToFill, cupsToFill, 0)
        currentMessage = changeStateMessage + defaultMessage
        currentState = State.IDLE
    }

    fun take() {
        currentMessage = "I gave you \$$currentDollars\n$defaultMessage"
        changeState(0, 0, 0, 0, -currentDollars)
    }

    fun remaining() {
        currentMessage = "The coffee machine has:\n" +
                "$currentWater of water\n" +
                "$currentMilk of milk\n" +
                "$currentBeans of coffee beans\n" +
                "$currentCups of disposable cups\n" +
                "\$$currentDollars of money\n" +
                defaultMessage
    }

    fun exit() {
        currentState = State.OFF
    }

    fun changeState(water: Int, milk: Int, beans: Int, cups: Int, dollars: Int): String {
        return when {
            currentWater + water < 0 -> "Sorry, not enough water!\n"
            currentMilk + milk < 0 -> "Sorry, not enough milk!\n"
            currentBeans + beans < 0 -> "Sorry, not enough coffee beans!\n"
            currentCups + cups < 0 -> "Sorry, not enough disposable cups!\n"
            else -> {
                currentWater += water
                currentMilk += milk
                currentBeans += beans
                currentCups += cups
                currentDollars += dollars
                ""
            }
        }
    }
}

fun main() {
    val coffeeMachine = CoffeeMachine()
    while (coffeeMachine.isOn()) {
        println(coffeeMachine.currentMessage)
        coffeeMachine.handleInput(scanner.next())
    }
}
