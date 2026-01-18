package com.example.immoscan.database.dao

import android.content.ContentValues
import android.content.Context
import com.example.immoscan.database.ImmoScanContract.ProprietaireEntry
import com.example.immoscan.database.ImmoScanDbHelper

class ProprietaireDAO(context: Context) {

    private val dbHelper = ImmoScanDbHelper(context)

    fun addProprietaire(nom: String, prenom: String, email: String, tel: String): Long {
        // En Kotlin, on utilise 'use' (non montré ici pour simplifier) ou on accède direct
        val db = dbHelper.writableDatabase

        val values = ContentValues().apply {
            put(ProprietaireEntry.COLUMN_NOM, nom)
            put(ProprietaireEntry.COLUMN_PRENOM, prenom)
            put(ProprietaireEntry.COLUMN_EMAIL, email)
            put(ProprietaireEntry.COLUMN_TELEPHONE, tel)
        }

        return db.insert(ProprietaireEntry.TABLE_NAME, null, values)
    }

    // Exemple de lecture simple
    fun getAllProprietairesNoms(): List<String> {
        val db = dbHelper.readableDatabase
        val list = mutableListOf<String>()

        val cursor = db.query(
            ProprietaireEntry.TABLE_NAME,
            arrayOf(ProprietaireEntry.COLUMN_NOM),
            null, null, null, null, null
        )

        with(cursor) {
            while (moveToNext()) {
                val nom = getString(getColumnIndexOrThrow(ProprietaireEntry.COLUMN_NOM))
                list.add(nom)
            }
            close()
        }
        return list
    }

    fun close() {
        dbHelper.close()
    }
}