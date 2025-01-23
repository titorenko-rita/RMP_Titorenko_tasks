import kotlin.math.PI
import kotlin.math.pow

interface PaymentSystem {
    fun processPayment(amount: Double)
}

class PayPal : PaymentSystem {
    override fun processPayment(amount: Double) {
        println("Оплата через PayPal на сумму: $amount")
    }
}

class Stripe : PaymentSystem {
    override fun processPayment(amount: Double) {
        println("Оплата через Stripe на сумму: $amount")
    }
}

fun main() {
    while (true) {
        println("Выберите задачу для выполнения:")
        println("1. Класс 'Человек'")
        println("2. Наследование: Класс 'Работник' и 'Менеджер'")
        println("3. Полиморфизм: Животные")
        println("4. Абстрактный класс 'Транспорт'")
        println("5. Класс 'Книга' и 'Библиотека'")
        println("6. Инкапсуляция: Банк")
        println("7. Счетчик объектов")
        println("8. Площадь фигур")
        println("9. Наследование: Животные и их движения")
        println("10. Работа с коллекциями: Университет")
        println("11. Класс 'Магазин'")
        println("12. Интерфейс 'Платежная система'")
        println("13. Генерация уникальных идентификаторов")
        println("14. Класс 'Точка' и 'Прямоугольник'")
        println("15. Комплексные числа")
        println("16. Перегрузка операторов: Матрица")
        println("17. Создание игры с использованием ООП")
        println("18. Автоматизированная система заказов")
        println("19. Наследование: Электроника")
        println("20. Игра 'Крестики-нолики'")
        println("21. Выход из программы")

        when (readln().toIntOrNull()) {
            1 -> task1()
            2 -> task2()
            3 -> task3()
            4 -> task4()
            5 -> task5()
            6 -> task6()
            7 -> task7()
            8 -> task8()
            9 -> task9()
            10 -> task10()
            11 -> task11()
            12 -> task12()
            13 -> task13()
            14 -> task14()
            15 -> task15()
            16 -> task16()
            17 -> task17()
            18 -> task18()
            19 -> task19()
            20 -> task20()
            21 -> {
                println("Выход из программы.")
                return
            }
            else -> println("Неверный ввод. Попробуйте снова.")
        }
    }
}

fun task1() {
    class Person(var name: String, var age: Int, var gender: String) {
        fun printInfo() {
            println("Имя: $name, Возраст: $age, Пол: $gender")
        }

        fun increaseAge() {
            age++
        }

        fun changeName(newName: String) {
            name = newName
        }
    }

    val person = Person("Иван", 25, "Мужской")
    person.printInfo()
    person.increaseAge()
    person.printInfo()
    person.changeName("Алексей")
    person.printInfo()
}

fun task2() {
    open class Person(var name: String, var age: Int, var gender: String)

    open class Worker(name: String, age: Int, gender: String, var salary: Double) : Person(name, age, gender)

    class Manager(name: String, age: Int, gender: String, salary: Double, var subordinates: List<Worker>) :
        Worker(name, age, gender, salary)

    val worker = Worker("Иван", 30, "Мужской", 50000.0)
    val manager = Manager("Анна", 40, "Женский", 80000.0, listOf(worker))

    println("Менеджер: ${manager.name}, Зарплата: ${manager.salary}, Количество подчиненных: ${manager.subordinates.size}")
}

interface Animal {
    fun makeSound()
}

class Dog : Animal {
    override fun makeSound() {
        println("Гав-гав")
    }
}

class Cat : Animal {
    override fun makeSound() {
        println("Мяу-мяу")
    }
}

class Cow : Animal {
    override fun makeSound() {
        println("Муу-муу")
    }
}

fun task3() {
    val animals: List<Animal> = listOf(Dog(), Cat(), Cow())
    animals.forEach { it.makeSound() }
}

