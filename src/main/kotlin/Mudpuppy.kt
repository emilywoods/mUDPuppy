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

        while (true) {
                val client = Client(datagramSocket, userComms, ipAddress, udpDatagram)
                //into client inject: DatagramSocket
                val server = Server(userComms, udpDatagram)
                client.start()
                server.start()
                client.client()
                server.serve()
                client.receivePacket()
        }
}
