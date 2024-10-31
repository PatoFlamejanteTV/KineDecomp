package com.bumptech.glide.b;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.ActivityChooserView;
import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* compiled from: GifHeaderParser.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: b */
    private ByteBuffer f8397b;

    /* renamed from: c */
    private c f8398c;

    /* renamed from: a */
    private final byte[] f8396a = new byte[256];

    /* renamed from: d */
    private int f8399d = 0;

    private boolean c() {
        return this.f8398c.f8389b != 0;
    }

    private int d() {
        try {
            return this.f8397b.get() & 255;
        } catch (Exception unused) {
            this.f8398c.f8389b = 1;
            return 0;
        }
    }

    private void e() {
        this.f8398c.f8391d.f8380a = l();
        this.f8398c.f8391d.f8381b = l();
        this.f8398c.f8391d.f8382c = l();
        this.f8398c.f8391d.f8383d = l();
        int d2 = d();
        boolean z = (d2 & 128) != 0;
        int pow = (int) Math.pow(2.0d, (d2 & 7) + 1);
        this.f8398c.f8391d.f8384e = (d2 & 64) != 0;
        if (z) {
            this.f8398c.f8391d.k = a(pow);
        } else {
            this.f8398c.f8391d.k = null;
        }
        this.f8398c.f8391d.j = this.f8397b.position();
        o();
        if (c()) {
            return;
        }
        c cVar = this.f8398c;
        cVar.f8390c++;
        cVar.f8392e.add(cVar.f8391d);
    }

    private void f() {
        this.f8399d = d();
        if (this.f8399d > 0) {
            int i = 0;
            int i2 = 0;
            while (i < this.f8399d) {
                try {
                    i2 = this.f8399d - i;
                    this.f8397b.get(this.f8396a, i, i2);
                    i += i2;
                } catch (Exception e2) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        Log.d("GifHeaderParser", "Error Reading Block n: " + i + " count: " + i2 + " blockSize: " + this.f8399d, e2);
                    }
                    this.f8398c.f8389b = 1;
                    return;
                }
            }
        }
    }

    private void g() {
        b(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    private void h() {
        d();
        int d2 = d();
        b bVar = this.f8398c.f8391d;
        bVar.f8386g = (d2 & 28) >> 2;
        if (bVar.f8386g == 0) {
            bVar.f8386g = 1;
        }
        this.f8398c.f8391d.f8385f = (d2 & 1) != 0;
        int l = l();
        if (l < 2) {
            l = 10;
        }
        b bVar2 = this.f8398c.f8391d;
        bVar2.i = l * 10;
        bVar2.f8387h = d();
        d();
    }

    private void i() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append((char) d());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.f8398c.f8389b = 1;
            return;
        }
        j();
        if (!this.f8398c.f8395h || c()) {
            return;
        }
        c cVar = this.f8398c;
        cVar.f8388a = a(cVar.i);
        c cVar2 = this.f8398c;
        cVar2.l = cVar2.f8388a[cVar2.j];
    }

    private void j() {
        this.f8398c.f8393f = l();
        this.f8398c.f8394g = l();
        this.f8398c.f8395h = (d() & 128) != 0;
        this.f8398c.i = (int) Math.pow(2.0d, (r0 & 7) + 1);
        this.f8398c.j = d();
        this.f8398c.k = d();
    }

    private void k() {
        do {
            f();
            byte[] bArr = this.f8396a;
            if (bArr[0] == 1) {
                this.f8398c.m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.f8399d <= 0) {
                return;
            }
        } while (!c());
    }

    private int l() {
        return this.f8397b.getShort();
    }

    private void m() {
        this.f8397b = null;
        Arrays.fill(this.f8396a, (byte) 0);
        this.f8398c = new c();
        this.f8399d = 0;
    }

    private void n() {
        int d2;
        do {
            d2 = d();
            this.f8397b.position(Math.min(this.f8397b.position() + d2, this.f8397b.limit()));
        } while (d2 > 0);
    }

    private void o() {
        d();
        n();
    }

    public d a(ByteBuffer byteBuffer) {
        m();
        this.f8397b = byteBuffer.asReadOnlyBuffer();
        this.f8397b.position(0);
        this.f8397b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public c b() {
        if (this.f8397b != null) {
            if (c()) {
                return this.f8398c;
            }
            i();
            if (!c()) {
                g();
                c cVar = this.f8398c;
                if (cVar.f8390c < 0) {
                    cVar.f8389b = 1;
                }
            }
            return this.f8398c;
        }
        throw new IllegalStateException("You must call setData() before parseHeader()");
    }

    public void a() {
        this.f8397b = null;
        this.f8398c = null;
    }

    private int[] a(int i) {
        byte[] bArr = new byte[i * 3];
        int[] iArr = null;
        try {
            this.f8397b.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                int i5 = bArr[i3] & 255;
                int i6 = i4 + 1;
                int i7 = bArr[i4] & 255;
                int i8 = i6 + 1;
                int i9 = i2 + 1;
                iArr[i2] = (i5 << 16) | ViewCompat.MEASURED_STATE_MASK | (i7 << 8) | (bArr[i6] & 255);
                i3 = i8;
                i2 = i9;
            }
        } catch (BufferUnderflowException e2) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e2);
            }
            this.f8398c.f8389b = 1;
        }
        return iArr;
    }

    private void b(int i) {
        boolean z = false;
        while (!z && !c() && this.f8398c.f8390c <= i) {
            int d2 = d();
            if (d2 == 33) {
                int d3 = d();
                if (d3 == 1) {
                    n();
                } else if (d3 == 249) {
                    this.f8398c.f8391d = new b();
                    h();
                } else if (d3 == 254) {
                    n();
                } else if (d3 != 255) {
                    n();
                } else {
                    f();
                    StringBuilder sb = new StringBuilder();
                    for (int i2 = 0; i2 < 11; i2++) {
                        sb.append((char) this.f8396a[i2]);
                    }
                    if (sb.toString().equals("NETSCAPE2.0")) {
                        k();
                    } else {
                        n();
                    }
                }
            } else if (d2 == 44) {
                c cVar = this.f8398c;
                if (cVar.f8391d == null) {
                    cVar.f8391d = new b();
                }
                e();
            } else if (d2 != 59) {
                this.f8398c.f8389b = 1;
            } else {
                z = true;
            }
        }
    }
}
