package com.example.immoscan

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.immoscan.database.dao.ProprietaireDAO

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // --- TEST BASE DE DONNÉES ---
        // Maintenant que l'import est fait là-haut, Android sait ce qu'est "ProprietaireDAO"
        val dao = ProprietaireDAO(this)

        // Insertion test
        val newId = dao.addProprietaire("Martin", "Paul", "paul.martin@kt.com", "0699887766")

        if (newId != -1L) {
            Log.d("ImmoScanDB", "SUCCÈS : Propriétaire créé avec ID: $newId")

            // Vérification lecture
            val noms = dao.getAllProprietairesNoms()
            Log.d("ImmoScanDB", "Liste des propriétaires : $noms")

        } else {
            Log.e("ImmoScanDB", "ERREUR : Échec de l'insertion")
        }

        dao.close()
    }
}