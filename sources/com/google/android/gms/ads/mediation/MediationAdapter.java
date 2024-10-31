package com.google.android.gms.ads.mediation;

import android.os.Bundle;

/* loaded from: classes.dex */
public interface MediationAdapter {

    /* loaded from: classes.dex */
    public static class zza {

        /* renamed from: a */
        private int f10275a;

        public final zza a(int i) {
            this.f10275a = 1;
            return this;
        }

        public final Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putInt("capabilities", this.f10275a);
            return bundle;
        }
    }

    void onDestroy();

    void onPause();

    void onResume();
}
