package com.google.api.client.util;

/* loaded from: classes.dex */
public final class Preconditions {
    public static void a(boolean z) {
        com.google.api.client.repackaged.com.google.common.base.Preconditions.a(z);
    }

    public static void a(boolean z, Object obj) {
        com.google.api.client.repackaged.com.google.common.base.Preconditions.a(z, obj);
    }

    public static void a(boolean z, String str, Object... objArr) {
        com.google.api.client.repackaged.com.google.common.base.Preconditions.a(z, str, objArr);
    }

    public static void b(boolean z) {
        com.google.api.client.repackaged.com.google.common.base.Preconditions.b(z);
    }

    public static void b(boolean z, String str, Object... objArr) {
        com.google.api.client.repackaged.com.google.common.base.Preconditions.b(z, str, objArr);
    }

    public static <T> T a(T t) {
        return (T) com.google.api.client.repackaged.com.google.common.base.Preconditions.a(t);
    }

    public static <T> T a(T t, Object obj) {
        return (T) com.google.api.client.repackaged.com.google.common.base.Preconditions.a(t, obj);
    }

    public static <T> T a(T t, String str, Object... objArr) {
        return (T) com.google.api.client.repackaged.com.google.common.base.Preconditions.a(t, str, objArr);
    }

    private Preconditions() {
    }
}
