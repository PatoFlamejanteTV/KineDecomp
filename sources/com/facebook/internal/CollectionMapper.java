package com.facebook.internal;

import com.facebook.FacebookException;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public class CollectionMapper {

    /* loaded from: classes.dex */
    public interface Collection<T> {
        Object get(T t);

        Iterator<T> keyIterator();

        void set(T t, Object obj, OnErrorListener onErrorListener);
    }

    /* loaded from: classes.dex */
    public interface OnErrorListener {
        void onError(FacebookException facebookException);
    }

    /* loaded from: classes.dex */
    public interface OnMapValueCompleteListener extends OnErrorListener {
        void onComplete(Object obj);
    }

    /* loaded from: classes.dex */
    public interface OnMapperCompleteListener extends OnErrorListener {
        void onComplete();
    }

    /* loaded from: classes.dex */
    public interface ValueMapper {
        void mapValue(Object obj, OnMapValueCompleteListener onMapValueCompleteListener);
    }

    private CollectionMapper() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void iterate(Collection<T> collection, ValueMapper valueMapper, OnMapperCompleteListener onMapperCompleteListener) {
        Mutable mutable = new Mutable(false);
        Mutable mutable2 = new Mutable(1);
        C0739i c0739i = new C0739i(mutable, mutable2, onMapperCompleteListener);
        Iterator keyIterator = collection.keyIterator();
        LinkedList linkedList = new LinkedList();
        while (keyIterator.hasNext()) {
            linkedList.add(keyIterator.next());
        }
        for (Object obj : linkedList) {
            Object obj2 = collection.get(obj);
            C0740j c0740j = new C0740j(collection, obj, c0739i);
            T t = mutable2.value;
            mutable2.value = (T) Integer.valueOf(((Integer) t).intValue() + 1);
            valueMapper.mapValue(obj2, c0740j);
        }
        c0739i.onComplete();
    }
}
