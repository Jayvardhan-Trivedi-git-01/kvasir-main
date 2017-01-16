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
		long current = 0;

		//Compute the file Size
		while (current != fileLength) {
			int size = 10000;
			if (fileLength - current >= size)
				current += size;
			else {
				size = (int) (fileLength - current);
				current = fileLength;
			}
			contents = new byte[size];
			bis.read(contents, 0, size);
			os.write(contents);
		}

		os.flush();
		
		//CLOSING THE SOCKET
		socket.close();
		ssock.close();
		System.out.println("File sent succesfully!");
	}

}
