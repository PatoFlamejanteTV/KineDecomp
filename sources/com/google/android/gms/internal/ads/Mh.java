package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbqw;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
final class Mh<FieldDescriptorType extends zzbqw<FieldDescriptorType>> {

    /* renamed from: a, reason: collision with root package name */
    private static final Mh f11687a = new Mh(true);

    /* renamed from: c, reason: collision with root package name */
    private boolean f11689c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f11690d = false;

    /* renamed from: b, reason: collision with root package name */
    private final C1154xi<FieldDescriptorType, Object> f11688b = C1154xi.a(16);

    private Mh() {
    }

    public static <T extends zzbqw<T>> Mh<T> g() {
        return f11687a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Iterator<Map.Entry<FieldDescriptorType, Object>> a() {
        if (this.f11690d) {
            return new Vh(this.f11688b.e().iterator());
        }
        return this.f11688b.e().iterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b() {
        return this.f11688b.isEmpty();
    }

    public final boolean c() {
        return this.f11689c;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        Mh mh = new Mh();
        for (int i = 0; i < this.f11688b.c(); i++) {
            Map.Entry<FieldDescriptorType, Object> b2 = this.f11688b.b(i);
            mh.a((Mh) b2.getKey(), b2.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f11688b.d()) {
            mh.a((Mh) entry.getKey(), entry.getValue());
        }
        mh.f11690d = this.f11690d;
        return mh;
    }

    public final boolean d() {
        for (int i = 0; i < this.f11688b.c(); i++) {
            if (!a((Map.Entry) this.f11688b.b(i))) {
                return false;
            }
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = this.f11688b.d().iterator();
        while (it.hasNext()) {
            if (!a((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> e() {
        if (this.f11690d) {
            return new Vh(this.f11688b.entrySet().iterator());
        }
        return this.f11688b.entrySet().iterator();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Mh) {
            return this.f11688b.equals(((Mh) obj).f11688b);
        }
        return false;
    }

    public final void f() {
        if (this.f11689c) {
            return;
        }
        this.f11688b.b();
        this.f11689c = true;
    }

    public final int h() {
        int i = 0;
        for (int i2 = 0; i2 < this.f11688b.c(); i2++) {
            Map.Entry<FieldDescriptorType, Object> b2 = this.f11688b.b(i2);
            i += b((zzbqw<?>) b2.getKey(), b2.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f11688b.d()) {
            i += b((zzbqw<?>) entry.getKey(), entry.getValue());
        }
        return i;
    }

    public final int hashCode() {
        return this.f11688b.hashCode();
    }

    public final int i() {
        int i = 0;
        for (int i2 = 0; i2 < this.f11688b.c(); i2++) {
            i += c(this.f11688b.b(i2));
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = this.f11688b.d().iterator();
        while (it.hasNext()) {
            i += c(it.next());
        }
        return i;
    }

    private final void b(Map.Entry<FieldDescriptorType, Object> entry) {
        zzbsl zzana;
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (!(value instanceof zzbro)) {
            if (key.zzamn()) {
                Object a2 = a((Mh<FieldDescriptorType>) key);
                if (a2 == null) {
                    a2 = new ArrayList();
                }
                Iterator it = ((List) value).iterator();
                while (it.hasNext()) {
                    ((List) a2).add(a(it.next()));
                }
                this.f11688b.a((C1154xi<FieldDescriptorType, Object>) key, (FieldDescriptorType) a2);
                return;
            }
            if (key.zzamm() == zzbuo.MESSAGE) {
                Object a3 = a((Mh<FieldDescriptorType>) key);
                if (a3 == null) {
                    this.f11688b.a((C1154xi<FieldDescriptorType, Object>) key, (FieldDescriptorType) a(value));
                    return;
                }
                if (a3 instanceof zzbss) {
                    zzana = key.zza((zzbss) a3, (zzbss) value);
                } else {
                    zzana = key.zza(((zzbsl) a3).zzamt(), (zzbsl) value).zzana();
                }
                this.f11688b.a((C1154xi<FieldDescriptorType, Object>) key, (FieldDescriptorType) zzana);
                return;
            }
            this.f11688b.a((C1154xi<FieldDescriptorType, Object>) key, (FieldDescriptorType) a(value));
            return;
        }
        zzbro.zzanm();
        throw null;
    }

    private static int c(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzamm() == zzbuo.MESSAGE && !key.zzamn() && !key.zzamo()) {
            if (value instanceof zzbro) {
                return zzbqk.zzb(entry.getKey().zzom(), (zzbro) value);
            }
            return zzbqk.zzd(entry.getKey().zzom(), (zzbsl) value);
        }
        return b((zzbqw<?>) key, value);
    }

    private Mh(boolean z) {
        f();
    }

    private final Object a(FieldDescriptorType fielddescriptortype) {
        Object obj = this.f11688b.get(fielddescriptortype);
        if (!(obj instanceof zzbro)) {
            return obj;
        }
        zzbro.zzanm();
        throw null;
    }

    private final void a(FieldDescriptorType fielddescriptortype, Object obj) {
        if (fielddescriptortype.zzamn()) {
            if (obj instanceof List) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj2 = arrayList.get(i);
                    i++;
                    a(fielddescriptortype.zzaml(), obj2);
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            a(fielddescriptortype.zzaml(), obj);
        }
        if (obj instanceof zzbro) {
            this.f11690d = true;
        }
        this.f11688b.a((C1154xi<FieldDescriptorType, Object>) fielddescriptortype, (FieldDescriptorType) obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0024, code lost:            if ((r3 instanceof com.google.android.gms.internal.ads.zzbrg) == false) goto L27;     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:            if ((r3 instanceof byte[]) == false) goto L27;     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:            if ((r3 instanceof com.google.android.gms.internal.ads.zzbro) == false) goto L27;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(com.google.android.gms.internal.ads.zzbuj r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.ads.zzbrf.checkNotNull(r3)
            int[] r0 = com.google.android.gms.internal.ads.Nh.f11713a
            com.google.android.gms.internal.ads.zzbuo r2 = r2.zzapj()
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
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzbsl
            if (r2 != 0) goto L26
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzbro
            if (r2 == 0) goto L43
            goto L26
        L1e:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L26
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzbrg
            if (r2 == 0) goto L43
        L26:
            r1 = 1
            goto L43
        L28:
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzbpu
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.Mh.a(com.google.android.gms.internal.ads.zzbuj, java.lang.Object):void");
    }

    private static int b(zzbuj zzbujVar, Object obj) {
        switch (Nh.f11714b[zzbujVar.ordinal()]) {
            case 1:
                return zzbqk.zzc(((Double) obj).doubleValue());
            case 2:
                return zzbqk.zzg(((Float) obj).floatValue());
            case 3:
                return zzbqk.zzbb(((Long) obj).longValue());
            case 4:
                return zzbqk.zzbc(((Long) obj).longValue());
            case 5:
                return zzbqk.zzfe(((Integer) obj).intValue());
            case 6:
                return zzbqk.zzbe(((Long) obj).longValue());
            case 7:
                return zzbqk.zzfh(((Integer) obj).intValue());
            case 8:
                return zzbqk.zzbe(((Boolean) obj).booleanValue());
            case 9:
                return zzbqk.zzg((zzbsl) obj);
            case 10:
                if (obj instanceof zzbro) {
                    return zzbqk.zza((zzbro) obj);
                }
                return zzbqk.zzf((zzbsl) obj);
            case 11:
                if (obj instanceof zzbpu) {
                    return zzbqk.zzao((zzbpu) obj);
                }
                return zzbqk.zzfy((String) obj);
            case 12:
                if (obj instanceof zzbpu) {
                    return zzbqk.zzao((zzbpu) obj);
                }
                return zzbqk.zzu((byte[]) obj);
            case 13:
                return zzbqk.zzff(((Integer) obj).intValue());
            case 14:
                return zzbqk.zzfi(((Integer) obj).intValue());
            case 15:
                return zzbqk.zzbf(((Long) obj).longValue());
            case 16:
                return zzbqk.zzfg(((Integer) obj).intValue());
            case 17:
                return zzbqk.zzbd(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzbrg) {
                    return zzbqk.zzfj(((zzbrg) obj).zzom());
                }
                return zzbqk.zzfj(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static boolean a(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.zzamm() == zzbuo.MESSAGE) {
            if (key.zzamn()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((zzbsl) it.next()).isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzbsl) {
                    if (!((zzbsl) value).isInitialized()) {
                        return false;
                    }
                } else {
                    if (value instanceof zzbro) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void a(Mh<FieldDescriptorType> mh) {
        for (int i = 0; i < mh.f11688b.c(); i++) {
            b(mh.f11688b.b(i));
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = mh.f11688b.d().iterator();
        while (it.hasNext()) {
            b(it.next());
        }
    }

    private static Object a(Object obj) {
        if (obj instanceof zzbss) {
            return ((zzbss) obj).zzaoc();
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
    public static void a(zzbqk zzbqkVar, zzbuj zzbujVar, int i, Object obj) throws IOException {
        if (zzbujVar == zzbuj.zzfvi) {
            zzbsl zzbslVar = (zzbsl) obj;
            zzbrf.zzi(zzbslVar);
            zzbqkVar.zzu(i, 3);
            zzbslVar.zzb(zzbqkVar);
            zzbqkVar.zzu(i, 4);
            return;
        }
        zzbqkVar.zzu(i, zzbujVar.zzapk());
        switch (Nh.f11714b[zzbujVar.ordinal()]) {
            case 1:
                zzbqkVar.zzb(((Double) obj).doubleValue());
                return;
            case 2:
                zzbqkVar.zzf(((Float) obj).floatValue());
                return;
            case 3:
                zzbqkVar.zzay(((Long) obj).longValue());
                return;
            case 4:
                zzbqkVar.zzay(((Long) obj).longValue());
                return;
            case 5:
                zzbqkVar.zzez(((Integer) obj).intValue());
                return;
            case 6:
                zzbqkVar.zzba(((Long) obj).longValue());
                return;
            case 7:
                zzbqkVar.zzfc(((Integer) obj).intValue());
                return;
            case 8:
                zzbqkVar.zzbd(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzbsl) obj).zzb(zzbqkVar);
                return;
            case 10:
                zzbqkVar.zze((zzbsl) obj);
                return;
            case 11:
                if (obj instanceof zzbpu) {
                    zzbqkVar.zzan((zzbpu) obj);
                    return;
                } else {
                    zzbqkVar.zzfx((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzbpu) {
                    zzbqkVar.zzan((zzbpu) obj);
                    return;
                } else {
                    byte[] bArr = (byte[]) obj;
                    zzbqkVar.zzl(bArr, 0, bArr.length);
                    return;
                }
            case 13:
                zzbqkVar.zzfa(((Integer) obj).intValue());
                return;
            case 14:
                zzbqkVar.zzfc(((Integer) obj).intValue());
                return;
            case 15:
                zzbqkVar.zzba(((Long) obj).longValue());
                return;
            case 16:
                zzbqkVar.zzfb(((Integer) obj).intValue());
                return;
            case 17:
                zzbqkVar.zzaz(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzbrg) {
                    zzbqkVar.zzez(((zzbrg) obj).zzom());
                    return;
                } else {
                    zzbqkVar.zzez(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    private static int b(zzbqw<?> zzbqwVar, Object obj) {
        zzbuj zzaml = zzbqwVar.zzaml();
        int zzom = zzbqwVar.zzom();
        if (zzbqwVar.zzamn()) {
            int i = 0;
            if (zzbqwVar.zzamo()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    i += b(zzaml, it.next());
                }
                return zzbqk.zzfd(zzom) + i + zzbqk.zzfl(i);
            }
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                i += a(zzaml, zzom, it2.next());
            }
            return i;
        }
        return a(zzaml, zzom, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(zzbuj zzbujVar, int i, Object obj) {
        int zzfd = zzbqk.zzfd(i);
        if (zzbujVar == zzbuj.zzfvi) {
            zzbrf.zzi((zzbsl) obj);
            zzfd <<= 1;
        }
        return zzfd + b(zzbujVar, obj);
    }
}
