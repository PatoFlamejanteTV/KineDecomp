package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.storage.asset.AdobeAssetCompPage;
import com.adobe.creativesdk.foundation.internal.storage.asset.AdobeAssetPSMixPage;
import com.adobe.creativesdk.foundation.internal.storage.asset.AdobeAssetSketchbookPage;
import com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.AdobeOneUpViewDataType;
import com.adobe.creativesdk.foundation.internal.storage.controllers.commands.AdobeAssetViewBrowserCommandName;
import com.adobe.creativesdk.foundation.internal.utils.photoview.PhotoView;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFileRenditionType;
import com.adobe.creativesdk.foundation.storage.C0533a;
import com.adobe.creativesdk.foundation.storage.C0582ma;
import java.io.File;
import java.io.IOException;
import java.util.Observer;

/* loaded from: classes.dex */
public class AdobeUXMobilePackageItemOneUpViewerActivity extends AbstractActivityC0427k {
    com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.h A;
    ud B;
    Observer z = null;

    /* loaded from: classes.dex */
    public class a extends FragmentStatePagerAdapter {
        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return AdobeUXMobilePackageItemOneUpViewerActivity.this.B.a();
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            return b.m(i);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends Fragment {

        /* renamed from: a, reason: collision with root package name */
        private int f5563a;

        /* renamed from: b, reason: collision with root package name */
        private RelativeLayout f5564b;

        /* renamed from: c, reason: collision with root package name */
        private ProgressBar f5565c;

        /* renamed from: d, reason: collision with root package name */
        private View f5566d;

        /* renamed from: e, reason: collision with root package name */
        private View f5567e;

        /* renamed from: f, reason: collision with root package name */
        d f5568f;

        /* renamed from: g, reason: collision with root package name */
        a f5569g;

        /* JADX INFO: Access modifiers changed from: protected */
        /* loaded from: classes.dex */
        public class a {
            protected a() {
            }

            public void a(Menu menu) {
            }

            public void a(Menu menu, MenuInflater menuInflater) {
            }

            protected boolean a(int i) {
                return false;
            }

            public boolean a(MenuItem menuItem) {
                return a(menuItem.getItemId());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(boolean z) {
            this.f5565c.setVisibility(z ? 0 : 8);
        }

        public static Fragment m(int i) {
            b bVar = new b();
            Bundle bundle = new Bundle();
            bundle.putInt("indexPos", i);
            bVar.setArguments(bundle);
            return bVar;
        }

        private void n(int i) {
            a(((AdobeUXMobilePackageItemOneUpViewerActivity) getActivity()).B.a(i));
        }

        protected a A() {
            if (this.f5569g == null) {
                this.f5569g = z();
            }
            return this.f5569g;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void B() {
            this.f5564b.setVisibility(0);
            this.f5566d.setVisibility(8);
            this.f5567e.setVisibility(8);
        }

        void b(boolean z) {
            this.f5564b.setVisibility(8);
            if (z) {
                this.f5566d.setVisibility(0);
                this.f5567e.setVisibility(8);
            } else {
                this.f5566d.setVisibility(8);
                this.f5567e.setVisibility(0);
            }
            c(false);
        }

        @Override // android.support.v4.app.Fragment
        public void onAttach(Activity activity) {
            super.onAttach(activity);
        }

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setHasOptionsMenu(true);
            this.f5563a = getArguments() != null ? getArguments().getInt("indexPos") : -1;
        }

        @Override // android.support.v4.app.Fragment
        public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
            A().a(menu, menuInflater);
            super.onCreateOptionsMenu(menu, menuInflater);
        }

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View inflate = layoutInflater.inflate(c.a.a.a.b.g.mobilepackage_item_fragment, viewGroup, false);
            this.f5564b = (RelativeLayout) inflate.findViewById(c.a.a.a.b.e.adobe_csdk_mobilepackage_item_fragment_content_container);
            this.f5566d = inflate.findViewById(c.a.a.a.b.e.adobe_csdk_mobilepackage_item_no_internet_connection);
            this.f5567e = inflate.findViewById(c.a.a.a.b.e.adobe_csdk_mobilepackage_item_no_preview);
            this.f5565c = (ProgressBar) inflate.findViewById(c.a.a.a.b.e.adobe_csdk_mobilepackage_item_progressbar_new);
            c(true);
            if (AbstractActivityC0427k.y()) {
                B();
                n(this.f5563a);
            } else {
                b(true);
            }
            return inflate;
        }

        @Override // android.support.v4.app.Fragment
        public boolean onOptionsItemSelected(MenuItem menuItem) {
            if (A().a(menuItem)) {
                return true;
            }
            if (menuItem.getItemId() == 16908332) {
                C0358a.a().a(AdobeAssetViewBrowserCommandName.NAVIGATE_BACK, (Object) null);
                return true;
            }
            return super.onOptionsItemSelected(menuItem);
        }

        @Override // android.support.v4.app.Fragment
        public void onPrepareOptionsMenu(Menu menu) {
            super.onPrepareOptionsMenu(menu);
            A().a(menu);
        }

        protected a z() {
            return new a();
        }

        private void a(AdobeAssetFile adobeAssetFile) {
            PhotoView photoView = new PhotoView(getActivity());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            photoView.setLayoutParams(layoutParams);
            com.adobe.creativesdk.foundation.internal.utils.photoview.g gVar = new com.adobe.creativesdk.foundation.internal.utils.photoview.g(photoView);
            gVar.a(new Da(this));
            Ca ca = new Ca(this);
            if (((AdobeUXMobilePackageItemOneUpViewerActivity) getActivity()).A.c()) {
                gVar.a(ca);
            }
            adobeAssetFile.getRenditionWithType(AdobeAssetFileRenditionType.ADOBE_ASSET_FILE_RENDITION_TYPE_PNG, new C0582ma(1024.0f, 1024.0f), new Fa(this, photoView));
            this.f5564b.addView(photoView);
        }
    }

