

// 1. Find the last element of a list
val alphabetList: List<String> = listOf("a", "b", "c", "d", "e", "e")
val lastElement = alphabetList.last()


// 2. Find the last but one element of a list
val lastButOneElement = alphabetList.elementAt(alphabetList.size -2)


// 3. Find the nth element of a list
fun nth(index: Int, subjectList: List<Any>): Any? {
    // check if index within the subject list bounds
    return if (index in subjectList.indices) {
        subjectList.elementAt(index)
        // if it is out of bounds, return null
    } else {
        null
    }
}


// 4. Find number of elements in a list
val noElementsInList = alphabetList.size


// 5. Reverse a list
val reverseList = alphabetList.reversed()


// 6. Find out whether a list is a palindrome
fun isPalindrome(inputList: List<Any>): Boolean {
    if (inputList.equals(inputList.reversed()) ) {
        return true
    }
    return false
}


// 7. Flatten a nested list structure
val nestedList1: List<Any> = listOf(listOf("1", "1"), "2", listOf("4", listOf("5","8")))

fun flattenComplexList(list: List<Any>): List<Any> {
    return list.flatMap {
        if (it is List<*>) {
            flattenComplexList(it as List<Any>)
        } else {listOf(it)}
    }
}


// 8. Eliminate consecutive duplicates of list elements
val uniqueList = alphabetList.toSet().toList()

// 9. Pack consecutive duplicates of list elements into sublists
// If a list contains repeated elements, they should be
// placed in separate sublists. Example:

val inputString: String = "aaaabccaadeeee"

fun pack(inputString: String): List<List<String>> {
    var startIndexCounter = 0
    var finishIndexCounter = 1
    val resultList: MutableList<List<String>> = mutableListOf()
    inputString.forEachIndexed { index, c ->
        // if index is not 0 and if character is same as previous character
        // increment the finishIndexCounter by 1
        if (index > 0 && c == inputString[index -1]) {
            finishIndexCounter ++
        } else {
            // if the character is not the same as previous character
            // add the subsection to the resultsList (start - finish index counter)
            resultList.add(listOf(inputString.slice(startIndexCounter until finishIndexCounter)))
            // reset the start index to begin at current index
            startIndexCounter = index
            // reset finish index to begin at current index +1
            finishIndexCounter = index +1

        }
    }
    // add remaining character to the resultList as a new list
    resultList.add(listOf(inputString.slice(startIndexCounter until finishIndexCounter)))
    return resultList
}

fun pack2(inputString: String): Any {
    // groupby.values groups all characters that are the same together in a map
    // Key is character and values are lists of characters i.e. a=[a, a, a, a, a, a]
    // then values gets lists of characters i.e. [a, a, a, a, a, a]
    // .map then convert each list of characters to a string.

    return inputString.groupBy { it }
        .values
        .map { it.joinToString("") }
}

// this function doesn't work as intended - because it groups the characters first.
// This means it doesn't take into account the consecutive element.

