 object MenuUtil {
     val storage=ExternalStorage()
    fun launchMenu(){
        println(" 1. Add new note ")
        println(" 2. Show all notes")
        println(" 3. Remove note from list ")
        println(" 4. Update specific note ")

        val operation:String? = InputUtil.getInput( "Type operation code ")


        when(operation){
            "1" -> { addNewNote()}
            OperationTypes.ADD_NOTE.value->{
              addNewNote()
            }
            "2"-> {
                showNotes()}
            OperationTypes.SHOW_NOTES.value->{
                showNotes()
            }
            "3" -> { removenotes()
            }
            OperationTypes.REMOVE_NOTE.value->{
                removenotes()
            }
            "4"-> {
                updatenotes()}
            OperationTypes.UPDATE_NOTE.value->{
             updatenotes()
            }
        }
    }

     fun addNewNote(){
         val noteType= InputUtil.getInput("Enter note type:1.Text, 2.Image,3.Music")
         when (noteType){
             "1"->{
                 val noteContent= InputUtil.getInput("Please write note")
                 val textNoteModel= TextNote(noteContent)
                 storage.addNoteToStorage(textNoteModel)
                 println("Note successfully added!")
             }
             "2"->{

                 val imageNoteModel= ImageNote()
                 val title = InputUtil.getInput("Enter title")
                 val filepath = InputUtil.getInput("Enter filepath ")
                 imageNoteModel.image=Image(title,filepath)
                 storage.addNoteToStorage(imageNoteModel)
                 println("Note successfully added!")}
             "3"->{
                 val musicNoteModel= MusicNote()
                 val title = InputUtil.getInput("Enter title")
                 val filepath = InputUtil.getInput("Enter filepath ")
                 musicNoteModel.music = Music(title,filepath)
                 storage.addNoteToStorage(musicNoteModel)
                 println("Note successfully added!")
             }
             else -> println("Unknown note type1")
         }

     }
     fun showNotes(){
         if (storage.getAllNotes().isEmpty()){
             println("List is empty")
         }
         for ((index,i) in storage.getAllNotes().withIndex()){
             i.printNote(index)
             //i.print(index)
         }
     }
     fun removenotes(){
       println("Index which you are prefer to remove")
         val indexofremovedData= readLine()?.toIntOrNull()
         indexofremovedData?.let {
             storage.getAllNotes().removeAt(it)
         }
     }
    fun updatenotes(){
        println("Write index which you are prefer update")
        val indexforUpdate = readLine()?.toIntOrNull()
            indexforUpdate?.let {
                val dataforUpdate= storage.getAllNotes().getOrNull(it)

                storage.getAllNotes().remove(dataforUpdate)
                when(dataforUpdate){
                    is TextNote ->{
                        println("By which value you want be update")
                        val newdata=readLine()
                        val textNote = TextNote()
                        textNote.text = newdata
                        storage.addNoteToStorage(textNote)
                    }
                    is MusicNote -> {
                        val musicNote = MusicNote()
                        val title = InputUtil.getInput("Enter new title")
                        val filepath = InputUtil.getInput("Enter new filepath")
                        musicNote.music = Music(title,filepath)
                        storage.addNoteToStorage(musicNote)
                    }
                    is ImageNote ->{
                        val imageNote=ImageNote()
                        val title = InputUtil.getInput("Enter new title ")
                        val filepath = InputUtil.getInput("Enter new duration ")
                        imageNote.image=Image(title,filepath)
                        storage.addNoteToStorage(imageNote)

                    }
                }
            }

    }


}

