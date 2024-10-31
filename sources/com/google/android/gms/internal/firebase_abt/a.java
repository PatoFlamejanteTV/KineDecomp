package com.google.android.gms.internal.firebase_abt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class a implements Cloneable {

    /* renamed from: a */
    private zze<?, ?> f12945a;

    /* renamed from: b */
    private Object f12946b;

    /* renamed from: c */
    private List<b> f12947c = new ArrayList();

    private final byte[] a() throws IOException {
        if (this.f12946b != null) {
            throw new NoSuchMethodError();
        }
        int i = 0;
        for (b bVar : this.f12947c) {
            i += zzb.zzf(bVar.f12948a) + 0 + bVar.f12949b.length;
        }
        byte[] bArr = new byte[i];
        zzb zzb = zzb.zzb(bArr);
        if (this.f12946b != null) {
            throw new NoSuchMethodError();
        }
        for (b bVar2 : this.f12947c) {
            zzb.zze(bVar2.f12948a);
            zzb.zzc(bVar2.f12949b);
        }
        return bArr;
    }

    /* renamed from: b */
    public final a clone() {
        Object clone;
        a aVar = new a();
        try {
            aVar.f12945a = this.f12945a;
            if (this.f12947c == null) {
                aVar.f12947c = null;
            } else {
                aVar.f12947c.addAll(this.f12947c);
            }
            if (this.f12946b != null) {
                if (this.f12946b instanceof zzj) {
                    clone = (zzj) ((zzj) this.f12946b).clone();
                } else if (this.f12946b instanceof byte[]) {
                    clone = ((byte[]) this.f12946b).clone();
                } else {
                    int i = 0;
                    if (this.f12946b instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.f12946b;
                        byte[][] bArr2 = new byte[bArr.length];
                        aVar.f12946b = bArr2;
                        while (i < bArr.length) {
                            bArr2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (this.f12946b instanceof boolean[]) {
                        clone = ((boolean[]) this.f12946b).clone();
                    } else if (this.f12946b instanceof int[]) {
                        clone = ((int[]) this.f12946b).clone();
                    } else if (this.f12946b instanceof long[]) {
                        clone = ((long[]) this.f12946b).clone();
                    } else if (this.f12946b instanceof float[]) {
                        clone = ((float[]) this.f12946b).clone();
                    } else if (this.f12946b instanceof double[]) {
                        clone = ((double[]) this.f12946b).clone();
                    } else if (this.f12946b instanceof zzj[]) {
                        zzj[] zzjVarArr = (zzj[]) this.f12946b;
                        zzj[] zzjVarArr2 = new zzj[zzjVarArr.length];
                        aVar.f12946b = zzjVarArr2;
                        while (i < zzjVarArr.length) {
                            zzjVarArr2[i] = (zzj) zzjVarArr[i].clone();
                            i++;
                        }
                    }
                }
                aVar.f12946b = clone;
            }
            return aVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public final void a(b bVar) throws IOException {
        List<b> list = this.f12947c;
        if (list != null) {
            list.add(bVar);
            return;
        }
        Object obj = this.f12946b;
        if (!(obj instanceof zzj)) {
            if (obj instanceof zzj[]) {
                Collections.singletonList(bVar);
                throw new NoSuchMethodError();
            }
            Collections.singletonList(bVar);
            throw new NoSuchMethodError();
        }
        byte[] bArr = bVar.f12949b;
        zza zza = zza.zza(bArr, 0, bArr.length);
        int zzg = zza.zzg();
        if (zzg != bArr.length - (zzg >= 0 ? zzb.zzf(zzg) : 10)) {
            throw zzi.zzl();
        }
        zzj zza2 = ((zzj) this.f12946b).zza(zza);
        this.f12945a = this.f12945a;
        this.f12946b = zza2;
        this.f12947c = null;
    }

    public final boolean equals(Object obj) {
        List<b> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f12946b == null || aVar.f12946b == null) {
            List<b> list2 = this.f12947c;
            if (list2 != null && (list = aVar.f12947c) != null) {
                return list2.equals(list);
            }
            try {
                return Arrays.equals(a(), aVar.a());
            } catch (IOException e2) {
                throw new IllegalStateException(e2);
            }
        }
        zze<?, ?> zzeVar = this.f12945a;
        if (zzeVar != aVar.f12945a) {
            return false;
        }
        if (!zzeVar.zzt.isArray()) {
            return this.f12946b.equals(aVar.f12946b);
        }
        Object obj2 = this.f12946b;
        return obj2 instanceof byte[] ? Arrays.equals((byte[]) obj2, (byte[]) aVar.f12946b) : obj2 instanceof int[] ? Arrays.equals((int[]) obj2, (int[]) aVar.f12946b) : obj2 instanceof long[] ? Arrays.equals((long[]) obj2, (long[]) aVar.f12946b) : obj2 instanceof float[] ? Arrays.equals((float[]) obj2, (float[]) aVar.f12946b) : obj2 instanceof double[] ? Arrays.equals((double[]) obj2, (double[]) aVar.f12946b) : obj2 instanceof boolean[] ? Arrays.equals((boolean[]) obj2, (boolean[]) aVar.f12946b) : Arrays.deepEquals((Object[]) obj2, (Object[]) aVar.f12946b);
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(a()) + 527;
        } catch (IOException e2) {
            throw new IllegalStateException(e2);
        }
    }
}
