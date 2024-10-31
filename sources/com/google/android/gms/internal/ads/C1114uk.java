package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Stack;

/* renamed from: com.google.android.gms.internal.ads.uk */
/* loaded from: classes2.dex */
public final class C1114uk implements InterfaceC1156xk {

    /* renamed from: a */
    private final byte[] f12585a = new byte[8];

    /* renamed from: b */
    private final Stack<C1142wk> f12586b = new Stack<>();

    /* renamed from: c */
    private final Dk f12587c = new Dk();

    /* renamed from: d */
    private InterfaceC1170yk f12588d;

    /* renamed from: e */
    private int f12589e;

    /* renamed from: f */
    private int f12590f;

    /* renamed from: g */
    private long f12591g;

    @Override // com.google.android.gms.internal.ads.InterfaceC1156xk
    public final void a(InterfaceC1170yk interfaceC1170yk) {
        this.f12588d = interfaceC1170yk;
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1156xk
    public final void reset() {
        this.f12589e = 0;
        this.f12586b.clear();
        this.f12587c.a();
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1156xk
    public final boolean a(zzia zziaVar) throws IOException, InterruptedException {
        String str;
        double longBitsToDouble;
        int a2;
        int a3;
        long j;
        int i;
        zzpo.checkState(this.f12588d != null);
        while (true) {
            if (!this.f12586b.isEmpty()) {
                long position = zziaVar.getPosition();
                j = this.f12586b.peek().f12636b;
                if (position >= j) {
                    InterfaceC1170yk interfaceC1170yk = this.f12588d;
                    i = this.f12586b.pop().f12635a;
                    interfaceC1170yk.b(i);
                    return true;
                }
            }
            if (this.f12589e == 0) {
                long a4 = this.f12587c.a(zziaVar, true, false, 4);
                if (a4 == -2) {
                    zziaVar.zzdx();
                    while (true) {
                        zziaVar.zza(this.f12585a, 0, 4);
                        a2 = Dk.a(this.f12585a[0]);
                        if (a2 != -1 && a2 <= 4) {
                            a3 = (int) Dk.a(this.f12585a, a2, false);
                            if (this.f12588d.c(a3)) {
                                break;
                            }
                        }
                        zziaVar.zzw(1);
                    }
                    zziaVar.zzw(a2);
                    a4 = a3;
                }
                if (a4 == -1) {
                    return false;
                }
                this.f12590f = (int) a4;
                this.f12589e = 1;
            }
            if (this.f12589e == 1) {
                this.f12591g = this.f12587c.a(zziaVar, false, true, 8);
                this.f12589e = 2;
            }
            int a5 = this.f12588d.a(this.f12590f);
            if (a5 != 0) {
                if (a5 == 1) {
                    long position2 = zziaVar.getPosition();
                    this.f12586b.add(new C1142wk(this.f12590f, this.f12591g + position2));
                    this.f12588d.a(this.f12590f, position2, this.f12591g);
                    this.f12589e = 0;
                    return true;
                }
                if (a5 == 2) {
                    long j2 = this.f12591g;
                    if (j2 <= 8) {
                        this.f12588d.a(this.f12590f, a(zziaVar, (int) j2));
                        this.f12589e = 0;
                        return true;
                    }
                    StringBuilder sb = new StringBuilder(42);
                    sb.append("Invalid integer size: ");
                    sb.append(j2);
                    throw new zzfx(sb.toString());
                }
                if (a5 == 3) {
                    long j3 = this.f12591g;
                    if (j3 <= 2147483647L) {
                        InterfaceC1170yk interfaceC1170yk2 = this.f12588d;
                        int i2 = this.f12590f;
                        int i3 = (int) j3;
                        if (i3 == 0) {
                            str = "";
                        } else {
                            byte[] bArr = new byte[i3];
                            zziaVar.readFully(bArr, 0, i3);
                            str = new String(bArr);
                        }
                        interfaceC1170yk2.a(i2, str);
                        this.f12589e = 0;
                        return true;
                    }
                    StringBuilder sb2 = new StringBuilder(41);
                    sb2.append("String element size: ");
                    sb2.append(j3);
                    throw new zzfx(sb2.toString());
                }
                if (a5 == 4) {
                    this.f12588d.a(this.f12590f, (int) this.f12591g, zziaVar);
                    this.f12589e = 0;
                    return true;
                }
                if (a5 == 5) {
                    long j4 = this.f12591g;
                    if (j4 != 4 && j4 != 8) {
                        StringBuilder sb3 = new StringBuilder(40);
                        sb3.append("Invalid float size: ");
                        sb3.append(j4);
                        throw new zzfx(sb3.toString());
                    }
                    InterfaceC1170yk interfaceC1170yk3 = this.f12588d;
                    int i4 = this.f12590f;
                    int i5 = (int) this.f12591g;
                    long a6 = a(zziaVar, i5);
                    if (i5 == 4) {
                        longBitsToDouble = Float.intBitsToFloat((int) a6);
                    } else {
                        longBitsToDouble = Double.longBitsToDouble(a6);
                    }
                    interfaceC1170yk3.a(i4, longBitsToDouble);
                    this.f12589e = 0;
                    return true;
                }
                StringBuilder sb4 = new StringBuilder(32);
                sb4.append("Invalid element type ");
                sb4.append(a5);
                throw new zzfx(sb4.toString());
            }
            zziaVar.zzw((int) this.f12591g);
            this.f12589e = 0;
        }
    }

    private final long a(zzia zziaVar, int i) throws IOException, InterruptedException {
        zziaVar.readFully(this.f12585a, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | (this.f12585a[i2] & 255);
        }
        return j;
    }
}
