package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;

@ShowFirstParty
@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzv extends com.google.android.gms.analytics.zzi<zzv> {
    private String zzuj;
    public int zzuk;
    public int zzul;
    public int zzum;
    public int zzun;
    public int zzuo;

    public final String getLanguage() {
        return this.zzuj;
    }

    public final void setLanguage(String str) {
        this.zzuj = str;
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put(com.umeng.commonsdk.proguard.e.M, this.zzuj);
        hashMap.put("screenColors", Integer.valueOf(this.zzuk));
        hashMap.put("screenWidth", Integer.valueOf(this.zzul));
        hashMap.put("screenHeight", Integer.valueOf(this.zzum));
        hashMap.put("viewportWidth", Integer.valueOf(this.zzun));
        hashMap.put("viewportHeight", Integer.valueOf(this.zzuo));
        return com.google.android.gms.analytics.zzi.zza((Object) hashMap);
    }

    @Override // com.google.android.gms.analytics.zzi
    public final /* synthetic */ void zzb(zzv zzvVar) {
        zzv zzvVar2 = zzvVar;
        int i = this.zzuk;
        if (i != 0) {
            zzvVar2.zzuk = i;
        }
        int i2 = this.zzul;
        if (i2 != 0) {
            zzvVar2.zzul = i2;
        }
        int i3 = this.zzum;
        if (i3 != 0) {
            zzvVar2.zzum = i3;
        }
        int i4 = this.zzun;
        if (i4 != 0) {
            zzvVar2.zzun = i4;
        }
        int i5 = this.zzuo;
        if (i5 != 0) {
            zzvVar2.zzuo = i5;
        }
        if (TextUtils.isEmpty(this.zzuj)) {
            return;
        }
        zzvVar2.zzuj = this.zzuj;
    }
}
