package com.google.firebase.database.core.operation;

import com.google.firebase.database.core.view.QueryParams;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class OperationSource {

    /* renamed from: a */
    public static final OperationSource f17002a = new OperationSource(Source.User, null, false);

    /* renamed from: b */
    public static final OperationSource f17003b = new OperationSource(Source.Server, null, false);

    /* renamed from: c */
    static final /* synthetic */ boolean f17004c = false;

    /* renamed from: d */
    private final Source f17005d;

    /* renamed from: e */
    private final QueryParams f17006e;

    /* renamed from: f */
    private final boolean f17007f;

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public enum Source {
        User,
        Server
    }

    public OperationSource(Source source, QueryParams queryParams, boolean z) {
        this.f17005d = source;
        this.f17006e = queryParams;
        this.f17007f = z;
        if (!f17004c && z && !b()) {
            throw new AssertionError();
        }
    }

    public static OperationSource a(QueryParams queryParams) {
        return new OperationSource(Source.Server, queryParams, true);
    }

    public boolean b() {
        return this.f17005d == Source.Server;
    }

    public boolean c() {
        return this.f17005d == Source.User;
    }

    public boolean d() {
        return this.f17007f;
    }

    public String toString() {
        return "OperationSource{source=" + this.f17005d + ", queryParams=" + this.f17006e + ", tagged=" + this.f17007f + '}';
    }

    public QueryParams a() {
        return this.f17006e;
    }
}
