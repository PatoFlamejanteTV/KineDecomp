package kotlinx.coroutines.scheduling;

import kotlinx.coroutines.scheduling.CoroutineScheduler;

/* loaded from: classes3.dex */
public final /* synthetic */ class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f28694a = new int[CoroutineScheduler.WorkerState.values().length];

    static {
        f28694a[CoroutineScheduler.WorkerState.PARKING.ordinal()] = 1;
        f28694a[CoroutineScheduler.WorkerState.BLOCKING.ordinal()] = 2;
        f28694a[CoroutineScheduler.WorkerState.CPU_ACQUIRED.ordinal()] = 3;
        f28694a[CoroutineScheduler.WorkerState.RETIRING.ordinal()] = 4;
        f28694a[CoroutineScheduler.WorkerState.TERMINATED.ordinal()] = 5;
    }
}
