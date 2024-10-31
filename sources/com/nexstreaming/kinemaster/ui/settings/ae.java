package com.nexstreaming.kinemaster.ui.settings;

import android.content.DialogInterface;
import android.widget.Toast;
import java.io.FileWriter;
import java.io.IOException;

/* compiled from: SettingFragment.java */
/* loaded from: classes.dex */
class ae implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ StringBuilder f4235a;
    final /* synthetic */ ac b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ac acVar, StringBuilder sb) {
        this.b = acVar;
        this.f4235a = sb;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 1:
                this.f4235a.append("#inapp using test sku").append("\n").append("USING_TEST_SKU=true");
                break;
        }
        try {
            FileWriter fileWriter = new FileWriter(this.b.b.b);
            fileWriter.write(this.f4235a.toString());
            fileWriter.close();
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this.b.b.f4231a, "Write failed: " + e.getMessage(), 0).show();
        }
    }
}
