package sagsaguz.multibhashi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Categories {

    @SerializedName("type")
    @Expose
    private var type: String? = null

    @SerializedName("value")
    @Expose
    private var value: List<String>? = null

    fun setType(type: String?) {
        this.type = type
    }

    fun getType(): String? {
        return type
    }

    fun setValue(value: List<String>?) {
        this.value = value
    }

    fun getValue(): List<String>? {
        return value
    }

}