package com.viatom.fananceyes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray

class MainActivity : AppCompatActivity() {
    val dataScope = CoroutineScope(Dispatchers.IO)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dataScope.launch {
            val nn=NetCmd.getFinance("sz300003")
            val a1=JSONArray(nn)
            Log.e("size",a1.toString())
        }
    }
}