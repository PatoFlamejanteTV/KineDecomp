package com.nexstreaming.kinemaster.ui.store.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.network.InterfaceC1822k;
import com.nexstreaming.kinemaster.ui.store.model.Category;
import com.nexstreaming.kinemaster.ui.store.view.AssetListViewPager;

/* compiled from: AudioPageFragment.java */
/* loaded from: classes2.dex */
public class Oa extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    private ListView f23470a;

    /* renamed from: b, reason: collision with root package name */
    private AssetListViewPager f23471b;

    /* renamed from: c, reason: collision with root package name */
    private Category f23472c;

    /* renamed from: d, reason: collision with root package name */
    private int f23473d = 0;

    public static Oa a(InterfaceC1822k interfaceC1822k, int i) {
        Oa oa = new Oa();
        Bundle bundle = new Bundle();
        bundle.putSerializable("KEY_CATEGORY", new Category(interfaceC1822k));
        bundle.putInt("SUB_CATEGORY_LIST_POSITION", i);
        oa.setArguments(bundle);
        return oa;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.nexstreaming.kinemaster.usage.analytics.b.a(Oa.class.getName());
        View inflate = layoutInflater.inflate(R.layout.fragment_audio_category, viewGroup, false);
        this.f23472c = (Category) getArguments().getSerializable("KEY_CATEGORY");
        this.f23473d = getArguments().getInt("SUB_CATEGORY_LIST_POSITION");
        this.f23471b = (AssetListViewPager) inflate.findViewById(R.id.asset_list_view_pager);
        this.f23471b.setAdapter(new Ma(getChildFragmentManager(), this.f23472c.getSubCategories()));
        this.f23471b.setOffscreenPageLimit(this.f23472c.getSubCategories().size());
        this.f23471b.addOnPageChangeListener(new Na(this));
        this.f23471b.postOnAnimation(new Runnable() { // from class: com.nexstreaming.kinemaster.ui.store.controller.K
            @Override // java.lang.Runnable
            public final void run() {
                Oa.this.z();
            }
        });
        Pa pa = new Pa(this.f23472c.getSubCategories());
        this.f23470a = (ListView) inflate.findViewById(R.id.subCategoryList);
        this.f23470a.setAdapter((ListAdapter) pa);
        this.f23470a.setSelection(this.f23473d);
        this.f23470a.setItemChecked(this.f23473d, true);
        this.f23470a.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.J
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                Oa.this.a(adapterView, view, i, j);
            }
        });
        return inflate;
    }

    public /* synthetic */ void z() {
        this.f23471b.setCurrentItem(this.f23473d);
    }

    public /* synthetic */ void a(AdapterView adapterView, View view, int i, long j) {
        this.f23471b.setCurrentItem(i);
    }
}
