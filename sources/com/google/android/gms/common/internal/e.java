package com.google.android.gms.common.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e extends zze {
    final /* synthetic */ char p;
    final /* synthetic */ char q;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(char c, char c2) {
        this.p = c;
        this.q = c2;
    }

    @Override // com.google.android.gms.common.internal.zze
    public boolean b(char c) {
        return c == this.p || c == this.q;
    }
}