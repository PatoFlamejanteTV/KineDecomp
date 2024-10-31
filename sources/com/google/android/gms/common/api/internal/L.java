package com.google.android.gms.common.api.internal;

/* loaded from: classes.dex */
public final class L implements N {

    /* renamed from: a */
    private final /* synthetic */ zacp f10772a;

    public L(zacp zacpVar) {
        this.f10772a = zacpVar;
    }

    @Override // com.google.android.gms.common.api.internal.N
    public final void a(BasePendingResult<?> basePendingResult) {
        this.f10772a.f10925c.remove(basePendingResult);
    }
}
