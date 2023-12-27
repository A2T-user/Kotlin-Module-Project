class NewNoteWindow (private val archiveKey: String){

    fun crateNewNote (nameSet : Set<String>) {
        // Запрос имени заметки
        println("Введите уникальное имя новой заметки или оставьте поле пустым для возврата в меню:")
        val paragraph = scannerString(nameSet)                  // Ввод имени нового архива
        // Запрос текста заметки, обрезаем начальные и конечные пробелы
        if (paragraph.isNotEmpty()) {
            println("Введите текст заметки или оставьте поле пустым для возврата в меню:")
            val text = scannerText()
            if (text.isNotEmpty()) {
                // Сохранение заметки
                val noteList = dataList[archiveKey]
                if (noteList != null) {
                    noteList[paragraph] = text
                    println("Заметка успешно создана!\n")
                }
            } else {
                print("Заметка не создана!\n")
            }
        } else {
            print("Заметка не создана!\n")
        }
        // Возврат в меню заметки
        NoteListWindow(archiveKey).createListWindow()
    }
}