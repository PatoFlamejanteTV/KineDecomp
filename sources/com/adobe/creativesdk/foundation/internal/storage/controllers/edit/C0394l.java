package com.adobe.creativesdk.foundation.internal.storage.controllers.edit;

import android.support.v4.app.FragmentManager;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;

/* compiled from: AdobeCCFilesEditManager.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.edit.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0394l {

    /* renamed from: a, reason: collision with root package name */
    static C0399q f6046a = null;

    /* renamed from: b, reason: collision with root package name */
    static boolean f6047b = false;

    /* renamed from: c, reason: collision with root package name */
    static boolean f6048c = false;

    /* renamed from: d, reason: collision with root package name */
    static boolean f6049d = true;

    /* renamed from: e, reason: collision with root package name */
    static double f6050e;

    public static void a(double d2) {
        f6050e = d2;
    }

    public static double b() {
        return f6050e;
    }

    public static boolean c() {
        return f6049d;
    }

    public static boolean d() {
        return f6048c;
    }

    public static boolean e() {
        return f6047b;
    }

    public static void a(boolean z) {
        f6049d = z;
    }

    public static void b(boolean z) {
        f6047b = z;
    }

    public static void c(boolean z) {
        f6048c = z;
    }

    public static C0399q a(FragmentManager fragmentManager, AdobeCCFilesEditOperation adobeCCFilesEditOperation, J j, AdobeCloud adobeCloud) {
        f6046a = new C0399q(fragmentManager, adobeCCFilesEditOperation, j, adobeCloud);
        return f6046a;
    }

    public static C0399q a(String str, FragmentManager fragmentManager, AdobeCCFilesEditOperation adobeCCFilesEditOperation, J j, AdobeCloud adobeCloud) {
        f6046a = new C0399q(str, fragmentManager, adobeCCFilesEditOperation, j, adobeCloud);
        return f6046a;
    }

    public static C0399q a() {
        return f6046a;
    }
}
