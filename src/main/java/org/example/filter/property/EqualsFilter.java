package org.example.filter.property;

import org.example.filter.visitor.FilterVisitor;

import java.util.Map;

public final class EqualsFilter extends PropertyFilter {

    private final String target;

    public EqualsFilter(String name, String target) {
        super(name);
        this.target = target;
    }

    @Override public boolean matches(Map<String,String> resource) {
        String v = value(resource);
        return v != null && v.equalsIgnoreCase(target);
    }

    @Override
    public <R> R accept(FilterVisitor<R> visitor) {
        return visitor.visitEquals(this);
    }

    public String getTarget(){
        return target;
    }
}