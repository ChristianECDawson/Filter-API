package org.example.filter;

import org.example.filter.visitor.FilterVisitor;

import java.util.Map;

public interface Filter {

    boolean matches(Map<String, String> resource);

    <R> R accept(FilterVisitor<R> visitor);
}