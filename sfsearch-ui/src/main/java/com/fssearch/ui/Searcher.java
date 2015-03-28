package com.fssearch.ui;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class Searcher extends VerticalLayout {
    private static final long serialVersionUID = 1L;

    private Random rand = new Random();

    TextField search = new TextField();
    ResultsList results = new ResultsList();

    public Searcher() {
        setMargin(true);
        setDefaultComponentAlignment(Alignment.TOP_CENTER);
        setSizeUndefined();

        search.setWidth("500px");

        build();
    }

    private void build() {
        
        search.addTextChangeListener(new TextChangeListener() {
            private static final long serialVersionUID = 1L;

            @Override
            public void textChange(TextChangeEvent event) {
                results.buildList(mockResults(event.getText()));
            }
        });

        addComponents(search, results);
    }

    private ArrayList<FileDto> mockResults(String search) {
        ArrayList<FileDto> results = new ArrayList<FileDto>();
        for (int i = 0; i <= rand.nextInt(15)+4; i++) {
            results.add(new FileDto(search, "C:/bla/bla", new BigDecimal(i * rand.nextInt(1000))));
        }
        return results;
    }
}
