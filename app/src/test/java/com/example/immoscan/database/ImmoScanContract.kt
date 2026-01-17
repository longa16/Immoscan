package com.example.immoscan.database

import android.provider.BaseColumns

object ImmoScanContract {

    // Table Propriétaires
    object ProprietaireEntry : BaseColumns {
        const val TABLE_NAME = "proprietaire"
        const val COLUMN_NOM = "nom"
        const val COLUMN_PRENOM = "prenom"
        const val COLUMN_EMAIL = "email"
        const val COLUMN_TELEPHONE = "telephone"
    }

    // Table Biens
    object BienEntry : BaseColumns {
        const val TABLE_NAME = "bien"
        const val COLUMN_ADRESSE = "adresse"
        const val COLUMN_VILLE = "ville"
        const val COLUMN_CP = "code_postal"
        const val COLUMN_TYPE = "type_bien"
        const val COLUMN_PROPRIETAIRE_ID = "proprietaire_id"
    }

    // Table Locataires
    object LocataireEntry : BaseColumns {
        const val TABLE_NAME = "locataire"
        const val COLUMN_NOM = "nom"
        const val COLUMN_PRENOM = "prenom"
        const val COLUMN_TELEPHONE = "telephone"
    }

    // Table Etats des Lieux
    object EtatLieuxEntry : BaseColumns {
        const val TABLE_NAME = "etat_lieux"
        const val COLUMN_BIEN_ID = "bien_id"
        const val COLUMN_LOCATAIRE_ID = "locataire_id"
        const val COLUMN_DATE = "date_creation"
        const val COLUMN_TYPE_ETAT = "type_etat"
        const val COLUMN_LATITUDE = "latitude"
        const val COLUMN_LONGITUDE = "longitude"
        const val COLUMN_SIGNATURE_PATH = "signature_path"
        const val COLUMN_IS_CLOSED = "is_closed"
    }

    // Pour simplifier l'exemple ici, je te laisse ajouter Piece, Element et Preuve
    // sur le même modèle si tu as compris le principe.
}