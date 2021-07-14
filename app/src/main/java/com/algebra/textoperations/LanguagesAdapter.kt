package com.algebra.textoperations

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LanguagesAdapter( val items : ArrayList< String >, val context: Context ) : RecyclerView.Adapter< LanguagesViewHolder >( )  {
    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int ): LanguagesViewHolder {
        return LanguagesViewHolder( LayoutInflater.from( context ).inflate( R.layout.language_list_item, parent, false ) )
    }

    override fun getItemCount( ): Int {
        return items.size
    }

    override fun onBindViewHolder( holder: LanguagesViewHolder, position: Int ) {
        holder?.tvLanguages?.text = items[position]
    }
}

class LanguagesViewHolder( view: View ) : RecyclerView.ViewHolder( view ) {
    val tvLanguages: TextView = view.findViewById( R.id.tvLanguage )
}