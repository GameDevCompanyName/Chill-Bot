package examples.TavernBot

class Dish(private var name: String,
           private var description: String,
           private var photo: String) {

    fun getName(): String {
        return name
    }

    fun getDescription(): String {
        return description
    }

    fun getPhoto(): String {
        return photo
    }

    fun setName(newName: String) {
        this.name = newName
    }

    fun setDescription(newDescribtion: String) {
        this.description = newDescribtion
    }

    fun setPhoto(adress: String) {
        this.photo = adress
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Dish

        if (name != other.name) return false
        if (description != other.description) return false
        if (photo != other.photo) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + photo.hashCode()
        return result
    }

    override fun toString(): String{
        return name
    }
}