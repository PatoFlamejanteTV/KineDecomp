package com.squareup.wire;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Preconditions.java */
/* loaded from: classes.dex */
public final class l {
    public static void a(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw new NullPointerException(str + " == null");
    }
}
