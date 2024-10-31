package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;

@VisibleForTesting
/* renamed from: com.facebook.ads.redexgen.X.Es, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC0378Es<T> {
    public EnumC0384Ey A00;

    @Nullable
    public abstract T A03();

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Es != com.facebook.ads.internal.database.AdDatabaseQuery<T> */
    public final EnumC0384Ey A00() {
        return this.A00;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Es != com.facebook.ads.internal.database.AdDatabaseQuery<T> */
    public final void A01(EnumC0384Ey enumC0384Ey) {
        this.A00 = enumC0384Ey;
    }
}
