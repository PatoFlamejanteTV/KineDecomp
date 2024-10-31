package com.squareup.picasso;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.List;

/* compiled from: Picasso.java */
/* loaded from: classes3.dex */
class w extends Handler {
    /* JADX INFO: Access modifiers changed from: package-private */
    public w(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        if (i == 3) {
            AbstractC2388a abstractC2388a = (AbstractC2388a) message.obj;
            if (abstractC2388a.f().p) {
                N.a("Main", "canceled", abstractC2388a.f25623b.d(), "target got garbage collected");
            }
            abstractC2388a.f25622a.b(abstractC2388a.j());
            return;
        }
        int i2 = 0;
        if (i == 8) {
            List list = (List) message.obj;
            int size = list.size();
            while (i2 < size) {
                RunnableC2396i runnableC2396i = (RunnableC2396i) list.get(i2);
                runnableC2396i.f25643f.a(runnableC2396i);
                i2++;
            }
            return;
        }
        if (i == 13) {
            List list2 = (List) message.obj;
            int size2 = list2.size();
            while (i2 < size2) {
                AbstractC2388a abstractC2388a2 = (AbstractC2388a) list2.get(i2);
                abstractC2388a2.f25622a.b(abstractC2388a2);
                i2++;
            }
            return;
        }
        throw new AssertionError("Unknown handler message received: " + message.what);
    }
}
