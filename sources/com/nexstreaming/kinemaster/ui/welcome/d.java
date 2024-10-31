package com.nexstreaming.kinemaster.ui.welcome;

import android.support.v4.view.ViewPager;

/* compiled from: WelcomeFragment.kt */
/* loaded from: classes2.dex */
public final class d implements ViewPager.OnPageChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f23702a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f23702a = cVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f2, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        g B;
        this.f23702a.f23698e = i;
        B = this.f23702a.B();
        B.a(i);
    }
}
