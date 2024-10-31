package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
final class Ta implements Cloneable {

    /* renamed from: a */
    private zzfv<?, ?> f12808a;

    /* renamed from: b */
    private Object f12809b;

    /* renamed from: c */
    private List<Object> f12810c = new ArrayList();

    private final byte[] b() throws IOException {
        byte[] bArr = new byte[a()];
        a(zzfs.zzg(bArr));
        return bArr;
    }

    /* renamed from: c */
    public final Ta clone() {
        Object clone;
        Ta ta = new Ta();
        try {
            ta.f12808a = this.f12808a;
            if (this.f12810c == null) {
                ta.f12810c = null;
            } else {
                ta.f12810c.addAll(this.f12810c);
            }
            if (this.f12809b != null) {
                if (this.f12809b instanceof zzfz) {
                    clone = (zzfz) ((zzfz) this.f12809b).clone();
                } else if (this.f12809b instanceof byte[]) {
                    clone = ((byte[]) this.f12809b).clone();
                } else {
                    int i = 0;
                    if (this.f12809b instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.f12809b;
                        byte[][] bArr2 = new byte[bArr.length];
                        ta.f12809b = bArr2;
                        while (i < bArr.length) {
                            bArr2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (this.f12809b instanceof boolean[]) {
                        clone = ((boolean[]) this.f12809b).clone();
                    } else if (this.f12809b instanceof int[]) {
                        clone = ((int[]) this.f12809b).clone();
                    } else if (this.f12809b instanceof long[]) {
                        clone = ((long[]) this.f12809b).clone();
                    } else if (this.f12809b instanceof float[]) {
                        clone = ((float[]) this.f12809b).clone();
                    } else if (this.f12809b instanceof double[]) {
                        clone = ((double[]) this.f12809b).clone();
                    } else if (this.f12809b instanceof zzfz[]) {
                        zzfz[] zzfzVarArr = (zzfz[]) this.f12809b;
                        zzfz[] zzfzVarArr2 = new zzfz[zzfzVarArr.length];
                        ta.f12809b = zzfzVarArr2;
                        while (i < zzfzVarArr.length) {
                            zzfzVarArr2[i] = (zzfz) zzfzVarArr[i].clone();
                            i++;
                        }
                    }
                }
                ta.f12809b = clone;
            }
            return ta;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public final int a() {
        if (this.f12809b != null) {
            throw new NoSuchMethodError();
        }
        Iterator<Object> it = this.f12810c.iterator();
        if (!it.hasNext()) {
            return 0;
        }
        it.next();
        throw new NoSuchMethodError();
    }

    public final void a(zzfs zzfsVar) throws IOException {
        if (this.f12809b != null) {
            throw new NoSuchMethodError();
        }
        Iterator<Object> it = this.f12810c.iterator();
        if (it.hasNext()) {
            it.next();
            throw new NoSuchMethodError();
        }
    }

    public final boolean equals(Object obj) {
        List<Object> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Ta)) {
            return false;
        }
        Ta ta = (Ta) obj;
        if (this.f12809b == null || ta.f12809b == null) {
            List<Object> list2 = this.f12810c;
            if (list2 != null && (list = ta.f12810c) != null) {
                return list2.equals(list);
            }
            try {
                return Arrays.equals(b(), ta.b());
            } catch (IOException e2) {
                throw new IllegalStateException(e2);
            }
        }
        zzfv<?, ?> zzfvVar = this.f12808a;
        if (zzfvVar != ta.f12808a) {
            return false;
        }
        if (!zzfvVar.zzrk.isArray()) {
            return this.f12809b.equals(ta.f12809b);
        }
        Object obj2 = this.f12809b;
        return obj2 instanceof byte[] ? Arrays.equals((byte[]) obj2, (byte[]) ta.f12809b) : obj2 instanceof int[] ? Arrays.equals((int[]) obj2, (int[]) ta.f12809b) : obj2 instanceof long[] ? Arrays.equals((long[]) obj2, (long[]) ta.f12809b) : obj2 instanceof float[] ? Arrays.equals((float[]) obj2, (float[]) ta.f12809b) : obj2 instanceof double[] ? Arrays.equals((double[]) obj2, (double[]) ta.f12809b) : obj2 instanceof boolean[] ? Arrays.equals((boolean[]) obj2, (boolean[]) ta.f12809b) : Arrays.deepEquals((Object[]) obj2, (Object[]) ta.f12809b);
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(b()) + 527;
        } catch (IOException e2) {
            throw new IllegalStateException(e2);
        }
    }
}
