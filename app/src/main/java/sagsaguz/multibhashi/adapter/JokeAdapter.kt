package sagsaguz.multibhashi.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import sagsaguz.multibhashi.R
import sagsaguz.multibhashi.model.Joke

class JokeAdapter : RecyclerView.Adapter<JokeAdapter.JokeViewHolder>() {

    private val jokeList = ArrayList<Joke>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_joke, parent, false)
        return JokeViewHolder(view)
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        val result = jokeList[position]
        holder.joke!!.text = result.getJoke()
    }

    override fun getItemCount(): Int {
        return jokeList.size
    }

    inner class JokeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var joke = itemView.findViewById<TextView>(R.id.joke)
    }

    fun addJokes(results: ArrayList<Joke>) {
        jokeList.addAll(results)
        notifyDataSetChanged()
    }

}
