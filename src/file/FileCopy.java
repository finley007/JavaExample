package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * 快速拷贝文件
 *
 */
public class FileCopy {
	
	public static void main(String[] args) {
		try {
			fileCopy(new File("C:\\Documents and Settings\\admin\\Desktop\\09305I252-1.jpg"), 
					new File("C:\\Documents and Settings\\admin\\Desktop\\aa.jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void fileCopy(File in, File out) throws Exception {
		FileChannel inChannel = new FileInputStream(in).getChannel();
		FileChannel outChannel = new FileOutputStream(out).getChannel();
		try {
			//magic number for Windows, 64Mb - 32Kb
			int maxCount = (64*1024*1024) - (32*1024);
			long size = inChannel.size();
			long position = 0;
			while ( position < size) {
				position += inChannel.transferTo(position, maxCount, outChannel);
			}
		} finally {
			if (inChannel != null) {
				inChannel.close();
			}
			if (outChannel != null) {
				outChannel.close();
			}
		}
		
	}

}
