package io.reactivex.exceptions;

import io.reactivex.internal.util.ExceptionHelper;

/* compiled from: Exceptions.java */
/* loaded from: classes3.dex */
public final class a {
    public static RuntimeException a(Throwable th) {
        throw ExceptionHelper.b(th);
    }

    public static void b(Throwable th) {
        if (!(th instanceof VirtualMachineError)) {
            if (!(th instanceof ThreadDeath)) {
                if (th instanceof LinkageError) {
                    throw ((LinkageError) th);
                }
                return;
            }
            throw ((ThreadDeath) th);
        }
        throw ((VirtualMachineError) th);
    }
}
