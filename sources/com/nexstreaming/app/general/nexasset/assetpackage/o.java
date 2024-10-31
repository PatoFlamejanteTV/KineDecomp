package com.nexstreaming.app.general.nexasset.assetpackage;

import com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader;
import java.util.Iterator;
import java.util.zip.ZipFile;

/* compiled from: AssetPackageReader.java */
/* loaded from: classes2.dex */
public class o implements Iterable<String> {

    /* renamed from: a */
    final /* synthetic */ AssetPackageReader.g f19544a;

    public o(AssetPackageReader.g gVar) {
        this.f19544a = gVar;
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        ZipFile zipFile;
        zipFile = this.f19544a.f19522a;
        return new n(this, zipFile.entries());
    }
}
