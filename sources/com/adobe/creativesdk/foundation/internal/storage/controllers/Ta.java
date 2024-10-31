package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.support.v4.view.ViewPager;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetTabsFragment.java */
/* loaded from: classes.dex */
public class Ta implements ViewPager.OnPageChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Ua f5847a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ta(Ua ua) {
        this.f5847a = ua;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f2, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        ViewPager viewPager;
        int unused = Ua.f5852b = i;
        Ua ua = this.f5847a;
        viewPager = ua.f5853c;
        ua.f(viewPager.getAdapter().getPageTitle(i).toString());
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(new com.adobe.creativesdk.foundation.internal.notification.c(AdobeInternalNotificationID.AdobeUxTabDataSourceChanged, null));
    }
}
