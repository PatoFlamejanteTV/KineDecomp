package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.internal.zzib;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.do, reason: invalid class name */
/* loaded from: classes.dex */
public final class Cdo extends zzib.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f1508a;
    final /* synthetic */ zzib.zzb b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Cdo(Context context, zzib.zzb zzbVar) {
        super(null);
        this.f1508a = context;
        this.b = zzbVar;
    }

    @Override // com.google.android.gms.internal.zzhz
    public void zzbn() {
        SharedPreferences zzv;
        zzv = zzib.zzv(this.f1508a);
        Bundle bundle = new Bundle();
        bundle.putInt("webview_cache_version", zzv.getInt("webview_cache_version", 0));
        if (this.b != null) {
            this.b.zzd(bundle);
        }
    }
}
