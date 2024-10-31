package com.google.common.collect;

import com.google.common.collect.Multiset;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: Serialization.java */
/* loaded from: classes2.dex */
final class cs {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(ObjectInputStream objectInputStream) throws IOException {
        return objectInputStream.readInt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void a(Map<K, V> map, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(map.size());
        for (Map.Entry<K, V> entry : map.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void a(Map<K, V> map, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        a(map, objectInputStream, objectInputStream.readInt());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> void a(Map<K, V> map, ObjectInputStream objectInputStream, int i) throws IOException, ClassNotFoundException {
        for (int i2 = 0; i2 < i; i2++) {
            map.put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> void a(Multiset<E> multiset, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(multiset.entrySet().size());
        for (Multiset.Entry<E> entry : multiset.entrySet()) {
            objectOutputStream.writeObject(entry.getElement());
            objectOutputStream.writeInt(entry.getCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> void a(Multiset<E> multiset, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        a(multiset, objectInputStream, objectInputStream.readInt());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <E> void a(Multiset<E> multiset, ObjectInputStream objectInputStream, int i) throws IOException, ClassNotFoundException {
        for (int i2 = 0; i2 < i; i2++) {
            multiset.add(objectInputStream.readObject(), objectInputStream.readInt());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void a(Multimap<K, V> multimap, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(multimap.asMap().size());
        for (Map.Entry<K, Collection<V>> entry : multimap.asMap().entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(entry.getValue().size());
            Iterator<V> it = entry.getValue().iterator();
            while (it.hasNext()) {
                objectOutputStream.writeObject(it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void a(Multimap<K, V> multimap, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        a(multimap, objectInputStream, objectInputStream.readInt());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> void a(Multimap<K, V> multimap, ObjectInputStream objectInputStream, int i) throws IOException, ClassNotFoundException {
        for (int i2 = 0; i2 < i; i2++) {
            Collection collection = multimap.get(objectInputStream.readObject());
            int readInt = objectInputStream.readInt();
            for (int i3 = 0; i3 < readInt; i3++) {
                collection.add(objectInputStream.readObject());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> a<T> a(Class<T> cls, String str) {
        try {
            return new a<>(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e) {
            throw new AssertionError(e);
        }
    }

    /* compiled from: Serialization.java */
    /* loaded from: classes2.dex */
    static final class a<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Field f2849a;

        private a(Field field) {
            this.f2849a = field;
            field.setAccessible(true);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(T t, Object obj) {
            try {
                this.f2849a.set(t, obj);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(T t, int i) {
            try {
                this.f2849a.set(t, Integer.valueOf(i));
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }
}
