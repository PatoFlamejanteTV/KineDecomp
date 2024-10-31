package com.google.firebase.database;

import com.google.firebase.annotations.PublicApi;
import com.google.firebase.database.core.EventRegistration;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.Repo;
import com.google.firebase.database.core.ValueEventRegistration;
import com.google.firebase.database.core.ZombieEventManager;
import com.google.firebase.database.core.view.QueryParams;
import com.google.firebase.database.core.view.QuerySpec;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
@PublicApi
/* loaded from: classes2.dex */
public class Query {

    /* renamed from: a, reason: collision with root package name */
    protected final Repo f16642a;

    /* renamed from: b, reason: collision with root package name */
    protected final Path f16643b;

    /* renamed from: c, reason: collision with root package name */
    protected final QueryParams f16644c = QueryParams.f17117a;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f16645d = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Query(Repo repo, Path path) {
        this.f16642a = repo;
        this.f16643b = path;
    }

    @PublicApi
    public void a(ValueEventListener valueEventListener) {
        a(new ValueEventRegistration(this.f16642a, new b(this, valueEventListener), b()));
    }

    @PublicApi
    public ValueEventListener b(ValueEventListener valueEventListener) {
        a(new ValueEventRegistration(this.f16642a, valueEventListener, b()));
        return valueEventListener;
    }

    @PublicApi
    public void c(ValueEventListener valueEventListener) {
        if (valueEventListener != null) {
            b(new ValueEventRegistration(this.f16642a, valueEventListener, b()));
            return;
        }
        throw new NullPointerException("listener must not be null");
    }

    private void b(EventRegistration eventRegistration) {
        ZombieEventManager.a().c(eventRegistration);
        this.f16642a.b(new c(this, eventRegistration));
    }

    private void a(EventRegistration eventRegistration) {
        ZombieEventManager.a().b(eventRegistration);
        this.f16642a.b(new d(this, eventRegistration));
    }

    public QuerySpec b() {
        return new QuerySpec(this.f16643b, this.f16644c);
    }

    public Path a() {
        return this.f16643b;
    }
}
