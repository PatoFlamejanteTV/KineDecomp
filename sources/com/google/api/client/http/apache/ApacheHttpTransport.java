package com.google.api.client.http.apache;

import com.facebook.internal.Utility;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.SecurityUtils;
import com.google.api.client.util.SslUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import org.apache.http.HttpHost;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.params.ConnRouteParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.conn.ProxySelectorRoutePlanner;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

/* loaded from: classes.dex */
public final class ApacheHttpTransport extends HttpTransport {
    private final HttpClient httpClient;

    public ApacheHttpTransport() {
        this(newDefaultHttpClient());
    }

    public ApacheHttpTransport(HttpClient httpClient) {
        this.httpClient = httpClient;
        HttpParams params = httpClient.getParams();
        HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
        params.setBooleanParameter("http.protocol.handle-redirects", false);
    }

    public static DefaultHttpClient newDefaultHttpClient() {
        return newDefaultHttpClient(SSLSocketFactory.getSocketFactory(), newDefaultHttpParams(), ProxySelector.getDefault());
    }

    static HttpParams newDefaultHttpParams() {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, false);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, Utility.DEFAULT_STREAM_BUFFER_SIZE);
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 200);
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(20));
        return basicHttpParams;
    }

    static DefaultHttpClient newDefaultHttpClient(SSLSocketFactory sSLSocketFactory, HttpParams httpParams, ProxySelector proxySelector) {
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", sSLSocketFactory, 443));
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(httpParams, schemeRegistry), httpParams);
        defaultHttpClient.setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler(0, false));
        if (proxySelector != null) {
            defaultHttpClient.setRoutePlanner(new ProxySelectorRoutePlanner(schemeRegistry, proxySelector));
        }
        return defaultHttpClient;
    }

    @Override // com.google.api.client.http.HttpTransport
    public boolean supportsMethod(String str) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.api.client.http.HttpTransport
    public a buildRequest(String str, String str2) {
        HttpRequestBase dVar;
        if (str.equals("DELETE")) {
            dVar = new HttpDelete(str2);
        } else if (str.equals("GET")) {
            dVar = new HttpGet(str2);
        } else if (str.equals("HEAD")) {
            dVar = new HttpHead(str2);
        } else if (str.equals("POST")) {
            dVar = new HttpPost(str2);
        } else if (str.equals("PUT")) {
            dVar = new HttpPut(str2);
        } else if (str.equals("TRACE")) {
            dVar = new HttpTrace(str2);
        } else if (str.equals("OPTIONS")) {
            dVar = new HttpOptions(str2);
        } else {
            dVar = new d(str, str2);
        }
        return new a(this.httpClient, dVar);
    }

    @Override // com.google.api.client.http.HttpTransport
    public void shutdown() {
        this.httpClient.getConnectionManager().shutdown();
    }

    public HttpClient getHttpClient() {
        return this.httpClient;
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        private SSLSocketFactory socketFactory = SSLSocketFactory.getSocketFactory();
        private HttpParams params = ApacheHttpTransport.newDefaultHttpParams();
        private ProxySelector proxySelector = ProxySelector.getDefault();

        public Builder setProxy(HttpHost httpHost) {
            ConnRouteParams.setDefaultProxy(this.params, httpHost);
            if (httpHost != null) {
                this.proxySelector = null;
            }
            return this;
        }

        public Builder setProxySelector(ProxySelector proxySelector) {
            this.proxySelector = proxySelector;
            if (proxySelector != null) {
                ConnRouteParams.setDefaultProxy(this.params, null);
            }
            return this;
        }

        public Builder trustCertificatesFromJavaKeyStore(InputStream inputStream, String str) throws GeneralSecurityException, IOException {
            KeyStore a2 = SecurityUtils.a();
            SecurityUtils.a(a2, inputStream, str);
            return trustCertificates(a2);
        }

        public Builder trustCertificatesFromStream(InputStream inputStream) throws GeneralSecurityException, IOException {
            KeyStore a2 = SecurityUtils.a();
            a2.load(null, null);
            SecurityUtils.a(a2, SecurityUtils.d(), inputStream);
            return trustCertificates(a2);
        }

        public Builder trustCertificates(KeyStore keyStore) throws GeneralSecurityException {
            SSLContext a2 = SslUtils.a();
            SslUtils.a(a2, keyStore, SslUtils.b());
            return setSocketFactory(new e(a2));
        }

        @Beta
        public Builder doNotValidateCertificate() throws GeneralSecurityException {
            this.socketFactory = new e(SslUtils.c());
            this.socketFactory.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            return this;
        }

        public Builder setSocketFactory(SSLSocketFactory sSLSocketFactory) {
            this.socketFactory = (SSLSocketFactory) Preconditions.a(sSLSocketFactory);
            return this;
        }

        public SSLSocketFactory getSSLSocketFactory() {
            return this.socketFactory;
        }

        public HttpParams getHttpParams() {
            return this.params;
        }

        public ApacheHttpTransport build() {
            return new ApacheHttpTransport(ApacheHttpTransport.newDefaultHttpClient(this.socketFactory, this.params, this.proxySelector));
        }
    }
}
