package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.BackgroundDetector;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.common.api.internal.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0820y implements BackgroundDetector.BackgroundStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ GoogleApiManager f10863a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0820y(GoogleApiManager googleApiManager) {
        this.f10863a = googleApiManager;
    }

    @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
    public final void a(boolean z) {
        this.f10863a.q.sendMessage(this.f10863a.q.obtainMessage(1, Boolean.valueOf(z)));
    }
}
