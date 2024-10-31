package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Result;
import kotlin.TypeCastException;

/* compiled from: ExceptionsConstuctor.kt */
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a */
    private static final ReentrantReadWriteLock f28633a = new ReentrantReadWriteLock();

    /* renamed from: b */
    private static final WeakHashMap<Class<? extends Throwable>, kotlin.jvm.a.b<Throwable, Throwable>> f28634b = new WeakHashMap<>();

    public static final <E extends Throwable> E a(E e2) {
        List c2;
        int i;
        kotlin.jvm.a.b bVar;
        kotlin.jvm.internal.h.b(e2, "exception");
        ReentrantReadWriteLock.ReadLock readLock = f28633a.readLock();
        readLock.lock();
        try {
            kotlin.jvm.a.b<Throwable, Throwable> bVar2 = f28634b.get(e2.getClass());
            if (bVar2 != null) {
                return (E) bVar2.invoke(e2);
            }
            Constructor<?>[] constructors = e2.getClass().getConstructors();
            kotlin.jvm.internal.h.a((Object) constructors, "exception.javaClass.constructors");
            c2 = kotlin.collections.g.c(constructors, new g());
            Iterator it = c2.iterator();
            while (true) {
                i = 0;
                if (!it.hasNext()) {
                    bVar = null;
                    break;
                }
                final Constructor constructor = (Constructor) it.next();
                kotlin.jvm.internal.h.a((Object) constructor, "constructor");
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                boolean z = true;
                if (parameterTypes.length == 2 && kotlin.jvm.internal.h.a(parameterTypes[0], String.class) && kotlin.jvm.internal.h.a(parameterTypes[1], Throwable.class)) {
                    bVar = new kotlin.jvm.a.b<Throwable, E>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        /* JADX WARN: Incorrect return type in method signature: (Ljava/lang/Throwable;)TE; */
                        @Override // kotlin.jvm.a.b
                        public final Throwable invoke(Throwable th) {
                            Object a2;
                            Object newInstance;
                            kotlin.jvm.internal.h.b(th, "e");
                            try {
                                Result.a aVar = Result.Companion;
                                newInstance = constructor.newInstance(th.getMessage(), th);
                            } catch (Throwable th2) {
                                Result.a aVar2 = Result.Companion;
                                a2 = kotlin.h.a(th2);
                                Result.m23constructorimpl(a2);
                            }
                            if (newInstance == null) {
                                throw new TypeCastException("null cannot be cast to non-null type E");
                            }
                            a2 = (Throwable) newInstance;
                            Result.m23constructorimpl(a2);
                            if (Result.m28isFailureimpl(a2)) {
                                a2 = null;
                            }
                            return (Throwable) a2;
                        }
                    };
                    break;
                }
                if (parameterTypes.length == 1 && kotlin.jvm.internal.h.a(parameterTypes[0], Throwable.class)) {
                    bVar = new kotlin.jvm.a.b<Throwable, E>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        /* JADX WARN: Incorrect return type in method signature: (Ljava/lang/Throwable;)TE; */
                        @Override // kotlin.jvm.a.b
                        public final Throwable invoke(Throwable th) {
                            Object a2;
                            Object newInstance;
                            kotlin.jvm.internal.h.b(th, "e");
                            try {
                                Result.a aVar = Result.Companion;
                                newInstance = constructor.newInstance(th);
                            } catch (Throwable th2) {
                                Result.a aVar2 = Result.Companion;
                                a2 = kotlin.h.a(th2);
                                Result.m23constructorimpl(a2);
                            }
                            if (newInstance == null) {
                                throw new TypeCastException("null cannot be cast to non-null type E");
                            }
                            a2 = (Throwable) newInstance;
                            Result.m23constructorimpl(a2);
                            if (Result.m28isFailureimpl(a2)) {
                                a2 = null;
                            }
                            return (Throwable) a2;
                        }
                    };
                    break;
                }
                kotlin.jvm.internal.h.a((Object) parameterTypes, "parameters");
                if (parameterTypes.length != 0) {
                    z = false;
                }
                if (z) {
                    bVar = new kotlin.jvm.a.b<Throwable, E>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$3
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        /* JADX WARN: Incorrect return type in method signature: (Ljava/lang/Throwable;)TE; */
                        @Override // kotlin.jvm.a.b
                        public final Throwable invoke(Throwable th) {
                            Object a2;
                            Object newInstance;
                            kotlin.jvm.internal.h.b(th, "e");
                            try {
                                Result.a aVar = Result.Companion;
                                newInstance = constructor.newInstance(new Object[0]);
                            } catch (Throwable th2) {
                                Result.a aVar2 = Result.Companion;
                                a2 = kotlin.h.a(th2);
                                Result.m23constructorimpl(a2);
                            }
                            if (newInstance == null) {
                                throw new TypeCastException("null cannot be cast to non-null type E");
                            }
                            a2 = (Throwable) newInstance;
                            Result.m23constructorimpl(a2);
                            if (Result.m28isFailureimpl(a2)) {
                                a2 = null;
                            }
                            Throwable th3 = (Throwable) a2;
                            if (th3 == null) {
                                return null;
                            }
                            th3.initCause(th);
                            return th3;
                        }
                    };
                    break;
                }
            }
            ReentrantReadWriteLock reentrantReadWriteLock = f28633a;
            ReentrantReadWriteLock.ReadLock readLock2 = reentrantReadWriteLock.readLock();
            int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
            for (int i2 = 0; i2 < readHoldCount; i2++) {
                readLock2.unlock();
            }
            ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
            writeLock.lock();
            try {
                f28634b.put(e2.getClass(), bVar != null ? bVar : new kotlin.jvm.a.b() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$4$1
                    @Override // kotlin.jvm.a.b
                    public final Void invoke(Throwable th) {
                        kotlin.jvm.internal.h.b(th, "it");
                        return null;
                    }
                });
                kotlin.k kVar = kotlin.k.f28545a;
                if (bVar != null) {
                    return (E) bVar.invoke(e2);
                }
                return null;
            } finally {
                while (i < readHoldCount) {
                    readLock2.lock();
                    i++;
                }
                writeLock.unlock();
            }
        } finally {
            readLock.unlock();
        }
    }
}
