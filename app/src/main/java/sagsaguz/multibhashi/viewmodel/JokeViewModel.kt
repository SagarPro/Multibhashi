package sagsaguz.multibhashi.viewmodel

import android.arch.lifecycle.ViewModel
import sagsaguz.multibhashi.model.Joke
import sagsaguz.multibhashi.jokes.JokeContract
import sagsaguz.multibhashi.remote.RetrofitInstance

class JokeViewModel : ViewModel(){

    private val retrofitInstance = RetrofitInstance

    fun getLiveData(view: JokeContract, categoryName: String?) {
        retrofitInstance.getJokeLiveData(view, categoryName)
    }

}
