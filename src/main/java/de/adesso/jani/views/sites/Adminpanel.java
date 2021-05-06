package de.adesso.jani.views.sites;

import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.richtexteditor.RichTextEditor;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.adesso.jani.views.main.MainView;
import org.springframework.security.access.annotation.Secured;

@Route(value="admin", layout= MainView.class)
@PageTitle("Adminpanel")
public class Adminpanel extends VerticalLayout {
    public Adminpanel(){
        Chart chart = new Chart(ChartType.PIE);
        Configuration conf = chart.getConfiguration();

        conf.setTitle("Test Chart");

        PlotOptionsPie options = new PlotOptionsPie();
        options.setAnimation(true);
        options.setShadow(true);

        conf.setPlotOptions(options);

        DataSeries data = new DataSeries();
        DataSeriesItem bwlStudenten = new DataSeriesItem("Bwl Studenten", 52);
        bwlStudenten.setSelected(true);
        data.add(bwlStudenten);
        data.add(new DataSeriesItem("Informatik Studenten", 10));
        data.add(new DataSeriesItem("Mediziner", 12));

        conf.setSeries(data);


        Anchor logout = new Anchor("logout", "Logout");
        add(logout);
        add(chart);
    }
}
