package com.nextreaming.nexvideoeditor;

import android.graphics.Rect;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexEditor.java */
/* renamed from: com.nextreaming.nexvideoeditor.i, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C2358i implements NexEditor.c {

    /* renamed from: a, reason: collision with root package name */
    private Map<NexEditor.FastPreviewOption, Integer> f24716a = new EnumMap(NexEditor.FastPreviewOption.class);

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NexEditor f24717b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2358i(NexEditor nexEditor) {
        this.f24717b = nexEditor;
    }

    private void b(boolean z) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<NexEditor.FastPreviewOption, Integer> entry : this.f24716a.entrySet()) {
            if (sb.length() > 0) {
                sb.append(' ');
            }
            sb.append(entry.getKey().name());
            sb.append('=');
            sb.append(entry.getValue());
        }
        this.f24717b.c(sb.toString(), z ? 1 : 0);
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.c
    public NexEditor.c a(NexEditor.FastPreviewOption fastPreviewOption, int i) {
        this.f24716a.put(fastPreviewOption, Integer.valueOf(i));
        return this;
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.c
    public void execute() {
        b(true);
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.c
    public NexEditor.c a(Rect rect) {
        a(NexEditor.FastPreviewOption.left, rect.left);
        a(NexEditor.FastPreviewOption.top, rect.bottom);
        a(NexEditor.FastPreviewOption.right, rect.right);
        a(NexEditor.FastPreviewOption.bottom, rect.top);
        return this;
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.c
    public NexEditor.c a(boolean z) {
        a(NexEditor.FastPreviewOption.swapv, z ? 1 : 0);
        return this;
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.c
    public NexEditor.c a(int i) {
        a(NexEditor.FastPreviewOption.cts, i);
        return this;
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.c
    public void a() {
        b(false);
    }
}
