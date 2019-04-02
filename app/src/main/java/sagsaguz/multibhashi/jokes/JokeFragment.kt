package sagsaguz.multibhashi.jokes

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import sagsaguz.multibhashi.R
import sagsaguz.multibhashi.adapter.JokeAdapter
import sagsaguz.multibhashi.model.Joke
import sagsaguz.multibhashi.network.Network
import sagsaguz.multibhashi.viewmodel.JokeViewModel

class JokeFragment : Fragment(), JokeContract {

    private lateinit var pbJoke : ProgressBar
    private lateinit var recyclerViewJokeList: RecyclerView

    private var jokeViewModel = JokeViewModel()

    private var mContext: Context? = null
    private var categoryName: String? = null

    private lateinit var adapter : JokeAdapter

    companion object {
        fun newInstance(context: Context?, categoryName: String): JokeFragment {
            val jokeFragment = JokeFragment()
            jokeFragment.mContext = context
            jokeFragment.categoryName = categoryName
            return jokeFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_joke, container, false)

        pbJoke = view.findViewById(R.id.pbJoke)
        pbJoke.visibility = View.VISIBLE

        adapter = JokeAdapter()
        recyclerViewJokeList = view.findViewById(R.id.recyclerViewJokeList)
        recyclerViewJokeList.layoutManager = LinearLayoutManager(mContext)
        recyclerViewJokeList.adapter = adapter

        Log.d("MMMM", categoryName)

        jokeViewModel = ViewModelProviders.of(this).get(JokeViewModel::class.java)
        jokeViewModel.getLiveData(this, categoryName)

        return view
    }

    override fun showJokes(liveData: LiveData<ArrayList<Joke>>) {
        val jokes = liveData.value as ArrayList<Joke>
        adapter.addJokes(jokes)
        pbJoke.visibility = View.GONE
    }

    override fun showError() {
        val network = Network
        if (!Network.isInternetAvaialble(mContext)) {
            Toast.makeText(mContext, "Internet not available", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(mContext, "Network Error! Please try again", Toast.LENGTH_SHORT).show()
        }
        pbJoke.visibility = View.GONE
    }

}