package com.google.api.client.googleapis.media;

import com.google.api.client.http.HttpIOExceptionHandler;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpUnsuccessfulResponseHandler;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: MediaUploadErrorHandler.java */
@Beta
/* loaded from: classes2.dex */
class a implements HttpUnsuccessfulResponseHandler, HttpIOExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    static final Logger f14691a = Logger.getLogger(a.class.getName());

    /* renamed from: b, reason: collision with root package name */
    private final MediaHttpUploader f14692b;

    /* renamed from: c, reason: collision with root package name */
    private final HttpIOExceptionHandler f14693c;

    /* renamed from: d, reason: collision with root package name */
    private final HttpUnsuccessfulResponseHandler f14694d;

    public a(MediaHttpUploader mediaHttpUploader, HttpRequest httpRequest) {
        Preconditions.a(mediaHttpUploader);
        this.f14692b = mediaHttpUploader;
        this.f14693c = httpRequest.f();
        this.f14694d = httpRequest.n();
        httpRequest.a((HttpIOExceptionHandler) this);
        httpRequest.a((HttpUnsuccessfulResponseHandler) this);
    }

    @Override // com.google.api.client.http.HttpIOExceptionHandler
    public boolean a(HttpRequest httpRequest, boolean z) throws IOException {
        HttpIOExceptionHandler httpIOExceptionHandler = this.f14693c;
        boolean z2 = httpIOExceptionHandler != null && httpIOExceptionHandler.a(httpRequest, z);
        if (z2) {
            try {
                this.f14692b.a();
            } catch (IOException e2) {
                f14691a.log(Level.WARNING, "exception thrown while calling server callback", (Throwable) e2);
            }
        }
        return z2;
    }

    @Override // com.google.api.client.http.HttpUnsuccessfulResponseHandler
    public boolean a(HttpRequest httpRequest, HttpResponse httpResponse, boolean z) throws IOException {
        HttpUnsuccessfulResponseHandler httpUnsuccessfulResponseHandler = this.f14694d;
        boolean z2 = httpUnsuccessfulResponseHandler != null && httpUnsuccessfulResponseHandler.a(httpRequest, httpResponse, z);
        if (z2 && z && httpResponse.g() / 100 == 5) {
            try {
                this.f14692b.a();
            } catch (IOException e2) {
                f14691a.log(Level.WARNING, "exception thrown while calling server callback", (Throwable) e2);
            }
        }
        return z2;
    }
}
