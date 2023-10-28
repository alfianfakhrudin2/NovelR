package com.example.novelr

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DetailAtivity : AppCompatActivity() {
    private lateinit var deskSinop: TextView
    private lateinit var gambar: ImageView
    private lateinit var title: TextView
    private lateinit var genreS: TextView
    private lateinit var penerbit: TextView
    private lateinit var bahasa: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_ativity)

        val Btn_share: FloatingActionButton = findViewById(R.id.action_share)
//        val actionbar = supportActionBar
//        actionbar!!.title = "Detail"
//        actionbar.setDisplayHomeAsUpEnabled(true)

        deskSinop = findViewById(R.id.DeskSinop)
        gambar = findViewById(R.id.avatar)
        title = findViewById(R.id.title)
        genreS = findViewById(R.id.deskGen)
        penerbit = findViewById(R.id.PenDesk)
        bahasa = findViewById(R.id.DeskLanguage)

        val dataHero = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Book>("key_hero", Book::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Book>("key_hero")
        }

        if (dataHero != null) {
            deskSinop.text = dataHero.deskripsi
            title.text = dataHero.name
            gambar.setImageResource(dataHero.foto)
            genreS.text = dataHero.genre
            penerbit.text = dataHero.penerbit
            bahasa.text = dataHero.bahasa
        }

//        UNTUK FUNGSION SHARE
        Btn_share.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, (dataHero?.deskripsi))
            startActivity(Intent.createChooser(intent, "Send To"))
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_share ->{
                val phoneNumber = "088294751"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }

            R.id.action_list ->{
                val moveIntentActivity = Intent(this@DetailAtivity, about_page::class.java)
                startActivity(moveIntentActivity)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

}