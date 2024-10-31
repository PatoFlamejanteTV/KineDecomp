package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Handler;
import com.crashlytics.android.Crashlytics;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.layer.TextLayer;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionPanelDefaultFragment.kt */
/* loaded from: classes2.dex */
final class Ud implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bd f22142a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f22143b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ VideoEditor f22144c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Integer f22145d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ud(Bd bd, String str, VideoEditor videoEditor, Integer num) {
        this.f22142a = bd;
        this.f22143b = str;
        this.f22144c = videoEditor;
        this.f22145d = num;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public final void onTaskEvent(Task task, Task.Event event) {
        TextLayer newInstance = TextLayer.newInstance(this.f22143b, this.f22144c.v(), this.f22145d.intValue());
        if (EditorGlobal.p) {
            StringBuilder sb = new StringBuilder();
            sb.append("[OptionPanelDefaultFragment:onActivityResult:waitForFirstProjectLoad().onComplete()] textLayer: ");
            if (newInstance == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            sb.append(newInstance);
            Crashlytics.log(sb.toString());
        }
        if (newInstance != null) {
            this.f22144c.a((NexLayerItem) newInstance);
            this.f22142a.a((NexTimelineItem) newInstance);
            new Handler().post(new Td(this, newInstance));
            this.f22142a.b(newInstance);
            if (EditorGlobal.p) {
                Crashlytics.log("[OptionPanelDefaultFragment:onActivityResult:waitForFirstProjectLoad().onComplete():commitChanges()]");
            }
        }
    }
}
