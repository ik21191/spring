package com.mypack;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class MyCustomWriter implements ItemWriter<String> {

	@Override
	public void write(List<? extends String> list) throws Exception {
		for (String data : list) {
			System.out.println("MyCustomWriter    : Writing data    : " + data);
		}
		System.out.println("MyCustomWriter    : Writing data    : completed");
	}
}
