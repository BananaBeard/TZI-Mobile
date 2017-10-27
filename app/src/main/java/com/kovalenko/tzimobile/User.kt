package com.kovalenko.tzimobile

data class User(val id: Int, val name: String, var password: String) {
    companion object {
        val COLUMN_ID = "id"
        val TABLE_NAME = "users"
        val COLUMN_NAME = "name"
        val COLUMN_PASSWORD = "password"
    }
}