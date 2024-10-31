package com.google.api.client.googleapis.services;

import com.google.api.client.googleapis.batch.BatchRequest;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Strings;
import java.io.IOException;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class AbstractGoogleClient {
    static final Logger LOGGER = Logger.getLogger(AbstractGoogleClient.class.getName());
    private final String applicationName;
    private final GoogleClientRequestInitializer googleClientRequestInitializer;
    private final ObjectParser objectParser;
    private final HttpRequestFactory requestFactory;
    private final String rootUrl;
    private final String servicePath;
    private boolean suppressPatternChecks;
    private boolean suppressRequiredParameterChecks;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractGoogleClient(Builder builder) {
        this.googleClientRequestInitializer = builder.googleClientRequestInitializer;
        this.rootUrl = normalizeRootUrl(builder.rootUrl);
        this.servicePath = normalizeServicePath(builder.servicePath);
        if (Strings.a(builder.applicationName)) {
            LOGGER.warning("Application name is not set. Call Builder#setApplicationName.");
        }
        this.applicationName = builder.applicationName;
        this.requestFactory = builder.httpRequestInitializer == null ? builder.transport.createRequestFactory() : builder.transport.createRequestFactory(builder.httpRequestInitializer);
        this.objectParser = builder.objectParser;
        this.suppressPatternChecks = builder.suppressPatternChecks;
        this.suppressRequiredParameterChecks = builder.suppressRequiredParameterChecks;
    }

    public final String getRootUrl() {
        return this.rootUrl;
    }

    public final String getServicePath() {
        return this.servicePath;
    }

    public final String getBaseUrl() {
        String valueOf = String.valueOf(this.rootUrl);
        String valueOf2 = String.valueOf(this.servicePath);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public final String getApplicationName() {
        return this.applicationName;
    }

    public final HttpRequestFactory getRequestFactory() {
        return this.requestFactory;
    }

    public final GoogleClientRequestInitializer getGoogleClientRequestInitializer() {
        return this.googleClientRequestInitializer;
    }

    public ObjectParser getObjectParser() {
        return this.objectParser;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
        if (getGoogleClientRequestInitializer() != null) {
            getGoogleClientRequestInitializer().initialize(abstractGoogleClientRequest);
        }
    }

    public final BatchRequest batch() {
        return batch(null);
    }

    public final BatchRequest batch(HttpRequestInitializer httpRequestInitializer) {
        BatchRequest batchRequest = new BatchRequest(getRequestFactory().a(), httpRequestInitializer);
        batchRequest.a(new GenericUrl(String.valueOf(getRootUrl()).concat("batch")));
        return batchRequest;
    }

    public final boolean getSuppressPatternChecks() {
        return this.suppressPatternChecks;
    }

    public final boolean getSuppressRequiredParameterChecks() {
        return this.suppressRequiredParameterChecks;
    }

    static String normalizeRootUrl(String str) {
        Preconditions.a(str, "root URL cannot be null.");
        if (!str.endsWith("/")) {
            return String.valueOf(str).concat("/");
        }
        return str;
    }

    static String normalizeServicePath(String str) {
        Preconditions.a(str, "service path cannot be null");
        if (str.length() == 1) {
            Preconditions.a("/".equals(str), "service path must equal \"/\" if it is of length 1.");
            return "";
        }
        if (str.length() > 0) {
            if (!str.endsWith("/")) {
                str = String.valueOf(str).concat("/");
            }
            if (str.startsWith("/")) {
                return str.substring(1);
            }
            return str;
        }
        return str;
    }

    /* loaded from: classes.dex */
    public static abstract class Builder {
        String applicationName;
        GoogleClientRequestInitializer googleClientRequestInitializer;
        HttpRequestInitializer httpRequestInitializer;
        final ObjectParser objectParser;
        String rootUrl;
        String servicePath;
        boolean suppressPatternChecks;
        boolean suppressRequiredParameterChecks;
        final HttpTransport transport;

        public abstract AbstractGoogleClient build();

        /* JADX INFO: Access modifiers changed from: protected */
        public Builder(HttpTransport httpTransport, String str, String str2, ObjectParser objectParser, HttpRequestInitializer httpRequestInitializer) {
            this.transport = (HttpTransport) Preconditions.a(httpTransport);
            this.objectParser = objectParser;
            setRootUrl(str);
            setServicePath(str2);
            this.httpRequestInitializer = httpRequestInitializer;
        }

        public final HttpTransport getTransport() {
            return this.transport;
        }

        public ObjectParser getObjectParser() {
            return this.objectParser;
        }

        public final String getRootUrl() {
            return this.rootUrl;
        }

        public Builder setRootUrl(String str) {
            this.rootUrl = AbstractGoogleClient.normalizeRootUrl(str);
            return this;
        }

        public final String getServicePath() {
            return this.servicePath;
        }

        public Builder setServicePath(String str) {
            this.servicePath = AbstractGoogleClient.normalizeServicePath(str);
            return this;
        }

        public final GoogleClientRequestInitializer getGoogleClientRequestInitializer() {
            return this.googleClientRequestInitializer;
        }

        public Builder setGoogleClientRequestInitializer(GoogleClientRequestInitializer googleClientRequestInitializer) {
            this.googleClientRequestInitializer = googleClientRequestInitializer;
            return this;
        }

        public final HttpRequestInitializer getHttpRequestInitializer() {
            return this.httpRequestInitializer;
        }

        public Builder setHttpRequestInitializer(HttpRequestInitializer httpRequestInitializer) {
            this.httpRequestInitializer = httpRequestInitializer;
            return this;
        }

        public final String getApplicationName() {
            return this.applicationName;
        }

        public Builder setApplicationName(String str) {
            this.applicationName = str;
            return this;
        }

        public final boolean getSuppressPatternChecks() {
            return this.suppressPatternChecks;
        }

        public Builder setSuppressPatternChecks(boolean z) {
            this.suppressPatternChecks = z;
            return this;
        }

        public final boolean getSuppressRequiredParameterChecks() {
            return this.suppressRequiredParameterChecks;
        }

        public Builder setSuppressRequiredParameterChecks(boolean z) {
            this.suppressRequiredParameterChecks = z;
            return this;
        }

        public Builder setSuppressAllChecks(boolean z) {
            return setSuppressPatternChecks(true).setSuppressRequiredParameterChecks(true);
        }
    }
}
