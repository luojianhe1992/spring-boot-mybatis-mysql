package com.ibm.util.generator;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.ibm.domain.Employee;
import com.ibm.domain.News;
import com.ibm.util.FileOutputUtil;

public class NewsGenerator {

	private static Set<String> titleSet = new HashSet<String>();
	private static Set<String> abstractionSet = new HashSet<String>();
	private static Set<String> languageSet = new HashSet<String>();
	private static Set<String> authorSet = new HashSet<String>();
	private static Set<String> topicSet = new HashSet<String>();

	static {
		initializeTitleSet();
		initializeAbstractionSet();
		initializeLanguageSet();
		initializeAuthorSet();
		initializeTopicSet();
	}

	private static void initializeTitleSet() {
		titleSet.add("Better Buy: Google vs. IBM");
		titleSet.add("The New Oracle Looks Like the Old IBM");
		titleSet.add("EXPLAINER-Initial exchange offerings flourish in crypto market");
		titleSet.add("7 Blue-Chip Stocks to Buy for a Noisy Market");
		titleSet.add("IBM Stock Has an 18% Rally at Hand");
		titleSet.add("IGM, IBM, NVDA, BKNG: Large Outflows Detected at ETF");
		titleSet.add("IBM Selected by Total to Build Supercomputer Pangea III");
	}

	private static void initializeAbstractionSet() {
		abstractionSet.add("Better Buy: Google vs. IBM");
		abstractionSet.add("The New Oracle Looks Like the Old IBM");
		abstractionSet.add("EXPLAINER-Initial exchange offerings flourish in crypto market");
		abstractionSet.add("7 Blue-Chip Stocks to Buy for a Noisy Market");
		abstractionSet.add("IBM Stock Has an 18% Rally at Hand");
		abstractionSet.add("IGM, IBM, NVDA, BKNG: Large Outflows Detected at ETF");
		abstractionSet.add("IBM Selected by Total to Build Supercomputer Pangea III");
	}

	private static void initializeLanguageSet() {
		languageSet.add("Spanish");
		languageSet.add("English");
		languageSet.add("Hindi");
		languageSet.add("Chinese");
		languageSet.add("Portuguese");
		languageSet.add("Russian");
		languageSet.add("Bengali");
	}

	private static void initializeAuthorSet() {
		authorSet.add("Eddie");
		authorSet.add("John");
		authorSet.add("Jack");
		authorSet.add("Bob");
		authorSet.add("Ryan");
		authorSet.add("Iven");
		authorSet.add("Dan");
		authorSet.add("Rocky");
	}

	private static void initializeTopicSet() {
		topicSet.add("AI");
		topicSet.add("machine learning");
		topicSet.add("robotics");
		topicSet.add("big data");
		topicSet.add("bioinformatics");
		topicSet.add("cyber security");
		topicSet.add("education");
		topicSet.add("deep learning");
	}

	private static String getRandomTitle() {
		return titleSet.stream().skip(new Random().nextInt(titleSet.size())).findFirst().orElse(null);

	}

	private static String getRandomAbstraction() {
		return abstractionSet.stream().skip(new Random().nextInt(abstractionSet.size())).findFirst().orElse(null);
	}

	private static String getRandomLanguage() {
		return languageSet.stream().skip(new Random().nextInt(languageSet.size())).findFirst().orElse(null);
	}

	private static int randBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}

	private static Date getRandomPublicationDate() {
		GregorianCalendar gc = new GregorianCalendar();
		int year = randBetween(1900, 2010);
		gc.set(gc.YEAR, year);
		int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
		gc.set(gc.DAY_OF_YEAR, dayOfYear);
		return Date.valueOf(gc.get(Calendar.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH));
	}

	private static String getRandomAuthor() {
		return authorSet.stream().skip(new Random().nextInt(authorSet.size())).findFirst().orElse(null);
	}

	private static String getRandomTopics() {
		Set<String> topics = new HashSet<String>();
		Random random = new Random();
		int size = random.nextInt(topicSet.size());
		for (int count = 0; count < size; count++) {
			topics.add(topicSet.stream().skip(new Random().nextInt(topicSet.size())).findFirst().orElse(null));
		}
		StringBuilder sb = new StringBuilder();
		for (String topic : topics) {
			sb.append(topic).append(",");
		}
		if (!sb.toString().isEmpty()) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	public static List<News> generateNewsList(int size) {
		List<News> newsList = new ArrayList<News>();
		for (int counter = 1; counter <= size; counter++) {
			News news = new News(counter + "", getRandomTitle(), getRandomAbstraction(), getRandomLanguage(),
					getRandomPublicationDate(), getRandomAuthor(), getRandomTopics());
			newsList.add(news);
		}
		return newsList;
	}

	public static void main(String[] args) {
		int size = 10;
		List<News> newsList = generateNewsList(size);
		String path = "src/main/resources/newsList.txt";
		FileOutputUtil.output(newsList, path);
	}
}
