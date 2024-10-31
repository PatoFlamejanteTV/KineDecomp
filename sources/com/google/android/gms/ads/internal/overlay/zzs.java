package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzaoq;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzvt;

@zzark
/* loaded from: classes.dex */
public final class zzs extends zzaoq {

    /* renamed from: a, reason: collision with root package name */
    private AdOverlayInfoParcel f10140a;

    /* renamed from: b, reason: collision with root package name */
    private Activity f10141b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f10142c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f10143d = false;

    public zzs(Activity activity, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.f10140a = adOverlayInfoParcel;
        this.f10141b = activity;
    }

    private final synchronized void A() {
        if (!this.f10143d) {
            if (this.f10140a.f10100c != null) {
                this.f10140a.f10100c.zziv();
            }
            this.f10143d = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void onActivityResult(int i, int i2, Intent intent) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void onBackPressed() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void onCreate(Bundle bundle) {
        zzn zznVar;
        boolean z = bundle != null ? bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false) : false;
        AdOverlayInfoParcel adOverlayInfoParcel = this.f10140a;
        if (adOverlayInfoParcel == null) {
            this.f10141b.finish();
            return;
        }
        if (z) {
            this.f10141b.finish();
            return;
        }
        if (bundle == null) {
            zzvt zzvtVar = adOverlayInfoParcel.f10099b;
            if (zzvtVar != null) {
                zzvtVar.onAdClicked();
            }
            if (this.f10141b.getIntent() != null && this.f10141b.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true) && (zznVar = this.f10140a.f10100c) != null) {
                zznVar.zziw();
            }
        }
        zzbv.b();
        Activity activity = this.f10141b;
        AdOverlayInfoParcel adOverlayInfoParcel2 = this.f10140a;
        if (zza.a(activity, adOverlayInfoParcel2.f10098a, adOverlayInfoParcel2.i)) {
            return;
        }
        this.f10141b.finish();
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void onDestroy() throws RemoteException {
        if (this.f10141b.isFinishing()) {
            A();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void onPause() throws RemoteException {
        zzn zznVar = this.f10140a.f10100c;
        if (zznVar != null) {
            zznVar.onPause();
        }
        if (this.f10141b.isFinishing()) {
            A();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void onRestart() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void onResume() throws RemoteException {
        if (this.f10142c) {
            this.f10141b.finish();
            return;
        }
        this.f10142c = true;
        zzn zznVar = this.f10140a.f10100c;
        if (zznVar != null) {
            zznVar.onResume();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void onSaveInstanceState(Bundle bundle) throws RemoteException {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.f10142c);
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void onStart() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void onStop() throws RemoteException {
        if (this.f10141b.isFinishing()) {
            A();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void zzay() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void zzq(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final boolean zzvq() throws RemoteException {
        return false;
    }
}
