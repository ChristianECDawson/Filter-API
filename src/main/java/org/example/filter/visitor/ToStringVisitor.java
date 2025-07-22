package org.example.filter.visitor;

import org.example.filter.composite.*;
import org.example.filter.literal.*;
import org.example.filter.property.*;

import java.util.stream.Collectors;

public class ToStringVisitor implements FilterVisitor<String> {

    @Override
    public String visitTrue(TrueFilter filter) {
        return "TRUE";
    }

    @Override
    public String visitFalse(FalseFilter filter) {
        return "FALSE";
    }

    @Override
    public String visitAnd(AndFilter filter) {
        return "(" + filter.getFilters().stream()
                .map(f -> f.accept(this))
                .collect(Collectors.joining(" AND ")) + ")";
    }

    @Override
    public String visitOr(OrFilter filter) {
        return "(" + filter.getFilters().stream()
                .map(f -> f.accept(this))
                .collect(Collectors.joining(" OR ")) + ")";
    }

    @Override
    public String visitNot(NotFilter filter) {
        return "(NOT " + filter.filter().accept(this) + ")";
    }

    @Override
    public String visitEquals(EqualsFilter filter) {
        return String.format("(%s == \"%s\")", filter.getName(), filter.getTarget());
    }

    @Override
    public String visitGreaterThan(GreaterThanFilter filter) {
        return String.format("(%s > \"%s\")", filter.getName(), filter.getTarget());
    }

    @Override
    public String visitLessThan(LessThanFilter filter) {
        return String.format("(%s < \"%s\")", filter.getName(), filter.getTarget());
    }

    @Override
    public String visitPresent(PresentFilter filter) {
        return String.format("present(%s)", filter.getName());
    }

    @Override
    public String visitRegex(RegexFilter filter) {
        return String.format("match(%s, /%s/)", filter.getName(), filter.getPattern().pattern());
    }
}

