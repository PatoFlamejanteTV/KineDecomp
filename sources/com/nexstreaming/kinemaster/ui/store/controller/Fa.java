package com.nexstreaming.kinemaster.ui.store.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.nexstreaming.app.kinemasterfree.R;
import java.util.ArrayList;

/* compiled from: AssetDetailPreviewImageListFragment.java */
/* loaded from: classes2.dex */
public class Fa extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    private ViewPager f23435a;

    /* renamed from: b, reason: collision with root package name */
    private ImageView f23436b;

    /* renamed from: c, reason: collision with root package name */
    private Da f23437c;

    /* renamed from: d, reason: collision with root package name */
    private int f23438d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<String> f23439e;

    public static Fragment a(int i, ArrayList<String> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putInt("position", i);
        bundle.putStringArrayList("thumbnails", arrayList);
        Fa fa = new Fa();
        fa.setArguments(bundle);
        return fa;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f23438d = getArguments().getInt("position");
        this.f23439e = getArguments().getStringArrayList("thumbnails");
        this.f23437c = new Da(this.f23439e);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.nexstreaming.kinemaster.usage.analytics.b.a(Fa.class.getName());
        View inflate = layoutInflater.inflate(R.layout.fragment_asset_detail_thumbnails, (ViewGroup) null);
        a(inflate);
        inflate.setOnClickListener(null);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f23435a.setAdapter(this.f23437c);
        this.f23435a.setCurrentItem(this.f23438d);
    }

    private void a(View view) {
        this.f23435a = (ViewPager) view.findViewById(R.id.vp_fragment_asset_detail_thumb);
        this.f23436b = (ImageView) view.findViewById(R.id.iv_fragment_asset_detail_thumb_close);
        this.f23436b.setOnClickListener(new Ea(this));
    }
}
