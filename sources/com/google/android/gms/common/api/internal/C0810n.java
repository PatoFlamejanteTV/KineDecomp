package com.google.android.gms.common.api.internal;

/* renamed from: com.google.android.gms.common.api.internal.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0810n extends AbstractC0818w {

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zaak f10846b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ com.google.android.gms.signin.internal.zaj f10847c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0810n(BinderC0809m binderC0809m, zabd zabdVar, zaak zaakVar, com.google.android.gms.signin.internal.zaj zajVar) {
        super(zabdVar);
        this.f10846b = zaakVar;
        this.f10847c = zajVar;
    }

    @Override // com.google.android.gms.common.api.internal.AbstractC0818w
    public final void a() {
        this.f10846b.a(this.f10847c);
    }
}
