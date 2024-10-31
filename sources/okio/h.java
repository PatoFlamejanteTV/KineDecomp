package okio;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Segment.java */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    final byte[] f4934a = new byte[2048];
    int b;
    int c;
    h d;
    h e;

    public h a() {
        h hVar = this.d != this ? this.d : null;
        this.e.d = this.d;
        this.d.e = this.e;
        this.d = null;
        this.e = null;
        return hVar;
    }

    public h a(h hVar) {
        hVar.e = this;
        hVar.d = this.d;
        this.d.e = hVar;
        this.d = hVar;
        return hVar;
    }

    public h a(int i) {
        int i2 = (this.c - this.b) - i;
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        if (i < i2) {
            h a2 = i.f4935a.a();
            System.arraycopy(this.f4934a, this.b, a2.f4934a, a2.b, i);
            this.b += i;
            a2.c += i;
            this.e.a(a2);
            return a2;
        }
        h a3 = i.f4935a.a();
        System.arraycopy(this.f4934a, this.b + i, a3.f4934a, a3.b, i2);
        this.c -= i2;
        a3.c = i2 + a3.c;
        a(a3);
        return this;
    }

    public void b() {
        if (this.e == this) {
            throw new IllegalStateException();
        }
        if ((this.e.c - this.e.b) + (this.c - this.b) <= 2048) {
            a(this.e, this.c - this.b);
            a();
            i.f4935a.a(this);
        }
    }

    public void a(h hVar, int i) {
        if ((hVar.c - hVar.b) + i > 2048) {
            throw new IllegalArgumentException();
        }
        if (hVar.c + i > 2048) {
            System.arraycopy(hVar.f4934a, hVar.b, hVar.f4934a, 0, hVar.c - hVar.b);
            hVar.c -= hVar.b;
            hVar.b = 0;
        }
        System.arraycopy(this.f4934a, this.b, hVar.f4934a, hVar.c, i);
        hVar.c += i;
        this.b += i;
    }
}
