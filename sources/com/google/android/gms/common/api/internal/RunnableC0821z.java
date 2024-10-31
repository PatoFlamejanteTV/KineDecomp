package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.GoogleApiManager;

/* renamed from: com.google.android.gms.common.api.internal.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class RunnableC0821z implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ GoogleApiManager.zaa f10864a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0821z(GoogleApiManager.zaa zaaVar) {
        this.f10864a = zaaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f10864a.n();
    }
}
