package com.google.android.gms.internal.firebase_auth;

import android.support.v7.widget.ActivityChooserView;
import java.io.IOException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class r implements InterfaceC1255ia {

    /* renamed from: a, reason: collision with root package name */
    private final zzet f13074a;

    /* renamed from: b, reason: collision with root package name */
    private int f13075b;

    /* renamed from: c, reason: collision with root package name */
    private int f13076c;

    /* renamed from: d, reason: collision with root package name */
    private int f13077d = 0;

    private r(zzet zzetVar) {
        zzfv.zza(zzetVar, "input");
        this.f13074a = zzetVar;
        this.f13074a.zzta = this;
    }

    public static r a(zzet zzetVar) {
        r rVar = zzetVar.zzta;
        return rVar != null ? rVar : new r(zzetVar);
    }

    private final <T> T d(InterfaceC1263ma<T> interfaceC1263ma, zzfg zzfgVar) throws IOException {
        int i = this.f13076c;
        this.f13076c = ((this.f13075b >>> 3) << 3) | 4;
        try {
            T newInstance = interfaceC1263ma.newInstance();
            interfaceC1263ma.a(newInstance, this, zzfgVar);
            interfaceC1263ma.zzf(newInstance);
            if (this.f13075b == this.f13076c) {
                return newInstance;
            }
            throw zzgc.zzhx();
        } finally {
            this.f13076c = i;
        }
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final <T> T b(InterfaceC1263ma<T> interfaceC1263ma, zzfg zzfgVar) throws IOException {
        c(3);
        return (T) d(interfaceC1263ma, zzfgVar);
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final int c() throws IOException {
        int i = this.f13077d;
        if (i != 0) {
            this.f13075b = i;
            this.f13077d = 0;
        } else {
            this.f13075b = this.f13074a.zzfi();
        }
        int i2 = this.f13075b;
        return (i2 == 0 || i2 == this.f13076c) ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : i2 >>> 3;
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final boolean e() throws IOException {
        int i;
        if (this.f13074a.zzfy() || (i = this.f13075b) == this.f13076c) {
            return false;
        }
        return this.f13074a.zzo(i);
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final long f() throws IOException {
        c(0);
        return this.f13074a.zzfj();
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final long g() throws IOException {
        c(0);
        return this.f13074a.zzfk();
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final int getTag() {
        return this.f13075b;
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final int h() throws IOException {
        c(5);
        return this.f13074a.zzfn();
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final boolean i() throws IOException {
        c(0);
        return this.f13074a.zzfo();
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final int j() throws IOException {
        c(0);
        return this.f13074a.zzfl();
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final long k() throws IOException {
        c(1);
        return this.f13074a.zzfm();
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final int l() throws IOException {
        c(0);
        return this.f13074a.zzfs();
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final int m() throws IOException {
        c(5);
        return this.f13074a.zzft();
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final zzeh n() throws IOException {
        c(2);
        return this.f13074a.zzfq();
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final String o() throws IOException {
        c(2);
        return this.f13074a.zzfp();
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final int p() throws IOException {
        c(0);
        return this.f13074a.zzfr();
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final void q(List<Float> list) throws IOException {
        int zzfi;
        int zzfi2;
        if (list instanceof C) {
            C c2 = (C) list;
            int i = this.f13075b & 7;
            if (i != 2) {
                if (i != 5) {
                    throw zzgc.zzhv();
                }
                do {
                    c2.a(this.f13074a.readFloat());
                    if (this.f13074a.zzfy()) {
                        return;
                    } else {
                        zzfi2 = this.f13074a.zzfi();
                    }
                } while (zzfi2 == this.f13075b);
                this.f13077d = zzfi2;
                return;
            }
            int zzfr = this.f13074a.zzfr();
            a(zzfr);
            int zzfz = this.f13074a.zzfz() + zzfr;
            do {
                c2.a(this.f13074a.readFloat());
            } while (this.f13074a.zzfz() < zzfz);
            return;
        }
        int i2 = this.f13075b & 7;
        if (i2 != 2) {
            if (i2 != 5) {
                throw zzgc.zzhv();
            }
            do {
                list.add(Float.valueOf(this.f13074a.readFloat()));
                if (this.f13074a.zzfy()) {
                    return;
                } else {
                    zzfi = this.f13074a.zzfi();
                }
            } while (zzfi == this.f13075b);
            this.f13077d = zzfi;
            return;
        }
        int zzfr2 = this.f13074a.zzfr();
        a(zzfr2);
        int zzfz2 = this.f13074a.zzfz() + zzfr2;
        do {
            list.add(Float.valueOf(this.f13074a.readFloat()));
        } while (this.f13074a.zzfz() < zzfz2);
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final void r(List<Double> list) throws IOException {
        int zzfi;
        int zzfi2;
        if (list instanceof C1277u) {
            C1277u c1277u = (C1277u) list;
            int i = this.f13075b & 7;
            if (i != 1) {
                if (i == 2) {
                    int zzfr = this.f13074a.zzfr();
                    d(zzfr);
                    int zzfz = this.f13074a.zzfz() + zzfr;
                    do {
                        c1277u.b(this.f13074a.readDouble());
                    } while (this.f13074a.zzfz() < zzfz);
                    return;
                }
                throw zzgc.zzhv();
            }
            do {
                c1277u.b(this.f13074a.readDouble());
                if (this.f13074a.zzfy()) {
                    return;
                } else {
                    zzfi2 = this.f13074a.zzfi();
                }
            } while (zzfi2 == this.f13075b);
            this.f13077d = zzfi2;
            return;
        }
        int i2 = this.f13075b & 7;
        if (i2 != 1) {
            if (i2 == 2) {
                int zzfr2 = this.f13074a.zzfr();
                d(zzfr2);
                int zzfz2 = this.f13074a.zzfz() + zzfr2;
                do {
                    list.add(Double.valueOf(this.f13074a.readDouble()));
                } while (this.f13074a.zzfz() < zzfz2);
                return;
            }
            throw zzgc.zzhv();
        }
        do {
            list.add(Double.valueOf(this.f13074a.readDouble()));
            if (this.f13074a.zzfy()) {
                return;
            } else {
                zzfi = this.f13074a.zzfi();
            }
        } while (zzfi == this.f13075b);
        this.f13077d = zzfi;
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final double readDouble() throws IOException {
        c(1);
        return this.f13074a.readDouble();
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final float readFloat() throws IOException {
        c(5);
        return this.f13074a.readFloat();
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final String readString() throws IOException {
        c(2);
        return this.f13074a.readString();
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final void zzf(List<Long> list) throws IOException {
        int zzfi;
        int zzfi2;
        if (list instanceof N) {
            N n = (N) list;
            int i = this.f13075b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzfz = this.f13074a.zzfz() + this.f13074a.zzfr();
                    do {
                        n.a(this.f13074a.zzfj());
                    } while (this.f13074a.zzfz() < zzfz);
                    b(zzfz);
                    return;
                }
                throw zzgc.zzhv();
            }
            do {
                n.a(this.f13074a.zzfj());
                if (this.f13074a.zzfy()) {
                    return;
                } else {
                    zzfi2 = this.f13074a.zzfi();
                }
            } while (zzfi2 == this.f13075b);
            this.f13077d = zzfi2;
            return;
        }
        int i2 = this.f13075b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzfz2 = this.f13074a.zzfz() + this.f13074a.zzfr();
                do {
                    list.add(Long.valueOf(this.f13074a.zzfj()));
                } while (this.f13074a.zzfz() < zzfz2);
                b(zzfz2);
                return;
            }
            throw zzgc.zzhv();
        }
        do {
            list.add(Long.valueOf(this.f13074a.zzfj()));
            if (this.f13074a.zzfy()) {
                return;
            } else {
                zzfi = this.f13074a.zzfi();
            }
        } while (zzfi == this.f13075b);
        this.f13077d = zzfi;
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final void zzh(List<Integer> list) throws IOException {
        int zzfi;
        int zzfi2;
        if (list instanceof F) {
            F f2 = (F) list;
            int i = this.f13075b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzfz = this.f13074a.zzfz() + this.f13074a.zzfr();
                    do {
                        f2.zzas(this.f13074a.zzfl());
                    } while (this.f13074a.zzfz() < zzfz);
                    b(zzfz);
                    return;
                }
                throw zzgc.zzhv();
            }
            do {
                f2.zzas(this.f13074a.zzfl());
                if (this.f13074a.zzfy()) {
                    return;
                } else {
                    zzfi2 = this.f13074a.zzfi();
                }
            } while (zzfi2 == this.f13075b);
            this.f13077d = zzfi2;
            return;
        }
        int i2 = this.f13075b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzfz2 = this.f13074a.zzfz() + this.f13074a.zzfr();
                do {
                    list.add(Integer.valueOf(this.f13074a.zzfl()));
                } while (this.f13074a.zzfz() < zzfz2);
                b(zzfz2);
                return;
            }
            throw zzgc.zzhv();
        }
        do {
            list.add(Integer.valueOf(this.f13074a.zzfl()));
            if (this.f13074a.zzfy()) {
                return;
            } else {
                zzfi = this.f13074a.zzfi();
            }
        } while (zzfi == this.f13075b);
        this.f13077d = zzfi;
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final <T> T a(InterfaceC1263ma<T> interfaceC1263ma, zzfg zzfgVar) throws IOException {
        c(2);
        return (T) c(interfaceC1263ma, zzfgVar);
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final long b() throws IOException {
        c(1);
        return this.f13074a.zzfu();
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final void e(List<String> list) throws IOException {
        a(list, false);
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final void f(List<Integer> list) throws IOException {
        int zzfi;
        int zzfi2;
        if (list instanceof F) {
            F f2 = (F) list;
            int i = this.f13075b & 7;
            if (i != 2) {
                if (i != 5) {
                    throw zzgc.zzhv();
                }
                do {
                    f2.zzas(this.f13074a.zzfn());
                    if (this.f13074a.zzfy()) {
                        return;
                    } else {
                        zzfi2 = this.f13074a.zzfi();
                    }
                } while (zzfi2 == this.f13075b);
                this.f13077d = zzfi2;
                return;
            }
            int zzfr = this.f13074a.zzfr();
            a(zzfr);
            int zzfz = this.f13074a.zzfz() + zzfr;
            do {
                f2.zzas(this.f13074a.zzfn());
            } while (this.f13074a.zzfz() < zzfz);
            return;
        }
        int i2 = this.f13075b & 7;
        if (i2 != 2) {
            if (i2 != 5) {
                throw zzgc.zzhv();
            }
            do {
                list.add(Integer.valueOf(this.f13074a.zzfn()));
                if (this.f13074a.zzfy()) {
                    return;
                } else {
                    zzfi = this.f13074a.zzfi();
                }
            } while (zzfi == this.f13075b);
            this.f13077d = zzfi;
            return;
        }
        int zzfr2 = this.f13074a.zzfr();
        a(zzfr2);
        int zzfz2 = this.f13074a.zzfz() + zzfr2;
        do {
            list.add(Integer.valueOf(this.f13074a.zzfn()));
        } while (this.f13074a.zzfz() < zzfz2);
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final void g(List<Long> list) throws IOException {
        int zzfi;
        int zzfi2;
        if (list instanceof N) {
            N n = (N) list;
            int i = this.f13075b & 7;
            if (i != 1) {
                if (i == 2) {
                    int zzfr = this.f13074a.zzfr();
                    d(zzfr);
                    int zzfz = this.f13074a.zzfz() + zzfr;
                    do {
                        n.a(this.f13074a.zzfm());
                    } while (this.f13074a.zzfz() < zzfz);
                    return;
                }
                throw zzgc.zzhv();
            }
            do {
                n.a(this.f13074a.zzfm());
                if (this.f13074a.zzfy()) {
                    return;
                } else {
                    zzfi2 = this.f13074a.zzfi();
                }
            } while (zzfi2 == this.f13075b);
            this.f13077d = zzfi2;
            return;
        }
        int i2 = this.f13075b & 7;
        if (i2 != 1) {
            if (i2 == 2) {
                int zzfr2 = this.f13074a.zzfr();
                d(zzfr2);
                int zzfz2 = this.f13074a.zzfz() + zzfr2;
                do {
                    list.add(Long.valueOf(this.f13074a.zzfm()));
                } while (this.f13074a.zzfz() < zzfz2);
                return;
            }
            throw zzgc.zzhv();
        }
        do {
            list.add(Long.valueOf(this.f13074a.zzfm()));
            if (this.f13074a.zzfy()) {
                return;
            } else {
                zzfi = this.f13074a.zzfi();
            }
        } while (zzfi == this.f13075b);
        this.f13077d = zzfi;
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final void k(List<Integer> list) throws IOException {
        int zzfi;
        int zzfi2;
        if (list instanceof F) {
            F f2 = (F) list;
            int i = this.f13075b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzfz = this.f13074a.zzfz() + this.f13074a.zzfr();
                    do {
                        f2.zzas(this.f13074a.zzfs());
                    } while (this.f13074a.zzfz() < zzfz);
                    b(zzfz);
                    return;
                }
                throw zzgc.zzhv();
            }
            do {
                f2.zzas(this.f13074a.zzfs());
                if (this.f13074a.zzfy()) {
                    return;
                } else {
                    zzfi2 = this.f13074a.zzfi();
                }
            } while (zzfi2 == this.f13075b);
            this.f13077d = zzfi2;
            return;
        }
        int i2 = this.f13075b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzfz2 = this.f13074a.zzfz() + this.f13074a.zzfr();
                do {
                    list.add(Integer.valueOf(this.f13074a.zzfs()));
                } while (this.f13074a.zzfz() < zzfz2);
                b(zzfz2);
                return;
            }
            throw zzgc.zzhv();
        }
        do {
            list.add(Integer.valueOf(this.f13074a.zzfs()));
            if (this.f13074a.zzfy()) {
                return;
            } else {
                zzfi = this.f13074a.zzfi();
            }
        } while (zzfi == this.f13075b);
        this.f13077d = zzfi;
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final void l(List<String> list) throws IOException {
        a(list, true);
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final void m(List<Boolean> list) throws IOException {
        int zzfi;
        int zzfi2;
        if (list instanceof C1248f) {
            C1248f c1248f = (C1248f) list;
            int i = this.f13075b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzfz = this.f13074a.zzfz() + this.f13074a.zzfr();
                    do {
                        c1248f.a(this.f13074a.zzfo());
                    } while (this.f13074a.zzfz() < zzfz);
                    b(zzfz);
                    return;
                }
                throw zzgc.zzhv();
            }
            do {
                c1248f.a(this.f13074a.zzfo());
                if (this.f13074a.zzfy()) {
                    return;
                } else {
                    zzfi2 = this.f13074a.zzfi();
                }
            } while (zzfi2 == this.f13075b);
            this.f13077d = zzfi2;
            return;
        }
        int i2 = this.f13075b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzfz2 = this.f13074a.zzfz() + this.f13074a.zzfr();
                do {
                    list.add(Boolean.valueOf(this.f13074a.zzfo()));
                } while (this.f13074a.zzfz() < zzfz2);
                b(zzfz2);
                return;
            }
            throw zzgc.zzhv();
        }
        do {
            list.add(Boolean.valueOf(this.f13074a.zzfo()));
            if (this.f13074a.zzfy()) {
                return;
            } else {
                zzfi = this.f13074a.zzfi();
            }
        } while (zzfi == this.f13075b);
        this.f13077d = zzfi;
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final void n(List<Integer> list) throws IOException {
        int zzfi;
        int zzfi2;
        if (list instanceof F) {
            F f2 = (F) list;
            int i = this.f13075b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzfz = this.f13074a.zzfz() + this.f13074a.zzfr();
                    do {
                        f2.zzas(this.f13074a.zzfr());
                    } while (this.f13074a.zzfz() < zzfz);
                    b(zzfz);
                    return;
                }
                throw zzgc.zzhv();
            }
            do {
                f2.zzas(this.f13074a.zzfr());
                if (this.f13074a.zzfy()) {
                    return;
                } else {
                    zzfi2 = this.f13074a.zzfi();
                }
            } while (zzfi2 == this.f13075b);
            this.f13077d = zzfi2;
            return;
        }
        int i2 = this.f13075b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzfz2 = this.f13074a.zzfz() + this.f13074a.zzfr();
                do {
                    list.add(Integer.valueOf(this.f13074a.zzfr()));
                } while (this.f13074a.zzfz() < zzfz2);
                b(zzfz2);
                return;
            }
            throw zzgc.zzhv();
        }
        do {
            list.add(Integer.valueOf(this.f13074a.zzfr()));
            if (this.f13074a.zzfy()) {
                return;
            } else {
                zzfi = this.f13074a.zzfi();
            }
        } while (zzfi == this.f13075b);
        this.f13077d = zzfi;
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final void o(List<zzeh> list) throws IOException {
        int zzfi;
        if ((this.f13075b & 7) != 2) {
            throw zzgc.zzhv();
        }
        do {
            list.add(n());
            if (this.f13074a.zzfy()) {
                return;
            } else {
                zzfi = this.f13074a.zzfi();
            }
        } while (zzfi == this.f13075b);
        this.f13077d = zzfi;
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final void p(List<Long> list) throws IOException {
        int zzfi;
        int zzfi2;
        if (list instanceof N) {
            N n = (N) list;
            int i = this.f13075b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzfz = this.f13074a.zzfz() + this.f13074a.zzfr();
                    do {
                        n.a(this.f13074a.zzfk());
                    } while (this.f13074a.zzfz() < zzfz);
                    b(zzfz);
                    return;
                }
                throw zzgc.zzhv();
            }
            do {
                n.a(this.f13074a.zzfk());
                if (this.f13074a.zzfy()) {
                    return;
                } else {
                    zzfi2 = this.f13074a.zzfi();
                }
            } while (zzfi2 == this.f13075b);
            this.f13077d = zzfi2;
            return;
        }
        int i2 = this.f13075b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzfz2 = this.f13074a.zzfz() + this.f13074a.zzfr();
                do {
                    list.add(Long.valueOf(this.f13074a.zzfk()));
                } while (this.f13074a.zzfz() < zzfz2);
                b(zzfz2);
                return;
            }
            throw zzgc.zzhv();
        }
        do {
            list.add(Long.valueOf(this.f13074a.zzfk()));
            if (this.f13074a.zzfy()) {
                return;
            } else {
                zzfi = this.f13074a.zzfi();
            }
        } while (zzfi == this.f13075b);
        this.f13077d = zzfi;
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final long a() throws IOException {
        c(0);
        return this.f13074a.zzfw();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final <T> void b(List<T> list, InterfaceC1263ma<T> interfaceC1263ma, zzfg zzfgVar) throws IOException {
        int zzfi;
        int i = this.f13075b;
        if ((i & 7) != 2) {
            throw zzgc.zzhv();
        }
        do {
            list.add(c(interfaceC1263ma, zzfgVar));
            if (this.f13074a.zzfy() || this.f13077d != 0) {
                return;
            } else {
                zzfi = this.f13074a.zzfi();
            }
        } while (zzfi == i);
        this.f13077d = zzfi;
    }

    private final void c(int i) throws IOException {
        if ((this.f13075b & 7) != i) {
            throw zzgc.zzhv();
        }
    }

    private final void a(List<String> list, boolean z) throws IOException {
        int zzfi;
        int zzfi2;
        if ((this.f13075b & 7) == 2) {
            if ((list instanceof zzgl) && !z) {
                zzgl zzglVar = (zzgl) list;
                do {
                    zzglVar.zzc(n());
                    if (this.f13074a.zzfy()) {
                        return;
                    } else {
                        zzfi2 = this.f13074a.zzfi();
                    }
                } while (zzfi2 == this.f13075b);
                this.f13077d = zzfi2;
                return;
            }
            do {
                list.add(z ? o() : readString());
                if (this.f13074a.zzfy()) {
                    return;
                } else {
                    zzfi = this.f13074a.zzfi();
                }
            } while (zzfi == this.f13075b);
            this.f13077d = zzfi;
            return;
        }
        throw zzgc.zzhv();
    }

    private final <T> T c(InterfaceC1263ma<T> interfaceC1263ma, zzfg zzfgVar) throws IOException {
        int zzfr = this.f13074a.zzfr();
        zzet zzetVar = this.f13074a;
        if (zzetVar.zzsx < zzetVar.zzsy) {
            int zzp = zzetVar.zzp(zzfr);
            T newInstance = interfaceC1263ma.newInstance();
            this.f13074a.zzsx++;
            interfaceC1263ma.a(newInstance, this, zzfgVar);
            interfaceC1263ma.zzf(newInstance);
            this.f13074a.zzn(0);
            r5.zzsx--;
            this.f13074a.zzq(zzp);
            return newInstance;
        }
        throw new zzgc("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final void b(List<Integer> list) throws IOException {
        int zzfi;
        int zzfi2;
        if (list instanceof F) {
            F f2 = (F) list;
            int i = this.f13075b & 7;
            if (i != 2) {
                if (i != 5) {
                    throw zzgc.zzhv();
                }
                do {
                    f2.zzas(this.f13074a.zzft());
                    if (this.f13074a.zzfy()) {
                        return;
                    } else {
                        zzfi2 = this.f13074a.zzfi();
                    }
                } while (zzfi2 == this.f13075b);
                this.f13077d = zzfi2;
                return;
            }
            int zzfr = this.f13074a.zzfr();
            a(zzfr);
            int zzfz = this.f13074a.zzfz() + zzfr;
            do {
                f2.zzas(this.f13074a.zzft());
            } while (this.f13074a.zzfz() < zzfz);
            return;
        }
        int i2 = this.f13075b & 7;
        if (i2 != 2) {
            if (i2 != 5) {
                throw zzgc.zzhv();
            }
            do {
                list.add(Integer.valueOf(this.f13074a.zzft()));
                if (this.f13074a.zzfy()) {
                    return;
                } else {
                    zzfi = this.f13074a.zzfi();
                }
            } while (zzfi == this.f13075b);
            this.f13077d = zzfi;
            return;
        }
        int zzfr2 = this.f13074a.zzfr();
        a(zzfr2);
        int zzfz2 = this.f13074a.zzfz() + zzfr2;
        do {
            list.add(Integer.valueOf(this.f13074a.zzft()));
        } while (this.f13074a.zzfz() < zzfz2);
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final int d() throws IOException {
        c(0);
        return this.f13074a.zzfv();
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final void d(List<Long> list) throws IOException {
        int zzfi;
        int zzfi2;
        if (list instanceof N) {
            N n = (N) list;
            int i = this.f13075b & 7;
            if (i != 1) {
                if (i == 2) {
                    int zzfr = this.f13074a.zzfr();
                    d(zzfr);
                    int zzfz = this.f13074a.zzfz() + zzfr;
                    do {
                        n.a(this.f13074a.zzfu());
                    } while (this.f13074a.zzfz() < zzfz);
                    return;
                }
                throw zzgc.zzhv();
            }
            do {
                n.a(this.f13074a.zzfu());
                if (this.f13074a.zzfy()) {
                    return;
                } else {
                    zzfi2 = this.f13074a.zzfi();
                }
            } while (zzfi2 == this.f13075b);
            this.f13077d = zzfi2;
            return;
        }
        int i2 = this.f13075b & 7;
        if (i2 != 1) {
            if (i2 == 2) {
                int zzfr2 = this.f13074a.zzfr();
                d(zzfr2);
                int zzfz2 = this.f13074a.zzfz() + zzfr2;
                do {
                    list.add(Long.valueOf(this.f13074a.zzfu()));
                } while (this.f13074a.zzfz() < zzfz2);
                return;
            }
            throw zzgc.zzhv();
        }
        do {
            list.add(Long.valueOf(this.f13074a.zzfu()));
            if (this.f13074a.zzfy()) {
                return;
            } else {
                zzfi = this.f13074a.zzfi();
            }
        } while (zzfi == this.f13075b);
        this.f13077d = zzfi;
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final void c(List<Integer> list) throws IOException {
        int zzfi;
        int zzfi2;
        if (list instanceof F) {
            F f2 = (F) list;
            int i = this.f13075b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzfz = this.f13074a.zzfz() + this.f13074a.zzfr();
                    do {
                        f2.zzas(this.f13074a.zzfv());
                    } while (this.f13074a.zzfz() < zzfz);
                    b(zzfz);
                    return;
                }
                throw zzgc.zzhv();
            }
            do {
                f2.zzas(this.f13074a.zzfv());
                if (this.f13074a.zzfy()) {
                    return;
                } else {
                    zzfi2 = this.f13074a.zzfi();
                }
            } while (zzfi2 == this.f13075b);
            this.f13077d = zzfi2;
            return;
        }
        int i2 = this.f13075b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzfz2 = this.f13074a.zzfz() + this.f13074a.zzfr();
                do {
                    list.add(Integer.valueOf(this.f13074a.zzfv()));
                } while (this.f13074a.zzfz() < zzfz2);
                b(zzfz2);
                return;
            }
            throw zzgc.zzhv();
        }
        do {
            list.add(Integer.valueOf(this.f13074a.zzfv()));
            if (this.f13074a.zzfy()) {
                return;
            } else {
                zzfi = this.f13074a.zzfi();
            }
        } while (zzfi == this.f13075b);
        this.f13077d = zzfi;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final <T> void a(List<T> list, InterfaceC1263ma<T> interfaceC1263ma, zzfg zzfgVar) throws IOException {
        int zzfi;
        int i = this.f13075b;
        if ((i & 7) != 3) {
            throw zzgc.zzhv();
        }
        do {
            list.add(d(interfaceC1263ma, zzfgVar));
            if (this.f13074a.zzfy() || this.f13077d != 0) {
                return;
            } else {
                zzfi = this.f13074a.zzfi();
            }
        } while (zzfi == i);
        this.f13077d = zzfi;
    }

    @Override // com.google.android.gms.internal.firebase_auth.InterfaceC1255ia
    public final void a(List<Long> list) throws IOException {
        int zzfi;
        int zzfi2;
        if (list instanceof N) {
            N n = (N) list;
            int i = this.f13075b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzfz = this.f13074a.zzfz() + this.f13074a.zzfr();
                    do {
                        n.a(this.f13074a.zzfw());
                    } while (this.f13074a.zzfz() < zzfz);
                    b(zzfz);
                    return;
                }
                throw zzgc.zzhv();
            }
            do {
                n.a(this.f13074a.zzfw());
                if (this.f13074a.zzfy()) {
                    return;
                } else {
                    zzfi2 = this.f13074a.zzfi();
                }
            } while (zzfi2 == this.f13075b);
            this.f13077d = zzfi2;
            return;
        }
        int i2 = this.f13075b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzfz2 = this.f13074a.zzfz() + this.f13074a.zzfr();
                do {
                    list.add(Long.valueOf(this.f13074a.zzfw()));
                } while (this.f13074a.zzfz() < zzfz2);
                b(zzfz2);
                return;
            }
            throw zzgc.zzhv();
        }
        do {
            list.add(Long.valueOf(this.f13074a.zzfw()));
            if (this.f13074a.zzfy()) {
                return;
            } else {
                zzfi = this.f13074a.zzfi();
            }
        } while (zzfi == this.f13075b);
        this.f13077d = zzfi;
    }

    private final void b(int i) throws IOException {
        if (this.f13074a.zzfz() != i) {
            throw zzgc.zzhq();
        }
    }

    private static void d(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzgc.zzhx();
        }
    }

    private static void a(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzgc.zzhx();
        }
    }
}
