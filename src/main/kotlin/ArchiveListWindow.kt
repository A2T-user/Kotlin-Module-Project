class ArchiveListWindow : AbstractListWindow (){
    override val title = "\nСписок архивов:\n\n0. Создать архив"

    // Возвращает массив ключей
    override fun getMenuList () : List<String> {
        // Перегоняем массив Set ключей в массив List, чтобы работать с индексами
        val menuList: MutableList<String> = mutableListOf()
        if (dataList.keys.isNotEmpty()) menuList.addAll(dataList.keys)
        return menuList
    }

    override fun processing (paragraph : Int, menuList : List<String>) {
        when (paragraph) {
            menuList.size + 1 -> {
                println("Завершение программы!")
                return
            }                        // Выход
            0 -> NewArchiveWindow().crateNewArchive(dataList.keys)   // Создать новый архив
            else -> {                                                       // Открыть архив по ключу
                val key = menuList[paragraph - 1]
                NoteListWindow(key).createListWindow()
            }
        }
    }
}