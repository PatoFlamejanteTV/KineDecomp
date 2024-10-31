package com.google.android.gms.common.internal;

import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f extends zze {
    final /* synthetic */ char[] p;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(char[] cArr) {
        this.p = cArr;
    }

    @Override // com.google.android.gms.common.internal.zze
    public boolean b(char c) {
        return Arrays.binarySearch(this.p, c) >= 0;
    }
}
