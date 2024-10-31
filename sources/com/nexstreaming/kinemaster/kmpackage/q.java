package com.nexstreaming.kinemaster.kmpackage;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.kmpackage.EffectLibrary;
import java.io.File;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EffectLibrary.java */
/* loaded from: classes.dex */
public class q implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Font f3461a;
    final /* synthetic */ File b;
    final /* synthetic */ Task c;
    final /* synthetic */ EffectLibrary d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(EffectLibrary effectLibrary, Font font, File file, Task task) {
        this.d = effectLibrary;
        this.f3461a = font;
        this.b = file;
        this.c = task;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        List list;
        Map map;
        Map map2;
        list = this.d.M;
        list.add(this.f3461a);
        for (y yVar : this.d.a()) {
            if (yVar instanceof EffectLibrary.b) {
                EffectLibrary.b bVar = (EffectLibrary.b) yVar;
                if (bVar.b().equals(this.f3461a.n())) {
                    map = this.d.N;
                    String b = bVar.b();
                    map2 = bVar.d;
                    map.put(b, map2);
                }
            }
        }
        this.f3461a.a(this.b);
        this.d.k();
        this.c.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
    }
}
