package com.google.android.gms.ads;

import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.mediation.MediationAdapter;
import java.util.Date;

/* loaded from: classes.dex */
public final class AdRequest {

    /* renamed from: a, reason: collision with root package name */
    public static final String f514a = zzy.f557a;
    private final zzy b;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private final zzy.zza f515a = new zzy.zza();

        public Builder() {
            this.f515a.b(AdRequest.f514a);
        }

        public Builder a(int i) {
            this.f515a.a(i);
            return this;
        }

        public Builder a(Location location) {
            this.f515a.a(location);
            return this;
        }

        public Builder a(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.f515a.a(cls, bundle);
            if (cls.equals(AdMobAdapter.class) && bundle.getBoolean("_emulatorLiveAds")) {
                this.f515a.c(AdRequest.f514a);
            }
            return this;
        }

        public Builder a(String str) {
            this.f515a.a(str);
            return this;
        }

        public Builder a(Date date) {
            this.f515a.a(date);
            return this;
        }

        public Builder a(boolean z) {
            this.f515a.a(z);
            return this;
        }

        public AdRequest a() {
            return new AdRequest(this);
        }

        public Builder b(String str) {
            this.f515a.b(str);
            return this;
        }
    }

    private AdRequest(Builder builder) {
        this.b = new zzy(builder.f515a);
    }

    public zzy a() {
        return this.b;
    }
}
