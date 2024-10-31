package com.google.common.base;

import java.util.Locale;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Platform.java */
/* loaded from: classes2.dex */
public final class l {

    /* renamed from: a */
    private static final Logger f15141a = Logger.getLogger(l.class.getName());

    /* renamed from: b */
    private static final j f15142b = b();

    /* compiled from: Platform.java */
    /* loaded from: classes2.dex */
    public static final class a implements j {
        private a() {
        }

        /* synthetic */ a(k kVar) {
            this();
        }
    }

    private l() {
    }

    public static long a() {
        return System.nanoTime();
    }

    private static j b() {
        return new a();
    }

    public static String a(double d2) {
        return String.format(Locale.ROOT, "%.4g", Double.valueOf(d2));
    }

    public static boolean a(@Nullable String str) {
        return str == null || str.isEmpty();
    }
}
