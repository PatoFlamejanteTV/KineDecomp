package com.nexstreaming.app.general.expression;

import com.nexstreaming.app.general.expression.Expression;
import java.util.Deque;

/* compiled from: Expression.java */
/* loaded from: classes.dex */
final class f extends Expression.a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public f() {
        super(null);
    }

    @Override // com.nexstreaming.app.general.expression.Expression.o
    public Expression.Assoc a() {
        return Expression.Assoc.LEFT;
    }

    @Override // com.nexstreaming.app.general.expression.Expression.o
    public Expression.Precd b() {
        return Expression.Precd.RELATIONAL;
    }

    @Override // com.nexstreaming.app.general.expression.Expression.g
    public void a(Deque<Expression.j<?>> deque, ad adVar) throws ExpressionEvalException {
        deque.push(deque.pop().h(deque.pop()) < 0 ? Expression.h : Expression.i);
    }

    public String toString() {
        return "<";
    }
}
