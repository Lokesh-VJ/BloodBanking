package net.bloodbanking.dto;

import java.util.ArrayList;
import java.util.List;

import net.bloodbanking.utils.Page;

public class ListDTO<T extends BaseDTO> extends BaseDTO {
	
	private List<T> list = new ArrayList<T>();
	
	private Page page;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
