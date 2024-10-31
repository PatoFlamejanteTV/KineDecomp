package com.bumptech.glide.g.a;

/* compiled from: StateVerifier.java */
/* loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: StateVerifier.java */
    /* loaded from: classes.dex */
    public static class a extends g {

        /* renamed from: a */
        private volatile boolean f8500a;

        a() {
            super();
        }

        @Override // com.bumptech.glide.g.a.g
        public void a(boolean z) {
            this.f8500a = z;
        }

        @Override // com.bumptech.glide.g.a.g
        public void b() {
            if (this.f8500a) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    /* synthetic */ g(f fVar) {
        this();
    }

    public static g a() {
        return new a();
    }

    public abstract void a(boolean z);

    public abstract void b();

    private g() {
    }
}
