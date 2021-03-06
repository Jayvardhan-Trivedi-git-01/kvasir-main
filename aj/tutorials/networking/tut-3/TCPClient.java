import java.io.*;
import java.net.*;

public class TCPClient {

	public static void main(String[] args) {

		try{
			//READING COMMAND LINE-TERMINAL PARAMETERS
			String server_name = args[0];
			int server_port = Integer.parseInt(args[1]);
			
			//CREATING A SOCKET
			Socket client_cocket = new Socket(server_name,server_port);
			
			//SENDING DATA TO SERVER
			String data_to_send = "Hello, this is client.";
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
