package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzrb;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab {

    /* renamed from: a, reason: collision with root package name */
    private static final u<zzag.zza> f2207a = new u<>(zzdf.b(), true);
    private final h b;
    private final Map<String, i> c;
    private final Map<String, i> d;
    private final Map<String, i> e;
    private final ao<zzrb.zza, u<zzag.zza>> f;
    private final ao<String, b> g;
    private final Set<zzrb.zze> h;
    private final DataLayer i;
    private final Map<String, c> j;
    private volatile String k;
    private int l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(zzrb.zze zzeVar, Set<zzrb.zza> set, Set<zzrb.zza> set2, z zVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private u<zzag.zza> f2208a;
        private zzag.zza b;

        public b(u<zzag.zza> uVar, zzag.zza zzaVar) {
            this.f2208a = uVar;
            this.b = zzaVar;
        }

        public u<zzag.zza> a() {
            return this.f2208a;
        }

        public zzag.zza b() {
            return this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {
        private zzrb.zza f;

        /* renamed from: a, reason: collision with root package name */
        private final Set<zzrb.zze> f2209a = new HashSet();
        private final Map<zzrb.zze, List<zzrb.zza>> b = new HashMap();
        private final Map<zzrb.zze, List<String>> d = new HashMap();
        private final Map<zzrb.zze, List<zzrb.zza>> c = new HashMap();
        private final Map<zzrb.zze, List<String>> e = new HashMap();

        public Set<zzrb.zze> a() {
            return this.f2209a;
        }

        public Map<zzrb.zze, List<zzrb.zza>> b() {
            return this.b;
        }

        public Map<zzrb.zze, List<String>> c() {
            return this.d;
        }

        public Map<zzrb.zze, List<String>> d() {
            return this.e;
        }

        public Map<zzrb.zze, List<zzrb.zza>> e() {
            return this.c;
        }

        public zzrb.zza f() {
            return this.f;
        }
    }

    private u<zzag.zza> a(zzag.zza zzaVar, Set<String> set, am amVar) {
        if (!zzaVar.zzje) {
            return new u<>(zzaVar, true);
        }
        switch (zzaVar.type) {
            case 2:
                zzag.zza zzo = zzrb.zzo(zzaVar);
                zzo.zziV = new zzag.zza[zzaVar.zziV.length];
                for (int i = 0; i < zzaVar.zziV.length; i++) {
                    u<zzag.zza> a2 = a(zzaVar.zziV[i], set, amVar.a(i));
                    if (a2 == f2207a) {
                        return f2207a;
                    }
                    zzo.zziV[i] = a2.a();
                }
                return new u<>(zzo, false);
            case 3:
                zzag.zza zzo2 = zzrb.zzo(zzaVar);
                if (zzaVar.zziW.length != zzaVar.zziX.length) {
                    zzbg.a("Invalid serving value: " + zzaVar.toString());
                    return f2207a;
                }
                zzo2.zziW = new zzag.zza[zzaVar.zziW.length];
                zzo2.zziX = new zzag.zza[zzaVar.zziW.length];
                for (int i2 = 0; i2 < zzaVar.zziW.length; i2++) {
                    u<zzag.zza> a3 = a(zzaVar.zziW[i2], set, amVar.b(i2));
                    u<zzag.zza> a4 = a(zzaVar.zziX[i2], set, amVar.c(i2));
                    if (a3 == f2207a || a4 == f2207a) {
                        return f2207a;
                    }
                    zzo2.zziW[i2] = a3.a();
                    zzo2.zziX[i2] = a4.a();
                }
                return new u<>(zzo2, false);
            case 4:
                if (set.contains(zzaVar.zziY)) {
                    zzbg.a("Macro cycle detected.  Current macro reference: " + zzaVar.zziY + ".  Previous macro references: " + set.toString() + ".");
                    return f2207a;
                }
                set.add(zzaVar.zziY);
                u<zzag.zza> a5 = an.a(a(zzaVar.zziY, set, amVar.a()), zzaVar.zzjd);
                set.remove(zzaVar.zziY);
                return a5;
            case 5:
            case 6:
            default:
                zzbg.a("Unknown type: " + zzaVar.type);
                return f2207a;
            case 7:
                zzag.zza zzo3 = zzrb.zzo(zzaVar);
                zzo3.zzjc = new zzag.zza[zzaVar.zzjc.length];
                for (int i3 = 0; i3 < zzaVar.zzjc.length; i3++) {
                    u<zzag.zza> a6 = a(zzaVar.zzjc[i3], set, amVar.d(i3));
                    if (a6 == f2207a) {
                        return f2207a;
                    }
                    zzo3.zzjc[i3] = a6.a();
                }
                return new u<>(zzo3, false);
        }
    }

    private u<zzag.zza> a(String str, Set<String> set, o oVar) {
        zzrb.zza next;
        this.l++;
        b a2 = this.g.a(str);
        if (a2 != null && !this.b.a()) {
            a(a2.b(), set);
            this.l--;
            return a2.a();
        }
        c cVar = this.j.get(str);
        if (cVar == null) {
            zzbg.a(a() + "Invalid macro: " + str);
            this.l--;
            return f2207a;
        }
        u<Set<zzrb.zza>> a3 = a(str, cVar.a(), cVar.b(), cVar.c(), cVar.e(), cVar.d(), set, oVar.b());
        if (a3.a().isEmpty()) {
            next = cVar.f();
        } else {
            if (a3.a().size() > 1) {
                zzbg.b(a() + "Multiple macros active for macroName " + str);
            }
            next = a3.a().iterator().next();
        }
        if (next == null) {
            this.l--;
            return f2207a;
        }
        u<zzag.zza> a4 = a(this.e, next, set, oVar.a());
        u<zzag.zza> uVar = a4 == f2207a ? f2207a : new u<>(a4.a(), a3.b() && a4.b());
        zzag.zza zzDz = next.zzDz();
        if (uVar.b()) {
            this.g.a(str, new b(uVar, zzDz));
        }
        a(zzDz, set);
        this.l--;
        return uVar;
    }

    private u<zzag.zza> a(Map<String, i> map, zzrb.zza zzaVar, Set<String> set, w wVar) {
        boolean z;
        zzag.zza zzaVar2 = zzaVar.zzEa().get(zzae.FUNCTION.toString());
        if (zzaVar2 == null) {
            zzbg.a("No function id in properties");
            return f2207a;
        }
        String str = zzaVar2.zziZ;
        i iVar = map.get(str);
        if (iVar == null) {
            zzbg.a(str + " has no backing implementation.");
            return f2207a;
        }
        u<zzag.zza> a2 = this.f.a(zzaVar);
        if (a2 != null && !this.b.a()) {
            return a2;
        }
        HashMap hashMap = new HashMap();
        boolean z2 = true;
        for (Map.Entry<String, zzag.zza> entry : zzaVar.zzEa().entrySet()) {
            u<zzag.zza> a3 = a(entry.getValue(), set, wVar.a(entry.getKey()).a(entry.getValue()));
            if (a3 == f2207a) {
                return f2207a;
            }
            if (a3.b()) {
                zzaVar.zza(entry.getKey(), a3.a());
                z = z2;
            } else {
                z = false;
            }
            hashMap.put(entry.getKey(), a3.a());
            z2 = z;
        }
        if (!iVar.a(hashMap.keySet())) {
            zzbg.a("Incorrect keys for function " + str + " required " + iVar.b() + " had " + hashMap.keySet());
            return f2207a;
        }
        boolean z3 = z2 && iVar.a();
        u<zzag.zza> uVar = new u<>(iVar.a(hashMap), z3);
        if (z3) {
            this.f.a(zzaVar, uVar);
        }
        wVar.a(uVar.a());
        return uVar;
    }

    private u<Set<zzrb.zza>> a(Set<zzrb.zze> set, Set<String> set2, a aVar, aa aaVar) {
        Set<zzrb.zza> hashSet = new HashSet<>();
        Set<zzrb.zza> hashSet2 = new HashSet<>();
        boolean z = true;
        for (zzrb.zze zzeVar : set) {
            z a2 = aaVar.a();
            u<Boolean> a3 = a(zzeVar, set2, a2);
            if (a3.a().booleanValue()) {
                aVar.a(zzeVar, hashSet, hashSet2, a2);
            }
            z = z && a3.b();
        }
        hashSet.removeAll(hashSet2);
        aaVar.a(hashSet);
        return new u<>(hashSet, z);
    }

    private String a() {
        if (this.l <= 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(this.l));
        for (int i = 2; i < this.l; i++) {
            sb.append(' ');
        }
        sb.append(": ");
        return sb.toString();
    }

    private void a(zzag.zza zzaVar, Set<String> set) {
        u<zzag.zza> a2;
        if (zzaVar == null || (a2 = a(zzaVar, set, new t())) == f2207a) {
            return;
        }
        Object c2 = zzdf.c(a2.a());
        if (c2 instanceof Map) {
            this.i.a((Map<String, Object>) c2);
            return;
        }
        if (!(c2 instanceof List)) {
            zzbg.b("pushAfterEvaluate: value not a Map or List");
            return;
        }
        for (Object obj : (List) c2) {
            if (obj instanceof Map) {
                this.i.a((Map<String, Object>) obj);
            } else {
                zzbg.b("pushAfterEvaluate: value not a Map");
            }
        }
    }

    u<Boolean> a(zzrb.zza zzaVar, Set<String> set, w wVar) {
        u<zzag.zza> a2 = a(this.d, zzaVar, set, wVar);
        Boolean b2 = zzdf.b(a2.a());
        wVar.a(zzdf.c(b2));
        return new u<>(b2, a2.b());
    }

    u<Boolean> a(zzrb.zze zzeVar, Set<String> set, z zVar) {
        Iterator<zzrb.zza> it = zzeVar.zzEi().iterator();
        boolean z = true;
        while (it.hasNext()) {
            u<Boolean> a2 = a(it.next(), set, zVar.a());
            if (a2.a().booleanValue()) {
                zVar.a(zzdf.c((Object) false));
                return new u<>(false, a2.b());
            }
            z = z && a2.b();
        }
        Iterator<zzrb.zza> it2 = zzeVar.zzEh().iterator();
        while (it2.hasNext()) {
            u<Boolean> a3 = a(it2.next(), set, zVar.b());
            if (!a3.a().booleanValue()) {
                zVar.a(zzdf.c((Object) false));
                return new u<>(false, a3.b());
            }
            z = z && a3.b();
        }
        zVar.a(zzdf.c((Object) true));
        return new u<>(true, z);
    }

    u<Set<zzrb.zza>> a(String str, Set<zzrb.zze> set, Map<zzrb.zze, List<zzrb.zza>> map, Map<zzrb.zze, List<String>> map2, Map<zzrb.zze, List<zzrb.zza>> map3, Map<zzrb.zze, List<String>> map4, Set<String> set2, aa aaVar) {
        return a(set, set2, new ac(this, map, map2, map3, map4), aaVar);
    }

    u<Set<zzrb.zza>> a(Set<zzrb.zze> set, aa aaVar) {
        return a(set, new HashSet(), new ad(this), aaVar);
    }

    public synchronized void a(String str) {
        b(str);
        g a2 = this.b.a(str);
        aq a3 = a2.a();
        Iterator<zzrb.zza> it = a(this.h, a3.b()).a().iterator();
        while (it.hasNext()) {
            a(this.c, it.next(), new HashSet(), a3.a());
        }
        a2.b();
        b(null);
    }

    synchronized void b(String str) {
        this.k = str;
    }
}
