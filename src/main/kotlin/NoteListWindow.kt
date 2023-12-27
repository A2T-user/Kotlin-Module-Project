class NoteListWindow (private val archiveKey: String): AbstractListWindow (){

    override val title = "\nАрхив '$archiveKey':\n\n0. Создать заметку"

    // Возвращает массив ключей
    override fun getMenuList () : List<String> {
        // Перегоняем массив Set ключей в массив List, чтобы работать с индексами
        return getNoteNameList(archiveKey)
    }

    override fun processing (paragraph : Int, menuList : List<String>) {
        val noteList = dataList[archiveKey]
        when (paragraph) {
            menuList.size + 1 -> ArchiveListWindow ().createListWindow()   // Выход
            0 -> {                                                         // Создать новую заметку
                if (noteList != null) {
                    NewNoteWindow(archiveKey).crateNewNote(noteList.keys)
                }
            }
            else -> {                                                      // Просмотр заметки по ключу
                val name = menuList[paragraph - 1]
                val text = noteList?.get(name) ?: ""
                ViewNoteWindow(name, text, archiveKey).createViewNotesWindow()
            }
        }
    }
}