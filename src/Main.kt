import kotlin.random.Random

fun alternatingSum()
{
    println("Введите количество чисел:")
    val n = readLine()?.toIntOrNull()

    if (n != null && n > 0)
    {
        var sum = 0
        var sign = 1
        for (i in 1..n)
        {
            println("Введите число:")
            val number = readLine()?.toIntOrNull()
            if (number != null)
            {
                sum += sign * number
                sign *= -1
            }
        }
        println("Знакочередующаяся сумма ряда: $sum")
    }
}

fun roads(): Pair <Int, Int>
{
    var roadNum = 0
    var maxHeight = 0

    println("Введите число дорог:")

    val n = readLine()?.toIntOrNull()
    if (n != null && n > 0)
    {
        for (i in 1..n)
        {
            println("Введите число туннелей для дороги $i:")
            val tunnelsNum = readLine()?.toIntOrNull()
            if (tunnelsNum != null && tunnelsNum > 0)
            {
                var min = 10000000
                for (j in 1..tunnelsNum)
                {
                    println("Введите высоту туннеля $j:")
                    val height = readLine()?.toIntOrNull()
                    if (height != null && height < min)
                        min = height
                }
                if (min > maxHeight)
                {
                    maxHeight = min
                    roadNum = i
                }
            }
        }
    }
    return Pair<Int, Int> (roadNum, maxHeight)
}


fun checkDoubleEvenNumber()
{
    println("Введите положительное трехзначное число:")
    val number = readLine()?.toIntOrNull()
    if (number != null && number in 100..999) {
        val digit1 = number / 100
        val digit2 = (number / 10) % 10
        val digit3 = number % 10
        val sum = digit1 + digit2 + digit3
        val mult = digit1 * digit2 * digit3
        val isDoubleEven = sum % 2 == 0 && mult % 2 == 0
        if (isDoubleEven) {
            println("Число $number является дважды четным.")
        } else {
            println("Число $number не является дважды четным.")
        }
        return
    }
    println("Введено некорректное число")
}

fun findLongestUniqueSubstring(input: String): String
{
    var longestSubstring = ""
    var currentSubstring = ""

    for (char in input) {
        if (currentSubstring.contains(char)) {
            if (currentSubstring.length > longestSubstring.length) {
                longestSubstring = currentSubstring
            }
            val charIndex = currentSubstring.indexOf(char)
            currentSubstring = currentSubstring.substring(charIndex + 1)
        }
        currentSubstring += char
    }

    if (currentSubstring.length > longestSubstring.length) {
        longestSubstring = currentSubstring
    }
    return longestSubstring
}


fun findMaxElements(matrix: Array<IntArray>): IntArray
{
    val maxElements = IntArray(matrix.size)
    for (i in matrix.indices) {
        var maxElement = Int.MIN_VALUE
        for (j in matrix[i].indices) {
            if (matrix[i][j] > maxElement) {
                maxElement = matrix[i][j]
            }
        }
        maxElements[i] = maxElement
    }
    return maxElements
}


fun main()
{
    //1
    alternatingSum()

    //2
    val result = roads()
    println("${result.first} ${result.second}")

    //3
    checkDoubleEvenNumber()

    //4
    println("Введите строку:")
    val input = readLine().toString()
    val longestSubstring = findLongestUniqueSubstring(input)
    println("Наибольшая подстрока в строке $input с уникальными символами: $longestSubstring")

    //5
    println("Введите количество строк в массиве:")
    val rows = readLine()?.toIntOrNull()
    println("Введите количество столбцов в массиве:")
    val columns = readLine()?.toIntOrNull()
    if (rows != null && columns != null && rows > 0 && columns > 0) {
        val matrix = Array(rows) { IntArray(columns) { Random.nextInt(100) } }
        println("Исходный двумерный массив:")
        for (row in matrix) {
            println(row.joinToString())
        }
        val maxElements = findMaxElements(matrix)
        println("Максимальные элементы из каждой строки:")
        println(maxElements.joinToString())
    }
    else
        println("Введены некорректные данные")
}