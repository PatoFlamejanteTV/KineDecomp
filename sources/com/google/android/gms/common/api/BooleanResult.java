package com.google.android.gms.common.api;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* loaded from: classes.dex */
public class BooleanResult implements Result {

    /* renamed from: a */
    private final Status f10682a;

    /* renamed from: b */
    private final boolean f10683b;

    @KeepForSdk
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BooleanResult)) {
            return false;
        }
        BooleanResult booleanResult = (BooleanResult) obj;
        return this.f10682a.equals(booleanResult.f10682a) && this.f10683b == booleanResult.f10683b;
    }

    @Override // com.google.android.gms.common.api.Result
    @KeepForSdk
    public Status getStatus() {
        return this.f10682a;
    }

    @KeepForSdk
    public final int hashCode() {
        return ((this.f10682a.hashCode() + 527) * 31) + (this.f10683b ? 1 : 0);
    }
}
