import kotlin.math.pow

fun main() {
    while (true) {
        // Вывод списка задач
        println("Выберите задачу (1-20) или введите 21 для выхода:")
        println("1. Четное или нечетное число")
        println("2. Минимальное из трех чисел")
        println("3. Таблица умножения")
        println("4. Сумма чисел от 1 до N")
        println("5. Число Фибоначчи")
        println("6. Проверка простого числа")
        println("7. Обратный порядок чисел")
        println("8. Сумма четных чисел")
        println("9. Реверс строки")
        println("10. Количество цифр в числе")
        println("11. Факториал числа")
        println("12. Сумма цифр числа")
        println("13. Палиндром")
        println("14. Найти максимальное число в массиве")
        println("15. Сумма всех элементов массива")
        println("16. Количество положительных и отрицательных чисел")
        println("17. Простые числа в диапазоне")
        println("18. Подсчет гласных и согласных в строке")
        println("19. Перестановка слов в строке")
        println("20. Число Армстронга")
        println("21. Выход")

        // Считывание ввода
        val choice = readLine()?.toIntOrNull()

        when (choice) {
            1 -> {
                // Задача 1: Четное или нечетное число
                println("Введите число:")
                val number = readLine()?.toIntOrNull() ?: 0
                if (number % 2 == 0) {
                    println("Четное")
                } else {
                    println("Нечетное")
                }
            }
            2 -> {
                // Задача 2: Минимальное из трех чисел
                println("Введите три числа:")
                val a = readLine()?.toIntOrNull() ?: 0
                val b = readLine()?.toIntOrNull() ?: 0
                val c = readLine()?.toIntOrNull() ?: 0
                println("Минимальное число: ${minOf(a, b, c)}")
            }
            3 -> {
                // Задача 3: Таблица умножения
                println("Таблица умножения на 5:")
                for (i in 1..10) {
                    println("5 * $i = ${5 * i}")
                }
            }
            4 -> {
                // Задача 4: Сумма чисел от 1 до N
                println("Введите число N:")
                val n = readLine()?.toIntOrNull() ?: 0
                println("Сумма чисел от 1 до $n: ${(n * (n + 1)) / 2}")
            }
            5 -> {
                // Задача 5: Число Фибоначчи
                println("Введите число N (количество чисел Фибоначчи):")
                val n = readLine()?.toIntOrNull() ?: 0
                var a = 0
                var b = 1
                for (i in 1..n) {
                    println(a)
                    val next = a + b
                    a = b
                    b = next
                }
            }
            6 -> {
                // Задача 6: Проверка простого числа
                println("Введите число:")
                val number = readLine()?.toIntOrNull() ?: 0
                var isPrime = true
                for (i in 2..number / 2) {
                    if (number % i == 0) {
                        isPrime = false
                        break
                    }
                }
                println(if (isPrime && number > 1) "Число простое" else "Число не простое")
            }
            7 -> {
                // Задача 7: Обратный порядок чисел
                println("Введите число N:")
                val n = readLine()?.toIntOrNull() ?: 0
                for (i in n downTo 1) {
                    println(i)
                }
            }
            8 -> {
                // Задача 8: Сумма четных чисел
                println("Введите два числа A и B:")
                val a = readLine()?.toIntOrNull() ?: 0
                val b = readLine()?.toIntOrNull() ?: 0
                var sum = 0
                for (i in a..b) {
                    if (i % 2 == 0) sum += i
                }
                println("Сумма четных чисел: $sum")
            }
            9 -> {
                // Задача 9: Реверс строки
                println("Введите строку:")
                val inputString9 = readLine() ?: ""
                println("Реверс строки: ${inputString9.reversed()}")
            }
            10 -> {
                // Задача 10: Количество цифр в числе
                println("Введите число:")
                val number = readLine()?.toIntOrNull() ?: 0
                println("Количество цифр: ${number.toString().length}")
            }
            11 -> {
                // Задача 11: Факториал числа
                println("Введите число:")
                val n = readLine()?.toIntOrNull() ?: 0
                var fact = 1
                for (i in 1..n) {
                    fact *= i
                }
                println("Факториал числа $n: $fact")
            }
            12 -> {
                // Задача 12: Сумма цифр числа
                println("Введите число:")
                val number = readLine()?.toIntOrNull() ?: 0
                val sumOfDigits = number.toString().sumOf { it.toString().toInt() }
                println("Сумма цифр числа: $sumOfDigits")
            }
            13 -> {
                // Задача 13: Палиндром
                println("Введите строку:")
                val inputString13 = readLine() ?: ""
                val reversedString = inputString13.reversed()
                println(if (inputString13 == reversedString) "Палиндром" else "Не палиндром")
            }
            14 -> {
                // Задача 14: Найти максимальное число в массиве
                println("Введите размер массива:")
                val size = readLine()?.toIntOrNull() ?: 0
                val array = IntArray(size)
                println("Введите элементы массива:")
                for (i in 0 until size) {
                    array[i] = readLine()?.toIntOrNull() ?: 0
                }
                println("Максимальное число: ${array.maxOrNull()}")
            }
            15 -> {
                // Задача 15: Сумма всех элементов массива
                println("Введите размер массива:")
                val size = readLine()?.toIntOrNull() ?: 0
                val array = IntArray(size)
                println("Введите элементы массива:")
                for (i in 0 until size) {
                    array[i] = readLine()?.toIntOrNull() ?: 0
                }
                println("Сумма всех элементов: ${array.sum()}")
            }
            16 -> {
                // Задача 16: Количество положительных и отрицательных чисел
                println("Введите размер массива:")
                val size = readLine()?.toIntOrNull() ?: 0
                val array = IntArray(size)
                var positiveCount = 0
                var negativeCount = 0
                println("Введите элементы массива:")
                for (i in 0 until size) {
                    array[i] = readLine()?.toIntOrNull() ?: 0
                    if (array[i] > 0) positiveCount++
                    if (array[i] < 0) negativeCount++
                }
                println("Положительных чисел: $positiveCount")
                println("Отрицательных чисел: $negativeCount")
            }
            17 -> {
                // Задача 17: Простые числа в диапазоне
                println("Введите два числа A и B:")
                val a = readLine()?.toIntOrNull() ?: 0
                val b = readLine()?.toIntOrNull() ?: 0
                for (i in a..b) {
                    var isPrime = true
                    for (j in 2..i / 2) {
                        if (i % j == 0) {
                            isPrime = false
                            break
                        }
                    }
                    if (isPrime && i > 1) {
                        println(i)
                    }
                }
            }
            18 -> {
                // Задача 18: Подсчет гласных и согласных в строке
                println("Введите строку:")
                val inputString18 = readLine() ?: ""
                var vowels = 0
                var consonants = 0
                for (ch in inputString18) {
                    if (ch.lowercaseChar() in "aeiou") vowels++
                    else if (ch.isLetter()) consonants++
                }
                println("Гласных: $vowels, Согласных: $consonants")
            }
            19 -> {
                // Задача 19: Перестановка слов в строке
                println("Введите строку:")
                val inputString19 = readLine() ?: ""
                val words = inputString19.split(" ").reversed()
                println("Перестановка слов: ${words.joinToString(" ")}")
            }
            20 -> {
                // Задача 20: Число Армстронга
                println("Введите число:")
                val number = readLine()?.toIntOrNull() ?: 0
                val numStr = number.toString()
                val sumOfPowers = numStr.sumOf { (it.toString().toInt()).toDouble().pow(numStr.length).toInt() }
                println(if (sumOfPowers == number) "Число Армстронга" else "Не число Армстронга")
            }
            21 -> {
                // Выход из программы
                println("Выход из программы.")
                break
            }
            else -> {
                println("Неверный выбор, попробуйте снова.")
            }
        }
    }
}
