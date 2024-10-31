package org.koin.core.definition;

import java.util.ArrayList;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.h;

/* compiled from: BeanDefinition.kt */
/* loaded from: classes3.dex */
public final class b<T> {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<kotlin.reflect.c<?>> f29362a;

    /* renamed from: b, reason: collision with root package name */
    private org.koin.core.b.a<T> f29363b;

    /* renamed from: c, reason: collision with root package name */
    public kotlin.jvm.a.c<? super org.koin.core.scope.a, ? super org.koin.core.d.a, ? extends T> f29364c;

    /* renamed from: d, reason: collision with root package name */
    private d f29365d;

    /* renamed from: e, reason: collision with root package name */
    private e f29366e;

    /* renamed from: f, reason: collision with root package name */
    public Kind f29367f;

    /* renamed from: g, reason: collision with root package name */
    private final org.koin.core.e.a f29368g;

    /* renamed from: h, reason: collision with root package name */
    private final org.koin.core.e.a f29369h;
    private final kotlin.reflect.c<?> i;

    public b(org.koin.core.e.a aVar, org.koin.core.e.a aVar2, kotlin.reflect.c<?> cVar) {
        h.b(cVar, "primaryType");
        this.f29368g = aVar;
        this.f29369h = aVar2;
        this.i = cVar;
        this.f29362a = new ArrayList<>();
        this.f29365d = new d(false, false, 3, null);
        this.f29366e = new e(null, 1, null);
    }

    public final void a(kotlin.jvm.a.c<? super org.koin.core.scope.a, ? super org.koin.core.d.a, ? extends T> cVar) {
        h.b(cVar, "<set-?>");
        this.f29364c = cVar;
    }

    public final kotlin.jvm.a.c<org.koin.core.scope.a, org.koin.core.d.a, T> b() {
        kotlin.jvm.a.c<? super org.koin.core.scope.a, ? super org.koin.core.d.a, ? extends T> cVar = this.f29364c;
        if (cVar != null) {
            return cVar;
        }
        h.b("definition");
        throw null;
    }

    public final d c() {
        return this.f29365d;
    }

    public final kotlin.reflect.c<?> d() {
        return this.i;
    }

    public final org.koin.core.e.a e() {
        return this.f29368g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!h.a(b.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj != null) {
            b bVar = (b) obj;
            return ((h.a(this.f29368g, bVar.f29368g) ^ true) || (h.a(this.i, bVar.i) ^ true)) ? false : true;
        }
        throw new TypeCastException("null cannot be cast to non-null type org.koin.core.definition.BeanDefinition<*>");
    }

    public final org.koin.core.e.a f() {
        return this.f29369h;
    }

    public final ArrayList<kotlin.reflect.c<?>> g() {
        return this.f29362a;
    }

    public int hashCode() {
        org.koin.core.e.a aVar = this.f29368g;
        return ((aVar != null ? aVar.hashCode() : 0) * 31) + this.i.hashCode();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0044, code lost:            if (r2 != null) goto L16;     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0026, code lost:            if (r1 != null) goto L10;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toString() {
        /*
            r15 = this;
            org.koin.core.definition.Kind r0 = r15.f29367f
            if (r0 == 0) goto Lb8
            java.lang.String r0 = r0.toString()
            org.koin.core.e.a r1 = r15.f29368g
            java.lang.String r2 = "', "
            java.lang.String r3 = ""
            if (r1 == 0) goto L29
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "name:'"
            r1.append(r4)
            org.koin.core.e.a r4 = r15.f29368g
            r1.append(r4)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            if (r1 == 0) goto L29
            goto L2a
        L29:
            r1 = r3
        L2a:
            org.koin.core.e.a r4 = r15.f29369h
            if (r4 == 0) goto L47
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "scope:'"
            r4.append(r5)
            org.koin.core.e.a r5 = r15.f29369h
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            if (r2 == 0) goto L47
            goto L48
        L47:
            r2 = r3
        L48:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "primary_type:'"
            r4.append(r5)
            kotlin.reflect.c<?> r5 = r15.i
            java.lang.String r5 = g.a.c.a.a(r5)
            r4.append(r5)
            r5 = 39
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.util.ArrayList<kotlin.reflect.c<?>> r5 = r15.f29362a
            boolean r5 = r5.isEmpty()
            r5 = r5 ^ 1
            if (r5 == 0) goto L90
            java.util.ArrayList<kotlin.reflect.c<?>> r6 = r15.f29362a
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1 r12 = new kotlin.jvm.a.b<kotlin.reflect.c<?>, java.lang.String>() { // from class: org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1
                static {
                    /*
                        org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1 r0 = new org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1) org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1.INSTANCE org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 1
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1.<init>():void");
                }

                @Override // kotlin.jvm.a.b
                public /* bridge */ /* synthetic */ java.lang.String invoke(kotlin.reflect.c<?> r1) {
                    /*
                        r0 = this;
                        kotlin.reflect.c r1 = (kotlin.reflect.c) r1
                        java.lang.String r1 = r0.invoke(r1)
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1.invoke(java.lang.Object):java.lang.Object");
                }

                @Override // kotlin.jvm.a.b
                public final java.lang.String invoke(kotlin.reflect.c<?> r2) {
                    /*
                        r1 = this;
                        java.lang.String r0 = "it"
                        kotlin.jvm.internal.h.b(r2, r0)
                        java.lang.String r2 = g.a.c.a.a(r2)
                        return r2
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.koin.core.definition.BeanDefinition$toString$defOtherTypes$typesAsString$1.invoke(kotlin.reflect.c):java.lang.String");
                }
            }
            r13 = 30
            r14 = 0
            java.lang.String r7 = ","
            java.lang.String r3 = kotlin.collections.i.a(r6, r7, r8, r9, r10, r11, r12, r13, r14)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = ", secondary_type:"
            r5.append(r6)
            r5.append(r3)
            java.lang.String r3 = r5.toString()
        L90:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "[type:"
            r5.append(r6)
            r5.append(r0)
            r0 = 44
            r5.append(r0)
            r5.append(r2)
            r5.append(r1)
            r5.append(r4)
            r5.append(r3)
            r0 = 93
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            return r0
        Lb8:
            java.lang.String r0 = "kind"
            kotlin.jvm.internal.h.b(r0)
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.koin.core.definition.b.toString():java.lang.String");
    }

    public final void a(Kind kind) {
        h.b(kind, "<set-?>");
        this.f29367f = kind;
    }

    public final void a() {
        org.koin.core.b.a<T> eVar;
        Kind kind = this.f29367f;
        if (kind == null) {
            h.b("kind");
            throw null;
        }
        int i = a.f29361a[kind.ordinal()];
        if (i == 1) {
            eVar = new org.koin.core.b.e<>(this);
        } else if (i == 2) {
            eVar = new org.koin.core.b.b<>(this);
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            eVar = new org.koin.core.b.d<>(this);
        }
        this.f29363b = eVar;
    }

    public final <T> T a(org.koin.core.b.c cVar) {
        T b2;
        h.b(cVar, com.umeng.analytics.pro.b.Q);
        org.koin.core.b.a<T> aVar = this.f29363b;
        if (aVar != null && (b2 = aVar.b(cVar)) != null) {
            return b2;
        }
        throw new IllegalStateException(("Definition without any InstanceContext - " + this).toString());
    }
}
