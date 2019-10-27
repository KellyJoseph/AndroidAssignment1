package org.wit.hillforts.main

import android.app.Application
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.wit.hillforts.models.HillfortJSONStore
import org.wit.hillforts.models.HillfortModel
import org.wit.hillforts.models.HillfortStore
import org.wit.hillforts.models.HillfortkMemStore

class MainApp: Application(), AnkoLogger {

    //val hillforts = ArrayList<HillfortModel>()
    //val hillforts = HillfortkMemStore()
    lateinit var hillforts: HillfortStore

    override fun onCreate() {
        super.onCreate()
        //hillforts = HillfortkMemStore()
        hillforts = HillfortJSONStore(applicationContext)
        info("Hillforts started")
    }
}