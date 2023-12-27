class ViewNoteWindow (private val name : String, private val text : String, private val archiveKey: String) {

    fun createViewNotesWindow () {
        println("\nЗаметка '$name'\n")
        println("Текст:\n$text")
        println("\nДля возврата к меню нажмите 'Enter'")
        scanner.nextLine()
        NoteListWindow(archiveKey).createListWindow()
    }
}