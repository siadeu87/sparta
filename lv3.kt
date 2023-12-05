package com.example.myapplication

fun main() {
    println("1번째 숫자를 입력")
    val num1 = readLine()!!.toInt()
    println("연산자 입력(+, -, *, /)")
    val operation = readLine()!!
    println("1번째 숫자를 입력")
    val num2 = readLine()!!.toInt()
    val calc = Calculator()

    val result = when (operation) {
        "+" -> calc.addOperation(AddOperation(), num1, num2)
        "-" -> calc.subtractOperation(SubtractOperation(), num1, num2)
        "*" -> calc.multiplyOperation(MultiplyOperation(), num1, num2)
        "/" -> calc.divideOperation(DivideOperation(), num1, num2)
        else -> {
            println("알맞지 않은 연산자")
            0
        }
    }

    println("${num1} ${operation} ${num2} 결과는 : ${result} 입니다")
}

class Calculator() {
    fun addOperation(addOperation: AddOperation, num1: Int, num2: Int): Int {
        return addOperation.operate(num1, num2)
    }

    fun subtractOperation(subtractOperation: SubtractOperation, num1: Int, num2: Int): Int {
        return subtractOperation.operate(num1, num2)
    }

    fun multiplyOperation(multiplyOperation: MultiplyOperation, num1: Int, num2: Int): Int {
        return multiplyOperation.operate(num1, num2)
    }

    fun divideOperation(divideOperation: DivideOperation, num1: Int, num2: Int): Int {
        return divideOperation.operate(num1, num2)
    }
}

class AddOperation() {
    fun operate(num1: Int, num2: Int): Int = num1 + num2
}

class SubtractOperation() {
    fun operate(num1: Int, num2: Int): Int = num1 - num2
}

class MultiplyOperation() {
    fun operate(num1: Int, num2: Int): Int = num1 * num2
}
class DivideOperation() {
    fun operate(num1: Int, num2: Int): Int {
        if (num2 != 0) {
            return num1 / num2
        } else {
            println("0으로 나눌 수 없습니다.")
            return 0
        }
    }
}