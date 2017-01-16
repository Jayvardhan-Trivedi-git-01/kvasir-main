import java.io.*;
import java.net.*;

public class TCPClient {
	public static void main(String[] args) throws Exception {

		// Initialize socket
		Socket socket = new Socket("localhost", 4747);
		byte[] contents = new byte[10000];

		// Initialize the FileOutputStream to the output file's full path.
		FileOutputStream fos = new FileOutputStream("new_jay.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		InputStream is = socket.getInputStream();

		// No of bytes read in one read() call
		int bytesRead = 0;

		while ((bytesRead = is.read(contents)) != -1)
			bos.write(contents, 0, bytesRead);

		bos.flush();
		socket.close();

		System.out.println("File saved successfully!");
	}

}
