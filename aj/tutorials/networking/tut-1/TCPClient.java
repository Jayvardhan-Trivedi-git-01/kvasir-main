import java.io.*;
import java.net.*;

public class TCPClient {

	public static void main(String[] args) {

		try{
			//CREATING THE SOCKET
			Socket client_cocket = new Socket("localhost", 5555);
			System.out.println("Connected to Server...");
			
			//SENDING DATA TO SERVER
			String data_to_send = "Hi from client...";
			DataOutputStream dout = new DataOutputStream(client_cocket.getOutputStream());
			dout.writeUTF(data_to_send);
			
			//RECEIVING DATA FROM SERVER
			DataInputStream din = new DataInputStream(client_cocket.getInputStream());
			String received_data = din.readUTF();
			System.out.println("Data Received from Server : "+ received_data);
		
			//CLOSING THE SOCKET
			client_cocket.close();
		}
		catch(IOException ioe){
			System.out.println("IO Exception cought : ");
			ioe.printStackTrace();
		}
	}

}
