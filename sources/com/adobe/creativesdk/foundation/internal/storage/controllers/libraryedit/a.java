package com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit;

import android.support.v4.app.FragmentManager;

/* compiled from: AdobeDesignLibraryEditManager.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    static l f6193a = null;

    /* renamed from: b, reason: collision with root package name */
    static boolean f6194b = false;

    /* renamed from: c, reason: collision with root package name */
    static boolean f6195c = false;

    /* renamed from: d, reason: collision with root package name */
    static boolean f6196d = true;

    /* renamed from: e, reason: collision with root package name */
    static boolean f6197e = false;

    /* renamed from: f, reason: collision with root package name */
    static double f6198f;

    public static void a(boolean z) {
        f6196d = z;
    }

    public static double b() {
        return f6198f;
    }

    public static boolean c() {
        return f6196d;
    }

    public static void d(boolean z) {
        f6197e = z;
    }

    public static boolean e() {
        return f6194b;
    }

    public static boolean f() {
        return f6197e;
    }

    public static l a(String str, FragmentManager fragmentManager, AdobeDesignLibraryEditOperation adobeDesignLibraryEditOperation, x xVar) {
        f6193a = new l(str, fragmentManager, adobeDesignLibraryEditOperation, xVar);
        return f6193a;
    }

    public static void b(boolean z) {
        f6194b = z;
    }

    public static void c(boolean z) {
        f6195c = z;
    }

    public static boolean d() {
        return f6195c;
    }

    public static l a() {
        return f6193a;
    }
}
