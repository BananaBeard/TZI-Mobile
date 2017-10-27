package com.kovalenko.tzimobile

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.TextView
import kotlinx.android.synthetic.main.users_fragment.*

class UserFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater?.inflate(R.layout.users_fragment, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var bundle = this.arguments

        textName.text = bundle.get("name").toString()
        textPass.text = bundle.get("pass").toString()

        toggleButton.setOnCheckedChangeListener(object: CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
                if (p1) {
                    textBlocked.visibility = TextView.VISIBLE
                } else {
                    textBlocked.visibility = TextView.INVISIBLE
                }
            }

        })
    }
}