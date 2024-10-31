package com.google.api.client.http;

import com.google.api.client.util.Beta;
import com.google.api.client.util.ExponentialBackOff;
import java.io.IOException;

@Beta
@Deprecated
/* loaded from: classes.dex */
public class ExponentialBackOffPolicy implements BackOffPolicy {

    /* renamed from: a, reason: collision with root package name */
    private final ExponentialBackOff f2453a;

    public ExponentialBackOffPolicy() {
        this(new Builder());
    }

    protected ExponentialBackOffPolicy(Builder builder) {
        this.f2453a = builder.f2454a.a();
    }

    @Override // com.google.api.client.http.BackOffPolicy
    public boolean a(int i) {
        switch (i) {
            case 500:
            case 503:
                return true;
            case 501:
            case 502:
            default:
                return false;
        }
    }

    @Override // com.google.api.client.http.BackOffPolicy
    public final void a() {
        this.f2453a.a();
    }

    @Override // com.google.api.client.http.BackOffPolicy
    public long b() throws IOException {
        return this.f2453a.b();
    }

    @Beta
    @Deprecated
    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        final ExponentialBackOff.Builder f2454a = new ExponentialBackOff.Builder();

        protected Builder() {
        }
    }
}
