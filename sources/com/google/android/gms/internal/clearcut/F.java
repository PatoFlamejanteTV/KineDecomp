package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzca;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class F<FieldDescriptorType extends zzca<FieldDescriptorType>> {

    /* renamed from: a, reason: collision with root package name */
    private static final F f12772a = new F(true);

    /* renamed from: c, reason: collision with root package name */
    private boolean f12774c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f12775d = false;

    /* renamed from: b, reason: collision with root package name */
    private final C1223sa<FieldDescriptorType, Object> f12773b = C1223sa.a(16);

    private F() {
    }

    private F(boolean z) {
        i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(zzfl zzflVar, int i, Object obj) {
        int zzr = zzbn.zzr(i);
        if (zzflVar == zzfl.zzql) {
            zzci.zzf((zzdo) obj);
            zzr <<= 1;
        }
        return zzr + b(zzflVar, obj);
    }

    private final Object a(FieldDescriptorType fielddescriptortype) {
        Object obj = this.f12773b.get(fielddescriptortype);
        if (!(obj instanceof zzcr)) {
            return obj;
        }
        zzcr.zzbr();
        throw null;
    }

    private static Object a(Object obj) {
        if (obj instanceof zzdv) {
            return ((zzdv) obj).zzci();
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
    public static void a(zzbn zzbnVar, zzfl zzflVar, int i, Object obj) throws IOException {
        if (zzflVar == zzfl.zzql) {
            zzdo zzdoVar = (zzdo) obj;
            zzci.zzf(zzdoVar);
            zzbnVar.zzb(i, 3);
            zzdoVar.zzb(zzbnVar);
            zzbnVar.zzb(i, 4);
            return;
        }
        zzbnVar.zzb(i, zzflVar.zzel());
        switch (G.f12777b[zzflVar.ordinal()]) {
            case 1:
                zzbnVar.zza(((Double) obj).doubleValue());
                return;
            case 2:
                zzbnVar.zza(((Float) obj).floatValue());
                return;
            case 3:
                zzbnVar.zzb(((Long) obj).longValue());
                return;
            case 4:
                zzbnVar.zzb(((Long) obj).longValue());
                return;
            case 5:
                zzbnVar.zzn(((Integer) obj).intValue());
                return;
            case 6:
                zzbnVar.zzd(((Long) obj).longValue());
                return;
            case 7:
                zzbnVar.zzq(((Integer) obj).intValue());
                return;
            case 8:
                zzbnVar.zza(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzdo) obj).zzb(zzbnVar);
                return;
            case 10:
                zzbnVar.zzb((zzdo) obj);
                return;
            case 11:
                if (obj instanceof zzbb) {
                    zzbnVar.zza((zzbb) obj);
                    return;
                } else {
                    zzbnVar.zzg((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzbb) {
                    zzbnVar.zza((zzbb) obj);
                    return;
                } else {
                    byte[] bArr = (byte[]) obj;
                    zzbnVar.zzd(bArr, 0, bArr.length);
                    return;
                }
            case 13:
                zzbnVar.zzo(((Integer) obj).intValue());
                return;
            case 14:
                zzbnVar.zzq(((Integer) obj).intValue());
                return;
            case 15:
                zzbnVar.zzd(((Long) obj).longValue());
                return;
            case 16:
                zzbnVar.zzp(((Integer) obj).intValue());
                return;
            case 17:
                zzbnVar.zzc(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzcj) {
                    zzbnVar.zzn(((zzcj) obj).zzc());
                    return;
                } else {
                    zzbnVar.zzn(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    private final void a(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.zzaw()) {
            a(fielddescriptortype.zzau(), obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                a(fielddescriptortype.zzau(), obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof zzcr) {
            this.f12775d = true;
        }
        this.f12773b.a((C1223sa<FieldDescriptorType, Object>) fielddescriptortype, (FieldDescriptorType) obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0024, code lost:            if ((r3 instanceof com.google.android.gms.internal.clearcut.zzcj) == false) goto L27;     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:            if ((r3 instanceof byte[]) == false) goto L27;     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:            if ((r3 instanceof com.google.android.gms.internal.clearcut.zzcr) == false) goto L27;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(com.google.android.gms.internal.clearcut.zzfl r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.clearcut.zzci.checkNotNull(r3)
            int[] r0 = com.google.android.gms.internal.clearcut.G.f12776a
            com.google.android.gms.internal.clearcut.zzfq r2 = r2.zzek()
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
            boolean r2 = r3 instanceof com.google.android.gms.internal.clearcut.zzdo
            if (r2 != 0) goto L26
            boolean r2 = r3 instanceof com.google.android.gms.internal.clearcut.zzcr
            if (r2 == 0) goto L43
            goto L26
        L1e:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L26
            boolean r2 = r3 instanceof com.google.android.gms.internal.clearcut.zzcj
            if (r2 == 0) goto L43
        L26:
            r1 = 1
            goto L43
        L28:
            boolean r2 = r3 instanceof com.google.android.gms.internal.clearcut.zzbb
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.F.a(com.google.android.gms.internal.clearcut.zzfl, java.lang.Object):void");
    }

    private static boolean a(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.zzav() == zzfq.MESSAGE) {
            if (key.zzaw()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((zzdo) it.next()).isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (!(value instanceof zzdo)) {
                    if (value instanceof zzcr) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
                if (!((zzdo) value).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int b(zzca<?> zzcaVar, Object obj) {
        zzfl zzau = zzcaVar.zzau();
        int zzc = zzcaVar.zzc();
        if (!zzcaVar.zzaw()) {
            return a(zzau, zzc, obj);
        }
        int i = 0;
        if (zzcaVar.zzax()) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                i += b(zzau, it.next());
            }
            return zzbn.zzr(zzc) + i + zzbn.zzz(i);
        }
        Iterator it2 = ((List) obj).iterator();
        while (it2.hasNext()) {
            i += a(zzau, zzc, it2.next());
        }
        return i;
    }

    private static int b(zzfl zzflVar, Object obj) {
        switch (G.f12777b[zzflVar.ordinal()]) {
            case 1:
                return zzbn.zzb(((Double) obj).doubleValue());
            case 2:
                return zzbn.zzb(((Float) obj).floatValue());
            case 3:
                return zzbn.zze(((Long) obj).longValue());
            case 4:
                return zzbn.zzf(((Long) obj).longValue());
            case 5:
                return zzbn.zzs(((Integer) obj).intValue());
            case 6:
                return zzbn.zzh(((Long) obj).longValue());
            case 7:
                return zzbn.zzv(((Integer) obj).intValue());
            case 8:
                return zzbn.zzb(((Boolean) obj).booleanValue());
            case 9:
                return zzbn.zzd((zzdo) obj);
            case 10:
                return obj instanceof zzcr ? zzbn.zza((zzcr) obj) : zzbn.zzc((zzdo) obj);
            case 11:
                return obj instanceof zzbb ? zzbn.zzb((zzbb) obj) : zzbn.zzh((String) obj);
            case 12:
                return obj instanceof zzbb ? zzbn.zzb((zzbb) obj) : zzbn.zzd((byte[]) obj);
            case 13:
                return zzbn.zzt(((Integer) obj).intValue());
            case 14:
                return zzbn.zzw(((Integer) obj).intValue());
            case 15:
                return zzbn.zzi(((Long) obj).longValue());
            case 16:
                return zzbn.zzu(((Integer) obj).intValue());
            case 17:
                return zzbn.zzg(((Long) obj).longValue());
            case 18:
                return obj instanceof zzcj ? zzbn.zzx(((zzcj) obj).zzc()) : zzbn.zzx(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private final void b(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzcr) {
            zzcr.zzbr();
            throw null;
        }
        if (key.zzaw()) {
            Object a2 = a((F<FieldDescriptorType>) key);
            if (a2 == null) {
                a2 = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) a2).add(a(it.next()));
            }
            this.f12773b.a((C1223sa<FieldDescriptorType, Object>) key, (FieldDescriptorType) a2);
            return;
        }
        if (key.zzav() != zzfq.MESSAGE) {
            this.f12773b.a((C1223sa<FieldDescriptorType, Object>) key, (FieldDescriptorType) a(value));
            return;
        }
        Object a3 = a((F<FieldDescriptorType>) key);
        if (a3 == null) {
            this.f12773b.a((C1223sa<FieldDescriptorType, Object>) key, (FieldDescriptorType) a(value));
        } else {
            this.f12773b.a((C1223sa<FieldDescriptorType, Object>) key, (FieldDescriptorType) (a3 instanceof zzdv ? key.zza((zzdv) a3, (zzdv) value) : key.zza(((zzdo) a3).zzbc(), (zzdo) value).zzbj()));
        }
    }

    private static int c(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        return (key.zzav() != zzfq.MESSAGE || key.zzaw() || key.zzax()) ? b((zzca<?>) key, value) : value instanceof zzcr ? zzbn.zzb(entry.getKey().zzc(), (zzcr) value) : zzbn.zzd(entry.getKey().zzc(), (zzdo) value);
    }

    public static <T extends zzca<T>> F<T> f() {
        return f12772a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Iterator<Map.Entry<FieldDescriptorType, Object>> a() {
        return this.f12775d ? new N(this.f12773b.d().iterator()) : this.f12773b.d().iterator();
    }

    public final void a(F<FieldDescriptorType> f2) {
        for (int i = 0; i < f2.f12773b.b(); i++) {
            b(f2.f12773b.b(i));
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = f2.f12773b.c().iterator();
        while (it.hasNext()) {
            b(it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b() {
        return this.f12773b.isEmpty();
    }

    public final boolean c() {
        return this.f12774c;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        F f2 = new F();
        for (int i = 0; i < this.f12773b.b(); i++) {
            Map.Entry<FieldDescriptorType, Object> b2 = this.f12773b.b(i);
            f2.a((F) b2.getKey(), b2.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f12773b.c()) {
            f2.a((F) entry.getKey(), entry.getValue());
        }
        f2.f12775d = this.f12775d;
        return f2;
    }

    public final boolean d() {
        for (int i = 0; i < this.f12773b.b(); i++) {
            if (!a((Map.Entry) this.f12773b.b(i))) {
                return false;
            }
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = this.f12773b.c().iterator();
        while (it.hasNext()) {
            if (!a((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> e() {
        return this.f12775d ? new N(this.f12773b.entrySet().iterator()) : this.f12773b.entrySet().iterator();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof F) {
            return this.f12773b.equals(((F) obj).f12773b);
        }
        return false;
    }

    public final int g() {
        int i = 0;
        for (int i2 = 0; i2 < this.f12773b.b(); i2++) {
            Map.Entry<FieldDescriptorType, Object> b2 = this.f12773b.b(i2);
            i += b((zzca<?>) b2.getKey(), b2.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f12773b.c()) {
            i += b((zzca<?>) entry.getKey(), entry.getValue());
        }
        return i;
    }

    public final int h() {
        int i = 0;
        for (int i2 = 0; i2 < this.f12773b.b(); i2++) {
            i += c(this.f12773b.b(i2));
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = this.f12773b.c().iterator();
        while (it.hasNext()) {
            i += c(it.next());
        }
        return i;
    }

    public final int hashCode() {
        return this.f12773b.hashCode();
    }

    public final void i() {
        if (this.f12774c) {
            return;
        }
        this.f12773b.e();
        this.f12774c = true;
    }
}
