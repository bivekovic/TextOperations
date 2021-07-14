package com.algebra.textoperations

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {
    private val          programmingLanguages : ArrayList< String > = ArrayList( )
    private val          displayedLanguages   : ArrayList< String > = ArrayList( )
    private lateinit var rView                : RecyclerView
    private lateinit var search               : SearchView

    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )
        setContentView( R.layout.activity_main2 )

        addProgrammingLanguages( )
        initWidgets( )
    }

    fun initWidgets( ) {
        rView               = findViewById( R.id.recycler )
        rView.layoutManager = LinearLayoutManager( this )
        rView.adapter       = LanguagesAdapter( displayedLanguages, this )
    }

    private fun addProgrammingLanguages( ) {
        for( i in resources.getStringArray( R.array.jezici ) )
            programmingLanguages.add( i )
        displayedLanguages.addAll( programmingLanguages )
    }

    override fun onCreateOptionsMenu( menu: Menu? ): Boolean {
        menuInflater.inflate( R.menu.main_menu2, menu )
        search = menu
            ?.findItem( R.id.pretraga )
            ?.actionView as SearchView
        setupSearch( )
        return super.onCreateOptionsMenu( menu )
    }

    override fun onOptionsItemSelected( item: MenuItem): Boolean {
        if( item.itemId==R.id.pretraga ) {
            Toast
                .makeText( this, "Radi", Toast.LENGTH_SHORT )
                .show( )
        }
        return super.onOptionsItemSelected( item )
    }

    private fun setupSearch( ) {
        search.setOnQueryTextListener( object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit( newText: String? ): Boolean {
                Toast
                    .makeText( this@MainActivity2, "Pretraga je upisana", Toast.LENGTH_SHORT )
                    .show( )
                return true
            }

            override fun onQueryTextChange( newText: String? ): Boolean {
                displayedLanguages.clear( )
                if( newText.isNullOrEmpty( ) ) {
                    displayedLanguages.addAll( programmingLanguages )

                } else {
                    programmingLanguages.forEach {
                        if ( it.uppercase( ).indexOf( newText.uppercase( ) )!=-1 )
                            displayedLanguages.add( it )
                    }
                }
                rView.adapter?.notifyDataSetChanged( )
                return true
            }

        } )
    }
}