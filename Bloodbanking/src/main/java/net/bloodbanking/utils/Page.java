package net.bloodbanking.utils;

import java.io.Serializable;
import java.util.List;

import net.bloodbanking.dto.BaseDTO;

public class Page implements Serializable {

	private static final long serialVersionUID = 6373680924240705879L;

	public Integer startPage = 0 ;
	
	public Integer endPage = 0 ;
	
	public Integer currentPage = 1 ;
	
	public Integer resultsPerPage = 0 ;
	
	public Integer totalCount = 0 ;
	
	public Integer totalPages = 0 ;
	
	public Integer currentPageSize = 0;
	
	public List<BaseDTO> results = null ;
	
	public Integer getStartPage() {
		return startPage;
	}
	
	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}
	
	public Integer getEndPage() {
		return endPage;
	}
	
	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}
	
	public Integer getResultsPerPage() {
		return resultsPerPage;
	}
	
	public void setResultsPerPage(Integer resultsPerPage) {
		this.resultsPerPage = resultsPerPage;
	}
	
	public Integer getTotalCount() {
		return totalCount;
	}
	
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	
	public Integer getTotalPages() {
		return totalPages;
	}
	
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	
	public List<BaseDTO> getResults() {
		return results;
	}
	
	public void setResults(List<BaseDTO> results) {
		this.results = results;
	}
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	public Integer getCurrentPageSize() {
		return currentPageSize;
	}
	
	public void setCurrentPageSize(Integer currentPageSize) {
		this.currentPageSize = currentPageSize;
	}
	
}
