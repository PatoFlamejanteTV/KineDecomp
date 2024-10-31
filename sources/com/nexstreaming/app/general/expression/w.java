package com.nexstreaming.app.general.expression;

import com.nexstreaming.app.general.expression.Expression;
import com.nexstreaming.app.general.expression.af;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Expression.java */
/* loaded from: classes.dex */
public final class w implements af.e<Expression.g, Expression.f> {
    @Override // com.nexstreaming.app.general.expression.af.e
    public Expression.g a(String str, Expression.f fVar) {
        return new Expression.e(Double.parseDouble(str));
    }
}
