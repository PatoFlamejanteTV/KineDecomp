package com.nexstreaming.app.general.expression;

import com.nexstreaming.app.general.expression.af;

/* compiled from: Tokenizer.java */
/* loaded from: classes.dex */
final class ai implements af.f {
    @Override // com.nexstreaming.app.general.expression.af.f
    public int a(String str) {
        int length = str.length();
        boolean z = false;
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                if (charAt != '.' || z) {
                    if (i == 1 && z) {
                        return 0;
                    }
                    return i;
                }
                z = true;
            }
        }
        if (length == 1 && z) {
            return 0;
        }
        return length;
    }
}
