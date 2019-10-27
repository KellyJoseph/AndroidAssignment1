package org.wit.hillforts.activities

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_hillforts_list.*
import kotlinx.android.synthetic.main.hillfort_card_xml.view.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivityForResult
import org.wit.hillforts.R
import org.wit.hillforts.main.MainApp
import org.wit.hillforts.models.HillfortModel

class HillfortListActivity: AppCompatActivity(), HillfortListener {

    lateinit var app: MainApp
    //val IMAGE_REQUEST = 1

    //create the activity. bundle is what activity data is saved in if closed, used to re-create a
    //closed activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hillforts_list)
        //as specifies an alias for an import or a type cast
        app = application as MainApp


        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        loadHillforts()
        //recyclerView.adapter = HillfortsAdapter(app.hillforts)
        //recyclerView.adapter = HillfortsAdapter(app.hillforts.findAll())
        recyclerView.adapter = HillfortsAdapter(app.hillforts.findAll(), this)

        //toolbar is a widget in ativity_hillforts_list
        toolbar.title = title
        //set a toolbar to act as an action bar in this activity
        setSupportActionBar(toolbar)
    }

    //just add the + button
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }


    //handler for the add button
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.item_add -> startActivityForResult<HillfortActivity>(0)
        }
        return super.onOptionsItemSelected(item)
    }



    //handler for select activity edit
    override fun onHillfortClick(hillfort: HillfortModel) {
        startActivityForResult(intentFor<HillfortActivity>().putExtra("hillfort_edit", hillfort), 0)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //recyclerView.adapter?.notifyDataSetChanged()
        loadHillforts()
        super.onActivityResult(requestCode, resultCode, data)
    }
    private fun loadHillforts() {
        showHillforts(app.hillforts.findAll())
    }
    fun showHillforts (hillforts: List<HillfortModel>) {
        recyclerView.adapter = HillfortsAdapter(hillforts, this)
        recyclerView.adapter?.notifyDataSetChanged()
    }
}
