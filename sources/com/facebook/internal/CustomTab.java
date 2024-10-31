package com.facebook.internal;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import b.b.c.j;
import com.facebook.FacebookSdk;

/* loaded from: classes.dex */
public class CustomTab {
    private Uri uri;

    public CustomTab(String str, Bundle bundle) {
        bundle = bundle == null ? new Bundle() : bundle;
        this.uri = Utility.buildUri(ServerProtocol.getDialogAuthority(), FacebookSdk.getGraphApiVersion() + "/" + ServerProtocol.DIALOG_PATH + str, bundle);
    }

    public void openCustomTab(Activity activity, String str) {
        b.b.c.j a2 = new j.a().a();
        a2.f3280a.setPackage(str);
        a2.f3280a.addFlags(1073741824);
        a2.a(activity, this.uri);
    }
}
