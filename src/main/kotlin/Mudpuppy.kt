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
                println("Server running on port ${server.localPort()}")
        }

//            val client = Client()
//            println("Client conected : ${client.inetAddress.hostAddress}")
//
//            val serializer = CustomSerializer()
//
//            val scanner = Scanner(client.inputStream)
//            while (scanner.hasNextLine()) {
//                val text = scanner.nextLine()
//                val requestBytes = text.toByteArray(Charset.defaultCharset())
//                val request = serializer.DeserializeRequest(requestBytes)
//
//                println(request)
//
//                val response = calculate(request.operandA, request.operandB, request.operator)
//                println(response)
//            }
//
//            scanner.close()
//            client.close()
//        }
//
//    })

}
