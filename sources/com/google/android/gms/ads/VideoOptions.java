package com.google.android.gms.ads;

import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzzw;

@zzark
/* loaded from: classes.dex */
public final class VideoOptions {

    /* renamed from: a */
    private final boolean f9947a;

    /* renamed from: b */
    private final boolean f9948b;

    /* renamed from: c */
    private final boolean f9949c;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        private boolean f9950a = true;

        /* renamed from: b */
        private boolean f9951b = false;

        /* renamed from: c */
        private boolean f9952c = false;

        public final Builder a(boolean z) {
            this.f9950a = z;
            return this;
        }

        public final VideoOptions a() {
            return new VideoOptions(this);
        }
    }

    public VideoOptions(zzzw zzzwVar) {
        this.f9947a = zzzwVar.zzcnf;
        this.f9948b = zzzwVar.zzcng;
        this.f9949c = zzzwVar.zzcnh;
    }

    public final boolean a() {
        return this.f9949c;
    }

    public final boolean b() {
        return this.f9948b;
    }

    public final boolean c() {
        return this.f9947a;
    }

    private VideoOptions(Builder builder) {
        this.f9947a = builder.f9950a;
        this.f9948b = builder.f9951b;
        this.f9949c = builder.f9952c;
    }

    /* synthetic */ VideoOptions(Builder builder, c cVar) {
        this(builder);
    }
}
