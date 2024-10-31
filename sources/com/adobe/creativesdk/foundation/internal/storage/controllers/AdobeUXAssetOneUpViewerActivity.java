package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.AdobeOneUpViewDataType;
import com.adobe.creativesdk.foundation.internal.storage.controllers.a.c;
import com.adobe.creativesdk.foundation.internal.storage.controllers.multipage.AdobeMultiPageViewState;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFileRenditionType;
import com.adobe.creativesdk.foundation.storage.C0533a;
import com.adobe.creativesdk.foundation.storage.C0582ma;
import java.io.File;
import java.io.IOException;
import java.util.Observer;

/* loaded from: classes.dex */
public class AdobeUXAssetOneUpViewerActivity extends AbstractActivityC0427k implements InterfaceC0406fd {
    private static AdobeAssetFile A = null;
    private static boolean z = false;
    private ImageButton B;
    private com.adobe.creativesdk.foundation.internal.storage.controllers.a.f C;
    private AdobeCloud D;
    protected C0469s E;
    protected com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.f F;
    private Menu G;
    private boolean H = false;
    private int I = -1;
    private boolean J = false;

    /* loaded from: classes.dex */
    public class a extends FragmentStatePagerAdapter {

        /* renamed from: h, reason: collision with root package name */
        protected b f5529h;

        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public b b() {
            return this.f5529h;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return AdobeUXAssetOneUpViewerActivity.this.E.b();
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            return b.m(i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            if (this.f5529h != obj) {
                this.f5529h = (b) obj;
            }
            super.setPrimaryItem(viewGroup, i, obj);
        }
    }

    /* loaded from: classes.dex */
    private class c extends ViewPager.SimpleOnPageChangeListener {
        private c() {
        }

        @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            AdobeUXAssetOneUpViewerActivity adobeUXAssetOneUpViewerActivity = AdobeUXAssetOneUpViewerActivity.this;
            adobeUXAssetOneUpViewerActivity.u = true;
            adobeUXAssetOneUpViewerActivity.D();
            AdobeUXAssetOneUpViewerActivity.this.b(i);
        }

        /* synthetic */ c(AdobeUXAssetOneUpViewerActivity adobeUXAssetOneUpViewerActivity, V v) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private class d implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        private Activity f5536a;

