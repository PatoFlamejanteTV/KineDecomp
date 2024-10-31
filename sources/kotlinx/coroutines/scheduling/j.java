package kotlinx.coroutines.scheduling;

import kotlinx.coroutines.C2553w;

/* compiled from: Tasks.kt */
/* loaded from: classes3.dex */
public final class j extends h {

    /* renamed from: c */
    public final Runnable f28712c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Runnable runnable, long j, i iVar) {
        super(j, iVar);
        kotlin.jvm.internal.h.b(runnable, "block");
        kotlin.jvm.internal.h.b(iVar, "taskContext");
        this.f28712c = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f28712c.run();
        } finally {
            this.f28711b.r();
        }
    }

    public String toString() {
        return "Task[" + C2553w.a(this.f28712c) + '@' + C2553w.b(this.f28712c) + ", " + this.f28710a + ", " + this.f28711b + ']';
    }
}
