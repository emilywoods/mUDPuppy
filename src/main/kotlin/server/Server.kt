package server

import java.io.DataInputStream
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress

class Server {

    val bufferSize = 1024
    val udpPort = 4320
    val serverSocket = DatagramSocket(udpPort)
    val packet = ByteArray(bufferSize)

    fun localPort () {
        serverSocket.localPort
    }

    fun serve() {
        val clientPacket = receivePacket()
        sendPacket(clientPacket, clientPacket.address, clientPacket.port)
    }

    // listens for a packet on a serverSocket
    private fun receivePacket(): DatagramPacket {
        val receivePacket = DatagramPacket(packet, packet.size)
        serverSocket.receive(receivePacket)
        println("Client:" + receivePacket.data.toString())
        return receivePacket
    }

    // sends a packet
    private fun sendPacket(clientMessage: DatagramPacket, clientAddress: InetAddress, clientPort: Int) {
        val dataInputStream = DataInputStream(System.`in`)
        println("Server:")
        val sendBytes = dataInputStream.readBytes()
        val sendPacket = DatagramPacket(sendBytes, sendBytes.size, clientAddress, clientPort)
        serverSocket.send(sendPacket)
    }

    //What about multiple clients??
    //More out-going messages
}


