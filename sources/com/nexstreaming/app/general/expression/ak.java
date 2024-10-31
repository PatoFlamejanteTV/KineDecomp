package com.nexstreaming.app.general.expression;

import com.facebook.internal.Utility;
import com.nexstreaming.app.general.expression.af;

/* compiled from: Tokenizer.java */
/* loaded from: classes.dex */
final class ak implements af.f {
    @Override // com.nexstreaming.app.general.expression.af.f
    public int a(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            switch (str.charAt(i)) {
                case '\t':
                case '\n':
                case 11:
                case '\f':
                case '\r':
                case ' ':
                case 133:
                case 160:
                case 5760:
                case 6158:
                case Utility.DEFAULT_STREAM_BUFFER_SIZE /* 8192 */:
                case 8193:
                case 8194:
                case 8195:
                case 8196:
                case 8197:
                case 8198:
                case 8199:
                case 8200:
                case 8201:
                case 8202:
                case 8232:
                case 8233:
                case 8239:
                case 8287:
                case 12288:
                default:
                    return i;
            }
        }
        return length;
    }
}
