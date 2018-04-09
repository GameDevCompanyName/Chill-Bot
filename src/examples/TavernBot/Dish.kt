package examples.TavernBot

class Dish(private val name: String,
           private val description: String,
           private val photo: String){

    fun getName(): String{return name}

    fun getDescription(): String{return description}

    fun getPhoto(): String{return photo}

}