package com.nexstreaming.kinemaster.ui.settings;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingFragment.java */
/* loaded from: classes.dex */
public final class aa implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f4231a;
    final /* synthetic */ File b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(Context context, File file) {
        this.f4231a = context;
        this.b = file;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str = null;
        switch (i) {
            case 0:
                str = "com.android.vending";
                break;
            case 1:
                str = "com.xiaomi.market";
                break;
            case 2:
                str = "com.qihoo.appstore";
                break;
        }
        new AlertDialog.Builder(this.f4231a).setTitle("Select Server").setCancelable(false).setItems(new String[]{"Real", "Test"}, new ac(this, str)).setNegativeButton("Cancel", new ab(this)).show();
    }
}
