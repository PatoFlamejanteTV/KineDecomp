package com.nexstreaming.app.general.nexasset.assetpackage;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/* compiled from: AssetPackageReader.java */
/* loaded from: classes2.dex */
class l implements Iterator<String> {

    /* renamed from: a */
    final /* synthetic */ List f19539a;

    /* renamed from: b */
    final /* synthetic */ m f19540b;

    public l(m mVar, List list) {
        this.f19540b = mVar;
        this.f19539a = list;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return !this.f19539a.isEmpty();
    }

    @Override // java.util.Iterator
    public void remove() {
    }

    @Override // java.util.Iterator
    public String next() {
        String b2;
        File[] listFiles;
        File file = (File) this.f19539a.remove(0);
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                this.f19539a.add(file2);
            }
        }
        b2 = this.f19540b.f19541a.b(file);
        return b2;
    }
}
