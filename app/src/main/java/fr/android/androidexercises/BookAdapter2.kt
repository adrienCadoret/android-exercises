package fr.android.androidexercises

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class BookAdapter2(private val inflater: LayoutInflater, private val books: List<Book>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(inflater.inflate(R.layout.custom_view_item_book, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder.itemView as BookItemView).bindView(books[position])
    }

    override fun getItemCount(): Int {
        return books.size
    }

    internal inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
