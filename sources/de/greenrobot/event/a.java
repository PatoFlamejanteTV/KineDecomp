package de.greenrobot.event;

/* compiled from: AsyncPoster.java */
/* loaded from: classes3.dex */
class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final j f26668a = new j();

    /* renamed from: b, reason: collision with root package name */
    private final e f26669b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(e eVar) {
        this.f26669b = eVar;
    }

    public void a(n nVar, Object obj) {
        this.f26668a.a(i.a(nVar, obj));
        this.f26669b.b().execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        i a2 = this.f26668a.a();
        if (a2 != null) {
            this.f26669b.a(a2);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
