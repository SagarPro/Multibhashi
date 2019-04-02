package sagsaguz.multibhashi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Jokes {

    @SerializedName("type")
    @Expose
    private var type: String? = null

    @SerializedName("value")
    @Expose
    private var value: List<Joke>? = null

    fun setType(type: String?) {
        this.type = type
    }

    fun getType(): String? {
        return type
    }

    fun setValue(value: List<Joke>?) {
        this.value = value
    }

    fun getValue(): List<Joke>? {
        return value
    }

}