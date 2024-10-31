package com.google.android.gms.ads.internal.purchase;

import android.content.Intent;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzgr;

@zzgr
/* loaded from: classes.dex */
public class zzk {

    /* renamed from: a, reason: collision with root package name */
    private final String f619a;

    public zzk(String str) {
        this.f619a = str;
    }

    public String a() {
        return zzp.e().zzgD();
    }

    public boolean a(String str, int i, Intent intent) {
        if (str == null || intent == null) {
            return false;
        }
        String b = zzp.o().b(intent);
        String c = zzp.o().c(intent);
        if (b == null || c == null) {
            return false;
        }
        if (!str.equals(zzp.o().a(b))) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Developer payload not match.");
            return false;
        }
        if (this.f619a == null || zzl.a(this.f619a, b, c)) {
            return true;
        }
        com.google.android.gms.ads.internal.util.client.zzb.e("Fail to verify signature.");
        return false;
    }
}
