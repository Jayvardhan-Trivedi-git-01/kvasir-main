import java.net.*;
import java.io.*;

public class TCPServer {
	
	public static void main(String[] args) {
		try{
	
			//CREATING THE SOCKET
			ServerSocket	server_socket = new ServerSocket(5555);
			System.out.println("Waiting for the client..");
			
			//ACCEPTING CLIENT CONNECTIONS
			Socket bridge_socket = server_socket.accept();
			String client_socket_add = bridge_socket.getRemoteSocketAddress().toString();
			System.out.println("Connected to Client : " + client_socket_add);
			
			//RECEIVING DATA FROM CLIENT
			DataInputStream din = new DataInputStream(bridge_socket.getInputStream());
			String received_data = din.readUTF();
			System.out.println("Data Received from client is : " + received_data);
			
			//SENDING DATA TO CLIENT
			String data_to_send = "Greetings from Server...";
			DataOutputStream dout = new DataOutputStream(bridge_socket.getOutputStream());
			dout.writeUTF(data_to_send);
			
			//CLOSING SOCKETS
			System.out.println("Closing socket connections...");
			bridge_socket.close();
			server_socket.close();
		}
			catch(IOException ioe){
				System.out.println("IO Exception cought : ");
				ioe.printStackTrace();
			}				
	}
}
