package fr.android.androidexercises

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.activity_library.*


import java.util.ArrayList
import java.util.Locale
import java.util.Random

class LibraryActivity : AppCompatActivity() {

    private val books: List<Book>
        get() {
            val books = ArrayList<Book>()
            for (i in 0..99) {
                books.add(Book(
                        String.format(Locale.FRANCE, "Garry Potier Tome %d", i),
                        RANDOM.nextInt(30).toFloat())
                )
            }
            return books
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        val books = books

        // TODO findViewById() and setAdapter()
        val isLandscape = resources.getBoolean(R.bool.landscape)
        val adapter = BookAdapter2(LayoutInflater.from(this), books)
        bookListView.layoutManager = GridLayoutManager(this, if (isLandscape) 2 else 1)
        bookListView.adapter = adapter
    }

    companion object {

        private val RANDOM = Random()
    }

}
