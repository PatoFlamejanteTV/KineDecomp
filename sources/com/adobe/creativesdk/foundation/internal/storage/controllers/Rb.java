package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.adobe.creativesdk.foundation.internal.storage.AdobeStorageDataSource;
import com.adobe.creativesdk.foundation.internal.storage.C0330a;
import com.adobe.creativesdk.foundation.internal.storage.C0512k;
import com.adobe.creativesdk.foundation.internal.storage.controllers.Db;
import com.adobe.creativesdk.foundation.internal.storage.controllers.Ub;
import com.adobe.creativesdk.foundation.internal.storage.controllers.upload.AdobeUploadAssetData;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetDataSourceType;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFileRenditionType;
import com.adobe.creativesdk.foundation.storage.C0533a;
import com.adobe.creativesdk.foundation.storage.C0578la;
import com.adobe.creativesdk.foundation.storage.C0582ma;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Observer;

/* compiled from: CCFilesListView.java */
/* loaded from: classes.dex */
public abstract class Rb extends Db {
    protected AdobeStorageDataSource k;
    private C0474t l;
    private c m;
    private C0578la n;
    protected boolean o;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: CCFilesListView.java */
    /* loaded from: classes.dex */
    public abstract class a extends Db.a {

        /* renamed from: f, reason: collision with root package name */
        protected ArrayList<C0330a> f5799f;

        public a(Context context) {
            super(context);
        }

        protected C0330a a(C0533a c0533a) {
            C0330a c0330a = new C0330a();
            c0330a.f5272a = c0533a.getGUID();
            c0330a.f5273b = c0533a.getName();
            c0330a.f5275d = c0533a.getModificationDate();
            c0330a.f5274c = c0533a.getCreationDate();
            boolean z = c0533a instanceof AdobeAssetFile;
            c0330a.f5276e = z ? ((AdobeAssetFile) c0533a).getOptionalMetadata() : null;
            c0330a.f5277f = z ? ((AdobeAssetFile) c0533a).getMd5Hash() : null;
            c0330a.f5278g = c0533a;
            c0330a.f5279h = Rb.this.o;
            c0330a.i = z ? ((AdobeAssetFile) c0533a).getFileSize() : 0L;
            return c0330a;
        }

        protected void a(Sa sa, C0578la c0578la, boolean z, boolean z2) {
        }

        int b(C0533a c0533a) {
            return c0533a instanceof AdobeAssetFile ? 0 : 1;
        }

        protected abstract Sa b(ViewGroup viewGroup);

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db.a
        public C0330a c(int i) {
            if (j() == null || i < 0) {
                return null;
            }
            return j().get(i);
        }

        protected abstract Sa c(ViewGroup viewGroup);

