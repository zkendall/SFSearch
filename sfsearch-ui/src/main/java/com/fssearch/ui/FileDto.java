package com.fssearch.ui;

import java.io.Serializable;
import java.math.BigDecimal;

public class FileDto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    final String name;
    final String path;
    final BigDecimal size;

    public FileDto(String n, String p, BigDecimal s) {
        this.name = n;
        this.path = p;
        this.size = s;
    }
}
