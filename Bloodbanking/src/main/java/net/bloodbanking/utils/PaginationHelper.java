package net.bloodbanking.utils;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import net.bloodbanking.dto.BaseDTO;
import net.bloodbanking.dto.ListDTO;

public class PaginationHelper {
	
	@SuppressWarnings("unchecked")
	public static Page getPage( ListDTO<? extends BaseDTO> list , Integer resultsPerPage, Integer pageNumber ){

		Page page = new Page(); 
		page.resultsPerPage = resultsPerPage ;
		page.totalCount = list != null ?  list.getTotalSize() : 0 ;
		page.totalPages = (int) Math.ceil( page.totalCount.floatValue() / page.resultsPerPage.floatValue());
		page.currentPage = pageNumber > page.totalPages || pageNumber < 1 ? 1 : pageNumber ;
		
		if(page.currentPage.equals(page.totalPages)){
			page.startPage = ( page.currentPage - 9 > 1 ) ? page.currentPage - 9 : 1 ;
		} else {
			page.startPage = ( page.currentPage - 4 > 1 ) ? page.currentPage - 4 : 1 ;
		}

		page.endPage = ( page.startPage + 9 < page.totalPages ) ? page.startPage + 9 : page.totalPages ;
		page.currentPageSize = ( list != null && CollectionUtils.isNotEmpty(list.getList()) ? list.getList().size() : 0) ;
		page.results =(List<BaseDTO>) (list != null ? list.getList() : null) ;

		return page; 

	}

}
