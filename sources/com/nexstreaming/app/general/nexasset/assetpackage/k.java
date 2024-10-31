package com.nexstreaming.app.general.nexasset.assetpackage;

import android.content.res.AssetManager;
import com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: AssetPackageReader.java */
/* loaded from: classes2.dex */
public class k implements Iterable<String> {

    /* renamed from: a */
    final /* synthetic */ AssetPackageReader.b f19538a;

    public k(AssetPackageReader.b bVar) {
        this.f19538a = bVar;
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        String[] strArr;
        String str;
        AssetManager assetManager;
        String str2;
        ArrayList arrayList = new ArrayList();
        try {
            assetManager = this.f19538a.f19510b;
            str2 = this.f19538a.f19509a;
            strArr = assetManager.list(str2);
        } catch (IOException e2) {
            e2.printStackTrace();
            strArr = null;
        }
        if (strArr != null) {
            for (String str3 : strArr) {
                str = this.f19538a.f19509a;
                arrayList.add(AssetPackageReader.b(str, str3));
            }
        }
        return new j(this, arrayList);
    }
}
