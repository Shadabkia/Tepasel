package com.example.tepasel

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ir.tapsell.plus.TapsellPlus
import ir.tapsell.plus.TapsellPlusInitListener
import ir.tapsell.plus.model.AdNetworkError
import ir.tapsell.plus.model.AdNetworks

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val key = "lhdghcmffbqqtiffaigbcfpfpcgfqbsnleoltfadsqpolocsrgqhfnfcegqlfnejgiitfi"

        TapsellPlus.initialize(this, key,
            object : TapsellPlusInitListener {
                override fun onInitializeSuccess(p0: AdNetworks?) {
                    Log.d("onInitializeSuccess", p0?.name ?: "");
                }

                override fun onInitializeFailed(p0: AdNetworks?, p1: AdNetworkError?) {
                    Log.d("onInitializeSuccess", p0?.name ?: "");
                }

            })

        TapsellPlus.setDebugMode(Log.DEBUG)

    }
}