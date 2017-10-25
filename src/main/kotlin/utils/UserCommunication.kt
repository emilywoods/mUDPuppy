package utils

import org.springframework.stereotype.Component
import java.io.BufferedReader
import java.io.InputStreamReader

@Component
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

