package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.google.android.gms.dynamic.zzc;

/* loaded from: classes.dex */
public final class zzh extends zzc.zza {

    /* renamed from: a, reason: collision with root package name */
    private Fragment f1213a;

    private zzh(Fragment fragment) {
        this.f1213a = fragment;
    }

    public static zzh a(Fragment fragment) {
        if (fragment != null) {
            return new zzh(fragment);
        }
        return null;
    }

    @Override // com.google.android.gms.dynamic.zzc
    public zzd a() {
        return zze.a(this.f1213a.getActivity());
    }

    @Override // com.google.android.gms.dynamic.zzc
    public void a(Intent intent) {
        this.f1213a.startActivity(intent);
    }

    @Override // com.google.android.gms.dynamic.zzc
    public void a(Intent intent, int i) {
        this.f1213a.startActivityForResult(intent, i);
    }

    @Override // com.google.android.gms.dynamic.zzc
    public void a(zzd zzdVar) {
        this.f1213a.registerForContextMenu((View) zze.a(zzdVar));
    }

    @Override // com.google.android.gms.dynamic.zzc
    public void a(boolean z) {
        this.f1213a.setHasOptionsMenu(z);
    }

    @Override // com.google.android.gms.dynamic.zzc
    public Bundle b() {
        return this.f1213a.getArguments();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public void b(zzd zzdVar) {
        this.f1213a.unregisterForContextMenu((View) zze.a(zzdVar));
    }

    @Override // com.google.android.gms.dynamic.zzc
    public void b(boolean z) {
        this.f1213a.setMenuVisibility(z);
    }

    @Override // com.google.android.gms.dynamic.zzc
    public int c() {
        return this.f1213a.getId();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public void c(boolean z) {
        this.f1213a.setRetainInstance(z);
    }

    @Override // com.google.android.gms.dynamic.zzc
    public zzc d() {
        return a(this.f1213a.getParentFragment());
    }

    @Override // com.google.android.gms.dynamic.zzc
    public void d(boolean z) {
        this.f1213a.setUserVisibleHint(z);
    }

    @Override // com.google.android.gms.dynamic.zzc
    public zzd e() {
        return zze.a(this.f1213a.getResources());
    }

    @Override // com.google.android.gms.dynamic.zzc
    public boolean f() {
        return this.f1213a.getRetainInstance();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public String g() {
        return this.f1213a.getTag();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public zzc h() {
        return a(this.f1213a.getTargetFragment());
    }

    @Override // com.google.android.gms.dynamic.zzc
    public int i() {
        return this.f1213a.getTargetRequestCode();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public boolean j() {
        return this.f1213a.getUserVisibleHint();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public zzd k() {
        return zze.a(this.f1213a.getView());
    }

    @Override // com.google.android.gms.dynamic.zzc
    public boolean l() {
        return this.f1213a.isAdded();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public boolean m() {
        return this.f1213a.isDetached();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public boolean n() {
        return this.f1213a.isHidden();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public boolean o() {
        return this.f1213a.isInLayout();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public boolean p() {
        return this.f1213a.isRemoving();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public boolean q() {
        return this.f1213a.isResumed();
    }

    @Override // com.google.android.gms.dynamic.zzc
    public boolean r() {
        return this.f1213a.isVisible();
    }
}
