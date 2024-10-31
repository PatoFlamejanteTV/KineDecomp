package com.nexstreaming.app.general.nexasset.assetpackage;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import com.nexstreaming.app.general.nexasset.assetpackage.db.AssetPackageRecord;
import com.nexstreaming.app.general.nexasset.assetpackage.db.CategoryRecord;
import com.nexstreaming.app.general.nexasset.assetpackage.db.InstallSourceRecord;
import com.nexstreaming.app.general.nexasset.assetpackage.db.ItemRecord;
import com.nexstreaming.app.general.nexasset.assetpackage.db.SubCategoryRecord;
import com.nexstreaming.app.general.util.C1702f;
import com.nexstreaming.app.general.util.H;
import com.nexstreaming.kinemaster.network.InterfaceC1821j;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.nextreaming.nexvideoeditor.InterfaceC2350a;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: AssetPackageManager.java */
/* loaded from: classes2.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static h f19533a;

    /* renamed from: b, reason: collision with root package name */
    private final com.nexstreaming.app.general.nexasset.assetpackage.db.a f19534b;

    /* renamed from: c, reason: collision with root package name */
    private InstallSourceRecord f19535c;

    private h(Context context) {
        this.f19534b = new com.nexstreaming.app.general.nexasset.assetpackage.db.a(context);
    }

    public static h e() {
        if (f19533a == null) {
            f19533a = new h(KineMasterApplication.f24056d.getApplicationContext());
        }
        return f19533a;
    }

    private InstallSourceRecord h() {
        InstallSourceRecord installSourceRecord = this.f19535c;
        if (installSourceRecord != null) {
            return installSourceRecord;
        }
        InstallSourceRecord installSourceRecord2 = (InstallSourceRecord) this.f19534b.b(InstallSourceRecord.class, "install_source_id = ?", "store");
        if (installSourceRecord2 == null) {
            installSourceRecord2 = new InstallSourceRecord();
            installSourceRecord2.installSourceId = "store";
            installSourceRecord2.installSourceType = InstallSourceType.STORE;
            installSourceRecord2.installSourceVersion = 0L;
            this.f19534b.a((com.nexstreaming.app.general.nexasset.assetpackage.db.a) installSourceRecord2);
        }
        this.f19535c = installSourceRecord2;
        return installSourceRecord2;
    }

    public com.nexstreaming.app.general.nexasset.assetpackage.db.a b() {
        return this.f19534b;
    }

    public void c(File file) {
        InstallSourceRecord a2 = a(InstallSourceType.FOLDER, file.getAbsolutePath());
        a(a2);
        a2.installSourceVersion = 0L;
        this.f19534b.d(a2);
    }

    public List<? extends r> d(ItemCategory itemCategory) {
        return this.f19534b.d(ItemRecord.class, "item_category = ?", itemCategory);
    }

    public InterfaceC2350a f() {
        return new e(this);
    }

    public void g() {
        String[] strArr;
        AssetPackageReader a2;
        int u;
        InstallSourceRecord a3 = a(InstallSourceType.APP_ASSETS, "kmassets");
        if (a3.installSourceVersion != 1570508193095L) {
            List<AssetPackageRecord> d2 = this.f19534b.d(AssetPackageRecord.class, "install_source = ?", Long.valueOf(a3.getDbRowID()));
            AssetManager assets = KineMasterApplication.f24056d.getAssets();
            try {
                String[] list = assets.list("kmassets");
                if (list != null) {
                    for (String str : list) {
                        int i = -1;
                        Iterator<AssetPackageRecord> it = d2.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            AssetPackageRecord next = it.next();
                            if (next.assetId.equals(str)) {
                                i = next.getAssetVersion();
                                d2.remove(next);
                                break;
                            }
                        }
                        String b2 = b("kmassets", str);
                        try {
                            strArr = assets.list(b2);
                        } catch (IOException unused) {
                            strArr = null;
                        }
                        if (strArr != null && strArr.length > 0 && i < (u = (a2 = AssetPackageReader.a(assets, b2, str)).u())) {
                            a(a2, null, new c(this, u, str), a3);
                        }
                    }
                }
                if (!d2.isEmpty()) {
                    a(d2);
                }
                a3.installSourceVersion = 1570508193095L;
                this.f19534b.d(a3);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static h a(Context context) {
        if (f19533a == null && context != null) {
            f19533a = new h(context.getApplicationContext());
        }
        return f19533a;
    }

    public List<b> b(ItemCategory itemCategory) {
        ArrayList arrayList = new ArrayList();
        for (b bVar : this.f19534b.a(AssetPackageRecord.class, (String) null, "install_source DESC, _id DESC", (Object[]) null)) {
            if (a(bVar, itemCategory)) {
                Iterator<? extends r> it = b(bVar.getAssetId(), itemCategory).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (!it.next().isHidden()) {
                        arrayList.add(bVar);
                        break;
                    }
                }
            }
        }
        return arrayList;
    }

    public List<? extends r> d() {
        return this.f19534b.a(ItemRecord.class);
    }

    public boolean a(String str, ItemCategory itemCategory) {
        r a2 = a(str.substring(str.indexOf(47) + 1));
        return a2 != null && a2.getCategory() == itemCategory;
    }

    public b c(String str) {
        return (b) this.f19534b.b(AssetPackageRecord.class, "asset_id = ?", str);
    }

    public List<? extends b> c() {
        return this.f19534b.d(AssetPackageRecord.class, "install_source == ?", Long.valueOf(h()._id));
    }

    public List<? extends r> c(String str, ItemCategory itemCategory) {
        return this.f19534b.d(ItemRecord.class, "asset_package_record = ? AND item_category = ?", Long.valueOf(this.f19534b.c(AssetPackageRecord.class, "asset_id = ?", str)), itemCategory);
    }

    public boolean a(File file) throws IOException {
        AssetPackageReader b2 = AssetPackageReader.b(file, (String) null);
        try {
            Iterator<r> it = b2.s().iterator();
            while (it.hasNext()) {
                int i = g.f19531a[it.next().getType().ordinal()];
                if (i == 1 || i == 2) {
                    return true;
                }
            }
            C1702f.a(b2);
            return false;
        } finally {
            C1702f.a(b2);
        }
    }

    public List<? extends r> b(String str, ItemCategory itemCategory) {
        return this.f19534b.d(ItemRecord.class, "asset_package_record = ? AND item_category = ? AND hidden == ?", Long.valueOf(this.f19534b.c(AssetPackageRecord.class, "asset_id = ?", str)), itemCategory, 0);
    }

    public List<b> c(ItemCategory itemCategory) {
        ArrayList arrayList = new ArrayList();
        for (b bVar : this.f19534b.a(AssetPackageRecord.class)) {
            if (a(bVar, itemCategory)) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public boolean b(File file) throws IOException {
        AssetPackageReader assetPackageReader;
        String str;
        InstallSourceRecord a2 = a(InstallSourceType.FOLDER, file.getAbsolutePath());
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length >= 1) {
            long j = 0;
            for (File file2 : listFiles) {
                j = Math.max(j, file2.lastModified());
            }
            if (a2.installSourceVersion == j) {
                return false;
            }
            a2.installSourceVersion = 0L;
            this.f19534b.d(a2);
            a(a2);
            for (File file3 : listFiles) {
                if (file3.isDirectory()) {
                    str = file3.getName();
                    assetPackageReader = AssetPackageReader.a(file3, str);
                } else if (file3.getName().endsWith(".zip")) {
                    str = file3.getName().substring(0, r6.length() - 4);
                    assetPackageReader = AssetPackageReader.b(file3, str);
                } else {
                    assetPackageReader = null;
                    str = null;
                }
                if (assetPackageReader != null) {
                    a(assetPackageReader, null, new d(this, str), a2);
                }
            }
            a2.installSourceVersion = j;
            this.f19534b.d(a2);
            return true;
        }
        a(a2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(String str, String str2) {
        if (!str2.startsWith("..") && !str2.contains("/..")) {
            if (str.endsWith("/")) {
                return str + str2;
            }
            int lastIndexOf = str.lastIndexOf(47);
            if (lastIndexOf < 0) {
                return str2;
            }
            return str.substring(0, lastIndexOf + 1) + str2;
        }
        throw new SecurityException("Parent Path References Not Allowed");
    }

    public void a(File file, File file2, InterfaceC1821j interfaceC1821j) throws IOException {
        AssetPackageReader b2;
        if (file.isDirectory()) {
            b2 = AssetPackageReader.a(file, interfaceC1821j.getAssetId());
        } else {
            b2 = AssetPackageReader.b(file, interfaceC1821j.getAssetId());
        }
        a(b2, file2, interfaceC1821j, h());
    }

    public List<? extends r> a(String str, ItemCategory itemCategory, ItemRatioType itemRatioType) {
        List<? extends r> d2 = this.f19534b.d(ItemRecord.class, "asset_package_record = ? AND item_category = ?", Long.valueOf(this.f19534b.c(AssetPackageRecord.class, "asset_id = ?", str)), itemCategory);
        if (d2 != null) {
            Iterator<? extends r> it = d2.iterator();
            while (it.hasNext()) {
                r next = it.next();
                if (!a(next.getRatios(), itemRatioType, next.getType())) {
                    it.remove();
                }
            }
            return d2;
        }
        return new ArrayList();
    }

    public b a(int i) {
        return (b) this.f19534b.b(AssetPackageRecord.class, "asset_idx = ?", Integer.valueOf(i));
    }

    public boolean a(b bVar, ItemCategory itemCategory) {
        long c2;
        if (bVar instanceof AssetPackageRecord) {
            c2 = ((AssetPackageRecord) bVar)._id;
        } else {
            c2 = this.f19534b.c(AssetPackageRecord.class, "asset_id = ?", bVar.getAssetId());
        }
        return this.f19534b.a(ItemRecord.class, "asset_package_record = ? AND item_category = ?", Long.valueOf(c2), itemCategory) > 0;
    }

    public List<? extends b> a(a aVar) {
        if (aVar instanceof CategoryRecord) {
            return this.f19534b.d(AssetPackageRecord.class, "category = ?", Long.valueOf(((CategoryRecord) aVar).getDbRowID()));
        }
        throw new UnsupportedOperationException();
    }

    public void b(int i) {
        this.f19534b.a();
        try {
            AssetPackageRecord assetPackageRecord = (AssetPackageRecord) this.f19534b.b(AssetPackageRecord.class, "asset_idx = ?", Integer.valueOf(i));
            Iterator it = this.f19534b.d(ItemRecord.class, "asset_package_record = ?", Long.valueOf(assetPackageRecord.getDbRowID())).iterator();
            while (it.hasNext()) {
                this.f19534b.c((ItemRecord) it.next());
            }
            this.f19534b.c(assetPackageRecord);
            this.f19534b.d();
        } finally {
            this.f19534b.b();
        }
    }

    public List<? extends b> a(p pVar) {
        if (pVar instanceof SubCategoryRecord) {
            return this.f19534b.d(AssetPackageRecord.class, "sub_category = ?", Long.valueOf(((SubCategoryRecord) pVar).getDbRowID()));
        }
        throw new UnsupportedOperationException();
    }

    public List<? extends a> a() {
        ArrayList arrayList = new ArrayList();
        for (CategoryRecord categoryRecord : this.f19534b.a(CategoryRecord.class)) {
            if (this.f19534b.a(AssetPackageRecord.class, "category = ?", Long.valueOf(categoryRecord.getDbRowID())) > 0) {
                arrayList.add(categoryRecord);
            }
        }
        return b(arrayList);
    }

    public void a(Iterable<String> iterable, NexEditor nexEditor, boolean z) {
        if (nexEditor == null || iterable == null) {
            return;
        }
        try {
            nexEditor.b(a(iterable), z);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    public List<? extends r> b(String str) {
        return this.f19534b.d(ItemRecord.class, "asset_package_record = ?", Long.valueOf(this.f19534b.c(AssetPackageRecord.class, "asset_id = ?", str)));
    }

    public String a(Iterable<String> iterable) throws IOException {
        Context applicationContext = KineMasterApplication.f24056d.getApplicationContext();
        StringBuilder sb = new StringBuilder();
        sb.append("<themeset name=\"KM\" defaultTheme=\"none\" defaultTransition=\"none\" >");
        sb.append("<texture id=\"video_out\" video=\"1\" />");
        sb.append("<texture id=\"video_in\" video=\"2\" />");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (String str : iterable) {
            if (str != null) {
                r a2 = a(str);
                if (a2 == null) {
                    Log.w("AssetPackageManager", "Could not find item for id: " + str);
                } else if (a2.getType() == ItemType.renderitem) {
                    continue;
                } else {
                    AssetPackageReader a3 = AssetPackageReader.a(applicationContext, a2.getPackageURI(), a2.getAssetPackage().getAssetId());
                    try {
                        InputStream g2 = a3.g(a2.getFilePath());
                        byteArrayOutputStream.reset();
                        H.a(g2, byteArrayOutputStream);
                        a3.close();
                        sb.append(byteArrayOutputStream.toString());
                    } catch (Throwable th) {
                        a3.close();
                        throw th;
                    }
                }
            }
        }
        sb.append("</themeset>");
        return sb.toString();
    }

    public void b(Iterable<String> iterable, NexEditor nexEditor, boolean z) {
        if (nexEditor == null || iterable == null) {
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Context applicationContext = KineMasterApplication.f24056d.getApplicationContext();
        nexEditor.a(z);
        for (String str : iterable) {
            if (str != null) {
                r a2 = a(str);
                if (a2 == null) {
                    Log.w("AssetPackageManager", "Could not find item for id: " + str);
                } else if (a2.getType() != ItemType.renderitem) {
                    continue;
                } else {
                    try {
                        AssetPackageReader a3 = AssetPackageReader.a(applicationContext, a2.getPackageURI(), a2.getAssetPackage().getAssetId());
                        try {
                            InputStream g2 = a3.g(a2.getFilePath());
                            byteArrayOutputStream.reset();
                            H.a(g2, byteArrayOutputStream);
                            a3.close();
                            nexEditor.a(str, byteArrayOutputStream.toString(), z);
                        } catch (Throwable th) {
                            a3.close();
                            throw th;
                        }
                    } catch (IOException e2) {
                        throw new RuntimeException(e2);
                    }
                }
            }
        }
    }

    private List<a> b(List<? extends a> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList<a> arrayList2 = new ArrayList(list);
        for (AssetCategoryAlias assetCategoryAlias : AssetCategoryAlias.values()) {
            a aVar = null;
            for (a aVar2 : arrayList2) {
                if (!aVar2.getCategoryAlias().equalsIgnoreCase(assetCategoryAlias.name())) {
                    if (aVar2.getCategoryAlias().equalsIgnoreCase(assetCategoryAlias.name() + com.umeng.commonsdk.proguard.e.ap)) {
                    }
                }
                aVar = aVar2;
            }
            if (aVar != null) {
                arrayList.add(aVar);
                arrayList2.remove(aVar);
            }
        }
        if (!arrayList2.isEmpty()) {
            Collections.sort(arrayList2, new f(this));
            arrayList.addAll(arrayList2);
        }
        return arrayList;
    }

    public r a(String str) {
        return (r) this.f19534b.b(ItemRecord.class, "item_id = ?", str);
    }

    public Set<p> a(ItemCategory itemCategory) {
        HashSet hashSet = new HashSet();
        for (r rVar : d()) {
            if (rVar.getCategory() == itemCategory) {
                hashSet.add(rVar.getAssetPackage().getAssetSubCategory());
            }
        }
        return hashSet;
    }

    private InstallSourceRecord a(InstallSourceType installSourceType, String str) {
        String str2;
        int i = g.f19532b[installSourceType.ordinal()];
        if (i == 1) {
            return h();
        }
        if (i == 2) {
            str2 = "assets:" + str;
        } else if (i == 3) {
            str2 = "file:" + str;
        } else {
            throw new IllegalArgumentException();
        }
        InstallSourceRecord installSourceRecord = (InstallSourceRecord) this.f19534b.b(InstallSourceRecord.class, "install_source_id = ?", str2);
        if (installSourceRecord != null) {
            return installSourceRecord;
        }
        InstallSourceRecord installSourceRecord2 = new InstallSourceRecord();
        installSourceRecord2.installSourceId = str2;
        installSourceRecord2.installSourceType = installSourceType;
        installSourceRecord2.installSourceVersion = 0L;
        this.f19534b.a((com.nexstreaming.app.general.nexasset.assetpackage.db.a) installSourceRecord2);
        return installSourceRecord2;
    }

    private static String b(String str, String str2) {
        if (!str2.startsWith("..") && !str2.contains("/..")) {
            if (str.endsWith("/")) {
                return str + str2;
            }
            return str + "/" + str2;
        }
        throw new SecurityException("Parent Path References Not Allowed");
    }

    private void a(AssetPackageReader assetPackageReader, File file, InterfaceC1821j interfaceC1821j, InstallSourceRecord installSourceRecord) throws IOException {
        CategoryRecord categoryRecord;
        SubCategoryRecord subCategoryRecord;
        this.f19534b.a();
        try {
            String str = null;
            if (interfaceC1821j.r() != 0) {
                categoryRecord = (CategoryRecord) this.f19534b.b(CategoryRecord.class, "category_id = ?", Integer.valueOf(interfaceC1821j.r()));
                if (categoryRecord == null) {
                    categoryRecord = new CategoryRecord();
                    categoryRecord.categoryId = interfaceC1821j.r();
                    categoryRecord.categoryName = interfaceC1821j.getCategoryAliasName();
                    categoryRecord.categoryIconURL = interfaceC1821j.g();
                    this.f19534b.b(categoryRecord);
                } else if (!categoryRecord.categoryIconURL.equals(interfaceC1821j.g())) {
                    categoryRecord.categoryIconURL = interfaceC1821j.g();
                    this.f19534b.d(categoryRecord);
                }
            } else {
                categoryRecord = null;
            }
            if (interfaceC1821j.n() != 0) {
                subCategoryRecord = (SubCategoryRecord) this.f19534b.b(SubCategoryRecord.class, "sub_category_id = ?", Integer.valueOf(interfaceC1821j.n()));
                if (subCategoryRecord == null) {
                    subCategoryRecord = new SubCategoryRecord();
                    subCategoryRecord.subCategoryId = interfaceC1821j.n();
                    subCategoryRecord.subCategoryName = interfaceC1821j.c();
                    subCategoryRecord.subCategoryAlias = interfaceC1821j.k();
                    this.f19534b.a((com.nexstreaming.app.general.nexasset.assetpackage.db.a) subCategoryRecord);
                } else {
                    subCategoryRecord.subCategoryName = interfaceC1821j.c();
                    this.f19534b.d(subCategoryRecord);
                }
            } else {
                subCategoryRecord = (SubCategoryRecord) this.f19534b.b(SubCategoryRecord.class, "sub_category_id = ?", -1L);
                if (subCategoryRecord == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("en", "Local");
                    SubCategoryRecord subCategoryRecord2 = new SubCategoryRecord();
                    subCategoryRecord2.subCategoryId = -1L;
                    subCategoryRecord2.subCategoryAlias = "local";
                    subCategoryRecord2.subCategoryName = hashMap;
                    this.f19534b.a((com.nexstreaming.app.general.nexasset.assetpackage.db.a) subCategoryRecord2);
                    subCategoryRecord = subCategoryRecord2;
                }
            }
            AssetPackageRecord assetPackageRecord = new AssetPackageRecord();
            assetPackageRecord.assetIdx = interfaceC1821j.a();
            assetPackageRecord.packageURI = assetPackageReader.v();
            assetPackageRecord.assetId = interfaceC1821j.getAssetId();
            assetPackageRecord.assetUrl = interfaceC1821j.l();
            assetPackageRecord.thumbPath = file == null ? null : file.getAbsolutePath();
            assetPackageRecord.assetDesc = null;
            assetPackageRecord.assetName = interfaceC1821j.j();
            if (assetPackageRecord.assetName.size() < 1) {
                assetPackageRecord.assetName = assetPackageReader.c();
            }
            assetPackageRecord.priceType = interfaceC1821j.getPriceType();
            assetPackageRecord.thumbUrl = interfaceC1821j.e();
            assetPackageRecord.installSource = installSourceRecord;
            assetPackageRecord.category = categoryRecord;
            assetPackageRecord.subCategory = subCategoryRecord;
            File r = assetPackageReader.r();
            if (r != null) {
                str = r.getAbsolutePath();
            }
            assetPackageRecord.localPath = str;
            assetPackageRecord.assetVersion = interfaceC1821j.getAssetVersion();
            assetPackageRecord.assetLevel = assetPackageReader.b();
            this.f19534b.b(assetPackageRecord);
            try {
                for (r rVar : assetPackageReader.s()) {
                    ItemRecord itemRecord = new ItemRecord();
                    itemRecord.assetPackageRecord = assetPackageRecord;
                    itemRecord.itemId = rVar.getId();
                    itemRecord.packageURI = rVar.getPackageURI();
                    itemRecord.filePath = rVar.getFilePath();
                    itemRecord.iconPath = rVar.getIconPath();
                    itemRecord.hidden = rVar.isHidden();
                    itemRecord.thumbPath = rVar.getThumbPath();
                    itemRecord.label = rVar.getLabel();
                    itemRecord.itemType = rVar.getType();
                    itemRecord.itemCategory = rVar.getCategory();
                    itemRecord.sampleText = rVar.getSampleText();
                    itemRecord.ratios = rVar.getRatios();
                    this.f19534b.b(itemRecord);
                }
                assetPackageReader.close();
                this.f19534b.d();
            } catch (Throwable th) {
                assetPackageReader.close();
                throw th;
            }
        } finally {
            this.f19534b.b();
        }
    }

    private boolean a(List<String> list, ItemRatioType itemRatioType, ItemType itemType) {
        if (list == null) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            ItemRatioType itemRatioType2 = ItemRatioType.getEnum(it.next());
            if (itemRatioType2 == null) {
                itemRatioType2 = ItemRatioType.RATIO_16v9;
            }
            if (itemRatioType == itemRatioType2) {
                return true;
            }
        }
        return false;
    }

    private void a(InstallSourceRecord installSourceRecord) {
        this.f19534b.a();
        try {
            for (AssetPackageRecord assetPackageRecord : this.f19534b.d(AssetPackageRecord.class, "install_source = ?", Long.valueOf(installSourceRecord.getDbRowID()))) {
                Iterator it = this.f19534b.d(ItemRecord.class, "asset_package_record = ?", Long.valueOf(assetPackageRecord.getDbRowID())).iterator();
                while (it.hasNext()) {
                    this.f19534b.c((ItemRecord) it.next());
                }
                this.f19534b.c(assetPackageRecord);
            }
            this.f19534b.d();
        } finally {
            this.f19534b.b();
        }
    }

    private void a(List<AssetPackageRecord> list) {
        this.f19534b.a();
        try {
            for (AssetPackageRecord assetPackageRecord : list) {
                Iterator it = this.f19534b.d(ItemRecord.class, "asset_package_record = ?", Long.valueOf(assetPackageRecord.getDbRowID())).iterator();
                while (it.hasNext()) {
                    this.f19534b.c((ItemRecord) it.next());
                }
                this.f19534b.c(assetPackageRecord);
            }
            this.f19534b.d();
        } finally {
            this.f19534b.b();
        }
    }
}
