package c.d.b.k;

import com.nexstreaming.app.general.task.Task;

/* compiled from: Transcoder.java */
/* loaded from: classes.dex */
class h implements Task.OnFailListener {
    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        ((j) task).g();
    }
}
