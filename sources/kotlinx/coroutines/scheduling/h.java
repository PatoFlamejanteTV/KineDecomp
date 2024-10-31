package kotlinx.coroutines.scheduling;

/* compiled from: Tasks.kt */
/* loaded from: classes3.dex */
public abstract class h implements Runnable {

    /* renamed from: a */
    public long f28710a;

    /* renamed from: b */
    public i f28711b;

    public h(long j, i iVar) {
        kotlin.jvm.internal.h.b(iVar, "taskContext");
        this.f28710a = j;
        this.f28711b = iVar;
    }

    public final TaskMode b() {
        return this.f28711b.s();
    }

    public h() {
        this(0L, g.f28709b);
    }
}
