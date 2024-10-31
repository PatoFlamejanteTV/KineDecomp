package com.crashlytics.android.answers;

import io.fabric.sdk.android.a.b.g;
import io.fabric.sdk.android.l;
import io.fabric.sdk.android.services.common.a;
import io.fabric.sdk.android.services.common.x;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.f;
import java.io.File;
import java.util.List;

/* loaded from: classes.dex */
class SessionAnalyticsFilesSender extends a implements g {
    static final String FILE_CONTENT_TYPE = "application/vnd.crashlytics.android.events";
    static final String FILE_PARAM_NAME = "session_analytics_file_";
    private final String apiKey;

    public SessionAnalyticsFilesSender(l lVar, String str, String str2, f fVar, String str3) {
        super(lVar, str, str2, fVar, HttpMethod.POST);
        this.apiKey = str3;
    }

    @Override // io.fabric.sdk.android.a.b.g
    public boolean send(List<File> list) {
        HttpRequest httpRequest = getHttpRequest();
        httpRequest.c(a.HEADER_CLIENT_TYPE, "android");
        httpRequest.c(a.HEADER_CLIENT_VERSION, this.kit.getVersion());
        httpRequest.c(a.HEADER_API_KEY, this.apiKey);
        int i = 0;
        for (File file : list) {
            httpRequest.a(FILE_PARAM_NAME + i, file.getName(), FILE_CONTENT_TYPE, file);
            i++;
        }
        io.fabric.sdk.android.f.f().d(Answers.TAG, "Sending " + list.size() + " analytics files to " + getUrl());
        int g2 = httpRequest.g();
        io.fabric.sdk.android.f.f().d(Answers.TAG, "Response code for analytics file send is " + g2);
        return x.a(g2) == 0;
    }
}
