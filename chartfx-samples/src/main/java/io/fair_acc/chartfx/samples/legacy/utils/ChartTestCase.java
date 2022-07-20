package io.fair_acc.chartfx.samples.legacy.utils;

import javafx.scene.Node;

public interface ChartTestCase {

    Node getChart(final int nSamples);

    void setNumberOfSamples(final int nSamples);

    void updateDataSet();
}
