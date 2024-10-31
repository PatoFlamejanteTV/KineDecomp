package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.DialogInterface;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f;

/* compiled from: ProjectEditActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.fg, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class DialogInterfaceOnClickListenerC1894fg implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1947lg f22337a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterfaceOnClickListenerC1894fg(C1947lg c1947lg) {
        this.f22337a = c1947lg;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        InterfaceC2025f interfaceC2025f;
        interfaceC2025f = this.f22337a.f22438a.T;
        interfaceC2025f.d();
        dialogInterface.dismiss();
    }
}
