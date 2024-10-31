package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzfm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase_auth.z, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C1287z<FieldDescriptorType extends zzfm<FieldDescriptorType>> {

    /* renamed from: a, reason: collision with root package name */
    private static final C1287z f13098a = new C1287z(true);

    /* renamed from: c, reason: collision with root package name */
    private boolean f13100c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f13101d = false;

    /* renamed from: b, reason: collision with root package name */
    private final C1269pa<FieldDescriptorType, Object> f13099b = C1269pa.a(16);

    private C1287z() {
    }

    public static <T extends zzfm<T>> C1287z<T> g() {
        return f13098a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Iterator<Map.Entry<FieldDescriptorType, Object>> a() {
        if (this.f13101d) {
            return new I(this.f13099b.e().iterator());
        }
        return this.f13099b.e().iterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b() {
        return this.f13099b.isEmpty();
    }

    public final boolean c() {
        return this.f13100c;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        C1287z c1287z = new C1287z();
        for (int i = 0; i < this.f13099b.c(); i++) {
            Map.Entry<FieldDescriptorType, Object> b2 = this.f13099b.b(i);
            c1287z.a((C1287z) b2.getKey(), b2.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f13099b.d()) {
            c1287z.a((C1287z) entry.getKey(), entry.getValue());
        }
        c1287z.f13101d = this.f13101d;
        return c1287z;
    }

    public final boolean d() {
        for (int i = 0; i < this.f13099b.c(); i++) {
            if (!a((Map.Entry) this.f13099b.b(i))) {
                return false;
            }
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = this.f13099b.d().iterator();
        while (it.hasNext()) {
            if (!a((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> e() {
        if (this.f13101d) {
            return new I(this.f13099b.entrySet().iterator());
        }
        return this.f13099b.entrySet().iterator();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1287z) {
            return this.f13099b.equals(((C1287z) obj).f13099b);
        }
        return false;
    }

    public final void f() {
        if (this.f13100c) {
            return;
        }
        this.f13099b.b();
        this.f13100c = true;
    }

    public final int h() {
        int i = 0;
        for (int i2 = 0; i2 < this.f13099b.c(); i2++) {
            Map.Entry<FieldDescriptorType, Object> b2 = this.f13099b.b(i2);
            i += b((zzfm<?>) b2.getKey(), b2.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f13099b.d()) {
            i += b((zzfm<?>) entry.getKey(), entry.getValue());
        }
        return i;
    }

    public final int hashCode() {
        return this.f13099b.hashCode();
    }

    public final int i() {
        int i = 0;
        for (int i2 = 0; i2 < this.f13099b.c(); i2++) {
            i += c(this.f13099b.b(i2));
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = this.f13099b.d().iterator();
        while (it.hasNext()) {
            i += c(it.next());
        }
        return i;
    }

    private final void b(Map.Entry<FieldDescriptorType, Object> entry) {
        zzhc zzhn;
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (!(value instanceof zzgf)) {
            if (key.zzha()) {
                Object a2 = a((C1287z<FieldDescriptorType>) key);
                if (a2 == null) {
                    a2 = new ArrayList();
                }
                Iterator it = ((List) value).iterator();
                while (it.hasNext()) {
                    ((List) a2).add(a(it.next()));
                }
                this.f13099b.a((C1269pa<FieldDescriptorType, Object>) key, (FieldDescriptorType) a2);
                return;
            }
            if (key.zzgz() == zzjk.MESSAGE) {
                Object a3 = a((C1287z<FieldDescriptorType>) key);
                if (a3 == null) {
                    this.f13099b.a((C1269pa<FieldDescriptorType, Object>) key, (FieldDescriptorType) a(value));
                    return;
                }
                if (a3 instanceof zzhi) {
                    zzhn = key.zza((zzhi) a3, (zzhi) value);
                } else {
                    zzhn = key.zza(((zzhc) a3).zzhg(), (zzhc) value).zzhn();
                }
                this.f13099b.a((C1269pa<FieldDescriptorType, Object>) key, (FieldDescriptorType) zzhn);
                return;
            }
            this.f13099b.a((C1269pa<FieldDescriptorType, Object>) key, (FieldDescriptorType) a(value));
            return;
        }
        zzgf.zzia();
        throw null;
    }

    private static int c(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzgz() == zzjk.MESSAGE && !key.zzha() && !key.zzhb()) {
            if (value instanceof zzgf) {
                return zzfa.zzb(entry.getKey().zzbi(), (zzgf) value);
            }
            return zzfa.zzb(entry.getKey().zzbi(), (zzhc) value);
        }
        return b((zzfm<?>) key, value);
    }

    private C1287z(boolean z) {
        f();
    }

    private final Object a(FieldDescriptorType fielddescriptortype) {
        Object obj = this.f13099b.get(fielddescriptortype);
        if (!(obj instanceof zzgf)) {
            return obj;
        }
        zzgf.zzia();
        throw null;
    }

    private final void a(FieldDescriptorType fielddescriptortype, Object obj) {
        if (fielddescriptortype.zzha()) {
            if (obj instanceof List) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj2 = arrayList.get(i);
                    i++;
                    a(fielddescriptortype.zzgy(), obj2);
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            a(fielddescriptortype.zzgy(), obj);
        }
        if (obj instanceof zzgf) {
            this.f13101d = true;
        }
        this.f13099b.a((C1269pa<FieldDescriptorType, Object>) fielddescriptortype, (FieldDescriptorType) obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0024, code lost:            if ((r3 instanceof com.google.android.gms.internal.firebase_auth.zzfw) == false) goto L27;     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:            if ((r3 instanceof byte[]) == false) goto L27;     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:            if ((r3 instanceof com.google.android.gms.internal.firebase_auth.zzgf) == false) goto L27;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(com.google.android.gms.internal.firebase_auth.zzjf r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.firebase_auth.zzfv.checkNotNull(r3)
            int[] r0 = com.google.android.gms.internal.firebase_auth.A.f12950a
            com.google.android.gms.internal.firebase_auth.zzjk r2 = r2.zzjy()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L40;
                case 2: goto L3d;
                case 3: goto L3a;
                case 4: goto L37;
                case 5: goto L34;
                case 6: goto L31;
                case 7: goto L28;
                case 8: goto L1e;
                case 9: goto L15;
                default: goto L14;
            }
        L14:
            goto L43
        L15:
            boolean r2 = r3 instanceof com.google.android.gms.internal.firebase_auth.zzhc
            if (r2 != 0) goto L26
            boolean r2 = r3 instanceof com.google.android.gms.internal.firebase_auth.zzgf
            if (r2 == 0) goto L43
            goto L26
        L1e:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L26
            boolean r2 = r3 instanceof com.google.android.gms.internal.firebase_auth.zzfw
            if (r2 == 0) goto L43
        L26:
            r1 = 1
            goto L43
        L28:
            boolean r2 = r3 instanceof com.google.android.gms.internal.firebase_auth.zzeh
            if (r2 != 0) goto L26
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L43
            goto L26
        L31:
            boolean r0 = r3 instanceof java.lang.String
            goto L42
        L34:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L42
        L37:
            boolean r0 = r3 instanceof java.lang.Double
            goto L42
        L3a:
            boolean r0 = r3 instanceof java.lang.Float
            goto L42
        L3d:
            boolean r0 = r3 instanceof java.lang.Long
            goto L42
        L40:
            boolean r0 = r3 instanceof java.lang.Integer
        L42:
            r1 = r0
        L43:
            if (r1 == 0) goto L46
            return
        L46:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            goto L4f
        L4e:
            throw r2
        L4f:
            goto L4e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.C1287z.a(com.google.android.gms.internal.firebase_auth.zzjf, java.lang.Object):void");
    }

    private static int b(zzjf zzjfVar, Object obj) {
        switch (A.f12951b[zzjfVar.ordinal()]) {
            case 1:
                return zzfa.zzb(((Double) obj).doubleValue());
            case 2:
                return zzfa.zzb(((Float) obj).floatValue());
            case 3:
                return zzfa.zze(((Long) obj).longValue());
            case 4:
                return zzfa.zzf(((Long) obj).longValue());
            case 5:
                return zzfa.zzah(((Integer) obj).intValue());
            case 6:
                return zzfa.zzh(((Long) obj).longValue());
            case 7:
                return zzfa.zzak(((Integer) obj).intValue());
            case 8:
                return zzfa.zzt(((Boolean) obj).booleanValue());
            case 9:
                return zzfa.zze((zzhc) obj);
            case 10:
                if (obj instanceof zzgf) {
                    return zzfa.zza((zzgf) obj);
                }
                return zzfa.zzd((zzhc) obj);
            case 11:
                if (obj instanceof zzeh) {
                    return zzfa.zzb((zzeh) obj);
                }
                return zzfa.zzdb((String) obj);
            case 12:
                if (obj instanceof zzeh) {
                    return zzfa.zzb((zzeh) obj);
                }
                return zzfa.zzc((byte[]) obj);
            case 13:
                return zzfa.zzai(((Integer) obj).intValue());
            case 14:
                return zzfa.zzal(((Integer) obj).intValue());
            case 15:
                return zzfa.zzi(((Long) obj).longValue());
            case 16:
                return zzfa.zzaj(((Integer) obj).intValue());
            case 17:
                return zzfa.zzg(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzfw) {
                    return zzfa.zzam(((zzfw) obj).zzbi());
                }
                return zzfa.zzam(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static boolean a(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.zzgz() == zzjk.MESSAGE) {
            if (key.zzha()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((zzhc) it.next()).isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzhc) {
                    if (!((zzhc) value).isInitialized()) {
                        return false;
                    }
                } else {
                    if (value instanceof zzgf) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void a(C1287z<FieldDescriptorType> c1287z) {
        for (int i = 0; i < c1287z.f13099b.c(); i++) {
            b(c1287z.f13099b.b(i));
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = c1287z.f13099b.d().iterator();
        while (it.hasNext()) {
            b(it.next());
        }
    }

    private static Object a(Object obj) {
        if (obj instanceof zzhi) {
            return ((zzhi) obj).zziq();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(zzfa zzfaVar, zzjf zzjfVar, int i, Object obj) throws IOException {
        if (zzjfVar == zzjf.zzada) {
            zzhc zzhcVar = (zzhc) obj;
            zzfv.zzg(zzhcVar);
            zzfaVar.zzf(i, 3);
            zzhcVar.zzb(zzfaVar);
            zzfaVar.zzf(i, 4);
            return;
        }
        zzfaVar.zzf(i, zzjfVar.zzjz());
        switch (A.f12951b[zzjfVar.ordinal()]) {
            case 1:
                zzfaVar.zza(((Double) obj).doubleValue());
                return;
            case 2:
                zzfaVar.zza(((Float) obj).floatValue());
                return;
            case 3:
                zzfaVar.zzb(((Long) obj).longValue());
                return;
            case 4:
                zzfaVar.zzb(((Long) obj).longValue());
                return;
            case 5:
                zzfaVar.zzac(((Integer) obj).intValue());
                return;
            case 6:
                zzfaVar.zzd(((Long) obj).longValue());
                return;
            case 7:
                zzfaVar.zzaf(((Integer) obj).intValue());
                return;
            case 8:
                zzfaVar.zzs(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzhc) obj).zzb(zzfaVar);
                return;
            case 10:
                zzfaVar.zzc((zzhc) obj);
                return;
            case 11:
                if (obj instanceof zzeh) {
                    zzfaVar.zza((zzeh) obj);
                    return;
                } else {
                    zzfaVar.zzda((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzeh) {
                    zzfaVar.zza((zzeh) obj);
                    return;
                } else {
                    byte[] bArr = (byte[]) obj;
                    zzfaVar.zzd(bArr, 0, bArr.length);
                    return;
                }
            case 13:
                zzfaVar.zzad(((Integer) obj).intValue());
                return;
            case 14:
                zzfaVar.zzaf(((Integer) obj).intValue());
                return;
            case 15:
                zzfaVar.zzd(((Long) obj).longValue());
                return;
            case 16:
                zzfaVar.zzae(((Integer) obj).intValue());
                return;
            case 17:
                zzfaVar.zzc(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzfw) {
                    zzfaVar.zzac(((zzfw) obj).zzbi());
                    return;
                } else {
                    zzfaVar.zzac(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    private static int b(zzfm<?> zzfmVar, Object obj) {
        zzjf zzgy = zzfmVar.zzgy();
        int zzbi = zzfmVar.zzbi();
        if (zzfmVar.zzha()) {
            int i = 0;
            if (zzfmVar.zzhb()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    i += b(zzgy, it.next());
                }
                return zzfa.zzag(zzbi) + i + zzfa.zzao(i);
            }
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                i += a(zzgy, zzbi, it2.next());
            }
            return i;
        }
        return a(zzgy, zzbi, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(zzjf zzjfVar, int i, Object obj) {
        int zzag = zzfa.zzag(i);
        if (zzjfVar == zzjf.zzada) {
            zzfv.zzg((zzhc) obj);
            zzag <<= 1;
        }
        return zzag + b(zzjfVar, obj);
    }
}
