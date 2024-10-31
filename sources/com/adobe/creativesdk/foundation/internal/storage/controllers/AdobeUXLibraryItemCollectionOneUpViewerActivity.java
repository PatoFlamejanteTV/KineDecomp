package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.util.DisplayMetrics;
import android.view.KeyCharacterMap;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.adobeinternal.storage.library.C0288q;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.AdobeOneUpViewDataType;
import com.adobe.creativesdk.foundation.internal.storage.controllers.a.c;
import com.adobe.creativesdk.foundation.internal.utils.DrawShadowRelativeLayout;
import com.adobe.creativesdk.foundation.internal.utils.photoview.PhotoView;
import com.adobe.creativesdk.foundation.storage.C0533a;
import com.adobe.creativesdk.foundation.storage.C0551eb;
import com.adobe.creativesdk.foundation.storage.C0582ma;
import com.adobe.creativesdk.foundation.storage.C0614ub;
import com.adobe.creativesdk.foundation.storage.C0622wb;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observer;

/* loaded from: classes.dex */
public class AdobeUXLibraryItemCollectionOneUpViewerActivity extends AbstractActivityC0427k {
    C0469s A;
    com.adobe.creativesdk.foundation.internal.storage.controllers.b.c B;
    com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.g C;
    com.adobe.creativesdk.foundation.internal.storage.controllers.a.f D;
    private Observer z = null;

