package com.nexstreaming.kinemaster.codeccaps;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CapabilityCheckPopup.java */
/* renamed from: com.nexstreaming.kinemaster.codeccaps.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class DialogInterfaceOnClickListenerC1720h implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1728p f20099a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterfaceOnClickListenerC1720h(C1728p c1728p) {
        this.f20099a = c1728p;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        CapabilityChecker capabilityChecker;
        capabilityChecker = this.f20099a.f20114c;
        capabilityChecker.b();
        dialogInterface.dismiss();
    }
}
