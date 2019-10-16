package org.wit.hillforts.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_hillfort.*
import org.wit.hillforts.R
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.toast
import org.wit.hillforts.main.MainApp
import org.wit.hillforts.models.HillfortModel

class HillfortActivity : AppCompatActivity(), AnkoLogger {

    var hillfort = HillfortModel()
    lateinit var app: MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hillfort)
        toolbarAdd.title = title
        setSupportActionBar(toolbarAdd)
        info("Hillfort Activity started..")

        app = application as MainApp

        btnAdd.setOnClickListener() {
            hillfort.name = hillfortName.text.toString()
            hillfort.description = description.text.toString()
            if (hillfort.name.isNotEmpty()) {
                app.hillforts.add(hillfort.copy())
                info("add Button Pressed: ${hillfort}")
                for (i in app.hillforts.indices) {
                    info("Placemark[$i]:${app.hillforts[i]}")
                }
                setResult(AppCompatActivity.RESULT_OK)
                finish()
            } else {
                toast("Please Enter a title")
            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.hillfort_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.item_cancel -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
