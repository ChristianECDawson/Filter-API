package org.example.filter;

import org.example.filter.builder.Filters;
import org.example.filter.visitor.ToStringVisitor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToStringVisitorTest {

    @Test
    void toStringVisitorGeneratesCorrectSimpleFilterString() {
        Filter filter = Filters.property("email").matches(".*@example\\.com");
        String result = filter.accept(new ToStringVisitor());
        assertEquals("match(email, /.*@example\\.com/)", result);
    }

    @Test
    void toStringVisitorGeneratesCorrectCompositeFilterString() {
        Filter filter = Filters.and(
                Filters.property("role").eq("admin"),
                Filters.property("age").gt("30")
        );
        String result = filter.accept(new ToStringVisitor());
        assertEquals("((role == \"admin\") AND (age > \"30\"))", result);
    }

    @Test
    void toStringVisitorGeneratesCorrectNestedLogicalFilterString() {
        Filter filter = Filters.or(
                Filters.and(
                        Filters.property("department").eq("engineering"),
                        Filters.property("level").eq("senior")
                ),
                Filters.not(
                        Filters.property("contract").eq("true")
                )
        );

        String result = filter.accept(new ToStringVisitor());
        assertEquals("(((department == \"engineering\") AND (level == \"senior\")) OR (NOT (contract == \"true\")))", result);
    }
}
