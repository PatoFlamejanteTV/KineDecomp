package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzrb;
import com.google.android.gms.tagmanager.ab;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
class ac implements ab.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map f2210a;
    final /* synthetic */ Map b;
    final /* synthetic */ Map c;
    final /* synthetic */ Map d;
    final /* synthetic */ ab e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar, Map map, Map map2, Map map3, Map map4) {
        this.e = abVar;
        this.f2210a = map;
        this.b = map2;
        this.c = map3;
        this.d = map4;
    }

    @Override // com.google.android.gms.tagmanager.ab.a
    public void a(zzrb.zze zzeVar, Set<zzrb.zza> set, Set<zzrb.zza> set2, z zVar) {
        List<zzrb.zza> list = (List) this.f2210a.get(zzeVar);
        List<String> list2 = (List) this.b.get(zzeVar);
        if (list != null) {
            set.addAll(list);
            zVar.c().a(list, list2);
        }
        List<zzrb.zza> list3 = (List) this.c.get(zzeVar);
        List<String> list4 = (List) this.d.get(zzeVar);
        if (list3 != null) {
            set2.addAll(list3);
            zVar.d().a(list3, list4);
        }
    }
}
