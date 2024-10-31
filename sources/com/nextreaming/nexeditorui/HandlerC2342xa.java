package com.nextreaming.nexeditorui;

import android.os.Handler;
import android.os.Message;
import android.widget.ListView;

/* compiled from: NexIndexScroller.java */
/* renamed from: com.nextreaming.nexeditorui.xa */
/* loaded from: classes.dex */
public class HandlerC2342xa extends Handler {

    /* renamed from: a */
    final /* synthetic */ C2344ya f24408a;

    public HandlerC2342xa(C2344ya c2344ya) {
        this.f24408a = c2344ya;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        float f2;
        float f3;
        float f4;
        ListView listView;
        float f5;
        float f6;
        float f7;
        ListView listView2;
        super.handleMessage(message);
        i = this.f24408a.f24415g;
        if (i == 1) {
            C2344ya c2344ya = this.f24408a;
            f2 = c2344ya.f24414f;
            double d2 = f2;
            f3 = this.f24408a.f24414f;
            double d3 = 1.0f - f3;
            Double.isNaN(d3);
            Double.isNaN(d2);
            c2344ya.f24414f = (float) (d2 + (d3 * 0.2d));
            f4 = this.f24408a.f24414f;
            if (f4 > 0.9d) {
                this.f24408a.f24414f = 1.0f;
                this.f24408a.a(2);
            }
            listView = this.f24408a.l;
            listView.invalidate();
            this.f24408a.a(10L);
            return;
        }
        if (i == 2) {
            this.f24408a.a(3);
            return;
        }
        if (i != 3) {
            return;
        }
        C2344ya c2344ya2 = this.f24408a;
        f5 = c2344ya2.f24414f;
        double d4 = f5;
        f6 = this.f24408a.f24414f;
        double d5 = f6;
        Double.isNaN(d5);
        Double.isNaN(d4);
        c2344ya2.f24414f = (float) (d4 - (d5 * 0.2d));
        f7 = this.f24408a.f24414f;
        if (f7 < 0.1d) {
            this.f24408a.f24414f = 0.0f;
            this.f24408a.a(0);
        }
        listView2 = this.f24408a.l;
        listView2.invalidate();
        this.f24408a.a(10L);
    }
}
