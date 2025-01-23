import java.time.format.DateTimeParseException
import kotlin.math.pow
import kotlin.math.sqrt
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    // Функции для каждой задачи

    // Задача 1: Функция для нахождения максимума
    fun findMax(a: Int, b: Int): Int {
        if (a == b) throw IllegalArgumentException("Числа равны!")
        return if (a > b) a else b
    }

    // Задача 2: Калькулятор деления
    fun divide(a: Int, b: Int): Double {
        if (b == 0) throw ArithmeticException("Деление на ноль невозможно!")
        return a.toDouble() / b
    }

    // Задача 3: Конвертер строк в числа
    fun stringToInt(str: String): Int {
        return str.toIntOrNull() ?: throw NumberFormatException("Строка не может быть конвертирована в число")
    }

    // Задача 4: Проверка возраста
    fun checkAge(age: Int) {
        if (age < 0 || age > 150) throw IllegalArgumentException("Некорректный возраст")
    }

    // Задача 5: Нахождение корня
    fun findRoot(number: Double): Double {
        if (number < 0) throw IllegalArgumentException("Отрицательное число не может иметь корень")
        return sqrt(number)
    }

    // Задача 6: Факториал
    fun factorial(n: Int): Int {
        if (n < 0) throw IllegalArgumentException("Число должно быть неотрицательным")
        return if (n == 0) 1 else n * factorial(n - 1)
    }

    // Задача 7: Проверка массива на нули
    fun checkArrayForZeros(arr: Array<Int>) {
        if (arr.contains(0)) throw IllegalArgumentException("Массив содержит нули")
    }

    // Задача 8: Калькулятор возведения в степень
    fun power(base: Double, exponent: Int): Double {
        if (exponent < 0) throw IllegalArgumentException("Степень не может быть отрицательной")
        return base.pow(exponent)
    }

    // Задача 9: Обрезка строки
    fun truncateString(str: String, length: Int): String {
        if (length > str.length) throw IllegalArgumentException("Длина больше длины строки")
        return str.substring(0, length)
    }

    // Задача 10: Поиск элемента в массиве
    fun findElementInArray(arr: Array<Int>, element: Int) {
        if (!arr.contains(element)) throw NoSuchElementException("Элемент не найден")
    }

    // Задача 11: Конвертация в двоичную систему
    fun toBinary(num: Int): String {
        if (num < 0) throw IllegalArgumentException("Число должно быть положительным")
        return Integer.toBinaryString(num)
    }

    // Задача 12: Проверка делимости
    fun checkDivisibility(a: Int, b: Int) {
        if (b == 0) throw ArithmeticException("Деление на ноль")
        if (a % b == 0) {
            println("$a делится на $b")
        } else {
            println("$a не делится на $b")
        }
    }

    // Задача 13: Чтение элемента списка
    fun readElementFromList(list: List<Int>, index: Int): Int {
        if (index !in 0 until list.size) throw IndexOutOfBoundsException("Индекс выходит за пределы списка")
        return list[index]
    }

    // Задача 14: Парольная проверка
    class WeakPasswordException(message: String): Exception(message)

    fun checkPasswordStrength(password: String) {
        if (password.length < 8) throw WeakPasswordException("Пароль слишком слабый")
    }

    // Задача 15: Проверка даты
    fun checkDate(date: String) {
        try {
            java.time.LocalDate.parse(date, java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy"))
        } catch (e: DateTimeParseException) {
            throw DateTimeParseException("Неверный формат даты", date, 0)
        }
    }

    // Задача 16: Конкатенация строк
    fun concatenateStrings(str1: String?, str2: String?) {
        if (str1 == null || str2 == null) throw NullPointerException("Одна из строк равна null")
        println(str1 + str2)
    }

    // Задача 17: Остаток от деления
    fun remainder(a: Int, b: Int): Int {
        if (b == 0) throw ArithmeticException("Деление на ноль невозможно")
        return a % b
    }

    // Задача 18: Квадратный корень
    fun squareRoot(number: Double): Double {
        if (number < 0) throw IllegalArgumentException("Отрицательное число не может иметь квадратный корень")
        return sqrt(number)
    }

    // Задача 19: Конвертер температуры
    fun convertTemperature(celsius: Double): Double {
        if (celsius < -273.15) throw IllegalArgumentException("Температура не может быть ниже абсолютного нуля")
        return celsius * 9 / 5 + 32
    }

    // Задача 20: Проверка строки на пустоту
    fun checkEmptyString(str: String?) {
        if (str.isNullOrEmpty()) throw IllegalArgumentException("Строка пустая или равна null")
    }

    // Список задач
    val tasks = listOf(
        "1. Функция для нахождения максимума",
        "2. Калькулятор деления",
        "3. Конвертер строк в числа",
        "4. Проверка возраста",
        "5. Нахождение корня",
        "6. Факториал",
        "7. Проверка массива на нули",
        "8. Калькулятор возведения в степень",
        "9. Обрезка строки",
        "10. Поиск элемента в массиве",
        "11. Конвертация в двоичную систему",
        "12. Проверка делимости",
        "13. Чтение элемента списка",
        "14. Парольная проверка",
        "15. Проверка даты",
        "16. Конкатенация строк",
        "17. Остаток от деления",
        "18. Квадратный корень",
        "19. Конвертер температуры",
        "20. Проверка строки на пустоту",
        "21. Выход из программы"
    )

    // Вывод списка задач
    while (true) {
        println("Выберите задачу для выполнения:")
        tasks.forEach { println(it) }

        // Чтение выбора пользователя
        val choice = scanner.nextInt()

        when (choice) {
            1 -> {
                println("Введите два числа для поиска максимума:")
                val a1 = scanner.nextInt()
                val b1 = scanner.nextInt()
                try {
                    println("Максимальное число: ${findMax(a1, b1)}")
                } catch (e: Exception) {
                    println("Ошибка: ${e.message}")
                }
            }
            2 -> {
                println("Введите два числа для деления (делимое и делитель):")
                val a2 = scanner.nextInt()
                val b2 = scanner.nextInt()
                try {
                    println("Результат деления: ${divide(a2, b2)}")
                } catch (e: Exception) {
                    println("Ошибка: ${e.message}")
                }
            }
            3 -> {
                println("Введите строку для конвертации в число:")
                val str3 = scanner.next()
                try {
                    println("Результат конвертации: ${stringToInt(str3)}")
                } catch (e: Exception) {
                    println("Ошибка: ${e.message}")
                }
            }
            4 -> {
                println("Введите возраст:")
                val age = scanner.nextInt()
                try {
                    checkAge(age)
                    println("Возраст корректен")
                } catch (e: Exception) {
                    println("Ошибка: ${e.message}")
                }
            }
            5 -> {
                println("Введите число для нахождения корня:")
                val number = scanner.nextDouble()
                try {
                    println("Корень числа: ${findRoot(number)}")
                } catch (e: Exception) {
                    println("Ошибка: ${e.message}")
                }
            }
            6 -> {
                println("Введите число для вычисления факториала:")
                val n = scanner.nextInt()
                try {
                    println("Факториал: ${factorial(n)}")
                } catch (e: Exception) {
                    println("Ошибка: ${e.message}")
                }
            }
            7 -> {
                println("Введите массив чисел, разделённых пробелом:")
                val arr = scanner.next().split(" ").map { it.toInt() }.toTypedArray()
                try {
                    checkArrayForZeros(arr)
                    println("Массив не содержит нулей")
                } catch (e: Exception) {
                    println("Ошибка: ${e.message}")
                }
            }
            8 -> {
                println("Введите основание и степень:")
                val base = scanner.nextDouble()
                val exponent = scanner.nextInt()
                try {
                    println("Результат возведения в степень: ${power(base, exponent)}")
                } catch (e: Exception) {
                    println("Ошибка: ${e.message}")
                }
            }
            9 -> {
                println("Введите строку и количество символов для обрезки:")
                val str = scanner.next()
                val length = scanner.nextInt()
                try {
                    println("Обрезанная строка: ${truncateString(str, length)}")
                } catch (e: Exception) {
                    println("Ошибка: ${e.message}")
                }
            }
            10 -> {
                println("Введите массив чисел и элемент для поиска:")
                try {
                    val input = readln().split(" ").map { it.toInt() } // Ввод массива
                    val elementToFind = readln().toInt()              // Ввод элемента для поиска
                    if (input.contains(elementToFind)) {
                        println("Элемент найден")
                    } else {
                        throw NoSuchElementException("Элемент не найден")
                    }
                } catch (e: Exception) {
                    println("Ошибка: ${e.message}")
                }
            }
            11 -> {
                println("Введите число для конвертации в двоичную систему:")
                val num = scanner.nextInt()
                try {
                    println("Число в двоичной системе: ${toBinary(num)}")
                } catch (e: Exception) {
                    println("Ошибка: ${e.message}")
                }
            }
            12 -> {
                println("Введите два числа для проверки делимости:")
                val a = scanner.nextInt()
                val b = scanner.nextInt()
                try {
                    checkDivisibility(a, b)
                } catch (e: Exception) {
                    println("Ошибка: ${e.message}")
                }
            }
            13 -> {
                println("Введите список чисел (через пробел):")
                try {
                    val input = readln().split(" ").map { it.toInt() } // Ввод списка чисел
                    println("Введите индекс для чтения элемента:")
                    val index = readln().toInt()                     // Ввод индекса
                    if (index in input.indices) {                    // Проверка диапазона индекса
                        println("Элемент на индексе $index: ${input[index]}")
                    } else {
                        throw IndexOutOfBoundsException("Индекс $index выходит за пределы списка. Доступный диапазон: 0..${input.size - 1}")
                    }
                } catch (e: Exception) {
                    println("Ошибка: ${e.message}")
                }
            }
            14 -> {
                println("Введите пароль для проверки:")
                val password = scanner.next()
                try {
                    (password)
                    println("Пароль достаточно сильный")
                } catch (e: Exception) {
                    println("Ошибка: ${e.message}")
                }
            }
            15 -> {
                println("Введите дату в формате dd.MM.yyyy:")
                val date = scanner.next()
                try {
                    checkDate(date)
                    println("Дата корректна")
                } catch (e: Exception) {
                    println("Ошибка: ${e.message}")
                }
            }
            16 -> {
                println("Введите две строки для конкатенации:")
                val str1 = scanner.next()
                val str2 = scanner.next()
                try {
                    concatenateStrings(str1, str2)
                } catch (e: Exception) {
                    println("Ошибка: ${e.message}")
                }
            }
            17 -> {
                println("Введите два числа для нахождения остатка от деления:")
                val a = scanner.nextInt()
                val b = scanner.nextInt()
                try {
                    println("Остаток от деления: ${remainder(a, b)}")
                } catch (e: Exception) {
                    println("Ошибка: ${e.message}")
                }
            }
            18 -> {
                println("Введите число для нахождения квадратного корня:")
                val number = scanner.nextDouble()
                try {
                    println("Квадратный корень: ${squareRoot(number)}")
                } catch (e: Exception) {
                    println("Ошибка: ${e.message}")
                }
            }
            19 -> {
                println("Введите температуру в Цельсиях для конвертации:")
                val celsius = scanner.nextDouble()
                try {
                    println("Температура в Фаренгейтах: ${convertTemperature(celsius)}")
                } catch (e: Exception) {
                    println("Ошибка: ${e.message}")
                }
            }
            20 -> {
                println("Введите строку для проверки на пустоту:")
                val str = scanner.next()
                try {
                    checkEmptyString(str)
                    println("Строка не пустая")
                } catch (e: Exception) {
                    println("Ошибка: ${e.message}")
                }
            }
            21 -> {
                println("Выход из программы")
                break
            }
            else -> {
                println("Некорректный ввод. Попробуйте снова.")
            }
        }
    }
}