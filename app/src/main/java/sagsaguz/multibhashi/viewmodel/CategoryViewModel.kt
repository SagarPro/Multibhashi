package sagsaguz.multibhashi.viewmodel

import android.arch.lifecycle.ViewModel
import sagsaguz.multibhashi.category.CategoryContract
import sagsaguz.multibhashi.remote.RetrofitInstance

class CategoryViewModel : ViewModel(){

    private val retrofitInstance = RetrofitInstance

    fun getCategoryLiveData(view: CategoryContract) {
        retrofitInstance.getCategoriesLiveData(view)
    }

}