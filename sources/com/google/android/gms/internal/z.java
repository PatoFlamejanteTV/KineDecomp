package com.google.android.gms.internal;

import com.google.android.gms.internal.zzbp;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements Comparator<zzbp.zza> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbm f1669a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(zzbm zzbmVar) {
        this.f1669a = zzbmVar;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(zzbp.zza zzaVar, zzbp.zza zzaVar2) {
        return (int) (zzaVar.value - zzaVar2.value);
    }
}
