package com.google.android.gms.internal.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class a implements Cloneable {

    /* renamed from: a */
    private zzbc<?, ?> f12936a;

    /* renamed from: b */
    private Object f12937b;

    /* renamed from: c */
    private List<b> f12938c = new ArrayList();

    private final byte[] b() throws IOException {
        byte[] bArr = new byte[a()];
        a(zzaz.zza(bArr));
        return bArr;
    }

    /* renamed from: c */
    public final a clone() {
        a aVar = new a();
        try {
            aVar.f12936a = this.f12936a;
            if (this.f12938c == null) {
                aVar.f12938c = null;
            } else {
                aVar.f12938c.addAll(this.f12938c);
            }
            if (this.f12937b != null) {
                if (this.f12937b instanceof zzbh) {
                    aVar.f12937b = (zzbh) ((zzbh) this.f12937b).clone();
                } else if (this.f12937b instanceof byte[]) {
                    aVar.f12937b = ((byte[]) this.f12937b).clone();
                } else {
                    int i = 0;
                    if (this.f12937b instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.f12937b;
                        byte[][] bArr2 = new byte[bArr.length];
                        aVar.f12937b = bArr2;
                        while (i < bArr.length) {
                            bArr2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (this.f12937b instanceof boolean[]) {
                        aVar.f12937b = ((boolean[]) this.f12937b).clone();
                    } else if (this.f12937b instanceof int[]) {
                        aVar.f12937b = ((int[]) this.f12937b).clone();
                    } else if (this.f12937b instanceof long[]) {
                        aVar.f12937b = ((long[]) this.f12937b).clone();
                    } else if (this.f12937b instanceof float[]) {
                        aVar.f12937b = ((float[]) this.f12937b).clone();
                    } else if (this.f12937b instanceof double[]) {
                        aVar.f12937b = ((double[]) this.f12937b).clone();
                    } else if (this.f12937b instanceof zzbh[]) {
                        zzbh[] zzbhVarArr = (zzbh[]) this.f12937b;
                        zzbh[] zzbhVarArr2 = new zzbh[zzbhVarArr.length];
                        aVar.f12937b = zzbhVarArr2;
                        while (i < zzbhVarArr.length) {
                            zzbhVarArr2[i] = (zzbh) zzbhVarArr[i].clone();
                            i++;
                        }
                    }
                }
            }
            return aVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public final void a(b bVar) throws IOException {
        List<b> list = this.f12938c;
        if (list != null) {
            list.add(bVar);
            return;
        }
        Object obj = this.f12937b;
        if (obj instanceof zzbh) {
            byte[] bArr = bVar.f12940b;
            zzay zza = zzay.zza(bArr, 0, bArr.length);
            int zzz = zza.zzz();
            if (zzz == bArr.length - zzaz.zzj(zzz)) {
                zzbh zza2 = ((zzbh) this.f12937b).zza(zza);
                this.f12936a = this.f12936a;
                this.f12937b = zza2;
                this.f12938c = null;
                return;
            }
            throw zzbg.zzag();
        }
        if (!(obj instanceof zzbh[])) {
            if (!(obj instanceof zzax)) {
                if (obj instanceof zzax[]) {
                    Collections.singletonList(bVar);
                    throw new NoSuchMethodError();
                }
                Collections.singletonList(bVar);
                throw new NoSuchMethodError();
            }
            Collections.singletonList(bVar);
            throw new NoSuchMethodError();
        }
        Collections.singletonList(bVar);
        throw new NoSuchMethodError();
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
        if (this.f12937b != null && aVar.f12937b != null) {
            zzbc<?, ?> zzbcVar = this.f12936a;
            if (zzbcVar != aVar.f12936a) {
                return false;
            }
            if (!zzbcVar.zzci.isArray()) {
                return this.f12937b.equals(aVar.f12937b);
            }
            Object obj2 = this.f12937b;
            if (obj2 instanceof byte[]) {
                return Arrays.equals((byte[]) obj2, (byte[]) aVar.f12937b);
            }
            if (obj2 instanceof int[]) {
                return Arrays.equals((int[]) obj2, (int[]) aVar.f12937b);
            }
            if (obj2 instanceof long[]) {
                return Arrays.equals((long[]) obj2, (long[]) aVar.f12937b);
            }
            if (obj2 instanceof float[]) {
                return Arrays.equals((float[]) obj2, (float[]) aVar.f12937b);
            }
            if (obj2 instanceof double[]) {
                return Arrays.equals((double[]) obj2, (double[]) aVar.f12937b);
            }
            if (obj2 instanceof boolean[]) {
                return Arrays.equals((boolean[]) obj2, (boolean[]) aVar.f12937b);
            }
            return Arrays.deepEquals((Object[]) obj2, (Object[]) aVar.f12937b);
        }
        List<b> list2 = this.f12938c;
        if (list2 != null && (list = aVar.f12938c) != null) {
            return list2.equals(list);
        }
        try {
            return Arrays.equals(b(), aVar.b());
        } catch (IOException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(b()) + 527;
        } catch (IOException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public final int a() {
        if (this.f12937b == null) {
            int i = 0;
            for (b bVar : this.f12938c) {
                i += zzaz.zzn(bVar.f12939a) + 0 + bVar.f12940b.length;
            }
            return i;
        }
        throw new NoSuchMethodError();
    }

    public final void a(zzaz zzazVar) throws IOException {
        if (this.f12937b == null) {
            for (b bVar : this.f12938c) {
                zzazVar.zzm(bVar.f12939a);
                zzazVar.zzc(bVar.f12940b);
            }
            return;
        }
        throw new NoSuchMethodError();
    }
}
