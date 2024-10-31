package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Im implements Comparator<zztl> {
    public Im(zzte zzteVar) {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zztl zztlVar, zztl zztlVar2) {
        zztl zztlVar3 = zztlVar;
        zztl zztlVar4 = zztlVar2;
        int i = zztlVar3.zzbzg - zztlVar4.zzbzg;
        return i != 0 ? i : (int) (zztlVar3.value - zztlVar4.value);
    }
}
