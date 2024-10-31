package com.nexstreaming.app.general.nexasset.assetpackage;

import com.nexstreaming.kinemaster.network.AbstractC1816e;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetPackageManager.java */
/* loaded from: classes2.dex */
public class c extends AbstractC1816e {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f19524a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f19525b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ h f19526c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(h hVar, int i, String str) {
        this.f19526c = hVar;
        this.f19524a = i;
        this.f19525b = str;
    }

    @Override // com.nexstreaming.kinemaster.network.InterfaceC1821j
    public String getAssetId() {
        return this.f19525b;
    }

    @Override // com.nexstreaming.kinemaster.network.AbstractC1816e, com.nexstreaming.kinemaster.network.InterfaceC1821j
    public int getAssetVersion() {
        return this.f19524a;
    }

    @Override // com.nexstreaming.kinemaster.network.InterfaceC1821j
    public int i() {
        return 0;
    }

    @Override // com.nexstreaming.kinemaster.network.InterfaceC1821j
    public String k() {
        return "local";
    }
}
