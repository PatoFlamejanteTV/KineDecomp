package com.google.api.client.http;

import com.google.api.client.util.Beta;
import com.google.api.client.util.ExponentialBackOff;
import java.io.IOException;

@Beta
@Deprecated
/* loaded from: classes2.dex */
public class ExponentialBackOffPolicy implements BackOffPolicy {

    /* renamed from: a */
    private final ExponentialBackOff f14731a;

    @Beta
    @Deprecated
    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a */
        final ExponentialBackOff.Builder f14732a = new ExponentialBackOff.Builder();

        protected Builder() {
        }
    }

    public ExponentialBackOffPolicy() {
        this(new Builder());
    }

    @Override // com.google.api.client.http.BackOffPolicy
    public long a() throws IOException {
        return this.f14731a.a();
    }

    @Override // com.google.api.client.http.BackOffPolicy
    public boolean a(int i) {
        return i == 500 || i == 503;
    }

    @Override // com.google.api.client.http.BackOffPolicy
    public final void reset() {
        this.f14731a.reset();
    }

    protected ExponentialBackOffPolicy(Builder builder) {
        this.f14731a = builder.f14732a.a();
    }
}
