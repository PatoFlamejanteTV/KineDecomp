package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb;
import com.adobe.creativesdk.foundation.internal.storage.controllers.a.c;
import com.adobe.creativesdk.foundation.internal.storage.controllers.commands.AdobeAssetViewBrowserCommandName;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetPackagePages;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

/* compiled from: MobileCreationPackageItemsFragment.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.nd, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0449nd extends AbstractC0414hb {
    private b P;
    C0478td Q;
    com.adobe.creativesdk.foundation.internal.storage.controllers.a.f R;
    private c S;
    private AdobeAssetPackagePages T;
    private AdobeCloud U;

    /* compiled from: MobileCreationPackageItemsFragment.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.nd$a */
    /* loaded from: classes.dex */
    protected class a extends AbstractC0414hb.b {
        protected a() {
            super();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public void a(Menu menu) {
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public void a(Menu menu, MenuInflater menuInflater) {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public boolean a(int i) {
            return super.a(i);
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb.b
        public void c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MobileCreationPackageItemsFragment.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.nd$b */
    /* loaded from: classes.dex */
    public class b implements com.adobe.creativesdk.foundation.internal.storage.ga {

        /* renamed from: a, reason: collision with root package name */
        c f6352a;

        private b() {
        }

        private void d() {
            C0449nd.this.T.b(new C0454od(this), new C0459pd(this));
        }

        public void a(c cVar) {
            this.f6352a = cVar;
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ga
        public void b() {
            this.f6352a = null;
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ga
        public void c() {
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ga
        public int getCount() {
            if (C0449nd.this.T.j() == null) {
                return 0;
            }
            return C0449nd.this.T.j().size();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ga
        public boolean a() {
            c cVar = this.f6352a;
            if (cVar != null) {
                cVar.a();
            }
            d();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MobileCreationPackageItemsFragment.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.nd$c */
    /* loaded from: classes.dex */
    public class c implements com.adobe.creativesdk.foundation.internal.storage.ha {
        private c() {
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ha
        public void a() {
            C0449nd.this.H();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ha
        public void b() {
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ha
        public void c() {
            C0449nd c0449nd = C0449nd.this;
            c0449nd.m(c0449nd.P.getCount());
            C0449nd.this.Q.e();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ha
        public void a(int i) {
            C0449nd.this.a(i, (com.adobe.creativesdk.foundation.internal.storage.model.util.b) null, (ArrayList<com.adobe.creativesdk.foundation.internal.storage.model.util.a>) null);
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.ha
        public void a(AdobeAssetException adobeAssetException) {
            C0449nd.this.a(adobeAssetException);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected AbstractC0414hb.b D() {
        return new a();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected int L() {
        return 0;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected String N() {
        return getString(c.a.a.a.b.i.adobe_csdk_uxassetbrowser_csdk_myassets_main);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected String O() {
        AdobeAssetPackagePages adobeAssetPackagePages = this.T;
        if (adobeAssetPackagePages == null || !adobeAssetPackagePages.i()) {
            return null;
        }
        return this.T.getName();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected com.adobe.creativesdk.foundation.internal.storage.ga P() {
        return this.P;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void V() {
        this.Q.o();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void W() {
        com.adobe.creativesdk.foundation.internal.storage.W.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public void Z() {
        C0358a.a().a(AdobeAssetViewBrowserCommandName.ACTION_ASSETVIEW_OPEN_SELECTED_FILES);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public void a(com.adobe.creativesdk.foundation.internal.storage.controllers.commands.d dVar) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public void a(com.adobe.creativesdk.foundation.internal.storage.controllers.utils.b bVar) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public void a(Object obj, View view) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected boolean ca() {
        return true;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void d(boolean z) {
        if (z) {
            this.P.a(this.S);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public boolean g(String str) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    public boolean ia() {
        return false;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        com.adobe.creativesdk.foundation.internal.storage.controllers.a.f fVar = this.R;
        if (fVar != null) {
            fVar.a();
            this.R = null;
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        RecyclerView a2 = this.Q.a(getContext());
        a2.setClipToPadding(false);
        a2.setPadding(a2.getPaddingLeft(), a2.getPaddingTop(), a2.getPaddingRight(), com.adobe.creativesdk.foundation.internal.utils.v.a(getActivity()));
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public boolean s() {
        return false;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void sa() {
        View d2 = this.Q.d();
        if (M().indexOfChild(d2) == -1) {
            M().addView(d2);
        }
        this.f6105d = this.Q;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void va() {
        this.P = new b();
        this.S = new c();
        this.P.a(this.S);
        c.a aVar = new c.a();
        aVar.a(0.1f);
        this.R = new com.adobe.creativesdk.foundation.internal.storage.controllers.a.f(getActivity());
        this.R.a(getActivity().getSupportFragmentManager(), aVar);
        this.Q = new C0478td(x());
        this.Q.a(this);
        this.Q.a(this.T);
        this.Q.d(x());
        this.Q.a(this.R);
        this.P.a();
        new com.adobe.creativesdk.foundation.internal.analytics.c("grid", "mobile_creation").a();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected C0474t a(Bundle bundle) {
        C0489w c0489w = new C0489w();
        c0489w.a(getArguments());
        this.U = c0489w.a();
        return c0489w;
    }

    public static AdobeAssetPackagePages a(String str, String str2, String str3) {
        AdobeAssetPackagePages bVar;
        try {
            URI uri = new URI(str);
            URI uri2 = new URI(str2);
            com.adobe.creativesdk.foundation.internal.storage.model.resources.e a2 = com.adobe.creativesdk.foundation.internal.storage.model.resources.e.a(uri, str3);
            com.adobe.creativesdk.foundation.internal.storage.model.resources.e a3 = com.adobe.creativesdk.foundation.internal.storage.model.resources.e.a(uri2);
            if (!str.contains("/adobedraw/") && !str.contains("/adobedrawandroid/")) {
                if (!str.contains("/adobesketch/") && !str.contains("/adobesketch-android/")) {
                    if (!str.contains("/adobe-psmix/") && !str.contains("/adobeclsmix/")) {
                        if (!str.contains("/adobe-layup/") && !str.contains("/adobecompandroid/")) {
                            if (!str.contains("/adobe-psfix/") && !str.contains("/adobefixandroid/") && !str.contains("/adobe-psfix-cls/")) {
                                return null;
                            }
                            bVar = new com.adobe.creativesdk.foundation.internal.storage.asset.e(a2, a3);
                            return bVar;
                        }
                        bVar = new com.adobe.creativesdk.foundation.internal.storage.asset.a(a2, a3);
                        return bVar;
                    }
                    bVar = new com.adobe.creativesdk.foundation.internal.storage.asset.f(a2, a3);
                    return bVar;
                }
                bVar = new com.adobe.creativesdk.foundation.internal.storage.asset.i(a2, a3);
                return bVar;
            }
            bVar = new com.adobe.creativesdk.foundation.internal.storage.asset.b(a2, a3);
            return bVar;
        } catch (URISyntaxException unused) {
            return null;
        }
    }

    public static AdobeAssetPackagePages a(String str, String str2) {
        AdobeAssetPackagePages bVar;
        try {
            URI uri = new URI(str);
            URI uri2 = new URI(str2);
            com.adobe.creativesdk.foundation.internal.storage.model.resources.e a2 = com.adobe.creativesdk.foundation.internal.storage.model.resources.e.a(uri);
            com.adobe.creativesdk.foundation.internal.storage.model.resources.e a3 = com.adobe.creativesdk.foundation.internal.storage.model.resources.e.a(uri2);
            if (!str.contains("/adobedraw/") && !str.contains("/adobedrawandroid/")) {
                if (!str.contains("/adobesketch/") && !str.contains("/adobesketch-android/")) {
                    if (!str.contains("/adobe-psmix/") && !str.contains("/adobeclsmix/")) {
                        if (!str.contains("/adobe-layup/") && !str.contains("/adobecompandroid/")) {
                            if (!str.contains("/adobe-psfix/") && !str.contains("/adobefixandroid/") && !str.contains("/adobe-psfix-cls/")) {
                                return null;
                            }
                            bVar = new com.adobe.creativesdk.foundation.internal.storage.asset.e(a2, a3);
                            return bVar;
                        }
                        bVar = new com.adobe.creativesdk.foundation.internal.storage.asset.a(a2, a3);
                        return bVar;
                    }
                    bVar = new com.adobe.creativesdk.foundation.internal.storage.asset.f(a2, a3);
                    return bVar;
                }
                bVar = new com.adobe.creativesdk.foundation.internal.storage.asset.i(a2, a3);
                return bVar;
            }
            bVar = new com.adobe.creativesdk.foundation.internal.storage.asset.b(a2, a3);
            return bVar;
        } catch (URISyntaxException unused) {
            return null;
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb
    protected void a(C0474t c0474t) {
        C0489w c0489w = (C0489w) c0474t;
        this.T = a(c0489w.h(), c0489w.j(), c0489w.i());
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0362ad
    public void a(Object obj) {
        int a2;
        com.adobe.creativesdk.foundation.internal.storage.controllers.utils.g gVar = (com.adobe.creativesdk.foundation.internal.storage.controllers.utils.g) obj;
        if (!(getActivity() instanceof AdobeUxAssetBrowserV2Activity) && C0455p.b(getActivity())) {
            a2 = com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.e.b();
        } else {
            a2 = com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.e.a();
        }
        com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.h hVar = (com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.h) com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.c.a(a2).a("ADOBE_ONE_UP_VIEW_MOBILE_CREATION_CONFIGURATION");
        hVar.a(gVar.f6500c);
        hVar.a(gVar.f6498a);
        hVar.b(gVar.f6499b);
        Intent intent = new Intent();
        intent.setClass(getActivity(), AdobeUXMobilePackageItemOneUpViewerActivity.class);
        intent.putExtra("one_up_controller_code", a2);
        getActivity().startActivityForResult(intent, 2137);
    }
}
