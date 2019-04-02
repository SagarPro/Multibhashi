package sagsaguz.multibhashi

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import sagsaguz.multibhashi.category.CategoryContract

class DefaultFragment : Fragment() {

    lateinit var categoryName : TextView

    lateinit var category: String
    lateinit var categoryContract: CategoryContract

    companion object {
        fun newInstance(category: String, view: CategoryContract): DefaultFragment {
            val defaultFragment = DefaultFragment()
            defaultFragment.category = category
            defaultFragment.categoryContract = view
            return defaultFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_default, container, false)

        categoryName = view.findViewById(R.id.tvCategoryName)
        categoryName.text = category

        view.setOnClickListener {
            categoryContract.onItemClick(category)
        }

        return view
    }

}