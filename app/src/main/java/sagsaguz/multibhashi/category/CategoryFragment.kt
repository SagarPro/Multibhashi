package sagsaguz.multibhashi.category

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import sagsaguz.multibhashi.DefaultFragment
import sagsaguz.multibhashi.R
import sagsaguz.multibhashi.adapter.ViewPagerAdapter
import sagsaguz.multibhashi.jokes.JokeFragment
import sagsaguz.multibhashi.network.Network
import sagsaguz.multibhashi.viewmodel.CategoryViewModel

class CategoryFragment : Fragment(), CategoryContract {

    private lateinit var pbCategory : ProgressBar
    private lateinit var vpCategory: ViewPager

    private lateinit var adapter : ViewPagerAdapter

    private var categoryViewModel = CategoryViewModel()

    val categoryList = ArrayList<String>()

    private var mContext: Context? = null

    companion object {
        fun newInstance(context: Context?): CategoryFragment {
            val categoryFragment = CategoryFragment()
            categoryFragment.mContext = context
            return categoryFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_category, container, false)

        pbCategory = view.findViewById(R.id.pbCategory)
        pbCategory.visibility = View.VISIBLE

        vpCategory = view.findViewById(R.id.vpCategory)

        categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel::class.java)
        categoryViewModel.getCategoryLiveData(this)

        return view
    }

    private fun setViewPager(){

        vpCategory.offscreenPageLimit = 1

        adapter = ViewPagerAdapter(fragmentManager)
        for (i in 0 until categoryList.size)
            adapter.addFrag(DefaultFragment.newInstance(categoryList[i], this))

        vpCategory.adapter = adapter

        pbCategory.visibility = View.GONE

    }

    override fun showResult(liveData: LiveData<ArrayList<String>>) {
        val categoryNames = liveData.value as ArrayList<String>
        categoryList.clear()
        categoryList.addAll(categoryNames)
        Log.d("MUTLIVE", categoryNames[1])
        setViewPager()
    }

    override fun showError() {
        if (!Network.isInternetAvaialble(mContext)) {
            Toast.makeText(mContext, "Internet not available", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(mContext, "Network Error! Please try again", Toast.LENGTH_SHORT).show()
        }
        pbCategory.visibility = View.GONE
    }

    override fun onItemClick(jokeType: String) {
        fragmentManager!!.beginTransaction().add(R.id.mainContainer, JokeFragment.newInstance(mContext, jokeType)).addToBackStack(null).commit()
    }


}