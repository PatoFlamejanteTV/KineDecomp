package com.nexstreaming.app.general.tracelog;

import com.nexstreaming.app.general.tracelog.AppUsage;

/* compiled from: AppUsage.java */
/* loaded from: classes2.dex */
public /* synthetic */ class b {

    /* renamed from: a */
    static final /* synthetic */ int[] f19780a;

    /* renamed from: b */
    static final /* synthetic */ int[] f19781b = new int[AppUsage.MetricType.values().length];

    static {
        try {
            f19781b[AppUsage.MetricType.Counter.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f19781b[AppUsage.MetricType.Peak.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f19781b[AppUsage.MetricType.Total.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f19781b[AppUsage.MetricType.Value.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        f19780a = new int[AppUsage.ReportingMode.values().length];
        try {
            f19780a[AppUsage.ReportingMode.FLURRY.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f19780a[AppUsage.ReportingMode.NEXSTREAMING_USAGEAPP.ordinal()] = 2;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
