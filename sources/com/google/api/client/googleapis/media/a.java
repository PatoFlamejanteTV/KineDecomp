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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaUploadErrorHandler.java */
@Beta
/* loaded from: classes.dex */
public class a implements HttpIOExceptionHandler, HttpUnsuccessfulResponseHandler {

    /* renamed from: a */
    static final Logger f2439a = Logger.getLogger(a.class.getName());
    private final MediaHttpUploader b;
    private final HttpIOExceptionHandler c;
    private final HttpUnsuccessfulResponseHandler d;

    public a(MediaHttpUploader mediaHttpUploader, HttpRequest httpRequest) {
        this.b = (MediaHttpUploader) Preconditions.a(mediaHttpUploader);
        this.c = httpRequest.k();
        this.d = httpRequest.j();
        httpRequest.a((HttpIOExceptionHandler) this);
        httpRequest.a((HttpUnsuccessfulResponseHandler) this);
    }

    @Override // com.google.api.client.http.HttpIOExceptionHandler
    public boolean a(HttpRequest httpRequest, boolean z) throws IOException {
        boolean z2 = this.c != null && this.c.a(httpRequest, z);
        if (z2) {
            try {
                this.b.a();
            } catch (IOException e) {
                f2439a.log(Level.WARNING, "exception thrown while calling server callback", (Throwable) e);
            }
        }
        return z2;
    }

    @Override // com.google.api.client.http.HttpUnsuccessfulResponseHandler
    public boolean a(HttpRequest httpRequest, HttpResponse httpResponse, boolean z) throws IOException {
        boolean z2 = this.d != null && this.d.a(httpRequest, httpResponse, z);
        if (z2 && z && httpResponse.d() / 100 == 5) {
            try {
                this.b.a();
            } catch (IOException e) {
                f2439a.log(Level.WARNING, "exception thrown while calling server callback", (Throwable) e);
            }
        }
        return z2;
    }
}
