package com.google.android.gms.internal.measurement;

import android.support.v7.widget.ActivityChooserView;
import java.io.IOException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.measurement.ma, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1378ma implements InterfaceC1350bb {

    /* renamed from: a, reason: collision with root package name */
    private final zztq f13485a;

    /* renamed from: b, reason: collision with root package name */
    private int f13486b;

    /* renamed from: c, reason: collision with root package name */
    private int f13487c;

    /* renamed from: d, reason: collision with root package name */
    private int f13488d = 0;

    private C1378ma(zztq zztqVar) {
        zzuq.zza(zztqVar, "input");
        this.f13485a = zztqVar;
        this.f13485a.zzbub = this;
    }

    public static C1378ma a(zztq zztqVar) {
        C1378ma c1378ma = zztqVar.zzbub;
        return c1378ma != null ? c1378ma : new C1378ma(zztqVar);
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final String b() throws IOException {
        a(2);
        return this.f13485a.zzuq();
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final boolean c() throws IOException {
        a(0);
        return this.f13485a.zzup();
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final long d() throws IOException {
        a(0);
        return this.f13485a.zzuk();
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final int e() throws IOException {
        a(5);
        return this.f13485a.zzuo();
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final long f() throws IOException {
        a(1);
        return this.f13485a.zzun();
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final int g() throws IOException {
        a(0);
        return this.f13485a.zzum();
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final int getTag() {
        return this.f13486b;
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final void h(List<Integer> list) throws IOException {
        int zzuj;
        int zzuj2;
        if (list instanceof Aa) {
            Aa aa = (Aa) list;
            int i = this.f13486b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzva = this.f13485a.zzva() + this.f13485a.zzus();
                    do {
                        aa.a(this.f13485a.zzut());
                    } while (this.f13485a.zzva() < zzva);
                    d(zzva);
                    return;
                }
                throw zzuv.zzwu();
            }
            do {
                aa.a(this.f13485a.zzut());
                if (this.f13485a.zzuz()) {
                    return;
                } else {
                    zzuj2 = this.f13485a.zzuj();
                }
            } while (zzuj2 == this.f13486b);
            this.f13488d = zzuj2;
            return;
        }
        int i2 = this.f13486b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzva2 = this.f13485a.zzva() + this.f13485a.zzus();
                do {
                    list.add(Integer.valueOf(this.f13485a.zzut()));
                } while (this.f13485a.zzva() < zzva2);
                d(zzva2);
                return;
            }
            throw zzuv.zzwu();
        }
        do {
            list.add(Integer.valueOf(this.f13485a.zzut()));
            if (this.f13485a.zzuz()) {
                return;
            } else {
                zzuj = this.f13485a.zzuj();
            }
        } while (zzuj == this.f13486b);
        this.f13488d = zzuj;
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final void i(List<Long> list) throws IOException {
        int zzuj;
        int zzuj2;
        if (list instanceof Ia) {
            Ia ia = (Ia) list;
            int i = this.f13486b & 7;
            if (i != 1) {
                if (i == 2) {
                    int zzus = this.f13485a.zzus();
                    b(zzus);
                    int zzva = this.f13485a.zzva() + zzus;
                    do {
                        ia.a(this.f13485a.zzuv());
                    } while (this.f13485a.zzva() < zzva);
                    return;
                }
                throw zzuv.zzwu();
            }
            do {
                ia.a(this.f13485a.zzuv());
                if (this.f13485a.zzuz()) {
                    return;
                } else {
                    zzuj2 = this.f13485a.zzuj();
                }
            } while (zzuj2 == this.f13486b);
            this.f13488d = zzuj2;
            return;
        }
        int i2 = this.f13486b & 7;
        if (i2 != 1) {
            if (i2 == 2) {
                int zzus2 = this.f13485a.zzus();
                b(zzus2);
                int zzva2 = this.f13485a.zzva() + zzus2;
                do {
                    list.add(Long.valueOf(this.f13485a.zzuv()));
                } while (this.f13485a.zzva() < zzva2);
                return;
            }
            throw zzuv.zzwu();
        }
        do {
            list.add(Long.valueOf(this.f13485a.zzuv()));
            if (this.f13485a.zzuz()) {
                return;
            } else {
                zzuj = this.f13485a.zzuj();
            }
        } while (zzuj == this.f13486b);
        this.f13488d = zzuj;
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final void j(List<Integer> list) throws IOException {
        int zzuj;
        int zzuj2;
        if (list instanceof Aa) {
            Aa aa = (Aa) list;
            int i = this.f13486b & 7;
            if (i != 2) {
                if (i != 5) {
                    throw zzuv.zzwu();
                }
                do {
                    aa.a(this.f13485a.zzuu());
                    if (this.f13485a.zzuz()) {
                        return;
                    } else {
                        zzuj2 = this.f13485a.zzuj();
                    }
                } while (zzuj2 == this.f13486b);
                this.f13488d = zzuj2;
                return;
            }
            int zzus = this.f13485a.zzus();
            c(zzus);
            int zzva = this.f13485a.zzva() + zzus;
            do {
                aa.a(this.f13485a.zzuu());
            } while (this.f13485a.zzva() < zzva);
            return;
        }
        int i2 = this.f13486b & 7;
        if (i2 != 2) {
            if (i2 != 5) {
                throw zzuv.zzwu();
            }
            do {
                list.add(Integer.valueOf(this.f13485a.zzuu()));
                if (this.f13485a.zzuz()) {
                    return;
                } else {
                    zzuj = this.f13485a.zzuj();
                }
            } while (zzuj == this.f13486b);
            this.f13488d = zzuj;
            return;
        }
        int zzus2 = this.f13485a.zzus();
        c(zzus2);
        int zzva2 = this.f13485a.zzva() + zzus2;
        do {
            list.add(Integer.valueOf(this.f13485a.zzuu()));
        } while (this.f13485a.zzva() < zzva2);
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final void k(List<Integer> list) throws IOException {
        int zzuj;
        int zzuj2;
        if (list instanceof Aa) {
            Aa aa = (Aa) list;
            int i = this.f13486b & 7;
            if (i != 2) {
                if (i != 5) {
                    throw zzuv.zzwu();
                }
                do {
                    aa.a(this.f13485a.zzuo());
                    if (this.f13485a.zzuz()) {
                        return;
                    } else {
                        zzuj2 = this.f13485a.zzuj();
                    }
                } while (zzuj2 == this.f13486b);
                this.f13488d = zzuj2;
                return;
            }
            int zzus = this.f13485a.zzus();
            c(zzus);
            int zzva = this.f13485a.zzva() + zzus;
            do {
                aa.a(this.f13485a.zzuo());
            } while (this.f13485a.zzva() < zzva);
            return;
        }
        int i2 = this.f13486b & 7;
        if (i2 != 2) {
            if (i2 != 5) {
                throw zzuv.zzwu();
            }
            do {
                list.add(Integer.valueOf(this.f13485a.zzuo()));
                if (this.f13485a.zzuz()) {
                    return;
                } else {
                    zzuj = this.f13485a.zzuj();
                }
            } while (zzuj == this.f13486b);
            this.f13488d = zzuj;
            return;
        }
        int zzus2 = this.f13485a.zzus();
        c(zzus2);
        int zzva2 = this.f13485a.zzva() + zzus2;
        do {
            list.add(Integer.valueOf(this.f13485a.zzuo()));
        } while (this.f13485a.zzva() < zzva2);
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final void l(List<Long> list) throws IOException {
        int zzuj;
        int zzuj2;
        if (list instanceof Ia) {
            Ia ia = (Ia) list;
            int i = this.f13486b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzva = this.f13485a.zzva() + this.f13485a.zzus();
                    do {
                        ia.a(this.f13485a.zzul());
                    } while (this.f13485a.zzva() < zzva);
                    d(zzva);
                    return;
                }
                throw zzuv.zzwu();
            }
            do {
                ia.a(this.f13485a.zzul());
                if (this.f13485a.zzuz()) {
                    return;
                } else {
                    zzuj2 = this.f13485a.zzuj();
                }
            } while (zzuj2 == this.f13486b);
            this.f13488d = zzuj2;
            return;
        }
        int i2 = this.f13486b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzva2 = this.f13485a.zzva() + this.f13485a.zzus();
                do {
                    list.add(Long.valueOf(this.f13485a.zzul()));
                } while (this.f13485a.zzva() < zzva2);
                d(zzva2);
                return;
            }
            throw zzuv.zzwu();
        }
        do {
            list.add(Long.valueOf(this.f13485a.zzul()));
            if (this.f13485a.zzuz()) {
                return;
            } else {
                zzuj = this.f13485a.zzuj();
            }
        } while (zzuj == this.f13486b);
        this.f13488d = zzuj;
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final void m(List<Long> list) throws IOException {
        int zzuj;
        int zzuj2;
        if (list instanceof Ia) {
            Ia ia = (Ia) list;
            int i = this.f13486b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzva = this.f13485a.zzva() + this.f13485a.zzus();
                    do {
                        ia.a(this.f13485a.zzuk());
                    } while (this.f13485a.zzva() < zzva);
                    d(zzva);
                    return;
                }
                throw zzuv.zzwu();
            }
            do {
                ia.a(this.f13485a.zzuk());
                if (this.f13485a.zzuz()) {
                    return;
                } else {
                    zzuj2 = this.f13485a.zzuj();
                }
            } while (zzuj2 == this.f13486b);
            this.f13488d = zzuj2;
            return;
        }
        int i2 = this.f13486b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzva2 = this.f13485a.zzva() + this.f13485a.zzus();
                do {
                    list.add(Long.valueOf(this.f13485a.zzuk()));
                } while (this.f13485a.zzva() < zzva2);
                d(zzva2);
                return;
            }
            throw zzuv.zzwu();
        }
        do {
            list.add(Long.valueOf(this.f13485a.zzuk()));
            if (this.f13485a.zzuz()) {
                return;
            } else {
                zzuj = this.f13485a.zzuj();
            }
        } while (zzuj == this.f13486b);
        this.f13488d = zzuj;
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final void n(List<Long> list) throws IOException {
        int zzuj;
        int zzuj2;
        if (list instanceof Ia) {
            Ia ia = (Ia) list;
            int i = this.f13486b & 7;
            if (i != 1) {
                if (i == 2) {
                    int zzus = this.f13485a.zzus();
                    b(zzus);
                    int zzva = this.f13485a.zzva() + zzus;
                    do {
                        ia.a(this.f13485a.zzun());
                    } while (this.f13485a.zzva() < zzva);
                    return;
                }
                throw zzuv.zzwu();
            }
            do {
                ia.a(this.f13485a.zzun());
                if (this.f13485a.zzuz()) {
                    return;
                } else {
                    zzuj2 = this.f13485a.zzuj();
                }
            } while (zzuj2 == this.f13486b);
            this.f13488d = zzuj2;
            return;
        }
        int i2 = this.f13486b & 7;
        if (i2 != 1) {
            if (i2 == 2) {
                int zzus2 = this.f13485a.zzus();
                b(zzus2);
                int zzva2 = this.f13485a.zzva() + zzus2;
                do {
                    list.add(Long.valueOf(this.f13485a.zzun()));
                } while (this.f13485a.zzva() < zzva2);
                return;
            }
            throw zzuv.zzwu();
        }
        do {
            list.add(Long.valueOf(this.f13485a.zzun()));
            if (this.f13485a.zzuz()) {
                return;
            } else {
                zzuj = this.f13485a.zzuj();
            }
        } while (zzuj == this.f13486b);
        this.f13488d = zzuj;
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final void o(List<Integer> list) throws IOException {
        int zzuj;
        int zzuj2;
        if (list instanceof Aa) {
            Aa aa = (Aa) list;
            int i = this.f13486b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzva = this.f13485a.zzva() + this.f13485a.zzus();
                    do {
                        aa.a(this.f13485a.zzum());
                    } while (this.f13485a.zzva() < zzva);
                    d(zzva);
                    return;
                }
                throw zzuv.zzwu();
            }
            do {
                aa.a(this.f13485a.zzum());
                if (this.f13485a.zzuz()) {
                    return;
                } else {
                    zzuj2 = this.f13485a.zzuj();
                }
            } while (zzuj2 == this.f13486b);
            this.f13488d = zzuj2;
            return;
        }
        int i2 = this.f13486b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzva2 = this.f13485a.zzva() + this.f13485a.zzus();
                do {
                    list.add(Integer.valueOf(this.f13485a.zzum()));
                } while (this.f13485a.zzva() < zzva2);
                d(zzva2);
                return;
            }
            throw zzuv.zzwu();
        }
        do {
            list.add(Integer.valueOf(this.f13485a.zzum()));
            if (this.f13485a.zzuz()) {
                return;
            } else {
                zzuj = this.f13485a.zzuj();
            }
        } while (zzuj == this.f13486b);
        this.f13488d = zzuj;
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final void p(List<Long> list) throws IOException {
        int zzuj;
        int zzuj2;
        if (list instanceof Ia) {
            Ia ia = (Ia) list;
            int i = this.f13486b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzva = this.f13485a.zzva() + this.f13485a.zzus();
                    do {
                        ia.a(this.f13485a.zzux());
                    } while (this.f13485a.zzva() < zzva);
                    d(zzva);
                    return;
                }
                throw zzuv.zzwu();
            }
            do {
                ia.a(this.f13485a.zzux());
                if (this.f13485a.zzuz()) {
                    return;
                } else {
                    zzuj2 = this.f13485a.zzuj();
                }
            } while (zzuj2 == this.f13486b);
            this.f13488d = zzuj2;
            return;
        }
        int i2 = this.f13486b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzva2 = this.f13485a.zzva() + this.f13485a.zzus();
                do {
                    list.add(Long.valueOf(this.f13485a.zzux()));
                } while (this.f13485a.zzva() < zzva2);
                d(zzva2);
                return;
            }
            throw zzuv.zzwu();
        }
        do {
            list.add(Long.valueOf(this.f13485a.zzux()));
            if (this.f13485a.zzuz()) {
                return;
            } else {
                zzuj = this.f13485a.zzuj();
            }
        } while (zzuj == this.f13486b);
        this.f13488d = zzuj;
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final void q(List<Integer> list) throws IOException {
        int zzuj;
        int zzuj2;
        if (list instanceof Aa) {
            Aa aa = (Aa) list;
            int i = this.f13486b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzva = this.f13485a.zzva() + this.f13485a.zzus();
                    do {
                        aa.a(this.f13485a.zzuw());
                    } while (this.f13485a.zzva() < zzva);
                    d(zzva);
                    return;
                }
                throw zzuv.zzwu();
            }
            do {
                aa.a(this.f13485a.zzuw());
                if (this.f13485a.zzuz()) {
                    return;
                } else {
                    zzuj2 = this.f13485a.zzuj();
                }
            } while (zzuj2 == this.f13486b);
            this.f13488d = zzuj2;
            return;
        }
        int i2 = this.f13486b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzva2 = this.f13485a.zzva() + this.f13485a.zzus();
                do {
                    list.add(Integer.valueOf(this.f13485a.zzuw()));
                } while (this.f13485a.zzva() < zzva2);
                d(zzva2);
                return;
            }
            throw zzuv.zzwu();
        }
        do {
            list.add(Integer.valueOf(this.f13485a.zzuw()));
            if (this.f13485a.zzuz()) {
                return;
            } else {
                zzuj = this.f13485a.zzuj();
            }
        } while (zzuj == this.f13486b);
        this.f13488d = zzuj;
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final double readDouble() throws IOException {
        a(1);
        return this.f13485a.readDouble();
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final float readFloat() throws IOException {
        a(5);
        return this.f13485a.readFloat();
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final String readString() throws IOException {
        a(2);
        return this.f13485a.readString();
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final long zzul() throws IOException {
        a(0);
        return this.f13485a.zzul();
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final zzte zzur() throws IOException {
        a(2);
        return this.f13485a.zzur();
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final int zzut() throws IOException {
        a(0);
        return this.f13485a.zzut();
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final int zzuu() throws IOException {
        a(5);
        return this.f13485a.zzuu();
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final long zzuv() throws IOException {
        a(1);
        return this.f13485a.zzuv();
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final int zzuw() throws IOException {
        a(0);
        return this.f13485a.zzuw();
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final long zzux() throws IOException {
        a(0);
        return this.f13485a.zzux();
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final int zzvh() throws IOException {
        int i = this.f13488d;
        if (i != 0) {
            this.f13486b = i;
            this.f13488d = 0;
        } else {
            this.f13486b = this.f13485a.zzuj();
        }
        int i2 = this.f13486b;
        return (i2 == 0 || i2 == this.f13487c) ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : i2 >>> 3;
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final boolean zzvi() throws IOException {
        int i;
        if (this.f13485a.zzuz() || (i = this.f13486b) == this.f13487c) {
            return false;
        }
        return this.f13485a.zzaq(i);
    }

    private final void a(int i) throws IOException {
        if ((this.f13486b & 7) != i) {
            throw zzuv.zzwu();
        }
    }

    private final <T> T c(InterfaceC1353cb<T> interfaceC1353cb, zzub zzubVar) throws IOException {
        int zzus = this.f13485a.zzus();
        zztq zztqVar = this.f13485a;
        if (zztqVar.zzbty < zztqVar.zzbtz) {
            int zzas = zztqVar.zzas(zzus);
            T newInstance = interfaceC1353cb.newInstance();
            this.f13485a.zzbty++;
            interfaceC1353cb.a(newInstance, this, zzubVar);
            interfaceC1353cb.b(newInstance);
            this.f13485a.zzap(0);
            r5.zzbty--;
            this.f13485a.zzat(zzas);
            return newInstance;
        }
        throw zzuv.zzwv();
    }

    private final <T> T d(InterfaceC1353cb<T> interfaceC1353cb, zzub zzubVar) throws IOException {
        int i = this.f13487c;
        this.f13487c = ((this.f13486b >>> 3) << 3) | 4;
        try {
            T newInstance = interfaceC1353cb.newInstance();
            interfaceC1353cb.a(newInstance, this, zzubVar);
            interfaceC1353cb.b(newInstance);
            if (this.f13486b == this.f13487c) {
                return newInstance;
            }
            throw zzuv.zzww();
        } finally {
            this.f13487c = i;
        }
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final <T> T b(InterfaceC1353cb<T> interfaceC1353cb, zzub zzubVar) throws IOException {
        a(2);
        return (T) c(interfaceC1353cb, zzubVar);
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final void e(List<String> list) throws IOException {
        a(list, false);
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final void f(List<Float> list) throws IOException {
        int zzuj;
        int zzuj2;
        if (list instanceof C1399xa) {
            C1399xa c1399xa = (C1399xa) list;
            int i = this.f13486b & 7;
            if (i != 2) {
                if (i != 5) {
                    throw zzuv.zzwu();
                }
                do {
                    c1399xa.a(this.f13485a.readFloat());
                    if (this.f13485a.zzuz()) {
                        return;
                    } else {
                        zzuj2 = this.f13485a.zzuj();
                    }
                } while (zzuj2 == this.f13486b);
                this.f13488d = zzuj2;
                return;
            }
            int zzus = this.f13485a.zzus();
            c(zzus);
            int zzva = this.f13485a.zzva() + zzus;
            do {
                c1399xa.a(this.f13485a.readFloat());
            } while (this.f13485a.zzva() < zzva);
            return;
        }
        int i2 = this.f13486b & 7;
        if (i2 != 2) {
            if (i2 != 5) {
                throw zzuv.zzwu();
            }
            do {
                list.add(Float.valueOf(this.f13485a.readFloat()));
                if (this.f13485a.zzuz()) {
                    return;
                } else {
                    zzuj = this.f13485a.zzuj();
                }
            } while (zzuj == this.f13486b);
            this.f13488d = zzuj;
            return;
        }
        int zzus2 = this.f13485a.zzus();
        c(zzus2);
        int zzva2 = this.f13485a.zzva() + zzus2;
        do {
            list.add(Float.valueOf(this.f13485a.readFloat()));
        } while (this.f13485a.zzva() < zzva2);
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final void g(List<Double> list) throws IOException {
        int zzuj;
        int zzuj2;
        if (list instanceof C1384pa) {
            C1384pa c1384pa = (C1384pa) list;
            int i = this.f13486b & 7;
            if (i != 1) {
                if (i == 2) {
                    int zzus = this.f13485a.zzus();
                    b(zzus);
                    int zzva = this.f13485a.zzva() + zzus;
                    do {
                        c1384pa.b(this.f13485a.readDouble());
                    } while (this.f13485a.zzva() < zzva);
                    return;
                }
                throw zzuv.zzwu();
            }
            do {
                c1384pa.b(this.f13485a.readDouble());
                if (this.f13485a.zzuz()) {
                    return;
                } else {
                    zzuj2 = this.f13485a.zzuj();
                }
            } while (zzuj2 == this.f13486b);
            this.f13488d = zzuj2;
            return;
        }
        int i2 = this.f13486b & 7;
        if (i2 != 1) {
            if (i2 == 2) {
                int zzus2 = this.f13485a.zzus();
                b(zzus2);
                int zzva2 = this.f13485a.zzva() + zzus2;
                do {
                    list.add(Double.valueOf(this.f13485a.readDouble()));
                } while (this.f13485a.zzva() < zzva2);
                return;
            }
            throw zzuv.zzwu();
        }
        do {
            list.add(Double.valueOf(this.f13485a.readDouble()));
            if (this.f13485a.zzuz()) {
                return;
            } else {
                zzuj = this.f13485a.zzuj();
            }
        } while (zzuj == this.f13486b);
        this.f13488d = zzuj;
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final <T> T a(InterfaceC1353cb<T> interfaceC1353cb, zzub zzubVar) throws IOException {
        a(3);
        return (T) d(interfaceC1353cb, zzubVar);
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final void b(List<Boolean> list) throws IOException {
        int zzuj;
        int zzuj2;
        if (list instanceof C1352ca) {
            C1352ca c1352ca = (C1352ca) list;
            int i = this.f13486b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzva = this.f13485a.zzva() + this.f13485a.zzus();
                    do {
                        c1352ca.a(this.f13485a.zzup());
                    } while (this.f13485a.zzva() < zzva);
                    d(zzva);
                    return;
                }
                throw zzuv.zzwu();
            }
            do {
                c1352ca.a(this.f13485a.zzup());
                if (this.f13485a.zzuz()) {
                    return;
                } else {
                    zzuj2 = this.f13485a.zzuj();
                }
            } while (zzuj2 == this.f13486b);
            this.f13488d = zzuj2;
            return;
        }
        int i2 = this.f13486b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzva2 = this.f13485a.zzva() + this.f13485a.zzus();
                do {
                    list.add(Boolean.valueOf(this.f13485a.zzup()));
                } while (this.f13485a.zzva() < zzva2);
                d(zzva2);
                return;
            }
            throw zzuv.zzwu();
        }
        do {
            list.add(Boolean.valueOf(this.f13485a.zzup()));
            if (this.f13485a.zzuz()) {
                return;
            } else {
                zzuj = this.f13485a.zzuj();
            }
        } while (zzuj == this.f13486b);
        this.f13488d = zzuj;
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final int a() throws IOException {
        a(0);
        return this.f13485a.zzus();
    }

    private final void a(List<String> list, boolean z) throws IOException {
        int zzuj;
        int zzuj2;
        if ((this.f13486b & 7) == 2) {
            if ((list instanceof zzve) && !z) {
                zzve zzveVar = (zzve) list;
                do {
                    zzveVar.zzc(zzur());
                    if (this.f13485a.zzuz()) {
                        return;
                    } else {
                        zzuj2 = this.f13485a.zzuj();
                    }
                } while (zzuj2 == this.f13486b);
                this.f13488d = zzuj2;
                return;
            }
            do {
                list.add(z ? b() : readString());
                if (this.f13485a.zzuz()) {
                    return;
                } else {
                    zzuj = this.f13485a.zzuj();
                }
            } while (zzuj == this.f13486b);
            this.f13488d = zzuj;
            return;
        }
        throw zzuv.zzwu();
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final void d(List<String> list) throws IOException {
        a(list, true);
    }

    private final void d(int i) throws IOException {
        if (this.f13485a.zzva() != i) {
            throw zzuv.zzwq();
        }
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final void c(List<zzte> list) throws IOException {
        int zzuj;
        if ((this.f13486b & 7) != 2) {
            throw zzuv.zzwu();
        }
        do {
            list.add(zzur());
            if (this.f13485a.zzuz()) {
                return;
            } else {
                zzuj = this.f13485a.zzuj();
            }
        } while (zzuj == this.f13486b);
        this.f13488d = zzuj;
    }

    private static void c(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzuv.zzww();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final <T> void a(List<T> list, InterfaceC1353cb<T> interfaceC1353cb, zzub zzubVar) throws IOException {
        int zzuj;
        int i = this.f13486b;
        if ((i & 7) != 3) {
            throw zzuv.zzwu();
        }
        do {
            list.add(d(interfaceC1353cb, zzubVar));
            if (this.f13485a.zzuz() || this.f13488d != 0) {
                return;
            } else {
                zzuj = this.f13485a.zzuj();
            }
        } while (zzuj == i);
        this.f13488d = zzuj;
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final void a(List<Integer> list) throws IOException {
        int zzuj;
        int zzuj2;
        if (list instanceof Aa) {
            Aa aa = (Aa) list;
            int i = this.f13486b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzva = this.f13485a.zzva() + this.f13485a.zzus();
                    do {
                        aa.a(this.f13485a.zzus());
                    } while (this.f13485a.zzva() < zzva);
                    d(zzva);
                    return;
                }
                throw zzuv.zzwu();
            }
            do {
                aa.a(this.f13485a.zzus());
                if (this.f13485a.zzuz()) {
                    return;
                } else {
                    zzuj2 = this.f13485a.zzuj();
                }
            } while (zzuj2 == this.f13486b);
            this.f13488d = zzuj2;
            return;
        }
        int i2 = this.f13486b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzva2 = this.f13485a.zzva() + this.f13485a.zzus();
                do {
                    list.add(Integer.valueOf(this.f13485a.zzus()));
                } while (this.f13485a.zzva() < zzva2);
                d(zzva2);
                return;
            }
            throw zzuv.zzwu();
        }
        do {
            list.add(Integer.valueOf(this.f13485a.zzus()));
            if (this.f13485a.zzuz()) {
                return;
            } else {
                zzuj = this.f13485a.zzuj();
            }
        } while (zzuj == this.f13486b);
        this.f13488d = zzuj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.InterfaceC1350bb
    public final <T> void b(List<T> list, InterfaceC1353cb<T> interfaceC1353cb, zzub zzubVar) throws IOException {
        int zzuj;
        int i = this.f13486b;
        if ((i & 7) != 2) {
            throw zzuv.zzwu();
        }
        do {
            list.add(c(interfaceC1353cb, zzubVar));
            if (this.f13485a.zzuz() || this.f13488d != 0) {
                return;
            } else {
                zzuj = this.f13485a.zzuj();
            }
        } while (zzuj == i);
        this.f13488d = zzuj;
    }

    private static void b(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzuv.zzww();
        }
    }
}
