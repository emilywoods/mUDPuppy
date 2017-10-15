package client

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress

class Client() : Thread() {
    val bufferSize = 1024
    val serverPort = 4320
    val socket = DatagramSocket()
    val ipAddress = InetAddress.getLocalHost()
    val receiveBytes = ByteArray(bufferSize)

    fun client() {
        socket.connect(ipAddress, serverPort)
        sendPacket()
    }

    private fun sendPacket() {
        val dataInputStream = BufferedReader(InputStreamReader(System.`in`))
        print("Client: ")
        val sendStr = dataInputStream.readLine()
        val sendByte = sendStr.toByteArray()
        val sendPacket = DatagramPacket(sendByte, sendByte.size, ipAddress, serverPort)
        socket.send(sendPacket)
        socket.disconnect()
    }

    fun receivePacket() {
        val receivePacket = DatagramPacket(receiveBytes, receiveBytes.size)
        socket.receive(receivePacket)
        val receiveStr = String(receivePacket.data)
        val receiveStrTrim = receiveStr.trim { it <= ' ' }
        println("Message from server:" + receiveStrTrim)
    }
}
