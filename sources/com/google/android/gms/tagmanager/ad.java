package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzrb;
import com.google.android.gms.tagmanager.ab;
import java.util.Set;

/* loaded from: classes.dex */
class ad implements ab.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ab f2211a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar) {
        this.f2211a = abVar;
    }

    @Override // com.google.android.gms.tagmanager.ab.a
    public void a(zzrb.zze zzeVar, Set<zzrb.zza> set, Set<zzrb.zza> set2, z zVar) {
        set.addAll(zzeVar.zzEj());
        set2.addAll(zzeVar.zzEk());
        zVar.e().a(zzeVar.zzEj(), zzeVar.zzEo());
        zVar.f().a(zzeVar.zzEk(), zzeVar.zzEp());
    }
}
