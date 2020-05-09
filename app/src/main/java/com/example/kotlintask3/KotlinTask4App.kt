package com.example.kotlintask3

import android.app.Application

class KotlinTask4App : Application() {
    override fun onCreate() {
        super.onCreate()
        PreferencesManager.with(this)
    }
}