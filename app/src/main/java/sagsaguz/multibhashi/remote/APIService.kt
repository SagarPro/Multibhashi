package sagsaguz.multibhashi.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import sagsaguz.multibhashi.model.Categories
import sagsaguz.multibhashi.model.Joke
import sagsaguz.multibhashi.model.Jokes

interface APIService {

    @GET("categories")
    fun getCategories(): Call<Categories>

    @GET("jokes/random/10")
    fun getJokes(@Query("CATEGORY_NAME") categoryName: String?): Call<Jokes>

}