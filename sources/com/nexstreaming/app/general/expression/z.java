package com.nexstreaming.app.general.expression;

import com.nexstreaming.app.general.expression.Expression;
import java.util.Deque;

/* compiled from: Expression.java */
/* loaded from: classes.dex */
final class z extends Expression.s {
    /* JADX INFO: Access modifiers changed from: package-private */
    public z() {
        super(null);
    }

    @Override // com.nexstreaming.app.general.expression.Expression.o
    public Expression.Assoc a() {
        return Expression.Assoc.RIGHT;
    }

    @Override // com.nexstreaming.app.general.expression.Expression.o
    public Expression.Precd b() {
        return Expression.Precd.UNARYNEG;
    }

    @Override // com.nexstreaming.app.general.expression.Expression.g
    public void a(Deque<Expression.j<?>> deque, ad adVar) throws ExpressionEvalException {
        deque.push(deque.pop().f());
    }

    public String toString() {
        return "[+]";
    }
}
