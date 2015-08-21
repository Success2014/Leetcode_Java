package first;

public class readNCharactersGivenRead4II extends Reader4{
	private char[] buffer = new char[4];
	int offset = 0, bufsize = 0;
	/**
	* @param buf Destination buffer
	* @param n Maximum number of characters to read
	* @return The number of characters read
	*/
	public int read(char[] buf, int n){
		boolean eof = false;
		int readBytes = 0;
		/* consider two call of the function read:
		read(buf, 3), read(buf, 3). First call left 1 char in the buffer, need to take care of it first.
		Then read another 2 char.
		If the buffer is not empty bufsize + offset = 4; if the buffer is empty, bufsize=offset=0. 
		*/
		while (!eof && readBytes < n){
			int sz = (bufsize == 0) ? read4(buffer) : bufsize;
			if (bufsize == 0 && sz < 4) eof = true;
			int bytes = Math.min(n - readBytes,	sz);
			System.arraycopy(buffer, offset, buf, readBytes, bytes);
			offset = (offset + bytes) % 4;
			bufsize = sz - bytes;
			readBytes += bytes;
		}
		
		return readBytes;
	}
	

}


