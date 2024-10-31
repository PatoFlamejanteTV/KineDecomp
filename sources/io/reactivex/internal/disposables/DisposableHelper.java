package io.reactivex.internal.disposables;

import io.reactivex.exceptions.ProtocolViolationException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public enum DisposableHelper implements io.reactivex.disposables.b {
    DISPOSED;

    public static boolean dispose(AtomicReference<io.reactivex.disposables.b> atomicReference) {
        io.reactivex.disposables.b andSet;
        io.reactivex.disposables.b bVar = atomicReference.get();
        DisposableHelper disposableHelper = DISPOSED;
        if (bVar == disposableHelper || (andSet = atomicReference.getAndSet(disposableHelper)) == disposableHelper) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.dispose();
        return true;
    }

    public static boolean isDisposed(io.reactivex.disposables.b bVar) {
        return bVar == DISPOSED;
    }

    public static boolean replace(AtomicReference<io.reactivex.disposables.b> atomicReference, io.reactivex.disposables.b bVar) {
        io.reactivex.disposables.b bVar2;
        do {
            bVar2 = atomicReference.get();
            if (bVar2 == DISPOSED) {
                if (bVar == null) {
                    return false;
                }
                bVar.dispose();
                return false;
            }
        } while (!atomicReference.compareAndSet(bVar2, bVar));
        return true;
    }

    public static void reportDisposableSet() {
        io.reactivex.f.a.b(new ProtocolViolationException("Disposable already set!"));
    }

    public static boolean set(AtomicReference<io.reactivex.disposables.b> atomicReference, io.reactivex.disposables.b bVar) {
        io.reactivex.disposables.b bVar2;
        do {
            bVar2 = atomicReference.get();
            if (bVar2 == DISPOSED) {
                if (bVar == null) {
                    return false;
                }
                bVar.dispose();
                return false;
            }
        } while (!atomicReference.compareAndSet(bVar2, bVar));
        if (bVar2 == null) {
            return true;
        }
        bVar2.dispose();
        return true;
    }

    public static boolean setOnce(AtomicReference<io.reactivex.disposables.b> atomicReference, io.reactivex.disposables.b bVar) {
        io.reactivex.d.a.b.a(bVar, "d is null");
        if (atomicReference.compareAndSet(null, bVar)) {
            return true;
        }
        bVar.dispose();
        if (atomicReference.get() == DISPOSED) {
            return false;
        }
        reportDisposableSet();
        return false;
    }

    public static boolean trySet(AtomicReference<io.reactivex.disposables.b> atomicReference, io.reactivex.disposables.b bVar) {
        if (atomicReference.compareAndSet(null, bVar)) {
            return true;
        }
        if (atomicReference.get() != DISPOSED) {
            return false;
        }
        bVar.dispose();
        return false;
    }

    public static boolean validate(io.reactivex.disposables.b bVar, io.reactivex.disposables.b bVar2) {
        if (bVar2 == null) {
            io.reactivex.f.a.b(new NullPointerException("next is null"));
            return false;
        }
        if (bVar == null) {
            return true;
        }
        bVar2.dispose();
        reportDisposableSet();
        return false;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return true;
    }
}