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

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void iterate(Collection<T> collection, ValueMapper valueMapper, OnMapperCompleteListener onMapperCompleteListener) {
        Mutable mutable = new Mutable(false);
        Mutable mutable2 = new Mutable(1);
        i iVar = new i(mutable, mutable2, onMapperCompleteListener);
        Iterator keyIterator = collection.keyIterator();
        LinkedList linkedList = new LinkedList();
        while (keyIterator.hasNext()) {
            linkedList.add(keyIterator.next());
        }
        for (Object obj : linkedList) {
            Object obj2 = collection.get(obj);
            j jVar = new j(collection, obj, iVar);
            mutable2.value = (T) Integer.valueOf(((Integer) mutable2.value).intValue() + 1);
            valueMapper.mapValue(obj2, jVar);
        }
        iVar.onComplete();
    }

    private CollectionMapper() {
    }
}
