package org.example.filter.literal;

import org.example.filter.Filter;
import org.example.filter.visitor.FilterVisitor;

import java.util.Map;

public record TrueFilter() implements Filter {

    @Override
    public boolean matches(Map<String, String> resource) {
        return true;
    }

    @Override
    public <R> R accept(FilterVisitor<R> visitor) {
        return visitor.visitTrue(this);
    }
}
