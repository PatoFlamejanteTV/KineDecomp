package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.zzlm;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataEventBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j implements zzlm.zzb<DataApi.DataListener> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ DataHolder f2373a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(DataHolder dataHolder) {
        this.f2373a = dataHolder;
    }

    @Override // com.google.android.gms.internal.zzlm.zzb
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void zzq(DataApi.DataListener dataListener) {
        try {
            dataListener.a(new DataEventBuffer(this.f2373a));
        } finally {
            this.f2373a.i();
        }
    }

    @Override // com.google.android.gms.internal.zzlm.zzb
    public void zznN() {
        this.f2373a.i();
    }
}
