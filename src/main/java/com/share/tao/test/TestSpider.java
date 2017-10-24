package com.share.tao.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestSpider {
	public static void main(String[] args) {
		new TestSpider();
	}

	public TestSpider() {
		startSpider();
	}

	public void startSpider() {
		
			String url="http://guba.eastmoney.com/list,600020_1.html";
			Document doc = getDocument(url);
			shareParser(doc);
	}

	public void shareParser(Document doc) {
		Elements eles=doc.select("div.articleh");
		for (Element element : eles) {
			String elems=element.select("span.class").text();
			
				System.out.println(elems);
			
		}
	}

	public Document getDocument(String url) {
		Document doc = null;
		try {
			doc = Jsoup.connect(url)
					.userAgent(
							"User-Agent:Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.63 Safari/537.36")
					.header("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
					.header("scheme", "https").header("version", "HTTP/1.1")
					.header("accept-encoding", "gzip, deflate, sdch").header("accept-language", "zh-CN,zh;q=0.8")
					// .header("cookie", "bid=\"Q5KWZL7y8g7\";")
					.header("cache-control", "max-age=0").get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doc;
	}
}
