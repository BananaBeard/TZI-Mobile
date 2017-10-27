package com.kovalenko.tzimobile

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_admin.*
import kotlinx.android.synthetic.main.users_fragment.*
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.db.*
import org.jetbrains.anko.doAsync

class AdminActivity : AppCompatActivity() {

    val Context.database: DatabaseHelper
        get() = DatabaseHelper.Instance(applicationContext)

    companion object {
        var users: List<User>? = null
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        var userFragments = ArrayList<Fragment>()


        bg {
            database.use {
                transaction {
                    insert(User.TABLE_NAME, User.COLUMN_ID to 1, User.COLUMN_NAME to "Kostya", User.COLUMN_PASSWORD to "Kostya13")
                    insert(User.TABLE_NAME, User.COLUMN_ID to 2, User.COLUMN_NAME to "Vlad", User.COLUMN_PASSWORD to "Vlad13")

                    users = select(User.TABLE_NAME).exec { parseList(classParser()) }

                }
            }
        }

        userFragments.add(createFragment(1))
        userFragments.add(createFragment(2))

        var adapter = UsersPagerAdapter(supportFragmentManager, userFragments)

        pagerAdmin.adapter = adapter
    }

    fun getUserWithId(id: Int) : User {

        val user: User = database.use {
            select(User.TABLE_NAME).whereArgs("(id = {userId})",
                    "userId" to id)
                    .exec { parseSingle(classParser()) }
        }

        return user
    }

    fun createFragment(int: Int) : UserFragment{
        var user = getUserWithId(int)

        var fragment = UserFragment()
        var bundle = Bundle()
        bundle.putString("name", user.name)
        bundle.putString("pass", user.password)
        fragment.arguments = bundle

        return fragment
    }

    inner class UsersPagerAdapter(fm: FragmentManager, private var fragments: List<Fragment>) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment = fragments[position]

        override fun getCount(): Int = fragments.size
    }
}
