package com.google.firebase.database.core.view;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.snapshot.Index;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class QuerySpec {

    /* renamed from: a */
    private final Path f17125a;

    /* renamed from: b */
    private final QueryParams f17126b;

    public QuerySpec(Path path, QueryParams queryParams) {
        this.f17125a = path;
        this.f17126b = queryParams;
    }

    public static QuerySpec a(Path path) {
        return new QuerySpec(path, QueryParams.f17117a);
    }

    public QueryParams b() {
        return this.f17126b;
    }

    public Path c() {
        return this.f17125a;
    }

    public boolean d() {
        return this.f17126b.l();
    }

    public boolean e() {
        return this.f17126b.n();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || QuerySpec.class != obj.getClass()) {
            return false;
        }
        QuerySpec querySpec = (QuerySpec) obj;
        return this.f17125a.equals(querySpec.f17125a) && this.f17126b.equals(querySpec.f17126b);
    }

    public int hashCode() {
        return (this.f17125a.hashCode() * 31) + this.f17126b.hashCode();
    }

    public String toString() {
        return this.f17125a + ":" + this.f17126b;
    }

    public static QuerySpec a(Path path, Map<String, Object> map) {
        return new QuerySpec(path, QueryParams.a(map));
    }

    public Index a() {
        return this.f17126b.a();
    }
}
