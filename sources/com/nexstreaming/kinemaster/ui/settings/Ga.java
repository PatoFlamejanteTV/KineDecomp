package com.nexstreaming.kinemaster.ui.settings;

import android.app.AlertDialog;
import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingFragment.java */
/* loaded from: classes2.dex */
public class Ga implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f23053a;

    /* renamed from: b */
    final /* synthetic */ Ha f23054b;

    public Ga(Ha ha, String str) {
        this.f23054b = ha;
        this.f23053a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        StringBuilder sb = new StringBuilder("#auto-generated by km config manager\n");
        sb.append("#selected installer");
        sb.append("\n");
        sb.append("INAPP_INSTALLER=" + this.f23053a);
        sb.append("\n");
        if (i != 0 && i == 1) {
            sb.append("#inapp using test server");
            sb.append("\n");
            sb.append("INAPP_TEST=true");
            sb.append("\n");
        }
        new AlertDialog.Builder(this.f23054b.f23056a).setTitle("Choose SKU type").setCancelable(false).setItems(new String[]{"Real", "Test"}, new Fa(this, sb)).setNegativeButton("Cancel", new Ea(this)).show();
    }
}