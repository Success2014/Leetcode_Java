package first;

public class readNCharactersGivenRead4 extends Reader4{
	/**
	* @param buf Destination buffer
	* @param n Maximum number of characters to read
	* @return The number of characters read
	*/	
	public int read (char[] buf, int n){
		char[] buffer = new char[4];
		boolean eof = false;
		int readBytes = 0;		
		
		while (!eof && readBytes < n){
			int sz = read4(buffer);
			if (sz < 4) eof = true;
			
			//consider special case: filesize=7, n=6
			//another special case: n=2, filesize > 4
			//normal case: filize=8,n=8 
			int bytes = Math.min(n - readBytes, sz);
			System.arraycopy(buffer, 0, buf, readBytes, bytes);
			readBytes += bytes;
		}
		
		return readBytes;
	}
	
	

}

class Reader4{
	
	public int read4(char[] buffer){
		return 4;//4, or 3, or 2, or 1, or 0, just a placehold here.
	}
	
}