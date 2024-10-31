package com.nexstreaming.app.general.expression;

import com.nexstreaming.app.general.expression.Expression;
import java.util.Deque;

/* compiled from: Expression.java */
/* loaded from: classes.dex */
final class v extends Expression.d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public v() {
        super(null);
    }

    @Override // com.nexstreaming.app.general.expression.Expression.g
    public void a(Deque<Expression.j<?>> deque, ad adVar) throws ExpressionEvalException {
        throw new RuntimeException("Bad state : attempt to execute delimeter.");
    }
}
