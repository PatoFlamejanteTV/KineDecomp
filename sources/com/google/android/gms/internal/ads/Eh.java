package com.google.android.gms.internal.ads;

import android.support.v7.widget.ActivityChooserView;
import java.io.IOException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Eh implements InterfaceC1098ti {

    /* renamed from: a, reason: collision with root package name */
    private final zzbqf f11492a;

    /* renamed from: b, reason: collision with root package name */
    private int f11493b;

    /* renamed from: c, reason: collision with root package name */
    private int f11494c;

    /* renamed from: d, reason: collision with root package name */
    private int f11495d = 0;

    private Eh(zzbqf zzbqfVar) {
        zzbrf.zza(zzbqfVar, "input");
        this.f11492a = zzbqfVar;
        this.f11492a.zzflt = this;
    }

    public static Eh a(zzbqf zzbqfVar) {
        Eh eh = zzbqfVar.zzflt;
        return eh != null ? eh : new Eh(zzbqfVar);
    }

    private final <T> T c(InterfaceC1112ui<T> interfaceC1112ui, zzbqq zzbqqVar) throws IOException {
        int zzald = this.f11492a.zzald();
        zzbqf zzbqfVar = this.f11492a;
        if (zzbqfVar.zzflq < zzbqfVar.zzflr) {
            int zzer = zzbqfVar.zzer(zzald);
            T newInstance = interfaceC1112ui.newInstance();
            this.f11492a.zzflq++;
            interfaceC1112ui.a(newInstance, this, zzbqqVar);
            interfaceC1112ui.d(newInstance);
            this.f11492a.zzeo(0);
            r5.zzflq--;
            this.f11492a.zzes(zzer);
            return newInstance;
        }
        throw zzbrl.zzani();
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final long b() throws IOException {
        a(0);
        return this.f11492a.zzakv();
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final int d() throws IOException {
        a(0);
        return this.f11492a.zzakx();
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final long e() throws IOException {
        a(0);
        return this.f11492a.zzakw();
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final long f() throws IOException {
        a(1);
        return this.f11492a.zzaky();
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final int g() throws IOException {
        a(5);
        return this.f11492a.zzakz();
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final int getTag() {
        return this.f11493b;
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final int h() throws IOException {
        a(0);
        return this.f11492a.zzald();
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final int i() throws IOException {
        a(0);
        return this.f11492a.zzale();
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final int j() throws IOException {
        a(5);
        return this.f11492a.zzalf();
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final long k() throws IOException {
        a(1);
        return this.f11492a.zzalg();
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final boolean l() throws IOException {
        a(0);
        return this.f11492a.zzala();
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final int m() throws IOException {
        int i = this.f11495d;
        if (i != 0) {
            this.f11493b = i;
            this.f11495d = 0;
        } else {
            this.f11493b = this.f11492a.zzaku();
        }
        int i2 = this.f11493b;
        return (i2 == 0 || i2 == this.f11494c) ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : i2 >>> 3;
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final String n() throws IOException {
        a(2);
        return this.f11492a.zzalb();
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final boolean o() throws IOException {
        int i;
        if (this.f11492a.zzalk() || (i = this.f11493b) == this.f11494c) {
            return false;
        }
        return this.f11492a.zzep(i);
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final zzbpu p() throws IOException {
        a(2);
        return this.f11492a.zzalc();
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final void q(List<Boolean> list) throws IOException {
        int zzaku;
        int zzaku2;
        if (list instanceof C1125vh) {
            C1125vh c1125vh = (C1125vh) list;
            int i = this.f11493b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzall = this.f11492a.zzall() + this.f11492a.zzald();
                    do {
                        c1125vh.a(this.f11492a.zzala());
                    } while (this.f11492a.zzall() < zzall);
                    d(zzall);
                    return;
                }
                throw zzbrl.zzanh();
            }
            do {
                c1125vh.a(this.f11492a.zzala());
                if (this.f11492a.zzalk()) {
                    return;
                } else {
                    zzaku2 = this.f11492a.zzaku();
                }
            } while (zzaku2 == this.f11493b);
            this.f11495d = zzaku2;
            return;
        }
        int i2 = this.f11493b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzall2 = this.f11492a.zzall() + this.f11492a.zzald();
                do {
                    list.add(Boolean.valueOf(this.f11492a.zzala()));
                } while (this.f11492a.zzall() < zzall2);
                d(zzall2);
                return;
            }
            throw zzbrl.zzanh();
        }
        do {
            list.add(Boolean.valueOf(this.f11492a.zzala()));
            if (this.f11492a.zzalk()) {
                return;
            } else {
                zzaku = this.f11492a.zzaku();
            }
        } while (zzaku == this.f11493b);
        this.f11495d = zzaku;
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final void r(List<zzbpu> list) throws IOException {
        int zzaku;
        if ((this.f11493b & 7) != 2) {
            throw zzbrl.zzanh();
        }
        do {
            list.add(p());
            if (this.f11492a.zzalk()) {
                return;
            } else {
                zzaku = this.f11492a.zzaku();
            }
        } while (zzaku == this.f11493b);
        this.f11495d = zzaku;
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final double readDouble() throws IOException {
        a(1);
        return this.f11492a.readDouble();
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final float readFloat() throws IOException {
        a(5);
        return this.f11492a.readFloat();
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final String readString() throws IOException {
        a(2);
        return this.f11492a.readString();
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final void s(List<Integer> list) throws IOException {
        int zzaku;
        int zzaku2;
        if (list instanceof Sh) {
            Sh sh = (Sh) list;
            int i = this.f11493b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzall = this.f11492a.zzall() + this.f11492a.zzald();
                    do {
                        sh.a(this.f11492a.zzald());
                    } while (this.f11492a.zzall() < zzall);
                    d(zzall);
                    return;
                }
                throw zzbrl.zzanh();
            }
            do {
                sh.a(this.f11492a.zzald());
                if (this.f11492a.zzalk()) {
                    return;
                } else {
                    zzaku2 = this.f11492a.zzaku();
                }
            } while (zzaku2 == this.f11493b);
            this.f11495d = zzaku2;
            return;
        }
        int i2 = this.f11493b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzall2 = this.f11492a.zzall() + this.f11492a.zzald();
                do {
                    list.add(Integer.valueOf(this.f11492a.zzald()));
                } while (this.f11492a.zzall() < zzall2);
                d(zzall2);
                return;
            }
            throw zzbrl.zzanh();
        }
        do {
            list.add(Integer.valueOf(this.f11492a.zzald()));
            if (this.f11492a.zzalk()) {
                return;
            } else {
                zzaku = this.f11492a.zzaku();
            }
        } while (zzaku == this.f11493b);
        this.f11495d = zzaku;
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final void t(List<Integer> list) throws IOException {
        int zzaku;
        int zzaku2;
        if (list instanceof Sh) {
            Sh sh = (Sh) list;
            int i = this.f11493b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzall = this.f11492a.zzall() + this.f11492a.zzald();
                    do {
                        sh.a(this.f11492a.zzalh());
                    } while (this.f11492a.zzall() < zzall);
                    d(zzall);
                    return;
                }
                throw zzbrl.zzanh();
            }
            do {
                sh.a(this.f11492a.zzalh());
                if (this.f11492a.zzalk()) {
                    return;
                } else {
                    zzaku2 = this.f11492a.zzaku();
                }
            } while (zzaku2 == this.f11493b);
            this.f11495d = zzaku2;
            return;
        }
        int i2 = this.f11493b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzall2 = this.f11492a.zzall() + this.f11492a.zzald();
                do {
                    list.add(Integer.valueOf(this.f11492a.zzalh()));
                } while (this.f11492a.zzall() < zzall2);
                d(zzall2);
                return;
            }
            throw zzbrl.zzanh();
        }
        do {
            list.add(Integer.valueOf(this.f11492a.zzalh()));
            if (this.f11492a.zzalk()) {
                return;
            } else {
                zzaku = this.f11492a.zzaku();
            }
        } while (zzaku == this.f11493b);
        this.f11495d = zzaku;
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final void u(List<Long> list) throws IOException {
        int zzaku;
        int zzaku2;
        if (list instanceof _h) {
            _h _hVar = (_h) list;
            int i = this.f11493b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzall = this.f11492a.zzall() + this.f11492a.zzald();
                    do {
                        _hVar.a(this.f11492a.zzali());
                    } while (this.f11492a.zzall() < zzall);
                    d(zzall);
                    return;
                }
                throw zzbrl.zzanh();
            }
            do {
                _hVar.a(this.f11492a.zzali());
                if (this.f11492a.zzalk()) {
                    return;
                } else {
                    zzaku2 = this.f11492a.zzaku();
                }
            } while (zzaku2 == this.f11493b);
            this.f11495d = zzaku2;
            return;
        }
        int i2 = this.f11493b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzall2 = this.f11492a.zzall() + this.f11492a.zzald();
                do {
                    list.add(Long.valueOf(this.f11492a.zzali()));
                } while (this.f11492a.zzall() < zzall2);
                d(zzall2);
                return;
            }
            throw zzbrl.zzanh();
        }
        do {
            list.add(Long.valueOf(this.f11492a.zzali()));
            if (this.f11492a.zzalk()) {
                return;
            } else {
                zzaku = this.f11492a.zzaku();
            }
        } while (zzaku == this.f11493b);
        this.f11495d = zzaku;
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final void v(List<Integer> list) throws IOException {
        int zzaku;
        int zzaku2;
        if (list instanceof Sh) {
            Sh sh = (Sh) list;
            int i = this.f11493b & 7;
            if (i != 2) {
                if (i != 5) {
                    throw zzbrl.zzanh();
                }
                do {
                    sh.a(this.f11492a.zzalf());
                    if (this.f11492a.zzalk()) {
                        return;
                    } else {
                        zzaku2 = this.f11492a.zzaku();
                    }
                } while (zzaku2 == this.f11493b);
                this.f11495d = zzaku2;
                return;
            }
            int zzald = this.f11492a.zzald();
            c(zzald);
            int zzall = this.f11492a.zzall() + zzald;
            do {
                sh.a(this.f11492a.zzalf());
            } while (this.f11492a.zzall() < zzall);
            return;
        }
        int i2 = this.f11493b & 7;
        if (i2 != 2) {
            if (i2 != 5) {
                throw zzbrl.zzanh();
            }
            do {
                list.add(Integer.valueOf(this.f11492a.zzalf()));
                if (this.f11492a.zzalk()) {
                    return;
                } else {
                    zzaku = this.f11492a.zzaku();
                }
            } while (zzaku == this.f11493b);
            this.f11495d = zzaku;
            return;
        }
        int zzald2 = this.f11492a.zzald();
        c(zzald2);
        int zzall2 = this.f11492a.zzall() + zzald2;
        do {
            list.add(Integer.valueOf(this.f11492a.zzalf()));
        } while (this.f11492a.zzall() < zzall2);
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final void w(List<Long> list) throws IOException {
        int zzaku;
        int zzaku2;
        if (list instanceof _h) {
            _h _hVar = (_h) list;
            int i = this.f11493b & 7;
            if (i != 1) {
                if (i == 2) {
                    int zzald = this.f11492a.zzald();
                    b(zzald);
                    int zzall = this.f11492a.zzall() + zzald;
                    do {
                        _hVar.a(this.f11492a.zzalg());
                    } while (this.f11492a.zzall() < zzall);
                    return;
                }
                throw zzbrl.zzanh();
            }
            do {
                _hVar.a(this.f11492a.zzalg());
                if (this.f11492a.zzalk()) {
                    return;
                } else {
                    zzaku2 = this.f11492a.zzaku();
                }
            } while (zzaku2 == this.f11493b);
            this.f11495d = zzaku2;
            return;
        }
        int i2 = this.f11493b & 7;
        if (i2 != 1) {
            if (i2 == 2) {
                int zzald2 = this.f11492a.zzald();
                b(zzald2);
                int zzall2 = this.f11492a.zzall() + zzald2;
                do {
                    list.add(Long.valueOf(this.f11492a.zzalg()));
                } while (this.f11492a.zzall() < zzall2);
                return;
            }
            throw zzbrl.zzanh();
        }
        do {
            list.add(Long.valueOf(this.f11492a.zzalg()));
            if (this.f11492a.zzalk()) {
                return;
            } else {
                zzaku = this.f11492a.zzaku();
            }
        } while (zzaku == this.f11493b);
        this.f11495d = zzaku;
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final void x(List<Integer> list) throws IOException {
        int zzaku;
        int zzaku2;
        if (list instanceof Sh) {
            Sh sh = (Sh) list;
            int i = this.f11493b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzall = this.f11492a.zzall() + this.f11492a.zzald();
                    do {
                        sh.a(this.f11492a.zzale());
                    } while (this.f11492a.zzall() < zzall);
                    d(zzall);
                    return;
                }
                throw zzbrl.zzanh();
            }
            do {
                sh.a(this.f11492a.zzale());
                if (this.f11492a.zzalk()) {
                    return;
                } else {
                    zzaku2 = this.f11492a.zzaku();
                }
            } while (zzaku2 == this.f11493b);
            this.f11495d = zzaku2;
            return;
        }
        int i2 = this.f11493b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzall2 = this.f11492a.zzall() + this.f11492a.zzald();
                do {
                    list.add(Integer.valueOf(this.f11492a.zzale()));
                } while (this.f11492a.zzall() < zzall2);
                d(zzall2);
                return;
            }
            throw zzbrl.zzanh();
        }
        do {
            list.add(Integer.valueOf(this.f11492a.zzale()));
            if (this.f11492a.zzalk()) {
                return;
            } else {
                zzaku = this.f11492a.zzaku();
            }
        } while (zzaku == this.f11493b);
        this.f11495d = zzaku;
    }

    private final void a(int i) throws IOException {
        if ((this.f11493b & 7) != i) {
            throw zzbrl.zzanh();
        }
    }

    private final <T> T d(InterfaceC1112ui<T> interfaceC1112ui, zzbqq zzbqqVar) throws IOException {
        int i = this.f11494c;
        this.f11494c = ((this.f11493b >>> 3) << 3) | 4;
        try {
            T newInstance = interfaceC1112ui.newInstance();
            interfaceC1112ui.a(newInstance, this, zzbqqVar);
            interfaceC1112ui.d(newInstance);
            if (this.f11493b == this.f11494c) {
                return newInstance;
            }
            throw zzbrl.zzanj();
        } finally {
            this.f11494c = i;
        }
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final <T> T b(InterfaceC1112ui<T> interfaceC1112ui, zzbqq zzbqqVar) throws IOException {
        a(3);
        return (T) d(interfaceC1112ui, zzbqqVar);
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final void e(List<String> list) throws IOException {
        a(list, false);
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final void h(List<Integer> list) throws IOException {
        int zzaku;
        int zzaku2;
        if (list instanceof Sh) {
            Sh sh = (Sh) list;
            int i = this.f11493b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzall = this.f11492a.zzall() + this.f11492a.zzald();
                    do {
                        sh.a(this.f11492a.zzakx());
                    } while (this.f11492a.zzall() < zzall);
                    d(zzall);
                    return;
                }
                throw zzbrl.zzanh();
            }
            do {
                sh.a(this.f11492a.zzakx());
                if (this.f11492a.zzalk()) {
                    return;
                } else {
                    zzaku2 = this.f11492a.zzaku();
                }
            } while (zzaku2 == this.f11493b);
            this.f11495d = zzaku2;
            return;
        }
        int i2 = this.f11493b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzall2 = this.f11492a.zzall() + this.f11492a.zzald();
                do {
                    list.add(Integer.valueOf(this.f11492a.zzakx()));
                } while (this.f11492a.zzall() < zzall2);
                d(zzall2);
                return;
            }
            throw zzbrl.zzanh();
        }
        do {
            list.add(Integer.valueOf(this.f11492a.zzakx()));
            if (this.f11492a.zzalk()) {
                return;
            } else {
                zzaku = this.f11492a.zzaku();
            }
        } while (zzaku == this.f11493b);
        this.f11495d = zzaku;
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final void i(List<Integer> list) throws IOException {
        int zzaku;
        int zzaku2;
        if (list instanceof Sh) {
            Sh sh = (Sh) list;
            int i = this.f11493b & 7;
            if (i != 2) {
                if (i != 5) {
                    throw zzbrl.zzanh();
                }
                do {
                    sh.a(this.f11492a.zzakz());
                    if (this.f11492a.zzalk()) {
                        return;
                    } else {
                        zzaku2 = this.f11492a.zzaku();
                    }
                } while (zzaku2 == this.f11493b);
                this.f11495d = zzaku2;
                return;
            }
            int zzald = this.f11492a.zzald();
            c(zzald);
            int zzall = this.f11492a.zzall() + zzald;
            do {
                sh.a(this.f11492a.zzakz());
            } while (this.f11492a.zzall() < zzall);
            return;
        }
        int i2 = this.f11493b & 7;
        if (i2 != 2) {
            if (i2 != 5) {
                throw zzbrl.zzanh();
            }
            do {
                list.add(Integer.valueOf(this.f11492a.zzakz()));
                if (this.f11492a.zzalk()) {
                    return;
                } else {
                    zzaku = this.f11492a.zzaku();
                }
            } while (zzaku == this.f11493b);
            this.f11495d = zzaku;
            return;
        }
        int zzald2 = this.f11492a.zzald();
        c(zzald2);
        int zzall2 = this.f11492a.zzall() + zzald2;
        do {
            list.add(Integer.valueOf(this.f11492a.zzakz()));
        } while (this.f11492a.zzall() < zzall2);
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final void j(List<Long> list) throws IOException {
        int zzaku;
        int zzaku2;
        if (list instanceof _h) {
            _h _hVar = (_h) list;
            int i = this.f11493b & 7;
            if (i != 1) {
                if (i == 2) {
                    int zzald = this.f11492a.zzald();
                    b(zzald);
                    int zzall = this.f11492a.zzall() + zzald;
                    do {
                        _hVar.a(this.f11492a.zzaky());
                    } while (this.f11492a.zzall() < zzall);
                    return;
                }
                throw zzbrl.zzanh();
            }
            do {
                _hVar.a(this.f11492a.zzaky());
                if (this.f11492a.zzalk()) {
                    return;
                } else {
                    zzaku2 = this.f11492a.zzaku();
                }
            } while (zzaku2 == this.f11493b);
            this.f11495d = zzaku2;
            return;
        }
        int i2 = this.f11493b & 7;
        if (i2 != 1) {
            if (i2 == 2) {
                int zzald2 = this.f11492a.zzald();
                b(zzald2);
                int zzall2 = this.f11492a.zzall() + zzald2;
                do {
                    list.add(Long.valueOf(this.f11492a.zzaky()));
                } while (this.f11492a.zzall() < zzall2);
                return;
            }
            throw zzbrl.zzanh();
        }
        do {
            list.add(Long.valueOf(this.f11492a.zzaky()));
            if (this.f11492a.zzalk()) {
                return;
            } else {
                zzaku = this.f11492a.zzaku();
            }
        } while (zzaku == this.f11493b);
        this.f11495d = zzaku;
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final void p(List<String> list) throws IOException {
        a(list, true);
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final <T> T a(InterfaceC1112ui<T> interfaceC1112ui, zzbqq zzbqqVar) throws IOException {
        a(2);
        return (T) c(interfaceC1112ui, zzbqqVar);
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final void b(List<Double> list) throws IOException {
        int zzaku;
        int zzaku2;
        if (list instanceof Hh) {
            Hh hh = (Hh) list;
            int i = this.f11493b & 7;
            if (i != 1) {
                if (i == 2) {
                    int zzald = this.f11492a.zzald();
                    b(zzald);
                    int zzall = this.f11492a.zzall() + zzald;
                    do {
                        hh.b(this.f11492a.readDouble());
                    } while (this.f11492a.zzall() < zzall);
                    return;
                }
                throw zzbrl.zzanh();
            }
            do {
                hh.b(this.f11492a.readDouble());
                if (this.f11492a.zzalk()) {
                    return;
                } else {
                    zzaku2 = this.f11492a.zzaku();
                }
            } while (zzaku2 == this.f11493b);
            this.f11495d = zzaku2;
            return;
        }
        int i2 = this.f11493b & 7;
        if (i2 != 1) {
            if (i2 == 2) {
                int zzald2 = this.f11492a.zzald();
                b(zzald2);
                int zzall2 = this.f11492a.zzall() + zzald2;
                do {
                    list.add(Double.valueOf(this.f11492a.readDouble()));
                } while (this.f11492a.zzall() < zzall2);
                return;
            }
            throw zzbrl.zzanh();
        }
        do {
            list.add(Double.valueOf(this.f11492a.readDouble()));
            if (this.f11492a.zzalk()) {
                return;
            } else {
                zzaku = this.f11492a.zzaku();
            }
        } while (zzaku == this.f11493b);
        this.f11495d = zzaku;
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final long a() throws IOException {
        a(0);
        return this.f11492a.zzali();
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final void a(List<Long> list) throws IOException {
        int zzaku;
        int zzaku2;
        if (list instanceof _h) {
            _h _hVar = (_h) list;
            int i = this.f11493b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzall = this.f11492a.zzall() + this.f11492a.zzald();
                    do {
                        _hVar.a(this.f11492a.zzakw());
                    } while (this.f11492a.zzall() < zzall);
                    d(zzall);
                    return;
                }
                throw zzbrl.zzanh();
            }
            do {
                _hVar.a(this.f11492a.zzakw());
                if (this.f11492a.zzalk()) {
                    return;
                } else {
                    zzaku2 = this.f11492a.zzaku();
                }
            } while (zzaku2 == this.f11493b);
            this.f11495d = zzaku2;
            return;
        }
        int i2 = this.f11493b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzall2 = this.f11492a.zzall() + this.f11492a.zzald();
                do {
                    list.add(Long.valueOf(this.f11492a.zzakw()));
                } while (this.f11492a.zzall() < zzall2);
                d(zzall2);
                return;
            }
            throw zzbrl.zzanh();
        }
        do {
            list.add(Long.valueOf(this.f11492a.zzakw()));
            if (this.f11492a.zzalk()) {
                return;
            } else {
                zzaku = this.f11492a.zzaku();
            }
        } while (zzaku == this.f11493b);
        this.f11495d = zzaku;
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final int c() throws IOException {
        a(0);
        return this.f11492a.zzalh();
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final void d(List<Float> list) throws IOException {
        int zzaku;
        int zzaku2;
        if (list instanceof Ph) {
            Ph ph = (Ph) list;
            int i = this.f11493b & 7;
            if (i != 2) {
                if (i != 5) {
                    throw zzbrl.zzanh();
                }
                do {
                    ph.a(this.f11492a.readFloat());
                    if (this.f11492a.zzalk()) {
                        return;
                    } else {
                        zzaku2 = this.f11492a.zzaku();
                    }
                } while (zzaku2 == this.f11493b);
                this.f11495d = zzaku2;
                return;
            }
            int zzald = this.f11492a.zzald();
            c(zzald);
            int zzall = this.f11492a.zzall() + zzald;
            do {
                ph.a(this.f11492a.readFloat());
            } while (this.f11492a.zzall() < zzall);
            return;
        }
        int i2 = this.f11493b & 7;
        if (i2 != 2) {
            if (i2 != 5) {
                throw zzbrl.zzanh();
            }
            do {
                list.add(Float.valueOf(this.f11492a.readFloat()));
                if (this.f11492a.zzalk()) {
                    return;
                } else {
                    zzaku = this.f11492a.zzaku();
                }
            } while (zzaku == this.f11493b);
            this.f11495d = zzaku;
            return;
        }
        int zzald2 = this.f11492a.zzald();
        c(zzald2);
        int zzall2 = this.f11492a.zzall() + zzald2;
        do {
            list.add(Float.valueOf(this.f11492a.readFloat()));
        } while (this.f11492a.zzall() < zzall2);
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final void c(List<Long> list) throws IOException {
        int zzaku;
        int zzaku2;
        if (list instanceof _h) {
            _h _hVar = (_h) list;
            int i = this.f11493b & 7;
            if (i != 0) {
                if (i == 2) {
                    int zzall = this.f11492a.zzall() + this.f11492a.zzald();
                    do {
                        _hVar.a(this.f11492a.zzakv());
                    } while (this.f11492a.zzall() < zzall);
                    d(zzall);
                    return;
                }
                throw zzbrl.zzanh();
            }
            do {
                _hVar.a(this.f11492a.zzakv());
                if (this.f11492a.zzalk()) {
                    return;
                } else {
                    zzaku2 = this.f11492a.zzaku();
                }
            } while (zzaku2 == this.f11493b);
            this.f11495d = zzaku2;
            return;
        }
        int i2 = this.f11493b & 7;
        if (i2 != 0) {
            if (i2 == 2) {
                int zzall2 = this.f11492a.zzall() + this.f11492a.zzald();
                do {
                    list.add(Long.valueOf(this.f11492a.zzakv()));
                } while (this.f11492a.zzall() < zzall2);
                d(zzall2);
                return;
            }
            throw zzbrl.zzanh();
        }
        do {
            list.add(Long.valueOf(this.f11492a.zzakv()));
            if (this.f11492a.zzalk()) {
                return;
            } else {
                zzaku = this.f11492a.zzaku();
            }
        } while (zzaku == this.f11493b);
        this.f11495d = zzaku;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final <T> void b(List<T> list, InterfaceC1112ui<T> interfaceC1112ui, zzbqq zzbqqVar) throws IOException {
        int zzaku;
        int i = this.f11493b;
        if ((i & 7) != 3) {
            throw zzbrl.zzanh();
        }
        do {
            list.add(d(interfaceC1112ui, zzbqqVar));
            if (this.f11492a.zzalk() || this.f11495d != 0) {
                return;
            } else {
                zzaku = this.f11492a.zzaku();
            }
        } while (zzaku == i);
        this.f11495d = zzaku;
    }

    private final void a(List<String> list, boolean z) throws IOException {
        int zzaku;
        int zzaku2;
        if ((this.f11493b & 7) == 2) {
            if ((list instanceof zzbru) && !z) {
                zzbru zzbruVar = (zzbru) list;
                do {
                    zzbruVar.zzap(p());
                    if (this.f11492a.zzalk()) {
                        return;
                    } else {
                        zzaku2 = this.f11492a.zzaku();
                    }
                } while (zzaku2 == this.f11493b);
                this.f11495d = zzaku2;
                return;
            }
            do {
                list.add(z ? n() : readString());
                if (this.f11492a.zzalk()) {
                    return;
                } else {
                    zzaku = this.f11492a.zzaku();
                }
            } while (zzaku == this.f11493b);
            this.f11495d = zzaku;
            return;
        }
        throw zzbrl.zzanh();
    }

    private static void b(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzbrl.zzanj();
        }
    }

    private final void d(int i) throws IOException {
        if (this.f11492a.zzall() != i) {
            throw zzbrl.zzanc();
        }
    }

    private static void c(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzbrl.zzanj();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.InterfaceC1098ti
    public final <T> void a(List<T> list, InterfaceC1112ui<T> interfaceC1112ui, zzbqq zzbqqVar) throws IOException {
        int zzaku;
        int i = this.f11493b;
        if ((i & 7) != 2) {
            throw zzbrl.zzanh();
        }
        do {
            list.add(c(interfaceC1112ui, zzbqqVar));
            if (this.f11492a.zzalk() || this.f11495d != 0) {
                return;
            } else {
                zzaku = this.f11492a.zzaku();
            }
        } while (zzaku == i);
        this.f11495d = zzaku;
    }
}
