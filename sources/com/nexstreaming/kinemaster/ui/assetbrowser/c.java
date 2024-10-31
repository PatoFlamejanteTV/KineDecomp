package com.nexstreaming.kinemaster.ui.assetbrowser;

import com.nexstreaming.kinemaster.ui.projectedit.D;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetBrowserBaseFragment.java */
/* loaded from: classes.dex */
public class c implements D.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f21375a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(i iVar) {
        this.f21375a = iVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.D.a
    public void a(boolean z) {
        if (this.f21375a.Y() != null) {
            this.f21375a.ua();
            if (z) {
                this.f21375a.G();
            }
        }
    }
}
