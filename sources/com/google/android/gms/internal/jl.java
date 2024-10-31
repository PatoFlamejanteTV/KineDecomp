package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class jl implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private zzrz<?, ?> f1652a;
    private Object b;
    private List<jm> c = new ArrayList();

    private byte[] c() throws IOException {
        byte[] bArr = new byte[a()];
        a(zzrx.zzC(bArr));
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        int i = 0;
        if (this.b != null) {
            return this.f1652a.zzX(this.b);
        }
        Iterator<jm> it = this.c.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = it.next().a() + i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> T a(zzrz<?, T> zzrzVar) {
        if (this.b == null) {
            this.f1652a = zzrzVar;
            this.b = zzrzVar.zzE(this.c);
            this.c = null;
        } else if (this.f1652a != zzrzVar) {
            throw new IllegalStateException("Tried to getExtension with a differernt Extension.");
        }
        return (T) this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(jm jmVar) {
        this.c.add(jmVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(zzrx zzrxVar) throws IOException {
        if (this.b != null) {
            this.f1652a.zza(this.b, zzrxVar);
            return;
        }
        Iterator<jm> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().a(zzrxVar);
        }
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final jl clone() {
        jl jlVar = new jl();
        try {
            jlVar.f1652a = this.f1652a;
            if (this.c == null) {
                jlVar.c = null;
            } else {
                jlVar.c.addAll(this.c);
            }
            if (this.b != null) {
                if (this.b instanceof zzse) {
                    jlVar.b = ((zzse) this.b).clone();
                } else if (this.b instanceof byte[]) {
                    jlVar.b = ((byte[]) this.b).clone();
                } else if (this.b instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.b;
                    byte[][] bArr2 = new byte[bArr.length];
                    jlVar.b = bArr2;
                    for (int i = 0; i < bArr.length; i++) {
                        bArr2[i] = (byte[]) bArr[i].clone();
                    }
                } else if (this.b instanceof boolean[]) {
                    jlVar.b = ((boolean[]) this.b).clone();
                } else if (this.b instanceof int[]) {
                    jlVar.b = ((int[]) this.b).clone();
                } else if (this.b instanceof long[]) {
                    jlVar.b = ((long[]) this.b).clone();
                } else if (this.b instanceof float[]) {
                    jlVar.b = ((float[]) this.b).clone();
                } else if (this.b instanceof double[]) {
                    jlVar.b = ((double[]) this.b).clone();
                } else if (this.b instanceof zzse[]) {
                    zzse[] zzseVarArr = (zzse[]) this.b;
                    zzse[] zzseVarArr2 = new zzse[zzseVarArr.length];
                    jlVar.b = zzseVarArr2;
                    for (int i2 = 0; i2 < zzseVarArr.length; i2++) {
                        zzseVarArr2[i2] = zzseVarArr[i2].clone();
                    }
                }
            }
            return jlVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof jl)) {
            return false;
        }
        jl jlVar = (jl) obj;
        if (this.b != null && jlVar.b != null) {
            if (this.f1652a == jlVar.f1652a) {
                return !this.f1652a.zzbil.isArray() ? this.b.equals(jlVar.b) : this.b instanceof byte[] ? Arrays.equals((byte[]) this.b, (byte[]) jlVar.b) : this.b instanceof int[] ? Arrays.equals((int[]) this.b, (int[]) jlVar.b) : this.b instanceof long[] ? Arrays.equals((long[]) this.b, (long[]) jlVar.b) : this.b instanceof float[] ? Arrays.equals((float[]) this.b, (float[]) jlVar.b) : this.b instanceof double[] ? Arrays.equals((double[]) this.b, (double[]) jlVar.b) : this.b instanceof boolean[] ? Arrays.equals((boolean[]) this.b, (boolean[]) jlVar.b) : Arrays.deepEquals((Object[]) this.b, (Object[]) jlVar.b);
            }
            return false;
        }
        if (this.c != null && jlVar.c != null) {
            return this.c.equals(jlVar.c);
        }
        try {
            return Arrays.equals(c(), jlVar.c());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public int hashCode() {
        try {
            return Arrays.hashCode(c()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
