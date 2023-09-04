package com.chunjae.dto;

public class pasing {
    private int wSize; // 글 개수
    private int pSize; // 페이지 개수
    private int writingCount;
    private int curPage;

    public pasing(int wSize, int pSize, int writingCount, int curPage) {
        this.wSize = wSize;
        this.pSize = pSize;
        this.writingCount = writingCount;
        this.curPage = curPage;
    }

    public int getPageCount()
    {
        return ( (writingCount - 1) / wSize) + 1;
    }

    public int getPageStart()
    {
        return ( ( curPage - 1 ) / pSize ) * pSize + 1;
    }

    public int getPageEnd()
    {
        return Math.min( getPageStart() + pSize - 1 , getPageCount() );
    }

    public boolean isPre()
    {
        return getPageStart() != 1;
    }

    public boolean isNext()
    {
        return getPageEnd() < getPageCount();
    }

    public int getWritingStart()
    {
        return getWritingEnd() - wSize + 1;
    }

    public int getWritingEnd()
    {
        return curPage * wSize;
    }
}
