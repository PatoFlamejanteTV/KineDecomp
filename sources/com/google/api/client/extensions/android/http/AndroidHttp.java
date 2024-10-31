package com.google.api.client.extensions.android.http;

import com.google.api.client.extensions.android.AndroidUtils;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.apache.ApacheHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.util.Beta;

@Beta
/* loaded from: classes2.dex */
public class AndroidHttp {
    private AndroidHttp() {
    }

    public static HttpTransport a() {
        return AndroidUtils.b(9) ? new NetHttpTransport() : new ApacheHttpTransport();
    }
}
