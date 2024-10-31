package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMakerInternalMap;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ComputingConcurrentHashMap<K, V> extends MapMakerInternalMap<K, V> {
    private static final long serialVersionUID = 4;
    final Function<? super K, ? extends V> computingFunction;

    ComputingConcurrentHashMap(MapMaker mapMaker, Function<? super K, ? extends V> function) {
        super(mapMaker);
        this.computingFunction = (Function) Preconditions.a(function);
    }

    @Override // com.google.common.collect.MapMakerInternalMap
    MapMakerInternalMap.Segment<K, V> createSegment(int i, int i2) {
        return new ComputingSegment(this, i, i2);
    }

    @Override // com.google.common.collect.MapMakerInternalMap
    public ComputingSegment<K, V> segmentFor(int i) {
        return (ComputingSegment) super.segmentFor(i);
    }

    V getOrCompute(K k) throws ExecutionException {
        int hash = hash(Preconditions.a(k));
        return segmentFor(hash).getOrCompute(k, hash, this.computingFunction);
    }

    /* loaded from: classes2.dex */
    public static final class ComputingSegment<K, V> extends MapMakerInternalMap.Segment<K, V> {
        ComputingSegment(MapMakerInternalMap<K, V> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:37:0x005d, code lost:            if (r5.getValueReference().b() == false) goto L114;     */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x005f, code lost:            r6 = false;     */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x0083, code lost:            r1 = r5.getValueReference().get();     */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x008b, code lost:            if (r1 != null) goto L118;     */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x008d, code lost:            enqueueNotification(r9, r13, r1, com.google.common.collect.MapMaker.RemovalCause.COLLECTED);     */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x0092, code lost:            r11.evictionQueue.remove(r5);        r11.expirationQueue.remove(r5);        r11.count = r6;        r6 = true;     */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00a6, code lost:            if (r11.map.expires() == false) goto L151;     */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00ae, code lost:            if (r11.map.isExpired(r5) == false) goto L152;     */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00b0, code lost:            enqueueNotification(r9, r13, r1, com.google.common.collect.MapMaker.RemovalCause.EXPIRED);     */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00c3, code lost:            recordLockedRead(r5);     */
        /* JADX WARN: Code restructure failed: missing block: B:66:?, code lost:            return r1;     */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        V getOrCompute(K r12, int r13, com.google.common.base.Function<? super K, ? extends V> r14) throws java.util.concurrent.ExecutionException {
            /*
                Method dump skipped, instructions count: 261
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ComputingConcurrentHashMap.ComputingSegment.getOrCompute(java.lang.Object, int, com.google.common.base.Function):java.lang.Object");
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x0034  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0039  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        V compute(K r7, int r8, com.google.common.collect.MapMakerInternalMap.i<K, V> r9, com.google.common.collect.ComputingConcurrentHashMap.c<K, V> r10) throws java.util.concurrent.ExecutionException {
            /*
                r6 = this;
                r4 = 0
                r1 = 0
                java.lang.System.nanoTime()
                monitor-enter(r9)     // Catch: java.lang.Throwable -> L3d
                java.lang.Object r1 = r10.a(r7, r8)     // Catch: java.lang.Throwable -> L2b
                long r2 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L2b
                monitor-exit(r9)     // Catch: java.lang.Throwable -> L40
                if (r1 == 0) goto L1e
                r0 = 1
                java.lang.Object r0 = r6.put(r7, r8, r1, r0)     // Catch: java.lang.Throwable -> L2f
                if (r0 == 0) goto L1e
                com.google.common.collect.MapMaker$RemovalCause r0 = com.google.common.collect.MapMaker.RemovalCause.REPLACED     // Catch: java.lang.Throwable -> L2f
                r6.enqueueNotification(r7, r8, r1, r0)     // Catch: java.lang.Throwable -> L2f
            L1e:
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 != 0) goto L25
                java.lang.System.nanoTime()
            L25:
                if (r1 != 0) goto L2a
                r6.clearValue(r7, r8, r10)
            L2a:
                return r1
            L2b:
                r0 = move-exception
                r2 = r4
            L2d:
                monitor-exit(r9)     // Catch: java.lang.Throwable -> L40
                throw r0     // Catch: java.lang.Throwable -> L2f
            L2f:
                r0 = move-exception
            L30:
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 != 0) goto L37
                java.lang.System.nanoTime()
            L37:
                if (r1 != 0) goto L3c
                r6.clearValue(r7, r8, r10)
            L3c:
                throw r0
            L3d:
                r0 = move-exception
                r2 = r4
                goto L30
            L40:
                r0 = move-exception
                goto L2d
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ComputingConcurrentHashMap.ComputingSegment.compute(java.lang.Object, int, com.google.common.collect.MapMakerInternalMap$i, com.google.common.collect.ComputingConcurrentHashMap$c):java.lang.Object");
        }
    }

    /* loaded from: classes2.dex */
    public static final class a<K, V> implements MapMakerInternalMap.u<K, V> {

        /* renamed from: a */
        final Throwable f2665a;

        a(Throwable th) {
            this.f2665a = th;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public V get() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public MapMakerInternalMap.i<K, V> a() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public MapMakerInternalMap.u<K, V> a(ReferenceQueue<V> referenceQueue, V v, MapMakerInternalMap.i<K, V> iVar) {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public boolean b() {
            return false;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public V c() throws ExecutionException {
            throw new ExecutionException(this.f2665a);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public void a(MapMakerInternalMap.u<K, V> uVar) {
        }
    }

    /* loaded from: classes2.dex */
    public static final class b<K, V> implements MapMakerInternalMap.u<K, V> {

        /* renamed from: a */
        final V f2666a;

        b(@Nullable V v) {
            this.f2666a = v;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public V get() {
            return this.f2666a;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public MapMakerInternalMap.i<K, V> a() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public MapMakerInternalMap.u<K, V> a(ReferenceQueue<V> referenceQueue, V v, MapMakerInternalMap.i<K, V> iVar) {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public boolean b() {
            return false;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public V c() {
            return get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public void a(MapMakerInternalMap.u<K, V> uVar) {
        }
    }

    /* loaded from: classes2.dex */
    public static final class c<K, V> implements MapMakerInternalMap.u<K, V> {

        /* renamed from: a */
        final Function<? super K, ? extends V> f2667a;

        @GuardedBy
        volatile MapMakerInternalMap.u<K, V> b = MapMakerInternalMap.unset();

        public c(Function<? super K, ? extends V> function) {
            this.f2667a = function;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public V get() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public MapMakerInternalMap.i<K, V> a() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public MapMakerInternalMap.u<K, V> a(ReferenceQueue<V> referenceQueue, @Nullable V v, MapMakerInternalMap.i<K, V> iVar) {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public boolean b() {
            return true;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public V c() throws ExecutionException {
            if (this.b == MapMakerInternalMap.UNSET) {
                boolean z = false;
                try {
                    synchronized (this) {
                        while (this.b == MapMakerInternalMap.UNSET) {
                            try {
                                wait();
                            } catch (InterruptedException e) {
                                z = true;
                            }
                        }
                    }
                } finally {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
            return this.b.c();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public void a(MapMakerInternalMap.u<K, V> uVar) {
            b(uVar);
        }

        V a(K k, int i) throws ExecutionException {
            try {
                V apply = this.f2667a.apply(k);
                b(new b(apply));
                return apply;
            } catch (Throwable th) {
                b(new a(th));
                throw new ExecutionException(th);
            }
        }

        void b(MapMakerInternalMap.u<K, V> uVar) {
            synchronized (this) {
                if (this.b == MapMakerInternalMap.UNSET) {
                    this.b = uVar;
                    notifyAll();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class ComputingMapAdapter<K, V> extends ComputingConcurrentHashMap<K, V> implements Serializable {
        private static final long serialVersionUID = 0;

        @Override // com.google.common.collect.ComputingConcurrentHashMap, com.google.common.collect.MapMakerInternalMap
        /* bridge */ /* synthetic */ MapMakerInternalMap.Segment segmentFor(int i) {
            return super.segmentFor(i);
        }

        public ComputingMapAdapter(MapMaker mapMaker, Function<? super K, ? extends V> function) {
            super(mapMaker, function);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.MapMakerInternalMap, java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            try {
                V orCompute = getOrCompute(obj);
                if (orCompute == null) {
                    throw new NullPointerException(this.computingFunction + " returned null for key " + obj + ".");
                }
                return orCompute;
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                Throwables.a(cause, ComputationException.class);
                throw new ComputationException(cause);
            }
        }
    }

    @Override // com.google.common.collect.MapMakerInternalMap
    Object writeReplace() {
        return new ComputingSerializationProxy(this.keyStrength, this.valueStrength, this.keyEquivalence, this.valueEquivalence, this.expireAfterWriteNanos, this.expireAfterAccessNanos, this.maximumSize, this.concurrencyLevel, this.removalListener, this, this.computingFunction);
    }

    /* loaded from: classes2.dex */
    static final class ComputingSerializationProxy<K, V> extends MapMakerInternalMap.AbstractSerializationProxy<K, V> {
        private static final long serialVersionUID = 4;
        final Function<? super K, ? extends V> computingFunction;

        ComputingSerializationProxy(MapMakerInternalMap.Strength strength, MapMakerInternalMap.Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, long j, long j2, int i, int i2, MapMaker.a<? super K, ? super V> aVar, ConcurrentMap<K, V> concurrentMap, Function<? super K, ? extends V> function) {
            super(strength, strength2, equivalence, equivalence2, j, j2, i, i2, aVar, concurrentMap);
            this.computingFunction = function;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            writeMapTo(objectOutputStream);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.delegate = readMapMaker(objectInputStream).a(this.computingFunction);
            readEntries(objectInputStream);
        }

        Object readResolve() {
            return this.delegate;
        }
    }
}
