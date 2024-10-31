package com.nexstreaming.kinemaster.ui.store.controller;

import android.support.v4.view.ViewPager;

/* compiled from: AudioPageFragment.java */
/* loaded from: classes2.dex */
class Na implements ViewPager.OnPageChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Oa f23468a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Na(Oa oa) {
        this.f23468a = oa;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f2, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        com.nexstreaming.kinemaster.ui.f.a.b.a().a(new com.nexstreaming.kinemaster.ui.f.a.a("RX_EVENT_STOP_PLAYER", null));
    }
}
