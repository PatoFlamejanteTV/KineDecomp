package com.squareup.picasso;

import android.net.NetworkInfo;
import com.squareup.picasso.N;
import com.squareup.picasso.Picasso;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PicassoExecutorService.java */
/* loaded from: classes3.dex */
public class A extends ThreadPoolExecutor {

    /* compiled from: PicassoExecutorService.java */
    /* loaded from: classes3.dex */
    private static final class a extends FutureTask<RunnableC2396i> implements Comparable<a> {

        /* renamed from: a, reason: collision with root package name */
        private final RunnableC2396i f25542a;

        public a(RunnableC2396i runnableC2396i) {
            super(runnableC2396i, null);
            this.f25542a = runnableC2396i;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            Picasso.Priority k = this.f25542a.k();
            Picasso.Priority k2 = aVar.f25542a.k();
            return k == k2 ? this.f25542a.f25642e - aVar.f25542a.f25642e : k2.ordinal() - k.ordinal();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public A() {
        super(3, 3, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new N.e());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
            int type = networkInfo.getType();
            if (type != 0) {
                if (type != 1 && type != 6 && type != 9) {
                    a(3);
                    return;
                } else {
                    a(4);
                    return;
                }
            }
            int subtype = networkInfo.getSubtype();
            switch (subtype) {
                case 1:
                case 2:
                    a(1);
                    return;
                case 3:
                case 4:
                case 5:
                case 6:
                    break;
                default:
                    switch (subtype) {
                        case 12:
                            break;
                        case 13:
                        case 14:
                        case 15:
                            a(3);
                            return;
                        default:
                            a(3);
                            return;
                    }
            }
            a(2);
            return;
        }
        a(3);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        a aVar = new a((RunnableC2396i) runnable);
        execute(aVar);
        return aVar;
    }

    private void a(int i) {
        setCorePoolSize(i);
        setMaximumPoolSize(i);
    }
}
