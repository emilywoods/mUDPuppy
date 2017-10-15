package utils

import java.io.BufferedReader
import java.io.InputStreamReader

class UserCommunication {

    fun getUserInputStream(): BufferedReader {
        return BufferedReader(InputStreamReader(System.`in`))
    }

    fun readAsString(dataInputStream: BufferedReader): String {
        return dataInputStream.readLine()
    }

    fun printLine(output: String) {
        println(output)
    }

    fun printout(output: String) {
        print(output)
    }
}

