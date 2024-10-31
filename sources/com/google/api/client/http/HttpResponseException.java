package com.google.api.client.http;

import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StringUtils;
import java.io.IOException;

/* loaded from: classes.dex */
public class HttpResponseException extends IOException {
    private static final long serialVersionUID = -1875819453475890043L;

    /* renamed from: a, reason: collision with root package name */
    private final transient HttpHeaders f2468a;
    private final String content;
    private final int statusCode;
    private final String statusMessage;

    public HttpResponseException(HttpResponse httpResponse) {
        this(new Builder(httpResponse));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HttpResponseException(Builder builder) {
        super(builder.e);
        this.statusCode = builder.f2469a;
        this.statusMessage = builder.b;
        this.f2468a = builder.c;
        this.content = builder.d;
    }

    public final boolean isSuccessStatusCode() {
        return HttpStatusCodes.a(this.statusCode);
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final String getStatusMessage() {
        return this.statusMessage;
    }

    public HttpHeaders getHeaders() {
        return this.f2468a;
    }

    public final String getContent() {
        return this.content;
    }

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        int f2469a;
        String b;
        HttpHeaders c;
        String d;
        String e;

        public Builder(int i, String str, HttpHeaders httpHeaders) {
            a(i);
            b(str);
            a(httpHeaders);
        }

        public Builder(HttpResponse httpResponse) {
            this(httpResponse.d(), httpResponse.e(), httpResponse.b());
            try {
                this.d = httpResponse.j();
                if (this.d.length() == 0) {
                    this.d = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            StringBuilder computeMessageBuffer = HttpResponseException.computeMessageBuffer(httpResponse);
            if (this.d != null) {
                computeMessageBuffer.append(StringUtils.f2548a).append(this.d);
            }
            this.e = computeMessageBuffer.toString();
        }

        public Builder a(String str) {
            this.e = str;
            return this;
        }

        public Builder a(int i) {
            Preconditions.a(i >= 0);
            this.f2469a = i;
            return this;
        }

        public Builder b(String str) {
            this.b = str;
            return this;
        }

        public Builder a(HttpHeaders httpHeaders) {
            this.c = (HttpHeaders) Preconditions.a(httpHeaders);
            return this;
        }

        public Builder c(String str) {
            this.d = str;
            return this;
        }
    }

    public static StringBuilder computeMessageBuffer(HttpResponse httpResponse) {
        StringBuilder sb = new StringBuilder();
        int d = httpResponse.d();
        if (d != 0) {
            sb.append(d);
        }
        String e = httpResponse.e();
        if (e != null) {
            if (d != 0) {
                sb.append(' ');
            }
            sb.append(e);
        }
        return sb;
    }
}
