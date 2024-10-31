package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.zzib;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class dn extends zzib.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f1507a;
    final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dn(Context context, int i) {
        super(null);
        this.f1507a = context;
        this.b = i;
    }

    @Override // com.google.android.gms.internal.zzhz
    public void zzbn() {
        SharedPreferences zzv;
        zzv = zzib.zzv(this.f1507a);
        SharedPreferences.Editor edit = zzv.edit();
        edit.putInt("webview_cache_version", this.b);
        edit.apply();
    }
}
