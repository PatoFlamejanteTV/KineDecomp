package com.google.android.gms.tagmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* loaded from: classes2.dex */
public class PreviewActivity extends Activity {
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            zzdi.d("Preview activity");
            Uri data = getIntent().getData();
            if (!TagManager.a(this).a(data)) {
                String valueOf = String.valueOf(data);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 73);
                sb.append("Cannot preview the app with the uri: ");
                sb.append(valueOf);
                sb.append(". Launching current version instead.");
                String sb2 = sb.toString();
                zzdi.b(sb2);
                AlertDialog create = new AlertDialog.Builder(this).create();
                create.setTitle("Preview failure");
                create.setMessage(sb2);
                create.setButton(-1, "Continue", new r(this));
                create.show();
            }
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
            if (launchIntentForPackage != null) {
                String valueOf2 = String.valueOf(getPackageName());
                zzdi.d(valueOf2.length() != 0 ? "Invoke the launch activity for package name: ".concat(valueOf2) : new String("Invoke the launch activity for package name: "));
                startActivity(launchIntentForPackage);
            } else {
                String valueOf3 = String.valueOf(getPackageName());
                zzdi.d(valueOf3.length() != 0 ? "No launch activity found for package name: ".concat(valueOf3) : new String("No launch activity found for package name: "));
            }
        } catch (Exception e2) {
            String valueOf4 = String.valueOf(e2.getMessage());
            zzdi.c(valueOf4.length() != 0 ? "Calling preview threw an exception: ".concat(valueOf4) : new String("Calling preview threw an exception: "));
        }
    }
}
