package com.squareup.wire;

/* compiled from: Preconditions.java */
/* loaded from: classes.dex */
final class l {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str + " == null");
        }
    }
}
