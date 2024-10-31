package com.google.api.client.http;

import com.google.api.client.util.BackOff;
import com.google.api.client.util.BackOffUtils;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Sleeper;
import java.io.IOException;

@Beta
/* loaded from: classes.dex */
public class HttpBackOffIOExceptionHandler implements HttpIOExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    private final BackOff f2457a;
    private Sleeper b;

    @Override // com.google.api.client.http.HttpIOExceptionHandler
    public boolean a(HttpRequest httpRequest, boolean z) throws IOException {
        if (!z) {
            return false;
        }
        try {
            return BackOffUtils.a(this.b, this.f2457a);
        } catch (InterruptedException e) {
            return false;
        }
    }
}
