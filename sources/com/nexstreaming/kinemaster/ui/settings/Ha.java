package com.nexstreaming.kinemaster.ui.settings;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import java.io.File;

/* compiled from: SettingFragment.java */
/* loaded from: classes2.dex */
public class Ha implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Context f23056a;

    /* renamed from: b */
    final /* synthetic */ File f23057b;

    public Ha(Context context, File file) {
        this.f23056a = context;
        this.f23057b = file;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        new AlertDialog.Builder(this.f23056a).setTitle("Select Server").setCancelable(false).setItems(new String[]{"Real", "Test"}, new Ga(this, i != 0 ? i != 1 ? i != 2 ? null : "com.qihoo.appstore" : "com.xiaomi.market" : "com.android.vending")).setNegativeButton("Cancel", new Da(this)).show();
    }
}
