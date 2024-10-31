package com.nexstreaming.kinemaster.kmpackage;

import android.util.Log;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.kmpackage.ad;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EffectLibrary.java */
/* loaded from: classes.dex */
public class s implements ad.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ EffectLibrary f3463a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(EffectLibrary effectLibrary) {
        this.f3463a = effectLibrary;
    }

    @Override // com.nexstreaming.kinemaster.kmpackage.ad.a
    public void a(ai aiVar, boolean z) {
        int i;
        Task task;
        int i2;
        Task task2;
        this.f3463a.a(aiVar);
        if (z) {
            EffectLibrary.g(this.f3463a);
            i2 = this.f3463a.r;
            if (i2 < 1) {
                task2 = this.f3463a.p;
                task2.signalEvent(Task.Event.COMPLETE);
            }
        }
        EffectLibrary.j(this.f3463a);
        i = this.f3463a.q;
        if (i < 1) {
            task = this.f3463a.o;
            task.signalEvent(Task.Event.COMPLETE);
        }
    }

    @Override // com.nexstreaming.kinemaster.kmpackage.ad.a
    public void a(String str, Exception exc, boolean z) {
        List list;
        int i;
        Task task;
        int i2;
        Task task2;
        if (exc instanceof MissingDependencyException) {
            Log.w("EffectLibrary", "Missing dependencies detected; seems like a theme package download or install was interrupted. " + str);
        } else {
            Log.w("EffectLibrary", "[init] onPackageLoadFailure : " + str);
            list = this.f3463a.G;
            list.add(str);
        }
        if (z) {
            EffectLibrary.g(this.f3463a);
            i2 = this.f3463a.r;
            if (i2 < 1) {
                task2 = this.f3463a.p;
                task2.signalEvent(Task.Event.COMPLETE);
            }
        }
        EffectLibrary.j(this.f3463a);
        i = this.f3463a.q;
        if (i < 1) {
            task = this.f3463a.o;
            task.signalEvent(Task.Event.COMPLETE);
        }
    }
}
