package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Map;

@VisibleForTesting
/* renamed from: com.google.firebase.auth.api.internal.b */
/* loaded from: classes2.dex */
final class C1562b implements zzan {

    /* renamed from: a */
    private final int f16450a;

    /* renamed from: b */
    private final int f16451b;

    /* renamed from: c */
    private final Map<String, Integer> f16452c;

    public C1562b(int i, int i2, Map<String, Integer> map) {
        this.f16450a = i;
        this.f16451b = i2;
        Preconditions.a(map);
        this.f16452c = map;
    }

    @Override // com.google.firebase.auth.api.internal.zzan
    public final boolean zzbr(String str) {
        int i = this.f16450a;
        if (i == 0) {
            return true;
        }
        if (this.f16451b <= i) {
            return false;
        }
        Integer num = this.f16452c.get(str);
        if (num == null) {
            num = 0;
        }
        return num.intValue() > this.f16450a && this.f16451b >= num.intValue();
    }
}
