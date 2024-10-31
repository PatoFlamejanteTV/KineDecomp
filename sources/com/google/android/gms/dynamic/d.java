package com.google.android.gms.dynamic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.zza;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements zza.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FrameLayout f1204a;
    final /* synthetic */ LayoutInflater b;
    final /* synthetic */ ViewGroup c;
    final /* synthetic */ Bundle d;
    final /* synthetic */ zza e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(zza zzaVar, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.e = zzaVar;
        this.f1204a = frameLayout;
        this.b = layoutInflater;
        this.c = viewGroup;
        this.d = bundle;
    }

    @Override // com.google.android.gms.dynamic.zza.a
    public int a() {
        return 2;
    }

    @Override // com.google.android.gms.dynamic.zza.a
    public void a(LifecycleDelegate lifecycleDelegate) {
        LifecycleDelegate lifecycleDelegate2;
        this.f1204a.removeAllViews();
        FrameLayout frameLayout = this.f1204a;
        lifecycleDelegate2 = this.e.f1208a;
        frameLayout.addView(lifecycleDelegate2.a(this.b, this.c, this.d));
    }
}
