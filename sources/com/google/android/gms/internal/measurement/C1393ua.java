package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuh;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.ua, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C1393ua<FieldDescriptorType extends zzuh<FieldDescriptorType>> {

    /* renamed from: a, reason: collision with root package name */
    private static final C1393ua f13529a = new C1393ua(true);

    /* renamed from: c, reason: collision with root package name */
    private boolean f13531c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f13532d = false;

    /* renamed from: b, reason: collision with root package name */
    private final C1362fb<FieldDescriptorType, Object> f13530b = C1362fb.a(16);

    private C1393ua() {
    }

    public static <T extends zzuh<T>> C1393ua<T> g() {
        return f13529a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Iterator<Map.Entry<FieldDescriptorType, Object>> a() {
        if (this.f13532d) {
            return new Da(this.f13530b.e().iterator());
        }
        return this.f13530b.e().iterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b() {
        return this.f13530b.isEmpty();
    }

    public final boolean c() {
        return this.f13531c;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        C1393ua c1393ua = new C1393ua();
        for (int i = 0; i < this.f13530b.c(); i++) {
            Map.Entry<FieldDescriptorType, Object> b2 = this.f13530b.b(i);
            c1393ua.a((C1393ua) b2.getKey(), b2.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f13530b.d()) {
            c1393ua.a((C1393ua) entry.getKey(), entry.getValue());
        }
        c1393ua.f13532d = this.f13532d;
        return c1393ua;
    }

    public final boolean d() {
        for (int i = 0; i < this.f13530b.c(); i++) {
            if (!a((Map.Entry) this.f13530b.b(i))) {
                return false;
            }
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = this.f13530b.d().iterator();
        while (it.hasNext()) {
            if (!a((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> e() {
        if (this.f13532d) {
            return new Da(this.f13530b.entrySet().iterator());
        }
        return this.f13530b.entrySet().iterator();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1393ua) {
            return this.f13530b.equals(((C1393ua) obj).f13530b);
        }
        return false;
    }

    public final void f() {
        if (this.f13531c) {
            return;
        }
        this.f13530b.b();
        this.f13531c = true;
    }

    public final int h() {
        int i = 0;
        for (int i2 = 0; i2 < this.f13530b.c(); i2++) {
            Map.Entry<FieldDescriptorType, Object> b2 = this.f13530b.b(i2);
            i += b((zzuh<?>) b2.getKey(), b2.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f13530b.d()) {
            i += b((zzuh<?>) entry.getKey(), entry.getValue());
        }
        return i;
    }

    public final int hashCode() {
        return this.f13530b.hashCode();
    }

    public final int i() {
        int i = 0;
        for (int i2 = 0; i2 < this.f13530b.c(); i2++) {
            i += c(this.f13530b.b(i2));
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = this.f13530b.d().iterator();
        while (it.hasNext()) {
            i += c(it.next());
        }
        return i;
    }

    private final void b(Map.Entry<FieldDescriptorType, Object> entry) {
        zzvv zzwo;
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (!(value instanceof zzuy)) {
            if (key.zzwb()) {
                Object a2 = a((C1393ua<FieldDescriptorType>) key);
                if (a2 == null) {
                    a2 = new ArrayList();
                }
                Iterator it = ((List) value).iterator();
                while (it.hasNext()) {
                    ((List) a2).add(a(it.next()));
                }
                this.f13530b.a((C1362fb<FieldDescriptorType, Object>) key, (FieldDescriptorType) a2);
                return;
            }
            if (key.zzwa() == zzxx.MESSAGE) {
                Object a3 = a((C1393ua<FieldDescriptorType>) key);
                if (a3 == null) {
                    this.f13530b.a((C1362fb<FieldDescriptorType, Object>) key, (FieldDescriptorType) a(value));
                    return;
                }
                if (a3 instanceof zzwb) {
                    zzwo = key.zza((zzwb) a3, (zzwb) value);
                } else {
                    zzwo = key.zza(((zzvv) a3).zzwh(), (zzvv) value).zzwo();
                }
                this.f13530b.a((C1362fb<FieldDescriptorType, Object>) key, (FieldDescriptorType) zzwo);
                return;
            }
            this.f13530b.a((C1362fb<FieldDescriptorType, Object>) key, (FieldDescriptorType) a(value));
            return;
        }
        zzuy.zzwz();
        throw null;
    }

    private static int c(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzwa() == zzxx.MESSAGE && !key.zzwb() && !key.zzwc()) {
            if (value instanceof zzuy) {
                return zztv.zzb(entry.getKey().zzc(), (zzuy) value);
            }
            return zztv.zzd(entry.getKey().zzc(), (zzvv) value);
        }
        return b((zzuh<?>) key, value);
    }

    private C1393ua(boolean z) {
        f();
    }

    private final Object a(FieldDescriptorType fielddescriptortype) {
        Object obj = this.f13530b.get(fielddescriptortype);
        if (!(obj instanceof zzuy)) {
            return obj;
        }
        zzuy.zzwz();
        throw null;
    }

    private final void a(FieldDescriptorType fielddescriptortype, Object obj) {
        if (fielddescriptortype.zzwb()) {
            if (obj instanceof List) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj2 = arrayList.get(i);
                    i++;
                    a(fielddescriptortype.zzvz(), obj2);
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            a(fielddescriptortype.zzvz(), obj);
        }
        if (obj instanceof zzuy) {
            this.f13532d = true;
        }
        this.f13530b.a((C1362fb<FieldDescriptorType, Object>) fielddescriptortype, (FieldDescriptorType) obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0024, code lost:            if ((r3 instanceof com.google.android.gms.internal.measurement.zzur) == false) goto L27;     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:            if ((r3 instanceof byte[]) == false) goto L27;     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:            if ((r3 instanceof com.google.android.gms.internal.measurement.zzuy) == false) goto L27;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(com.google.android.gms.internal.measurement.zzxs r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.measurement.zzuq.checkNotNull(r3)
            int[] r0 = com.google.android.gms.internal.measurement.C1395va.f13537a
            com.google.android.gms.internal.measurement.zzxx r2 = r2.zzyv()
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
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzvv
            if (r2 != 0) goto L26
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzuy
            if (r2 == 0) goto L43
            goto L26
        L1e:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L26
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzur
            if (r2 == 0) goto L43
        L26:
            r1 = 1
            goto L43
        L28:
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzte
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C1393ua.a(com.google.android.gms.internal.measurement.zzxs, java.lang.Object):void");
    }

    private static int b(zzxs zzxsVar, Object obj) {
        switch (C1395va.f13538b[zzxsVar.ordinal()]) {
            case 1:
                return zztv.zzc(((Double) obj).doubleValue());
            case 2:
                return zztv.zzb(((Float) obj).floatValue());
            case 3:
                return zztv.zzaw(((Long) obj).longValue());
            case 4:
                return zztv.zzax(((Long) obj).longValue());
            case 5:
                return zztv.zzbe(((Integer) obj).intValue());
            case 6:
                return zztv.zzaz(((Long) obj).longValue());
            case 7:
                return zztv.zzbh(((Integer) obj).intValue());
            case 8:
                return zztv.zzt(((Boolean) obj).booleanValue());
            case 9:
                return zztv.zzd((zzvv) obj);
            case 10:
                if (obj instanceof zzuy) {
                    return zztv.zza((zzuy) obj);
                }
                return zztv.zzc((zzvv) obj);
            case 11:
                if (obj instanceof zzte) {
                    return zztv.zzb((zzte) obj);
                }
                return zztv.zzgc((String) obj);
            case 12:
                if (obj instanceof zzte) {
                    return zztv.zzb((zzte) obj);
                }
                return zztv.zzk((byte[]) obj);
            case 13:
                return zztv.zzbf(((Integer) obj).intValue());
            case 14:
                return zztv.zzbi(((Integer) obj).intValue());
            case 15:
                return zztv.zzba(((Long) obj).longValue());
            case 16:
                return zztv.zzbg(((Integer) obj).intValue());
            case 17:
                return zztv.zzay(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzur) {
                    return zztv.zzbj(((zzur) obj).zzc());
                }
                return zztv.zzbj(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static boolean a(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.zzwa() == zzxx.MESSAGE) {
            if (key.zzwb()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((zzvv) it.next()).isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzvv) {
                    if (!((zzvv) value).isInitialized()) {
                        return false;
                    }
                } else {
                    if (value instanceof zzuy) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void a(C1393ua<FieldDescriptorType> c1393ua) {
        for (int i = 0; i < c1393ua.f13530b.c(); i++) {
            b(c1393ua.f13530b.b(i));
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = c1393ua.f13530b.d().iterator();
        while (it.hasNext()) {
            b(it.next());
        }
    }

    private static Object a(Object obj) {
        if (obj instanceof zzwb) {
            return ((zzwb) obj).zzxp();
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
    public static void a(zztv zztvVar, zzxs zzxsVar, int i, Object obj) throws IOException {
        if (zzxsVar == zzxs.zzcdq) {
            zzvv zzvvVar = (zzvv) obj;
            zzuq.zzf(zzvvVar);
            zztvVar.zzc(i, 3);
            zzvvVar.zzb(zztvVar);
            zztvVar.zzc(i, 4);
            return;
        }
        zztvVar.zzc(i, zzxsVar.zzyw());
        switch (C1395va.f13538b[zzxsVar.ordinal()]) {
            case 1:
                zztvVar.zzb(((Double) obj).doubleValue());
                return;
            case 2:
                zztvVar.zza(((Float) obj).floatValue());
                return;
            case 3:
                zztvVar.zzat(((Long) obj).longValue());
                return;
            case 4:
                zztvVar.zzat(((Long) obj).longValue());
                return;
            case 5:
                zztvVar.zzaz(((Integer) obj).intValue());
                return;
            case 6:
                zztvVar.zzav(((Long) obj).longValue());
                return;
            case 7:
                zztvVar.zzbc(((Integer) obj).intValue());
                return;
            case 8:
                zztvVar.zzs(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzvv) obj).zzb(zztvVar);
                return;
            case 10:
                zztvVar.zzb((zzvv) obj);
                return;
            case 11:
                if (obj instanceof zzte) {
                    zztvVar.zza((zzte) obj);
                    return;
                } else {
                    zztvVar.zzgb((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzte) {
                    zztvVar.zza((zzte) obj);
                    return;
                } else {
                    byte[] bArr = (byte[]) obj;
                    zztvVar.zze(bArr, 0, bArr.length);
                    return;
                }
            case 13:
                zztvVar.zzba(((Integer) obj).intValue());
                return;
            case 14:
                zztvVar.zzbc(((Integer) obj).intValue());
                return;
            case 15:
                zztvVar.zzav(((Long) obj).longValue());
                return;
            case 16:
                zztvVar.zzbb(((Integer) obj).intValue());
                return;
            case 17:
                zztvVar.zzau(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzur) {
                    zztvVar.zzaz(((zzur) obj).zzc());
                    return;
                } else {
                    zztvVar.zzaz(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    private static int b(zzuh<?> zzuhVar, Object obj) {
        zzxs zzvz = zzuhVar.zzvz();
        int zzc = zzuhVar.zzc();
        if (zzuhVar.zzwb()) {
            int i = 0;
            if (zzuhVar.zzwc()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    i += b(zzvz, it.next());
                }
                return zztv.zzbd(zzc) + i + zztv.zzbl(i);
            }
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                i += a(zzvz, zzc, it2.next());
            }
            return i;
        }
        return a(zzvz, zzc, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(zzxs zzxsVar, int i, Object obj) {
        int zzbd = zztv.zzbd(i);
        if (zzxsVar == zzxs.zzcdq) {
            zzuq.zzf((zzvv) obj);
            zzbd <<= 1;
        }
        return zzbd + b(zzxsVar, obj);
    }
}
