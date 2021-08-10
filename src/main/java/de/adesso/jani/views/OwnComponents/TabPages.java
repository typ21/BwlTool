package de.adesso.jani.views.OwnComponents;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;

import java.util.HashMap;
import java.util.Map;
@CssImport("./components/card.css")
public class TabPages extends VerticalLayout {

    Tabs tabs = new Tabs();

    Map<Tab, VerticalLayout> map = new HashMap<>();

    public TabPages(){
        listener();
        build();
    }

    private void build() {
        add(tabs);
    }

    private void listener() {
        tabs.addSelectedChangeListener(event -> {
            map.values().forEach(page -> page.setVisible(false));
            map.get(tabs.getSelectedTab()).setVisible(true);
        });
    }

    public VerticalLayout createPage(String title){
        VerticalLayout page = new VerticalLayout();
        Tab tab = new Tab(title);
        map.put(tab, page);
        page.setVisible(false);
        tabs.add(tab);
        add(page);
        return page;
    }

    public void selectTab(int index){
        tabs.setSelectedIndex(index);
    }
}