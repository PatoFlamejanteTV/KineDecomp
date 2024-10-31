package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.internal.customviews.CustomFontTabLayout;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.storage.controllers.C0432l;
import com.adobe.creativesdk.foundation.storage.AdobeAssetDataSourceType;
import com.facebook.internal.NativeProtocol;
import com.facebook.places.model.PlaceFields;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/* compiled from: AssetTabsFragment.java */
/* loaded from: classes.dex */
public class Ua extends Va {

    /* renamed from: b, reason: collision with root package name */
    private static int f5852b;

    /* renamed from: c, reason: collision with root package name */
    private ViewPager f5853c;

    /* renamed from: d, reason: collision with root package name */
    private c f5854d;

    /* renamed from: e, reason: collision with root package name */
    private CustomFontTabLayout f5855e;

    /* renamed from: f, reason: collision with root package name */
    private EnumSet<AdobeAssetDataSourceType> f5856f;

    /* renamed from: g, reason: collision with root package name */
    private ArrayList<a> f5857g;

    /* renamed from: h, reason: collision with root package name */
    private b f5858h;
    private AdobeCloud i;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AssetTabsFragment.java */
    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        C0432l.a f5859a;

        /* renamed from: b, reason: collision with root package name */
        String f5860b;

        private a() {
        }

