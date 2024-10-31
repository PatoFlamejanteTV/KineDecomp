package com.nexstreaming.app.general.expression;

import com.nexstreaming.app.general.expression.Expression;
import java.util.Deque;

/* compiled from: Expression.java */
/* loaded from: classes.dex */
final class u extends Expression.a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public u() {
        super(null);
    }

    @Override // com.nexstreaming.app.general.expression.Expression.o
    public Expression.Assoc a() {
        return Expression.Assoc.LEFT;
    }

    @Override // com.nexstreaming.app.general.expression.Expression.o
    public Expression.Precd b() {
        return Expression.Precd.BITWISE;
    }

    @Override // com.nexstreaming.app.general.expression.Expression.g
    public void a(Deque<Expression.j<?>> deque, ad adVar) throws ExpressionEvalException {
        Expression.j<?> pop = deque.pop();
        deque.push(new Expression.i(pop.b() & deque.pop().b()));
    }

    public String toString() {
        return "&";
    }
}
