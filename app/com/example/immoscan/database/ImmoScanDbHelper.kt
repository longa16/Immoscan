package com.example.immoscan.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import com.example.immoscan.database.ImmoScanContract.ProprietaireEntry
import com.example.immoscan.database.ImmoScanContract.BienEntry

class ImmoScanDbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "ImmoScan.db"

        // Note comment j'utilise les variables importées directement maintenant
        private const val SQL_CREATE_PROPRIETAIRE = """
            CREATE TABLE ${ProprietaireEntry.TABLE_NAME} (
                ${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT,
                ${ProprietaireEntry.COLUMN_NOM} TEXT NOT NULL,
                ${ProprietaireEntry.COLUMN_PRENOM} TEXT,
                ${ProprietaireEntry.COLUMN_EMAIL} TEXT,
                ${ProprietaireEntry.COLUMN_TELEPHONE} TEXT
            )
        """

        private const val SQL_CREATE_BIEN = """
            CREATE TABLE ${BienEntry.TABLE_NAME} (
                ${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT,
                ${BienEntry.COLUMN_ADRESSE} TEXT NOT NULL,
                ${BienEntry.COLUMN_VILLE} TEXT,
                ${BienEntry.COLUMN_CP} TEXT,
                ${BienEntry.COLUMN_TYPE} TEXT,
                ${BienEntry.COLUMN_PROPRIETAIRE_ID} INTEGER,
                FOREIGN KEY(${BienEntry.COLUMN_PROPRIETAIRE_ID}) REFERENCES ${ProprietaireEntry.TABLE_NAME}(${BaseColumns._ID})
            )
        """
    }

    override fun onConfigure(db: SQLiteDatabase) {
        super.onConfigure(db)
        // Active les clés étrangères
        db.setForeignKeyConstraintsEnabled(true)
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_PROPRIETAIRE)
        db.execSQL(SQL_CREATE_BIEN)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS ${BienEntry.TABLE_NAME}")
        db.execSQL("DROP TABLE IF EXISTS ${ProprietaireEntry.TABLE_NAME}")
        onCreate(db)
    }
}
