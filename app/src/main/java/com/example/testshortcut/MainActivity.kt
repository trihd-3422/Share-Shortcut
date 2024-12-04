package com.example.testshortcut

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mSharingShortcutsManager = SharingShortcutsManager()
        mSharingShortcutsManager.pushDirectShareTargets(this)
    }
}