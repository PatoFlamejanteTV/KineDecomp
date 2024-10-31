package com.facebook;

import android.util.Pair;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GraphRequest.java */
/* loaded from: classes.dex */
public class u implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ArrayList f9663a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ GraphRequestBatch f9664b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(ArrayList arrayList, GraphRequestBatch graphRequestBatch) {
        this.f9663a = arrayList;
        this.f9664b = graphRequestBatch;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = this.f9663a.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((GraphRequest.Callback) pair.first).onCompleted((GraphResponse) pair.second);
        }
        Iterator<GraphRequestBatch.Callback> it2 = this.f9664b.getCallbacks().iterator();
        while (it2.hasNext()) {
            it2.next().onBatchCompleted(this.f9664b);
        }
    }
}
