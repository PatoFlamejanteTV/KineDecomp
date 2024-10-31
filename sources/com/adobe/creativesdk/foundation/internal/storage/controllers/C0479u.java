package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.view.View;

/* compiled from: AdobeDepthPageTransformer.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.u */
/* loaded from: classes.dex */
public class C0479u implements ViewPager.PageTransformer {
    @Override // android.support.v4.view.ViewPager.PageTransformer
    public void transformPage(View view, float f2) {
        int width = view.getWidth();
        if (f2 < -1.0f) {
            ViewCompat.setAlpha(view, 0.0f);
            return;
        }
        if (f2 <= 0.0f) {
            ViewCompat.setAlpha(view, 1.0f);
            ViewCompat.setTranslationX(view, 0.0f);
            ViewCompat.setScaleX(view, 1.0f);
            ViewCompat.setScaleY(view, 1.0f);
            return;
        }
        if (f2 <= 1.0f) {
            ViewCompat.setAlpha(view, 1.0f - f2);
            ViewCompat.setTranslationX(view, width * (-f2));
            float abs = ((1.0f - Math.abs(f2)) * 0.25f) + 0.75f;
            ViewCompat.setScaleX(view, abs);
            ViewCompat.setScaleY(view, abs);
            return;
        }
        ViewCompat.setAlpha(view, 0.0f);
    }
}
