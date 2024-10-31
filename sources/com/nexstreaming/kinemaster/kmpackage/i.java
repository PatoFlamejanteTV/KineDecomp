package com.nexstreaming.kinemaster.kmpackage;

import android.os.AsyncTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.kmpackage.OnFontChangeListener;
import java.io.File;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EffectLibrary.java */
/* loaded from: classes.dex */
public class i extends AsyncTask<Integer, Integer, Integer> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Set f3453a;
    final /* synthetic */ Task b;
    final /* synthetic */ EffectLibrary c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(EffectLibrary effectLibrary, Set set, Task task) {
        this.c = effectLibrary;
        this.f3453a = set;
        this.b = task;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer doInBackground(Integer... numArr) {
        this.c.a((Set<File>) this.f3453a);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Integer num) {
        Iterator it = this.f3453a.iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
        this.c.k();
        this.c.j();
        this.c.a(OnFontChangeListener.FontEvent.UNINSTALL);
        this.b.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
        super.onPostExecute(num);
    }
}
