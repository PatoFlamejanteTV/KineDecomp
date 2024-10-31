package com.nexstreaming.kinemaster.ui.store.controller;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;
import java.util.List;

/* compiled from: AudioPageAssetListPagerAdapter.java */
/* loaded from: classes2.dex */
public class Ma extends FragmentPagerAdapter {

    /* renamed from: f, reason: collision with root package name */
    private List<com.nexstreaming.kinemaster.network.m> f23465f;

    /* renamed from: g, reason: collision with root package name */
    private SparseArray<Fragment> f23466g;

    public Ma(FragmentManager fragmentManager, List<com.nexstreaming.kinemaster.network.m> list) {
        super(fragmentManager);
        this.f23466g = new SparseArray<>();
        this.f23465f = list;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.f23466g.remove(i);
        super.destroyItem(viewGroup, i, obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.f23465f.size();
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return La.a(this.f23465f.get(i));
    }

    @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Fragment fragment = (Fragment) super.instantiateItem(viewGroup, i);
        this.f23466g.put(i, fragment);
        return fragment;
    }
}
