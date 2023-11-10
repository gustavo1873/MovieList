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

        // Set the favorite button state based on the saved favorite state
        viewHolder.favoriteButton?.setImageResource(
            if (favoriteStates[position]) R.drawable.ic_star else R.drawable.ic_star_border
        )

        viewHolder.favoriteButton?.setOnClickListener {
            // Toggle the favorite state for the clicked item
            favoriteStates[position] = !favoriteStates[position]

            // Update the favorite button image accordingly
            viewHolder.favoriteButton?.setImageResource(
                if (favoriteStates[position]) R.drawable.ic_star else R.drawable.ic_star_border
            )
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
