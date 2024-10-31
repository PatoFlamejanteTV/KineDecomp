package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.internal.zzib;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class dm extends zzib.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f1506a;
    final /* synthetic */ zzib.zzb b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dm(Context context, zzib.zzb zzbVar) {
        super(null);
        this.f1506a = context;
        this.b = zzbVar;
    }

    @Override // com.google.android.gms.internal.zzhz
    public void zzbn() {
        SharedPreferences zzv;
        zzv = zzib.zzv(this.f1506a);
        Bundle bundle = new Bundle();
        bundle.putBoolean("use_https", zzv.getBoolean("use_https", true));
        if (this.b != null) {
            this.b.zzd(bundle);
        }
    }
}
