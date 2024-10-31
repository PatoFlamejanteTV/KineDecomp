package com.nexstreaming.kinemaster.ui.store.controller;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.nexstreaming.kinemaster.network.InterfaceC1822k;
import com.nexstreaming.kinemaster.network.ViewType;
import java.util.List;

/* compiled from: SubPagerAdapter.java */
/* loaded from: classes2.dex */
public class qb extends FragmentPagerAdapter {

    /* renamed from: f, reason: collision with root package name */
    private List<InterfaceC1822k> f23611f;

    /* renamed from: g, reason: collision with root package name */
    private int f23612g;

    /* renamed from: h, reason: collision with root package name */
    SparseArray<Fragment> f23613h;

    public qb(FragmentManager fragmentManager, List<InterfaceC1822k> list, int i) {
        super(fragmentManager);
        this.f23612g = 0;
        this.f23613h = new SparseArray<>();
        this.f23611f = list;
        this.f23612g = i;
    }

    public Fragment a(int i) {
        return this.f23613h.get(i);
    }

    @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.f23613h.remove(i);
        super.destroyItem(viewGroup, i, obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.f23611f.size();
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        InterfaceC1822k interfaceC1822k = this.f23611f.get(i);
        int categoryIdx = interfaceC1822k.getCategoryIdx();
        ViewType viewType = interfaceC1822k.getViewType();
        if (i == 0) {
            return Sa.z();
        }
        if (viewType == ViewType.AUDIO) {
            return Oa.a(interfaceC1822k, this.f23612g);
        }
        return _a.c(categoryIdx, this.f23612g);
    }

    @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Fragment fragment = (Fragment) super.instantiateItem(viewGroup, i);
        this.f23613h.put(i, fragment);
        return fragment;
    }
}
