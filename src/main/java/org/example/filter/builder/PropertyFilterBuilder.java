package org.example.filter.builder;

import org.example.filter.Filter;
import org.example.filter.property.*;

public final class PropertyFilterBuilder {
    private final String name;

    PropertyFilterBuilder(String name) {
        this.name = name;
    }

    public Filter present() {
        return new PresentFilter(name);
    }

    public Filter eq(String v) {
        return new EqualsFilter(name, v);
    }

    public Filter lt(String v) {
        return new LessThanFilter(name, v);
    }

    public Filter gt(String v) {
        return new GreaterThanFilter(name, v);
    }

    public Filter matches(String r) {
        return new RegexFilter(name, r);
    }

}