class NewArchiveWindow {
    fun crateNewArchive (nameSet : Set<String>) {
        println("Введите уникальное имя нового архива  или оставьте поле пустым для возврата в меню:")
        val paragraph = scannerString(nameSet)                          // Ввод имени нового архива
        if (paragraph.isNotEmpty()) {                                     // Если массив не пустой
            val newMap: MutableMap<String, String> = mutableMapOf()     // Создаем пустой массив заметок для нового архива
            dataList[paragraph] = newMap                             // Добавляем новый архив
            print("Архив успешно создан!\n")
        } else {
            print("Архив не создан!\n")
        }
        ArchiveListWindow().createListWindow()                          // Возврат в меню архивов
    }
}