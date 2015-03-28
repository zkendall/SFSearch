package com.fssearch.ui;

import java.util.ArrayList;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.VerticalLayout;

public class ResultsList extends VerticalLayout {
    private static final long serialVersionUID = 1L;

    private ArrayList<SearchResult> results = new ArrayList<>();

    public ResultsList() {
        setMargin(true);
        setSpacing(true);
        setDefaultComponentAlignment(Alignment.TOP_LEFT);
    }

    private void reset() {
        results.clear();
        removeAllComponents();
    }

    public void buildList(ArrayList<FileDto> files) {
        reset();
        for (FileDto file : files) {
            SearchResult result = new SearchResult(file);
            results.add(result);
            addComponent(result);
        }
//        addComponents(files.toArray(new Component[files.size()]));
    }

}
