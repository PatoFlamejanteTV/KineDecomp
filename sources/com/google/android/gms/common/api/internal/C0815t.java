package com.google.android.gms.common.api.internal;

import android.content.Context;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.common.api.internal.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0815t implements ResultCallback<Status> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ StatusPendingResult f10855a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ boolean f10856b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ GoogleApiClient f10857c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ zaaw f10858d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0815t(zaaw zaawVar, StatusPendingResult statusPendingResult, boolean z, GoogleApiClient googleApiClient) {
        this.f10858d = zaawVar;
        this.f10855a = statusPendingResult;
        this.f10856b = z;
        this.f10857c = googleApiClient;
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final /* synthetic */ void onResult(Status status) {
        Context context;
        Status status2 = status;
        context = this.f10858d.f10886g;
        Storage.a(context).e();
        if (status2.Q() && this.f10858d.j()) {
            this.f10858d.k();
        }
        this.f10855a.a((StatusPendingResult) status2);
        if (this.f10856b) {
            this.f10857c.d();
        }
    }
}
