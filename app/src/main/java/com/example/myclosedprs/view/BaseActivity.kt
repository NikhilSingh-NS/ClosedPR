package com.example.myclosedprs.view

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity() {
    abstract  fun initializeViewModel()
    abstract  fun initializeUI()
}