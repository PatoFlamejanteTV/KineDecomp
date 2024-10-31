package okio;

import javax.annotation.Nullable;

/* compiled from: Segment.java */
/* loaded from: classes3.dex */
public final class w {

    /* renamed from: a */
    final byte[] f29272a;

    /* renamed from: b */
    int f29273b;

    /* renamed from: c */
    int f29274c;

    /* renamed from: d */
    boolean f29275d;

    /* renamed from: e */
    boolean f29276e;

    /* renamed from: f */
    w f29277f;

    /* renamed from: g */
    w f29278g;

    public w() {
        this.f29272a = new byte[8192];
        this.f29276e = true;
        this.f29275d = false;
    }

    public final w a(w wVar) {
        wVar.f29278g = this;
        wVar.f29277f = this.f29277f;
        this.f29277f.f29278g = wVar;
        this.f29277f = wVar;
        return wVar;
    }

    @Nullable
    public final w b() {
        w wVar = this.f29277f;
        if (wVar == this) {
            wVar = null;
        }
        w wVar2 = this.f29278g;
        wVar2.f29277f = this.f29277f;
        this.f29277f.f29278g = wVar2;
        this.f29277f = null;
        this.f29278g = null;
        return wVar;
    }

    public final w c() {
        this.f29275d = true;
        return new w(this.f29272a, this.f29273b, this.f29274c, true, false);
    }

    public w(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.f29272a = bArr;
        this.f29273b = i;
        this.f29274c = i2;
        this.f29275d = z;
        this.f29276e = z2;
    }

    public final w a(int i) {
        w a2;
        if (i > 0 && i <= this.f29274c - this.f29273b) {
            if (i >= 1024) {
                a2 = c();
            } else {
                a2 = x.a();
                System.arraycopy(this.f29272a, this.f29273b, a2.f29272a, 0, i);
            }
            a2.f29274c = a2.f29273b + i;
            this.f29273b += i;
            this.f29278g.a(a2);
            return a2;
        }
        throw new IllegalArgumentException();
    }

    public final void a() {
        w wVar = this.f29278g;
        if (wVar != this) {
            if (wVar.f29276e) {
                int i = this.f29274c - this.f29273b;
                if (i > (8192 - wVar.f29274c) + (wVar.f29275d ? 0 : wVar.f29273b)) {
                    return;
                }
                a(this.f29278g, i);
                b();
                x.a(this);
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    public final void a(w wVar, int i) {
        if (wVar.f29276e) {
            int i2 = wVar.f29274c;
            if (i2 + i > 8192) {
                if (!wVar.f29275d) {
                    int i3 = wVar.f29273b;
                    if ((i2 + i) - i3 <= 8192) {
                        byte[] bArr = wVar.f29272a;
                        System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
                        wVar.f29274c -= wVar.f29273b;
                        wVar.f29273b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f29272a, this.f29273b, wVar.f29272a, wVar.f29274c, i);
            wVar.f29274c += i;
            this.f29273b += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
