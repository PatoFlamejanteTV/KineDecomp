package com.nextreaming.nexeditorui;

import android.app.Activity;
import android.content.DialogInterface;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExpiredActivity.java */
/* loaded from: classes.dex */
public final class ac implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f4510a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(Activity activity) {
        this.f4510a = activity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.nexstreaming.kinemaster.support.i.a(this.f4510a, "NE-DLG", new File[0]);
    }
}
