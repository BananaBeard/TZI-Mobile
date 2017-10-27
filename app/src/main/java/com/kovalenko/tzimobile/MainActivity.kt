package com.kovalenko.tzimobile

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.PagerAdapter
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

    class LoginPagerAdapter(fm: FragmentManager, private var fragments: List<Fragment>) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment = fragments[position]

        override fun getCount(): Int = fragments.size
    }
}
