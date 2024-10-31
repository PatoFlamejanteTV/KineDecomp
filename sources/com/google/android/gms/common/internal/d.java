package com.google.android.gms.common.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d extends zze {
    final /* synthetic */ char p;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(char c) {
        this.p = c;
    }

    @Override // com.google.android.gms.common.internal.zze
    public zze a(zze zzeVar) {
        return zzeVar.b(this.p) ? zzeVar : super.a(zzeVar);
    }

    @Override // com.google.android.gms.common.internal.zze
    public boolean b(char c) {
        return c == this.p;
    }
}
