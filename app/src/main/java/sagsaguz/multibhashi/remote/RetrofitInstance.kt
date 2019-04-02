package sagsaguz.multibhashi.remote

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sagsaguz.multibhashi.constant.Constants
import sagsaguz.multibhashi.model.Categories
import sagsaguz.multibhashi.model.Joke
import sagsaguz.multibhashi.model.Jokes
import sagsaguz.multibhashi.category.CategoryContract
import sagsaguz.multibhashi.jokes.JokeContract

object RetrofitInstance {

    private val retrofitInstance: Retrofit
        get() = Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

    val apiService: APIService
        get() = retrofitInstance.create(APIService::class.java)

    fun getCategoriesLiveData(view: CategoryContract){
        val mutableLiveData = MutableLiveData<ArrayList<String>>()
        val apiService = RetrofitInstance.apiService
        apiService.getCategories().enqueue(object : Callback<Categories>{
            override fun onFailure(call: Call<Categories>?, t: Throwable?) {
                view.showError()
            }
            override fun onResponse(call: Call<Categories>?, response: Response<Categories>?) {
                val categories = response!!.body()!!.getValue() as ArrayList<String>
                mutableLiveData.value = categories
                view.showResult(mutableLiveData)
            }
        })
    }

    fun getJokeLiveData(view: JokeContract, categoryName: String?){

        val mutableLiveData = MutableLiveData<ArrayList<Joke>>()
        val apiService = RetrofitInstance.apiService
        apiService.getJokes(categoryName).enqueue(object : Callback<Jokes>{
            override fun onFailure(call: Call<Jokes>?, t: Throwable?) {
                view.showError()
            }
            override fun onResponse(call: Call<Jokes>?, response: Response<Jokes>?) {
                val jokes = response!!.body()!!.getValue() as ArrayList<Joke>
                mutableLiveData.value = jokes
                view.showJokes(mutableLiveData)
            }
        })
    }

}
