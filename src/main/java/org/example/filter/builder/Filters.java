package org.example.filter.builder;

import org.example.filter.*;
import org.example.filter.composite.*;
import org.example.filter.literal.*;

public final class Filters {

    private Filters() {
    }

    // literals
    public static Filter alwaysTrue() {
        return new TrueFilter();
    }

    public static Filter alwaysFalse() {
        return new FalseFilter();
    }

    // logical
    public static Filter and(Filter... f) {
        return new AndFilter(f);
    }

    public static Filter or (Filter... f) {
        return new OrFilter(f);
    }

    public static Filter not(Filter f) {
        return new NotFilter(f);
    }

    // property entry‑point
    public static PropertyFilterBuilder property(String name) {
        return new PropertyFilterBuilder(name);
    }
}