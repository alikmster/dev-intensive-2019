package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName:String?): Pair<String?, String?>{
        val parts : List<String>? = fullName?.trim()?.split(" ") ?: null

        var firstName = parts?.getOrNull(0)
        var lastName= parts?.getOrNull(1)

        if (firstName.isNullOrBlank()) firstName = null
        if (lastName.isNullOrBlank()) lastName = null

        return firstName?.trim() to lastName?.trim()
    }

    fun transliteration(payload: String, divider: String = " "): String {
        return ""
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        val firstLetter: String = "А"
        val lastLetter: String = "М"

        return "$firstLetter $lastLetter"
    }
}