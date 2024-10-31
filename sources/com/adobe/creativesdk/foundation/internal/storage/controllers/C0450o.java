package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.storage.controllers.C0432l;
import com.adobe.creativesdk.foundation.internal.storage.controllers.commands.AdobeAssetViewBrowserCommandName;
import com.adobe.creativesdk.foundation.storage.AdobeAssetDataSourceType;
import com.adobe.creativesdk.foundation.storage.AdobePhotoCollection;
import com.adobe.creativesdk.foundation.storage.C0578la;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.EnumSet;
import java.util.List;

/* compiled from: AdobeAssetViewMainBrowserFragment.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0450o extends Fragment implements InterfaceC0367bd {

    /* renamed from: b, reason: collision with root package name */
    private a f6356b;

    /* renamed from: c, reason: collision with root package name */
    private C0368c f6357c;

    /* renamed from: d, reason: collision with root package name */
    private C0373d f6358d;

    /* renamed from: e, reason: collision with root package name */
    private InterfaceC0372cd f6359e;

    /* renamed from: a, reason: collision with root package name */
    private int f6355a = 0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f6360f = false;

    /* compiled from: AdobeAssetViewMainBrowserFragment.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.o$a */
    /* loaded from: classes.dex */
    private class a extends com.adobe.creativesdk.foundation.internal.storage.controllers.commands.c {
        private a() {
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.commands.c
        protected EnumSet<AdobeAssetViewBrowserCommandName> a() {
            return EnumSet.of(AdobeAssetViewBrowserCommandName.NAVIGATE_TO_COLLECTION, AdobeAssetViewBrowserCommandName.NAVIGATE_TO_DESIGNLIBRARY_COLLECTION, AdobeAssetViewBrowserCommandName.NAVIGATE_TO_MOBILECREATION_COLLECTION, AdobeAssetViewBrowserCommandName.NAVIGATE_BACK, AdobeAssetViewBrowserCommandName.ACTION_MENU_SHOW_MY_ACCOUNT, AdobeAssetViewBrowserCommandName.ACTION_ASSETVIEW_OPEN_SELECTED_FILES, AdobeAssetViewBrowserCommandName.ACTION_ASSETVIEW_OPEN_SELECTED_PHOTOS, AdobeAssetViewBrowserCommandName.NAVIGATE_TO_PHOTO_COLLECTION, AdobeAssetViewBrowserCommandName.ASSET_BROWSER_USER_SIGNOUT, AdobeAssetViewBrowserCommandName.ACTION_MENU_CREATE_NEWFOLDER, AdobeAssetViewBrowserCommandName.ACTION_ASSETVIEW_NEWFOLDER_CREATED, AdobeAssetViewBrowserCommandName.ACTION_ASSETVIEW_LIBRARY_CREATED, AdobeAssetViewBrowserCommandName.ACTION_MENU_CREATE_NEWLIBRARY, AdobeAssetViewBrowserCommandName.ACTION_MENU_CREATE_NEW_PHOTOCOLLECTION, AdobeAssetViewBrowserCommandName.ACTION_ASSETVIEW_PHOTOCOLLECTION_CREATED, AdobeAssetViewBrowserCommandName.ACTION_ASSETVIEW_UPLOAD_SHOW_ERROR_DETAILS, AdobeAssetViewBrowserCommandName.ACTION_ASSETVIEW_EDIT_SHOW_ERROR_DETAILS, AdobeAssetViewBrowserCommandName.ACTION_SHOW_CC_DATASOURCE_MYASSETS, AdobeAssetViewBrowserCommandName.ACTION_SHOW_CC_DATASOURCE_MYLIBRARIES, AdobeAssetViewBrowserCommandName.ACTION_ASSET_VIEW_COLLABORATOR_SELF_DELETE);
        }

        /* synthetic */ a(C0450o c0450o, C0445n c0445n) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.commands.c
        public void a(AdobeAssetViewBrowserCommandName adobeAssetViewBrowserCommandName, Object obj) {
            switch (C0445n.f6342a[adobeAssetViewBrowserCommandName.ordinal()]) {
                case 1:
                    com.adobe.creativesdk.foundation.internal.storage.controllers.commands.i iVar = (com.adobe.creativesdk.foundation.internal.storage.controllers.commands.i) obj;
                    C0450o.this.a(iVar.b(), iVar.a(), iVar.c());
                    return;
                case 2:
                    C0450o.this.a((com.adobe.creativesdk.foundation.internal.storage.controllers.commands.j) obj);
                    return;
                case 3:
                    C0450o.this.a((com.adobe.creativesdk.foundation.internal.storage.controllers.commands.g) obj);
                    return;
                case 4:
                default:
                    return;
                case 5:
                    C0450o.this.N();
                    return;
                case 6:
                    C0450o.this.J();
                    return;
                case 7:
                    C0450o.this.K();
                    return;
                case 8:
                    C0450o.this.a(AdobeAssetDataSourceType.AdobeAssetDataSourcePhotos, (com.adobe.creativesdk.foundation.internal.storage.controllers.commands.k) obj);
                    return;
                case 9:
                    C0450o.this.O();
                    return;
                case 10:
                    C0450o.this.c(obj);
                    return;
                case 11:
                    C0450o.this.b(obj);
                    return;
                case 12:
                    C0450o.this.a((C0578la) obj);
                    return;
                case 13:
                    C0450o.this.b((C0578la) obj);
                    return;
                case 14:
                    C0450o.this.F();
                    return;
                case 15:
                    C0450o.this.f((String) obj);
                    return;
                case 16:
                    C0450o.this.G();
                    return;
                case 17:
                    C0450o.this.a((AdobePhotoCollection) obj);
                    return;
                case 18:
                    C0450o.this.L();
                    return;
                case 19:
                    C0450o.this.M();
                    return;
                case 20:
                    C0450o.this.H();
                    return;
            }
        }
    }

    private void E() {
        EnumSet enumSet;
        Bundle arguments = getArguments();
        if (arguments == null || (enumSet = (EnumSet) arguments.getSerializable("DATA_SOURCE_FILTER_ARRAY")) == null || enumSet.isEmpty()) {
            return;
        }
        enumSet.remove(AdobeAssetDataSourceType.AdobeAssetDataSourceLibrary);
        arguments.putSerializable("DATA_SOURCE_FILTER_ARRAY", enumSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        C0432l.a().show(getChildFragmentManager(), "upload_create_new_library");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        C0432l.a(A().a()).show(getChildFragmentManager(), "upload_create_new_collection");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        B();
    }

    private void I() {
        while (true) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            if (childFragmentManager.getBackStackEntryCount() == 1) {
                com.adobe.creativesdk.foundation.internal.notification.b.a().a(new com.adobe.creativesdk.foundation.internal.notification.c(AdobeInternalNotificationID.AdobeCCFilesForceRefreshAssetsList, null));
                return;
            }
            childFragmentManager.popBackStackImmediate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        ((InterfaceC0372cd) getActivity()).b(C0437m.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        ((InterfaceC0372cd) getActivity()).b(C0437m.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        b((Fragment) C0432l.a(getActivity(), getArguments(), this.f6357c));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        b((Fragment) C0432l.a(getActivity(), AdobeAssetDataSourceType.AdobeAssetDataSourceLibrary));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        U u = new U();
        Bundle bundle = new Bundle();
        bundle.putSerializable("ADOBE_CLOUD", A().a());
        u.setArguments(bundle);
        a(u);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        ((InterfaceC0372cd) getActivity()).l();
    }

    private void P() {
        String c2 = this.f6358d.c();
        com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar = null;
        if (c2 != null) {
            try {
                eVar = com.adobe.creativesdk.foundation.internal.storage.model.resources.e.a(new URI(c2));
            } catch (URISyntaxException e2) {
                e2.printStackTrace();
            }
        }
        boolean a2 = this.f6358d.a();
        boolean b2 = this.f6358d.b();
        if (eVar != null) {
            if (!b2) {
                a(eVar);
                return;
            } else {
                g(c2);
                return;
            }
        }
        if (a2) {
            L();
        } else if (b2) {
            M();
        } else {
            L();
        }
    }

    private boolean m(int i) {
        return i == 2134 || i == 2135 || i == 2137 || i == 2136;
    }

    public C0368c A() {
        return this.f6357c;
    }

    public boolean B() {
        if (z().booleanValue()) {
            return true;
        }
        getChildFragmentManager().popBackStack();
        return true;
    }

    public boolean C() {
        return getChildFragmentManager().getBackStackEntryCount() == 0;
    }

    public void D() {
        Bundle extras = getActivity().getIntent().getExtras();
        if (extras == null || !extras.getBoolean("NON_MAIN_BROWSER_FRAGMENT")) {
            P();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle == null) {
            D();
        } else if (getChildFragmentManager().getBackStackEntryCount() == 0) {
            D();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof InterfaceC0372cd) {
            this.f6359e = (InterfaceC0372cd) activity;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6356b = new a(this, null);
        setRetainInstance(true);
        Bundle arguments = getArguments();
        this.f6357c = C0432l.a(arguments);
        this.f6358d = C0432l.c(arguments);
        if (this.f6357c.b() == null || this.f6357c.b().isEmpty()) {
            com.adobe.creativesdk.foundation.internal.storage.na.c().a(this.f6357c.a());
            com.adobe.creativesdk.foundation.internal.storage.na.c().a(true);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(getActivity());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f6355a = 4660;
        frameLayout.setId(this.f6355a);
        com.adobe.creativesdk.foundation.adobeinternal.net.a.b();
        return frameLayout;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        com.adobe.creativesdk.foundation.adobeinternal.net.a.a();
        super.onDestroyView();
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
    public void onResume() {
        super.onResume();
        if (this.f6360f) {
            this.f6360f = false;
            I();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        this.f6356b.b();
        super.onStart();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        this.f6356b.c();
        super.onStop();
    }

    public Boolean z() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Boolean bool = false;
        if (!(childFragmentManager.findFragmentById(this.f6355a) instanceof Va)) {
            return bool;
        }
        Va va = (Va) childFragmentManager.findFragmentById(this.f6355a);
        if (va instanceof AbstractC0414hb) {
            AbstractC0414hb abstractC0414hb = (AbstractC0414hb) va;
            bool = abstractC0414hb.ka();
            if (bool.booleanValue()) {
                abstractC0414hb.B();
            }
        } else if (va instanceof Ua) {
            AbstractC0414hb abstractC0414hb2 = (AbstractC0414hb) ((Ua) va).z();
            if (abstractC0414hb2 == null) {
                return bool;
            }
            bool = abstractC0414hb2.ka();
            if (bool.booleanValue()) {
                abstractC0414hb2.B();
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Object obj) {
        C0432l.b(obj).show(getChildFragmentManager(), "upload_error_details");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str) {
        com.adobe.creativesdk.foundation.internal.storage.controllers.commands.j jVar = new com.adobe.creativesdk.foundation.internal.storage.controllers.commands.j();
        jVar.a(str);
        a(jVar);
    }

    private void g(String str) {
        Jc jc = new Jc();
        Bundle bundle = new Bundle();
        bundle.putString("designLibraryID", str);
        jc.setArguments(bundle);
        b((Fragment) jc);
    }

    void b(Fragment fragment) {
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.replace(this.f6355a, fragment, "CURRENT_FRAGMENT");
        beginTransaction.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(C0578la c0578la) {
        a(AdobeAssetDataSourceType.AdobeAssetDataSourceFiles, com.adobe.creativesdk.foundation.internal.storage.model.resources.e.a(c0578la.getHref()), c0578la.d());
    }

    public void a(AdobeAssetDataSourceType adobeAssetDataSourceType, com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar, boolean z) {
        InterfaceC0372cd interfaceC0372cd = this.f6359e;
        if (interfaceC0372cd != null) {
            interfaceC0372cd.g();
        }
        C0432l.a a2 = C0432l.a(getActivity(), adobeAssetDataSourceType, getArguments(), eVar);
        a2.a().putBoolean("ASSET_CONTAINER_IS_READ_ONLY", z);
        a((Va) Fragment.instantiate(getActivity(), a2.b().getName(), a2.a()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Object obj) {
        C0432l.a(obj).show(getChildFragmentManager(), "edit_error_details");
    }

    public void a(AdobeAssetDataSourceType adobeAssetDataSourceType, com.adobe.creativesdk.foundation.internal.storage.controllers.commands.k kVar) {
        Fd fd = new Fd();
        Bundle a2 = C0432l.a(adobeAssetDataSourceType, getArguments(), (com.adobe.creativesdk.foundation.internal.storage.model.resources.e) null);
        a2.putString("ASSET_CONTAINER_TARGET_COLLECTION_GUID", kVar.c());
        a2.putString("ASSET_CONTAINER_TARGET_COLLECTION_NAME", kVar.d());
        a2.putString("ASSET_CONTAINER_TARGET_COLLECTION_CATALOG_GUID", kVar.a());
        a2.putString("ASSET_CONTAINER_TARGET_COLLECTION_CATALOG_NAME", kVar.b());
        fd.setArguments(a2);
        a(fd);
    }

    void a(Fragment fragment) {
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.replace(this.f6355a, fragment);
        beginTransaction.addToBackStack(null);
        beginTransaction.commit();
    }

    private void a(com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar) {
        E();
        b((Fragment) C0432l.a(getActivity(), getArguments(), this.f6357c, eVar));
    }

    public void a(int i, int i2, Intent intent) {
        if (i2 == -1 && m(i)) {
            if (i == 2135) {
                K();
            } else {
                J();
            }
        }
        if (i2 == -1 && i == 10 && a(intent)) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            C0500yc.b(true);
            childFragmentManager.popBackStackImmediate();
        }
    }

    public boolean a(Intent intent) {
        return intent != null && intent.getBooleanExtra("SELF_DELTE", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.adobe.creativesdk.foundation.internal.storage.controllers.commands.j jVar) {
        Jc jc = new Jc();
        Bundle bundle = new Bundle();
        bundle.putString("designLibraryID", jVar.a());
        bundle.putSerializable("ADOBE_CLOUD", A().a());
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey("DESIGNLIBRARYITEMS_FILTER_ARRAY")) {
            bundle.putSerializable("design_library_items_key", arguments.getSerializable("DESIGNLIBRARYITEMS_FILTER_ARRAY"));
            bundle.putSerializable("design_library_items_filtertype", arguments.getSerializable("DESIGNLIBRARYITEMS_FILTER_TYPE"));
        }
        jc.setArguments(bundle);
        a(jc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.adobe.creativesdk.foundation.internal.storage.controllers.commands.g gVar) {
        C0449nd c0449nd = new C0449nd();
        Bundle bundle = new Bundle();
        bundle.putString("mobilePackageCollectionHref", gVar.a());
        bundle.putString("mobilePackageCollectionParentHref", gVar.c());
        bundle.putString("mobilePackageCollectionModifiedDate", gVar.b());
        c0449nd.setArguments(bundle);
        a(c0449nd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdobePhotoCollection adobePhotoCollection) {
        com.adobe.creativesdk.foundation.internal.storage.controllers.commands.k kVar = new com.adobe.creativesdk.foundation.internal.storage.controllers.commands.k();
        kVar.c(adobePhotoCollection.getGUID());
        kVar.d(adobePhotoCollection.getName());
        kVar.a(adobePhotoCollection.getCatalog().getGUID());
        kVar.b(adobePhotoCollection.getCatalog().getName());
        a(AdobeAssetDataSourceType.AdobeAssetDataSourcePhotos, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(C0578la c0578la) {
        C0432l.a(c0578la).show(getChildFragmentManager(), "upload_create_new_folder");
    }
}
