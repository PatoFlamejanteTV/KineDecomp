package com.nexstreaming.app.general.nexasset.assetpackage;

import com.nexstreaming.kinemaster.network.AbstractC1816e;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetPackageManager.java */
/* loaded from: classes2.dex */
public class d extends AbstractC1816e {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f19527a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ h f19528b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(h hVar, String str) {
        this.f19528b = hVar;
        this.f19527a = str;
    }

    @Override // com.nexstreaming.kinemaster.network.InterfaceC1821j
    public String getAssetId() {
        return this.f19527a;
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
