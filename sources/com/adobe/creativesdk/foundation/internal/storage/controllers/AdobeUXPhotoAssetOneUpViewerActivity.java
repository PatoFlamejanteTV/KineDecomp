package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.R;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.AdobeOneUpViewDataType;
import com.adobe.creativesdk.foundation.storage.AdobePhotoAsset;
import com.adobe.creativesdk.foundation.storage.AdobePhotoAssetRendition;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes.dex */
public class AdobeUXPhotoAssetOneUpViewerActivity extends AbstractActivityC0427k implements InterfaceC0406fd {
    private F A;
    private com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.i B;
    private ImageButton z;

    /* loaded from: classes.dex */
    private class a extends ViewPager.SimpleOnPageChangeListener {
        private a() {
        }

        @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            AdobeUXPhotoAssetOneUpViewerActivity adobeUXPhotoAssetOneUpViewerActivity = AdobeUXPhotoAssetOneUpViewerActivity.this;
            adobeUXPhotoAssetOneUpViewerActivity.u = true;
            adobeUXPhotoAssetOneUpViewerActivity.f6156d = i;
            TextView textView = adobeUXPhotoAssetOneUpViewerActivity.k;
            if (textView != null) {
                textView.setText((AdobeUXPhotoAssetOneUpViewerActivity.this.f6156d + 1) + " " + AdobeUXPhotoAssetOneUpViewerActivity.this.getString(c.a.a.a.b.i.adobe_csdk_IDS_ASSET_VIEWER_OF) + " " + AdobeUXPhotoAssetOneUpViewerActivity.this.A.g());
            }
            AdobePhotoAsset b2 = AdobeUXPhotoAssetOneUpViewerActivity.this.A.b(AdobeUXPhotoAssetOneUpViewerActivity.this.f6156d);
            AdobeUXPhotoAssetOneUpViewerActivity.this.D();
            com.adobe.creativesdk.foundation.internal.utils.b.a(AdobeUXPhotoAssetOneUpViewerActivity.this.findViewById(R.id.content), b2.getName());
            AdobeUXPhotoAssetOneUpViewerActivity.this.C();
            if (AdobeUXPhotoAssetOneUpViewerActivity.this.f6156d >= r5.A.c() - 5) {
                AdobeUXPhotoAssetOneUpViewerActivity.this.A.j();
            }
        }

