package com.nexstreaming.app.general.expression;

import com.nexstreaming.app.general.expression.Expression;
import com.nexstreaming.app.general.expression.af;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Expression.java */
/* loaded from: classes.dex */
public final class m implements af.e<Expression.g, Expression.f> {
    @Override // com.nexstreaming.app.general.expression.af.e
    public Expression.g a(String str, Expression.f fVar) {
        Expression.r rVar = fVar.f3127a.get(str);
        if (rVar == null) {
            Expression.r rVar2 = new Expression.r(str);
            fVar.f3127a.put(str, rVar2);
            return rVar2;
        }
        return rVar;
    }
}
