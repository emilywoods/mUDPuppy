package server

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress

class Server : Thread() {

    val bufferSize = 1024
    val serverPort = 4320
    val serverSocket = DatagramSocket(serverPort)
    val packet = ByteArray(bufferSize)

    fun localPort (): Int {
        return serverSocket.localPort
    }

    fun serve() {
        val clientPacket = receivePacket()
        sendPacket(clientPacket.address, clientPacket.port)
    }

    private fun receivePacket(): DatagramPacket {
        val receivePacket = DatagramPacket(packet, packet.size)
        serverSocket.receive(receivePacket)
        val receiveStr = String(receivePacket.data)
        val receiveStrTrim = receiveStr.trim { it <= ' ' }
        println("Message from client:" + receiveStrTrim)
        serverSocket.disconnect()
        return receivePacket
    }

    private fun sendPacket(clientAddress: InetAddress, clientPort: Int) {
        val dataInputStream = BufferedReader(InputStreamReader(System.`in`))
        print("Server:")
        val sendStr = dataInputStream.readLine()
        val sendByte = sendStr.toByteArray()
        val  sendPacket = DatagramPacket(sendByte, sendByte.size, clientAddress, clientPort)
        serverSocket.send(sendPacket)
        serverSocket.close()
    }
}


