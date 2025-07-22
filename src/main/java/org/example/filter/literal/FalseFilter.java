package org.example.filter.literal;

import org.example.filter.Filter;
import org.example.filter.visitor.FilterVisitor;

import java.util.Map;

public record FalseFilter() implements Filter {

    @Override
    public boolean matches(Map<String, String> resource) {
        return false;
    }

    @Override
    public <R> R accept(FilterVisitor<R> visitor) {
        return visitor.visitFalse(this);
    }
}
