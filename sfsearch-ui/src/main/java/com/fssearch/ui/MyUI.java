package com.fssearch.ui;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;

@Theme("mytheme")
@Widgetset("com.fssearch.AppWidgetset")
public class MyUI extends UI {
    private static final long serialVersionUID = 1L;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Panel panel = new Panel();
        panel.setSizeFull();
        final Searcher search = new Searcher();
        panel.setContent(search);
        setContent(panel);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
        private static final long serialVersionUID = 1L;
    }
}
