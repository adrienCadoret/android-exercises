package fr.android.androidexercises

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.custom_view_item_book.view.*

class BookItemView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : LinearLayout(context, attrs, defStyleAttr) {

    fun bindView(book: Book) {
        // TODO setText()
        nameTextView.text = book.name
        priceTextView.text = book.price.toString()
    }
}