        public d(Activity activity) {
            this.f5536a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == AdobeUXAssetOneUpViewerActivity.this.m.getId()) {
                AdobeUXAssetOneUpViewerActivity.this.F.b(id);
            } else if (id == AdobeUXAssetOneUpViewerActivity.this.o.getId()) {
                AdobeUXAssetOneUpViewerActivity.this.F.c(id);
            } else {
                if (id == AdobeUXAssetOneUpViewerActivity.this.p.getId()) {
                    AdobeUXAssetOneUpViewerActivity.this.H = true;
                    Intent v = AdobeUXAssetOneUpViewerActivity.this.v();
                    if (v != null) {
                        AdobeUXAssetOneUpViewerActivity.this.startActivity(v);
                        return;
                    }
                    return;
                }
                AdobeUXAssetOneUpViewerActivity.this.F.d(id);
            }
            if (AdobeUXAssetOneUpViewerActivity.this.F.a() != null) {
                AdobeUXAssetOneUpViewerActivity adobeUXAssetOneUpViewerActivity = AdobeUXAssetOneUpViewerActivity.this;
                AdobeAssetFile adobeAssetFile = (AdobeAssetFile) adobeUXAssetOneUpViewerActivity.E.a(adobeUXAssetOneUpViewerActivity.f6156d);
                com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.a aVar = new com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.a();
                aVar.a(adobeAssetFile);
                aVar.a(AdobeOneUpViewDataType.ADOBE_ONE_UP_VIEW_DATA_TYPE_FILES);
                AdobeUXAssetOneUpViewerActivity.this.F.a().a(id, aVar, this.f5536a, AdobeUXAssetOneUpViewerActivity.this.D);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        ImageView imageView = this.q;
        if (imageView != null) {
            imageView.setColorFilter(ContextCompat.getColor(getApplicationContext(), c.a.a.a.b.b.adobe_csdk_one_up_view_share_button_disabled_color));
        }
        RelativeLayout relativeLayout = this.p;
        if (relativeLayout != null) {
            relativeLayout.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        ImageView imageView = this.q;
        if (imageView != null) {
            imageView.setColorFilter(ContextCompat.getColor(getApplicationContext(), c.a.a.a.b.b.adobe_csdk_one_up_view_share_button_enabled_color));
        }
        RelativeLayout relativeLayout = this.p;
        if (relativeLayout != null) {
            relativeLayout.setClickable(true);
        }
    }

    private void F() {
        if (this.G != null) {
            for (int i = 0; i < this.G.size(); i++) {
                this.G.getItem(i).setVisible(false);
            }
        }
    }

    private void G() {
        ImageView imageView = (ImageView) this.m.findViewById(c.a.a.a.b.e.comments_bottombar);
        TextView textView = (TextView) findViewById(c.a.a.a.b.e.adobe_comment_count);
        this.F.a(textView);
        this.F.a(imageView);
        if (this.D.isPrivateCloud()) {
            if (textView != null) {
                textView.setVisibility(4);
            }
            if (imageView != null) {
                imageView.setImageResource(c.a.a.a.b.d.ic_forum_black_24dp_disabled);
            }
        }
        if (this.F.a() != null && this.f6156d != -1) {
            com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.a aVar = new com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.a();
            aVar.a(this.E.a(this.f6156d));
            aVar.a(AdobeOneUpViewDataType.ADOBE_ONE_UP_VIEW_DATA_TYPE_FILES);
            this.F.a().a(aVar, this.o, textView);
        }
        if (this.F.a() != null) {
            Handler handler = new Handler();
            RelativeLayout relativeLayout = !this.F.a().a() ? null : this.o;
            RelativeLayout relativeLayout2 = this.m;
            if (relativeLayout != null) {
                handler.postDelayed(new Y(this, handler, this, relativeLayout2, relativeLayout), 500L);
            } else if (relativeLayout2 != null) {
                handler.postDelayed(new RunnableC0359aa(this, this, relativeLayout2), 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        int i = this.I;
        int i2 = this.f6156d;
        if (i == i2) {
            return;
        }
        this.I = i2;
        C0533a a2 = this.E.a(i2);
        if (this.F.a() != null) {
            C0369ca c0369ca = new C0369ca(this, i2, a2);
            String a3 = a(a2);
            if (new File(this.f6157e, a3 + ".png").exists()) {
                if (!this.F.c()) {
                    a(i2, true);
                }
                E();
                return;
            }
            com.adobe.creativesdk.foundation.internal.storage.controllers.a.f fVar = this.C;
            StringBuilder sb = new StringBuilder();
            sb.append(a2.getGUID());
            AdobeAssetFile adobeAssetFile = (AdobeAssetFile) a2;
            sb.append(adobeAssetFile.getMd5Hash());
            byte[] b2 = fVar.b(sb.toString());
            if (b2 != null) {
                new e(a2, i2).execute(b2);
            } else {
                adobeAssetFile.getRenditionWithType(AdobeAssetFileRenditionType.ADOBE_ASSET_FILE_RENDITION_TYPE_PNG, new C0582ma(0.0f, 0.0f), c0369ca);
            }
        }
    }

    private void I() {
        if (this.G != null) {
            for (int i = 0; i < this.G.size(); i++) {
                this.G.getItem(i).setVisible(true);
            }
        }
    }

    private void J() {
        C0533a a2 = this.E.a(this.f6156d);
        if (this.B != null) {
            if (this.E.b((AdobeAssetFile) a2)) {
                this.B.setSelected(true);
            } else {
                this.B.setSelected(false);
            }
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k
    protected void A() {
        if (!this.F.c()) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
    }

    public void B() {
        synchronized (AdobeUXAssetOneUpViewerActivity.class) {
            if (A != null) {
                this.E.f6392d.add(A);
                A = null;
            }
        }
        this.f6158f.notifyDataSetChanged();
    }

    public com.adobe.creativesdk.foundation.internal.storage.controllers.a.f C() {
        return this.C;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0406fd
    public void f() {
        this.f6158f.notifyDataSetChanged();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0406fd
    public void h() {
        String format;
        int d2 = this.E.d();
        if (d2 < 1) {
            format = com.adobe.creativesdk.foundation.internal.utils.l.b(c.a.a.a.b.i.adobe_csdk_storage_open_files);
        } else if (d2 > 99) {
            format = com.adobe.creativesdk.foundation.internal.utils.l.b(c.a.a.a.b.i.adobe_csdk_storage_open_multiple_files_99);
        } else {
            format = String.format(com.adobe.creativesdk.foundation.internal.utils.l.b(c.a.a.a.b.i.adobe_csdk_storage_open_multiple_files), Integer.toString(d2));
        }
        this.f6160h.setText(format);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0406fd
    public void k() {
        if (getSupportActionBar().isShowing()) {
            return;
        }
        w();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        this.H = false;
        if (((a) this.f6158f).b() == null || !((a) this.f6158f).b().A()) {
            super.onBackPressed();
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.J || this.F.a() == null) {
            return;
        }
        this.F.a().a(configuration.orientation);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k, com.adobe.creativesdk.foundation.internal.base.AdobeTOUHandlerActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(null);
        if (bundle != null && bundle.getInt("ASSET_ONE_UP_ACTIVITY", -2) != -2) {
            finish();
            return;
        }
        c.a aVar = new c.a();
        aVar.a(0.1f);
        this.C = new com.adobe.creativesdk.foundation.internal.storage.controllers.a.f(this);
        this.C.a(getSupportFragmentManager(), aVar);
        c.a.a.a.c.a.a.b().a(getApplicationContext());
        this.D = (AdobeCloud) getIntent().getExtras().getSerializable("ADOBE_CLOUD");
        com.adobe.creativesdk.foundation.internal.utils.b.a(findViewById(R.id.content), "Yes");
        if (!this.E.f()) {
            finish();
            return;
        }
        this.E.a(this);
        this.f6158f = new a(getSupportFragmentManager());
        this.f6159g = (ViewPager) findViewById(c.a.a.a.b.e.adobe_csdk_library_item_pager);
        this.f6159g.setAdapter(this.f6158f);
        this.f6156d = this.E.e();
        this.f6159g.setCurrentItem(this.f6156d, false);
        C0533a a2 = this.E.a(this.f6156d);
        com.adobe.creativesdk.foundation.internal.utils.b.a(findViewById(R.id.content), a2.getName());
        this.f6159g.setPageTransformer(true, new C0479u());
        this.f6157e = new File(getFilesDir(), "adobeassetviewerimages");
        if (!this.f6157e.exists()) {
            this.f6157e.mkdirs();
        }
        this.i.setOnClickListener(new V(this));
        this.B = (ImageButton) findViewById(c.a.a.a.b.e.adobe_csdk_library_items_image_selectbtn);
        this.k.setText((this.f6156d + 1) + " " + getString(c.a.a.a.b.i.adobe_csdk_IDS_ASSET_VIEWER_OF) + " " + this.E.b());
        if (!this.F.c()) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
        if (!this.F.c() && this.E.g()) {
            this.B.setVisibility(0);
        } else {
            this.B.setVisibility(8);
        }
        J();
        this.B.setOnClickListener(new W(this));
        h();
        boolean booleanExtra = getIntent().getBooleanExtra("START_WITH_COMMENT_WINDOW", false);
        boolean booleanExtra2 = getIntent().getBooleanExtra("START_WITH_COMMENT_REPLY_WINDOW", false);
        Bundle bundle2 = new Bundle();
        if (booleanExtra) {
            bundle2.putBoolean("START_WITH_COMMENT_WINDOW", true);
        } else if (booleanExtra2) {
            bundle2.putBoolean("START_WITH_COMMENT_REPLY_WINDOW", true);
        }
        if (this.F.a() != null) {
            com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.a aVar2 = new com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.a();
            aVar2.a(a2);
            aVar2.a(AdobeOneUpViewDataType.ADOBE_ONE_UP_VIEW_DATA_TYPE_FILES);
            this.F.a().a(bundle2, aVar2, this, this.D);
        }
        D();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        View inflate;
        if (!this.E.f()) {
            return super.onCreateOptionsMenu(menu);
        }
        if (this.D != null) {
            if (this.F.c() && this.F.b() != -1) {
                getMenuInflater().inflate(this.F.b(), menu);
                for (int i = 0; i < menu.size(); i++) {
                    menu.getItem(i).setTitle(c(menu.getItem(i).getTitle().toString()));
                    Integer a2 = this.F.a(menu.getItem(i).getItemId());
                    if (a2 != null && (inflate = getLayoutInflater().inflate(a2.intValue(), (ViewGroup) null)) != null) {
                        menu.getItem(i).setActionView(inflate);
                        this.F.a(menu.getItem(i).getItemId(), inflate);
                        inflate.setOnClickListener(new ViewOnClickListenerC0364ba(this, menu, i, this));
                    }
                }
            }
            this.G = menu;
            this.F.a(menu);
            if (this.F.a() != null) {
                this.F.a().a(this.D.isPrivateCloud());
            }
            if (this.F.a() != null && this.f6156d != -1) {
                com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.a aVar = new com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.a();
                aVar.a(this.E.a(this.f6156d));
                aVar.a(AdobeOneUpViewDataType.ADOBE_ONE_UP_VIEW_DATA_TYPE_FILES);
                this.F.a().a(aVar, this.D);
            }
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k, com.adobe.creativesdk.foundation.internal.base.AdobeTOUHandlerActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        com.adobe.creativesdk.foundation.adobeinternal.net.a.a();
        synchronized (AdobeUXAssetOneUpViewerActivity.class) {
            AbstractActivityC0427k.f6155c = null;
        }
        if (!this.H) {
            try {
                if (this.f6157e != null) {
                    org.apache.commons.io.b.b(this.f6157e);
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        super.onDestroy();
        com.adobe.creativesdk.foundation.internal.storage.controllers.a.f fVar = this.C;
        if (fVar != null) {
            fVar.a();
        }
        this.C = null;
        this.E.i();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            return true;
        }
        AdobeAssetFile adobeAssetFile = (AdobeAssetFile) this.E.a(this.f6156d);
        if (this.F.a() != null) {
            com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.a aVar = new com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.a();
            aVar.a(adobeAssetFile);
            aVar.a(AdobeOneUpViewDataType.ADOBE_ONE_UP_VIEW_DATA_TYPE_FILES);
            this.F.a().a(menuItem.getItemId(), aVar, this, this.D);
        }
        return true;
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        this.E.b(this.f6156d);
        bundle.putInt("ASSET_ONE_UP_ACTIVITY", this.f6156d);
        super.onSaveInstanceState(bundle);
    }

    @Override // com.adobe.creativesdk.foundation.internal.base.AdobeTOUHandlerActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        if (Boolean.valueOf(C0455p.b(this)).booleanValue()) {
            d dVar = new d(this);
            this.l.setVisibility(0);
            this.m.setOnClickListener(dVar);
            this.n.setOnClickListener(dVar);
            this.o.setOnClickListener(dVar);
            this.p.setOnClickListener(dVar);
            G();
        }
        if (z) {
            B();
            z = false;
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k
    protected String s() {
        return this.E.a(this.f6156d).getName();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k
    protected ViewPager.SimpleOnPageChangeListener t() {
        return new c(this, null);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k
    protected File u() {
        String a2 = a(this.E.a(this.f6156d));
        return new File(this.f6157e, a2 + ".png");
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k
    protected void x() {
        com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.d dVar = this.r;
        if (dVar != null) {
            this.F = (com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.f) dVar.a("ADOBE_ONE_UP_VIEW_ASSET_CONFIGURATION");
            this.E = C0469s.a(this.F.e(), this.F.d());
            this.s = this.F;
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k
    protected void z() {
        super.z();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k
    protected void d(boolean z2) {
        C0469s c0469s;
        com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.f fVar = this.F;
        if (fVar == null || fVar.c() || (c0469s = this.E) == null || !c0469s.g()) {
            return;
        }
        if (z2) {
            this.B.setVisibility(0);
        } else {
            this.B.setVisibility(4);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k, com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0406fd
    public void e() {
        super.w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        this.f6156d = i;
        if (AbstractActivityC0427k.y()) {
            I();
        } else {
            F();
        }
        TextView textView = this.k;
        if (textView != null) {
            textView.setText((this.f6156d + 1) + " " + getString(c.a.a.a.b.i.adobe_csdk_IDS_ASSET_VIEWER_OF) + " " + this.E.b());
        }
        C0533a a2 = this.E.a(this.f6156d);
        J();
        com.adobe.creativesdk.foundation.internal.utils.b.a(findViewById(R.id.content), a2.getName());
        H();
        if (this.f6156d >= this.E.b() - 5) {
            this.E.h();
        }
        AdobeAssetFile adobeAssetFile = (AdobeAssetFile) this.E.a(this.f6156d);
        if (this.F.a() != null) {
            com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.a aVar = new com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.a();
            aVar.a(adobeAssetFile);
            aVar.a(AdobeOneUpViewDataType.ADOBE_ONE_UP_VIEW_DATA_TYPE_FILES);
            this.F.a().a(aVar, this.D);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends Fragment implements com.adobe.creativesdk.foundation.internal.storage.controllers.multipage.v {

        /* renamed from: a, reason: collision with root package name */
        int f5530a;

        /* renamed from: b, reason: collision with root package name */
        com.adobe.creativesdk.foundation.internal.storage.controllers.multipage.p f5531b;

        /* renamed from: c, reason: collision with root package name */
        C f5532c;

        /* renamed from: d, reason: collision with root package name */
        private Observer f5533d;

        /* renamed from: e, reason: collision with root package name */
        int f5534e = 1;

        private int a(C0533a c0533a) {
            if (!(c0533a instanceof AdobeAssetFile)) {
                return 0;
            }
            AdobeAssetFile adobeAssetFile = (AdobeAssetFile) c0533a;
            if (adobeAssetFile.getOptionalMetadata() != null) {
                this.f5534e = adobeAssetFile.getOptionalMetadata().optInt(com.umeng.analytics.pro.b.s, 1);
            }
            return this.f5534e;
        }

        static b m(int i) {
            b bVar = new b();
            Bundle bundle = new Bundle();
            bundle.putInt("num", i);
            bVar.setArguments(bundle);
            return bVar;
        }

        public boolean A() {
            if (this.f5534e <= 1 || this.f5531b.d() != AdobeMultiPageViewState.AdobeMultiPageViewPager) {
                return false;
            }
            if (this.f5531b.c() == AdobeMultiPageViewState.AdobeMultiPageGridView) {
                this.f5531b.a();
            } else if (this.f5531b.c() == AdobeMultiPageViewState.AdobeMultiPageListView) {
                this.f5531b.b();
            }
            return true;
        }

        public void B() {
            if (this.f5533d == null) {
                this.f5533d = new C0379ea(this);
            }
            com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeNetworkStatusChangeNotification, this.f5533d);
        }

        public void C() {
            com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeNetworkStatusChangeNotification, this.f5533d);
        }

        @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            com.adobe.creativesdk.foundation.internal.storage.controllers.multipage.p pVar = this.f5531b;
            if (pVar != null) {
                pVar.e();
            }
            super.onConfigurationChanged(configuration);
        }

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            this.f5530a = getArguments() != null ? getArguments().getInt("num") : 1;
        }

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View inflate;
            AdobeUXAssetOneUpViewerActivity adobeUXAssetOneUpViewerActivity = (AdobeUXAssetOneUpViewerActivity) getActivity();
            C0533a a2 = adobeUXAssetOneUpViewerActivity.E.a(this.f5530a);
            this.f5534e = a(a2);
            if (this.f5534e == 1) {
                inflate = layoutInflater.inflate(c.a.a.a.b.g.fragment_asset_image, viewGroup, false);
                inflate.findViewById(c.a.a.a.b.e.adobe_csdk_asset_image_view);
                this.f5532c = new C();
                this.f5532c.a(z());
                this.f5532c.a(inflate);
                this.f5532c.a(a2);
                this.f5532c.a(this.f5530a);
                this.f5532c.a(adobeUXAssetOneUpViewerActivity.E);
                this.f5532c.b(adobeUXAssetOneUpViewerActivity.t);
                this.f5532c.a(getActivity(), adobeUXAssetOneUpViewerActivity.F);
                this.f5532c.e();
            } else {
                inflate = layoutInflater.inflate(c.a.a.a.b.g.adobe_multipage_fragment_controller, viewGroup, false);
                this.f5531b = new com.adobe.creativesdk.foundation.internal.storage.controllers.multipage.p();
                this.f5531b.a(this);
                this.f5531b.a(inflate);
                this.f5531b.a(a2);
                this.f5531b.a(AdobeMultiPageViewState.AdobeMultiPageGridView);
                this.f5531b.a(getActivity());
                this.f5531b.a(z());
                this.f5531b.f();
            }
            ((AdobeUXAssetOneUpViewerActivity) getActivity()).H();
            return inflate;
        }

        @Override // android.support.v4.app.Fragment
        public void onDestroyView() {
            super.onDestroyView();
            C c2 = this.f5532c;
            if (c2 != null) {
                c2.b();
                this.f5532c.a((View) null);
                this.f5532c.c();
                this.f5532c = null;
                return;
            }
            com.adobe.creativesdk.foundation.internal.storage.controllers.multipage.p pVar = this.f5531b;
        }

        @Override // android.support.v4.app.Fragment
        public void onStart() {
            super.onStart();
            B();
        }

        @Override // android.support.v4.app.Fragment
        public void onStop() {
            super.onStop();
            C();
        }

        com.adobe.creativesdk.foundation.internal.storage.controllers.a.f z() {
            AdobeUXAssetOneUpViewerActivity adobeUXAssetOneUpViewerActivity = (AdobeUXAssetOneUpViewerActivity) getActivity();
            if (adobeUXAssetOneUpViewerActivity != null) {
                return adobeUXAssetOneUpViewerActivity.C();
            }
            return null;
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.multipage.v
        public C0469s a() {
            return ((AdobeUXAssetOneUpViewerActivity) getActivity()).E;
        }
    }

    public void a(int i, boolean z2) {
        View view = this.i;
        if (view == null || i != this.f6156d) {
            return;
        }
        view.setEnabled(z2);
        this.B.setEnabled(z2);
        if (!z2 && this.B.isSelected()) {
            C0533a a2 = this.E.a(this.f6156d);
            this.B.setSelected(false);
            this.E.c((AdobeAssetFile) a2);
        }
        if (z2) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends AsyncTask<byte[], Integer, Uri> {

        /* renamed from: a, reason: collision with root package name */
        boolean f5538a;

        /* renamed from: b, reason: collision with root package name */
        C0533a f5539b;

        /* renamed from: c, reason: collision with root package name */
        int f5540c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public e(C0533a c0533a, int i) {
            this.f5539b = c0533a;
            this.f5540c = i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0082 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public android.net.Uri doInBackground(byte[]... r6) {
            /*
                r5 = this;
                r0 = 0
                r5.f5538a = r0
                r1 = 1
                r2 = 0
                if (r6 != 0) goto La
                r5.f5538a = r1
                return r2
            La:
                r6 = r6[r0]
                if (r6 != 0) goto L11
                r5.f5538a = r1
                return r2
            L11:
                com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXAssetOneUpViewerActivity r0 = com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXAssetOneUpViewerActivity.this
                com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.f r0 = r0.F
                boolean r0 = r0.c()
                if (r0 != 0) goto L1c
                return r2
            L1c:
                com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXAssetOneUpViewerActivity r0 = com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXAssetOneUpViewerActivity.this
                com.adobe.creativesdk.foundation.storage.a r1 = r5.f5539b
                java.lang.String r0 = com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXAssetOneUpViewerActivity.a(r0, r1)
                java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L6f
                com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXAssetOneUpViewerActivity r3 = com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXAssetOneUpViewerActivity.this     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L6f
                java.io.File r3 = r3.f6157e     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L6f
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L6f
                r4.<init>()     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L6f
                r4.append(r0)     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L6f
                java.lang.String r0 = ".png"
                r4.append(r0)     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L6f
                java.lang.String r0 = r4.toString()     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L6f
                r1.<init>(r3, r0)     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L6f
                boolean r0 = r1.createNewFile()     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L6f
                if (r0 == 0) goto L61
                java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L6f
                r0.<init>(r1)     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L6f
                r0.write(r6)     // Catch: java.lang.Exception -> L5f java.lang.Throwable -> L7e
                r0.flush()     // Catch: java.lang.Exception -> L5f java.lang.Throwable -> L7e
                com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXAssetOneUpViewerActivity r6 = com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXAssetOneUpViewerActivity.this     // Catch: java.lang.Exception -> L5f java.lang.Throwable -> L7e
                com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXAssetOneUpViewerActivity r3 = com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXAssetOneUpViewerActivity.this     // Catch: java.lang.Exception -> L5f java.lang.Throwable -> L7e
                com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.d r3 = r3.r     // Catch: java.lang.Exception -> L5f java.lang.Throwable -> L7e
                java.lang.String r3 = r3.a()     // Catch: java.lang.Exception -> L5f java.lang.Throwable -> L7e
                android.net.Uri r6 = android.support.v4.content.FileProvider.getUriForFile(r6, r3, r1)     // Catch: java.lang.Exception -> L5f java.lang.Throwable -> L7e
                r2 = r6
                goto L62
            L5f:
                r6 = move-exception
                goto L71
            L61:
                r0 = r2
            L62:
                if (r0 == 0) goto L7d
                r0.close()     // Catch: java.io.IOException -> L68
                goto L7d
            L68:
                r6 = move-exception
                r6.printStackTrace()
                goto L7d
            L6d:
                r6 = move-exception
                goto L80
            L6f:
                r6 = move-exception
                r0 = r2
            L71:
                com.adobe.creativesdk.foundation.internal.utils.logging.Level r1 = com.adobe.creativesdk.foundation.internal.utils.logging.Level.DEBUG     // Catch: java.lang.Throwable -> L7e
                java.lang.String r3 = "AdobeUXAssetOneUpViewerActivity"
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(r1, r3, r2, r6)     // Catch: java.lang.Throwable -> L7e
                if (r0 == 0) goto L7d
                r0.close()     // Catch: java.io.IOException -> L68
            L7d:
                return r2
            L7e:
                r6 = move-exception
                r2 = r0
            L80:
                if (r2 == 0) goto L8a
                r2.close()     // Catch: java.io.IOException -> L86
                goto L8a
            L86:
                r0 = move-exception
                r0.printStackTrace()
            L8a:
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXAssetOneUpViewerActivity.e.doInBackground(byte[][]):android.net.Uri");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onProgressUpdate(Integer... numArr) {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Uri uri) {
            AdobeUXAssetOneUpViewerActivity.this.E();
            if (AdobeUXAssetOneUpViewerActivity.this.F.c()) {
                return;
            }
            if (!this.f5538a) {
                AdobeUXAssetOneUpViewerActivity.this.a(this.f5540c, true);
            } else {
                AdobeUXAssetOneUpViewerActivity.this.a(this.f5540c, false);
            }
        }
    }
}