        protected C0533a d(int i) {
            C0330a item = getItem(i);
            if (item != null) {
                return (C0533a) item.f5278g;
            }
            return null;
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db.a
        protected int f() {
            if (j() != null) {
                return j().size();
            }
            return 0;
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db.a, android.support.v7.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i >= 0 && i < getItemCount()) {
                return b(d(i));
            }
            return this.f5616c;
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db.a
        protected void h() {
            this.f5799f = null;
        }

        protected ArrayList<C0330a> j() {
            ArrayList<C0533a> b2;
            AdobeStorageDataSource adobeStorageDataSource = Rb.this.k;
            if (adobeStorageDataSource == null) {
                return null;
            }
            if (this.f5799f == null && (b2 = adobeStorageDataSource.g().b()) != null) {
                this.f5799f = new ArrayList<>(b2.size());
                for (int i = 0; i < b2.size(); i++) {
                    this.f5799f.add(a(b2.get(i)));
                }
            }
            return this.f5799f;
        }

        public int k() {
            return 2;
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db.a
        protected boolean b(C0330a c0330a) {
            Object obj;
            if (c0330a == null || (obj = c0330a.f5278g) == null) {
                return false;
            }
            return obj instanceof AdobeAssetFile;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db.a
        public void b(Sa sa, C0330a c0330a, int i) {
            C0578la c0578la;
            Object obj = c0330a.f5278g;
            if ((obj instanceof C0578la) && (c0578la = (C0578la) obj) != null) {
                a(sa, c0578la, c0578la.e(), c0578la.d() || Rb.this.o);
            }
            super.b(sa, c0330a, i);
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db.a
        protected Sa a(ViewGroup viewGroup, int i) {
            if (i == 0) {
                return b(viewGroup);
            }
            if (i == 1) {
                return c(viewGroup);
            }
            return null;
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db.a
        protected boolean a(C0330a c0330a) {
            Object obj;
            return c0330a == null || (obj = c0330a.f5278g) == null || !(obj instanceof C0578la);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db.a
        public boolean a(Sa sa, C0330a c0330a) {
            String c2 = sa.c();
            String str = c0330a.f5272a;
            if (c2 != null && str != null && c2.equalsIgnoreCase(str)) {
                String h2 = sa.h();
                String str2 = c0330a.f5273b;
                boolean z = (h2 == null || str2 == null || !h2.equalsIgnoreCase(str2)) ? false : true;
                if (!z) {
                    return z;
                }
                Object obj = c0330a.f5278g;
                if (obj instanceof AdobeAssetFile) {
                    String d2 = sa.d();
                    String md5Hash = ((AdobeAssetFile) obj).getMd5Hash();
                    if (d2 == null || md5Hash == null || !d2.equalsIgnoreCase(md5Hash)) {
                        z = false;
                    } else {
                        if (com.adobe.creativesdk.foundation.internal.storage.W.b()) {
                            boolean s = sa.s();
                            boolean b2 = Rb.this.b(c0330a);
                            if (s != b2) {
                                sa.a(b2);
                            }
                        }
                        z = true;
                    }
                }
                if (!(c0330a.f5278g instanceof C0578la)) {
                    return z;
                }
            }
            return false;
        }
    }

    /* compiled from: CCFilesListView.java */
    /* loaded from: classes.dex */
    public abstract class b extends a {

        /* renamed from: h, reason: collision with root package name */
        private com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t<C0578la> f5801h;
        private a i;
        private ArrayList<C0330a> j;
        private C0029b k;

        /* compiled from: CCFilesListView.java */
        /* loaded from: classes.dex */
        public class a implements Comparator<C0330a> {

            /* renamed from: a, reason: collision with root package name */
            private boolean f5802a;

            public a(boolean z) {
                this.f5802a = false;
                this.f5802a = z;
            }

            private int b(C0330a c0330a, C0330a c0330a2) {
                char upperCase = Character.toUpperCase(c0330a.f5273b.charAt(0));
                char upperCase2 = Character.toUpperCase(c0330a2.f5273b.charAt(0));
                if (upperCase > upperCase2) {
                    return 1;
                }
                return upperCase < upperCase2 ? -1 : 0;
            }

            private int c(C0330a c0330a, C0330a c0330a2) {
                long time = c0330a.f5275d.getTime();
                long time2 = c0330a2.f5275d.getTime();
                if (time > time2) {
                    return -1;
                }
                return time < time2 ? 1 : 0;
            }

            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(C0330a c0330a, C0330a c0330a2) {
                if (this.f5802a) {
                    return b(c0330a, c0330a2);
                }
                return c(c0330a, c0330a2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: CCFilesListView.java */
        /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.Rb$b$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0029b {

            /* renamed from: a, reason: collision with root package name */
            HashMap<String, Observer> f5804a = new HashMap<>();

            public C0029b() {
            }

            public void a() {
                this.f5804a.clear();
            }

            public void b(AdobeUploadAssetData adobeUploadAssetData, com.adobe.creativesdk.foundation.internal.storage.controllers.upload.z zVar) {
                Observer observer = this.f5804a.get(adobeUploadAssetData.f5272a);
                if (observer == null) {
                    return;
                }
                this.f5804a.remove(adobeUploadAssetData.f5272a);
                b().b(adobeUploadAssetData, observer);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public void c(AdobeUploadAssetData adobeUploadAssetData, com.adobe.creativesdk.foundation.internal.storage.controllers.upload.z zVar) {
                if (b.this.a(adobeUploadAssetData, zVar)) {
                    zVar.a(adobeUploadAssetData.c());
                }
            }

            public void a(AdobeUploadAssetData adobeUploadAssetData, com.adobe.creativesdk.foundation.internal.storage.controllers.upload.z zVar) {
                b(adobeUploadAssetData, zVar);
                Sb sb = new Sb(this, adobeUploadAssetData, zVar);
                this.f5804a.put(adobeUploadAssetData.f5272a, sb);
                b().a(adobeUploadAssetData, sb);
                c(adobeUploadAssetData, zVar);
            }

            private com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t<C0578la> b() {
                return b.this.f5801h;
            }
        }

        public b(Context context) {
            super(context);
            this.k = new C0029b();
        }

        private boolean c(C0330a c0330a) {
            return c0330a instanceof AdobeUploadAssetData;
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Rb.a
        protected Sa b(ViewGroup viewGroup) {
            return this.i.b(viewGroup);
        }

        protected abstract com.adobe.creativesdk.foundation.internal.storage.controllers.upload.z d(ViewGroup viewGroup);

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Rb.a, com.adobe.creativesdk.foundation.internal.storage.controllers.Db.a
        protected int f() {
            if (this.f5801h == null) {
                return 0;
            }
            l();
            return this.j.size();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Rb.a, com.adobe.creativesdk.foundation.internal.storage.controllers.Db.a, android.support.v7.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            int i2 = this.f5616c;
            if (i < 0 || i >= getItemCount()) {
                return i2;
            }
            if (c(c(i))) {
                return 2;
            }
            return super.getItemViewType(i);
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Rb.a, com.adobe.creativesdk.foundation.internal.storage.controllers.Db.a
        protected void h() {
            this.j = null;
            this.i.h();
        }

        protected void l() {
            if (this.j != null) {
                return;
            }
            ArrayList<C0330a> arrayList = new ArrayList<>();
            if (this.f5801h.b().getHref().equals(Rb.this.n.getHref())) {
                arrayList.addAll(this.f5801h.a());
            }
            if (this.i.j() != null) {
                arrayList.addAll(this.i.j());
            }
            a(arrayList, Rb.this.k.h());
            this.j = arrayList;
        }

        public void m() {
            this.f5801h = null;
            this.k.a();
            h();
            notifyDataSetChanged();
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Rb.a, com.adobe.creativesdk.foundation.internal.storage.controllers.Db.a
        protected boolean b(C0330a c0330a) {
            if (c(c0330a)) {
                return false;
            }
            return super.b(c0330a);
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Rb.a
        protected Sa c(ViewGroup viewGroup) {
            return this.i.c(viewGroup);
        }

        public void a(a aVar) {
            this.i = aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Rb.a, com.adobe.creativesdk.foundation.internal.storage.controllers.Db.a
        public C0330a c(int i) {
            l();
            ArrayList<C0330a> arrayList = this.j;
            if (arrayList != null) {
                return arrayList.get(i);
            }
            return null;
        }

        private void b(AdobeUploadAssetData adobeUploadAssetData, com.adobe.creativesdk.foundation.internal.storage.controllers.upload.z zVar) {
            this.k.a(adobeUploadAssetData, zVar);
        }

        public void a(com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t<C0578la> tVar) {
            this.f5801h = tVar;
        }

        private ArrayList<C0330a> a(ArrayList<C0330a> arrayList, AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType adobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType) {
            Collections.sort(arrayList, new a(adobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType == AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType.SORT_TYPE_ALPHA));
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Rb.a, com.adobe.creativesdk.foundation.internal.storage.controllers.Db.a
        public void b(Sa sa, C0330a c0330a, int i) {
            if (c(c0330a)) {
                b((AdobeUploadAssetData) c0330a, (com.adobe.creativesdk.foundation.internal.storage.controllers.upload.z) sa);
                super.b(sa, c0330a, i);
                return;
            }
            super.b(sa, c0330a, i);
        }

        private void c(AdobeUploadAssetData adobeUploadAssetData, com.adobe.creativesdk.foundation.internal.storage.controllers.upload.z zVar) {
            this.k.b(adobeUploadAssetData, zVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Rb.a, com.adobe.creativesdk.foundation.internal.storage.controllers.Db.a
        public boolean a(Sa sa, C0330a c0330a) {
            if (c0330a instanceof AdobeUploadAssetData) {
                String c2 = sa.c();
                String str = c0330a.f5272a;
                boolean z = false;
                if (c2 != null && str != null && c2.equalsIgnoreCase(str)) {
                    String h2 = sa.h();
                    String str2 = c0330a.f5273b;
                    if (h2 != null && str2 != null && h2.equalsIgnoreCase(str2)) {
                        z = true;
                    }
                    if (z) {
                        AdobeUploadAssetData adobeUploadAssetData = (AdobeUploadAssetData) c0330a;
                        com.adobe.creativesdk.foundation.internal.storage.controllers.upload.z zVar = (com.adobe.creativesdk.foundation.internal.storage.controllers.upload.z) sa;
                        zVar.a(adobeUploadAssetData.d());
                        zVar.a(adobeUploadAssetData.c());
                    }
                }
                return z;
            }
            return super.a(sa, c0330a);
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Rb.a, com.adobe.creativesdk.foundation.internal.storage.controllers.Db.a
        protected Sa a(ViewGroup viewGroup, int i) {
            if (i == super.k()) {
                return d(viewGroup);
            }
            return super.a(viewGroup, i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db.a
        public void a(Sa sa, C0330a c0330a, int i) {
            if (c(c0330a) && sa.f5819f != null) {
                c((AdobeUploadAssetData) c0330a, (com.adobe.creativesdk.foundation.internal.storage.controllers.upload.z) sa);
            }
            super.a(sa, c0330a, i);
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Rb.a, com.adobe.creativesdk.foundation.internal.storage.controllers.Db.a
        protected boolean a(C0330a c0330a) {
            if (c0330a instanceof AdobeUploadAssetData) {
                return true;
            }
            return super.a(c0330a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(AdobeUploadAssetData adobeUploadAssetData, com.adobe.creativesdk.foundation.internal.storage.controllers.upload.z zVar) {
            if (zVar.c() != null) {
                return adobeUploadAssetData.f5272a.equalsIgnoreCase(zVar.c());
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CCFilesListView.java */
    /* loaded from: classes.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public b f5806a;

        /* renamed from: b, reason: collision with root package name */
        public com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t<C0578la> f5807b;

        /* renamed from: c, reason: collision with root package name */
        public Db.a f5808c;

        c() {
        }
    }

    public Rb(Context context) {
        super(context);
    }

    private boolean d(C0330a c0330a) {
        return c0330a instanceof AdobeUploadAssetData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    public void a(Sa sa, boolean z, boolean z2, boolean z3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean a(Bitmap bitmap, String str, AdobeAssetFileRenditionType adobeAssetFileRenditionType, C0582ma c0582ma);

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    protected boolean c(C0330a c0330a) {
        return b((C0533a) c0330a.f5278g);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db, com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0457pb
    public void e() {
        this.k.g().a(this.k.d());
        super.e();
    }

    public void p() {
        if (this.m == null) {
            return;
        }
        ((b) this.f5615h).m();
        com.adobe.creativesdk.foundation.internal.utils.o.a().post(new Qb(this));
    }

    protected abstract b q();

    public void r() {
        a(this.k.d().size() <= 0);
    }

    public void b(boolean z) {
        this.o = z;
    }

    public void a(C0474t c0474t) {
        this.l = c0474t;
    }

    protected boolean b(C0533a c0533a) {
        if (c0533a instanceof AdobeAssetFile) {
            return com.adobe.creativesdk.foundation.internal.storage.model.util.i.a(this.l.d(), ((AdobeAssetFile) c0533a).getType(), this.l.c());
        }
        return false;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0377dd
    public boolean a() {
        return com.adobe.creativesdk.foundation.internal.storage.W.b();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    protected boolean a(C0330a c0330a, AdobeAssetFileRenditionType adobeAssetFileRenditionType, C0582ma c0582ma, com.adobe.creativesdk.foundation.storage.sd<Bitmap, AdobeCSDKException> sdVar) {
        C0533a c0533a = (C0533a) c0330a.f5278g;
        Bitmap a2 = a(c0330a.f5272a, adobeAssetFileRenditionType, c0582ma);
        if (a2 != null) {
            sdVar.b(a2);
            return true;
        }
        if (c0533a instanceof AdobeAssetFile) {
            ((AdobeAssetFile) c0533a).getRenditionWithType(adobeAssetFileRenditionType, c0582ma, new Ob(this, sdVar, c0330a, adobeAssetFileRenditionType, c0582ma));
            return true;
        }
        if (c0533a instanceof C0578la) {
            return true;
        }
        if (!d(c0330a)) {
            return false;
        }
        AdobeUploadAssetData adobeUploadAssetData = (AdobeUploadAssetData) c0330a;
        adobeUploadAssetData.p = adobeAssetFileRenditionType;
        adobeUploadAssetData.r = c0582ma;
        a(adobeUploadAssetData, sdVar);
        return true;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    protected boolean b(C0330a c0330a) {
        return com.adobe.creativesdk.foundation.internal.storage.W.b((AdobeAssetFile) c0330a.f5278g);
    }

    private void a(AdobeUploadAssetData adobeUploadAssetData, com.adobe.creativesdk.foundation.storage.sd<Bitmap, AdobeCSDKException> sdVar) {
        Bitmap bitmap = adobeUploadAssetData.k;
        if (bitmap != null) {
            sdVar.b(bitmap);
        } else {
            com.adobe.creativesdk.foundation.internal.storage.controllers.upload.v.c().a(adobeUploadAssetData, new Pb(this, sdVar));
        }
    }

    protected com.adobe.creativesdk.foundation.internal.storage.controllers.commands.d a(C0533a c0533a) {
        com.adobe.creativesdk.foundation.internal.storage.controllers.commands.e eVar = new com.adobe.creativesdk.foundation.internal.storage.controllers.commands.e();
        C0578la c0578la = (C0578la) c0533a;
        if (c0578la instanceof C0512k) {
            C0512k c0512k = (C0512k) c0578la;
            eVar.a(c0512k.h());
            eVar.a(c0512k.d());
        } else {
            eVar.a(com.adobe.creativesdk.foundation.internal.storage.model.resources.e.a(c0578la.getHref()));
        }
        eVar.a(AdobeAssetDataSourceType.AdobeAssetDataSourceFiles);
        return eVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.InterfaceC0377dd
    public void a(Sa sa) {
        C0533a c0533a = (C0533a) this.f5615h.getItem(sa.f()).f5278g;
        if (c0533a == null || !com.adobe.creativesdk.foundation.internal.storage.W.b()) {
            return;
        }
        AdobeAssetFile adobeAssetFile = (AdobeAssetFile) c0533a;
        if (sa.s()) {
            sa.a(false);
            com.adobe.creativesdk.foundation.internal.storage.W.c(adobeAssetFile);
        } else {
            sa.a(true);
            com.adobe.creativesdk.foundation.internal.storage.W.a(adobeAssetFile);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    public void a(int i) {
        C0330a item = this.f5615h.getItem(i);
        C0533a c0533a = item != null ? (C0533a) item.f5278g : null;
        if (c0533a == null) {
            return;
        }
        InterfaceC0362ad interfaceC0362ad = this.f6373b.get();
        if (c0533a instanceof C0578la) {
            if (interfaceC0362ad != null) {
                interfaceC0362ad.a(a(c0533a));
            }
        } else {
            if (c(item) || interfaceC0362ad == null) {
                return;
            }
            interfaceC0362ad.a(item.f5278g);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    protected void a(int i, View view) {
        WeakReference<InterfaceC0362ad> weakReference;
        InterfaceC0362ad interfaceC0362ad;
        C0330a item = this.f5615h.getItem(i);
        C0533a c0533a = item != null ? (C0533a) item.f5278g : null;
        if (c0533a == null || (weakReference = this.f6373b) == null || (interfaceC0362ad = weakReference.get()) == null) {
            return;
        }
        interfaceC0362ad.a(c0533a, view);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db
    void a(C0330a c0330a) {
        Object obj = c0330a.f5278g;
        if (obj instanceof AdobeAssetFile) {
            ((AdobeAssetFile) obj).cancelRenditionRequest();
        }
    }

    public void a(AdobeStorageDataSource adobeStorageDataSource) {
        this.k = adobeStorageDataSource;
    }

    public void a(com.adobe.creativesdk.foundation.internal.storage.controllers.upload.t<C0578la> tVar) {
        this.m = new c();
        c cVar = this.m;
        cVar.f5807b = tVar;
        cVar.f5808c = this.f5615h;
        b q = q();
        q.a((a) this.f5615h);
        q.a(tVar);
        this.m.f5806a = q;
        Db.a aVar = this.f5615h;
        if (aVar instanceof Ub.b) {
            ((Ub.b) aVar).m();
        }
        a(q);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(RecyclerView.Adapter adapter) {
        this.f5615h = (a) adapter;
        this.f5612e.setAdapter(this.f5615h.g());
        this.f5612e.setLayoutManager(c(this.f6372a));
        this.f5615h.notifyDataSetChanged();
    }

    public void a(C0578la c0578la) {
        this.n = c0578la;
    }
}
