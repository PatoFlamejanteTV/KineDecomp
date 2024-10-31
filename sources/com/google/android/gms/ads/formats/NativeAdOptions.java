package com.google.android.gms.ads.formats;

/* loaded from: classes.dex */
public final class NativeAdOptions {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f523a;
    private final int b;
    private final boolean c;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private boolean f524a = false;
        private int b = 0;
        private boolean c = false;

        public Builder a(int i) {
            this.b = i;
            return this;
        }

        public Builder a(boolean z) {
            this.f524a = z;
            return this;
        }

        public NativeAdOptions a() {
            return new NativeAdOptions(this);
        }

        public Builder b(boolean z) {
            this.c = z;
            return this;
        }
    }

    private NativeAdOptions(Builder builder) {
        this.f523a = builder.f524a;
        this.b = builder.b;
        this.c = builder.c;
    }

    public boolean a() {
        return this.f523a;
    }

    public int b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }
}
