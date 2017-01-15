import java.net.*;
import java.io.*;

public class TCPServer extends Thread {

	private ServerSocket server_socket;

	public TCPServer(int port) {
		try {
			//CREATING A SOCKET
			server_socket = new ServerSocket(port);
		} catch (IOException ioe) {
			System.out.println("IO Exception cought : ");
			ioe.printStackTrace();
		}
	}

	public void run() {
		while (true) {
			try {
				//ACCEPTING CLIENT(S) CONNECTIONS
				Socket bridge_socket = server_socket.accept();

				//RECEIVING DATA FROM CLIENT
				DataInputStream in = new DataInputStream(bridge_socket.getInputStream());
				String received_data = in.readUTF();
				System.out.println("Data Received from client is : "  + received_data);
				
				//SENDING DATA TO CLIENT
				DataOutputStream out = new DataOutputStream(bridge_socket.getOutputStream());
				String data_to_send = received_data;  //Sending back the received data as an echo
				out.writeUTF(data_to_send);
				
				//CLOSING SOCKETS
				bridge_socket.close();

			} catch (SocketTimeoutException s) {
				System.out.println("Socket timed out!");
				break;
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
	}

	public static void main(String[] args) {
		int port = Integer.parseInt(args[0]);
		Thread t = new TCPServer(port);
		t.start();
	}
}
