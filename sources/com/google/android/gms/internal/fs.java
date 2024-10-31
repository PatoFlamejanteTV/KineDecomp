package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.zzk;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fs implements zzk.zza {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzli f1563a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fs(zzli zzliVar) {
        this.f1563a = zzliVar;
    }

    @Override // com.google.android.gms.common.internal.zzk.zza
    public boolean isConnected() {
        return this.f1563a.isConnected();
    }

    @Override // com.google.android.gms.common.internal.zzk.zza
    public Bundle zzmS() {
        return null;
    }
}
