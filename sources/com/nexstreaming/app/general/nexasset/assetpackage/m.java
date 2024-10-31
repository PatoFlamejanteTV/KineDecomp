package com.nexstreaming.app.general.nexasset.assetpackage;

import com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: AssetPackageReader.java */
/* loaded from: classes2.dex */
public class m implements Iterable<String> {

    /* renamed from: a */
    final /* synthetic */ AssetPackageReader.e f19541a;

    public m(AssetPackageReader.e eVar) {
        this.f19541a = eVar;
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        File file;
        ArrayList arrayList = new ArrayList();
        file = this.f19541a.f19513a;
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                arrayList.add(file2);
            }
        }
        return new l(this, arrayList);
    }
}
