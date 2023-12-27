import java.util.Scanner

// Структура для хранения данных : Map< archiveName, Map< noteName, noteText >>
var dataList = mutableMapOf<String, MutableMap<String, String>>()

val scanner = Scanner(System.`in`)



// Принимает ввод числа от пользователя, проверяет его и возвращает, если прошел проверку
fun scannerInt (menuList: List<String>) : Int {
    val enteredNumberStr = scanner.nextLine()
    return when (enteredNumberStr.toIntOrNull()) {
        null -> {       // Строка не конвертируется в Int
            println("Ошибка: Введенное значение не является целым числом!\nПовторите ввод:")
            scannerInt(menuList)     // Повторяем ввод
        }
        else -> {       // Строка конвертируется в Int
            val enteredNumber : Int = enteredNumberStr.toInt()
            if (enteredNumber < 0 || enteredNumber > menuList.size + 1) {    // Число вне диапазона
                println("Ошибка: В меню нет пункта с таким номером!\nПовторите ввод:")
                scannerInt(menuList)
            } else {        // Подходящее число
                enteredNumber
            }
        }
    }
}

// Принимает ввод строки от пользователя, проверяет ее и возвращает, если прошла проверку
fun scannerString (menuSet: Set<String>) : String {
    // Запрос имени, и обрезание начальных и конечных пробелов
    val enteredString = scanner.nextLine().trim()
    // Создаем мутабельную копию menuSet
    val menuMutableSet: MutableSet<String> = mutableSetOf()
    menuMutableSet.addAll(menuSet)
    return when {
        menuMutableSet.add(enteredString) -> enteredString      // Если имя уникальное
        enteredString.isEmpty() -> ""                           // Если пустая строка
        else -> {                                               // Если такая строка уже есть в массиве,
            println("Ошибка: Такое имя уже есть!\nВведите уникальное имя:")     // повтор ввода
            scannerString(menuSet)
        }
    }
}

fun scannerText () : String {
    // Запрашиваем текст заметки, обрезаем начальные и конечные пробелы
    val text = scanner.nextLine().trim()
    return text.ifEmpty { "" }
}
// Возвращает массив имен заметок
fun getNoteNameList (archiveKey: String) : List<String> {
    // Перегоняем массив Set ключей в массив List, чтобы работать с индексами
    val menuList: MutableList<String> = mutableListOf()
    val menuMap: Map<String, String>? = dataList[archiveKey]
    if (menuMap != null) menuList.addAll(menuMap.keys)
    return menuList
}