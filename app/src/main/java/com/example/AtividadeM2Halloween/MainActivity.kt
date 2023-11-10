package com.example.AtividadeM2Halloween

import MovieListAdapter
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.ListView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.example.AtividadeM2Halloween.database.AppDatabase
import com.example.AtividadeM2Halloween.ui.theme.AtividadeM2HalloweenTheme


class MainActivity : ComponentActivity() {

    var isFavorite = false

    companion object {
        lateinit var database: AppDatabase
    }

    private val name = arrayOf("Pearl", "Panico VI", "Panico V", "Sorria", "M3GAN", "A Freira",
        "A Freira 2", "Nós", "Corra!", "Invocacao do Mal")

    private val image = arrayOf(R.drawable.pearl, R.drawable.panico6, R.drawable.panico5, R.drawable.sorria, R.drawable.m3gan,
        R.drawable.freira, R.drawable.freira2, R.drawable.nos, R.drawable.corra, R.drawable.invocacao)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ListView>(R.id.list_view).adapter = MovieListAdapter(this, image, name)

        val favoriteButton = findViewById<ImageButton>(R.id.favoriteButton)

        favoriteButton.setOnClickListener {
            isFavorite = !isFavorite
            if (isFavorite) {
                favoriteButton.setImageResource(R.drawable.ic_star)
            } else {
                favoriteButton.setImageResource(R.drawable.ic_star_border)
            }
        }
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "app-database"
        ).build()
    }



}
