package org.example.filter.property;

import org.example.filter.visitor.FilterVisitor;

import java.util.Map;

public final class PresentFilter extends PropertyFilter {

    public PresentFilter(String name) {
        super(name);
    }

    @Override public boolean matches(Map<String,String> resource) {
        return resource.containsKey(name);
    }

    @Override
    public <R> R accept(FilterVisitor<R> visitor) {
        return visitor.visitPresent(this);
    }
}