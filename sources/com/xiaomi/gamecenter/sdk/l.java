package com.xiaomi.gamecenter.sdk;

import android.content.DialogInterface;
import android.os.Process;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiCommplatform f4899a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(MiCommplatform miCommplatform) {
        this.f4899a = miCommplatform;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Process.killProcess(Process.myPid());
    }
}
