import client.Client
import server.Server

fun main(args: Array<String>) {

        while (true) {
                val client = Client()
                val server = Server()
                client.start()
                server.start()
                client.client()
                server.serve()
                client.receivePacket()
        }
}
