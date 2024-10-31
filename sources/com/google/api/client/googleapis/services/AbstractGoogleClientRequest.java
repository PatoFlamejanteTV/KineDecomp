package com.google.api.client.googleapis.services;

import com.google.api.client.googleapis.MethodOverride;
import com.google.api.client.googleapis.batch.BatchCallback;
import com.google.api.client.googleapis.batch.BatchRequest;
import com.google.api.client.googleapis.media.MediaHttpDownloader;
import com.google.api.client.googleapis.media.MediaHttpUploader;
import com.google.api.client.http.AbstractInputStreamContent;
import com.google.api.client.http.EmptyContent;
import com.google.api.client.http.GZipEncoding;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.UriTemplate;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public abstract class AbstractGoogleClientRequest<T> extends GenericData {
    public static final String USER_AGENT_SUFFIX = "Google-API-Java-Client";
    private final AbstractGoogleClient abstractGoogleClient;
    private boolean disableGZipContent;
    private MediaHttpDownloader downloader;
    private final HttpContent httpContent;
    private HttpHeaders lastResponseHeaders;
    private String lastStatusMessage;
    private final String requestMethod;
    private Class<T> responseClass;
    private MediaHttpUploader uploader;
    private final String uriTemplate;
    private HttpHeaders requestHeaders = new HttpHeaders();
    private int lastStatusCode = -1;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractGoogleClientRequest(AbstractGoogleClient abstractGoogleClient, String str, String str2, HttpContent httpContent, Class<T> cls) {
        this.responseClass = (Class) Preconditions.a(cls);
        this.abstractGoogleClient = (AbstractGoogleClient) Preconditions.a(abstractGoogleClient);
        this.requestMethod = (String) Preconditions.a(str);
        this.uriTemplate = (String) Preconditions.a(str2);
        this.httpContent = httpContent;
        String applicationName = abstractGoogleClient.getApplicationName();
        if (applicationName != null) {
            HttpHeaders httpHeaders = this.requestHeaders;
            String valueOf = String.valueOf(String.valueOf(applicationName));
            String valueOf2 = String.valueOf(String.valueOf(USER_AGENT_SUFFIX));
            httpHeaders.l(new StringBuilder(valueOf.length() + 1 + valueOf2.length()).append(valueOf).append(" ").append(valueOf2).toString());
            return;
        }
        this.requestHeaders.l(USER_AGENT_SUFFIX);
    }

    public final boolean getDisableGZipContent() {
        return this.disableGZipContent;
    }

    public AbstractGoogleClientRequest<T> setDisableGZipContent(boolean z) {
        this.disableGZipContent = z;
        return this;
    }

    public final String getRequestMethod() {
        return this.requestMethod;
    }

    public final String getUriTemplate() {
        return this.uriTemplate;
    }

    public final HttpContent getHttpContent() {
        return this.httpContent;
    }

    public AbstractGoogleClient getAbstractGoogleClient() {
        return this.abstractGoogleClient;
    }

    public final HttpHeaders getRequestHeaders() {
        return this.requestHeaders;
    }

    public AbstractGoogleClientRequest<T> setRequestHeaders(HttpHeaders httpHeaders) {
        this.requestHeaders = httpHeaders;
        return this;
    }

    public final HttpHeaders getLastResponseHeaders() {
        return this.lastResponseHeaders;
    }

    public final int getLastStatusCode() {
        return this.lastStatusCode;
    }

    public final String getLastStatusMessage() {
        return this.lastStatusMessage;
    }

    public final Class<T> getResponseClass() {
        return this.responseClass;
    }

    public final MediaHttpUploader getMediaHttpUploader() {
        return this.uploader;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void initializeMediaUpload(AbstractInputStreamContent abstractInputStreamContent) {
        HttpRequestFactory requestFactory = this.abstractGoogleClient.getRequestFactory();
        this.uploader = new MediaHttpUploader(abstractInputStreamContent, requestFactory.a(), requestFactory.b());
        this.uploader.a(this.requestMethod);
        if (this.httpContent != null) {
            this.uploader.a(this.httpContent);
        }
    }

    public final MediaHttpDownloader getMediaHttpDownloader() {
        return this.downloader;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void initializeMediaDownload() {
        HttpRequestFactory requestFactory = this.abstractGoogleClient.getRequestFactory();
        this.downloader = new MediaHttpDownloader(requestFactory.a(), requestFactory.b());
    }

    public GenericUrl buildHttpRequestUrl() {
        return new GenericUrl(UriTemplate.a(this.abstractGoogleClient.getBaseUrl(), this.uriTemplate, (Object) this, true));
    }

    public HttpRequest buildHttpRequest() throws IOException {
        return buildHttpRequest(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HttpRequest buildHttpRequestUsingHead() throws IOException {
        return buildHttpRequest(true);
    }

    private HttpRequest buildHttpRequest(boolean z) throws IOException {
        Preconditions.a(this.uploader == null);
        Preconditions.a(!z || this.requestMethod.equals("GET"));
        HttpRequest a2 = getAbstractGoogleClient().getRequestFactory().a(z ? "HEAD" : this.requestMethod, buildHttpRequestUrl(), this.httpContent);
        new MethodOverride().b(a2);
        a2.a(getAbstractGoogleClient().getObjectParser());
        if (this.httpContent == null && (this.requestMethod.equals("POST") || this.requestMethod.equals("PUT") || this.requestMethod.equals("PATCH"))) {
            a2.a(new EmptyContent());
        }
        a2.g().putAll(this.requestHeaders);
        if (!this.disableGZipContent) {
            a2.a(new GZipEncoding());
        }
        a2.a(new a(this, a2.l(), a2));
        return a2;
    }

    public HttpResponse executeUnparsed() throws IOException {
        return executeUnparsed(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HttpResponse executeMedia() throws IOException {
        set("alt", (Object) "media");
        return executeUnparsed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HttpResponse executeUsingHead() throws IOException {
        Preconditions.a(this.uploader == null);
        HttpResponse executeUnparsed = executeUnparsed(true);
        executeUnparsed.h();
        return executeUnparsed;
    }

    private HttpResponse executeUnparsed(boolean z) throws IOException {
        HttpResponse a2;
        if (this.uploader == null) {
            a2 = buildHttpRequest(z).p();
        } else {
            GenericUrl buildHttpRequestUrl = buildHttpRequestUrl();
            boolean o = getAbstractGoogleClient().getRequestFactory().a(this.requestMethod, buildHttpRequestUrl, this.httpContent).o();
            a2 = this.uploader.a(this.requestHeaders).a(this.disableGZipContent).a(buildHttpRequestUrl);
            a2.f().a(getAbstractGoogleClient().getObjectParser());
            if (o && !a2.c()) {
                throw newExceptionOnError(a2);
            }
        }
        this.lastResponseHeaders = a2.b();
        this.lastStatusCode = a2.d();
        this.lastStatusMessage = a2.e();
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IOException newExceptionOnError(HttpResponse httpResponse) {
        return new HttpResponseException(httpResponse);
    }

    public T execute() throws IOException {
        return (T) executeUnparsed().a(this.responseClass);
    }

    public InputStream executeAsInputStream() throws IOException {
        return executeUnparsed().g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public InputStream executeMediaAsInputStream() throws IOException {
        return executeMedia().g();
    }

    public void executeAndDownloadTo(OutputStream outputStream) throws IOException {
        executeUnparsed().a(outputStream);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void executeMediaAndDownloadTo(OutputStream outputStream) throws IOException {
        if (this.downloader == null) {
            executeMedia().a(outputStream);
        } else {
            this.downloader.a(buildHttpRequestUrl(), this.requestHeaders, outputStream);
        }
    }

    public final <E> void queue(BatchRequest batchRequest, Class<E> cls, BatchCallback<T, E> batchCallback) throws IOException {
        Preconditions.a(this.uploader == null, "Batching media requests is not supported");
        batchRequest.a(buildHttpRequest(), getResponseClass(), cls, batchCallback);
    }

    @Override // com.google.api.client.util.GenericData
    public AbstractGoogleClientRequest<T> set(String str, Object obj) {
        return (AbstractGoogleClientRequest) super.set(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void checkRequiredParameter(Object obj, String str) {
        Preconditions.a(this.abstractGoogleClient.getSuppressRequiredParameterChecks() || obj != null, "Required parameter %s must be specified", str);
    }
}
