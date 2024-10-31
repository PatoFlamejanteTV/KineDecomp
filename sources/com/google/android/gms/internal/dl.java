package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.zzib;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class dl extends zzib.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f1505a;
    final /* synthetic */ boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dl(Context context, boolean z) {
        super(null);
        this.f1505a = context;
        this.b = z;
    }

    @Override // com.google.android.gms.internal.zzhz
    public void zzbn() {
        SharedPreferences zzv;
        zzv = zzib.zzv(this.f1505a);
        SharedPreferences.Editor edit = zzv.edit();
        edit.putBoolean("use_https", this.b);
        edit.apply();
    }
}
