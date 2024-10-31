package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class Db implements Cloneable {

    /* renamed from: a */
    private zzur<?, ?> f13139a;

    /* renamed from: b */
    private Object f13140b;

    /* renamed from: c */
    private List<Eb> f13141c = new ArrayList();

    private final byte[] b() throws IOException {
        byte[] bArr = new byte[a()];
        a(zzuo.zzl(bArr));
        return bArr;
    }

    /* renamed from: c */
    public final Db clone() {
        Db db = new Db();
        try {
            db.f13139a = this.f13139a;
            if (this.f13141c == null) {
                db.f13141c = null;
            } else {
                db.f13141c.addAll(this.f13141c);
            }
            if (this.f13140b != null) {
                if (this.f13140b instanceof zzuw) {
                    db.f13140b = (zzuw) ((zzuw) this.f13140b).clone();
                } else if (this.f13140b instanceof byte[]) {
                    db.f13140b = ((byte[]) this.f13140b).clone();
                } else {
                    int i = 0;
                    if (this.f13140b instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.f13140b;
                        byte[][] bArr2 = new byte[bArr.length];
                        db.f13140b = bArr2;
                        while (i < bArr.length) {
                            bArr2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (this.f13140b instanceof boolean[]) {
                        db.f13140b = ((boolean[]) this.f13140b).clone();
                    } else if (this.f13140b instanceof int[]) {
                        db.f13140b = ((int[]) this.f13140b).clone();
                    } else if (this.f13140b instanceof long[]) {
                        db.f13140b = ((long[]) this.f13140b).clone();
                    } else if (this.f13140b instanceof float[]) {
                        db.f13140b = ((float[]) this.f13140b).clone();
                    } else if (this.f13140b instanceof double[]) {
                        db.f13140b = ((double[]) this.f13140b).clone();
                    } else if (this.f13140b instanceof zzuw[]) {
                        zzuw[] zzuwVarArr = (zzuw[]) this.f13140b;
                        zzuw[] zzuwVarArr2 = new zzuw[zzuwVarArr.length];
                        db.f13140b = zzuwVarArr2;
                        while (i < zzuwVarArr.length) {
                            zzuwVarArr2[i] = (zzuw) zzuwVarArr[i].clone();
                            i++;
                        }
                    }
                }
            }
            return db;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public final void a(Eb eb) throws IOException {
        Object zzag;
        Object obj;
        List<Eb> list = this.f13141c;
        if (list != null) {
            list.add(eb);
            return;
        }
        Object obj2 = this.f13140b;
        if (obj2 instanceof zzuw) {
            byte[] bArr = eb.f13144b;
            zzun zzj = zzun.zzj(bArr, 0, bArr.length);
            int zzoa = zzj.zzoa();
            if (zzoa == bArr.length - zzuo.zzbc(zzoa)) {
                zzag = ((zzuw) this.f13140b).zza(zzj);
            } else {
                throw zzuv.zzsa();
            }
        } else {
            if (obj2 instanceof zzuw[]) {
                zzuw[] zzuwVarArr = (zzuw[]) this.f13139a.zzag(Collections.singletonList(eb));
                zzuw[] zzuwVarArr2 = (zzuw[]) this.f13140b;
                obj = (zzuw[]) Arrays.copyOf(zzuwVarArr2, zzuwVarArr2.length + zzuwVarArr.length);
                System.arraycopy(zzuwVarArr, 0, obj, zzuwVarArr2.length, zzuwVarArr.length);
            } else if (obj2 instanceof zzsk) {
                zzag = ((zzsk) this.f13140b).zzpg().zza((zzsk) this.f13139a.zzag(Collections.singletonList(eb))).zzpm();
            } else if (obj2 instanceof zzsk[]) {
                zzsk[] zzskVarArr = (zzsk[]) this.f13139a.zzag(Collections.singletonList(eb));
                zzsk[] zzskVarArr2 = (zzsk[]) this.f13140b;
                obj = (zzsk[]) Arrays.copyOf(zzskVarArr2, zzskVarArr2.length + zzskVarArr.length);
                System.arraycopy(zzskVarArr, 0, obj, zzskVarArr2.length, zzskVarArr.length);
            } else {
                zzag = this.f13139a.zzag(Collections.singletonList(eb));
            }
            zzag = obj;
        }
        this.f13139a = this.f13139a;
        this.f13140b = zzag;
        this.f13141c = null;
    }

    public final boolean equals(Object obj) {
        List<Eb> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Db)) {
            return false;
        }
        Db db = (Db) obj;
        if (this.f13140b != null && db.f13140b != null) {
            zzur<?, ?> zzurVar = this.f13139a;
            if (zzurVar != db.f13139a) {
                return false;
            }
            if (!zzurVar.zzbhc.isArray()) {
                return this.f13140b.equals(db.f13140b);
            }
            Object obj2 = this.f13140b;
            if (obj2 instanceof byte[]) {
                return Arrays.equals((byte[]) obj2, (byte[]) db.f13140b);
            }
            if (obj2 instanceof int[]) {
                return Arrays.equals((int[]) obj2, (int[]) db.f13140b);
            }
            if (obj2 instanceof long[]) {
                return Arrays.equals((long[]) obj2, (long[]) db.f13140b);
            }
            if (obj2 instanceof float[]) {
                return Arrays.equals((float[]) obj2, (float[]) db.f13140b);
            }
            if (obj2 instanceof double[]) {
                return Arrays.equals((double[]) obj2, (double[]) db.f13140b);
            }
            if (obj2 instanceof boolean[]) {
                return Arrays.equals((boolean[]) obj2, (boolean[]) db.f13140b);
            }
            return Arrays.deepEquals((Object[]) obj2, (Object[]) db.f13140b);
        }
        List<Eb> list2 = this.f13141c;
        if (list2 != null && (list = db.f13141c) != null) {
            return list2.equals(list);
        }
        try {
            return Arrays.equals(b(), db.b());
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
    public final <T> T a(zzur<?, T> zzurVar) {
        if (this.f13140b != null) {
            if (!this.f13139a.equals(zzurVar)) {
                throw new IllegalStateException("Tried to getExtension with a different Extension.");
            }
        } else {
            this.f13139a = zzurVar;
            this.f13140b = zzurVar.zzag(this.f13141c);
            this.f13141c = null;
        }
        return (T) this.f13140b;
    }

    public final int a() {
        Object obj = this.f13140b;
        if (obj != null) {
            zzur<?, ?> zzurVar = this.f13139a;
            if (zzurVar.zzbhd) {
                int length = Array.getLength(obj);
                int i = 0;
                for (int i2 = 0; i2 < length; i2++) {
                    Object obj2 = Array.get(obj, i2);
                    if (obj2 != null) {
                        i += zzurVar.zzaj(obj2);
                    }
                }
                return i;
            }
            return zzurVar.zzaj(obj);
        }
        int i3 = 0;
        for (Eb eb : this.f13141c) {
            i3 += zzuo.zzbj(eb.f13143a) + 0 + eb.f13144b.length;
        }
        return i3;
    }

    public final void a(zzuo zzuoVar) throws IOException {
        Object obj = this.f13140b;
        if (obj != null) {
            zzur<?, ?> zzurVar = this.f13139a;
            if (zzurVar.zzbhd) {
                int length = Array.getLength(obj);
                for (int i = 0; i < length; i++) {
                    Object obj2 = Array.get(obj, i);
                    if (obj2 != null) {
                        zzurVar.zza(obj2, zzuoVar);
                    }
                }
                return;
            }
            zzurVar.zza(obj, zzuoVar);
            return;
        }
        for (Eb eb : this.f13141c) {
            zzuoVar.zzcb(eb.f13143a);
            zzuoVar.zzm(eb.f13144b);
        }
    }
}
