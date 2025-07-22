package org.example.filter.visitor;

import org.example.filter.literal.*;
import org.example.filter.composite.*;
import org.example.filter.property.*;

/***
 * Thoughts on extensions :
 *
 *  - Visitor pattern can be used for generating string representation & third-party extension
 *  - Define visitor interface for each filter
 *  - 'R' generic return type allows use of interface to build, evaluate or transform depending on third-party requirement
 *  -
 */
public interface FilterVisitor<R> {
    R visitTrue(TrueFilter filter);
    R visitFalse(FalseFilter filter);
    R visitAnd(AndFilter filter);
    R visitOr(OrFilter filter);
    R visitNot(NotFilter filter);
    R visitEquals(EqualsFilter filter);
    R visitPresent(PresentFilter filter);
    R visitRegex(RegexFilter filter);
    R visitGreaterThan(GreaterThanFilter filter);
    R visitLessThan(LessThanFilter filter);
}
