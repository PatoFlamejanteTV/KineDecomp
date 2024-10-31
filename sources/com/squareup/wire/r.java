package com.squareup.wire;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import okio.ByteString;

/* compiled from: UnknownFieldMap.java */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a */
    Map<Integer, List<a>> f25731a;

    /* compiled from: UnknownFieldMap.java */
    /* loaded from: classes3.dex */
    public static abstract class a {

        /* renamed from: a */
        private final int f25732a;

        /* renamed from: b */
        private final WireType f25733b;

        public a(int i, WireType wireType) {
            this.f25732a = i;
            this.f25733b = wireType;
        }

        public static b a(int i, Integer num) {
            return new b(i, num);
        }

        public static e b(int i, Long l) {
            return new e(i, l);
        }

        public abstract int a();

        public abstract void a(int i, v vVar) throws IOException;

        public static c a(int i, Long l) {
            return new c(i, l);
        }

        public WireType b() {
            return this.f25733b;
        }

        public static d a(int i, ByteString byteString) {
            return new d(i, byteString);
        }
    }

    /* compiled from: UnknownFieldMap.java */
    /* loaded from: classes3.dex */
    public static final class b extends a {

        /* renamed from: c */
        private final Integer f25734c;

        public b(int i, Integer num) {
            super(i, WireType.FIXED32);
            this.f25734c = num;
        }

        @Override // com.squareup.wire.r.a
        public int a() {
            return 4;
        }

        @Override // com.squareup.wire.r.a
        public void a(int i, v vVar) throws IOException {
            vVar.b(i, WireType.FIXED32);
            vVar.d(this.f25734c.intValue());
        }
    }

    /* compiled from: UnknownFieldMap.java */
    /* loaded from: classes3.dex */
    public static final class c extends a {

        /* renamed from: c */
        private final Long f25735c;

        public c(int i, Long l) {
            super(i, WireType.FIXED64);
            this.f25735c = l;
        }

        @Override // com.squareup.wire.r.a
        public int a() {
            return 8;
        }

        @Override // com.squareup.wire.r.a
        public void a(int i, v vVar) throws IOException {
            vVar.b(i, WireType.FIXED64);
            vVar.b(this.f25735c.longValue());
        }
    }

    /* compiled from: UnknownFieldMap.java */
    /* loaded from: classes3.dex */
    public static final class d extends a {

        /* renamed from: c */
        private final ByteString f25736c;

        public d(int i, ByteString byteString) {
            super(i, WireType.LENGTH_DELIMITED);
            this.f25736c = byteString;
        }

        @Override // com.squareup.wire.r.a
        public int a() {
            return v.b(this.f25736c.size()) + this.f25736c.size();
        }

        @Override // com.squareup.wire.r.a
        public void a(int i, v vVar) throws IOException {
            vVar.b(i, WireType.LENGTH_DELIMITED);
            vVar.g(this.f25736c.size());
            vVar.b(this.f25736c.toByteArray());
        }
    }

    /* compiled from: UnknownFieldMap.java */
    /* loaded from: classes3.dex */
    public static final class e extends a {

        /* renamed from: c */
        private final Long f25737c;

        public e(int i, Long l) {
            super(i, WireType.VARINT);
            this.f25737c = l;
        }

        @Override // com.squareup.wire.r.a
        public int a() {
            return v.a(this.f25737c.longValue());
        }

        @Override // com.squareup.wire.r.a
        public void a(int i, v vVar) throws IOException {
            vVar.b(i, WireType.VARINT);
            vVar.c(this.f25737c.longValue());
        }
    }

    public r() {
    }

    public void a(int i, Integer num) throws IOException {
        a(b(), i, num, WireType.FIXED32);
    }

    public void b(int i, Long l) throws IOException {
        a(b(), i, l, WireType.VARINT);
    }

    public r(r rVar) {
        if (rVar.f25731a != null) {
            b().putAll(rVar.f25731a);
        }
    }

    private Map<Integer, List<a>> b() {
        if (this.f25731a == null) {
            this.f25731a = new TreeMap();
        }
        return this.f25731a;
    }

    public void a(int i, Long l) throws IOException {
        a(b(), i, l, WireType.FIXED64);
    }

    public void a(int i, ByteString byteString) throws IOException {
        a(b(), i, byteString, WireType.LENGTH_DELIMITED);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> void a(Map<Integer, List<a>> map, int i, T t, WireType wireType) throws IOException {
        a b2;
        List<a> list = map.get(Integer.valueOf(i));
        if (list == null) {
            list = new ArrayList<>();
            map.put(Integer.valueOf(i), list);
        }
        int i2 = q.f25730a[wireType.ordinal()];
        if (i2 == 1) {
            b2 = a.b(i, (Long) t);
        } else if (i2 == 2) {
            b2 = a.a(i, (Integer) t);
        } else if (i2 == 3) {
            b2 = a.a(i, (Long) t);
        } else if (i2 == 4) {
            b2 = a.a(i, (ByteString) t);
        } else {
            throw new IllegalArgumentException("Unsupported wireType = " + wireType);
        }
        if (list.size() > 0 && list.get(0).b() != b2.b()) {
            throw new IOException(String.format("Wire type %s differs from previous type %s for tag %s", b2.b(), list.get(0).b(), Integer.valueOf(i)));
        }
        list.add(b2);
    }

    public int a() {
        Map<Integer, List<a>> map = this.f25731a;
        int i = 0;
        if (map != null) {
            for (Map.Entry<Integer, List<a>> entry : map.entrySet()) {
                i += v.c(entry.getKey().intValue());
                Iterator<a> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    i += it.next().a();
                }
            }
        }
        return i;
    }

    public void a(v vVar) throws IOException {
        Map<Integer, List<a>> map = this.f25731a;
        if (map != null) {
            for (Map.Entry<Integer, List<a>> entry : map.entrySet()) {
                int intValue = entry.getKey().intValue();
                Iterator<a> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    it.next().a(intValue, vVar);
                }
            }
        }
    }
}
