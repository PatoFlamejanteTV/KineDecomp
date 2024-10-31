package com.crashlytics.android.core;

import io.fabric.sdk.android.l;
import io.fabric.sdk.android.services.common.a;
import io.fabric.sdk.android.services.common.x;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.f;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
class DefaultCreateReportSpiCall extends a implements CreateReportSpiCall {
    static final String FILE_CONTENT_TYPE = "application/octet-stream";
    static final String FILE_PARAM = "report[file]";
    static final String IDENTIFIER_PARAM = "report[identifier]";
    static final String MULTI_FILE_PARAM = "report[file";

    public DefaultCreateReportSpiCall(l lVar, String str, String str2, f fVar) {
        super(lVar, str, str2, fVar, HttpMethod.POST);
    }

    private HttpRequest applyHeadersTo(HttpRequest httpRequest, CreateReportRequest createReportRequest) {
        httpRequest.c(a.HEADER_API_KEY, createReportRequest.apiKey);
        httpRequest.c(a.HEADER_CLIENT_TYPE, "android");
        httpRequest.c(a.HEADER_CLIENT_VERSION, this.kit.getVersion());
        Iterator<Map.Entry<String, String>> it = createReportRequest.report.getCustomHeaders().entrySet().iterator();
        while (it.hasNext()) {
            httpRequest.a(it.next());
        }
        return httpRequest;
    }

    private HttpRequest applyMultipartDataTo(HttpRequest httpRequest, Report report) {
        httpRequest.e(IDENTIFIER_PARAM, report.getIdentifier());
        if (report.getFiles().length == 1) {
            io.fabric.sdk.android.f.f().d(CrashlyticsCore.TAG, "Adding single file " + report.getFileName() + " to report " + report.getIdentifier());
            httpRequest.a(FILE_PARAM, report.getFileName(), FILE_CONTENT_TYPE, report.getFile());
            return httpRequest;
        }
        int i = 0;
        for (File file : report.getFiles()) {
            io.fabric.sdk.android.f.f().d(CrashlyticsCore.TAG, "Adding file " + file.getName() + " to report " + report.getIdentifier());
            StringBuilder sb = new StringBuilder();
            sb.append(MULTI_FILE_PARAM);
            sb.append(i);
            sb.append("]");
            httpRequest.a(sb.toString(), file.getName(), FILE_CONTENT_TYPE, file);
            i++;
        }
        return httpRequest;
    }

    @Override // com.crashlytics.android.core.CreateReportSpiCall
    public boolean invoke(CreateReportRequest createReportRequest) {
        HttpRequest httpRequest = getHttpRequest();
        applyHeadersTo(httpRequest, createReportRequest);
        applyMultipartDataTo(httpRequest, createReportRequest.report);
        io.fabric.sdk.android.f.f().d(CrashlyticsCore.TAG, "Sending report to: " + getUrl());
        int g2 = httpRequest.g();
        io.fabric.sdk.android.f.f().d(CrashlyticsCore.TAG, "Create report request ID: " + httpRequest.d(a.HEADER_REQUEST_ID));
        io.fabric.sdk.android.f.f().d(CrashlyticsCore.TAG, "Result was: " + g2);
        return x.a(g2) == 0;
    }

    DefaultCreateReportSpiCall(l lVar, String str, String str2, f fVar, HttpMethod httpMethod) {
        super(lVar, str, str2, fVar, httpMethod);
    }
}
