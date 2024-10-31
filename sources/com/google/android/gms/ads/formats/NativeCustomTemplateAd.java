package com.google.android.gms.ads.formats;

/* loaded from: classes.dex */
public interface NativeCustomTemplateAd {

    /* loaded from: classes.dex */
    public interface OnCustomClickListener {
        void a(NativeCustomTemplateAd nativeCustomTemplateAd, String str);
    }

    /* loaded from: classes.dex */
    public interface OnCustomTemplateAdLoadedListener {
        void a(NativeCustomTemplateAd nativeCustomTemplateAd);
    }

    String getCustomTemplateId();
}
