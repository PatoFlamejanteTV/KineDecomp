package com.nexstreaming.kinemaster.codeccaps;

import android.app.Activity;
import android.content.DialogInterface;
import java.io.File;

/* compiled from: CapabilityCheckPopup.java */
/* renamed from: com.nexstreaming.kinemaster.codeccaps.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1725m implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f20106a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ File f20107b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ File f20108c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ C1727o f20109d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterfaceOnClickListenerC1725m(C1727o c1727o, Activity activity, File file, File file2) {
        this.f20109d = c1727o;
        this.f20106a = activity;
        this.f20107b = file;
        this.f20108c = file2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.nexstreaming.kinemaster.support.v.a(this.f20106a, null, "Codec-Capability-Checker", this.f20107b, this.f20108c);
    }
}
