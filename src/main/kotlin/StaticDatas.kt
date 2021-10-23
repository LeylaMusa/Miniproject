interface AbstractStorage{
  fun addNoteToStorage(note: BaseNoteModel)
  fun getAllNotes():MutableList<BaseNoteModel>
}

class Storage: AbstractStorage{

  private val list=  mutableListOf<BaseNoteModel>()


    override fun addNoteToStorage(note: BaseNoteModel) {
      list.add(note)
    }

    override fun getAllNotes(): MutableList<BaseNoteModel> {
        return list
    }
}

class ExternalStorage : AbstractStorage{

    override fun addNoteToStorage(note: BaseNoteModel) {
        ExternalDatas.list.add(note)
    }

    override fun getAllNotes(): MutableList<BaseNoteModel> {
        return  ExternalDatas.list
    }

}



object ExternalDatas{
    val list= mutableListOf<BaseNoteModel>()
}