package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.support.v4.app.Fragment;
import com.adobe.creativesdk.foundation.internal.customviews.CustomFontTabLayout;

/* compiled from: AssetViewBaseFragment.java */
/* loaded from: classes.dex */
public class Va extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    protected static CustomFontTabLayout f5872a;

    public void b(boolean z) {
        CustomFontTabLayout customFontTabLayout = f5872a;
        if (customFontTabLayout != null) {
            if (z) {
                customFontTabLayout.setVisibility(0);
            } else {
                customFontTabLayout.setVisibility(8);
            }
        }
    }
}
