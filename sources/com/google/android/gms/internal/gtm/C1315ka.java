package com.google.android.gms.internal.gtm;

import android.support.v7.widget.ActivityChooserView;
import java.io.IOException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.gtm.ka, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1315ka implements Za {

    /* renamed from: a, reason: collision with root package name */
    private final zzqe f13254a;

    /* renamed from: b, reason: collision with root package name */
    private int f13255b;

    /* renamed from: c, reason: collision with root package name */
    private int f13256c;

    /* renamed from: d, reason: collision with root package name */
    private int f13257d = 0;

    private C1315ka(zzqe zzqeVar) {
        zzre.zza(zzqeVar, "input");
        this.f13254a = zzqeVar;
        this.f13254a.zzawi = this;
    }

    public static C1315ka a(zzqe zzqeVar) {
        C1315ka c1315ka = zzqeVar.zzawi;
        return c1315ka != null ? c1315ka : new C1315ka(zzqeVar);
    }

    @Override // com.google.android.gms.internal.gtm.Za
    public final int b() throws IOException {
        a(5);
        return this.f13254a.zznn();
    }

    @Override // com.google.android.gms.internal.gtm.Za
    public final int c() throws IOException {
        a(0);
        return this.f13254a.zznl();
    }

    @Override // com.google.android.gms.internal.gtm.Za
    public final long d() throws IOException {
        a(1);
        return this.f13254a.zznm();
    }

    @Override // com.google.android.gms.internal.gtm.Za
    public final long e() throws IOException {
        a(0);
        return this.f13254a.zznk();
    }

    @Override // com.google.android.gms.internal.gtm.Za
    public final int f() throws IOException {
        a(0);
        return this.f13254a.zzns();
    }

    @Override // com.google.android.gms.internal.gtm.Za
    public final int g() throws IOException {
        a(0);
        return this.f13254a.zznr();
    }

    @Override // com.google.android.gms.internal.gtm.Za
    public final int getTag() {
        return this.f13255b;
    }

    @Override // com.google.android.gms.internal.gtm.Za
    public final zzps h() throws IOException {
        a(2);
        return this.f13254a.zznq();
    }

    @Override // com.google.android.gms.internal.gtm.Za
    public final String i() throws IOException {
        a(2);
        return this.f13254a.zznp();
    }

    @Override // com.google.android.gms.internal.gtm.Za
    public final long j() throws IOException {
        a(0);
        return this.f13254a.zznw();
    }

    @Override // com.google.android.gms.internal.gtm.Za
    public final boolean k() throws IOException {
        int i;
        if (this.f13254a.zzny() || (i = this.f13255b) == this.f13256c) {
            return false;
        }
        return this.f13254a.zzao(i);
    }

    @Override // com.google.android.gms.internal.gtm.Za
    public final int l() throws IOException {
        a(0);
        return this.f13254a.zznv();
    }

    @Override // com.google.android.gms.internal.gtm.Za
    public final int m() throws IOException {
        int i = this.f13257d;
        if (i != 0) {
            this.f13255b = i;
            this.f13257d = 0;
        } else {
            this.f13255b = this.f13254a.zzni();
        }
        int i2 = this.f13255b;
        return (i2 == 0 || i2 == this.f13256c) ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : i2 >>> 3;
    }

    @Override // com.google.android.gms.internal.gtm.Za
    public final long n() throws IOException {
        a(1);
        return this.f13254a.zznu();
    }

    @Override // com.google.android.gms.internal.gtm.Za
    public final int o() throws IOException {
        a(5);
        return this.f13254a.zznt();
    }

    @Override // com.google.android.gms.internal.gtm.Za
    public final long p() throws IOException {
        a(0);
        return this.f13254a.zznj();
    }

    @Override // com.google.android.gms.internal.gtm.Za
    public final double readDouble() throws IOException {
        a(1);
        return this.f13254a.readDouble();
    }

    @Override // com.google.android.gms.internal.gtm.Za
    public final float readFloat() throws IOException {
        a(5);
        return this.f13254a.readFloat();
    }

    @Override // com.google.android.gms.internal.gtm.Za
    public final String readString() throws IOException {
        a(2);
        return this.f13254a.readString();
    }

    @Override // com.google.android.gms.internal.gtm.Za
    public final void zzh(List<Float> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof C1336va) {
            C1336va c1336va = (C1336va) list;
            int i = this.f13255b & 7;
            if (i != 2) {
                if (i != 5) {
                    throw zzrk.zzpt();
                }
                do {
                    c1336va.a(this.f13254a.readFloat());
                    if (this.f13254a.zzny()) {
                        return;
                    } else {
                        zzni2 = this.f13254a.zzni();
                    }
                } while (zzni2 == this.f13255b);
                this.f13257d = zzni2;
                return;
            }
            int zznr = this.f13254a.zznr();
            c(zznr);
            int zznz = this.f13254a.zznz() + zznr;
            do {
                c1336va.a(this.f13254a.readFloat());
            } while (this.f13254a.zznz() < zznz);
            return;
        }
        int i2 = this.f13255b & 7;
        if (i2 != 2) {
            if (i2 != 5) {
                throw zzrk.zzpt();
            }
            do {
                list.add(Float.valueOf(this.f13254a.readFloat()));
                if (this.f13254a.zzny()) {
                    return;
                } else {
                    zzni = this.f13254a.zzni();
                }
            } while (zzni == this.f13255b);
            this.f13257d = zzni;
            return;
        }
        int zznr2 = this.f13254a.zznr();
        c(zznr2);
        int zznz2 = this.f13254a.zznz() + zznr2;
        do {
            list.add(Float.valueOf(this.f13254a.readFloat()));
        } while (this.f13254a.zznz() < zznz2);
    }

    private final void a(int i) throws IOException {
        if ((this.f13255b & 7) != i) {
            throw zzrk.zzpt();
        }
    }

    private final <T> T c(_a<T> _aVar, zzqp zzqpVar) throws IOException {
        int zznr = this.f13254a.zznr();
        zzqe zzqeVar = this.f13254a;
        if (zzqeVar.zzawf < zzqeVar.zzawg) {
            int zzaq = zzqeVar.zzaq(zznr);
            T newInstance = _aVar.newInstance();
            this.f13254a.zzawf++;
            _aVar.a(newInstance, this, zzqpVar);
            _aVar.e(newInstance);
            this.f13254a.zzan(0);
            r5.zzawf--;
            this.f13254a.zzar(zzaq);
            return newInstance;
        }
        throw zzrk.zzpu();
    }

    private final <T> T d(_a<T> _aVar, zzqp zzqpVar) throws IOException {
        int i = this.f13256c;
        this.f13256c = ((this.f13255b >>> 3) << 3) | 4;
        try {
            T newInstance = _aVar.newInstance();
            _aVar.a(newInstance, this, zzqpVar);
            _aVar.e(newInstance);
            if (this.f13255b == this.f13256c) {
                return newInstance;
            }
            throw zzrk.zzpv();
        } finally {
            this.f13256c = i;
        }
    }

    @Override // com.google.android.gms.internal.gtm.Za
    public final <T> T b(_a<T> _aVar, zzqp zzqpVar) throws IOException {
        a(2);
        return (T) c(_aVar, zzqpVar);
    }

    @Override // com.google.android.gms.internal.gtm.Za
    public final void e(List<String> list) throws IOException {
        a(list, false);
    }

    @Override // com.google.android.gms.internal.gtm.Za
    public final void f(List<Long> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof Ga) {
            Ga ga = (Ga) list;
            int i = this.f13255b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zznz = this.f13254a.zznz() + this.f13254a.zznr();
                    do {
                        ga.a(this.f13254a.zznk());
                    } while (this.f13254a.zznz() < zznz);
                    d(zznz);
                    return;
                }
                throw zzrk.zzpt();
            }
            do {
                ga.a(this.f13254a.zznk());
                if (this.f13254a.zzny()) {
                    return;
                } else {
                    zzni2 = this.f13254a.zzni();
                }
            } while (zzni2 == this.f13255b);
            this.f13257d = zzni2;
            return;
        }
        int i2 = this.f13255b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zznz2 = this.f13254a.zznz() + this.f13254a.zznr();
                do {
                    list.add(Long.valueOf(this.f13254a.zznk()));
                } while (this.f13254a.zznz() < zznz2);
                d(zznz2);
                return;
            }
            throw zzrk.zzpt();
        }
        do {
            list.add(Long.valueOf(this.f13254a.zznk()));
            if (this.f13254a.zzny()) {
                return;
            } else {
                zzni = this.f13254a.zzni();
            }
        } while (zzni == this.f13255b);
        this.f13257d = zzni;
    }

    @Override // com.google.android.gms.internal.gtm.Za
    public final void g(List<Long> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof Ga) {
            Ga ga = (Ga) list;
            int i = this.f13255b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zznz = this.f13254a.zznz() + this.f13254a.zznr();
                    do {
                        ga.a(this.f13254a.zznj());
                    } while (this.f13254a.zznz() < zznz);
                    d(zznz);
                    return;
                }
                throw zzrk.zzpt();
            }
            do {
                ga.a(this.f13254a.zznj());
                if (this.f13254a.zzny()) {
                    return;
                } else {
                    zzni2 = this.f13254a.zzni();
                }
            } while (zzni2 == this.f13255b);
            this.f13257d = zzni2;
            return;
        }
        int i2 = this.f13255b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zznz2 = this.f13254a.zznz() + this.f13254a.zznr();
                do {
                    list.add(Long.valueOf(this.f13254a.zznj()));
                } while (this.f13254a.zznz() < zznz2);
                d(zznz2);
                return;
            }
            throw zzrk.zzpt();
        }
        do {
            list.add(Long.valueOf(this.f13254a.zznj()));
            if (this.f13254a.zzny()) {
                return;
            } else {
                zzni = this.f13254a.zzni();
            }
        } while (zzni == this.f13255b);
        this.f13257d = zzni;
    }

    @Override // com.google.android.gms.internal.gtm.Za
    public final void h(List<Long> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof Ga) {
            Ga ga = (Ga) list;
            int i = this.f13255b & 7;
            if (i != 1) {
                if (i == 2) {
                    int zznr = this.f13254a.zznr();
                    b(zznr);
                    int zznz = this.f13254a.zznz() + zznr;
                    do {
                        ga.a(this.f13254a.zznu());
                    } while (this.f13254a.zznz() < zznz);
                    return;
                }
                throw zzrk.zzpt();
            }
            do {
                ga.a(this.f13254a.zznu());
                if (this.f13254a.zzny()) {
                    return;
                } else {
                    zzni2 = this.f13254a.zzni();
                }
            } while (zzni2 == this.f13255b);
            this.f13257d = zzni2;
            return;
        }
        int i2 = this.f13255b & 7;
        if (i2 != 1) {
            if (i2 == 2) {
                int zznr2 = this.f13254a.zznr();
                b(zznr2);
                int zznz2 = this.f13254a.zznz() + zznr2;
                do {
                    list.add(Long.valueOf(this.f13254a.zznu()));
                } while (this.f13254a.zznz() < zznz2);
                return;
            }
            throw zzrk.zzpt();
        }
        do {
            list.add(Long.valueOf(this.f13254a.zznu()));
            if (this.f13254a.zzny()) {
                return;
            } else {
                zzni = this.f13254a.zzni();
            }
        } while (zzni == this.f13255b);
        this.f13257d = zzni;
    }

    @Override // com.google.android.gms.internal.gtm.Za
    public final void i(List<Long> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof Ga) {
            Ga ga = (Ga) list;
            int i = this.f13255b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zznz = this.f13254a.zznz() + this.f13254a.zznr();
                    do {
                        ga.a(this.f13254a.zznw());
                    } while (this.f13254a.zznz() < zznz);
                    d(zznz);
                    return;
                }
                throw zzrk.zzpt();
            }
            do {
                ga.a(this.f13254a.zznw());
                if (this.f13254a.zzny()) {
                    return;
                } else {
                    zzni2 = this.f13254a.zzni();
                }
            } while (zzni2 == this.f13255b);
            this.f13257d = zzni2;
            return;
        }
        int i2 = this.f13255b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zznz2 = this.f13254a.zznz() + this.f13254a.zznr();
                do {
                    list.add(Long.valueOf(this.f13254a.zznw()));
                } while (this.f13254a.zznz() < zznz2);
                d(zznz2);
                return;
            }
            throw zzrk.zzpt();
        }
        do {
            list.add(Long.valueOf(this.f13254a.zznw()));
            if (this.f13254a.zzny()) {
                return;
            } else {
                zzni = this.f13254a.zzni();
            }
        } while (zzni == this.f13255b);
        this.f13257d = zzni;
    }

    @Override // com.google.android.gms.internal.gtm.Za
    public final void j(List<Integer> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof C1342ya) {
            C1342ya c1342ya = (C1342ya) list;
            int i = this.f13255b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zznz = this.f13254a.zznz() + this.f13254a.zznr();
                    do {
                        c1342ya.a(this.f13254a.zznv());
                    } while (this.f13254a.zznz() < zznz);
                    d(zznz);
                    return;
                }
                throw zzrk.zzpt();
            }
            do {
                c1342ya.a(this.f13254a.zznv());
                if (this.f13254a.zzny()) {
                    return;
                } else {
                    zzni2 = this.f13254a.zzni();
                }
            } while (zzni2 == this.f13255b);
            this.f13257d = zzni2;
            return;
        }
        int i2 = this.f13255b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zznz2 = this.f13254a.zznz() + this.f13254a.zznr();
                do {
                    list.add(Integer.valueOf(this.f13254a.zznv()));
                } while (this.f13254a.zznz() < zznz2);
                d(zznz2);
                return;
            }
            throw zzrk.zzpt();
        }
        do {
            list.add(Integer.valueOf(this.f13254a.zznv()));
            if (this.f13254a.zzny()) {
                return;
            } else {
                zzni = this.f13254a.zzni();
            }
        } while (zzni == this.f13255b);
        this.f13257d = zzni;
    }

    @Override // com.google.android.gms.internal.gtm.Za
    public final void k(List<String> list) throws IOException {
        a(list, true);
    }

    @Override // com.google.android.gms.internal.gtm.Za
    public final void l(List<Long> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof Ga) {
            Ga ga = (Ga) list;
            int i = this.f13255b & 7;
            if (i != 1) {
                if (i == 2) {
                    int zznr = this.f13254a.zznr();
                    b(zznr);
                    int zznz = this.f13254a.zznz() + zznr;
                    do {
                        ga.a(this.f13254a.zznm());
                    } while (this.f13254a.zznz() < zznz);
                    return;
                }
                throw zzrk.zzpt();
            }
            do {
                ga.a(this.f13254a.zznm());
                if (this.f13254a.zzny()) {
                    return;
                } else {
                    zzni2 = this.f13254a.zzni();
                }
            } while (zzni2 == this.f13255b);
            this.f13257d = zzni2;
            return;
        }
        int i2 = this.f13255b & 7;
        if (i2 != 1) {
            if (i2 == 2) {
                int zznr2 = this.f13254a.zznr();
                b(zznr2);
                int zznz2 = this.f13254a.zznz() + zznr2;
                do {
                    list.add(Long.valueOf(this.f13254a.zznm()));
                } while (this.f13254a.zznz() < zznz2);
                return;
            }
            throw zzrk.zzpt();
        }
        do {
            list.add(Long.valueOf(this.f13254a.zznm()));
            if (this.f13254a.zzny()) {
                return;
            } else {
                zzni = this.f13254a.zzni();
            }
        } while (zzni == this.f13255b);
        this.f13257d = zzni;
    }

    @Override // com.google.android.gms.internal.gtm.Za
    public final void n(List<Boolean> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof C1290aa) {
            C1290aa c1290aa = (C1290aa) list;
            int i = this.f13255b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zznz = this.f13254a.zznz() + this.f13254a.zznr();
                    do {
                        c1290aa.a(this.f13254a.zzno());
                    } while (this.f13254a.zznz() < zznz);
                    d(zznz);
                    return;
                }
                throw zzrk.zzpt();
            }
            do {
                c1290aa.a(this.f13254a.zzno());
                if (this.f13254a.zzny()) {
                    return;
                } else {
                    zzni2 = this.f13254a.zzni();
                }
            } while (zzni2 == this.f13255b);
            this.f13257d = zzni2;
            return;
        }
        int i2 = this.f13255b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zznz2 = this.f13254a.zznz() + this.f13254a.zznr();
                do {
                    list.add(Boolean.valueOf(this.f13254a.zzno()));
                } while (this.f13254a.zznz() < zznz2);
                d(zznz2);
                return;
            }
            throw zzrk.zzpt();
        }
        do {
            list.add(Boolean.valueOf(this.f13254a.zzno()));
            if (this.f13254a.zzny()) {
                return;
            } else {
                zzni = this.f13254a.zzni();
            }
        } while (zzni == this.f13255b);
        this.f13257d = zzni;
    }

    @Override // com.google.android.gms.internal.gtm.Za
    public final void o(List<Integer> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof C1342ya) {
            C1342ya c1342ya = (C1342ya) list;
            int i = this.f13255b & 7;
            if (i != 2) {
                if (i != 5) {
                    throw zzrk.zzpt();
                }
                do {
                    c1342ya.a(this.f13254a.zznn());
                    if (this.f13254a.zzny()) {
                        return;
                    } else {
                        zzni2 = this.f13254a.zzni();
                    }
                } while (zzni2 == this.f13255b);
                this.f13257d = zzni2;
                return;
            }
            int zznr = this.f13254a.zznr();
            c(zznr);
            int zznz = this.f13254a.zznz() + zznr;
            do {
                c1342ya.a(this.f13254a.zznn());
            } while (this.f13254a.zznz() < zznz);
            return;
        }
        int i2 = this.f13255b & 7;
        if (i2 != 2) {
            if (i2 != 5) {
                throw zzrk.zzpt();
            }
            do {
                list.add(Integer.valueOf(this.f13254a.zznn()));
                if (this.f13254a.zzny()) {
                    return;
                } else {
                    zzni = this.f13254a.zzni();
                }
            } while (zzni == this.f13255b);
            this.f13257d = zzni;
            return;
        }
        int zznr2 = this.f13254a.zznr();
        c(zznr2);
        int zznz2 = this.f13254a.zznz() + zznr2;
        do {
            list.add(Integer.valueOf(this.f13254a.zznn()));
        } while (this.f13254a.zznz() < zznz2);
    }

    @Override // com.google.android.gms.internal.gtm.Za
    public final void p(List<Double> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof C1321na) {
            C1321na c1321na = (C1321na) list;
            int i = this.f13255b & 7;
            if (i != 1) {
                if (i == 2) {
                    int zznr = this.f13254a.zznr();
                    b(zznr);
                    int zznz = this.f13254a.zznz() + zznr;
                    do {
                        c1321na.b(this.f13254a.readDouble());
                    } while (this.f13254a.zznz() < zznz);
                    return;
                }
                throw zzrk.zzpt();
            }
            do {
                c1321na.b(this.f13254a.readDouble());
                if (this.f13254a.zzny()) {
                    return;
                } else {
                    zzni2 = this.f13254a.zzni();
                }
            } while (zzni2 == this.f13255b);
            this.f13257d = zzni2;
            return;
        }
        int i2 = this.f13255b & 7;
        if (i2 != 1) {
            if (i2 == 2) {
                int zznr2 = this.f13254a.zznr();
                b(zznr2);
                int zznz2 = this.f13254a.zznz() + zznr2;
                do {
                    list.add(Double.valueOf(this.f13254a.readDouble()));
                } while (this.f13254a.zznz() < zznz2);
                return;
            }
            throw zzrk.zzpt();
        }
        do {
            list.add(Double.valueOf(this.f13254a.readDouble()));
            if (this.f13254a.zzny()) {
                return;
            } else {
                zzni = this.f13254a.zzni();
            }
        } while (zzni == this.f13255b);
        this.f13257d = zzni;
    }

    @Override // com.google.android.gms.internal.gtm.Za
    public final boolean a() throws IOException {
        a(0);
        return this.f13254a.zzno();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.gtm.Za
    public final <T> void b(List<T> list, _a<T> _aVar, zzqp zzqpVar) throws IOException {
        int zzni;
        int i = this.f13255b;
        if ((i & 7) != 3) {
            throw zzrk.zzpt();
        }
        do {
            list.add(d(_aVar, zzqpVar));
            if (this.f13254a.zzny() || this.f13257d != 0) {
                return;
            } else {
                zzni = this.f13254a.zzni();
            }
        } while (zzni == i);
        this.f13257d = zzni;
    }

    @Override // com.google.android.gms.internal.gtm.Za
    public final void m(List<Integer> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof C1342ya) {
            C1342ya c1342ya = (C1342ya) list;
            int i = this.f13255b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zznz = this.f13254a.zznz() + this.f13254a.zznr();
                    do {
                        c1342ya.a(this.f13254a.zznl());
                    } while (this.f13254a.zznz() < zznz);
                    d(zznz);
                    return;
                }
                throw zzrk.zzpt();
            }
            do {
                c1342ya.a(this.f13254a.zznl());
                if (this.f13254a.zzny()) {
                    return;
                } else {
                    zzni2 = this.f13254a.zzni();
                }
            } while (zzni2 == this.f13255b);
            this.f13257d = zzni2;
            return;
        }
        int i2 = this.f13255b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zznz2 = this.f13254a.zznz() + this.f13254a.zznr();
                do {
                    list.add(Integer.valueOf(this.f13254a.zznl()));
                } while (this.f13254a.zznz() < zznz2);
                d(zznz2);
                return;
            }
            throw zzrk.zzpt();
        }
        do {
            list.add(Integer.valueOf(this.f13254a.zznl()));
            if (this.f13254a.zzny()) {
                return;
            } else {
                zzni = this.f13254a.zzni();
            }
        } while (zzni == this.f13255b);
        this.f13257d = zzni;
    }

    @Override // com.google.android.gms.internal.gtm.Za
    public final <T> T a(_a<T> _aVar, zzqp zzqpVar) throws IOException {
        a(3);
        return (T) d(_aVar, zzqpVar);
    }

    private final void a(List<String> list, boolean z) throws IOException {
        int zzni;
        int zzni2;
        if ((this.f13255b & 7) == 2) {
            if ((list instanceof zzrt) && !z) {
                zzrt zzrtVar = (zzrt) list;
                do {
                    zzrtVar.zzc(h());
                    if (this.f13254a.zzny()) {
                        return;
                    } else {
                        zzni2 = this.f13254a.zzni();
                    }
                } while (zzni2 == this.f13255b);
                this.f13257d = zzni2;
                return;
            }
            do {
                list.add(z ? i() : readString());
                if (this.f13254a.zzny()) {
                    return;
                } else {
                    zzni = this.f13254a.zzni();
                }
            } while (zzni == this.f13255b);
            this.f13257d = zzni;
            return;
        }
        throw zzrk.zzpt();
    }

    @Override // com.google.android.gms.internal.gtm.Za
    public final void b(List<zzps> list) throws IOException {
        int zzni;
        if ((this.f13255b & 7) != 2) {
            throw zzrk.zzpt();
        }
        do {
            list.add(h());
            if (this.f13254a.zzny()) {
                return;
            } else {
                zzni = this.f13254a.zzni();
            }
        } while (zzni == this.f13255b);
        this.f13257d = zzni;
    }

    @Override // com.google.android.gms.internal.gtm.Za
    public final void d(List<Integer> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof C1342ya) {
            C1342ya c1342ya = (C1342ya) list;
            int i = this.f13255b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zznz = this.f13254a.zznz() + this.f13254a.zznr();
                    do {
                        c1342ya.a(this.f13254a.zznr());
                    } while (this.f13254a.zznz() < zznz);
                    d(zznz);
                    return;
                }
                throw zzrk.zzpt();
            }
            do {
                c1342ya.a(this.f13254a.zznr());
                if (this.f13254a.zzny()) {
                    return;
                } else {
                    zzni2 = this.f13254a.zzni();
                }
            } while (zzni2 == this.f13255b);
            this.f13257d = zzni2;
            return;
        }
        int i2 = this.f13255b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zznz2 = this.f13254a.zznz() + this.f13254a.zznr();
                do {
                    list.add(Integer.valueOf(this.f13254a.zznr()));
                } while (this.f13254a.zznz() < zznz2);
                d(zznz2);
                return;
            }
            throw zzrk.zzpt();
        }
        do {
            list.add(Integer.valueOf(this.f13254a.zznr()));
            if (this.f13254a.zzny()) {
                return;
            } else {
                zzni = this.f13254a.zzni();
            }
        } while (zzni == this.f13255b);
        this.f13257d = zzni;
    }

    @Override // com.google.android.gms.internal.gtm.Za
    public final void c(List<Integer> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof C1342ya) {
            C1342ya c1342ya = (C1342ya) list;
            int i = this.f13255b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zznz = this.f13254a.zznz() + this.f13254a.zznr();
                    do {
                        c1342ya.a(this.f13254a.zzns());
                    } while (this.f13254a.zznz() < zznz);
                    d(zznz);
                    return;
                }
                throw zzrk.zzpt();
            }
            do {
                c1342ya.a(this.f13254a.zzns());
                if (this.f13254a.zzny()) {
                    return;
                } else {
                    zzni2 = this.f13254a.zzni();
                }
            } while (zzni2 == this.f13255b);
            this.f13257d = zzni2;
            return;
        }
        int i2 = this.f13255b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zznz2 = this.f13254a.zznz() + this.f13254a.zznr();
                do {
                    list.add(Integer.valueOf(this.f13254a.zzns()));
                } while (this.f13254a.zznz() < zznz2);
                d(zznz2);
                return;
            }
            throw zzrk.zzpt();
        }
        do {
            list.add(Integer.valueOf(this.f13254a.zzns()));
            if (this.f13254a.zzny()) {
                return;
            } else {
                zzni = this.f13254a.zzni();
            }
        } while (zzni == this.f13255b);
        this.f13257d = zzni;
    }

    private static void b(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzrk.zzpv();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.gtm.Za
    public final <T> void a(List<T> list, _a<T> _aVar, zzqp zzqpVar) throws IOException {
        int zzni;
        int i = this.f13255b;
        if ((i & 7) != 2) {
            throw zzrk.zzpt();
        }
        do {
            list.add(c(_aVar, zzqpVar));
            if (this.f13254a.zzny() || this.f13257d != 0) {
                return;
            } else {
                zzni = this.f13254a.zzni();
            }
        } while (zzni == i);
        this.f13257d = zzni;
    }

    @Override // com.google.android.gms.internal.gtm.Za
    public final void a(List<Integer> list) throws IOException {
        int zzni;
        int zzni2;
        if (list instanceof C1342ya) {
            C1342ya c1342ya = (C1342ya) list;
            int i = this.f13255b & 7;
            if (i != 2) {
                if (i != 5) {
                    throw zzrk.zzpt();
                }
                do {
                    c1342ya.a(this.f13254a.zznt());
                    if (this.f13254a.zzny()) {
                        return;
                    } else {
                        zzni2 = this.f13254a.zzni();
                    }
                } while (zzni2 == this.f13255b);
                this.f13257d = zzni2;
                return;
            }
            int zznr = this.f13254a.zznr();
            c(zznr);
            int zznz = this.f13254a.zznz() + zznr;
            do {
                c1342ya.a(this.f13254a.zznt());
            } while (this.f13254a.zznz() < zznz);
            return;
        }
        int i2 = this.f13255b & 7;
        if (i2 != 2) {
            if (i2 != 5) {
                throw zzrk.zzpt();
            }
            do {
                list.add(Integer.valueOf(this.f13254a.zznt()));
                if (this.f13254a.zzny()) {
                    return;
                } else {
                    zzni = this.f13254a.zzni();
                }
            } while (zzni == this.f13255b);
            this.f13257d = zzni;
            return;
        }
        int zznr2 = this.f13254a.zznr();
        c(zznr2);
        int zznz2 = this.f13254a.zznz() + zznr2;
        do {
            list.add(Integer.valueOf(this.f13254a.zznt()));
        } while (this.f13254a.zznz() < zznz2);
    }

    private final void d(int i) throws IOException {
        if (this.f13254a.zznz() != i) {
            throw zzrk.zzpp();
        }
    }

    private static void c(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzrk.zzpv();
        }
    }
}
