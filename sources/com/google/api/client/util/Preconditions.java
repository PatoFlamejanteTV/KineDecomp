package com.google.api.client.util;

/* loaded from: classes2.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static void a(boolean z) {
        com.google.common.base.Preconditions.a(z);
    }

    public static void b(boolean z) {
        com.google.common.base.Preconditions.b(z);
    }

    public static void a(boolean z, Object obj) {
        com.google.common.base.Preconditions.a(z, obj);
    }

    public static void b(boolean z, String str, Object... objArr) {
        com.google.common.base.Preconditions.b(z, str, objArr);
    }

    public static void a(boolean z, String str, Object... objArr) {
        com.google.common.base.Preconditions.a(z, str, objArr);
    }

    public static <T> T a(T t) {
        com.google.common.base.Preconditions.a(t);
        return t;
    }

    public static <T> T a(T t, Object obj) {
        com.google.common.base.Preconditions.a(t, obj);
        return t;
    }

    public static <T> T a(T t, String str, Object... objArr) {
        com.google.common.base.Preconditions.a((Object) t, str, objArr);
        return t;
    }
}
