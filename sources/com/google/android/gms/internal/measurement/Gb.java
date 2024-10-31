package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class Gb implements Cloneable {

    /* renamed from: a */
    private zzyd<?, ?> f13367a;

    /* renamed from: b */
    private Object f13368b;

    /* renamed from: c */
    private List<Hb> f13369c = new ArrayList();

    private final byte[] b() throws IOException {
        byte[] bArr = new byte[a()];
        a(zzya.zzo(bArr));
        return bArr;
    }

    /* renamed from: c */
    public final Gb clone() {
        Gb gb = new Gb();
        try {
            gb.f13367a = this.f13367a;
            if (this.f13369c == null) {
                gb.f13369c = null;
            } else {
                gb.f13369c.addAll(this.f13369c);
            }
            if (this.f13368b != null) {
                if (this.f13368b instanceof zzyi) {
                    gb.f13368b = (zzyi) ((zzyi) this.f13368b).clone();
                } else if (this.f13368b instanceof byte[]) {
                    gb.f13368b = ((byte[]) this.f13368b).clone();
                } else {
                    int i = 0;
                    if (this.f13368b instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.f13368b;
                        byte[][] bArr2 = new byte[bArr.length];
                        gb.f13368b = bArr2;
                        while (i < bArr.length) {
                            bArr2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (this.f13368b instanceof boolean[]) {
                        gb.f13368b = ((boolean[]) this.f13368b).clone();
                    } else if (this.f13368b instanceof int[]) {
                        gb.f13368b = ((int[]) this.f13368b).clone();
                    } else if (this.f13368b instanceof long[]) {
                        gb.f13368b = ((long[]) this.f13368b).clone();
                    } else if (this.f13368b instanceof float[]) {
                        gb.f13368b = ((float[]) this.f13368b).clone();
                    } else if (this.f13368b instanceof double[]) {
                        gb.f13368b = ((double[]) this.f13368b).clone();
                    } else if (this.f13368b instanceof zzyi[]) {
                        zzyi[] zzyiVarArr = (zzyi[]) this.f13368b;
                        zzyi[] zzyiVarArr2 = new zzyi[zzyiVarArr.length];
                        gb.f13368b = zzyiVarArr2;
                        while (i < zzyiVarArr.length) {
                            zzyiVarArr2[i] = (zzyi) zzyiVarArr[i].clone();
                            i++;
                        }
                    }
                }
            }
            return gb;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public final void a(Hb hb) throws IOException {
        Object zzai;
        Object obj;
        List<Hb> list = this.f13369c;
        if (list != null) {
            list.add(hb);
            return;
        }
        Object obj2 = this.f13368b;
        if (obj2 instanceof zzyi) {
            byte[] bArr = hb.f13371b;
            zzxz zzj = zzxz.zzj(bArr, 0, bArr.length);
            int zzvb = zzj.zzvb();
            if (zzvb == bArr.length - zzya.zzbe(zzvb)) {
                zzai = ((zzyi) this.f13368b).zza(zzj);
            } else {
                throw zzyh.zzzd();
            }
        } else {
            if (obj2 instanceof zzyi[]) {
                zzyi[] zzyiVarArr = (zzyi[]) this.f13367a.zzai(Collections.singletonList(hb));
                zzyi[] zzyiVarArr2 = (zzyi[]) this.f13368b;
                obj = (zzyi[]) Arrays.copyOf(zzyiVarArr2, zzyiVarArr2.length + zzyiVarArr.length);
                System.arraycopy(zzyiVarArr, 0, obj, zzyiVarArr2.length, zzyiVarArr.length);
            } else if (obj2 instanceof zzvv) {
                zzai = ((zzvv) this.f13368b).zzwh().zza((zzvv) this.f13367a.zzai(Collections.singletonList(hb))).zzwo();
            } else if (obj2 instanceof zzvv[]) {
                zzvv[] zzvvVarArr = (zzvv[]) this.f13367a.zzai(Collections.singletonList(hb));
                zzvv[] zzvvVarArr2 = (zzvv[]) this.f13368b;
                obj = (zzvv[]) Arrays.copyOf(zzvvVarArr2, zzvvVarArr2.length + zzvvVarArr.length);
                System.arraycopy(zzvvVarArr, 0, obj, zzvvVarArr2.length, zzvvVarArr.length);
            } else {
                zzai = this.f13367a.zzai(Collections.singletonList(hb));
            }
            zzai = obj;
        }
        this.f13367a = this.f13367a;
        this.f13368b = zzai;
        this.f13369c = null;
    }

    public final boolean equals(Object obj) {
        List<Hb> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Gb)) {
            return false;
        }
        Gb gb = (Gb) obj;
        if (this.f13368b != null && gb.f13368b != null) {
            zzyd<?, ?> zzydVar = this.f13367a;
            if (zzydVar != gb.f13367a) {
                return false;
            }
            if (!zzydVar.zzceu.isArray()) {
                return this.f13368b.equals(gb.f13368b);
            }
            Object obj2 = this.f13368b;
            if (obj2 instanceof byte[]) {
                return Arrays.equals((byte[]) obj2, (byte[]) gb.f13368b);
            }
            if (obj2 instanceof int[]) {
                return Arrays.equals((int[]) obj2, (int[]) gb.f13368b);
            }
            if (obj2 instanceof long[]) {
                return Arrays.equals((long[]) obj2, (long[]) gb.f13368b);
            }
            if (obj2 instanceof float[]) {
                return Arrays.equals((float[]) obj2, (float[]) gb.f13368b);
            }
            if (obj2 instanceof double[]) {
                return Arrays.equals((double[]) obj2, (double[]) gb.f13368b);
            }
            if (obj2 instanceof boolean[]) {
                return Arrays.equals((boolean[]) obj2, (boolean[]) gb.f13368b);
            }
            return Arrays.deepEquals((Object[]) obj2, (Object[]) gb.f13368b);
        }
        List<Hb> list2 = this.f13369c;
        if (list2 != null && (list = gb.f13369c) != null) {
            return list2.equals(list);
        }
        try {
            return Arrays.equals(b(), gb.b());
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

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T a(zzyd<?, T> zzydVar) {
        if (this.f13368b != null) {
            if (!this.f13367a.equals(zzydVar)) {
                throw new IllegalStateException("Tried to getExtension with a different Extension.");
            }
        } else {
            this.f13367a = zzydVar;
            this.f13368b = zzydVar.zzai(this.f13369c);
            this.f13369c = null;
        }
        return (T) this.f13368b;
    }

    public final int a() {
        Object obj = this.f13368b;
        if (obj != null) {
            zzyd<?, ?> zzydVar = this.f13367a;
            if (zzydVar.zzcev) {
                int length = Array.getLength(obj);
                int i = 0;
                for (int i2 = 0; i2 < length; i2++) {
                    Object obj2 = Array.get(obj, i2);
                    if (obj2 != null) {
                        i += zzydVar.zzao(obj2);
                    }
                }
                return i;
            }
            return zzydVar.zzao(obj);
        }
        int i3 = 0;
        for (Hb hb : this.f13369c) {
            i3 += zzya.zzbl(hb.f13370a) + 0 + hb.f13371b.length;
        }
        return i3;
    }

    public final void a(zzya zzyaVar) throws IOException {
        Object obj = this.f13368b;
        if (obj != null) {
            zzyd<?, ?> zzydVar = this.f13367a;
            if (zzydVar.zzcev) {
                int length = Array.getLength(obj);
                for (int i = 0; i < length; i++) {
                    Object obj2 = Array.get(obj, i);
                    if (obj2 != null) {
                        zzydVar.zza(obj2, zzyaVar);
                    }
                }
                return;
            }
            zzydVar.zza(obj, zzyaVar);
            return;
        }
        for (Hb hb : this.f13369c) {
            zzyaVar.zzcd(hb.f13370a);
            zzyaVar.zzp(hb.f13371b);
        }
    }
}
