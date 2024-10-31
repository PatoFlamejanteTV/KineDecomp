package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzqv;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.gtm.sa, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C1330sa<FieldDescriptorType extends zzqv<FieldDescriptorType>> {

    /* renamed from: a, reason: collision with root package name */
    private static final C1330sa f13290a = new C1330sa(true);

    /* renamed from: c, reason: collision with root package name */
    private boolean f13292c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f13293d = false;

    /* renamed from: b, reason: collision with root package name */
    final C1297cb<FieldDescriptorType, Object> f13291b = C1297cb.a(16);

    private C1330sa() {
    }

    public static <T extends zzqv<T>> C1330sa<T> f() {
        return f13290a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Iterator<Map.Entry<FieldDescriptorType, Object>> a() {
        if (this.f13293d) {
            return new Ba(this.f13291b.e().iterator());
        }
        return this.f13291b.e().iterator();
    }

    public final boolean b() {
        return this.f13292c;
    }

    public final boolean c() {
        for (int i = 0; i < this.f13291b.c(); i++) {
            if (!a((Map.Entry) this.f13291b.b(i))) {
                return false;
            }
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = this.f13291b.d().iterator();
        while (it.hasNext()) {
            if (!a((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        C1330sa c1330sa = new C1330sa();
        for (int i = 0; i < this.f13291b.c(); i++) {
            Map.Entry<FieldDescriptorType, Object> b2 = this.f13291b.b(i);
            c1330sa.b((C1330sa) b2.getKey(), b2.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f13291b.d()) {
            c1330sa.b((C1330sa) entry.getKey(), entry.getValue());
        }
        c1330sa.f13293d = this.f13293d;
        return c1330sa;
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> d() {
        if (this.f13293d) {
            return new Ba(this.f13291b.entrySet().iterator());
        }
        return this.f13291b.entrySet().iterator();
    }

    public final void e() {
        if (this.f13292c) {
            return;
        }
        this.f13291b.b();
        this.f13292c = true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1330sa) {
            return this.f13291b.equals(((C1330sa) obj).f13291b);
        }
        return false;
    }

    public final int g() {
        int i = 0;
        for (int i2 = 0; i2 < this.f13291b.c(); i2++) {
            i += c(this.f13291b.b(i2));
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = this.f13291b.d().iterator();
        while (it.hasNext()) {
            i += c(it.next());
        }
        return i;
    }

    public final int hashCode() {
        return this.f13291b.hashCode();
    }

    private final void b(FieldDescriptorType fielddescriptortype, Object obj) {
        if (fielddescriptortype.zzoz()) {
            if (obj instanceof List) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj2 = arrayList.get(i);
                    i++;
                    a(fielddescriptortype.zzox(), obj2);
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            a(fielddescriptortype.zzox(), obj);
        }
        if (obj instanceof zzrn) {
            this.f13293d = true;
        }
        this.f13291b.a((C1297cb<FieldDescriptorType, Object>) fielddescriptortype, (FieldDescriptorType) obj);
    }

    private C1330sa(boolean z) {
        e();
    }

    private final Object a(FieldDescriptorType fielddescriptortype) {
        Object obj = this.f13291b.get(fielddescriptortype);
        if (!(obj instanceof zzrn)) {
            return obj;
        }
        zzrn.zzpy();
        throw null;
    }

    private static int c(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzoy() == zzul.MESSAGE && !key.zzoz() && !key.zzpa()) {
            if (value instanceof zzrn) {
                return zzqj.zzb(entry.getKey().zzc(), (zzrn) value);
            }
            return zzqj.zzd(entry.getKey().zzc(), (zzsk) value);
        }
        return a((zzqv<?>) key, value);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0024, code lost:            if ((r3 instanceof com.google.android.gms.internal.gtm.zzrf) == false) goto L27;     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:            if ((r3 instanceof byte[]) == false) goto L27;     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:            if ((r3 instanceof com.google.android.gms.internal.gtm.zzrn) == false) goto L27;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(com.google.android.gms.internal.gtm.zzug r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.gtm.zzre.checkNotNull(r3)
            int[] r0 = com.google.android.gms.internal.gtm.C1332ta.f13298a
            com.google.android.gms.internal.gtm.zzul r2 = r2.zzrs()
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
            boolean r2 = r3 instanceof com.google.android.gms.internal.gtm.zzsk
            if (r2 != 0) goto L26
            boolean r2 = r3 instanceof com.google.android.gms.internal.gtm.zzrn
            if (r2 == 0) goto L43
            goto L26
        L1e:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L26
            boolean r2 = r3 instanceof com.google.android.gms.internal.gtm.zzrf
            if (r2 == 0) goto L43
        L26:
            r1 = 1
            goto L43
        L28:
            boolean r2 = r3 instanceof com.google.android.gms.internal.gtm.zzps
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.C1330sa.a(com.google.android.gms.internal.gtm.zzug, java.lang.Object):void");
    }

    private final void b(Map.Entry<FieldDescriptorType, Object> entry) {
        zzsk zzpm;
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (!(value instanceof zzrn)) {
            if (key.zzoz()) {
                Object a2 = a((C1330sa<FieldDescriptorType>) key);
                if (a2 == null) {
                    a2 = new ArrayList();
                }
                Iterator it = ((List) value).iterator();
                while (it.hasNext()) {
                    ((List) a2).add(a(it.next()));
                }
                this.f13291b.a((C1297cb<FieldDescriptorType, Object>) key, (FieldDescriptorType) a2);
                return;
            }
            if (key.zzoy() == zzul.MESSAGE) {
                Object a3 = a((C1330sa<FieldDescriptorType>) key);
                if (a3 == null) {
                    this.f13291b.a((C1297cb<FieldDescriptorType, Object>) key, (FieldDescriptorType) a(value));
                    return;
                }
                if (a3 instanceof zzsq) {
                    zzpm = key.zza((zzsq) a3, (zzsq) value);
                } else {
                    zzpm = key.zza(((zzsk) a3).zzpg(), (zzsk) value).zzpm();
                }
                this.f13291b.a((C1297cb<FieldDescriptorType, Object>) key, (FieldDescriptorType) zzpm);
                return;
            }
            this.f13291b.a((C1297cb<FieldDescriptorType, Object>) key, (FieldDescriptorType) a(value));
            return;
        }
        zzrn.zzpy();
        throw null;
    }

    private static boolean a(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.zzoy() == zzul.MESSAGE) {
            if (key.zzoz()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((zzsk) it.next()).isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzsk) {
                    if (!((zzsk) value).isInitialized()) {
                        return false;
                    }
                } else {
                    if (value instanceof zzrn) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void a(C1330sa<FieldDescriptorType> c1330sa) {
        for (int i = 0; i < c1330sa.f13291b.c(); i++) {
            b(c1330sa.f13291b.b(i));
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = c1330sa.f13291b.d().iterator();
        while (it.hasNext()) {
            b(it.next());
        }
    }

    private static Object a(Object obj) {
        if (obj instanceof zzsq) {
            return ((zzsq) obj).zzqo();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private static int b(zzug zzugVar, Object obj) {
        switch (C1332ta.f13299b[zzugVar.ordinal()]) {
            case 1:
                return zzqj.zzc(((Double) obj).doubleValue());
            case 2:
                return zzqj.zzb(((Float) obj).floatValue());
            case 3:
                return zzqj.zzs(((Long) obj).longValue());
            case 4:
                return zzqj.zzt(((Long) obj).longValue());
            case 5:
                return zzqj.zzbc(((Integer) obj).intValue());
            case 6:
                return zzqj.zzv(((Long) obj).longValue());
            case 7:
                return zzqj.zzbf(((Integer) obj).intValue());
            case 8:
                return zzqj.zzj(((Boolean) obj).booleanValue());
            case 9:
                return zzqj.zzd((zzsk) obj);
            case 10:
                if (obj instanceof zzrn) {
                    return zzqj.zza((zzrn) obj);
                }
                return zzqj.zzc((zzsk) obj);
            case 11:
                if (obj instanceof zzps) {
                    return zzqj.zzb((zzps) obj);
                }
                return zzqj.zzda((String) obj);
            case 12:
                if (obj instanceof zzps) {
                    return zzqj.zzb((zzps) obj);
                }
                return zzqj.zzh((byte[]) obj);
            case 13:
                return zzqj.zzbd(((Integer) obj).intValue());
            case 14:
                return zzqj.zzbg(((Integer) obj).intValue());
            case 15:
                return zzqj.zzw(((Long) obj).longValue());
            case 16:
                return zzqj.zzbe(((Integer) obj).intValue());
            case 17:
                return zzqj.zzu(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzrf) {
                    return zzqj.zzbh(((zzrf) obj).zzc());
                }
                return zzqj.zzbh(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(zzqj zzqjVar, zzug zzugVar, int i, Object obj) throws IOException {
        if (zzugVar == zzug.zzbfy) {
            zzsk zzskVar = (zzsk) obj;
            zzre.zzf(zzskVar);
            zzqjVar.zzd(i, 3);
            zzskVar.zzb(zzqjVar);
            zzqjVar.zzd(i, 4);
            return;
        }
        zzqjVar.zzd(i, zzugVar.zzrt());
        switch (C1332ta.f13299b[zzugVar.ordinal()]) {
            case 1:
                zzqjVar.zzb(((Double) obj).doubleValue());
                return;
            case 2:
                zzqjVar.zza(((Float) obj).floatValue());
                return;
            case 3:
                zzqjVar.zzp(((Long) obj).longValue());
                return;
            case 4:
                zzqjVar.zzp(((Long) obj).longValue());
                return;
            case 5:
                zzqjVar.zzax(((Integer) obj).intValue());
                return;
            case 6:
                zzqjVar.zzr(((Long) obj).longValue());
                return;
            case 7:
                zzqjVar.zzba(((Integer) obj).intValue());
                return;
            case 8:
                zzqjVar.zzi(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzsk) obj).zzb(zzqjVar);
                return;
            case 10:
                zzqjVar.zzb((zzsk) obj);
                return;
            case 11:
                if (obj instanceof zzps) {
                    zzqjVar.zza((zzps) obj);
                    return;
                } else {
                    zzqjVar.zzcz((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzps) {
                    zzqjVar.zza((zzps) obj);
                    return;
                } else {
                    byte[] bArr = (byte[]) obj;
                    zzqjVar.zze(bArr, 0, bArr.length);
                    return;
                }
            case 13:
                zzqjVar.zzay(((Integer) obj).intValue());
                return;
            case 14:
                zzqjVar.zzba(((Integer) obj).intValue());
                return;
            case 15:
                zzqjVar.zzr(((Long) obj).longValue());
                return;
            case 16:
                zzqjVar.zzaz(((Integer) obj).intValue());
                return;
            case 17:
                zzqjVar.zzq(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzrf) {
                    zzqjVar.zzax(((zzrf) obj).zzc());
                    return;
                } else {
                    zzqjVar.zzax(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(zzug zzugVar, int i, Object obj) {
        int zzbb = zzqj.zzbb(i);
        if (zzugVar == zzug.zzbfy) {
            zzre.zzf((zzsk) obj);
            zzbb <<= 1;
        }
        return zzbb + b(zzugVar, obj);
    }

    public static int a(zzqv<?> zzqvVar, Object obj) {
        zzug zzox = zzqvVar.zzox();
        int zzc = zzqvVar.zzc();
        if (zzqvVar.zzoz()) {
            int i = 0;
            if (zzqvVar.zzpa()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    i += b(zzox, it.next());
                }
                return zzqj.zzbb(zzc) + i + zzqj.zzbj(i);
            }
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                i += a(zzox, zzc, it2.next());
            }
            return i;
        }
        return a(zzox, zzc, obj);
    }
}
