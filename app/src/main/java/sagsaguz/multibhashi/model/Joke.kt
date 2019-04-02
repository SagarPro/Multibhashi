package sagsaguz.multibhashi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Joke {

    @SerializedName("id")
    @Expose
    private var id: Int? = null

    @SerializedName("joke")
    @Expose
    private var joke: String? = null

    @SerializedName("categories")
    @Expose
    private var categories: List<String>? = null

    fun setId(id: Int?) {
        this.id = id
    }

    fun getId(): Int? {
        return id
    }

    fun setJoke(joke: String?) {
        this.joke = joke
    }

    fun getJoke(): String? {
        return joke
    }

    fun setCategories(categories: List<String>?) {
        this.categories = categories
    }

    fun getCategories(): List<String>? {
        return categories
    }

}