fun task4() {
    abstract class Transport {
        abstract fun move()
    }

    class Car : Transport() {
        override fun move() {
            println("Машина едет по дороге")
        }
    }

    class Bike : Transport() {
        override fun move() {
            println("Велосипед едет по дороге")
        }
    }

    val transport: List<Transport> = listOf(Car(), Bike())
    transport.forEach { it.move() }
}

fun task5() {
    class Book(val title: String, val author: String, val year: Int)

    class Library {
        private val books = mutableListOf<Book>()

        fun addBook(book: Book) {
            books.add(book)
        }

        fun searchByAuthor(author: String): List<Book> {
            return books.filter { it.author == author }
        }

        fun searchByYear(year: Int): List<Book> {
            return books.filter { it.year == year }
        }
    }

    val library = Library()
    library.addBook(Book("Книга 1", "Автор 1", 2000))
    library.addBook(Book("Книга 2", "Автор 2", 2005))

    println("Книги автора 'Автор 1': ${library.searchByAuthor("Автор 1").map { it.title }}")
    println("Книги 2005 года: ${library.searchByYear(2005).map { it.title }}")
}

fun task6() {
    class BankAccount(private val accountNumber: String, private var balance: Double) {
        fun deposit(amount: Double) {
            if (amount > 0) {
                balance += amount
                println("Пополнение: $amount. Баланс: $balance")
            } else {
                println("Ошибка: Неверная сумма.")
            }
        }

        fun withdraw(amount: Double) {
            if (amount > 0 && amount <= balance) {
                balance -= amount
                println("Снятие: $amount. Баланс: $balance")
            } else {
                println("Ошибка: Недостаточно средств или неверная сумма.")
            }
        }
    }

    val account = BankAccount("12345", 1000.0)
    account.deposit(200.0)
    account.withdraw(500.0)
}

class Counter {
    companion object {
        var count = 0
    }

    init {
        count++
    }
}

fun task7() {
    Counter()
    Counter()
    Counter()

    println("Количество объектов: ${Counter.count}")
}

fun task8() {
    abstract class Shape {
        abstract fun getArea(): Double
    }

    class Circle(private val radius: Double) : Shape() {
        override fun getArea(): Double {
            return PI * radius.pow(2)
        }
    }

    class Rectangle(private val width: Double, private val height: Double) : Shape() {
        override fun getArea(): Double {
            return width * height
        }
    }

    val circle = Circle(3.0)
    val rectangle = Rectangle(4.0, 5.0)

    println("Площадь круга: ${circle.getArea()}")
    println("Площадь прямоугольника: ${rectangle.getArea()}")
}

fun task9() {
    open class Animal {
        open fun move() {
            println("Животное движется")
        }
    }

    class Fish : Animal() {
        override fun move() {
            println("Рыба плавает")
        }
    }

    class Bird : Animal() {
        override fun move() {
            println("Птица летает")
        }
    }

    class Dog : Animal() {
        override fun move() {
            println("Собака бегает")
        }
    }

    val animals: List<Animal> = listOf(Fish(), Bird(), Dog())
    animals.forEach { it.move() }
}

fun task10() {
    class Student(val name: String, val group: String, val grade: Double)

    class University {
        private val students = mutableListOf<Student>()

        fun addStudent(student: Student) {
            students.add(student)
        }

        fun sortByName(): List<Student> {
            return students.sortedBy { it.name }
        }

        fun filterByGrade(minGrade: Double): List<Student> {
            return students.filter { it.grade >= minGrade }
        }
    }

    val university = University()
    university.addStudent(Student("Иван", "101", 4.5))
    university.addStudent(Student("Анна", "102", 3.8))

    println("Студенты по алфавиту: ${university.sortByName().map { it.name }}")
    println("Студенты с оценкой >= 4.0: ${university.filterByGrade(4.0).map { it.name }}")
}

