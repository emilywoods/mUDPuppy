package client

import java.io.DataInputStream
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress

class Client() : Thread() {
    val bufferSize = 1024
    val udpPort = 4320
    val socket = DatagramSocket()
    val ipAddress = InetAddress.getLocalHost()
    val receiveBytes = ByteArray(bufferSize)

    fun client() {
        while (true) {
            socket.connect(ipAddress, udpPort)
            send()
            receive()
        }
    }

    private fun send() {
//        val dataInputStream = Scanner(System.`in`)
//        println("Client:")
//        val sendString = dataInputStream.nextLine()
//        var sendByte  = sendString.toByteArray()
//        val sendPacket = DatagramPacket(sendByte, sendByte.size, ipAddress, udpPort)
//        socket.send(sendPacket)
//        println("Message sent")


        val dataInputStream = DataInputStream(System.`in`)
        print("Client:")
        val sendStr = dataInputStream.readUTF()
        val sendByte = sendStr.toByteArray()
        val sendPacket = DatagramPacket(sendByte, sendByte.size, ipAddress, udpPort)
        socket.send(sendPacket)
        println("Message sent")

    }

    private fun receive() {
//        val receivePacket = DatagramPacket(receiveBytes, receiveBytes.size)
//        socket.receive(receivePacket)
//        println("Message received")
//        val receiveStr = receivePacket.data.toString()
//        println("Server:" + receiveStr)

        val receivePacket = DatagramPacket(receiveBytes, receiveBytes.size)
        socket.receive(receivePacket)
        val receiveStr = String(receivePacket.getData())
        val receiveStrTrim = receiveStr.trim()
        System.out.println("Server:"+ receiveStrTrim)
    }

}
