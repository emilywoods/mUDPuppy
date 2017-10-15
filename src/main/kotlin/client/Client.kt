package client

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import utils.UdpDatagram
import utils.UserCommunication
import java.net.DatagramSocket
import java.net.InetAddress

@Component
class Client @Autowired constructor(
        val socket: DatagramSocket,
        val userComms: UserCommunication,
        val ipAddress: InetAddress,
        val udpDatagram: UdpDatagram
) : Thread() {

    private val bufferSize = 1024
    private val serverPort = 4320
    private val receiveBytes = ByteArray(bufferSize)

    fun client() {
        socket.connect(ipAddress, serverPort)
        sendPacket()
    }

    fun receivePacket() {
        val receivePacket =  udpDatagram.constructPacketToReceive(receiveBytes, receiveBytes.size)
        socket.receive(receivePacket)
        val receiveStr = String(receivePacket.data)
        val receiveStrTrimmed = receiveStr.trim { it <= ' ' }
        userComms.printLine("Message from server:" + receiveStrTrimmed)
    }

    private fun sendPacket() {
        val dataInputStream = userComms.getUserInputStream()
        userComms.printout("Client: ")
        val sendStr = userComms.readAsString(dataInputStream)
        val sendByte = sendStr.toByteArray()
        val sendPacket = udpDatagram.constructPacketToSend(sendByte, sendByte.size, ipAddress, serverPort)
        socket.send(sendPacket)
        socket.disconnect()
    }
}
