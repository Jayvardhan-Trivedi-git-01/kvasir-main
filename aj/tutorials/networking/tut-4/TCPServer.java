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
	public static int add(NumberInfo ni){
			return  ni.number1 + ni.number2;
	}

	public void run() {
		while (true) {
			try {
				//ACCEPTING CLIENT(S) CONNECTIONS
				Socket bridge_socket = server_socket.accept();

				//RECEIVING DATA FROM CLIENT
				ObjectInputStream ois = new ObjectInputStream(bridge_socket.getInputStream());
				NumberInfo received_number = (NumberInfo) ois.readObject();
				
				//SENDING DATA TO CLIENT
				DataOutputStream out = new DataOutputStream(bridge_socket.getOutputStream());
				int final_ans = TCPServer.add(received_number);
				out.writeInt(final_ans);
				out.flush();
				
				//CLOSING SOCKETS
				bridge_socket.close();

			} catch (SocketTimeoutException s) {
				System.out.println("Socket timed out!");
				break;
			} catch (IOException e) {
				e.printStackTrace();
				break;
			} catch(ClassNotFoundException cnf){
				cnf.printStackTrace();
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
