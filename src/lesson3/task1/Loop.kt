@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import java.lang.Math.*


/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result *= i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    for (m in 2..Math.sqrt(n.toDouble()).toInt()) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
        when {
            n == m -> 1
            n < 10 -> 0
            else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
        }

/**
 * Тривиальная
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 */
fun digitNumber(n: Int): Int {
    var count = 0
    var number = n
    if (number == 0)
        return 1
    else
        while (number != 0) {
            count++
            number /= 10
        }
    return count
}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var a = 0
    var b = 1
    for (i in 2..n) {
        val c = b
        b += a
        a = c
    }
    return if ((n == 1) || (n == 2)) 1
    else b
}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var k = 1
    while ((k % n != 0) || (k % m != 0)) {
        k++
    }
    return k
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var del = 2
    while (n % del != 0) {
        del++
    }
    return del
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var del = n - 1
    while (n % del != 0) {
        del--
    }
    return del
}


/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    var del = 2
    while (del <= m || del <= n) {
        if (m % del == 0 && n % del == 0) return false
        else del++
    }
    return true
}

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    for (i in 0..Math.round(sqrt(n.toDouble()))) {
        if ((i * i >= m) && (i * i <= n)) return true
    }
    return false
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun sin(x: Double, eps: Double): Double {
    var k = x
    while (abs(k) > 2 * PI) {
        if (k > 0) k -= 2 * PI
        else k += 2 * PI
    }
    var z = k
    var y = k
    var i = 0
    while (abs(y) >= eps) {
        i++
        y = pow(k, ((2 * i) + 1).toDouble()) / factorial(2 * i + 1)
        if (i % 2 == 1) z -= y
        else z += y
    }
    return z
}


/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun cos(x: Double, eps: Double): Double {
    var k = x
    while (abs(k) > 2 * PI) {
        if (k > 0) k -= 2 * PI
        else k += 2 * PI
    }
    var z = 1.0
    var y = z
    var i = 0
    while (abs(y) >= eps) {
        i++
        y = pow(k, (2 * i).toDouble()) / factorial(2 * i)
        if (i % 2 == 1) z -= y
        else z += y
    }
    return z
}

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 * Не использовать строки при решении задачи.
 */
fun revert(n: Int): Int {
    var s = 0
    var x = n
    while (x > 0) {
        val k = x % 10
        s = s * 10 + k
        x /= 10
    }
    return s
}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 */
fun isPalindrome(n: Int): Boolean = revert(n) == n

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 */
fun hasDifferentDigits(n: Int): Boolean {
    var x = n
    if (x < 9) return false
    else
        while (x > 10) {
            val k = x % 10
            val s = x % 100 / 10
            if (k == s) x /= 100
            else return true
        }
    return false
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 */
fun squareSequenceDigit(n: Int): Int {
    var s = 0
    var k = 0
    var x = 0
    val del = 10
    while (s < n) {
        k++
        x = k * k
        var count = 0
        var b = x
        while (b > 0) {
            count++
            b /= del
        }
        s += count
    }
    if (s == n) return x % 10
    else while (s != n) {
        x /= 10
        s--
    }
    return x % 10
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 */
fun fibSequenceDigit(n: Int): Int {
    var s = 0
    var k = 0
    var x = 0
    val del = 10
    while (s < n) {
        k++
        x = fib(k)
        var count = 0
        var b = x
        while (b > 0) {
            count++
            b /= del
        }
        s += count
    }
    if (s == n) return x % 10
    else while (s != n) {
        x /= 10
        s--
    }
    return x % 10
}
