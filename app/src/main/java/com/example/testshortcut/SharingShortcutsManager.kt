package com.example.testshortcut

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.core.content.pm.ShortcutManagerCompat
import androidx.core.graphics.drawable.IconCompat
import androidx.core.app.Person.Builder

class SharingShortcutsManager {
    @SuppressLint("NewApi")
    fun pushDirectShareTargets(context: Context) {
        val shortcuts = ArrayList<ShortcutInfoCompat>()

        // Category that our sharing shortcuts will be assigned to
        val contactCategories: MutableSet<String> = HashSet()
        contactCategories.add(CATEGORY_TEXT_SHARE_TARGET)

        // Adding maximum number of shortcuts to the list
        for (id in 0 until MAX_SHORTCUTS) {
            val staticLauncherShortcutIntent = Intent(Intent.ACTION_DEFAULT)

            shortcuts.add(
                ShortcutInfoCompat.Builder(context, id.toString())
                    .setShortLabel(id.toString())
                    .setIcon(
                        IconCompat.createWithResource(
                            context,
                            R.drawable.ic_android_black_24dp
                        )
                    )
                    .setIntent(staticLauncherShortcutIntent)
                    .setLongLived()
                    .setCategories(contactCategories)
                    .setPerson(
                        Builder()
                            .setName(id.toString())
                            .build()
                    )
                    .build()
            )
        }

        ShortcutManagerCompat.addDynamicShortcuts(context, shortcuts)
    }

    fun removeAllDirectShareTargets(context: Context) {
        ShortcutManagerCompat.removeAllDynamicShortcuts(context)
    }

    companion object {
        private const val MAX_SHORTCUTS = 4

        private const val CATEGORY_TEXT_SHARE_TARGET =
            "com.example.testshortcut.category.TEXT_SHARE_TARGET"
    }
}