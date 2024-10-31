package com.facebook;

import android.util.Pair;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: GraphRequest.java */
/* loaded from: classes.dex */
public final class u implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ArrayList f412a;
    final /* synthetic */ GraphRequestBatch b;

    public u(ArrayList arrayList, GraphRequestBatch graphRequestBatch) {
        this.f412a = arrayList;
        this.b = graphRequestBatch;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = this.f412a.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((GraphRequest.Callback) pair.first).onCompleted((GraphResponse) pair.second);
        }
        Iterator<GraphRequestBatch.Callback> it2 = this.b.getCallbacks().iterator();
        while (it2.hasNext()) {
            it2.next().onBatchCompleted(this.b);
        }
    }
}
