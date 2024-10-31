package com.nexstreaming.app.general.nexasset.assetpackage;

import android.graphics.Typeface;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.nextreaming.nexvideoeditor.InterfaceC2350a;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetPackageManager.java */
/* loaded from: classes2.dex */
public class e implements InterfaceC2350a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f19529a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(h hVar) {
        this.f19529a = hVar;
    }

    @Override // com.nextreaming.nexvideoeditor.InterfaceC2350a
    public File a(String str, String str2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.nextreaming.nexvideoeditor.InterfaceC2350a
    public InputStream b(String str, String str2) throws IOException {
        String c2;
        r a2 = this.f19529a.a(str);
        AssetPackageReader a3 = AssetPackageReader.a(KineMasterApplication.f24056d.getApplicationContext(), a2.getPackageURI(), a2.getAssetPackage().getAssetId());
        c2 = h.c(a2.getFilePath(), str2);
        return a3.g(c2);
    }

    @Override // com.nextreaming.nexvideoeditor.InterfaceC2350a
    public Typeface a(String str) {
        return com.nexstreaming.kinemaster.fonts.d.b().a(str);
    }
}
