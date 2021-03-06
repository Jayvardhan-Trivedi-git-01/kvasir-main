import java.net.*;
import java.util.Date;
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
	
	public static String doProcess(String data){
		String finalString = new String();
		int ch_count=0, d_count = 0;
		StringBuilder sb = new StringBuilder(data);
		
		for(int i=0; i<sb.length();i++){
			
			char ch = sb.charAt(i);
			if(Character.isAlphabetic(ch)){
				ch_count++;
			}
			if(Character.isDigit(ch)){
				d_count++;
			}			
		}
		finalString = "Total Char : " + ch_count + " and total digits : " + d_count;
		return finalString;		
	}

	public void run() {
		while (true) {
			try {
				System.out.println("-----------------------------------------------");
				System.out.println("Waiting for client on port " + server_socket.getLocalPort() + "...");
				
				//ACCEPTING CLIENT(S) CONNECTIONS
				Socket bridge_socket = server_socket.accept();

				String client_add = bridge_socket.getRemoteSocketAddress().toString();
				System.out.println("Just connected to " + client_add);
				
				//RECEIVING DATA FROM CLIENT
				DataInputStream in = new DataInputStream(bridge_socket.getInputStream());
				String received_data = in.readUTF();
				System.out.println("Data Received from client is : "  + received_data);
				
				//SENDING DATA TO CLIENT
				DataOutputStream out = new DataOutputStream(bridge_socket.getOutputStream());
				String server_add = bridge_socket.getLocalSocketAddress().toString();
				
				String data_to_send = TCPServer.doProcess(received_data);				
				out.writeUTF(data_to_send);
				
				//CLOSING SOCKETS
				System.out.println("Closing socket connections...");
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
