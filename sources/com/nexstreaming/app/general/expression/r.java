package com.nexstreaming.app.general.expression;

import com.nexstreaming.app.general.expression.Expression;
import java.util.Deque;

/* compiled from: Expression.java */
/* loaded from: classes.dex */
final class r extends Expression.s {
    /* JADX INFO: Access modifiers changed from: package-private */
    public r() {
        super(null);
    }

    @Override // com.nexstreaming.app.general.expression.Expression.o
    public Expression.Assoc a() {
        return Expression.Assoc.LEFT;
    }

    @Override // com.nexstreaming.app.general.expression.Expression.o
    public Expression.Precd b() {
        return Expression.Precd.UNARYNOT;
    }

    @Override // com.nexstreaming.app.general.expression.Expression.g
    public void a(Deque<Expression.j<?>> deque, ad adVar) throws ExpressionEvalException {
        deque.push(new Expression.i(deque.pop().b() ^ (-1)));
    }

    public String toString() {
        return "~";
    }
}
