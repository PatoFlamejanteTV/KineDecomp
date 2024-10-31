package com.nexstreaming.kinemaster.ui.settings;

import com.nexstreaming.app.general.iab.IABManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AccountInfoV4Fragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.settings.j, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class RunnableC2174j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FragmentC2201x f23156a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2174j(FragmentC2201x fragmentC2201x) {
        this.f23156a = fragmentC2201x;
    }

    @Override // java.lang.Runnable
    public void run() {
        FragmentC2201x fragmentC2201x = this.f23156a;
        IABManager iABManager = fragmentC2201x.F;
        if (iABManager != null) {
            fragmentC2201x.b(iABManager, iABManager.A());
            FragmentC2201x fragmentC2201x2 = this.f23156a;
            IABManager iABManager2 = fragmentC2201x2.F;
            fragmentC2201x2.a(iABManager2, iABManager2.A());
        }
    }
}
