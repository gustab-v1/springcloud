package com.leyou.search.pojo;

public class SearchRequest {
    private String key;                             //搜索字段
    private Integer page;                           //当前页
    private static final Integer DEFAULT_SIZE = 20; //每页大小
    private static final Integer DEFAULT_PAGE = 1;  //默认页

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getPage() {
        if (page == null){
            return DEFAULT_PAGE;
        }
        return Math.max(DEFAULT_PAGE,page);
    }

    public void setPage(int page) {
        this.page = page;
    }

    public static Integer getSize() {
        return DEFAULT_SIZE;
    }
}
