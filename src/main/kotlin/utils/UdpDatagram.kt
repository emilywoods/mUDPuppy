package utils

import org.springframework.stereotype.Component
import java.net.DatagramPacket
import java.net.InetAddress

@Component
class UdpDatagram {

    fun constructPacketToReceive(receiveBytes: ByteArray, size: Int): DatagramPacket {
        return DatagramPacket(receiveBytes, size)
    }

    fun  constructPacketToSend(sendByte: ByteArray, size: Int, address: InetAddress, port: Int): DatagramPacket? {
        return DatagramPacket(sendByte, size, address, port)
    }
}
