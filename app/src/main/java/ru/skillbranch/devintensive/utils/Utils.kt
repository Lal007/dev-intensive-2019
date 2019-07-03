package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName:String?):Pair<String?, String?>{


        var newName = fullName?.trimStart()?.trimEnd()
        newName = newName?.replace(Regex("\\s{2,}"), " ")

        val parts : List<String>? = newName?.split(" ")

        var firstName = parts?.getOrNull(0)
        if (firstName.isNullOrEmpty()) firstName = null
        var lastName = parts?.getOrNull(1)
        if (lastName.isNullOrEmpty()) lastName = null
        return Pair(firstName, lastName)
    }

    fun transliteration(payload: String, divider:String = " "): String {
        val parts: List<String> = payload.split(" ")
        var first = parts.getOrNull(0)
        var second = parts.getOrNull(1)
        var result:String = ""

        if (first != null) {
            for (s in first){
                result += translit(s)
            }
        }
        first = result
        result = ""

        if (second != null) {
            for (s in second){
                result += translit(s)
            }
        }
        second = result

        //println("$first$divider$second")
        return if (!first.isNullOrEmpty() && !second.isNullOrEmpty()){
            "$first$divider$second"
        } else if (!first.isNullOrEmpty() && second.isNullOrEmpty()){
            "$first"
        } else "$second"
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        var first:String?
        var second:String?

        first = firstName?.replace(Regex("\\s+"), "")
        second = lastName?.replace(Regex("\\s+"), "")

        if (!first.isNullOrEmpty()){
            first = firstName?.substring(0, 1)?.toUpperCase()
        }else first = null
        if (!second.isNullOrEmpty()){
            second = lastName?.substring(0, 1)?.toUpperCase()
        }else second = null


        if (first.isNullOrEmpty() && second.isNullOrEmpty()) return null
        else if (first.isNullOrEmpty() && !second.isNullOrEmpty()) return second
        else if (!first.isNullOrEmpty() && second.isNullOrEmpty()) return first
        return ("$first$second")
    }

    fun translit(ch: Char): String {
       when(ch){
           'а' -> return "a"

            'б' -> return "b"

            'в' -> return "v"

            'г' -> return "g"

            'д' -> return "d"

            'е' -> return "e"

            'ё' -> return "e"

            'ж' -> return "zh"

            'з' -> return "z"

            'и' -> return "i"

            'й' -> return "i"

            'к' -> return "k"

            'л' -> return "l"

            'м' -> return "m"

            'н' -> return "n"

            'о' -> return "o"

            'п' -> return "p"

            'р' -> return "r"

            'с' -> return "s"

            'т' -> return "t"

            'у' -> return "u"

            'ф' -> return "f"

            'х' -> return "h"

            'ц' -> return "c"

            'ч' -> return "ch"

            'ш' -> return "sh"

            'щ' -> return "sh'"

            'ъ' -> return ""

            'ы' -> return "i"

            'ь' -> return ""

            'э' -> return "e"

            'ю' -> return "yu"

            'я' -> return "ya"

           'А' -> return "A"

           'Б' -> return "B"

           'В' -> return "V"

           'Г' -> return "G"

           'Д' -> return "D"

           'Е' -> return "E"

           'Ё' -> return "E"

           'Ж' -> return "Zh"

           'З' -> return "Z"

           'И' -> return "I"

           'Й' -> return "I"

           'К' -> return "K"

           'Л' -> return "L"

           'М' -> return "M"

           'Н' -> return "N"

           'О' -> return "O"

           'П' -> return "P"

           'Р' -> return "R"

           'С' -> return "S"

           'Т' -> return "T"

           'У' -> return "U"

           'Ф' -> return "F"

           'Х' -> return "H"

           'Ц' -> return "C"

           'Ч' -> return "Ch"

           'Ш' -> return "Sh"

           'Щ' -> return "Sh'"

           'Ъ' -> return ""

           'Ы' -> return "I"

           'Ь' -> return ""

           'Э' -> return "E"

           'Ю' -> return "Yu"

           'Я' -> return "Ya"

           else -> return "$ch"
       }
    }
}