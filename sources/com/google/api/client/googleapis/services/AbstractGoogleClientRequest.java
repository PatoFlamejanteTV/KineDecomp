package com.google.api.client.googleapis.services;

import com.google.api.client.googleapis.GoogleUtils;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public abstract class AbstractGoogleClientRequest<T> extends GenericData {
    private static final String API_VERSION_HEADER = "X-Goog-Api-Client";
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

    /* loaded from: classes2.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final String f14703a = a();

        /* renamed from: b, reason: collision with root package name */
        private static final String f14704b = a(System.getProperty("os.name"));

        /* renamed from: c, reason: collision with root package name */
        private static final String f14705c = b(System.getProperty("os.version"));

        /* JADX INFO: Access modifiers changed from: private */
        public static String b(AbstractGoogleClient abstractGoogleClient) {
            return String.format("java/%s http-google-%s/%s %s/%s", f14703a, a(abstractGoogleClient.getClass().getSimpleName()), b(GoogleUtils.f14645d), f14704b, f14705c);
        }

        private static String a() {
            String property = System.getProperty("java.version");
            return property.startsWith("9") ? "9.0.0" : b(property);
        }

        private static String a(String str) {
            return str.toLowerCase().replaceAll("[^\\w\\d\\-]", "-");
        }

        private static String b(String str) {
            Matcher matcher = Pattern.compile("(\\d+\\.\\d+\\.\\d+).*").matcher(str);
            return matcher.find() ? matcher.group(1) : str;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractGoogleClientRequest(AbstractGoogleClient abstractGoogleClient, String str, String str2, HttpContent httpContent, Class<T> cls) {
        Preconditions.a(cls);
        this.responseClass = cls;
        Preconditions.a(abstractGoogleClient);
        this.abstractGoogleClient = abstractGoogleClient;
        Preconditions.a(str);
        this.requestMethod = str;
        Preconditions.a(str2);
        this.uriTemplate = str2;
        this.httpContent = httpContent;
        String applicationName = abstractGoogleClient.getApplicationName();
        if (applicationName != null) {
            this.requestHeaders.k(applicationName + " " + USER_AGENT_SUFFIX);
        } else {
            this.requestHeaders.k(USER_AGENT_SUFFIX);
        }
        this.requestHeaders.set(API_VERSION_HEADER, (Object) a.b(abstractGoogleClient));
    }

    public HttpRequest buildHttpRequest() throws IOException {
        return buildHttpRequest(false);
    }

    public GenericUrl buildHttpRequestUrl() {
        return new GenericUrl(UriTemplate.a(this.abstractGoogleClient.getBaseUrl(), this.uriTemplate, (Object) this, true));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HttpRequest buildHttpRequestUsingHead() throws IOException {
        return buildHttpRequest(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void checkRequiredParameter(Object obj, String str) {
        Preconditions.a(this.abstractGoogleClient.getSuppressRequiredParameterChecks() || obj != null, "Required parameter %s must be specified", str);
    }

    public T execute() throws IOException {
        return (T) executeUnparsed().a(this.responseClass);
    }

    public void executeAndDownloadTo(OutputStream outputStream) throws IOException {
        executeUnparsed().a(outputStream);
    }

    public InputStream executeAsInputStream() throws IOException {
        return executeUnparsed().b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HttpResponse executeMedia() throws IOException {
        set("alt", (Object) "media");
        return executeUnparsed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void executeMediaAndDownloadTo(OutputStream outputStream) throws IOException {
        MediaHttpDownloader mediaHttpDownloader = this.downloader;
        if (mediaHttpDownloader == null) {
            executeMedia().a(outputStream);
        } else {
            mediaHttpDownloader.a(buildHttpRequestUrl(), this.requestHeaders, outputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public InputStream executeMediaAsInputStream() throws IOException {
        return executeMedia().b();
    }

    public HttpResponse executeUnparsed() throws IOException {
        return executeUnparsed(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HttpResponse executeUsingHead() throws IOException {
        Preconditions.a(this.uploader == null);
        HttpResponse executeUnparsed = executeUnparsed(true);
        executeUnparsed.i();
        return executeUnparsed;
    }

    public AbstractGoogleClient getAbstractGoogleClient() {
        return this.abstractGoogleClient;
    }

    public final boolean getDisableGZipContent() {
        return this.disableGZipContent;
    }

    public final HttpContent getHttpContent() {
        return this.httpContent;
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

    public final MediaHttpDownloader getMediaHttpDownloader() {
        return this.downloader;
    }

    public final MediaHttpUploader getMediaHttpUploader() {
        return this.uploader;
    }

    public final HttpHeaders getRequestHeaders() {
        return this.requestHeaders;
    }

    public final String getRequestMethod() {
        return this.requestMethod;
    }

    public final Class<T> getResponseClass() {
        return this.responseClass;
    }

    public final String getUriTemplate() {
        return this.uriTemplate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void initializeMediaDownload() {
        HttpRequestFactory requestFactory = this.abstractGoogleClient.getRequestFactory();
        this.downloader = new MediaHttpDownloader(requestFactory.b(), requestFactory.a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void initializeMediaUpload(AbstractInputStreamContent abstractInputStreamContent) {
        HttpRequestFactory requestFactory = this.abstractGoogleClient.getRequestFactory();
        this.uploader = new MediaHttpUploader(abstractInputStreamContent, requestFactory.b(), requestFactory.a());
        this.uploader.a(this.requestMethod);
        HttpContent httpContent = this.httpContent;
        if (httpContent != null) {
            this.uploader.a(httpContent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IOException newExceptionOnError(HttpResponse httpResponse) {
        return new HttpResponseException(httpResponse);
    }

    public final <E> void queue(BatchRequest batchRequest, Class<E> cls, BatchCallback<T, E> batchCallback) throws IOException {
        Preconditions.a(this.uploader == null, "Batching media requests is not supported");
        batchRequest.a(buildHttpRequest(), getResponseClass(), cls, batchCallback);
    }

    public AbstractGoogleClientRequest<T> setDisableGZipContent(boolean z) {
        this.disableGZipContent = z;
        return this;
    }

    public AbstractGoogleClientRequest<T> setRequestHeaders(HttpHeaders httpHeaders) {
        this.requestHeaders = httpHeaders;
        return this;
    }

    private HttpRequest buildHttpRequest(boolean z) throws IOException {
        boolean z2 = true;
        Preconditions.a(this.uploader == null);
        if (z && !this.requestMethod.equals("GET")) {
            z2 = false;
        }
        Preconditions.a(z2);
        HttpRequest a2 = getAbstractGoogleClient().getRequestFactory().a(z ? "HEAD" : this.requestMethod, buildHttpRequestUrl(), this.httpContent);
        new MethodOverride().a(a2);
        a2.a(getAbstractGoogleClient().getObjectParser());
        if (this.httpContent == null && (this.requestMethod.equals("POST") || this.requestMethod.equals("PUT") || this.requestMethod.equals("PATCH"))) {
            a2.a(new EmptyContent());
        }
        a2.e().putAll(this.requestHeaders);
        if (!this.disableGZipContent) {
            a2.a(new GZipEncoding());
        }
        a2.a(new com.google.api.client.googleapis.services.a(this, a2.k(), a2));
        return a2;
    }

    private HttpResponse executeUnparsed(boolean z) throws IOException {
        HttpResponse a2;
        if (this.uploader == null) {
            a2 = buildHttpRequest(z).a();
        } else {
            GenericUrl buildHttpRequestUrl = buildHttpRequestUrl();
            boolean l = getAbstractGoogleClient().getRequestFactory().a(this.requestMethod, buildHttpRequestUrl, this.httpContent).l();
            a2 = this.uploader.a(this.requestHeaders).a(this.disableGZipContent).a(buildHttpRequestUrl);
            a2.f().a(getAbstractGoogleClient().getObjectParser());
            if (l && !a2.j()) {
                throw newExceptionOnError(a2);
            }
        }
        this.lastResponseHeaders = a2.e();
        this.lastStatusCode = a2.g();
        this.lastStatusMessage = a2.h();
        return a2;
    }

    @Override // com.google.api.client.util.GenericData
    public AbstractGoogleClientRequest<T> set(String str, Object obj) {
        super.set(str, obj);
        return this;
    }
}
