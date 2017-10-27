package com.kovalenko.tzimobile

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.admin_login.*
import kotlinx.android.synthetic.main.user_login.*

class AdminLoginFragment : Fragment() {

    private var counter = 3

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater?.inflate(R.layout.admin_login, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginButtonAdmin.setOnClickListener {
            if (editPassAdmin.text.isNotEmpty()) {
                if (editPassAdmin.text.toString() == "Adminpass1") {
                    Snackbar.make(view!!, "Login successful", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show()
                    counter = 3
                    var callingActivity: MainActivity = activity as MainActivity
                    var intent = Intent(callingActivity, AdminActivity::class.java)
                    startActivity(intent)
                } else {
                    counter--
                    if (counter == 0) {
                        loginButtonAdmin.isEnabled = false
                    } else Toast.makeText(context, "$counter attempts left", Toast.LENGTH_SHORT).show()
                }
            } else Toast.makeText(context, "Please enter password", Toast.LENGTH_SHORT).show()
        }
    }
}

class UserLoginFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater?.inflate(R.layout.user_login, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginButtonUser.setOnClickListener{
            editNameUser.text = editPassUser.text
        }
    }
}