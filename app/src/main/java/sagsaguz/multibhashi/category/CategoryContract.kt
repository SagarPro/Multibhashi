package sagsaguz.multibhashi.category

import android.arch.lifecycle.LiveData

interface CategoryContract {

    fun showResult(liveData: LiveData<ArrayList<String>>)

    fun onItemClick(jokeType: String)

    fun showError()

}