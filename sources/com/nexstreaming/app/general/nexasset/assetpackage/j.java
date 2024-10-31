package com.nexstreaming.app.general.nexasset.assetpackage;

import android.content.res.AssetManager;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* compiled from: AssetPackageReader.java */
/* loaded from: classes2.dex */
class j implements Iterator<String> {

    /* renamed from: a */
    final /* synthetic */ List f19536a;

    /* renamed from: b */
    final /* synthetic */ k f19537b;

    public j(k kVar, List list) {
        this.f19537b = kVar;
        this.f19536a = list;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return !this.f19536a.isEmpty();
    }

    @Override // java.util.Iterator
    public void remove() {
    }

    @Override // java.util.Iterator
    public String next() {
        String[] strArr;
        String str;
        AssetManager assetManager;
        String str2 = (String) this.f19536a.remove(0);
        try {
            assetManager = this.f19537b.f19538a.f19510b;
            strArr = assetManager.list(str2);
        } catch (IOException unused) {
            strArr = null;
        }
        if (strArr != null && strArr.length > 0) {
            for (String str3 : strArr) {
                this.f19536a.add(AssetPackageReader.b(str2, str3));
            }
        }
        str = this.f19537b.f19538a.f19509a;
        int length = str.length();
        return str2.substring(length > 0 ? length + 1 : 0);
    }
}