        /* synthetic */ a(AdobeUXPhotoAssetOneUpViewerActivity adobeUXPhotoAssetOneUpViewerActivity, Ga ga) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public class b extends FragmentStatePagerAdapter {

        /* renamed from: h, reason: collision with root package name */
        protected c f5575h;

        public b(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return AdobeUXPhotoAssetOneUpViewerActivity.this.A.c();
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            return c.m(i);
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            if (this.f5575h != obj) {
                this.f5575h = (c) obj;
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    /* loaded from: classes.dex */
    public static class c extends Fragment {

        /* renamed from: a, reason: collision with root package name */
        int f5576a;

        static c m(int i) {
            c cVar = new c();
            Bundle bundle = new Bundle();
            bundle.putInt("num", i);
            cVar.setArguments(bundle);
            return cVar;
        }

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            this.f5576a = getArguments() != null ? getArguments().getInt("num") : 1;
        }

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View inflate = layoutInflater.inflate(c.a.a.a.b.g.fragment_photo_image, viewGroup, false);
            View findViewById = inflate.findViewById(c.a.a.a.b.e.adobe_csdk_photo_image_view);
            View findViewById2 = inflate.findViewById(c.a.a.a.b.e.adobe_csdk_photo_viewer_no_internet_connection);
            View findViewById3 = inflate.findViewById(c.a.a.a.b.e.adobe_csdk_photo_viewer_no_preview);
            ProgressBar progressBar = (ProgressBar) inflate.findViewById(c.a.a.a.b.e.adobe_csdk_photo_image_progressbar_new);
            progressBar.setVisibility(0);
            AdobeUXPhotoAssetOneUpViewerActivity adobeUXPhotoAssetOneUpViewerActivity = (AdobeUXPhotoAssetOneUpViewerActivity) getActivity();
            AdobePhotoAsset b2 = adobeUXPhotoAssetOneUpViewerActivity.A.b(this.f5576a);
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            com.adobe.creativesdk.foundation.internal.utils.photoview.g gVar = new com.adobe.creativesdk.foundation.internal.utils.photoview.g((ImageView) findViewById);
            gVar.a(new Ma(this, adobeUXPhotoAssetOneUpViewerActivity));
            La la = new La(this);
            if (adobeUXPhotoAssetOneUpViewerActivity.B.c()) {
                gVar.a(la);
            }
            Na na = new Na(this, findViewById, findViewById2, findViewById3, progressBar);
            Oa oa = new Oa(this, na, displayMetrics, findViewById, progressBar);
            if (AbstractActivityC0427k.y()) {
                na.a();
                Map<String, AdobePhotoAssetRendition> renditions = b2.getRenditions();
                if (renditions.get(AdobePhotoAsset.AdobePhotoAssetRenditionImage2048) != null) {
                    b2.downloadRendition(renditions.get(AdobePhotoAsset.AdobePhotoAssetRenditionImage2048), oa);
                } else if (renditions.get(AdobePhotoAsset.AdobePhotoAssetRenditionImage1024) != null) {
                    b2.downloadRendition(renditions.get(AdobePhotoAsset.AdobePhotoAssetRenditionImage1024), oa);
                } else if (renditions.get(AdobePhotoAsset.AdobePhotoAssetRenditionImageThumbnail2x) != null) {
                    b2.downloadRendition(renditions.get(AdobePhotoAsset.AdobePhotoAssetRenditionImageThumbnail2x), oa);
                } else if (renditions.get(AdobePhotoAsset.AdobePhotoAssetRenditionImageThumbnail) != null) {
                    b2.downloadRendition(renditions.get(AdobePhotoAsset.AdobePhotoAssetRenditionImageThumbnail), oa);
                } else {
                    oa.b(null);
                }
            } else {
                na.a(true);
            }
            ((AdobeUXPhotoAssetOneUpViewerActivity) getActivity()).C();
            return inflate;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        int i = this.f6156d;
        AdobePhotoAsset b2 = this.A.b(i);
        Ka ka = new Ka(this, i, b2);
        String a2 = a(b2);
        if (new File(this.f6157e, a2 + ".png").exists()) {
            if (this.B.c()) {
                return;
            }
            a(i, true);
            return;
        }
        this.A.a(b2, ka);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        AdobePhotoAsset b2 = this.A.b(this.f6156d);
        if (this.z != null) {
            if (this.A.b(b2)) {
                this.z.setSelected(true);
            } else {
                this.z.setSelected(false);
            }
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k
    protected void A() {
        if (!this.B.c()) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0406fd
    public void f() {
        this.f6158f.notifyDataSetChanged();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0406fd
    public void h() {
        String format;
        int e2 = this.A.e();
        if (e2 < 1) {
            format = com.adobe.creativesdk.foundation.internal.utils.l.b(c.a.a.a.b.i.adobe_csdk_storage_open_files);
        } else if (e2 > 99) {
            format = com.adobe.creativesdk.foundation.internal.utils.l.b(c.a.a.a.b.i.adobe_csdk_storage_open_multiple_files_99);
        } else {
            format = String.format(com.adobe.creativesdk.foundation.internal.utils.l.b(c.a.a.a.b.i.adobe_csdk_storage_open_multiple_files), Integer.toString(e2));
        }
        this.f6160h.setText(format);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0406fd
    @SuppressLint({"InlinedApi"})
    public void k() {
        w();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k, com.adobe.creativesdk.foundation.internal.base.AdobeTOUHandlerActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c.a.a.a.c.a.a.b().a(getApplicationContext());
        if (!this.A.h()) {
            finish();
            return;
        }
        F f2 = this.A;
        F.a(this);
        this.f6158f = new b(getSupportFragmentManager());
        this.f6159g = (ViewPager) findViewById(c.a.a.a.b.e.adobe_csdk_library_item_pager);
        this.f6159g.setAdapter(this.f6158f);
        this.f6159g.setOnPageChangeListener(new a(this, null));
        this.f6159g.setPageTransformer(true, new C0479u());
        this.f6157e = new File(getFilesDir(), "adobeassetviewerimages");
        if (!this.f6157e.exists()) {
            this.f6157e.mkdirs();
        }
        this.i.setOnClickListener(new Ga(this));
        this.z = (ImageButton) findViewById(c.a.a.a.b.e.adobe_csdk_library_items_image_selectbtn);
        d(true);
        this.f6156d = this.A.f();
        this.f6159g.setCurrentItem(this.f6156d, false);
        com.adobe.creativesdk.foundation.internal.utils.b.a(findViewById(R.id.content), this.A.b(this.f6156d).getName());
        this.k.setText((this.f6156d + 1) + " " + getString(c.a.a.a.b.i.adobe_csdk_IDS_ASSET_VIEWER_OF) + " " + this.A.g());
        if (!this.B.c()) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
        if (!this.B.c() && this.A.i()) {
            this.z.setVisibility(0);
        } else {
            this.z.setVisibility(8);
        }
        D();
        this.z.setOnClickListener(new Ha(this));
        h();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        View inflate;
        if (!this.A.h()) {
            return super.onCreateOptionsMenu(menu);
        }
        if (this.B.c() && this.B.b() != -1) {
            getMenuInflater().inflate(this.B.b(), menu);
            for (int i = 0; i < menu.size(); i++) {
                menu.getItem(i).setTitle(c(menu.getItem(i).getTitle().toString()));
                Integer a2 = this.B.a(menu.getItem(i).getItemId());
                if (a2 != null && (inflate = getLayoutInflater().inflate(a2.intValue(), (ViewGroup) null)) != null) {
                    menu.getItem(i).setActionView(inflate);
                    this.B.a(menu.getItem(i).getItemId(), inflate);
                    inflate.setOnClickListener(new Ia(this, menu, i, this));
                }
            }
        } else {
            C();
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k, com.adobe.creativesdk.foundation.internal.base.AdobeTOUHandlerActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        com.adobe.creativesdk.foundation.adobeinternal.net.a.a();
        try {
            if (this.f6157e != null) {
                org.apache.commons.io.b.b(this.f6157e);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        super.onDestroy();
        this.A.k();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            return true;
        }
        if (this.B.a() != null) {
            com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.a aVar = new com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.a();
            aVar.a(this.A.b(this.f6156d));
            aVar.a(AdobeOneUpViewDataType.ADOBE_ONE_UP_VIEW_DATA_TYPE_PHOTOS);
            this.B.a().a(menuItem.getItemId(), aVar, this, (AdobeCloud) null);
        }
        return true;
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        F f2 = this.A;
        F.c(this.f6156d);
        bundle.putInt("ASSET_ONE_UP_ACTIVITY", this.f6156d);
        super.onSaveInstanceState(bundle);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k
    protected String s() {
        return this.A.b(this.f6156d).getName();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k
    protected ViewPager.SimpleOnPageChangeListener t() {
        return new a(this, null);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k
    protected File u() {
        String a2 = a(this.A.b(this.f6156d));
        return new File(this.f6157e, a2 + ".png");
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k
    protected void x() {
        this.B = (com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.i) this.r.a("ADOBE_ONE_UP_VIEW_PHOTO_CONFIGURATION");
        this.A = F.a(this.B.e(), this.B.d());
        this.s = this.B;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k
    protected void d(boolean z) {
        if (this.B.c() || !this.A.i()) {
            return;
        }
        if (z) {
            this.z.setVisibility(0);
        } else {
            this.z.setVisibility(4);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k, com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0406fd
    @SuppressLint({"InlinedApi"})
    public void e() {
        w();
    }

    public void a(int i, boolean z) {
        View view = this.i;
        if (view == null || i != this.f6156d) {
            return;
        }
        view.setEnabled(z);
        this.z.setEnabled(z);
        if (!z && this.z.isSelected()) {
            AdobePhotoAsset b2 = this.A.b(this.f6156d);
            this.z.setSelected(false);
            this.A.c(b2);
        }
        if (z) {
            ViewCompat.setAlpha(this.i, 1.0f);
        } else {
            ViewCompat.setAlpha(this.i, 0.5f);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0406fd
    public int d() {
        return this.f6156d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(AdobePhotoAsset adobePhotoAsset) {
        String guid = adobePhotoAsset.getGUID();
        if (guid != null && guid.length() != 0) {
            String[] split = guid.split("/");
            if (split.length > 1) {
                return split[split.length - 1];
            }
            return split[0];
        }
        return adobePhotoAsset.getName().replace(".", io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR);
    }
}
