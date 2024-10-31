package com.google.api.client.http;

import com.google.api.client.util.Preconditions;
import com.google.api.client.util.StringUtils;
import java.io.IOException;

/* loaded from: classes2.dex */
public class HttpResponseException extends IOException {
    private static final long serialVersionUID = -1875819453475890043L;

    /* renamed from: a */
    private final transient HttpHeaders f14782a;
    private final String content;
    private final int statusCode;
    private final String statusMessage;

    public HttpResponseException(HttpResponse httpResponse) {
        this(new Builder(httpResponse));
    }

    public static StringBuilder computeMessageBuffer(HttpResponse httpResponse) {
        StringBuilder sb = new StringBuilder();
        int g2 = httpResponse.g();
        if (g2 != 0) {
            sb.append(g2);
        }
        String h2 = httpResponse.h();
        if (h2 != null) {
            if (g2 != 0) {
                sb.append(' ');
            }
            sb.append(h2);
        }
        return sb;
    }

    public final String getContent() {
        return this.content;
    }

    public HttpHeaders getHeaders() {
        return this.f14782a;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final String getStatusMessage() {
        return this.statusMessage;
    }

    public final boolean isSuccessStatusCode() {
        return HttpStatusCodes.b(this.statusCode);
    }

    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a */
        int f14783a;

        /* renamed from: b */
        String f14784b;

        /* renamed from: c */
        HttpHeaders f14785c;

        /* renamed from: d */
        String f14786d;

        /* renamed from: e */
        String f14787e;

        public Builder(int i, String str, HttpHeaders httpHeaders) {
            a(i);
            c(str);
            a(httpHeaders);
        }

        public Builder a(int i) {
            Preconditions.a(i >= 0);
            this.f14783a = i;
            return this;
        }

        public Builder b(String str) {
            this.f14787e = str;
            return this;
        }

        public Builder c(String str) {
            this.f14784b = str;
            return this;
        }

        public Builder a(HttpHeaders httpHeaders) {
            Preconditions.a(httpHeaders);
            this.f14785c = httpHeaders;
            return this;
        }

        public Builder a(String str) {
            this.f14786d = str;
            return this;
        }

        public Builder(HttpResponse httpResponse) {
            this(httpResponse.g(), httpResponse.h(), httpResponse.e());
            try {
                this.f14786d = httpResponse.k();
                if (this.f14786d.length() == 0) {
                    this.f14786d = null;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            StringBuilder computeMessageBuffer = HttpResponseException.computeMessageBuffer(httpResponse);
            if (this.f14786d != null) {
                computeMessageBuffer.append(StringUtils.f14981a);
                computeMessageBuffer.append(this.f14786d);
            }
            this.f14787e = computeMessageBuffer.toString();
        }
    }

    public HttpResponseException(Builder builder) {
        super(builder.f14787e);
        this.statusCode = builder.f14783a;
        this.statusMessage = builder.f14784b;
        this.f14782a = builder.f14785c;
        this.content = builder.f14786d;
    }
}
