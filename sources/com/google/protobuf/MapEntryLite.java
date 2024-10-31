package com.google.protobuf;

import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat;
import java.io.IOException;

/* loaded from: classes2.dex */
public class MapEntryLite<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private final a<K, V> f18648a;

    /* renamed from: b, reason: collision with root package name */
    private final K f18649b;

    /* renamed from: c, reason: collision with root package name */
    private final V f18650c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final WireFormat.FieldType f18651a;

        /* renamed from: b, reason: collision with root package name */
        public final K f18652b;

        /* renamed from: c, reason: collision with root package name */
        public final WireFormat.FieldType f18653c;

        /* renamed from: d, reason: collision with root package name */
        public final V f18654d;

        public a(WireFormat.FieldType fieldType, K k, WireFormat.FieldType fieldType2, V v) {
            this.f18651a = fieldType;
            this.f18652b = k;
            this.f18653c = fieldType2;
            this.f18654d = v;
        }
    }

    private MapEntryLite(WireFormat.FieldType fieldType, K k, WireFormat.FieldType fieldType2, V v) {
        this.f18648a = new a<>(fieldType, k, fieldType2, v);
        this.f18649b = k;
        this.f18650c = v;
    }

    public static <K, V> MapEntryLite<K, V> a(WireFormat.FieldType fieldType, K k, WireFormat.FieldType fieldType2, V v) {
        return new MapEntryLite<>(fieldType, k, fieldType2, v);
    }

    static <K, V> void a(CodedOutputStream codedOutputStream, a<K, V> aVar, K k, V v) throws IOException {
        FieldSet.a(codedOutputStream, aVar.f18651a, 1, k);
        FieldSet.a(codedOutputStream, aVar.f18653c, 2, v);
    }

    static <K, V> int a(a<K, V> aVar, K k, V v) {
        return FieldSet.a(aVar.f18651a, 1, k) + FieldSet.a(aVar.f18653c, 2, v);
    }

    static <T> T a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, WireFormat.FieldType fieldType, T t) throws IOException {
        int i = I.f18610a[fieldType.ordinal()];
        if (i == 1) {
            MessageLite.Builder b2 = ((MessageLite) t).b();
            codedInputStream.a(b2, extensionRegistryLite);
            return (T) b2.T();
        }
        if (i == 2) {
            return (T) Integer.valueOf(codedInputStream.f());
        }
        if (i != 3) {
            return (T) FieldSet.a(codedInputStream, fieldType, true);
        }
        throw new RuntimeException("Groups are not allowed in maps.");
    }

    public void a(CodedOutputStream codedOutputStream, int i, K k, V v) throws IOException {
        codedOutputStream.h(i, 2);
        codedOutputStream.r(a(this.f18648a, k, v));
        a(codedOutputStream, this.f18648a, k, v);
    }

    public int a(int i, K k, V v) {
        return CodedOutputStream.i(i) + CodedOutputStream.d(a(this.f18648a, k, v));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(MapFieldLite<K, V> mapFieldLite, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int d2 = codedInputStream.d(codedInputStream.o());
        a<K, V> aVar = this.f18648a;
        Object obj = aVar.f18652b;
        Object obj2 = aVar.f18654d;
        while (true) {
            int x = codedInputStream.x();
            if (x == 0) {
                break;
            }
            if (x == WireFormat.a(1, this.f18648a.f18651a.getWireType())) {
                obj = a(codedInputStream, extensionRegistryLite, this.f18648a.f18651a, obj);
            } else if (x == WireFormat.a(2, this.f18648a.f18653c.getWireType())) {
                obj2 = a(codedInputStream, extensionRegistryLite, this.f18648a.f18653c, obj2);
            } else if (!codedInputStream.f(x)) {
                break;
            }
        }
        codedInputStream.a(0);
        codedInputStream.c(d2);
        mapFieldLite.put(obj, obj2);
    }
}
