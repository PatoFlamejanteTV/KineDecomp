package com.facebook.appevents.internal;

/* compiled from: AutomaticAnalyticsLogger.java */
/* loaded from: classes.dex */
/* synthetic */ class f {

    /* renamed from: a */
    static final /* synthetic */ int[] f9191a = new int[SubscriptionType.values().length];

    static {
        try {
            f9191a[SubscriptionType.RESTORE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f9191a[SubscriptionType.CANCEL.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f9191a[SubscriptionType.HEARTBEAT.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f9191a[SubscriptionType.EXPIRE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f9191a[SubscriptionType.NEW.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
