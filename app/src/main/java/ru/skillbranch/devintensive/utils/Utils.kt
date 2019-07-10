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

    fun transliteration(payload: String, divider: String = " "): String = buildString {
        payload.asSequence().forEach {
            append(if (it == ' ') divider else it.transliterate())
        }
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        var firstLetter: String = firstName?.trimStart()?.first().toString().toUpperCase()
        var lastLetter: String = lastName?.trimStart()?.first().toString().toUpperCase()

        if (firstName.isNullOrBlank()) firstLetter = null.toString()
        if (lastName.isNullOrBlank()) lastLetter = null.toString()

        return "$firstLetter $lastLetter"

        /*
        (firstName == null || firstName.isBlank()) && (lastName == null || lastName.isBlank()) -> null
        (firstName == null || firstName.isBlank()) && lastName != null -> lastName.trimStart().first().toString().toUpperCase()
        firstName != null && (lastName == null || lastName.isBlank()) -> firstName.trimStart().first().toString().toUpperCase()
        else -> (firstName!!.trimStart().first().toString() + lastName!!.trimStart().first()).toUpperCase()
        * */
    }
}

private val chars = mapOf(
    'а' to "a",
    'б' to "b",
    'в' to "v",
    'г' to "g",
    'д' to "d",
    'е' to "e",
    'ё' to "e",
    'ж' to "zh",
    'з' to "z",
    'и' to "i",
    'й' to "i",
    'к' to "k",
    'л' to "l",
    'м' to "m",
    'н' to "n",
    'о' to "o",
    'п' to "p",
    'р' to "r",
    'с' to "s",
    'т' to "t",
    'у' to "u",
    'ф' to "f",
    'х' to "h",
    'ц' to "c",
    'ч' to "ch",
    'ш' to "sh",
    'щ' to "sh'",
    'ъ' to "",
    'ы' to "i",
    'ь' to "",
    'э' to "e",
    'ю' to "yu",
    'я' to "ya"
)

private fun Char.transliterate(): String {
    return if (isUpperCase()) {
        chars[this.toLowerCase()]?.toUpperCase() ?: this.toString()
    } else {
        chars[this] ?: this.toString()
    }
}