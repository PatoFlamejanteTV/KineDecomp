package com.nexstreaming.app.general.task;

import com.nexstreaming.app.general.task.Task;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class ResultTask<T> extends Task {
    private T mResult = null;
    private long mResultTime;

    /* loaded from: classes.dex */
    public interface OnResultAvailableListener<T> {
        void onResultAvailable(ResultTask<T> resultTask, Task.Event event, T t);
    }

    @Override // com.nexstreaming.app.general.task.Task
    public ResultTask<T> setTimeout(long j) {
        super.setTimeout(j);
        return this;
    }

    @Override // com.nexstreaming.app.general.task.Task
    public ResultTask<T> onFailure(Task.OnFailListener onFailListener) {
        super.onFailure(onFailListener);
        return this;
    }

    @Override // com.nexstreaming.app.general.task.Task
    public ResultTask<T> onCancel(Task.OnTaskEventListener onTaskEventListener) {
        super.onCancel(onTaskEventListener);
        return this;
    }

    @Override // com.nexstreaming.app.general.task.Task
    public ResultTask<T> onComplete(Task.OnTaskEventListener onTaskEventListener) {
        super.onComplete(onTaskEventListener);
        return this;
    }

    @Override // com.nexstreaming.app.general.task.Task
    public ResultTask<T> onProgress(Task.OnProgressListener onProgressListener) {
        super.onProgress(onProgressListener);
        return this;
    }

    @Override // com.nexstreaming.app.general.task.Task
    public ResultTask<T> onSuccess(Task.OnTaskEventListener onTaskEventListener) {
        super.onSuccess(onTaskEventListener);
        return this;
    }

    public long getTimeSinceResult() {
        if (didSignalEvent(Task.Event.RESULT_AVAILABLE)) {
            return (System.nanoTime() - this.mResultTime) / 1000000;
        }
        return -1L;
    }

    public void setResult(T t) {
        boolean z = this.mResult != t;
        this.mResult = t;
        this.mResultTime = System.nanoTime();
        signalEvent(Task.Event.RESULT_AVAILABLE);
        if (z) {
            signalEvent(Task.Event.UPDATE_OR_RESULT_AVAILABLE);
        }
    }

    public T getResult() {
        if (!didSignalEvent(Task.Event.RESULT_AVAILABLE)) {
            throw new RuntimeException("Result not available");
        }
        return this.mResult;
    }

    public void sendResult(T t) {
        setResult(t);
        super.signalEvent(Task.Event.RESULT_AVAILABLE, Task.Event.SUCCESS, Task.Event.COMPLETE);
    }

    public ResultTask<T> onResultAvailable(OnResultAvailableListener<T> onResultAvailableListener) {
        onEvent(Task.Event.RESULT_AVAILABLE, new a(this, onResultAvailableListener));
        return this;
    }

    public ResultTask<T> onUpdateOrResultAvailable(OnResultAvailableListener<T> onResultAvailableListener) {
        onEvent(Task.Event.UPDATE_OR_RESULT_AVAILABLE, new b(this, onResultAvailableListener));
        if (didSignalEvent(Task.Event.RESULT_AVAILABLE)) {
            onResultAvailableListener.onResultAvailable(this, Task.Event.UPDATE_OR_RESULT_AVAILABLE, this.mResult);
        }
        return this;
    }

    public T awaitResult() throws Task.TaskErrorException {
        makeWaitable();
        awaitTaskCompletion();
        if (didSignalEvent(Task.Event.FAIL)) {
            throw new Task.TaskErrorException(getTaskError());
        }
        if (!didSignalEvent(Task.Event.RESULT_AVAILABLE)) {
            throw new Task.TaskErrorException(Task.NO_RESULT_AVAILABLE);
        }
        return getResult();
    }

    public static <T> ResultTask<List<T>> combineResults(ResultTask<Collection<T>>... resultTaskArr) {
        return combineResults(Arrays.asList(resultTaskArr));
    }

    public static <T> ResultTask<T> completedResultTask(T t) {
        ResultTask<T> resultTask = new ResultTask<>();
        resultTask.sendResult(t);
        return resultTask;
    }

    public static <INDIVIDUAL_RESULT_TYPE, RESULT_COLLECTION extends Collection<INDIVIDUAL_RESULT_TYPE>, TASK_COLLECTION extends Collection<ResultTask<RESULT_COLLECTION>>> ResultTask<List<INDIVIDUAL_RESULT_TYPE>> combineResults(TASK_COLLECTION task_collection) {
        ResultTask<List<INDIVIDUAL_RESULT_TYPE>> resultTask = new ResultTask<>();
        HashMap hashMap = new HashMap();
        Iterator it = task_collection.iterator();
        while (it.hasNext()) {
            ((ResultTask) it.next()).onResultAvailable(new d(resultTask, hashMap, task_collection)).onFailure((Task.OnFailListener) new c(resultTask, hashMap));
        }
        return resultTask;
    }

    public static <T> ResultTask<T> failedResultTask(Task.TaskError taskError) {
        ResultTask<T> resultTask = new ResultTask<>();
        resultTask.sendFailure(taskError);
        return resultTask;
    }
}
