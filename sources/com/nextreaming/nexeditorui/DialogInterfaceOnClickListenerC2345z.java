package com.nextreaming.nexeditorui;

import android.app.Activity;
import android.content.DialogInterface;
import java.io.File;

/* compiled from: ExpiredActivity.java */
/* renamed from: com.nextreaming.nexeditorui.z */
/* loaded from: classes.dex */
public class DialogInterfaceOnClickListenerC2345z implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Activity f24417a;

    public DialogInterfaceOnClickListenerC2345z(Activity activity) {
        this.f24417a = activity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.nexstreaming.kinemaster.support.v.a(this.f24417a, null, "NE-DLG", new File[0]);
    }
}
