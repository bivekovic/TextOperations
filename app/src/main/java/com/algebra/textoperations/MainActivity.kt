package com.algebra.textoperations

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class MainActivity : AppCompatActivity() {

    private val          programmingLanguages : ArrayList< String > = ArrayList( )
    private lateinit var adapterJezika        : ArrayAdapter< String >

    private lateinit var swipe : SwipeRefreshLayout
    private lateinit var lView : ListView

    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )
        setContentView( R.layout.activity_main )

        initWidgets( )
        setupListeners( )
        addProgrammingLanguages( )

        adapterJezika = ArrayAdapter( this, android.R.layout.simple_list_item_1, programmingLanguages )
        lView.adapter = adapterJezika

    }

    private fun initWidgets( ) {
        swipe = findViewById( R.id.SwipeRefresh )
        lView = findViewById( R.id.ListView )
    }

    private fun setupListeners( ) {
        swipe.setOnRefreshListener {
            programmingLanguages.shuffle( )
            adapterJezika.notifyDataSetChanged( )
            swipe.isRefreshing = false
        }
    }

    private fun addProgrammingLanguages( ) {
        for( i in resources.getStringArray( R.array.jezici ) )
            programmingLanguages.add( i )
    }

    override fun onCreateOptionsMenu( menu: Menu? ): Boolean {
        menuInflater.inflate( R.menu.main_menu, menu )
        return super.onCreateOptionsMenu( menu )
    }

    override fun onOptionsItemSelected( item: MenuItem): Boolean {
        if( item.itemId==R.id.drugaAktivnost ) {
            val intent = Intent( this, MainActivity2::class.java )
            startActivity( intent )
        }
        return super.onOptionsItemSelected( item )
    }
}