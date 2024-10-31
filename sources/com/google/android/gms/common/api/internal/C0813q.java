package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.GmsClientEventManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.common.api.internal.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0813q implements GmsClientEventManager.GmsClientEventState {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zaaw f10850a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0813q(zaaw zaawVar) {
        this.f10850a = zaawVar;
    }

    @Override // com.google.android.gms.common.internal.GmsClientEventManager.GmsClientEventState
    public final Bundle getConnectionHint() {
        return null;
    }

    @Override // com.google.android.gms.common.internal.GmsClientEventManager.GmsClientEventState
    public final boolean isConnected() {
        return this.f10850a.j();
    }
}
