package com.google.android.gms.common.api.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.common.api.internal.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0801e extends AbstractC0818w {

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zaah f10832b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0801e(zaah zaahVar, zabd zabdVar) {
        super(zabdVar);
        this.f10832b = zaahVar;
    }

    @Override // com.google.android.gms.common.api.internal.AbstractC0818w
    public final void a() {
        this.f10832b.onConnectionSuspended(1);
    }
}
