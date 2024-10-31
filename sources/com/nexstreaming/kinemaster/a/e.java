package com.nexstreaming.kinemaster.a;

import android.util.SparseArray;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* compiled from: SeekableParticleSystem.java */
/* loaded from: classes.dex */
public class e implements c {

    /* renamed from: a, reason: collision with root package name */
    private final c f3259a;
    private final int c;
    private int d;
    private int b = 0;
    private SparseArray<d> e = new SparseArray<>();

    public static e a(c cVar, int i, int i2) {
        if (cVar instanceof e) {
            if (((e) cVar).c == i && ((e) cVar).d == i2) {
                return (e) cVar;
            }
            return new e(((e) cVar).f3259a, i, i2);
        }
        return new e(cVar, i, i2);
    }

    private e(c cVar, int i, int i2) {
        this.f3259a = cVar;
        this.c = i;
        this.d = i2;
        cVar.b();
    }

    @Override // com.nexstreaming.kinemaster.a.c
    public int a() {
        return this.f3259a.a();
    }

    @Override // com.nexstreaming.kinemaster.a.c
    public boolean a(int i, b bVar) {
        return this.f3259a.a(i, bVar);
    }

    @Override // com.nexstreaming.kinemaster.a.c
    public void b() {
        this.b = 0;
        this.f3259a.b();
    }

    @Override // com.nexstreaming.kinemaster.a.c
    public void c() {
        this.b++;
        this.f3259a.c();
        if (this.b > 0 && this.b % 480 == 0 && this.e.get(this.b) == null) {
            this.e.put(this.b, this.f3259a.d());
        }
    }

    @Override // com.nexstreaming.kinemaster.a.c
    public d d() {
        return new a((this.b * LicenseErrCode.LICENSE_STATUS_NOT_LICENSED) / this.c);
    }

    @Override // com.nexstreaming.kinemaster.a.c
    public void a(d dVar) {
        a(((a) dVar).f3260a);
    }

    public int e() {
        return this.d;
    }

    public void a(int i) {
        int i2 = (this.c * i) / LicenseErrCode.LICENSE_STATUS_NOT_LICENSED;
        if (i2 != this.b) {
            if (i2 < this.b) {
                for (int i3 = i2 - (i2 % 480); i3 > 0; i3 -= 480) {
                    d dVar = this.e.get(i3);
                    if (dVar != null) {
                        this.f3259a.a(dVar);
                        this.b = i3;
                        while (this.b < i2) {
                            c();
                        }
                        return;
                    }
                }
                b();
            }
            while (this.b < i2) {
                c();
            }
        }
    }

    /* compiled from: SeekableParticleSystem.java */
    /* loaded from: classes.dex */
    private static class a implements d {

        /* renamed from: a, reason: collision with root package name */
        public final int f3260a;

        private a(int i) {
            this.f3260a = i;
        }
    }
}
