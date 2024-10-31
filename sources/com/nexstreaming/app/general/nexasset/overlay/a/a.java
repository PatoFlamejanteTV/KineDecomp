package com.nexstreaming.app.general.nexasset.overlay.a;

import com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader;
import com.nexstreaming.app.general.nexasset.assetpackage.r;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.io.IOException;

/* compiled from: AbstractOverlayAsset.java */
/* loaded from: classes2.dex */
public abstract class a implements com.nexstreaming.app.general.nexasset.overlay.b {

    /* renamed from: a, reason: collision with root package name */
    private final r f19590a;

    public a(r rVar) {
        this.f19590a = rVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AssetPackageReader d() throws IOException {
        return AssetPackageReader.a(KineMasterApplication.f24056d.getApplicationContext(), this.f19590a.getPackageURI(), this.f19590a.getAssetPackage().getAssetId());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public r e() {
        return this.f19590a;
    }
}
