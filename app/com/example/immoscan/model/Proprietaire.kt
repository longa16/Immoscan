package com.example.immoscan.model // <-- Mets ton package ici

data class Proprietaire(
    val id: Long,
    val nom: String,
    val prenom: String?, // Le ? signifie que ça peut être null (optionnel)
    val email: String?,
    val telephone: String?
) {
    // Une petite fonction utilitaire pour l'affichage
    fun getNomComplet(): String {
        return "${nom.uppercase()} ${prenom ?: ""}".trim()
    }
}