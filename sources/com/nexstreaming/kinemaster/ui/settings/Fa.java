package com.nexstreaming.kinemaster.ui.settings;

import android.content.DialogInterface;
import android.widget.Toast;
import java.io.FileWriter;
import java.io.IOException;

/* compiled from: SettingFragment.java */
/* loaded from: classes2.dex */
class Fa implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ StringBuilder f23045a;

    /* renamed from: b */
    final /* synthetic */ Ga f23046b;

    public Fa(Ga ga, StringBuilder sb) {
        this.f23046b = ga;
        this.f23045a = sb;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i != 0 && i == 1) {
            StringBuilder sb = this.f23045a;
            sb.append("#inapp using test sku");
            sb.append("\n");
            sb.append("USING_TEST_SKU=true");
        }
        try {
            FileWriter fileWriter = new FileWriter(this.f23046b.f23054b.f23057b);
            fileWriter.write(this.f23045a.toString());
            fileWriter.close();
            System.exit(0);
        } catch (IOException e2) {
            e2.printStackTrace();
            Toast.makeText(this.f23046b.f23054b.f23056a, "Write failed: " + e2.getMessage(), 0).show();
        }
    }
}
