package com.example.bodymanagement.Unit;

import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;

public class SpringDataPageAble implements Pageable {
    @Override
    public int getNumberOfPages() {
        return 0;
    }

    @Override
    public PageFormat getPageFormat(int pageIndex) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public Printable getPrintable(int pageIndex) throws IndexOutOfBoundsException {
        return null;
    }
}
