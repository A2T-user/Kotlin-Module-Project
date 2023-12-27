// val archiveKey: String?
abstract class AbstractListWindow  {

    abstract val title: String

    // Создание окна меню и обработка ввода
    fun createListWindow () {
        val menuList = getMenuList()
        createMenu(menuList)
        val paragraph = scannerInt(menuList)
        processing(paragraph, menuList)
    }

    // Создает текст меню
    private fun createMenu (menuList: List<String>) {
        println(title)
        var i = 1
        for (name in menuList) {
            println("$i. $name")
            i++
        }
        println("$i. Выход\n\nВведите номер пункта меню:")
    }

    // Обработка введенного пункта меню
    abstract fun processing (paragraph : Int, menuList : List<String>)

    // Возвращает массив ключей *******************
    abstract fun getMenuList () : List<String>
}