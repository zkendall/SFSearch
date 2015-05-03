package com.fssearch.ui;

import java.util.Collection;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.filter.SimpleStringFilter;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;

public class ResultsList extends Grid {
    private static final long serialVersionUID = 1L;
    private BeanItemContainer<FileDto> container;

    private static final String NAME_COL = "name";
    private static final String SIZE_COL = "size";
    private static final String PATH_COL = "path";

    @SuppressWarnings("unchecked")
    public ResultsList() {
        super(new BeanItemContainer<>(FileDto.class));
        container = (BeanItemContainer<FileDto>) getContainerDataSource();
        setColumnOrder(NAME_COL, SIZE_COL, PATH_COL);

        setSizeFull();
        setSelectionMode(SelectionMode.NONE);
        
        setColumnSizes();
        setFilterHeader();
    }

    private void setColumnSizes() {
        getColumn(NAME_COL).setExpandRatio(2);
        getColumn(SIZE_COL).setExpandRatio(1);
        getColumn(PATH_COL).setExpandRatio(8);
    }

    private void setFilterHeader() {
        HeaderRow filterRow = appendHeaderRow();

        HeaderCell nameCell = filterRow.getCell(NAME_COL);
        TextField filterField = new TextField();
        filterField.setSizeFull();
        filterField.addTextChangeListener(new TextChangeListener() {
            private static final long serialVersionUID = 1L;

            @Override
            public void textChange(TextChangeEvent event) {
                container.removeContainerFilters(NAME_COL);
                if (!event.getText().isEmpty())
                    container.addContainerFilter(new SimpleStringFilter(NAME_COL, event.getText(), true, false));
            }
        });
        nameCell.setComponent(filterField);

    }

    public void buildList(Collection<FileDto> files) {
        container.removeAllItems();
        container.addAll(files);

        setColumnSizes();
    }

}
