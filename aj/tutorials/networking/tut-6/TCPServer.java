import java.net.*;
import java.io.*;

public class TCPServer {
	public static void main(String[] args) throws Exception {

		// Initialize Sockets
		ServerSocket ssock = new ServerSocket(4747);
		Socket socket = ssock.accept();

		// Specify the file
		File file = new File("jay.txt");
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);

		// Get socket's output stream
		OutputStream os = socket.getOutputStream();

		// Read File Contents into contents array
		byte[] contents;
		long fileLength = file.length();

		contents = new byte[(int) fileLength];
		bis.read(contents, 0, (int) fileLength);//Reading from file buffer
		os.write(contents);//sending it to client
		os.flush();

		// CLOSING THE SOCKET
		socket.close();
		ssock.close();
		System.out.println("File sent succesfully!");
	}

}
