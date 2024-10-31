package com.nextreaming.nexvideoeditor;

import com.nextreaming.nexvideoeditor.NexEditor;
import java.util.Deque;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexEditor.java */
/* renamed from: com.nextreaming.nexvideoeditor.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C2354e extends NexEditor.g {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f24700b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f24701c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ NexEditor.p f24702d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ NexEditor f24703e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2354e(NexEditor nexEditor, int i, int i2, NexEditor.p pVar) {
        this.f24703e = nexEditor;
        this.f24700b = i;
        this.f24701c = i2;
        this.f24702d = pVar;
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.g
    public void a(NexEditor.b bVar) {
        boolean z;
        int i;
        int startPlay;
        Deque deque;
        z = this.f24703e.pa;
        if (z) {
            i = this.f24703e.oa;
            if (i != this.f24700b) {
                return;
            }
            this.f24703e.pa = false;
            this.f24703e.qa = true;
            startPlay = this.f24703e.startPlay(this.f24701c);
            if (startPlay == 0) {
                deque = this.f24703e.v;
                deque.add(this.f24702d);
            } else {
                this.f24702d.a(NexEditor.b.a(startPlay));
            }
        }
    }
}
