package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
@zzark
/* loaded from: classes2.dex */
final class zzarx extends Exception {
    private final int mErrorCode;

    public zzarx(String str, int i) {
        super(str);
        this.mErrorCode = i;
    }

    public final int getErrorCode() {
        return this.mErrorCode;
    }
}
