package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Cd implements zzbaw {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Context f11439a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f11440b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cd(zzayh zzayhVar, Context context, String str) {
        this.f11439a = context;
        this.f11440b = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbaw
    public final void zzed(String str) {
        com.google.android.gms.ads.internal.zzbv.e();
        zzayh.zzc(this.f11439a, this.f11440b, str);
    }
}
