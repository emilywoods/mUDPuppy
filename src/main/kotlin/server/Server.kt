package server

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import utils.UdpDatagram
import utils.UserCommunication
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress

@Component
class Server @Autowired constructor(
        val userComms: UserCommunication,
        val udpDatagram: UdpDatagram,
        val serverSocket: DatagramSocket
): Thread() {

    val bufferSize = 1024
    val packet = ByteArray(bufferSize)

    fun serve() {
        val clientPacket = receivePacket()
        sendPacket(clientPacket.address, clientPacket.port)
    }

    private fun receivePacket(): DatagramPacket {
        val receivePacket = udpDatagram.constructPacketToReceive(packet, packet.size)
        serverSocket.receive(receivePacket)
        val receiveStr = String(receivePacket.data)
        val receiveStrTrimmed = receiveStr.trim { it <= ' ' }
        userComms.printLine("Message from client:" + receiveStrTrimmed)
        serverSocket.disconnect()
        return receivePacket
    }

    private fun sendPacket(clientAddress: InetAddress, clientPort: Int) {
        val dataInputStream = userComms.getUserInputStream()
        userComms.printout("Server:")
        val sendStr = userComms.readAsString(dataInputStream)
        val sendByte = sendStr.toByteArray()
        val sendPacket = udpDatagram.constructPacketToSend(sendByte, sendByte.size, clientAddress, clientPort)
        serverSocket.send(sendPacket)
        serverSocket.close()
    }
}


