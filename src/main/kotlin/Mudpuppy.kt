import client.Client
import server.Server
import utils.UdpDatagram
import utils.UserCommunication
import java.net.DatagramSocket
import java.net.InetAddress

fun main(args: Array<String>) {
        val userComms = UserCommunication()
        val ipAddress: InetAddress = InetAddress.getLocalHost()
        val udpDatagram = UdpDatagram()
        val serverPort = 4320

        while (true) {
                val client = Client(DatagramSocket(), userComms, ipAddress, udpDatagram)
                val server = Server(userComms, udpDatagram, DatagramSocket(serverPort))
                client.start()
                server.start()
                client.client()
                server.serve()
                client.receivePacket()
        }
}
