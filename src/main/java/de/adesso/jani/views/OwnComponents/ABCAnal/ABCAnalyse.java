package de.adesso.jani.views.OwnComponents.ABCAnal;

import com.vaadin.flow.component.notification.Notification;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ABCAnalyse {

    private final List<ABCElement> abcElements;

    private double aSum;
    private double bSum;
    private double cSum;

    public ABCAnalyse(List<ABCElement> abcElements) {
        this.abcElements = abcElements;

        this.aSum = 0;
        this.bSum = 0;
        this.cSum = 0;
    }

    public List<ABCElement> analyze(double aSize, double bSize, double cSize) {

        assert (aSize + bSize + cSize == 1);

        double sum = abcElements.stream().mapToDouble(ABCElement::getUmsatz).reduce(0.0, Double::sum);

        return abcElements.stream().peek(e -> e.setPercentage(e.getUmsatz() / sum)).sorted((o1, o2) ->
            Double.compare(o2.getPercentage(), o1.getPercentage())
        ).
                peek(new Consumer<>() {
                    double currentSum = 0;

                    @Override
                    public void accept(ABCElement abcElement) {
                        this.currentSum += abcElement.getPercentage();
                        abcElement.setPercentageCum(currentSum);

                        if (currentSum <= aSize + 0.01) {
                            abcElement.setGroup('a');
                            aSum = currentSum;
                        } else if (currentSum > aSize && currentSum <= (aSize + bSize)) {
                            abcElement.setGroup('b');
                            bSum = (currentSum-aSum);
                        } else if (currentSum > (aSize + bSize) && currentSum <= 1) {
                            abcElement.setGroup('c');
                            cSum = (currentSum - (aSum + bSum));
                        } else {
                            Notification.show("Hier ist etwas schiefgelaufen. Bitte überprüfe die Werte" +
                                    " und versuche es nochmal!");
                        }

                    }
                }).collect(Collectors.toList());

    }

    public double getASum() {
        return aSum;
    }

    public double getBSum() {
        return bSum;
    }

    public double getCSum() {
        return cSum;
    }
}