        /* synthetic */ a(Ua ua, Ta ta) {
            this();
        }
    }

    /* compiled from: AssetTabsFragment.java */
    /* loaded from: classes.dex */
    private class b implements Observer {
        b() {
        }

        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            com.adobe.creativesdk.foundation.internal.notification.c cVar = (com.adobe.creativesdk.foundation.internal.notification.c) obj;
            if (cVar.a() == AdobeInternalNotificationID.AdobeDataSourceReady) {
                AdobeAssetDataSourceType adobeAssetDataSourceType = (AdobeAssetDataSourceType) cVar.b().get("DataSourceReady");
                a aVar = new a(Ua.this, null);
                aVar.f5860b = Ua.this.a(adobeAssetDataSourceType);
                Ua ua = Ua.this;
                aVar.f5859a = ua.a(adobeAssetDataSourceType, ua.getArguments());
                Ua.this.f5857g.add(aVar);
                Ua.this.f5854d.notifyDataSetChanged();
                Ua.this.C();
                Ua.this.f5855e.a(aVar.f5860b);
                return;
            }
            if (cVar.a() == AdobeInternalNotificationID.AdobeAppOrientationConfigurationChanged) {
                Ua.this.f5854d.notifyDataSetChanged();
                Ua.this.C();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AssetTabsFragment.java */
    /* loaded from: classes.dex */
    public class c extends FragmentPagerAdapter {

        /* renamed from: f, reason: collision with root package name */
        Map<Integer, Fragment> f5863f;

        public c(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.f5863f = new HashMap();
        }

        public Fragment a(int i) {
            return this.f5863f.get(Integer.valueOf(i));
        }

        @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            super.destroyItem(viewGroup, i, obj);
            this.f5863f.remove(Integer.valueOf(i));
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            if (Ua.this.f5857g != null) {
                return Ua.this.f5857g.size();
            }
            return 0;
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            Fragment fragment = null;
            try {
                C0432l.a aVar = ((a) Ua.this.f5857g.get(i)).f5859a;
                fragment = Fragment.instantiate(Ua.this.getActivity(), aVar.b().getName(), aVar.a());
                this.f5863f.put(Integer.valueOf(i), fragment);
                return fragment;
            } catch (Fragment.InstantiationException unused) {
                return fragment;
            }
        }

        @Override // android.support.v4.view.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return ((a) Ua.this.f5857g.get(i)).f5860b;
        }
    }

    public static int A() {
        return f5852b;
    }

    private EnumSet<AdobeAssetDataSourceType> B() {
        return C0432l.b(getArguments());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        this.f5855e.setTabMode(0);
        this.f5855e.setTabGravity(1);
        f5852b = this.f5855e.getSelectedTabPosition();
        this.f5855e.b(f5852b).h();
        com.adobe.creativesdk.foundation.internal.utils.u.a(this.f5855e);
    }

    private void D() {
        this.f5856f = B();
        this.f5857g = new ArrayList<>();
        if (this.i == null) {
            this.i = com.adobe.creativesdk.foundation.adobeinternal.cloud.d.e().c();
        }
        List<AdobeAssetDataSourceType> d2 = com.adobe.creativesdk.foundation.internal.storage.na.c().d();
        if (d2 == null) {
            d2 = new ArrayList<>();
        }
        Iterator it = this.f5856f.iterator();
        while (it.hasNext()) {
            AdobeAssetDataSourceType adobeAssetDataSourceType = (AdobeAssetDataSourceType) it.next();
            if (C0432l.a(adobeAssetDataSourceType, this.i) && !d2.contains(adobeAssetDataSourceType)) {
                a aVar = new a(this, null);
                aVar.f5860b = a(adobeAssetDataSourceType);
                aVar.f5859a = a(adobeAssetDataSourceType, getArguments());
                this.f5857g.add(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str) {
        String str2;
        String str3;
        HashMap<String, String> hashMap = new HashMap<String, String>() { // from class: com.adobe.creativesdk.foundation.internal.storage.controllers.AssetTabsFragment$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                put("area", "browser");
                put(NativeProtocol.WEB_DIALOG_ACTION, "view");
            }
        };
        if (str.equals(getResources().getString(c.a.a.a.b.i.adobe_csdk_uxassetbrowser_files))) {
            str2 = "files";
            str3 = "mobile.ccmobile.viewFiles";
        } else if (str.equals(getResources().getString(c.a.a.a.b.i.adobe_csdk_uxassetbrowser_photos))) {
            str2 = PlaceFields.PHOTOS_PROFILE;
            str3 = "mobile.ccmobile.viewPhotos";
        } else if (str.equals(getResources().getString(c.a.a.a.b.i.adobe_csdk_uxassetbrowser_psmix))) {
            str2 = "mix";
            str3 = "mobile.ccmobile.viewMix";
        } else if (str.equals(getResources().getString(c.a.a.a.b.i.adobe_csdk_uxassetbrowser_sketches))) {
            str2 = "sketch";
            str3 = "mobile.ccmobile.viewSketch";
        } else if (str.equals(getResources().getString(c.a.a.a.b.i.adobe_csdk_uxassetbrowser_lines))) {
            str2 = "line";
            str3 = "mobile.ccmobile.viewLine";
        } else if (str.equals(getResources().getString(c.a.a.a.b.i.adobe_csdk_uxassetbrowser_drawings))) {
            str2 = "draw";
            str3 = "mobile.ccmobile.viewDraw";
        } else if (str.equals(getResources().getString(c.a.a.a.b.i.adobe_csdk_uxassetbrowser_comps))) {
            str2 = "comp";
            str3 = "mobile.ccmobile.viewComp";
        } else {
            str2 = null;
            str3 = null;
        }
        hashMap.put("type", str2);
        com.adobe.creativesdk.foundation.internal.analytics.q.a(str3, hashMap, null);
    }

    private String n(int i) {
        return c.a.a.a.c.a.a.b().a().getResources().getString(i);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5854d = new c(getChildFragmentManager());
        this.i = (AdobeCloud) getArguments().getSerializable("ADOBE_CLOUD");
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(c.a.a.a.b.g.adobe_assetsview_datasource_tabs, viewGroup, false);
        Boolean valueOf = Boolean.valueOf(C0455p.b(getContext()));
        Va.f5872a = (CustomFontTabLayout) inflate.findViewById(c.a.a.a.b.e.adobe_csdk_tab_layout_loki);
        CustomFontTabLayout customFontTabLayout = (CustomFontTabLayout) inflate.findViewById(c.a.a.a.b.e.adobe_csdk_tab_layout);
        if (valueOf.booleanValue()) {
            this.f5855e = Va.f5872a;
            customFontTabLayout.setVisibility(8);
            Va.f5872a.setVisibility(0);
        } else {
            this.f5855e = customFontTabLayout;
            customFontTabLayout.setVisibility(0);
            Va.f5872a.setVisibility(8);
        }
        this.f5853c = (ViewPager) inflate.findViewById(c.a.a.a.b.e.adobe_csdk_view_pager);
        D();
        this.f5853c.setAdapter(this.f5854d);
        this.f5855e.setupWithViewPager(this.f5853c);
        com.adobe.creativesdk.foundation.internal.utils.u.a(this.f5855e);
        this.f5853c.addOnPageChangeListener(new Ta(this));
        if (bundle != null) {
            f5852b = bundle.getInt("currentTab");
        }
        this.f5855e.b(f5852b).h();
        this.f5858h = new b();
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeDataSourceReady, this.f5858h);
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeAppOrientationConfigurationChanged, this.f5858h);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeDataSourceReady, this.f5858h);
        com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeAppOrientationConfigurationChanged, this.f5858h);
        this.f5858h = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        if (fragments != null) {
            for (Fragment fragment : fragments) {
                if (fragment != null) {
                    fragment.onRequestPermissionsResult(i, strArr, iArr);
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("CurrentTab", f5852b);
    }

    public Fragment z() {
        return this.f5854d.a(A());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(AdobeAssetDataSourceType adobeAssetDataSourceType) {
        if (adobeAssetDataSourceType == AdobeAssetDataSourceType.AdobeAssetDataSourceFiles) {
            return n(c.a.a.a.b.i.adobe_csdk_uxassetbrowser_files);
        }
        if (adobeAssetDataSourceType == AdobeAssetDataSourceType.AdobeAssetDataSourcePhotos) {
            return n(c.a.a.a.b.i.adobe_csdk_uxassetbrowser_photos);
        }
        if (adobeAssetDataSourceType == AdobeAssetDataSourceType.AdobeAssetDataSourcePSMix) {
            return n(c.a.a.a.b.i.adobe_csdk_uxassetbrowser_psmix);
        }
        if (adobeAssetDataSourceType == AdobeAssetDataSourceType.AdobeAssetDataSourceLibrary) {
            return n(c.a.a.a.b.i.adobe_csdk_uxassetbrowser_designlibrary);
        }
        if (adobeAssetDataSourceType == AdobeAssetDataSourceType.AdobeAssetDataSourceSketches) {
            return n(c.a.a.a.b.i.adobe_csdk_uxassetbrowser_sketches);
        }
        if (adobeAssetDataSourceType == AdobeAssetDataSourceType.AdobeAssetDataSourceDraw) {
            return n(c.a.a.a.b.i.adobe_csdk_uxassetbrowser_drawings);
        }
        if (adobeAssetDataSourceType == AdobeAssetDataSourceType.AdobeAssetDataSourceCompositions) {
            return n(c.a.a.a.b.i.adobe_csdk_uxassetbrowser_comps);
        }
        return adobeAssetDataSourceType == AdobeAssetDataSourceType.AdobeAssetDataSourceMobileCreations ? n(c.a.a.a.b.i.adobe_csdk_uxassetbrowser_all_mobilecreations) : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C0432l.a a(AdobeAssetDataSourceType adobeAssetDataSourceType, Bundle bundle) {
        return C0432l.a(c.a.a.a.c.a.a.b().a(), adobeAssetDataSourceType, bundle, (com.adobe.creativesdk.foundation.internal.storage.model.resources.e) null);
    }
}
