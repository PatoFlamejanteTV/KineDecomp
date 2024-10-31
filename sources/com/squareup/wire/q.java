package com.squareup.wire;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import okio.ByteString;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UnknownFieldMap.java */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    Map<Integer, List<a>> f4863a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UnknownFieldMap.java */
    /* loaded from: classes.dex */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f4864a;
        private final WireType b;

        public abstract int a();

        public abstract void a(int i, v vVar) throws IOException;

        public a(int i, WireType wireType) {
            this.f4864a = i;
            this.b = wireType;
        }

        public static e a(int i, Long l) {
            return new e(i, l);
        }

        public static b a(int i, Integer num) {
            return new b(i, num);
        }

        public static c b(int i, Long l) {
            return new c(i, l);
        }

        public static d a(int i, ByteString byteString) {
            return new d(i, byteString);
        }

        public WireType b() {
            return this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UnknownFieldMap.java */
    /* loaded from: classes.dex */
    public static final class e extends a {

        /* renamed from: a, reason: collision with root package name */
        private final Long f4868a;

        public e(int i, Long l) {
            super(i, WireType.VARINT);
            this.f4868a = l;
        }

        @Override // com.squareup.wire.q.a
        public int a() {
            return v.a(this.f4868a.longValue());
        }

        @Override // com.squareup.wire.q.a
        public void a(int i, v vVar) throws IOException {
            vVar.b(i, WireType.VARINT);
            vVar.b(this.f4868a.longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UnknownFieldMap.java */
    /* loaded from: classes.dex */
    public static final class b extends a {

        /* renamed from: a, reason: collision with root package name */
        private final Integer f4865a;

        public b(int i, Integer num) {
            super(i, WireType.FIXED32);
            this.f4865a = num;
        }

        @Override // com.squareup.wire.q.a
        public int a() {
            return 4;
        }

        @Override // com.squareup.wire.q.a
        public void a(int i, v vVar) throws IOException {
            vVar.b(i, WireType.FIXED32);
            vVar.g(this.f4865a.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UnknownFieldMap.java */
    /* loaded from: classes.dex */
    public static final class c extends a {

        /* renamed from: a, reason: collision with root package name */
        private final Long f4866a;

        public c(int i, Long l) {
            super(i, WireType.FIXED64);
            this.f4866a = l;
        }

        @Override // com.squareup.wire.q.a
        public int a() {
            return 8;
        }

        @Override // com.squareup.wire.q.a
        public void a(int i, v vVar) throws IOException {
            vVar.b(i, WireType.FIXED64);
            vVar.c(this.f4866a.longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UnknownFieldMap.java */
    /* loaded from: classes.dex */
    public static final class d extends a {

        /* renamed from: a, reason: collision with root package name */
        private final ByteString f4867a;

        public d(int i, ByteString byteString) {
            super(i, WireType.LENGTH_DELIMITED);
            this.f4867a = byteString;
        }

        @Override // com.squareup.wire.q.a
        public int a() {
            return v.c(this.f4867a.size()) + this.f4867a.size();
        }

        @Override // com.squareup.wire.q.a
        public void a(int i, v vVar) throws IOException {
            vVar.b(i, WireType.LENGTH_DELIMITED);
            vVar.f(this.f4867a.size());
            vVar.b(this.f4867a.toByteArray());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(q qVar) {
        if (qVar.f4863a != null) {
            b().putAll(qVar.f4863a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, Long l) throws IOException {
        a(b(), i, l, WireType.VARINT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, Integer num) throws IOException {
        a(b(), i, num, WireType.FIXED32);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i, Long l) throws IOException {
        a(b(), i, l, WireType.FIXED64);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, ByteString byteString) throws IOException {
        a(b(), i, byteString, WireType.LENGTH_DELIMITED);
    }

    private Map<Integer, List<a>> b() {
        if (this.f4863a == null) {
            this.f4863a = new TreeMap();
        }
        return this.f4863a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> void a(Map<Integer, List<a>> map, int i, T t, WireType wireType) throws IOException {
        List<a> list;
        a a2;
        List<a> list2 = map.get(Integer.valueOf(i));
        if (list2 == null) {
            ArrayList arrayList = new ArrayList();
            map.put(Integer.valueOf(i), arrayList);
            list = arrayList;
        } else {
            list = list2;
        }
        switch (wireType) {
            case VARINT:
                a2 = a.a(i, (Long) t);
                break;
            case FIXED32:
                a2 = a.a(i, (Integer) t);
                break;
            case FIXED64:
                a2 = a.b(i, (Long) t);
                break;
            case LENGTH_DELIMITED:
                a2 = a.a(i, (ByteString) t);
                break;
            default:
                throw new IllegalArgumentException("Unsupported wireType = " + wireType);
        }
        if (list.size() > 0 && list.get(0).b() != a2.b()) {
            throw new IOException(String.format("Wire type %s differs from previous type %s for tag %s", a2.b(), list.get(0).b(), Integer.valueOf(i)));
        }
        list.add(a2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        if (this.f4863a == null) {
            return 0;
        }
        int i = 0;
        for (Map.Entry<Integer, List<a>> entry : this.f4863a.entrySet()) {
            int b2 = v.b(entry.getKey().intValue()) + i;
            Iterator<a> it = entry.getValue().iterator();
            while (it.hasNext()) {
                b2 += it.next().a();
            }
            i = b2;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(v vVar) throws IOException {
        if (this.f4863a != null) {
            for (Map.Entry<Integer, List<a>> entry : this.f4863a.entrySet()) {
                int intValue = entry.getKey().intValue();
                Iterator<a> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    it.next().a(intValue, vVar);
                }
            }
        }
    }
}
