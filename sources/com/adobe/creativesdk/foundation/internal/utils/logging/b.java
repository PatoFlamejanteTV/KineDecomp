package com.adobe.creativesdk.foundation.internal.utils.logging;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLogger.java */
/* loaded from: classes.dex */
public /* synthetic */ class b {

    /* renamed from: a */
    static final /* synthetic */ int[] f6869a = new int[Level.values().length];

    static {
        try {
            f6869a[Level.DEBUG.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f6869a[Level.INFO.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f6869a[Level.ERROR.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f6869a[Level.WARN.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