fun task11() {
    class Product(val name: String, val price: Double, var quantity: Int)

    class Store {
        private val products = mutableListOf<Product>()

        fun addProduct(product: Product) {
            val existingProduct = products.find { it.name == product.name }
            if (existingProduct != null) {
                existingProduct.quantity += product.quantity
            } else {
                products.add(product)
            }
        }

        fun removeProduct(name: String) {
            products.removeIf { it.name == name }
        }

        fun findProductByName(name: String): Product? {
            return products.find { it.name == name }
        }

        fun getTotalPrice(): Double {
            return products.sumOf { it.price * it.quantity }
        }
    }

    val store = Store()
    store.addProduct(Product("Товар 1", 10.0, 2))
    store.addProduct(Product("Товар 2", 20.0, 1))
    store.addProduct(Product("Товар 1", 10.0, 1)) // Добавляем еще одну единицу "Товар 1"

    println("Общая стоимость товаров: ${store.getTotalPrice()}") // Ожидаемая стоимость: 50.0

    val foundProduct = store.findProductByName("Товар 1")
    println("Найденный товар: ${foundProduct?.name}, Количество: ${foundProduct?.quantity}")

    store.removeProduct("Товар 2")
    println("Общая стоимость товаров после удаления: ${store.getTotalPrice()}") // Ожидаемая стоимость: 30.0
}


fun task12() {
    val paymentSystems: List<PaymentSystem> = listOf(PayPal(), Stripe())
    paymentSystems.forEach { it.processPayment(100.0) }
}

// Задача 13: Генерация уникальных идентификаторов
class UniqueID {
    companion object {
        private var idCounter = 0

        // Генерация уникального идентификатора
        fun generateID(): Int {
            idCounter++
            return idCounter
        }

        // Сброс счетчика
        fun resetCounter() {
            idCounter = 0
        }
    }
}

fun task13() {
    println(UniqueID.generateID()) // 1
    println(UniqueID.generateID()) // 2
    UniqueID.resetCounter()         // Сброс счетчика
    println(UniqueID.generateID()) // 1
}


// Задача 14: Класс "Точка" и "Прямоугольник"
fun task14() {
    class Point(val x: Double, val y: Double)

    class Rectangle(val topLeft: Point, val bottomRight: Point) {
        init {
            require(topLeft.x <= bottomRight.x && topLeft.y >= bottomRight.y) {
                "Координаты точек некорректны: topLeft должна быть выше и левее bottomRight."
            }
        }

        fun getArea(): Double {
            val width = bottomRight.x - topLeft.x
            val height = topLeft.y - bottomRight.y
            return if (width > 0 && height > 0) width * height else 0.0
        }
    }

    val point1 = Point(0.0, 10.0)
    val point2 = Point(5.0, 0.0)
    val rectangle = Rectangle(point1, point2)
    println("Площадь прямоугольника: ${rectangle.getArea()}")
}


// Задача 15: Комплексные числа
fun task15() {
    class ComplexNumber(val real: Double, val imaginary: Double) {
        operator fun plus(other: ComplexNumber): ComplexNumber {
            return ComplexNumber(real + other.real, imaginary + other.imaginary)
        }

        operator fun minus(other: ComplexNumber): ComplexNumber {
            return ComplexNumber(real - other.real, imaginary - other.imaginary)
        }

        operator fun times(other: ComplexNumber): ComplexNumber {
            val realPart = real * other.real - imaginary * other.imaginary
            val imaginaryPart = real * other.imaginary + imaginary * other.real
            return ComplexNumber(realPart, imaginaryPart)
        }

        operator fun div(other: ComplexNumber): ComplexNumber {
            val denominator = other.real.pow(2) + other.imaginary.pow(2)
            val realPart = (real * other.real + imaginary * other.imaginary) / denominator
            val imaginaryPart = (imaginary * other.real - real * other.imaginary) / denominator
            return ComplexNumber(realPart, imaginaryPart)
        }

        override fun toString(): String {
            return "$real + ${imaginary}i"
        }
    }

    val complex1 = ComplexNumber(1.0, 2.0)
    val complex2 = ComplexNumber(2.0, 3.0)
    println("Сумма: ${complex1 + complex2}")
    println("Разница: ${complex1 - complex2}")
    println("Произведение: ${complex1 * complex2}")
    println("Частное: ${complex1 / complex2}")
}

