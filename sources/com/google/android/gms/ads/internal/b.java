package com.google.android.gms.ads.internal;

import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzcu;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class B implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbp f9986a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public B(zzbp zzbpVar) {
        this.f9986a = zzbpVar;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        zzcu zzcuVar;
        zzcu zzcuVar2;
        zzcuVar = this.f9986a.f10240h;
        if (zzcuVar == null) {
            return false;
        }
        zzcuVar2 = this.f9986a.f10240h;
        zzcuVar2.zza(motionEvent);
        return false;
    }
}
