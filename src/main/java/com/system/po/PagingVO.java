package com.system.po;

/**
 *  分页信息 pojo类
 */
public class PagingVO {

    //总记录数
    private int totalCount;
    //总页数
    private int totalPage;
    //页面容量
    private int pageSize = 5;
    //当前页码,默认第一页
    private int currentPageNo = 1;
    //上一页
    private int upPageNo;
    //下一页
    private int nextPageNo;
    //到某页
    private int toPageNo = 1;
    //起始位置
    private int startNo = 0;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        if (totalCount % pageSize > 0){
            this.totalPage = (totalCount/pageSize) + 1;
        } else {
            this.totalPage = totalCount/totalPage;
        }
        return totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPageNo() {
        return currentPageNo;
    }

    public void setCurrentPageNo(int currentPageNo) {
        this.currentPageNo = currentPageNo;
    }

    public int getUpPageNo() {
        if (currentPageNo != 1) {
            return currentPageNo - 1;
        } else {
            return 1;
        }
    }

    public int getNextPageNo() {
        if (currentPageNo < totalPage) {
            return currentPageNo + 1;
        } else {
            return totalPage;
        }
    }

    public int getToPageNo() {
        return toPageNo;
    }

    public void setToPageNo(int toPageNo) {
        this.toPageNo = toPageNo;
        this.startNo = (toPageNo-1)*pageSize;
    }

    public int getStartNo() {
        return  startNo;
    }
}
