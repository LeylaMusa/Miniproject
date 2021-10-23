import java.util.*

abstract class BaseNoteModel(val id: String? = UUID.randomUUID().toString()) {

    abstract fun printNote(index:Int)
}

    class TextNote(var text: String? = null) : BaseNoteModel() {

      override  fun printNote(index: Int) {
            println("${index}. Content: $text")
        }

        //override fun print(index: Int) {
        // printNote(index)
    }
    //fun getNote(){

    //}
    //fun getNote(index: Int){

    // }


    class ImageNote : BaseNoteModel() {
        var image: Image? = null
      override  fun printNote(index: Int) {
            println("${index}. Image: ${image?.title} ${image?.filePath}")
        }

    }

    class MusicNote : BaseNoteModel() {
        var music: Music? = null;
       override fun printNote(index: Int) {
            println("${index}. Music: ${music?.title} ${music?.duration} ")
        }


    }
