package com.company;

import java.io.IOException;
import java.net.*;

public class TCPWorker {
    private static Socket socket;
// Возвращает 0, если порт октрыт; -1 - если неправильное имя хоста; или 1 - если порт закрыт
    public static int tcpCheck(String host, int port, int timeout) throws IOException {
        int result = 1;
        try {
            InetSocketAddress socketAddress = new InetSocketAddress(InetAddress.getByName(host), port);
            socket = new Socket();
            socket.connect(socketAddress, timeout);
            result = 0;
            socket.close();
        } catch (UnknownHostException e) {
            System.out.println("Неправильное имя хоста или адрес");
            result = -1;
        } catch (SocketTimeoutException e) {
            System.out.println("Не смог подключиться");
            result = 1;
        } catch (IOException e) {
            result = 1;
        }
        return result;
    }
}
