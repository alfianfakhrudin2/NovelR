package com.example.novelr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvHeroes: RecyclerView
    private val list = ArrayList<Book>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHeroes = findViewById(R.id.Lbuku)
        rvHeroes.setHasFixedSize(true)
        list.addAll(getListHeroes())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    //    Untuk mengatur tampilan layout bisa grid dengan 2 span dan juga bisa list kebwah
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_list ->{
                val moveIntentActivity = Intent(this@MainActivity, about_page::class.java)
                startActivity(moveIntentActivity)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListHeroes(): ArrayList<Book> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val genre = resources.getStringArray(R.array.genre)
        val penerbit = resources.getStringArray(R.array.penerbit)
        val bahasa = resources.getStringArray(R.array.bahasa)

        val listBook = ArrayList<Book>()
        for (i in dataName.indices) {
            val book = Book(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), genre[i], penerbit[i], bahasa[i])
            listBook.add(book)
        }
        return listBook
    }

    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListBookAdapter(list)
        rvHeroes.adapter = listHeroAdapter
    }
}