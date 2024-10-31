package io.fabric.sdk.android.services.common;

import io.fabric.sdk.android.services.common.w;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: QueueFile.java */
/* loaded from: classes3.dex */
public class v implements w.c {

    /* renamed from: a */
    boolean f26909a = true;

    /* renamed from: b */
    final /* synthetic */ StringBuilder f26910b;

    /* renamed from: c */
    final /* synthetic */ w f26911c;

    public v(w wVar, StringBuilder sb) {
        this.f26911c = wVar;
        this.f26910b = sb;
    }

    @Override // io.fabric.sdk.android.services.common.w.c
    public void read(InputStream inputStream, int i) throws IOException {
        if (this.f26909a) {
            this.f26909a = false;
        } else {
            this.f26910b.append(", ");
        }
        this.f26910b.append(i);
    }
}
