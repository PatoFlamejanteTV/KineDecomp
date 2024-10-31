package com.google.api.client.auth.openidconnect;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Clock;
import java.util.Collection;
import java.util.Collections;

@Beta
/* loaded from: classes.dex */
public class IdTokenVerifier {

    /* renamed from: a, reason: collision with root package name */
    private final Clock f2418a;
    private final long b;
    private final String c;
    private final Collection<String> d;

    @Beta
    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        Clock f2419a = Clock.f2532a;
        long b = 300;
        String c;
        Collection<String> d;
    }

    public IdTokenVerifier() {
        this(new Builder());
    }

    protected IdTokenVerifier(Builder builder) {
        this.f2418a = builder.f2419a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d == null ? null : Collections.unmodifiableCollection(builder.d);
    }
}
