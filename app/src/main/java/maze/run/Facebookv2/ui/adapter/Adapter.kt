package maze.run.Facebookv2.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_posts.view.*
import maze.run.Facebookv2.R
import maze.run.Facebookv2.pojo.Posts

class Adapter(var conxt: Context) : RecyclerView.Adapter<Adapter.viewholder>() {

    lateinit var list: List<Posts>

    fun setlist(data: List<Posts>) {
        list = data
    }

    class viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun find(item: Posts) {
            itemView.title.text = item.title
            itemView.body.text = item.body
            itemView.userid.text = item.id.toString()


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        return viewholder(
            LayoutInflater.from(
                conxt
            ).inflate(
                R.layout.layout_posts,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val items = list[position]
        holder.find(items)

    }
}