    /* loaded from: classes.dex */
    class c extends ViewPager.SimpleOnPageChangeListener {
        c() {
        }

        @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            AdobeUXMobilePackageItemOneUpViewerActivity adobeUXMobilePackageItemOneUpViewerActivity = AdobeUXMobilePackageItemOneUpViewerActivity.this;
            adobeUXMobilePackageItemOneUpViewerActivity.u = true;
            adobeUXMobilePackageItemOneUpViewerActivity.f6156d = i;
            adobeUXMobilePackageItemOneUpViewerActivity.D();
            AdobeUXMobilePackageItemOneUpViewerActivity.this.B();
        }
    }

    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public int f5572a;

        /* renamed from: b, reason: collision with root package name */
        public int f5573b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        if (this.z != null) {
            com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeMobilePackageOneUpControllerInitialized, this.z);
            this.z = null;
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k
    protected void A() {
        if (!this.A.c()) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B() {
        if (this.A.c()) {
            AdobeAssetFile a2 = this.B.a(this.f6156d);
            Ba ba = new Ba(this, a2);
            String a3 = a(a2);
            if (new File(this.f6157e, a3 + ".png").exists()) {
                return;
            }
            a2.getRenditionWithType(AdobeAssetFileRenditionType.ADOBE_ASSET_FILE_RENDITION_TYPE_PNG, new C0582ma(0.0f, 0.0f), ba);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C() {
        this.f6158f = new a(getSupportFragmentManager());
        this.f6159g.setAdapter(this.f6158f);
        this.f6156d = this.B.c();
        this.f6159g.setCurrentItem(this.f6156d, false);
        D();
    }

    protected void D() {
        if (this.k != null) {
            this.k.setText(String.format(getString(c.a.a.a.b.i.adobe_csdk_IDS_ASSET_VIEWER_OF_2), Integer.valueOf(this.f6156d + 1), Integer.valueOf(this.B.a())));
        }
        AdobeAssetFile a2 = this.B.a(this.f6156d);
        String b2 = com.adobe.creativesdk.foundation.internal.utils.l.b(c.a.a.a.b.i.adobe_csdk_lineordrawcollection_singular);
        if (a2 instanceof AdobeAssetSketchbookPage) {
            b2 = com.adobe.creativesdk.foundation.internal.utils.l.b(c.a.a.a.b.i.adobe_csdk_sketchCollection_singular);
        } else if (a2 instanceof AdobeAssetCompPage) {
            b2 = com.adobe.creativesdk.foundation.internal.utils.l.b(c.a.a.a.b.i.adobe_csdk_composition_collection_singular);
        } else if (a2 instanceof AdobeAssetPSMixPage) {
            b2 = com.adobe.creativesdk.foundation.internal.utils.l.b(c.a.a.a.b.i.adobe_csdk_psmix_collection_singular);
        }
        if (a2 != null) {
            d(b2);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k
    protected void d(boolean z) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k, com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0406fd
    public void e() {
        w();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k, com.adobe.creativesdk.foundation.internal.base.AdobeTOUHandlerActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.i.setOnClickListener(new ViewOnClickListenerC0502za(this));
        a(bundle);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        View inflate;
        if (!this.A.c() || this.A.b() == -1) {
            return true;
        }
        getMenuInflater().inflate(this.A.b(), menu);
        for (int i = 0; i < menu.size(); i++) {
            menu.getItem(i).setTitle(c(menu.getItem(i).getTitle().toString()));
            Integer a2 = this.A.a(menu.getItem(i).getItemId());
            if (a2 != null && (inflate = getLayoutInflater().inflate(a2.intValue(), (ViewGroup) null)) != null) {
                menu.getItem(i).setActionView(inflate);
                this.A.a(menu.getItem(i).getItemId(), inflate);
                inflate.setOnClickListener(new ViewOnClickListenerC0498ya(this, menu, i, this));
            }
        }
        return true;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k, com.adobe.creativesdk.foundation.internal.base.AdobeTOUHandlerActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        E();
        com.adobe.creativesdk.foundation.adobeinternal.net.a.a();
        try {
            if (this.f6157e != null) {
                org.apache.commons.io.b.b(this.f6157e);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        synchronized (AdobeUXMobilePackageItemOneUpViewerActivity.class) {
            AbstractActivityC0427k.f6155c = null;
        }
        super.onDestroy();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            return true;
        }
        AdobeAssetFile a2 = this.B.a(this.f6156d);
        if (this.A.a() != null) {
            com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.a aVar = new com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.a();
            aVar.a(a2);
            aVar.a(AdobeOneUpViewDataType.ADOBE_ONE_UP_VIEW_DATA_TYPE_MOBILE_CREATION);
            this.A.a().a(menuItem.getItemId(), aVar, this, (AdobeCloud) null);
        }
        return true;
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        super.onSaveInstanceState(bundle, persistableBundle);
        this.B.b(bundle);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k
    protected String s() {
        return this.B.a(this.f6156d).getName();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k
    protected ViewPager.SimpleOnPageChangeListener t() {
        return new c();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k
    protected File u() {
        String a2 = a(this.B.a(this.f6156d));
        return new File(this.f6157e, a2 + ".png");
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k
    protected void x() {
        this.A = (com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.h) this.r.a("ADOBE_ONE_UP_VIEW_MOBILE_CREATION_CONFIGURATION");
        this.B = ud.a(this.A.d(), this.A.e(), this.A.f());
        this.s = this.A;
    }

    protected void a(Bundle bundle) {
        if (this.B != null) {
            C();
            return;
        }
        this.z = new C0494xa(this);
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeMobilePackageOneUpControllerInitialized, this.z);
        this.B = ud.a(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(C0533a c0533a) {
        String guid = c0533a.getGUID();
        if (guid != null && guid.length() != 0) {
            String[] split = guid.split("/");
            if (split.length > 1) {
                return split[split.length - 1];
            }
            return split[0];
        }
        return c0533a.getName().replace(".", io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR);
    }
}
