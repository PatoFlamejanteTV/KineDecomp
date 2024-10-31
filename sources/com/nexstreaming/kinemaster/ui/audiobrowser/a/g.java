package com.nexstreaming.kinemaster.ui.audiobrowser.a;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.nexstreaming.app.general.nexasset.assetpackage.ItemCategory;
import com.nexstreaming.app.general.nexasset.assetpackage.db.ItemRecord;
import com.nexstreaming.app.general.nexasset.assetpackage.p;
import com.nexstreaming.app.general.nexasset.assetpackage.r;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.util.J;
import com.nexstreaming.kinemaster.ui.audiobrowser.s;
import com.nexstreaming.kinemaster.ui.audiobrowser.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* compiled from: AssetsLister.java */
/* loaded from: classes.dex */
public class g extends m {

    /* renamed from: d */
    private static final String f21420d = "g";

    /* renamed from: e */
    protected boolean f21421e;

    /* renamed from: f */
    protected List<p> f21422f;

    /* renamed from: g */
    protected List<? extends com.nexstreaming.app.general.nexasset.assetpackage.b> f21423g;

    public g(boolean z) {
        this.f21421e = z;
    }

    public List<u> d(Context context) {
        ArrayList arrayList = new ArrayList();
        for (r rVar : com.nexstreaming.app.general.nexasset.assetpackage.h.e().d(ItemCategory.audio)) {
            ItemRecord itemRecord = (ItemRecord) rVar;
            long subCategoryId = itemRecord.assetPackageRecord.getAssetSubCategory().getSubCategoryId();
            if (subCategoryId == 8 || subCategoryId == 16) {
                String a2 = J.a(context, itemRecord.assetPackageRecord.getAssetName());
                String lowerCase = a2 == null ? null : a2.trim().toLowerCase(Locale.ENGLISH);
                String a3 = J.a(context, rVar.getLabel());
                String str = (lowerCase == null || !a3.trim().toLowerCase(Locale.ENGLISH).contains(lowerCase)) ? a2 + " — " + a3 : null;
                String a4 = a(context, rVar);
                int a5 = a(a4);
                int i = (int) subCategoryId;
                if (i != 8) {
                    if (i == 16 && a3.equalsIgnoreCase(MessengerShareContentUtility.WEBVIEW_RATIO_FULL)) {
                        u uVar = new u(a2, a2, a5, "@kmasset:" + rVar.getAssetPackage().getAssetIdx() + "/" + rVar.getId(), a4, rVar.getAssetPackage());
                        uVar.a(rVar.getAssetPackage().getPriceType());
                        arrayList.add(uVar);
                    }
                } else {
                    u uVar2 = new u(a3, str, a5, "@kmasset:" + rVar.getAssetPackage().getAssetIdx() + "/" + rVar.getId(), a4, rVar.getAssetPackage());
                    uVar2.a(rVar.getAssetPackage().getPriceType());
                    arrayList.add(uVar2);
                }
            }
        }
        Collections.sort(arrayList, new d(this));
        return arrayList;
    }

    @Override // com.nexstreaming.kinemaster.ui.audiobrowser.a.m
    public List<u> b(Context context, long j) {
        ArrayList arrayList = new ArrayList();
        if (this.f21423g != null && r1.size() > j) {
            com.nexstreaming.app.general.nexasset.assetpackage.b bVar = this.f21423g.get((int) j);
            String a2 = J.a(context, bVar.getAssetName());
            String lowerCase = a2 == null ? null : a2.trim().toLowerCase(Locale.ENGLISH);
            for (r rVar : com.nexstreaming.app.general.nexasset.assetpackage.h.e().c(bVar.getAssetId(), ItemCategory.audio)) {
                String a3 = J.a(context, rVar.getLabel());
                String str = (lowerCase == null || !a3.trim().toLowerCase(Locale.ENGLISH).contains(lowerCase)) ? a2 + " — " + a3 : null;
                String a4 = a(context, rVar);
                u uVar = new u(a3, str, a(a4), "@kmasset:" + rVar.getAssetPackage().getAssetIdx() + "/" + rVar.getId(), a4);
                uVar.a(rVar.getAssetPackage().getPriceType());
                arrayList.add(uVar);
            }
            Collections.sort(arrayList, new e(this));
        }
        return arrayList;
    }

    public ResultTask<List<u>> c(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f21433a = new ResultTask<>();
        new c(this, applicationContext).execute(new Void[0]);
        return this.f21433a;
    }

