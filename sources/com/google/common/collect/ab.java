package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

/* compiled from: Hashing.java */
@GwtCompatible
/* loaded from: classes2.dex */
final class ab {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i) {
        int i2 = ((i >>> 20) ^ (i >>> 12)) ^ i;
        return (i2 >>> 4) ^ ((i2 >>> 7) ^ i2);
    }
}
