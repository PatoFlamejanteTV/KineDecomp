package com.google.android.gms.ads.formats;

import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.internal.ads.zzark;

@zzark
/* loaded from: classes.dex */
public final class NativeAdOptions {

    /* renamed from: a */
    private final boolean f9957a;

    /* renamed from: b */
    private final int f9958b;

    /* renamed from: c */
    private final boolean f9959c;

    /* renamed from: d */
    private final int f9960d;

    /* renamed from: e */
    private final VideoOptions f9961e;

    /* renamed from: f */
    private final boolean f9962f;

    /* loaded from: classes.dex */
    public @interface AdChoicesPlacement {
    }

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: d */
        private VideoOptions f9966d;

        /* renamed from: a */
        private boolean f9963a = false;

        /* renamed from: b */
        private int f9964b = -1;

        /* renamed from: c */
        private boolean f9965c = false;

        /* renamed from: e */
        private int f9967e = 1;

        /* renamed from: f */
        private boolean f9968f = false;

        public final Builder a(boolean z) {
            this.f9965c = z;
            return this;
        }

        public final Builder b(boolean z) {
            this.f9963a = z;
            return this;
        }

        public final Builder a(@AdChoicesPlacement int i) {
            this.f9967e = i;
            return this;
        }

        public final Builder b(int i) {
            this.f9964b = i;
            return this;
        }

        public final Builder a(VideoOptions videoOptions) {
            this.f9966d = videoOptions;
            return this;
        }

        public final NativeAdOptions a() {
            return new NativeAdOptions(this);
        }
    }

    private NativeAdOptions(Builder builder) {
        this.f9957a = builder.f9963a;
        this.f9958b = builder.f9964b;
        this.f9959c = builder.f9965c;
        this.f9960d = builder.f9967e;
        this.f9961e = builder.f9966d;
        this.f9962f = builder.f9968f;
    }

    public final int a() {
        return this.f9960d;
    }

    public final int b() {
        return this.f9958b;
    }

    public final VideoOptions c() {
        return this.f9961e;
    }

    public final boolean d() {
        return this.f9959c;
    }

    public final boolean e() {
        return this.f9957a;
    }

    public final boolean f() {
        return this.f9962f;
    }

    /* synthetic */ NativeAdOptions(Builder builder, a aVar) {
        this(builder);
    }
}