    @Override // com.nexstreaming.kinemaster.ui.audiobrowser.a.m, com.nexstreaming.kinemaster.ui.audiobrowser.t
    public boolean a() {
        List<p> b2 = b();
        if (b2 == null || b2.size() == 0) {
            return false;
        }
        if (this.f21423g == null) {
            if (this.f21421e) {
                this.f21423g = com.nexstreaming.app.general.nexasset.assetpackage.h.e().a(b2.get(0));
            } else {
                this.f21423g = com.nexstreaming.app.general.nexasset.assetpackage.h.e().c(ItemCategory.audio);
                for (int size = this.f21423g.size() - 1; size >= 0; size--) {
                    p assetSubCategory = this.f21423g.get(size).getAssetSubCategory();
                    if (assetSubCategory == null || assetSubCategory.getSubCategoryAlias() == null) {
                        this.f21423g.remove(size);
                    } else if (assetSubCategory.getSubCategoryId() == 9) {
                        this.f21423g.remove(size);
                    }
                }
            }
        }
        List<? extends com.nexstreaming.app.general.nexasset.assetpackage.b> list = this.f21423g;
        return list != null && list.size() > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0038 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected static java.lang.String a(android.content.Context r3, com.nexstreaming.app.general.nexasset.assetpackage.r r4) {
        /*
            r0 = 0
            java.lang.String r1 = r4.getPackageURI()     // Catch: java.lang.Throwable -> L21 java.io.IOException -> L24
            java.lang.String r2 = r4.getId()     // Catch: java.lang.Throwable -> L21 java.io.IOException -> L24
            com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader r3 = com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader.a(r3, r1, r2)     // Catch: java.lang.Throwable -> L21 java.io.IOException -> L24
            java.lang.String r4 = r4.getFilePath()     // Catch: java.io.IOException -> L1f java.lang.Throwable -> L35
            java.io.File r4 = r3.e(r4)     // Catch: java.io.IOException -> L1f java.lang.Throwable -> L35
            java.lang.String r4 = r4.getAbsolutePath()     // Catch: java.io.IOException -> L1f java.lang.Throwable -> L35
            if (r3 == 0) goto L1e
            r3.close()     // Catch: java.io.IOException -> L1e
        L1e:
            return r4
        L1f:
            r4 = move-exception
            goto L26
        L21:
            r4 = move-exception
            r3 = r0
            goto L36
        L24:
            r4 = move-exception
            r3 = r0
        L26:
            java.lang.String r1 = com.nexstreaming.kinemaster.ui.audiobrowser.a.g.f21420d     // Catch: java.lang.Throwable -> L35
            java.lang.String r2 = r4.getMessage()     // Catch: java.lang.Throwable -> L35
            android.util.Log.e(r1, r2, r4)     // Catch: java.lang.Throwable -> L35
            if (r3 == 0) goto L34
            r3.close()     // Catch: java.io.IOException -> L34
        L34:
            return r0
        L35:
            r4 = move-exception
        L36:
            if (r3 == 0) goto L3b
            r3.close()     // Catch: java.io.IOException -> L3b
        L3b:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.audiobrowser.a.g.a(android.content.Context, com.nexstreaming.app.general.nexasset.assetpackage.r):java.lang.String");
    }

    @Override // com.nexstreaming.kinemaster.ui.audiobrowser.a.m
    public List<s> b(Context context) {
        ArrayList arrayList = new ArrayList();
        if (this.f21423g != null) {
            for (int i = 0; i < this.f21423g.size(); i++) {
                s sVar = new s(i, J.a(context, this.f21423g.get(i).getAssetName()), -1, null);
                sVar.a(this.f21423g.get(i).getPriceType());
                arrayList.add(sVar);
            }
            Collections.sort(arrayList, new f(this));
        }
        return arrayList;
    }

    protected static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
                if (extractMetadata != null) {
                    long parseLong = Long.parseLong(extractMetadata);
                    if (parseLong < 2147483647L) {
                        return (int) parseLong;
                    }
                }
            } catch (NumberFormatException e2) {
                Log.e(f21420d, e2.getMessage(), e2);
            } catch (IllegalArgumentException e3) {
                Log.e(f21420d, e3.getMessage(), e3);
            }
            return -1;
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    protected List<p> b() {
        List<p> list = this.f21422f;
        if (list != null) {
            return list;
        }
        this.f21422f = new ArrayList();
        for (p pVar : com.nexstreaming.app.general.nexasset.assetpackage.h.e().a(ItemCategory.audio)) {
            if (this.f21421e && "Sound Effects".equalsIgnoreCase(pVar.getSubCategoryAlias())) {
                this.f21422f.add(pVar);
            } else if (!this.f21421e && !"Sound Effects".equalsIgnoreCase(pVar.getSubCategoryAlias())) {
                this.f21422f.add(pVar);
            }
        }
        return this.f21422f;
    }
}
