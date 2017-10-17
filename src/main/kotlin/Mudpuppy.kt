import client.Client
import server.Server
import utils.UdpDatagram
import utils.UserCommunication
import java.net.DatagramSocket
import java.net.InetAddress

fun main(args: Array<String>) {
        val datagramSocket = DatagramSocket()
        val userComms = UserCommunication()
        val ipAddress: InetAddress = InetAddress.getLocalHost()
        val udpDatagram = UdpDatagram()
        val serverPort = 4320
        val serverSocket = DatagramSocket(serverPort)

        while (true) {
                val client = Client(datagramSocket, userComms, ipAddress, udpDatagram)
                val server = Server(userComms, udpDatagram, serverSocket)
                client.start()
                server.start()
                client.client()
                server.serve()
                client.receivePacket()
        }
}
