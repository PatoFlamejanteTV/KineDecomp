package org.keyczar;

import java.util.concurrent.ConcurrentHashMap;
import org.keyczar.interfaces.Stream;

/* loaded from: classes.dex */
class StreamCache<T extends Stream> {
    private final ConcurrentHashMap<KeyczarKey, StreamQueue<T>> cacheMap = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void put(KeyczarKey keyczarKey, T t) {
        getQueue(keyczarKey).add(t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public T get(KeyczarKey keyczarKey) {
        return (T) getQueue(keyczarKey).poll();
    }

    StreamQueue<T> getQueue(KeyczarKey keyczarKey) {
        StreamQueue<T> streamQueue = this.cacheMap.get(keyczarKey);
        if (streamQueue == null) {
            StreamQueue<T> streamQueue2 = new StreamQueue<>();
            StreamQueue<T> putIfAbsent = this.cacheMap.putIfAbsent(keyczarKey, streamQueue2);
            return putIfAbsent == null ? streamQueue2 : putIfAbsent;
        }
        return streamQueue;
    }
}
