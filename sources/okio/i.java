package okio;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SegmentPool.java */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    static final i f4935a = new i();
    long b;
    private h c;

    private i() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h a() {
        synchronized (this) {
            if (this.c != null) {
                h hVar = this.c;
                this.c = hVar.d;
                hVar.d = null;
                this.b -= 2048;
                return hVar;
            }
            return new h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(h hVar) {
        if (hVar.d != null || hVar.e != null) {
            throw new IllegalArgumentException();
        }
        synchronized (this) {
            if (this.b + 2048 <= 65536) {
                this.b += 2048;
                hVar.d = this.c;
                hVar.c = 0;
                hVar.b = 0;
                this.c = hVar;
            }
        }
    }
}
