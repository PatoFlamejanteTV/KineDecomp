package com.google.android.gms.tagmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/* loaded from: classes.dex */
public class PreviewActivity extends Activity {
    private void a(String str, String str2, String str3) {
        AlertDialog create = new AlertDialog.Builder(this).create();
        create.setTitle(str);
        create.setMessage(str2);
        create.setButton(-1, str3, new c(this));
        create.show();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            zzbg.c("Preview activity");
            Uri data = getIntent().getData();
            if (!TagManager.a(this).a(data)) {
                String str = "Cannot preview the app with the uri: " + data + ". Launching current version instead.";
                zzbg.b(str);
                a("Preview failure", str, "Continue");
            }
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
            if (launchIntentForPackage == null) {
                zzbg.c("No launch activity found for package name: " + getPackageName());
            } else {
                zzbg.c("Invoke the launch activity for package name: " + getPackageName());
                startActivity(launchIntentForPackage);
            }
        } catch (Exception e) {
            zzbg.a("Calling preview threw an exception: " + e.getMessage());
        }
    }
}
