package com.nexstreaming.app.general.expression;

import com.nexstreaming.app.general.expression.af;

/* compiled from: Tokenizer.java */
/* loaded from: classes.dex */
final class aj implements af.f {
    @Override // com.nexstreaming.app.general.expression.af.f
    public int a(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt >= '0' && charAt <= '9') {
                i++;
            } else {
                return i;
            }
        }
        return length;
    }
}
