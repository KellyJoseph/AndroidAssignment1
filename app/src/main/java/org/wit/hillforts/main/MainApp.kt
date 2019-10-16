package org.wit.hillforts.main

import android.app.Application
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.wit.hillforts.models.HillfortModel
import org.wit.hillforts.models.HillfortkMemStore

class MainApp: Application(), AnkoLogger {

    //val hillforts = ArrayList<HillfortModel>()
    val hillforts = HillfortkMemStore()

    override fun onCreate() {
        super.onCreate()
        info("Hillforts started")
        hillforts.create(HillfortModel( 1, "One", "About one..."))
        hillforts.create(HillfortModel( 2, "Two", "About two..."))
        hillforts.create(HillfortModel( 3, "Three", "About three..."))
    }
}