// Задача 16: Перегрузка операторов: Матрица
fun task16() {
    class Matrix(private val rows: Int, private val columns: Int, initData: Array<DoubleArray>? = null) {
        private val data: Array<DoubleArray> = initData ?: Array(rows) { DoubleArray(columns) }

        operator fun plus(other: Matrix): Matrix {
            if (this.rows != other.rows || this.columns != other.columns) {
                throw IllegalArgumentException("Матрицы должны быть одинакового размера для сложения")
            }

            val result = Matrix(rows, columns)
            for (i in 0 until rows) {
                for (j in 0 until columns) {
                    result.data[i][j] = this.data[i][j] + other.data[i][j]
                }
            }
            return result
        }

        operator fun times(other: Matrix): Matrix {
            if (this.columns != other.rows) {
                throw IllegalArgumentException("Количество столбцов первой матрицы должно быть равно количеству строк второй матрицы")
            }

            val result = Matrix(this.rows, other.columns)
            for (i in 0 until this.rows) {
                for (j in 0 until other.columns) {
                    for (k in 0 until this.columns) {
                        result.data[i][j] += this.data[i][k] * other.data[k][j]
                    }
                }
            }
            return result
        }

        fun display() {
            for (row in data) {
                println(row.joinToString(", "))
            }
        }
    }

    val matrix1 = Matrix(2, 2, arrayOf(doubleArrayOf(1.0, 2.0), doubleArrayOf(3.0, 4.0)))
    val matrix2 = Matrix(2, 2, arrayOf(doubleArrayOf(5.0, 6.0), doubleArrayOf(7.0, 8.0)))

    println("Matrix 1:")
    matrix1.display()
    println("Matrix 2:")
    matrix2.display()

    val sum = matrix1 + matrix2
    println("Сумма матриц:")
    sum.display()

    val product = matrix1 * matrix2
    println("Произведение матриц:")
    product.display()
}

// Задача 17: Создание игры с использованием ООП
fun task17() {
    class Enemy(val name: String, var health: Int) {
        fun takeDamage(damage: Int) {
            health -= damage
            if (health < 0) health = 0
            println("$name получает $damage урона, текущее здоровье: $health")
        }
    }

    class Player(val name: String, var health: Int, var attackPower: Int) {
        fun attack(enemy: Enemy) {
            println("$name атакует ${enemy.name} на $attackPower единиц урона")
            enemy.takeDamage(attackPower)
        }

        fun heal(amount: Int) {
            health += amount
            println("$name исцеляет себя на $amount единиц здоровья, текущее здоровье: $health")
        }
    }

    class Weapon(val name: String, val damage: Int) {
        fun use(player: Player, enemy: Enemy) {
            println("${player.name} использует оружие $name, добавляя $damage к атаке!")
            val originalAttackPower = player.attackPower
            player.attackPower += damage
            player.attack(enemy)
            player.attackPower = originalAttackPower
        }
    }

    val player = Player("Игрок", 100, 20)
    val enemy = Enemy("Враг", 50)
    val sword = Weapon("Меч", 15)

    sword.use(player, enemy)
    player.heal(10)
    player.attack(enemy)
}


// Задача 18: Автоматизированная система заказов
fun task18() {
    class Product(val name: String, val price: Double)

    class Customer(val name: String)

    class Order(val customer: Customer, val products: List<Product>) {
        val id: Int = UniqueID.generateID()

        fun getTotalPrice(): Double {
            return products.sumOf { it.price }
        }

        fun displayOrderInfo() {
            println("Заказ #$id для клиента ${customer.name}")
            products.forEach { println("- ${it.name}: ${it.price} руб.") }
            println("Общая стоимость заказа: ${getTotalPrice()} руб.")
        }
    }

    val product1 = Product("Продукт 1", 200.0)
    val product2 = Product("Продукт 2", 150.0)
    val customer = Customer("Клиент")
    val order = Order(customer, listOf(product1, product2))
    order.displayOrderInfo()
}

