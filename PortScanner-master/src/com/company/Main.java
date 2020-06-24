package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

public class Main {

    public static void main(String[] args) throws IOException {
		if (args.length != 3 && args.length != 4) {
			System.out.println("Чтобы запустить, введите: " +
                    "java -jar HOSTNAME MIN_PORT MAX_PORT [TIMEOUT]");
			return;
		}

		int timeout = 100;
		if(args.length == 4)
		{
			timeout = Integer.parseInt(args[3]);
		}

		String host = args[0];
		int minValue = Integer.parseInt(args[1]);
		int maxValue = Integer.parseInt(args[2]);

		ArrayList<String> tcpPorts = new ArrayList<>();
		int answer;

		System.out.println("Открытые TCP порты на хосте " + host + " :");
		for (int i = minValue; i < maxValue; i++)
		{
			if ((answer = TCPWorker.tcpCheck(host,i, timeout)) == 0) {
				System.out.print(i + ", ");
			}
			if (answer == -1) return;
		}

		for (String s : tcpPorts)
			System.out.println(s);
    }
}
