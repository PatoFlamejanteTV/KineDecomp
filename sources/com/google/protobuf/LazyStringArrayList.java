package com.google.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public class LazyStringArrayList extends AbstractC1647a<String> implements LazyStringList, RandomAccess {

    /* renamed from: b */
    private static final LazyStringArrayList f18642b = new LazyStringArrayList();

    /* renamed from: c */
    public static final LazyStringList f18643c;

    /* renamed from: d */
    private final List<Object> f18644d;

    static {
        f18642b.L();
        f18643c = f18642b;
    }

    public LazyStringArrayList() {
        this(10);
    }

    @Override // com.google.protobuf.AbstractC1647a, com.google.protobuf.Internal.ProtobufList
    public /* bridge */ /* synthetic */ boolean M() {
        return super.M();
    }

    @Override // com.google.protobuf.LazyStringList
    public List<?> N() {
        return Collections.unmodifiableList(this.f18644d);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: a */
    public void add(int i, String str) {
        a();
        this.f18644d.add(i, str);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.AbstractC1647a, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: b */
    public String set(int i, String str) {
        a();
        return a(this.f18644d.set(i, str));
    }

    @Override // com.google.protobuf.AbstractC1647a, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        a();
        this.f18644d.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.AbstractC1647a, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.protobuf.AbstractC1647a, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.protobuf.AbstractC1647a, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.protobuf.AbstractC1647a, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f18644d.size();
    }

    public LazyStringArrayList(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    @Override // com.google.protobuf.AbstractC1647a, java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection<? extends String> collection) {
        a();
        if (collection instanceof LazyStringList) {
            collection = ((LazyStringList) collection).N();
        }
        boolean addAll = this.f18644d.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // java.util.AbstractList, java.util.List
    public String get(int i) {
        Object obj = this.f18644d.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.f18644d.set(i, stringUtf8);
            }
            return stringUtf8;
        }
        byte[] bArr = (byte[]) obj;
        String c2 = Internal.c(bArr);
        if (Internal.b(bArr)) {
            this.f18644d.set(i, c2);
        }
        return c2;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.IntList
    /* renamed from: h */
    public LazyStringArrayList h2(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.f18644d);
            return new LazyStringArrayList((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.AbstractC1647a, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    private LazyStringArrayList(ArrayList<Object> arrayList) {
        this.f18644d = arrayList;
    }

    @Override // java.util.AbstractList, java.util.List
    public String remove(int i) {
        a();
        Object remove = this.f18644d.remove(i);
        ((AbstractList) this).modCount++;
        return a(remove);
    }

    private static String a(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            return ((ByteString) obj).toStringUtf8();
        }
        return Internal.c((byte[]) obj);
    }
}
