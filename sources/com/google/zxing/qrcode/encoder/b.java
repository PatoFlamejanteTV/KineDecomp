package com.google.zxing.qrcode.encoder;

import com.google.zxing.qrcode.decoder.Mode;

/* compiled from: Encoder.java */
/* loaded from: classes2.dex */
/* synthetic */ class b {

    /* renamed from: a */
    static final /* synthetic */ int[] f19262a = new int[Mode.values().length];

    static {
        try {
            f19262a[Mode.NUMERIC.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f19262a[Mode.ALPHANUMERIC.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f19262a[Mode.BYTE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f19262a[Mode.KANJI.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
