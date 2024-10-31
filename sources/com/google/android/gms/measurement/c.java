package com.google.android.gms.measurement;

import java.util.Comparator;

/* loaded from: classes.dex */
class c implements Comparator<zze> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzb f2015a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(zzb zzbVar) {
        this.f2015a = zzbVar;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(zze zzeVar, zze zzeVar2) {
        return zzeVar.getClass().getCanonicalName().compareTo(zzeVar2.getClass().getCanonicalName());
    }
}
