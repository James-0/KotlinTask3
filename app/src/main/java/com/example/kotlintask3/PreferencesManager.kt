package com.example.kotlintask3

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object PreferencesManager {
    private const val prefName = "Database"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    fun with(application: Application) {
        preferences = application.getSharedPreferences(prefName, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    fun getGson(key: String): ArrayList<User> {
        var json: String = preferences.getString(key, "").toString()
        return fromJson(json)
    }

    fun saveGson(user: List<User>, key: String) : List<User> {
        val gson = Gson()
        val json = gson.toJson(user)

        preferences.edit() {
            it.putString(key, json)
        }
        return fromJson(json)
    }

    fun clear() {
    preferences.edit() {
        it.clear()
            }
        }
    private inline fun <reified User> fromJson(json: String) : User {
        return Gson().fromJson(json, object : TypeToken<User>(){}.type)
    }
}