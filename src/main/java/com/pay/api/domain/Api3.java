package com.pay.api.domain;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @ToString
public class Api3 {
	
	private String year;

    private List<Api3Detail> dataList;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public List<Api3Detail> getDataList() {
		return dataList;
	}

	public void setDataList(List<Api3Detail> dataList) {
		this.dataList = dataList;
	}
	
	
}
