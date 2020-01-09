package com.example.demo.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class PageUtil {
	public static PageRequest getPageRequest(Integer pageIndex, Integer pageSize, Sort sort){
        
        if(pageIndex==null || pageIndex<1){
            pageIndex = 0;
        }else{
            pageIndex = pageIndex-1;
        }
        
        if(pageSize==null || pageSize<1){
            pageSize = 2;
        }
        
        if(sort==null){
            sort = new Sort(Sort.Direction.DESC,"id");
        }
        return PageRequest.of(pageIndex,pageSize,sort);
    }

    public static PageRequest getPageRequest(){
        return getPageRequest(null,null,null);
    }

    public static PageRequest getPageRequest(Integer pageIndex,Integer pageSize){
        return getPageRequest(pageIndex,pageSize,null);
    }
}
