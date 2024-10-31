package com.google.android.gms.internal.ads;

import android.webkit.ConsoleMessage;

/* loaded from: classes2.dex */
final /* synthetic */ class Cf {

    /* renamed from: a */
    static final /* synthetic */ int[] f11443a = new int[ConsoleMessage.MessageLevel.values().length];

    static {
        try {
            f11443a[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f11443a[ConsoleMessage.MessageLevel.WARNING.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f11443a[ConsoleMessage.MessageLevel.LOG.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f11443a[ConsoleMessage.MessageLevel.TIP.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f11443a[ConsoleMessage.MessageLevel.DEBUG.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
