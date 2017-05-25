package log4j;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

public class LogClass {

	private boolean initializationFlag = false;
	// default value
	private String maxFileSize;
	private int maxBackupIndex;

	public LogClass(String fileSize, int backupIndex) {

		this.maxFileSize = fileSize;
		this.maxBackupIndex = backupIndex;
		

		System.out.println(maxFileSize + ":" + maxBackupIndex);
		
	}

	private void intializeLogger(String fileName, Logger log, String fileSize, int backupIndex) throws IOException {

		String currentDAte = currentDate();

		PatternLayout layOut = new PatternLayout();
		layOut.setConversionPattern("%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n");

		RollingFileAppender rollingAppender = new RollingFileAppender(layOut,
				"/home/bogdan/Documents/testLogger/" + fileName + "_" + currentDAte + ".log");
		rollingAppender.setMaxFileSize(fileSize);
		rollingAppender.setMaxBackupIndex(backupIndex);
		rollingAppender.activateOptions();
		log.addAppender(rollingAppender);
	}

	public Logger getLogger(String fileName, Logger log) throws IOException {
		if (initializationFlag == false) {
			intializeLogger(fileName, log, maxFileSize, maxBackupIndex);
			initializationFlag = true;
			
			
			return log;
		} else {
			return log;
		}
	}

	private String currentDate() {

		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yy");
		Date date = new Date();

		System.out.println(dateFormat.format(date));

		return dateFormat.format(date);
	}
}
