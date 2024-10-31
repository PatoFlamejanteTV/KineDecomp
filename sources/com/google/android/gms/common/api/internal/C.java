package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class C implements BaseGmsClient.SignOutCallbacks {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ GoogleApiManager.zaa f10729a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C(GoogleApiManager.zaa zaaVar) {
        this.f10729a = zaaVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.SignOutCallbacks
    public final void a() {
        GoogleApiManager.this.q.post(new D(this));
    }
}
