import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.example.AtividadeM2Halloween.R

class MovieListAdapter(private val context: Context, private val images: Array<Int>, private val names: Array<String>) : BaseAdapter() {

    var selectedPosition: Int = -1
    private val favoriteStates = BooleanArray(images.size)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View? = convertView
        val viewHolder: ViewHolder
        if (view == null) {
            viewHolder = ViewHolder()
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.listadeitens, null, true)
            viewHolder.name = view.findViewById(R.id.name)
            viewHolder.image = view.findViewById(R.id.img)
            viewHolder.favoriteButton = view.findViewById(R.id.favoriteButton)

            view.tag = viewHolder
        } else {
            viewHolder = view.tag as ViewHolder
        }

        viewHolder.name?.text = names[position]
        viewHolder.image?.setImageResource(images[position])


        viewHolder.favoriteButton?.setImageResource(
            if (favoriteStates[position]) R.drawable.ic_star else R.drawable.ic_star_border
        )


        view?.setOnClickListener {

            favoriteStates[position] = !favoriteStates[position]


            viewHolder.favoriteButton?.setImageResource(
                if (favoriteStates[position]) R.drawable.ic_star else R.drawable.ic_star_border
            )


            selectedPosition = position
            notifyDataSetChanged()
        }

        return view!!
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return images.size
    }

    private inner class ViewHolder {
        var name: TextView? = null
        var image: ImageView? = null
        var favoriteButton: ImageButton? = null
    }
}

