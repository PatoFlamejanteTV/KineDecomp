package com.google.android.gms.ads.formats;

import android.os.Bundle;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;

/* loaded from: classes.dex */
public abstract class NativeContentAd extends NativeAd {

    /* loaded from: classes.dex */
    public interface OnContentAdLoadedListener {
        void a(NativeContentAd nativeContentAd);
    }

    public abstract CharSequence getAdvertiser();

    public abstract CharSequence getBody();

    public abstract CharSequence getCallToAction();

    public abstract Bundle getExtras();

    public abstract CharSequence getHeadline();

    public abstract List<NativeAd.Image> getImages();

    public abstract NativeAd.Image getLogo();
}
