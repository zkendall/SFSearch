package com.fssearch.ui;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
@Widgetset("com.fssearch.AppWidgetset")
public class MyUI extends UI {
    private static final long serialVersionUID = 1L;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        final Searcher search = new Searcher();
        VerticalLayout main = new VerticalLayout(search);
        main.setSizeFull();
        main.setComponentAlignment(search, Alignment.TOP_CENTER);
        setContent(main);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
        private static final long serialVersionUID = 1L;
    }
}
