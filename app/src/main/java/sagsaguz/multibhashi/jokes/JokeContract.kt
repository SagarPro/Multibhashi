package sagsaguz.multibhashi.jokes

import android.arch.lifecycle.LiveData
import sagsaguz.multibhashi.model.Joke

interface JokeContract {

    fun showJokes(liveData: LiveData<ArrayList<Joke>>)

    fun showError()

}