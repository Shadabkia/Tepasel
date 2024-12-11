package com.example.tapsel

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tapsel.R
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
                    TapsellPlus.setGDPRConsent(this@MainActivity, true)
                    TapsellPlus.setDebugMode(Log.DEBUG)
                    Toast.makeText(this@MainActivity, "OnInitializeSuccess", Toast.LENGTH_SHORT)
                        .show()
                    Log.d("onInitializeSuccess", p0?.name ?: "");
                }

                override fun onInitializeFailed(p0: AdNetworks?, p1: AdNetworkError?) {
                    Log.d("onInitializeFailed", p0?.name ?: "");
                }

            })

        findViewById<Button>(R.id.button2).setOnClickListener {
            startActivity(Intent(this, NativeBannerActivity::class.java))
        }

    }
}