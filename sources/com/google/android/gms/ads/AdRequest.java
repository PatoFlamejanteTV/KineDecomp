package com.google.android.gms.ads;

import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzyx;
import com.google.android.gms.internal.ads.zzyy;
import java.util.Date;

@VisibleForTesting
/* loaded from: classes.dex */
public final class AdRequest {

    /* renamed from: a */
    private final zzyx f9930a;

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        private final zzyy f9931a = new zzyy();

        public Builder() {
            this.f9931a.zzbe("B3EEABB8EE11C2BE770B684D95219ECB");
        }

        public final Builder a(String str) {
            this.f9931a.zzbd(str);
            return this;
        }

        public final Builder b(String str) {
            this.f9931a.zzbe(str);
            return this;
        }

        public final Builder a(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.f9931a.zza(cls, bundle);
            if (cls.equals(AdMobAdapter.class) && bundle.getBoolean("_emulatorLiveAds")) {
                this.f9931a.zzbf("B3EEABB8EE11C2BE770B684D95219ECB");
            }
            return this;
        }

        public final Builder b(boolean z) {
            this.f9931a.zzu(z);
            return this;
        }

        public final AdRequest a() {
            return new AdRequest(this);
        }

        @Deprecated
        public final Builder a(Date date) {
            this.f9931a.zza(date);
            return this;
        }

        @Deprecated
        public final Builder a(int i) {
            this.f9931a.zzch(i);
            return this;
        }

        public final Builder a(Location location) {
            this.f9931a.zzb(location);
            return this;
        }

        @Deprecated
        public final Builder a(boolean z) {
            this.f9931a.zzv(z);
            return this;
        }
    }

    private AdRequest(Builder builder) {
        this.f9930a = new zzyx(builder.f9931a);
    }

    public final zzyx a() {
        return this.f9930a;
    }

    /* synthetic */ AdRequest(Builder builder, b bVar) {
        this(builder);
    }
}
