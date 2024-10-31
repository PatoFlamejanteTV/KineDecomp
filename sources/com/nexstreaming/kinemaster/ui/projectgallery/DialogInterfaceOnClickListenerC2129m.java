package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;
import com.nexstreaming.kinemaster.network.InterfaceC1821j;

/* compiled from: DependencyChecker.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.m, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class DialogInterfaceOnClickListenerC2129m implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ InterfaceC1821j f22951a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C2137q f22952b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterfaceOnClickListenerC2129m(C2137q c2137q, InterfaceC1821j interfaceC1821j) {
        this.f22952b = c2137q;
        this.f22951a = interfaceC1821j;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f22952b.f22969a.a(this.f22951a);
    }
}
