package com.adobe.creativesdk.foundation.internal.storage.controllers.edit;

import android.support.v4.app.FragmentManager;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloudServiceType;
import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.internal.storage.controllers.C0358a;
import com.adobe.creativesdk.foundation.internal.storage.controllers.commands.AdobeAssetViewBrowserCommandName;
import com.adobe.creativesdk.foundation.internal.storage.controllers.edit.AdobeCCFilesEditAssetData;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;
import com.adobe.creativesdk.foundation.storage.C0533a;
import java.util.ArrayList;

/* compiled from: AdobeCCFilesEditSession.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.edit.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0399q {

    /* renamed from: a, reason: collision with root package name */
    AdobeCCFilesEditOperation f6060a;

    /* renamed from: b, reason: collision with root package name */
    J f6061b;

    /* renamed from: c, reason: collision with root package name */
    FragmentManager f6062c;

    /* renamed from: d, reason: collision with root package name */
    private String f6063d;

    /* renamed from: e, reason: collision with root package name */
    private a f6064e;

    /* renamed from: f, reason: collision with root package name */
    protected int f6065f = 0;

    /* renamed from: g, reason: collision with root package name */
    private AdobeCloud f6066g;

    /* compiled from: AdobeCCFilesEditSession.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.edit.q$a */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public AdobeCCFilesEditOperation f6067a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f6068b = false;

        /* renamed from: c, reason: collision with root package name */
        public ArrayList<AdobeCCFilesEditAssetData> f6069c = new ArrayList<>();

        /* renamed from: d, reason: collision with root package name */
        public ArrayList<AdobeCCFilesEditAssetData> f6070d = new ArrayList<>();

        public int a() {
            return this.f6069c.size();
        }

        public int b() {
            return this.f6070d.size();
        }

        public boolean c() {
            if (!this.f6068b) {
                return false;
            }
            this.f6068b = false;
            return true;
        }

        public void d() {
            this.f6068b = true;
        }
    }

    public C0399q(FragmentManager fragmentManager, AdobeCCFilesEditOperation adobeCCFilesEditOperation, J j, AdobeCloud adobeCloud) {
        this.f6060a = adobeCCFilesEditOperation;
        this.f6061b = j;
        this.f6062c = fragmentManager;
        this.f6066g = adobeCloud;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        a aVar = this.f6064e;
        if (aVar != null) {
            ArrayList<AdobeCCFilesEditAssetData> arrayList = aVar.f6070d;
            if (arrayList != null) {
                arrayList.clear();
            }
            ArrayList<AdobeCCFilesEditAssetData> arrayList2 = this.f6064e.f6069c;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
        }
    }

    private void d() {
        this.f6065f = 0;
        this.f6064e = new a();
        this.f6064e.f6067a = AdobeCCFilesEditOperation.ADOBE_CC_FILE_EDIT_OPERATION_ERASE;
        ra raVar = (ra) this.f6066g.getSessionForService(AdobeCloudServiceType.AdobeCloudServiceTypeStorage);
        if (C0393k.c().b() != null) {
            g();
            for (int i = 0; i < C0393k.c().b().size(); i++) {
                int size = C0393k.c().b().size();
                C0533a c0533a = C0393k.c().b().get(i);
                raVar.a(c0533a, new C0397o(this, c0533a, size));
                if (C0393k.c().b() == null || !com.adobe.creativesdk.foundation.adobeinternal.net.a.b().b()) {
                    return;
                }
            }
        }
    }

    private void e() {
        this.f6065f = 0;
        this.f6064e = new a();
        this.f6064e.f6067a = AdobeCCFilesEditOperation.ADOBE_CC_FILE_EDIT_OPERATION_MOVE;
        ra raVar = (ra) this.f6066g.getSessionForService(AdobeCloudServiceType.AdobeCloudServiceTypeStorage);
        if (C0393k.c().b() != null) {
            g();
            String uri = C0393k.c().b().get(0).getHref().toString();
            if (uri.endsWith("/")) {
                uri = uri.substring(0, uri.length() - 1);
            }
            String substring = uri.substring(0, uri.lastIndexOf("/"));
            if (!substring.endsWith("/")) {
                substring = substring + "/";
            }
            if (substring.equals(this.f6063d)) {
                f();
                return;
            }
            int size = C0393k.c().b().size();
            for (int i = 0; i < C0393k.c().b().size(); i++) {
                C0533a c0533a = C0393k.c().b().get(i);
                raVar.a(this.f6063d, c0533a, new C0396n(this, c0533a, size));
                if (C0393k.c().b() == null) {
                    return;
                }
            }
        }
    }

    private void f() {
        AdobeCCFilesEditAssetData adobeCCFilesEditAssetData;
        int size = C0393k.c().b().size();
        for (int i = 0; i < C0393k.c().b().size(); i++) {
            C0533a c0533a = C0393k.c().b().get(i);
            if (c0533a instanceof AdobeAssetFile) {
                adobeCCFilesEditAssetData = new AdobeCCFilesEditAssetData(c0533a.getName(), (AdobeAssetFile) c0533a, AdobeCCFilesEditAssetData.EditStatus.Error);
            } else {
                adobeCCFilesEditAssetData = new AdobeCCFilesEditAssetData(c0533a.getName(), AdobeCCFilesEditAssetData.EditStatus.Error);
            }
            a(adobeCCFilesEditAssetData);
            this.f6065f++;
            if (this.f6065f == size) {
                C0394l.a(false);
                a aVar = this.f6064e;
                if (aVar != null) {
                    aVar.d();
                }
                this.f6061b.onComplete();
            }
        }
    }

    private void g() {
        C0394l.b(true);
        C0394l.c(true);
        C0358a.a().a(AdobeAssetViewBrowserCommandName.ACTION_ASSETVIEW_EDIT_STARTED);
    }

    public void b() {
        int i = C0398p.f6059a[this.f6060a.ordinal()];
        if (i == 1) {
            d();
        } else {
            if (i != 2) {
                return;
            }
            e();
        }
    }

    public void a(I i) {
        if (this.f6060a == AdobeCCFilesEditOperation.ADOBE_CC_FILE_EDIT_OPERATION_RENAME) {
            b(i);
        }
    }

    private void b(I i) {
        this.f6064e = new a();
        this.f6064e.f6067a = AdobeCCFilesEditOperation.ADOBE_CC_FILE_EDIT_OPERATION_RENAME;
        C0392j c0392j = new C0392j();
        if (C0393k.c().b() != null) {
            C0533a c0533a = C0393k.c().b().get(0);
            c0392j.a(c0533a, new C0395m(this, c0533a), this.f6066g);
            c0392j.a(i);
            c0392j.show(this.f6062c, "AssetRename");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(AdobeCCFilesEditAssetData adobeCCFilesEditAssetData) {
        if (adobeCCFilesEditAssetData.f6028d == AdobeCCFilesEditAssetData.EditStatus.Completed && this.f6064e != null) {
            this.f6064e.f6070d.add(adobeCCFilesEditAssetData);
        } else if (adobeCCFilesEditAssetData.f6028d == AdobeCCFilesEditAssetData.EditStatus.Error && this.f6064e != null) {
            this.f6064e.f6069c.add(adobeCCFilesEditAssetData);
        }
    }

    public C0399q(String str, FragmentManager fragmentManager, AdobeCCFilesEditOperation adobeCCFilesEditOperation, J j, AdobeCloud adobeCloud) {
        this.f6060a = adobeCCFilesEditOperation;
        this.f6061b = j;
        this.f6062c = fragmentManager;
        this.f6063d = str;
        this.f6066g = adobeCloud;
    }

    public a a() {
        return this.f6064e;
    }
}
