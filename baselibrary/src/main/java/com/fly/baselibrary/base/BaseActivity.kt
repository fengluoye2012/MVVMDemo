package com.fly.baselibrary.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResID())

        intView()
        intDat()
    }

    abstract fun getLayoutResID(): Int
    abstract fun intView()
    abstract fun intDat()
}