package com.fssearch.ui;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;

public class SearchResult extends GridLayout {
    private static final long serialVersionUID = 1L;

    final FileDto file;

    public SearchResult(FileDto f) {
        setColumns(2);
        setRows(2);
        setSizeFull();
//        content.setMargin(true);
//        content.setSpacing(true);

        file = f;

        Label lName = new Label(f.name);
        Label lSize = new Label(f.size.toPlainString() + " kb");
        Label lPath = new Label(f.path);
        
        addComponent(lName, 0, 0);
        addComponent(lSize, 1, 0);
        addComponent(lPath, 0, 1, 1, 1);
        setComponentAlignment(lSize, Alignment.TOP_RIGHT);
    }
}
