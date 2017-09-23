package client

import java.io.DataInputStream
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress
import java.util.*

class Client{
    val bufferSize = 1024
    val udpPort = 4320
    val socket = DatagramSocket()
    val ipAddress = InetAddress.getLocalHost()
    val packet = ByteArray(bufferSize)

    fun client() {
        while (true) {
            socket.connect(ipAddress, udpPort)
            send()
            receive()
        }
    }

    private fun send() {
        val dataInputStream = Scanner(System.`in`)
        println("Client:")
        val sendString = dataInputStream.nextLine()
        val sendByte  = sendString.toByteArray()
        val sendPacket = DatagramPacket(sendByte, sendByte.size, ipAddress, udpPort)
        socket.send(sendPacket)
        println("Message sent")
    }

    private fun receive() {
        val receivePacket = DatagramPacket(packet, packet.size)
        socket.receive(receivePacket)
        println("Message received")
        val receiveStr = receivePacket.data.toString()
        println("Server:" + receiveStr)
    }

}
