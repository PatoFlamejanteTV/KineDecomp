package com.umeng.commonsdk.proguard;

import com.umeng.commonsdk.proguard.q;
import com.umeng.commonsdk.proguard.t;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: TUnion.java */
/* loaded from: classes3.dex */
public abstract class t<T extends t<?, ?>, F extends q> implements j<T, F> {

    /* renamed from: c, reason: collision with root package name */
    private static final Map<Class<? extends aq>, ar> f26278c = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    protected Object f26279a;

    /* renamed from: b, reason: collision with root package name */
    protected F f26280b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TUnion.java */
    /* loaded from: classes3.dex */
    public static class a extends as<t> {
        private a() {
        }

        @Override // com.umeng.commonsdk.proguard.aq
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(ai aiVar, t tVar) throws p {
            tVar.f26280b = null;
            tVar.f26279a = null;
            aiVar.j();
            ad l = aiVar.l();
            tVar.f26279a = tVar.a(aiVar, l);
            if (tVar.f26279a != null) {
                tVar.f26280b = (F) tVar.a(l.f26173c);
            }
            aiVar.m();
            aiVar.l();
            aiVar.k();
        }

        @Override // com.umeng.commonsdk.proguard.aq
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ai aiVar, t tVar) throws p {
            if (tVar.a() != null && tVar.b() != null) {
                aiVar.a(tVar.d());
                aiVar.a(tVar.c(tVar.f26280b));
                tVar.a(aiVar);
                aiVar.c();
                aiVar.d();
                aiVar.b();
                return;
            }
            throw new aj("Cannot write a TUnion with no set value!");
        }
    }

    /* compiled from: TUnion.java */
    /* loaded from: classes3.dex */
    private static class b implements ar {
        private b() {
        }

        @Override // com.umeng.commonsdk.proguard.ar
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TUnion.java */
    /* loaded from: classes3.dex */
    public static class c extends at<t> {
        private c() {
        }

        @Override // com.umeng.commonsdk.proguard.aq
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(ai aiVar, t tVar) throws p {
            tVar.f26280b = null;
            tVar.f26279a = null;
            short v = aiVar.v();
            tVar.f26279a = tVar.a(aiVar, v);
            if (tVar.f26279a != null) {
                tVar.f26280b = (F) tVar.a(v);
            }
        }

        @Override // com.umeng.commonsdk.proguard.aq
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ai aiVar, t tVar) throws p {
            if (tVar.a() != null && tVar.b() != null) {
                aiVar.a(tVar.f26280b.a());
                tVar.b(aiVar);
                return;
            }
            throw new aj("Cannot write a TUnion with no set value!");
        }
    }

    /* compiled from: TUnion.java */
    /* loaded from: classes3.dex */
    private static class d implements ar {
        private d() {
        }

        @Override // com.umeng.commonsdk.proguard.ar
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c();
        }
    }

    static {
        f26278c.put(as.class, new b());
        f26278c.put(at.class, new d());
    }

    protected t() {
        this.f26280b = null;
        this.f26279a = null;
    }

    private static Object a(Object obj) {
        if (obj instanceof j) {
            return ((j) obj).deepCopy();
        }
        if (obj instanceof ByteBuffer) {
            return k.d((ByteBuffer) obj);
        }
        if (obj instanceof List) {
            return a((List) obj);
        }
        if (obj instanceof Set) {
            return a((Set) obj);
        }
        return obj instanceof Map ? a((Map<Object, Object>) obj) : obj;
    }

    protected abstract F a(short s);

    protected abstract Object a(ai aiVar, ad adVar) throws p;

    protected abstract Object a(ai aiVar, short s) throws p;

    protected abstract void a(ai aiVar) throws p;

    public Object b() {
        return this.f26279a;
    }

    protected abstract void b(ai aiVar) throws p;

    protected abstract void b(F f2, Object obj) throws ClassCastException;

    protected abstract ad c(F f2);

    public boolean c() {
        return this.f26280b != null;
    }

    @Override // com.umeng.commonsdk.proguard.j
    public final void clear() {
        this.f26280b = null;
        this.f26279a = null;
    }

    protected abstract an d();

    @Override // com.umeng.commonsdk.proguard.j
    public void read(ai aiVar) throws p {
        f26278c.get(aiVar.D()).b().b(aiVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(t.class.getSimpleName());
        sb.append(" ");
        if (a() != null) {
            Object b2 = b();
            sb.append(c(a()).f26171a);
            sb.append(":");
            if (b2 instanceof ByteBuffer) {
                k.a((ByteBuffer) b2, sb);
            } else {
                sb.append(b2.toString());
            }
        }
        sb.append(">");
        return sb.toString();
    }

    @Override // com.umeng.commonsdk.proguard.j
    public void write(ai aiVar) throws p {
        f26278c.get(aiVar.D()).b().a(aiVar, this);
    }

    public boolean b(F f2) {
        return this.f26280b == f2;
    }

    public boolean b(int i) {
        return b((t<T, F>) a((short) i));
    }

    protected t(F f2, Object obj) {
        a((t<T, F>) f2, obj);
    }

    protected t(t<T, F> tVar) {
        if (tVar.getClass().equals(t.class)) {
            this.f26280b = tVar.f26280b;
            this.f26279a = a(tVar.f26279a);
            return;
        }
        throw new ClassCastException();
    }

    private static Map a(Map<Object, Object> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            hashMap.put(a(entry.getKey()), a(entry.getValue()));
        }
        return hashMap;
    }

    private static Set a(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(a(it.next()));
        }
        return hashSet;
    }

    private static List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return arrayList;
    }

    public F a() {
        return this.f26280b;
    }

    public Object a(F f2) {
        if (f2 == this.f26280b) {
            return b();
        }
        throw new IllegalArgumentException("Cannot get the value of field " + f2 + " because union's set field is " + this.f26280b);
    }

    public Object a(int i) {
        return a((t<T, F>) a((short) i));
    }

    public void a(F f2, Object obj) {
        b(f2, obj);
        this.f26280b = f2;
        this.f26279a = obj;
    }

    public void a(int i, Object obj) {
        a((t<T, F>) a((short) i), obj);
    }
}
