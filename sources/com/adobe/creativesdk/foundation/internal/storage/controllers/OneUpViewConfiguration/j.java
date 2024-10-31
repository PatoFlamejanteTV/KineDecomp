package com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.storage.C0533a;

/* compiled from: IAdobeOneUpViewerEventHandler.java */
/* loaded from: classes.dex */
public interface j {
    void a(int i);

    void a(int i, a aVar, Activity activity, AdobeCloud adobeCloud);

    void a(Activity activity, String str, String str2, String str3, View view, boolean z, int i, com.adobe.creativesdk.foundation.internal.utils.a.a aVar);

    void a(Bundle bundle, a aVar, Activity activity, AdobeCloud adobeCloud);

    void a(a aVar, RelativeLayout relativeLayout, TextView textView);

    void a(a aVar, AdobeCloud adobeCloud);

    void a(C0533a c0533a);

    void a(boolean z);

    boolean a();
}
