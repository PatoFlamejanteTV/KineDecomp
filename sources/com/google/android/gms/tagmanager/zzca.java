package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class zzca extends i {

    /* renamed from: a, reason: collision with root package name */
    private static final String f2235a = zzae.ARG0.toString();
    private static final String b = zzae.ARG1.toString();

    public zzca(String str) {
        super(str, f2235a, b);
    }

    @Override // com.google.android.gms.tagmanager.i
    public zzag.zza a(Map<String, zzag.zza> map) {
        Iterator<zzag.zza> it = map.values().iterator();
        while (it.hasNext()) {
            if (it.next() == zzdf.b()) {
                return zzdf.c((Object) false);
            }
        }
        zzag.zza zzaVar = map.get(f2235a);
        zzag.zza zzaVar2 = map.get(b);
        return zzdf.c(Boolean.valueOf((zzaVar == null || zzaVar2 == null) ? false : a(zzaVar, zzaVar2, map)));
    }

    @Override // com.google.android.gms.tagmanager.i
    public boolean a() {
        return true;
    }

    protected abstract boolean a(zzag.zza zzaVar, zzag.zza zzaVar2, Map<String, zzag.zza> map);

    @Override // com.google.android.gms.tagmanager.i
    public /* bridge */ /* synthetic */ Set b() {
        return super.b();
    }
}