// Задача 19: Наследование: Электроника
fun task19() {
    open class ElectronicDevice(val name: String, val brand: String) {
        open fun turnOn() {
            println("$name от $brand включен.")
        }

        open fun turnOff() {
            println("$name от $brand выключен.")
        }
    }

    class Smartphone(name: String, brand: String, val model: String) : ElectronicDevice(name, brand) {
        fun takePhoto() {
            println("$name $model делает фотографию.")
        }

        override fun turnOn() {
            println("$name $model от $brand включен как смартфон.")
        }

        override fun turnOff() {
            println("$name $model от $brand выключен как смартфон.")
        }
    }

    class Laptop(name: String, brand: String, val os: String) : ElectronicDevice(name, brand) {
        fun compileCode() {
            println("$name от $brand компилирует код на $os.")
        }

        override fun turnOn() {
            println("$name с операционной системой $os от $brand включен как ноутбук.")
        }

        override fun turnOff() {
            println("$name с операционной системой $os от $brand выключен как ноутбук.")
        }
    }

    // Пример использования
    val smartphone = Smartphone("iPhone", "Apple", "14 Pro Max")
    val laptop = Laptop("MacBook", "Apple", "macOS")

    smartphone.turnOn()
    smartphone.takePhoto()
    smartphone.turnOff()

    println()

    laptop.turnOn()
    laptop.compileCode()
    laptop.turnOff()
}


// Задача 20: Игра "Крестики-нолики"
fun task20() {
    class Player(val name: String, val symbol: Char)

    class Game {
        private val board = Array(3) { Array(3) { ' ' } }
        private var currentPlayer: Player? = null
        private val players = mutableListOf<Player>()
        private var isGameOver = false

        fun addPlayer(player: Player) {
            if (players.size < 2) {
                players.add(player)
            } else {
                println("Игра уже имеет двух игроков.")
            }
        }

        fun startGame() {
            if (players.size != 2) {
                println("Нужно два игрока, чтобы начать игру.")
                return
            }

            currentPlayer = players[0]
            isGameOver = false
            println("Игра началась!")
            displayBoard()

            while (!isGameOver) {
                println("${currentPlayer?.name}'s ход (${currentPlayer?.symbol}):")
                print("Введите строку (0-2): ")
                val row = readln().toIntOrNull() ?: continue
                print("Введите столбец (0-2): ")
                val col = readln().toIntOrNull() ?: continue
                if (makeMove(row, col)) break
            }
        }

        private fun makeMove(row: Int, col: Int): Boolean {
            if (row !in 0..2 || col !in 0..2 || board[row][col] != ' ') {
                println("Неверный ход!")
                return false
            }

            board[row][col] = currentPlayer!!.symbol
            displayBoard()

            if (checkWin()) {
                println("Игрок ${currentPlayer?.name} (${currentPlayer?.symbol}) победил!")
                isGameOver = true
                return true
            }

            if (board.all { row -> row.all { it != ' ' } }) {
                println("Ничья!")
                isGameOver = true
                return true
            }

            currentPlayer = if (currentPlayer == players[0]) players[1] else players[0]
            return false
        }

        private fun checkWin(): Boolean {
            for (i in 0..2) {
                if (board[i].all { it == currentPlayer?.symbol } || board.all { it[i] == currentPlayer?.symbol }) {
                    return true
                }
            }
            if (board[0][0] == currentPlayer?.symbol && board[1][1] == currentPlayer?.symbol && board[2][2] == currentPlayer?.symbol) {
                return true
            }
            if (board[0][2] == currentPlayer?.symbol && board[1][1] == currentPlayer?.symbol && board[2][0] == currentPlayer?.symbol) {
                return true
            }
            return false
        }

        private fun displayBoard() {
            for (row in board) {
                println(row.joinToString(" | "))
            }
            println("---------")
        }
    }

    val game = Game()
    game.addPlayer(Player("Игрок 1", 'X'))
    game.addPlayer(Player("Игрок 2", 'O'))
    game.startGame()
}

