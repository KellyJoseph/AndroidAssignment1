package org.wit.hillforts.activities

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_hillforts_list.*
import kotlinx.android.synthetic.main.hillfort_card_xml.view.*
import org.jetbrains.anko.startActivityForResult
import org.wit.hillforts.R
import org.wit.hillforts.main.MainApp
import org.wit.hillforts.models.HillfortModel

class HillfortListActivity: AppCompatActivity() {

    lateinit var app: MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hillforts_list)
        app = application as MainApp

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = HillfortsAdapter(app.hillforts)

        toolbar.title = title
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.item_add -> startActivityForResult<HillfortActivity>(0)
        }
        return super.onOptionsItemSelected(item)
    }
}
