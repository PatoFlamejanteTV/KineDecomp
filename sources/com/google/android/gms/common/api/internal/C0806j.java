package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

/* renamed from: com.google.android.gms.common.api.internal.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0806j extends AbstractC0818w {

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ ConnectionResult f10840b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ C0805i f10841c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0806j(C0805i c0805i, zabd zabdVar, ConnectionResult connectionResult) {
        super(zabdVar);
        this.f10841c = c0805i;
        this.f10840b = connectionResult;
    }

    @Override // com.google.android.gms.common.api.internal.AbstractC0818w
    public final void a() {
        this.f10841c.f10839c.b(this.f10840b);
    }
}
