package com.nextreaming.nexeditorui;

import android.os.Handler;
import android.os.Message;
import android.widget.ListView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexIndexScroller.java */
/* loaded from: classes.dex */
public class ci extends Handler {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ch f4572a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(ch chVar) {
        this.f4572a = chVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        float f;
        float f2;
        ListView listView;
        float f3;
        float f4;
        ListView listView2;
        super.handleMessage(message);
        i = this.f4572a.g;
        switch (i) {
            case 1:
                ch chVar = this.f4572a;
                f3 = this.f4572a.f;
                ch.a(chVar, (1.0f - f3) * 0.2d);
                f4 = this.f4572a.f;
                if (f4 > 0.9d) {
                    this.f4572a.f = 1.0f;
                    this.f4572a.a(2);
                }
                listView2 = this.f4572a.l;
                listView2.invalidate();
                this.f4572a.a(10L);
                return;
            case 2:
                this.f4572a.a(3);
                return;
            case 3:
                ch chVar2 = this.f4572a;
                f = this.f4572a.f;
                ch.b(chVar2, f * 0.2d);
                f2 = this.f4572a.f;
                if (f2 < 0.1d) {
                    this.f4572a.f = 0.0f;
                    this.f4572a.a(0);
                }
                listView = this.f4572a.l;
                listView.invalidate();
                this.f4572a.a(10L);
                return;
            default:
                return;
        }
    }
}
