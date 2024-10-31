package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes2.dex */
public final class A implements zzacb {

    /* renamed from: a */
    private final /* synthetic */ View f11360a;

    /* renamed from: b */
    private final /* synthetic */ zzact f11361b;

    public A(zzact zzactVar, View view) {
        this.f11361b = zzactVar;
        this.f11360a = view;
    }

    @Override // com.google.android.gms.internal.ads.zzacb
    public final void zzc(MotionEvent motionEvent) {
        this.f11361b.onTouch(null, motionEvent);
    }

    @Override // com.google.android.gms.internal.ads.zzacb
    public final void zzsh() {
        boolean zza;
        zza = this.f11361b.zza(zzact.zzdcy);
        if (zza) {
            this.f11361b.onClick(this.f11360a);
        }
    }
}
