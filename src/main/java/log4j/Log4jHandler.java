package log4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class Log4jHandler {

	private String className;
	private Logger log;
	private String fileName;
	private LogClass logClass;

	// default value
	private String maxFileSize;
	private int maxBackupIndex;
	
	private String mails;
	private List<String> mailsList;
	
	private List<String> levelsList;

	public Log4jHandler(String name, String maxFileSize, int maxBackupIndex, List<String> levelsList) {

		init(name, maxFileSize, maxBackupIndex, levelsList);
	}

	public Log4jHandler(String name,List<String> levelsList) {

		maxFileSize = "1MB";
		maxBackupIndex = 5;
		init(name, maxFileSize, maxBackupIndex, levelsList);
	}

	public Log4jHandler(List<String> levelsList) {

		maxFileSize = "1MB";
		maxBackupIndex = 5;
		String defaultName = "Smarty";
		init(defaultName, maxFileSize, maxBackupIndex, levelsList);
	}

	private void init(String name, String fileSize, int backupIndex, List<String> levelsList) {
		className = name;
		log = Logger.getLogger(className);
		fileName = name;
		logClass = new LogClass(fileSize, backupIndex);

		this.mails = "yevhengren@gmail.com";
		this.mailsList = splitData(mails);
		
		this.levelsList = levelsList;
	}
	
	public void debug(String message) throws IOException {
		if (levelsList.contains("DEBUG") || levelsList.contains("ALL")) {
			List<String> emails = mailsList;
			logClass.getLogger(fileName, log).debug(message);
			sendEmail(fileName, message, emails);
		}
	}

	public void error(String message) throws IOException {
		if (levelsList.contains("ERROR") || levelsList.contains("ALL")) {
			List<String> emails = mailsList;
			logClass.getLogger(fileName, log).error(message);
			sendEmail(fileName, message, emails);
		}
	}

	public void fatal(String message) throws IOException {
		if (levelsList.contains("FATAL") || levelsList.contains("ALL")) {
			List<String> emails = mailsList;
			logClass.getLogger(fileName, log).fatal(message);
			sendEmail(fileName, message, emails);
		}
	}

	public void info(String message) throws IOException {
		if (levelsList.contains("INFO") || levelsList.contains("ALL")) {
			List<String> emails = mailsList;
			logClass.getLogger(fileName, log).info(message);
			sendEmail(fileName, message, emails);
		}
	}

	public void trace(String message) throws IOException {
		if (levelsList.contains("TRACE") || levelsList.contains("ALL")) {
			List<String> emails = mailsList;
			logClass.getLogger(fileName, log).trace(message);
			sendEmail(fileName, message, emails);
		}
	}

	public void warn(String message) throws IOException {
		if (levelsList.contains("WARN") || levelsList.contains("ALL")) {
			List<String> emails = mailsList;
			logClass.getLogger(fileName, log).warn(message);
			sendEmail(fileName, message, emails);
		}
	}

	private List<String> splitData(String array) {

		String replace = array.replace(" ", "");
		array = replace;
		List<String> dataList = new ArrayList<String>();

		String[] dataArray = array.split(",");
		for (int i = 0; i < dataArray.length; i++) {
			String level = dataArray[i];
			dataList.add(level);
		}
		return dataList;
	}

	private void sendEmail(String title, String text, List<String> email) {

	}
}
