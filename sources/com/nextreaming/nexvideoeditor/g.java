package com.nextreaming.nexvideoeditor;

import android.graphics.Rect;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexEditor.java */
/* loaded from: classes.dex */
public class g implements NexEditor.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexEditor f4831a;
    private Map<NexEditor.FastPreviewOption, Integer> b = new EnumMap(NexEditor.FastPreviewOption.class);

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(NexEditor nexEditor) {
        this.f4831a = nexEditor;
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.c
    public NexEditor.c a(NexEditor.FastPreviewOption fastPreviewOption, int i) {
        this.b.put(fastPreviewOption, Integer.valueOf(i));
        return this;
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.c
    public NexEditor.c a(Rect rect) {
        return a(NexEditor.FastPreviewOption.left, rect.left).a(NexEditor.FastPreviewOption.top, rect.bottom).a(NexEditor.FastPreviewOption.right, rect.right).a(NexEditor.FastPreviewOption.bottom, rect.top);
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.c
    public NexEditor.c a(boolean z) {
        return a(NexEditor.FastPreviewOption.swapv, z ? 1 : 0);
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.c
    public NexEditor.c a(int i) {
        return a(NexEditor.FastPreviewOption.cts, i);
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.c
    public void a() {
        b(true);
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.c
    public void b() {
        b(false);
    }

    private void b(boolean z) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<NexEditor.FastPreviewOption, Integer> entry : this.b.entrySet()) {
            if (sb.length() > 0) {
                sb.append(' ');
            }
            sb.append(entry.getKey().name());
            sb.append('=');
            sb.append(entry.getValue());
        }
        this.f4831a.b(sb.toString(), z ? 1 : 0);
    }
}
