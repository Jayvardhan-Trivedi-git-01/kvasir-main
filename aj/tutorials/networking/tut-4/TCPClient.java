import java.io.*;
import java.net.*;

public class TCPClient {

	public static void main(String[] args)  {

		try{
			//READING COMMAND LINE-TERMINAL PARAMETERS
			String server_name = args[0];
			int server_port = Integer.parseInt(args[1]);
			
			//CREATING A SOCKET
			Socket client_cocket = new Socket(server_name,server_port);
			
			//SENDING DATA TO SERVER
			NumberInfo myNo = new NumberInfo();
			myNo.number1 = 4;    //OR YOU CAN TAKE THEM FROM TERMINAL/CMD VIA ARGS[2] AND ARGS[3] (OPTIONAL)
			myNo.number2 = 5;
			ObjectOutputStream oos = new ObjectOutputStream(client_cocket.getOutputStream());
			oos.writeObject(myNo);
			oos.flush();
			
			//RECEIVING DATA FROM SERVER
			DataInputStream din = new DataInputStream(client_cocket.getInputStream());
			int ans = din.readInt();
			System.out.println("Sum received from the server is : "+ ans);
		
			//CLOSING THE SOCKET
			client_cocket.close();
		}
		catch(IOException ioe){
			System.out.println("IO Exception cought : ");
			ioe.printStackTrace();
		}
	}

}
