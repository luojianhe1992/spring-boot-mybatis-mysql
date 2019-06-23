package com.ibm.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

import com.ibm.domain.News;

public class FileOutputUtil {
	public static void output(List<?> list, String path) {
		File file = new File(path);
		if (!file.exists()) {
			System.out.println(path + " doesn't exist!!!!");
			return;
		}
		PrintWriter printWriter = null;
		try {
			printWriter = new PrintWriter(new FileOutputStream(file));
			for (Object object : list) {
				printWriter.println(object);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
		}
	}

	public static void outputNews(List<News> newsList, String path) {
		File file = new File(path);
		if (!file.exists()) {
			System.out.println(path + " doesn't exist!!!!");
		}
		PrintWriter printWriter = null;
		try {
			printWriter = new PrintWriter(new FileOutputStream(file));
			for (News news : newsList) {
				printWriter.println(news);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
		}
	}
}
