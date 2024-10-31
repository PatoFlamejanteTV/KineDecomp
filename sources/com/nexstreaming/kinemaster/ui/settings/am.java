package com.nexstreaming.kinemaster.ui.settings;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingFragment.java */
/* loaded from: classes.dex */
public final class am implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ File f4240a;
    final /* synthetic */ Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(File file, Context context) {
        this.f4240a = file;
        this.b = context;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            if (!this.f4240a.exists()) {
                Toast.makeText(this.b, "Config file not found", 0).show();
                return;
            }
            if (this.f4240a.delete()) {
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.b);
                defaultSharedPreferences.edit().remove("apc_sku_date").commit();
                defaultSharedPreferences.edit().remove("apc_skus").commit();
                System.exit(0);
                return;
            }
            Toast.makeText(this.b, "Delete failed", 0).show();
            return;
        }
        if (i == 1) {
            try {
                FileWriter fileWriter = new FileWriter(this.f4240a);
                fileWriter.write("# staging config auto-generated by km config manager\nDEVICE_SUPPORT_SERVER_URL=https://staging-api-kinemaster.nexstreaming.com/updatekmdevicelist/\nDEVICE_SUPPORT_SERVER_TIMEOUT=60000\nDEVICE_SUPPORT_SERVER_CACHE=false");
                fileWriter.close();
                System.exit(0);
                return;
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this.b, "Write failed: " + e.getMessage(), 0).show();
                return;
            }
        }
        if (i == 2) {
            try {
                FileWriter fileWriter2 = new FileWriter(this.f4240a);
                fileWriter2.write("# dev config auto-generated by km config manager\nDEVICE_SUPPORT_SERVER_URL=https://test-api-kinemaster.nexstreaming.com/updatekmdevicelist/\nDEVICE_SUPPORT_SERVER_TIMEOUT=60000\nDEVICE_SUPPORT_SERVER_CACHE=false");
                fileWriter2.close();
                System.exit(0);
                return;
            } catch (IOException e2) {
                e2.printStackTrace();
                Toast.makeText(this.b, "Write failed: " + e2.getMessage(), 0).show();
                return;
            }
        }
        if (i == 3) {
            try {
                FileWriter fileWriter3 = new FileWriter(this.f4240a);
                fileWriter3.write("# local config auto-generated by km config manager\nDEVICE_SUPPORT_LOCAL_ONLY=true");
                fileWriter3.close();
                System.exit(0);
                return;
            } catch (IOException e3) {
                e3.printStackTrace();
                Toast.makeText(this.b, "Write failed: " + e3.getMessage(), 0).show();
                return;
            }
        }
        if (i == 4) {
            try {
                FileWriter fileWriter4 = new FileWriter(this.f4240a);
                fileWriter4.write("# theme dev config auto-generated by km config manager\nTHEME_SERVER_URL=https://test-api-kinemaster.nexstreaming.com/themedownload/\n");
                fileWriter4.close();
                System.exit(0);
                return;
            } catch (IOException e4) {
                e4.printStackTrace();
                Toast.makeText(this.b, "Write failed: " + e4.getMessage(), 0).show();
                return;
            }
        }
        if (i == 5) {
            try {
                FileWriter fileWriter5 = new FileWriter(this.f4240a);
                fileWriter5.write("# update and notify dev config auto-generated by km config manager\nUPDATE_SERVER_URL=https://test-api-tracelog.nexstreaming.com/updateapp/\nNOTIFY_SERVER_URL=https://test-api-tracelog.nexstreaming.com/notifyapp/\n");
                fileWriter5.close();
                System.exit(0);
                return;
            } catch (IOException e5) {
                e5.printStackTrace();
                Toast.makeText(this.b, "Write failed: " + e5.getMessage(), 0).show();
                return;
            }
        }
        if (i == 6) {
            try {
                FileWriter fileWriter6 = new FileWriter(this.f4240a);
                fileWriter6.write("# promocode dev config auto-generated by km config manager\nUSING_TEST_SKU=true");
                fileWriter6.close();
                System.exit(0);
                return;
            } catch (IOException e6) {
                e6.printStackTrace();
                Toast.makeText(this.b, "Write failed: " + e6.getMessage(), 0).show();
                return;
            }
        }
        if (i == 7) {
            try {
                FileWriter fileWriter7 = new FileWriter(this.f4240a);
                fileWriter7.write("# promocode dev config auto-generated by km config manager\nINAPP_TEST=true\nUSING_TEST_SKU=true");
                fileWriter7.close();
                System.exit(0);
                return;
            } catch (IOException e7) {
                e7.printStackTrace();
                Toast.makeText(this.b, "Write failed: " + e7.getMessage(), 0).show();
                return;
            }
        }
        if (i == 8) {
            x.b(this.b, this.f4240a);
        }
    }
}
