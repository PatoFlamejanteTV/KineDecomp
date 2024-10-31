package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
final class Yi implements Cloneable {

    /* renamed from: a */
    private zzbuu<?, ?> f11982a;

    /* renamed from: b */
    private Object f11983b;

    /* renamed from: c */
    private List<Zi> f11984c = new ArrayList();

    private final byte[] b() throws IOException {
        byte[] bArr = new byte[a()];
        a(zzbur.zzx(bArr));
        return bArr;
    }

    /* renamed from: c */
    public final Yi clone() {
        Yi yi = new Yi();
        try {
            yi.f11982a = this.f11982a;
            if (this.f11984c == null) {
                yi.f11984c = null;
            } else {
                yi.f11984c.addAll(this.f11984c);
            }
            if (this.f11983b != null) {
                if (this.f11983b instanceof zzbuz) {
                    yi.f11983b = (zzbuz) ((zzbuz) this.f11983b).clone();
                } else if (this.f11983b instanceof byte[]) {
                    yi.f11983b = ((byte[]) this.f11983b).clone();
                } else {
                    int i = 0;
                    if (this.f11983b instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.f11983b;
                        byte[][] bArr2 = new byte[bArr.length];
                        yi.f11983b = bArr2;
                        while (i < bArr.length) {
                            bArr2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (this.f11983b instanceof boolean[]) {
                        yi.f11983b = ((boolean[]) this.f11983b).clone();
                    } else if (this.f11983b instanceof int[]) {
                        yi.f11983b = ((int[]) this.f11983b).clone();
                    } else if (this.f11983b instanceof long[]) {
                        yi.f11983b = ((long[]) this.f11983b).clone();
                    } else if (this.f11983b instanceof float[]) {
                        yi.f11983b = ((float[]) this.f11983b).clone();
                    } else if (this.f11983b instanceof double[]) {
                        yi.f11983b = ((double[]) this.f11983b).clone();
                    } else if (this.f11983b instanceof zzbuz[]) {
                        zzbuz[] zzbuzVarArr = (zzbuz[]) this.f11983b;
                        zzbuz[] zzbuzVarArr2 = new zzbuz[zzbuzVarArr.length];
                        yi.f11983b = zzbuzVarArr2;
                        while (i < zzbuzVarArr.length) {
                            zzbuzVarArr2[i] = (zzbuz) zzbuzVarArr[i].clone();
                            i++;
                        }
                    }
                }
            }
            return yi;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public final void a(Zi zi) throws IOException {
        List<Zi> list = this.f11984c;
        if (list != null) {
            list.add(zi);
            return;
        }
        Object obj = this.f11983b;
        if (obj instanceof zzbuz) {
            byte[] bArr = zi.f12012b;
            zzbuq zzq = zzbuq.zzq(bArr, 0, bArr.length);
            int zzalm = zzq.zzalm();
            if (zzalm == bArr.length - zzbur.zzfe(zzalm)) {
                zzbuz zza = ((zzbuz) this.f11983b).zza(zzq);
                this.f11982a = this.f11982a;
                this.f11983b = zza;
                this.f11984c = null;
                return;
            }
            throw zzbuy.zzapo();
        }
        if (obj instanceof zzbuz[]) {
            Collections.singletonList(zi);
            throw new NoSuchMethodError();
        }
        Collections.singletonList(zi);
        throw new NoSuchMethodError();
    }

    public final boolean equals(Object obj) {
        List<Zi> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Yi)) {
            return false;
        }
        Yi yi = (Yi) obj;
        if (this.f11983b != null && yi.f11983b != null) {
            zzbuu<?, ?> zzbuuVar = this.f11982a;
            if (zzbuuVar != yi.f11982a) {
                return false;
            }
            if (!zzbuuVar.zzfwl.isArray()) {
                return this.f11983b.equals(yi.f11983b);
            }
            Object obj2 = this.f11983b;
            if (obj2 instanceof byte[]) {
                return Arrays.equals((byte[]) obj2, (byte[]) yi.f11983b);
            }
            if (obj2 instanceof int[]) {
                return Arrays.equals((int[]) obj2, (int[]) yi.f11983b);
            }
            if (obj2 instanceof long[]) {
                return Arrays.equals((long[]) obj2, (long[]) yi.f11983b);
            }
            if (obj2 instanceof float[]) {
                return Arrays.equals((float[]) obj2, (float[]) yi.f11983b);
            }
            if (obj2 instanceof double[]) {
                return Arrays.equals((double[]) obj2, (double[]) yi.f11983b);
            }
            if (obj2 instanceof boolean[]) {
                return Arrays.equals((boolean[]) obj2, (boolean[]) yi.f11983b);
            }
            return Arrays.deepEquals((Object[]) obj2, (Object[]) yi.f11983b);
        }
        List<Zi> list2 = this.f11984c;
        if (list2 != null && (list = yi.f11984c) != null) {
            return list2.equals(list);
        }
        try {
            return Arrays.equals(b(), yi.b());
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
        if (this.f11983b == null) {
            int i = 0;
            for (Zi zi : this.f11984c) {
                i += zzbur.zzfl(zi.f12011a) + 0 + zi.f12012b.length;
            }
            return i;
        }
        throw new NoSuchMethodError();
    }

    public final void a(zzbur zzburVar) throws IOException {
        if (this.f11983b == null) {
            for (Zi zi : this.f11984c) {
                zzburVar.zzge(zi.f12011a);
                zzburVar.zzz(zi.f12012b);
            }
            return;
        }
        throw new NoSuchMethodError();
    }
}
