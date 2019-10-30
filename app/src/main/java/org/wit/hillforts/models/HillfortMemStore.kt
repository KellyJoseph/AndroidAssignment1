package org.wit.hillforts.models

import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class HillfortkMemStore : HillfortStore, AnkoLogger {

    var users = mutableListOf<UserModel>()


    val hillforts = ArrayList<HillfortModel>()

    override fun findAll(): List<HillfortModel> {
        return hillforts
    }

    override fun create(hillfort: HillfortModel) {
        hillforts.add(hillfort)
        logAll()
    }
    override fun delete(hillfort: HillfortModel) {
        //var foundHillfort: HillfortModel? = hillforts.find { p -> p.id == hillfort.id }
        hillforts.remove(hillfort)
    }
    override fun register(user: UserModel) {
        user.id = generateRandomId()
        users.add(user)
    }


    
    override fun login(email: String, password: String) : UserModel? {
        var foundUser:  UserModel? = users.find { p -> p.email == email}
        // if (foundUser != null && foundUser.password == password) {
        //     return foundUser
        // }
        return foundUser
    }

    override fun update(hillfort: HillfortModel) {
        var foundHillfort: HillfortModel? = hillforts.find { p -> p.id == hillfort.id }
        if (foundHillfort != null) {
            foundHillfort.name = hillfort.name
            foundHillfort.description = hillfort.description
            foundHillfort.image = hillfort.image
            foundHillfort.lat = hillfort.lat
            foundHillfort.lng = hillfort.lng
            foundHillfort.zoom = hillfort.zoom
            logAll()
        }
    }


    fun logAll() {
        hillforts.forEach{ info("${it}") }
    }

}