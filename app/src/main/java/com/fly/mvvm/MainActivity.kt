package com.fly.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fly.mvvm.ui.main.MainFragment
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }

        GlobalScope.launch {

        }

        GlobalScope.launch(Dispatchers.Main){
           val image = suspendingGetImage("")
            //todo
        }

    }

    //
    suspend fun suspendingGetImage(id:String) = withContext(Dispatchers.IO){
        delay(500)
        return@withContext
    }
}