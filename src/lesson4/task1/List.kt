@file:Suppress("UNUSED_PARAMETER")
package lesson4.task1

import lesson1.task1.discriminant
import lesson1.task1.sqr
import lesson3.task1.isPrime
import java.lang.Math.sqrt

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
        when {
            y < 0 -> listOf()
            y == 0.0 -> listOf(0.0)
            else -> {
                val root = Math.sqrt(y)
                // Результат!
                listOf(-root, root)
            }
        }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double {
    var res = 0.0
    for (i in 0 until v.size){
        res += sqr(v[i])
    }
    return sqrt(res)
}


/**
 * Простая
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double {
    val res: Double
    if (list.isEmpty()) return 0.0
    else res = list.sum() / list.size
    return res
}

/**
 * Средняя
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> = TODO()

/**
 * Средняя
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.0.
 */
fun times(a: List<Double>, b: List<Double>): Double = TODO()

/**
 * Средняя
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0.0 при любом x.
 */
fun polynom(p: List<Double>, x: Double): Double = TODO()

/**
 * Средняя
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Double>): MutableList<Double> = TODO()

/**
 * Средняя
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> = TODO()

/**
 * Сложная
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 */
fun factorizeToString(n: Int): String{
    val res = mutableListOf<Int>()
    var k = n
    var i = 2
    if (isPrime(k)) return k.toString()
    while (k != 1) {
        if ((isPrime(i)) && (k % i == 0)) {
            res.add(i)
            k /= i
        }
        else i++
    }
    return res.joinToString(separator = "*")
}

/**
 * Средняя
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> = TODO()

/**
 * Сложная
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 */
fun convertToString(n: Int, base: Int): String = TODO()

/**
 * Средняя
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int = TODO()

/**
 * Сложная
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 */
fun decimalFromString(str: String, base: Int): Int = TODO()

/**
 * Сложная
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String {
    var k = n
    val rom = listOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
    val numb = listOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
    var fin = ""
    var i = 0
    while (k > 0) {
        if (k - numb[i] >= 0) {
            k -= numb[i]
            fin += rom[i]
        }
        else i++
    }
    return fin
}

/**
 * Очень сложная
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun amount(n: Int): Int {
    var k = n
    var i = 0
    while (k > 0){
        k /= 10
        i++
    }
    return i
}

fun russian(n: Int): String {
    var k = n
    val res = mutableListOf<String>()
    val list1 = listOf<String>("один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять")
    val list1_1 = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val list2 = listOf<String>("десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто")
    val list2_2 = listOf<Int>(10, 20, 30, 40, 50, 60, 70, 80, 90)
    val list3 = listOf<String>("сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот")
    val list3_3 = listOf<Int>(100, 200, 300, 400, 500, 600, 700, 800, 900)
    val list4 = listOf<String>("тысяч", "тысячи", "тысяча")
    val list5 = listOf<String>("одна", "две")
    val list6 = listOf<String>("одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать")
    val list6_6 = listOf<Int>(11, 12, 13, 14, 15, 16, 17, 18, 19)
        for (i in 0 until 9) {
            if (k / 1000 - list3_3[i] == 0 && amount(k) == 6 && k / 1000 % 100 == 0) {
                res.add(list3[i])
                res.add(list4[0])
                k -= list3_3[i] * 1000
                break
            }
            if (k / 1000 - k / 1000 % 100  - list3_3[i] == 0 && amount(k) == 6) {
                res.add(list3[i])
                k -= list3_3[i] * 1000
            }
        }
        for (i in 0 until 9) {
            if (k / 1000 - k / 1000 % 10 - list2_2[i] == 0 && k / 1000 % 100 !in 11..19 && amount(k) == 5) {
                res.add(list2[i])
                k -= list2_2[i] * 1000
            }
            if (k / 1000 % 100 - list6_6[i] == 0 && amount(k) == 5) {
                res.add(list6[i])
                res.add(list4[0])
                k -= list6_6[i] * 1000
            }
        }
        if (k / 1000 % 10 - list1_1[0] == 0 && k / 1000 % 100 !in 11..19 && amount(k) == 4) {
            res.add(list5[0])
            res.add(list4[2])
            k -= list1_1[0] * 1000
        }
        for (i in 2..3)
            if (k / 1000 % 10 - list1_1[i] == 0 && k / 1000 % 100 !in 11..19 && amount(k) == 4) {
                res.add(list1[i])
                res.add(list4[1])
                k -= list1_1[i] * 1000
            }
        if (k / 1000 % 10 - list1_1[1] == 0 && k / 1000 % 100 !in 11..19 && amount(k) == 4) {
            res.add(list5[1])
            res.add(list4[1])
            k -= list1_1[1] * 1000
        }
        for (i in 4..8)
            if (k / 1000 % 10 - list1_1[i] == 0 && k / 1000 % 100 !in 11..19 && amount(k) == 4) {
                res.add(list1[i])
                res.add(list4[0])
                k -= list1_1[i] * 1000
            }
        for (i in 0..8)
            if (k - k % 100 - list3_3[i] == 0 && amount(k) == 3) {
                res.add(list3[i])
                k -= list3_3[i]
                break
            }
        for (i in 0 until 9) {
            if (k - k % 10 - list2_2[i] == 0 && k % 100 !in 11..19 && amount(k) == 2) {
                res.add(list2[i])
                k -= list2_2[i]
            }
            if (k % 100 - list6_6[i] == 0 && amount(k) == 2) {
                res.add(list6[i])
                k -= list6_6[i]
            }
        }
        for (i in 0..8)
            if (k % 10 - list1_1[i] == 0 && amount(k) == 1) {
                res.add(list1[i])
                k -= list1_1[i]
            }
    return res.joinToString(separator = " ")
}