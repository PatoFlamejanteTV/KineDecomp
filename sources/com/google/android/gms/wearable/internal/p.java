package com.google.android.gms.wearable.internal;

import com.google.android.gms.internal.zzlm;
import com.google.android.gms.wearable.CapabilityApi;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p implements zzlm.zzb<CapabilityApi.CapabilityListener> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CapabilityInfoParcelable f2379a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(CapabilityInfoParcelable capabilityInfoParcelable) {
        this.f2379a = capabilityInfoParcelable;
    }

    @Override // com.google.android.gms.internal.zzlm.zzb
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zzq(CapabilityApi.CapabilityListener capabilityListener) {
        capabilityListener.a(this.f2379a);
    }

    @Override // com.google.android.gms.internal.zzlm.zzb
    public void zznN() {
    }
}
