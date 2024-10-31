package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* renamed from: com.google.android.gms.common.api.internal.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0807k extends AbstractC0818w {

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ BaseGmsClient.ConnectionProgressReportCallbacks f10842b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0807k(C0805i c0805i, zabd zabdVar, BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        super(zabdVar);
        this.f10842b = connectionProgressReportCallbacks;
    }

    @Override // com.google.android.gms.common.api.internal.AbstractC0818w
    public final void a() {
        this.f10842b.a(new ConnectionResult(16, null));
    }
}
