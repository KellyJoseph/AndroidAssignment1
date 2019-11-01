package org.wit.hillforts.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_hillfort.*
import kotlinx.android.synthetic.main.activity_hillfort.toolbarAdd
import kotlinx.android.synthetic.main.activity_user.*
import kotlinx.android.synthetic.main.activity_user.view.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.toast
import org.wit.hillforts.R
import org.wit.hillforts.main.MainApp
import org.wit.hillforts.models.UserModel


class UserActivity: AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        toolbarAdd.title = title
        setSupportActionBar(toolbarAdd)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        info("User Activity started..")

        var app = application as MainApp

        var user = app.loggedInUser
        editFirstName.setText(user.firstName)
        editLastName.setText(user.lastName)
        editPassword.setText(user.password)
        editEmail.setText(user.email)

        editUserSubmit.setOnClickListener() {
            user.firstName= editFirstName.text.toString()
            user.lastName = editLastName.text.toString()
            user.password = editPassword.text.toString()
            user.id = user.id
            user.email = user.email
            if (user.firstName.isEmpty() || user.lastName.isEmpty() || user.password.isEmpty())  {
                toast(R.string.enter_hillfort_name)
            } else {
                app.users.update(user.copy())
            }

            info("user info updated")
            setResult(AppCompatActivity.RESULT_OK)
            finish()
        }
    }
}