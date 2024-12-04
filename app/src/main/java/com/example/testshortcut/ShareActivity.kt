package com.example.testshortcut

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class ShareActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)

        when {
            intent?.action == Intent.ACTION_SEND -> {
                if ("text/plain" == intent.type) {
                    intent.getStringExtra(Intent.EXTRA_TEXT)?.let {
                        val textShared = findViewById<TextView>(R.id.text_shared)
                        textShared.text = it
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P &&
                        intent.hasExtra(Intent.EXTRA_SHORTCUT_ID)) {
                        val shortcutId = intent.getStringExtra(Intent.EXTRA_SHORTCUT_ID)
                        val e = ""
                    }
                }
            }
        }
    }
}
