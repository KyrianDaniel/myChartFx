package io.fair_acc.chartfx.utils;

import com.ibm.icu.text.DecimalFormat;

import javafx.util.StringConverter;

public class NumberFormatterImpl extends StringConverter<Number> implements NumberFormatter {
    public final static char DEFAULT_DECIMAL_SEPARATOR = ' ';
    // com.ibm.icu.text.DecimalFormat
    protected DecimalFormat formatter = new DecimalFormat();

    public NumberFormatterImpl() {
        super();
        formatter.setGroupingSize(0);
    }

    public NumberFormatterImpl(final int precision, final boolean exponentialForm) {
        this();
        setPrecision(precision);
        setExponentialForm(exponentialForm);
    }

    @Override
    public Number fromString(final String string) {
        return Double.parseDouble(string);
    }

    public DecimalFormat getFormatter() {
        return formatter;
    }

    /*
     * (non-Javadoc)
     *
     * @see io.fair_acc.chartfx.utils.NumberFormatter#getPrecision()
     */
    @Override
    public int getPrecision() {
        return formatter.getMinimumSignificantDigits();
    }

    @Override
    public boolean isExponentialForm() {
        return formatter.isScientificNotation();
    }

    @Override
    public NumberFormatter setExponentialForm(final boolean state) {
        // formatter.setExponentSignAlwaysShown(true);
        formatter.setScientificNotation(state);
        return this;
    }

    /*
     * (non-Javadoc)
     *
     * @see io.fair_acc.chartfx.utils.NumberFormatter#setPrecision(int)
     */
    @Override
    public NumberFormatter setPrecision(final int precision) {
        formatter.setSignificantDigitsUsed(true);
        // formatter.setMaximumSignificantDigits(precision);
        formatter.setMinimumSignificantDigits(precision);
        formatter.setMinimumFractionDigits(2);
        formatter.setMaximumFractionDigits(2);
        return this;
    }

    @Override
    public String toString(final double val) {
        return formatter.format(val);
    }

    @Override
    public String toString(final Number object) {
        return toString(object.doubleValue());
    }

}
