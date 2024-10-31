package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortState;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFolderOrderBy;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFolderOrderDirection;
import com.adobe.creativesdk.foundation.storage.AdobeAssetMimeTypes;
import com.adobe.creativesdk.foundation.storage.C0533a;
import com.adobe.creativesdk.foundation.storage.C0578la;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class AdobeStorageDataSource implements ga, la, ma {

    /* renamed from: a, reason: collision with root package name */
    private static int f5217a = 20;

    /* renamed from: b, reason: collision with root package name */
    ArrayList<C0533a> f5218b;

    /* renamed from: c, reason: collision with root package name */
    ArrayList<C0533a> f5219c;

    /* renamed from: d, reason: collision with root package name */
    String f5220d;

    /* renamed from: e, reason: collision with root package name */
    public da f5221e;

    /* renamed from: f, reason: collision with root package name */
    AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType f5222f;

    /* renamed from: g, reason: collision with root package name */
    boolean f5223g;

    /* renamed from: h, reason: collision with root package name */
    boolean f5224h;
    boolean i;
    boolean j;
    boolean k;
    private C0578la l;
    private WeakReference<ka> m;
    private boolean n = false;
    private int o = 0;
    private int p = 0;
    private DataSourceInternalFilters q;
    boolean r;
    EnumSet<AdobeAssetMimeTypes> s;

    /* loaded from: classes.dex */
    public enum DataSourceInternalFilters {
        FilterOnlyFolders,
        FilterOnlyFiles
    }

    public AdobeStorageDataSource() {
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.f5222f = c.a.a.a.c.a.c.c();
        if (this.f5222f == AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType.SORT_TYPE_ALPHA) {
            this.f5221e = new V();
            this.f5221e.f6566b = c.a.a.a.c.a.c.b();
        } else {
            this.f5221e = new ea();
            this.f5221e.f6566b = c.a.a.a.c.a.c.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ka n() {
        WeakReference<ka> weakReference = this.m;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void f() {
        if (this.j) {
            return;
        }
        if (this.l.c()) {
            this.j = true;
            int i = f5217a;
            ka n = n();
            if (n != null) {
                n.d();
            }
            this.l.a(i, new Z(this));
            return;
        }
        ka n2 = n();
        if (n2 != null) {
            n2.b();
        }
    }

    public da g() {
        return this.f5221e;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.ga
    public int getCount() {
        return e();
    }

    public AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType h() {
        return this.f5222f;
    }

    public boolean i() {
        if ((this.i && !this.f5223g) || !this.l.c()) {
            return false;
        }
        this.i = true;
        if (this.p == 0) {
            this.p = f5217a;
        }
        this.l.a(this.p, new Y(this, this.p));
        return true;
    }

    public ArrayList<C0533a> j() {
        if (this.f5219c == null) {
            return null;
        }
        a(DataSourceInternalFilters.FilterOnlyFiles);
        ArrayList<C0533a> a2 = a(this.f5219c);
        a((DataSourceInternalFilters) null);
        if (this.s == null) {
            return a2;
        }
        ArrayList<C0533a> arrayList = new ArrayList<>();
        Iterator<C0533a> it = a2.iterator();
        while (it.hasNext()) {
            AdobeAssetFile adobeAssetFile = (AdobeAssetFile) it.next();
            if (!a(adobeAssetFile)) {
                arrayList.add(adobeAssetFile);
            }
        }
        return arrayList;
    }

    public void k() {
        this.f5220d = null;
    }

    public boolean l() {
        AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType c2 = c.a.a.a.c.a.c.c();
        if (this.f5222f == c2) {
            return false;
        }
        a(c2, c.a.a.a.c.a.c.b());
        return true;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.ga
    public void b() {
        a((ka) null);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.ga
    public void c() {
        a(false);
    }

    public ArrayList<C0533a> d() {
        return this.f5219c;
    }

    public int e() {
        ArrayList<C0533a> arrayList = this.f5219c;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public void b(boolean z) {
        this.r = z;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.ga
    public boolean a() {
        return a(true);
    }

    public void a(ka kaVar) {
        this.m = kaVar != null ? new WeakReference<>(kaVar) : null;
    }

    public void a(DataSourceInternalFilters dataSourceInternalFilters) {
        this.q = dataSourceInternalFilters;
    }

    public void a(EnumSet<AdobeAssetMimeTypes> enumSet) {
        this.s = enumSet;
    }

    public void a(C0578la c0578la) {
        this.l = c0578la;
    }

    boolean a(AdobeAssetFile adobeAssetFile) {
        return com.adobe.creativesdk.foundation.internal.storage.model.util.i.a(this.s, adobeAssetFile.getType(), this.r);
    }

    public boolean a(boolean z) {
        AdobeAssetFolderOrderDirection adobeAssetFolderOrderDirection;
        AdobeAssetFolderOrderBy adobeAssetFolderOrderBy;
        if (this.i && !this.f5223g) {
            return false;
        }
        if (this.l != null) {
            this.n = z;
            if (z) {
                k();
                this.l.f();
                this.f5218b = new ArrayList<>();
                this.f5219c = new ArrayList<>();
                this.o = 0;
                ka n = n();
                if (n != null) {
                    n.a();
                }
            }
            if (!this.l.c()) {
                return true;
            }
            ka n2 = n();
            if (n2 != null) {
                n2.f();
            }
            return i();
        }
        ka n3 = n();
        if (n3 != null) {
            n3.g();
        }
        this.f5218b = new ArrayList<>();
        this.f5219c = new ArrayList<>();
        if (this.f5221e.f6566b == AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortState.SORT_STATE_ASCENDING) {
            adobeAssetFolderOrderDirection = AdobeAssetFolderOrderDirection.ADOBE_ASSET_FOLDER_ORDER_ASCENDING;
        } else {
            adobeAssetFolderOrderDirection = AdobeAssetFolderOrderDirection.ADOBE_ASSET_FOLDER_ORDER_DESCENDING;
        }
        if (this.f5222f == AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType.SORT_TYPE_ALPHA) {
            adobeAssetFolderOrderBy = AdobeAssetFolderOrderBy.ADOBE_ASSET_FOLDER_ORDER_BY_NAME;
        } else {
            adobeAssetFolderOrderBy = AdobeAssetFolderOrderBy.ADOBE_ASSET_FOLDER_ORDER_BY_MODIFIED;
        }
        this.l = C0578la.a(adobeAssetFolderOrderBy, adobeAssetFolderOrderDirection);
        return i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<C0533a> a(ArrayList<C0533a> arrayList) {
        if (this.q == null) {
            return arrayList;
        }
        ArrayList<C0533a> arrayList2 = new ArrayList<>();
        Iterator<C0533a> it = arrayList.iterator();
        while (it.hasNext()) {
            C0533a next = it.next();
            DataSourceInternalFilters dataSourceInternalFilters = this.q;
            if (dataSourceInternalFilters == DataSourceInternalFilters.FilterOnlyFolders) {
                if (next instanceof C0578la) {
                    arrayList2.add(next);
                }
            } else if (dataSourceInternalFilters == DataSourceInternalFilters.FilterOnlyFiles && (next instanceof AdobeAssetFile)) {
                arrayList2.add(next);
            }
        }
        return arrayList2;
    }

    public void a(AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType adobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType, AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortState adobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortState) {
        AdobeAssetFolderOrderDirection adobeAssetFolderOrderDirection;
        AdobeAssetFolderOrderBy adobeAssetFolderOrderBy;
        if (adobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType == AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType.SORT_TYPE_ALPHA) {
            if (!(this.f5221e instanceof V)) {
                this.f5221e = new V();
            }
        } else if (adobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType == AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType.SORT_TYPE_TIME && !(this.f5221e instanceof ea)) {
            this.f5221e = new ea();
        }
        this.f5222f = adobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType;
        this.f5221e.f6566b = adobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortState;
        if (adobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortState == AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortState.SORT_STATE_ASCENDING) {
            adobeAssetFolderOrderDirection = AdobeAssetFolderOrderDirection.ADOBE_ASSET_FOLDER_ORDER_ASCENDING;
        } else {
            adobeAssetFolderOrderDirection = AdobeAssetFolderOrderDirection.ADOBE_ASSET_FOLDER_ORDER_DESCENDING;
        }
        if (this.f5222f == AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType.SORT_TYPE_ALPHA) {
            adobeAssetFolderOrderBy = AdobeAssetFolderOrderBy.ADOBE_ASSET_FOLDER_ORDER_BY_NAME;
        } else {
            adobeAssetFolderOrderBy = AdobeAssetFolderOrderBy.ADOBE_ASSET_FOLDER_ORDER_BY_MODIFIED;
        }
        this.l.b(adobeAssetFolderOrderBy, adobeAssetFolderOrderDirection);
        ka n = n();
        if (n != null) {
            n.a(adobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType, adobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortState);
        }
        this.f5220d = null;
        if (this.i) {
            this.f5223g = true;
        }
        if (this.j) {
            this.f5224h = true;
            ka n2 = n();
            if (n2 != null) {
                n2.b();
            }
        }
        a(true);
    }

    public void a(String str) {
        ArrayList<C0533a> arrayList;
        if (this.i) {
            this.f5220d = str;
            return;
        }
        if (str != null && str.length() > 0) {
            boolean z = false;
            if (this.f5220d != null && str.length() == this.f5220d.length() && !str.contentEquals(this.f5220d)) {
                z = true;
            }
            if ((this.f5220d != null && str.length() < this.f5220d.length()) || z) {
                arrayList = this.f5218b;
            } else {
                arrayList = this.f5219c;
            }
            this.f5219c = new ArrayList<>();
            String lowerCase = str.toLowerCase();
            Iterator<C0533a> it = arrayList.iterator();
            while (it.hasNext()) {
                C0533a next = it.next();
                if (next.getName().toLowerCase().contains(lowerCase)) {
                    this.f5219c.add(next);
                }
            }
            this.k = true;
            this.f5220d = str;
            ka n = n();
            if (n != null) {
                n.h();
            }
            f();
            return;
        }
        this.f5220d = null;
        this.f5219c = this.f5218b;
        this.k = true;
        ka n2 = n();
        if (n2 != null) {
            n2.h();
        }
    }
}
