package com.kovalenko.tzimobile

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fragments = ArrayList<Fragment>()

        fragments.add(UserLoginFragment())
        fragments.add(AdminLoginFragment())

        var adapter = LoginPagerAdapter(supportFragmentManager, fragments)

        pager.adapter = adapter
    }
}