    /* loaded from: classes.dex */
    public class a extends FragmentStatePagerAdapter {
        public a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return AdobeUXLibraryItemCollectionOneUpViewerActivity.this.B.a();
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            return c.m(i);
        }
    }

    /* loaded from: classes.dex */
    private class b extends ViewPager.SimpleOnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.SimpleOnPageChangeListener, android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            AdobeUXLibraryItemCollectionOneUpViewerActivity adobeUXLibraryItemCollectionOneUpViewerActivity = AdobeUXLibraryItemCollectionOneUpViewerActivity.this;
            adobeUXLibraryItemCollectionOneUpViewerActivity.u = true;
            adobeUXLibraryItemCollectionOneUpViewerActivity.f6156d = i;
            adobeUXLibraryItemCollectionOneUpViewerActivity.H();
            AdobeUXLibraryItemCollectionOneUpViewerActivity.this.e(false);
        }

        /* synthetic */ b(AdobeUXLibraryItemCollectionOneUpViewerActivity adobeUXLibraryItemCollectionOneUpViewerActivity, C0446na c0446na) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static class c extends Fragment {

        /* renamed from: a, reason: collision with root package name */
        private int f5552a;

        /* renamed from: b, reason: collision with root package name */
        private RelativeLayout f5553b;

        /* renamed from: c, reason: collision with root package name */
        private ProgressBar f5554c;

        /* renamed from: d, reason: collision with root package name */
        private View f5555d;

        /* renamed from: e, reason: collision with root package name */
        private View f5556e;

        /* renamed from: f, reason: collision with root package name */
        e f5557f;

        /* JADX INFO: Access modifiers changed from: private */
        public void A() {
            b(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(boolean z) {
            this.f5554c.setVisibility(z ? 0 : 8);
        }

        public static Fragment m(int i) {
            c cVar = new c();
            Bundle bundle = new Bundle();
            bundle.putInt("indexPos", i);
            cVar.setArguments(bundle);
            return cVar;
        }

        private void n(int i) {
            AdobeUXLibraryItemCollectionOneUpViewerActivity adobeUXLibraryItemCollectionOneUpViewerActivity = (AdobeUXLibraryItemCollectionOneUpViewerActivity) getActivity();
            C0622wb a2 = adobeUXLibraryItemCollectionOneUpViewerActivity.B.a(i);
            C0614ub b2 = adobeUXLibraryItemCollectionOneUpViewerActivity.B.b();
            if (a2 == null) {
                return;
            }
            if (a2.j().equals("application/vnd.adobe.element.color+dcx")) {
                b(a2, b2);
                c(false);
            } else if (a2.j().equals("application/vnd.adobe.element.colortheme+dcx")) {
                a(a2, b2);
                c(false);
            } else if (a(a2)) {
                c(a2, b2);
            }
        }

        void b(boolean z) {
            this.f5553b.setVisibility(8);
            if (z) {
                this.f5555d.setVisibility(0);
                this.f5556e.setVisibility(8);
            } else {
                this.f5555d.setVisibility(8);
                this.f5556e.setVisibility(0);
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
            this.f5552a = getArguments() != null ? getArguments().getInt("indexPos") : -1;
        }

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View inflate = layoutInflater.inflate(c.a.a.a.b.g.library_item_fragment, viewGroup, false);
            this.f5553b = (RelativeLayout) inflate.findViewById(c.a.a.a.b.e.adobe_csdk_library_item_fragment_content_container);
            this.f5555d = inflate.findViewById(c.a.a.a.b.e.adobe_csdk_alibrary_item_no_internet_connection);
            this.f5556e = inflate.findViewById(c.a.a.a.b.e.adobe_csdk_library_item_no_preview);
            this.f5554c = (ProgressBar) inflate.findViewById(c.a.a.a.b.e.adobe_csdk_library_item_progressbar_new);
            c(true);
            if (AbstractActivityC0427k.y()) {
                z();
                n(this.f5552a);
            } else {
                b(true);
            }
            return inflate;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void z() {
            this.f5553b.setVisibility(0);
            this.f5555d.setVisibility(8);
            this.f5556e.setVisibility(8);
        }

        private void c(C0622wb c0622wb, C0614ub c0614ub) {
            RelativeLayout.LayoutParams layoutParams;
            PhotoView photoView = new PhotoView(getActivity());
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(13);
            photoView.setLayoutParams(layoutParams2);
            new com.adobe.creativesdk.foundation.internal.utils.photoview.g(photoView).a(new C0490wa(this));
            AdobeUXLibraryItemCollectionOneUpViewerActivity adobeUXLibraryItemCollectionOneUpViewerActivity = (AdobeUXLibraryItemCollectionOneUpViewerActivity) getActivity();
            C0582ma c0582ma = new C0582ma(450.0f, 0.0f);
            BitmapDrawable c2 = adobeUXLibraryItemCollectionOneUpViewerActivity.D.c(c0622wb.c());
            if (c2 == null) {
                if (!c.a.a.a.a.b.a.c.e.a(c.a.a.a.a.b.a.c.e.a(c0622wb, 1, getActivity(), false), adobeUXLibraryItemCollectionOneUpViewerActivity.B.b(), c0622wb, new C0486va(this, adobeUXLibraryItemCollectionOneUpViewerActivity, c0622wb, c0582ma, photoView), new Handler(Looper.getMainLooper()))) {
                    A();
                }
            } else {
                Bitmap bitmap = c2.getBitmap();
                z();
                this.f5557f = new e();
                this.f5557f.f5560a = bitmap.getWidth();
                this.f5557f.f5561b = bitmap.getHeight();
                DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                if (bitmap.getWidth() >= displayMetrics.widthPixels && bitmap.getHeight() >= displayMetrics.heightPixels) {
                    layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                } else {
                    layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                }
                photoView.setImageBitmap(com.adobe.creativesdk.foundation.internal.utils.p.a(bitmap, displayMetrics.widthPixels, displayMetrics.heightPixels));
                layoutParams.addRule(13);
                photoView.setLayoutParams(layoutParams);
                c(false);
            }
            this.f5553b.addView(photoView);
        }

        private boolean a(C0622wb c0622wb) {
            return c0622wb.j().equals("application/vnd.adobe.element.image+dcx") || c0622wb.j().equals("application/vnd.adobe.element.brush+dcx") || c0622wb.j().equals("application/vnd.adobe.element.characterstyle+dcx") || c0622wb.j().equals("application/vnd.adobe.element.layerstyle+dcx") || c0622wb.j().equals("application/vnd.adobe.element.look+dcx") || c0622wb.j().equals("application/vnd.adobe.element.pattern+dcx") || c0622wb.j().equals("application/vnd.adobe.element.template+dcx") || c0622wb.j().equals("application/vnd.adobe.element.material+dcx") || c0622wb.j().equals("application/vnd.adobe.element.light+dcx") || c0622wb.j().equals("application/vnd.adobe.element.3d+dcx") || c0622wb.j().equals("application/vnd.adobe.element.animation+dcx");
        }

        private void b(C0622wb c0622wb, C0614ub c0614ub) {
            RelativeLayout relativeLayout = new RelativeLayout(getActivity());
            int dimensionPixelSize = getResources().getDimensionPixelSize(c.a.a.a.b.c.adobe_csdk_library_oneup_color_size);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
            layoutParams.addRule(13);
            relativeLayout.setLayoutParams(layoutParams);
            relativeLayout.setBackgroundColor(C0551eb.a(c0622wb, c0614ub).intValue());
            this.f5553b.addView(relativeLayout);
            Bitmap createBitmap = Bitmap.createBitmap(relativeLayout.getLayoutParams().width, relativeLayout.getLayoutParams().height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            relativeLayout.layout(0, 0, relativeLayout.getLayoutParams().width, relativeLayout.getLayoutParams().height);
            relativeLayout.draw(canvas);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), createBitmap);
            AdobeUXLibraryItemCollectionOneUpViewerActivity adobeUXLibraryItemCollectionOneUpViewerActivity = (AdobeUXLibraryItemCollectionOneUpViewerActivity) getActivity();
            adobeUXLibraryItemCollectionOneUpViewerActivity.a(bitmapDrawable, adobeUXLibraryItemCollectionOneUpViewerActivity.a(c0622wb));
        }

        private void a(C0622wb c0622wb, C0614ub c0614ub) {
            LinearLayout linearLayout = new LinearLayout(getActivity());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(c.a.a.a.b.c.adobe_csdk_library_oneup_colortheme_width), getResources().getDimensionPixelSize(c.a.a.a.b.c.adobe_csdk_library_oneup_colortheme_height));
            layoutParams.addRule(13);
            linearLayout.setLayoutParams(layoutParams);
            c.a.a.a.a.b.a.b.a.e.b.d a2 = c.a.a.a.a.b.a.b.a.e.a.a.a(c0614ub, c0622wb);
            ArrayList arrayList = new ArrayList();
            Iterator<c.a.a.a.a.b.a.b.a.e.b.a> it = a2.f3444a.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(it.next().a()));
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1, 1.0f);
            for (int i = 0; i < 5; i++) {
                View view = new View(getActivity());
                view.setLayoutParams(layoutParams2);
                view.setBackgroundColor(((Integer) arrayList.get(i)).intValue());
                linearLayout.addView(view);
            }
            this.f5553b.addView(linearLayout);
            Bitmap createBitmap = Bitmap.createBitmap(linearLayout.getLayoutParams().width, linearLayout.getLayoutParams().height, Bitmap.Config.ARGB_8888);
            linearLayout.draw(new Canvas(createBitmap));
            AdobeUXLibraryItemCollectionOneUpViewerActivity adobeUXLibraryItemCollectionOneUpViewerActivity = (AdobeUXLibraryItemCollectionOneUpViewerActivity) getActivity();
            adobeUXLibraryItemCollectionOneUpViewerActivity.a(new BitmapDrawable(adobeUXLibraryItemCollectionOneUpViewerActivity.getResources(), createBitmap), adobeUXLibraryItemCollectionOneUpViewerActivity.a(c0622wb));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        private Activity f5558a;

        public d(Activity activity) {
            this.f5558a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == AdobeUXLibraryItemCollectionOneUpViewerActivity.this.p.getId()) {
                Intent v = AdobeUXLibraryItemCollectionOneUpViewerActivity.this.v();
                if (v != null) {
                    AdobeUXLibraryItemCollectionOneUpViewerActivity.this.startActivity(v);
                    return;
                }
                return;
            }
            if (view.getId() == AdobeUXLibraryItemCollectionOneUpViewerActivity.this.n.getId()) {
                AdobeUXLibraryItemCollectionOneUpViewerActivity adobeUXLibraryItemCollectionOneUpViewerActivity = AdobeUXLibraryItemCollectionOneUpViewerActivity.this;
                C0622wb a2 = adobeUXLibraryItemCollectionOneUpViewerActivity.B.a(adobeUXLibraryItemCollectionOneUpViewerActivity.f6156d);
                com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.a aVar = new com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.a();
                aVar.a(a2);
                aVar.a(AdobeOneUpViewDataType.ADOBE_ONE_UP_VIEW_DATA_TYPE_LIBRARY);
                AdobeUXLibraryItemCollectionOneUpViewerActivity.this.C.a().a(0, aVar, this.f5558a, (AdobeCloud) null);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public int f5560a;

        /* renamed from: b, reason: collision with root package name */
        public int f5561b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        C0622wb C = C();
        C0614ub b2 = this.B.b();
        if (com.adobe.creativesdk.foundation.internal.storage.ba.c()) {
            com.adobe.creativesdk.foundation.internal.storage.ba.a(C, b2);
        }
        setResult(-1, new Intent());
        finish();
    }

    private void E() {
        if (Boolean.valueOf(C0455p.b(this)).booleanValue()) {
            d dVar = new d(this);
            this.l.setVisibility(0);
            this.m.setVisibility(8);
            this.o.setVisibility(8);
            this.p.setOnClickListener(dVar);
            this.n.setOnClickListener(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        if (this.z != null) {
            com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeLibraryOneUpControllerInitialized, this.z);
            this.z = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        this.f6158f = new a(getSupportFragmentManager());
        this.f6159g.setAdapter(this.f6158f);
        this.f6156d = this.B.c();
        this.f6159g.setCurrentItem(this.f6156d, false);
        H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        if (this.k != null) {
            this.k.setText(String.format(getString(c.a.a.a.b.i.adobe_csdk_IDS_ASSET_VIEWER_OF_2), Integer.valueOf(this.f6156d + 1), Integer.valueOf(this.B.a())));
        }
        C0622wb a2 = this.B.a(this.f6156d);
        if (a2 == null || a2.j().equals("application/vnd.adobe.element.color+dcx")) {
            return;
        }
        d(C0288q.b(a2));
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k
    protected void A() {
        if (com.adobe.creativesdk.foundation.internal.storage.ba.c()) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B() {
        if (this.C.c()) {
            C0622wb a2 = this.B.a(this.f6156d);
            C0614ub b2 = this.B.b();
            boolean z = a2.j().equals("application/vnd.adobe.element.color+dcx") || a2.j().equals("application/vnd.adobe.element.colortheme+dcx");
            if (a2 == null || z) {
                return;
            }
            String a3 = a(a2);
            com.adobe.creativesdk.foundation.internal.storage.controllers.a.f fVar = this.D;
            if (fVar != null) {
                BitmapDrawable c2 = fVar.c(a2.c());
                if (c2 != null) {
                    a(c2, a3);
                } else {
                    c.a.a.a.a.b.a.c.e.a(500, b2, a2, new C0470sa(this, a2, a3), new Handler(Looper.getMainLooper()));
                }
            }
        }
    }

    C0622wb C() {
        return this.B.a(this.f6159g.getCurrentItem());
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k
    protected void d(boolean z) {
    }

    public void e(boolean z) {
        FragmentStatePagerAdapter fragmentStatePagerAdapter = this.f6158f;
        if (fragmentStatePagerAdapter != null && fragmentStatePagerAdapter.getCount() > 0) {
            C0622wb C = C();
            if (!C.j().equals("application/vnd.adobe.element.image+dcx")) {
                C.j().equals("application/vnd.adobe.element.characterstyle+dcx");
            }
        }
        this.f6159g.setBackgroundColor(getResources().getColor(c.a.a.a.b.b.adobe_csdk_oneupview_background_color));
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k, com.adobe.creativesdk.foundation.internal.base.AdobeTOUHandlerActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        E();
        this.i.setOnClickListener(new ViewOnClickListenerC0451oa(this));
        b(bundle);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        View inflate;
        if (!this.C.c() || this.C.b() == -1) {
            return true;
        }
        getMenuInflater().inflate(this.C.b(), menu);
        for (int i = 0; i < menu.size(); i++) {
            menu.getItem(i).setTitle(c(menu.getItem(i).getTitle().toString()));
            Integer a2 = this.C.a(menu.getItem(i).getItemId());
            if (a2 != null && (inflate = getLayoutInflater().inflate(a2.intValue(), (ViewGroup) null)) != null) {
                menu.getItem(i).setActionView(inflate);
                this.C.a(menu.getItem(i).getItemId(), inflate);
                inflate.setOnClickListener(new ViewOnClickListenerC0456pa(this, menu, i, this));
            }
        }
        return true;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k, com.adobe.creativesdk.foundation.internal.base.AdobeTOUHandlerActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        F();
        com.adobe.creativesdk.foundation.adobeinternal.net.a.a();
        synchronized (AdobeUXLibraryItemCollectionOneUpViewerActivity.class) {
            AbstractActivityC0427k.f6155c = null;
        }
        com.adobe.creativesdk.foundation.internal.storage.controllers.a.f fVar = this.D;
        if (fVar != null) {
            fVar.a();
        }
        this.D = null;
        super.onDestroy();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            return true;
        }
        C0622wb a2 = this.B.a(this.f6156d);
        if (this.C.a() != null) {
            com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.a aVar = new com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.a();
            aVar.a(a2);
            aVar.a(AdobeOneUpViewDataType.ADOBE_ONE_UP_VIEW_DATA_TYPE_FILES);
            this.C.a().a(menuItem.getItemId(), aVar, this, (AdobeCloud) null);
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
        return this.B.a(this.f6156d).e();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k
    protected ViewPager.SimpleOnPageChangeListener t() {
        return new b(this, null);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k
    protected File u() {
        String a2 = a(this.B.a(this.f6156d));
        return new File(this.f6157e, a2 + ".png");
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k
    protected void x() {
        this.C = (com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.g) this.r.a("ADOBE_ONE_UP_VIEW_LIBRARY_CONFIGURATION");
        this.A = C0469s.a((C0533a) null);
        this.B = com.adobe.creativesdk.foundation.internal.storage.controllers.b.c.a(this.C.e(), this.C.d(), this.C.f());
        this.s = this.C;
    }

    private void b(Bundle bundle) {
        if (this.D == null) {
            c.a aVar = new c.a();
            aVar.a(0.1f);
            this.D = new com.adobe.creativesdk.foundation.internal.storage.controllers.a.f(this);
            this.D.a(getSupportFragmentManager(), aVar);
        }
        if (this.B != null) {
            G();
            return;
        }
        this.z = new C0446na(this);
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeLibraryOneUpControllerInitialized, this.z);
        this.B = com.adobe.creativesdk.foundation.internal.storage.controllers.b.c.a(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0050 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.graphics.drawable.BitmapDrawable r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.String r0 = "AdobeUXLibraryItemCollectionOneUpViewerActivity"
            if (r6 == 0) goto L5b
            android.graphics.Bitmap r6 = r6.getBitmap()
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L39
            java.io.File r3 = r5.f6157e     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L39
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L39
            r4.<init>()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L39
            r4.append(r7)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L39
            java.lang.String r7 = ".png"
            r4.append(r7)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L39
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L39
            r2.<init>(r3, r7)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L39
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L39
            r7.<init>(r2)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L39
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.PNG     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L4d
            r3 = 100
            r6.compress(r2, r3, r7)     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L4d
            r7.flush()     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L4d
            r7.close()     // Catch: java.io.IOException -> L46
            goto L5b
        L34:
            r6 = move-exception
            goto L3b
        L36:
            r6 = move-exception
            r7 = r1
            goto L4e
        L39:
            r6 = move-exception
            r7 = r1
        L3b:
            com.adobe.creativesdk.foundation.internal.utils.logging.Level r2 = com.adobe.creativesdk.foundation.internal.utils.logging.Level.DEBUG     // Catch: java.lang.Throwable -> L4d
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(r2, r0, r1, r6)     // Catch: java.lang.Throwable -> L4d
            if (r7 == 0) goto L5b
            r7.close()     // Catch: java.io.IOException -> L46
            goto L5b
        L46:
            r6 = move-exception
            com.adobe.creativesdk.foundation.internal.utils.logging.Level r7 = com.adobe.creativesdk.foundation.internal.utils.logging.Level.DEBUG
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(r7, r0, r1, r6)
            goto L5b
        L4d:
            r6 = move-exception
        L4e:
            if (r7 == 0) goto L5a
            r7.close()     // Catch: java.io.IOException -> L54
            goto L5a
        L54:
            r7 = move-exception
            com.adobe.creativesdk.foundation.internal.utils.logging.Level r2 = com.adobe.creativesdk.foundation.internal.utils.logging.Level.DEBUG
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(r2, r0, r1, r7)
        L5a:
            throw r6
        L5b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXLibraryItemCollectionOneUpViewerActivity.a(android.graphics.drawable.BitmapDrawable, java.lang.String):void");
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractActivityC0427k, com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0406fd
    @SuppressLint({"InlinedApi"})
    public void e() {
        ActionBar supportActionBar = getSupportActionBar();
        ViewConfiguration.get(this).hasPermanentMenuKey();
        int i = 4;
        KeyCharacterMap.deviceHasKey(4);
        if (supportActionBar != null) {
            if (supportActionBar.isShowing()) {
                supportActionBar.hide();
                this.j.setVisibility(8);
                ((DrawShadowRelativeLayout) this.v).a(false, false);
                e(false);
                this.f6159g.setPadding(0, 0, 0, 0);
                int i2 = Build.VERSION.SDK_INT;
                if (i2 < 16) {
                    i = 0;
                } else if (i2 >= 19) {
                    i = 2052;
                }
                View decorView = getWindow().getDecorView();
                if (com.adobe.creativesdk.foundation.internal.utils.s.a(this)) {
                    i |= 1794;
                }
                decorView.setSystemUiVisibility(i);
                return;
            }
            supportActionBar.show();
            ((DrawShadowRelativeLayout) this.v).a(true, false);
            A();
            e(false);
            this.f6159g.setPadding(0, supportActionBar.getHeight(), 0, 0);
            getWindow().getDecorView().setSystemUiVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(C0622wb c0622wb) {
        String c2 = c0622wb.c();
        if (c2 != null && c2.length() != 0) {
            String[] split = c2.split("/");
            if (split.length > 1) {
                return split[split.length - 1];
            }
            return split[0];
        }
        return c0622wb.e().replace(".", io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR);
    }
}
