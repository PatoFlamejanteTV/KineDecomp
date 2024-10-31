package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.storage.C0614ub;
import com.adobe.creativesdk.foundation.storage.C0622wb;

/* compiled from: AdobeStorageLibrarySelectionState.java */
/* loaded from: classes.dex */
public class ba {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f5497a;

    /* renamed from: b, reason: collision with root package name */
    private static C0622wb f5498b;

    /* renamed from: c, reason: collision with root package name */
    private static C0614ub f5499c;

    public static void a(C0622wb c0622wb, C0614ub c0614ub) {
        f5498b = c0622wb;
        f5499c = c0614ub;
    }

    public static boolean b() {
        return (f5498b == null || f5499c == null) ? false : true;
    }

    public static boolean c() {
        return f5497a;
    }

    public static C0622wb a() {
        return f5498b;
    }
}
