package com.fssearch.ui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fssearch.da.FileLogService;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class Searcher extends VerticalLayout {
    private static final long serialVersionUID = 1L;

    TextField search = new TextField();
    ResultsList results = new ResultsList();

    public Searcher() {
        setMargin(true);
        setSpacing(true);
        
        setDefaultComponentAlignment(Alignment.TOP_CENTER);
        setSizeFull();
        addComponents(search, results);
        setExpandRatio(results, 1f);

        search.addTextChangeListener(new TextChangeListener() {
            private static final long serialVersionUID = 1L;

            @Override
            public void textChange(TextChangeEvent event) {
                results.buildList(search(event.getText()));
            }
        });

    }

    /**
     * A lot of sophistication to be added here.
     */
    private List<FileDto> search(String search) {
        List<FileDto> results = new ArrayList<FileDto>(0);
        try {
            results = FileLogService.queryAllLog();
            Iterator<FileDto> iterator = results.iterator();
            while (iterator.hasNext()) {
                FileDto dto = iterator.next();
                if (!dto.name.contains(search)) {
                    iterator.remove();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }
}
