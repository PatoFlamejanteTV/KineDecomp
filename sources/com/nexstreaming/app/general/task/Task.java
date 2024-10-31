package com.nexstreaming.app.general.task;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.facebook.internal.AnalyticsEvents;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class Task {
    public static final int INVALID_TASK_ID = 0;
    private AtomicBoolean mCancelRequested;
    private final long mLongTaskId;
    private final int mTaskId;
    private static int sTaskId = 0;
    private static long sLongTaskId = (SystemClock.uptimeMillis() & (-1)) << 32;
    private static Map<Long, WeakReference<Task>> sLongIdTaskMap = new HashMap();
    private static SparseArray<WeakReference<Task>> sIntIdTaskMap = new SparseArray<>();
    private static int sRegisterCount = 0;
    public static final TaskError UNKNOWN_ERROR = new e();
    public static final TaskError TIMEOUT = new h();
    public static final TaskError NO_RESULT_AVAILABLE = new i();
    private List<Pair<OnTaskEventListener, Event>> mListeners = new LinkedList();
    private EnumSet<Event> mSignalledEvents = EnumSet.noneOf(Event.class);
    private int mProgress = 0;
    private int mMaxProgress = 0;
    private boolean mProgressSignalled = false;
    private boolean mRegistered = false;
    private TaskError mTaskError = null;
    private boolean mCancellable = false;
    private Handler mHandler = null;
    private Runnable mTimeoutRunnable = null;
    private CountDownLatch mLatch = null;

    /* loaded from: classes.dex */
    public enum Event {
        SUCCESS,
        FAIL,
        COMPLETE,
        CANCEL,
        PROGRESS,
        RESULT_AVAILABLE,
        UPDATE_OR_RESULT_AVAILABLE
    }

    /* loaded from: classes.dex */
    public interface OnFailListener {
        void onFail(Task task, Event event, TaskError taskError);
    }

    /* loaded from: classes.dex */
    public interface OnProgressListener {
        void onProgress(Task task, Event event, int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface OnTaskEventListener {
        void onTaskEvent(Task task, Event event);
    }

    /* loaded from: classes.dex */
    public interface TaskError {
        Exception getException();

        String getLocalizedMessage(Context context);

        String getMessage();
    }

    /* loaded from: classes.dex */
    public static class TaskErrorException extends Exception {
        private static final long serialVersionUID = 1;
        private final TaskError taskError;

        public TaskErrorException(TaskError taskError) {
            super(taskError.getMessage());
            this.taskError = taskError;
        }

        public TaskErrorException(TaskError taskError, Throwable th) {
            super(taskError.getMessage(), th);
            this.taskError = taskError;
        }

        public TaskError getTaskError() {
            return this.taskError;
        }
    }

    /* loaded from: classes.dex */
    public static class SimpleTaskError implements TaskError {
        private final Exception mException;
        private final String mMessage;

        public SimpleTaskError(Exception exc, String str) {
            this.mException = exc;
            this.mMessage = str;
        }

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public Exception getException() {
            return this.mException;
        }

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public String getMessage() {
            if (this.mMessage != null) {
                return this.mMessage;
            }
            if (this.mException.getMessage() != null) {
                return this.mException.getMessage();
            }
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public String getLocalizedMessage(Context context) {
            if (this.mMessage != null) {
                return this.mMessage;
            }
            if (this.mException.getLocalizedMessage() != null) {
                return this.mException.getLocalizedMessage();
            }
            if (this.mException.getMessage() != null) {
                return this.mException.getMessage();
            }
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }

        public String toString() {
            return getException() != null ? "<SimpleTaskError: " + getException().getClass().getName() + ">" : "<SimpleTaskError: " + getMessage() + ">";
        }
    }

    public String toString() {
        Iterator it = this.mSignalledEvents.iterator();
        boolean z = true;
        String str = "";
        while (it.hasNext()) {
            str = str + (z ? "" : ",") + ((Event) it.next()).name();
            z = false;
        }
        if (str.length() < 1) {
            str = "none";
        }
        return this.mProgressSignalled ? "[Task " + this.mTaskId + ": progress=" + this.mProgress + "/" + this.mMaxProgress + " events=" + str + "]" : "[Task " + this.mTaskId + ": events=" + str + "]";
    }

    public static TaskError makeTaskError(Exception exc) {
        return new SimpleTaskError(exc, null);
    }

    public static TaskError makeTaskError(String str, Exception exc) {
        return new SimpleTaskError(exc, str);
    }

    public static TaskError makeTaskError(String str) {
        return new SimpleTaskError(null, str);
    }

    public Task setTimeout(long j) {
        if (this.mHandler == null) {
            this.mHandler = new Handler();
        }
        if (this.mTimeoutRunnable == null) {
            this.mTimeoutRunnable = new j(this);
        } else {
            this.mHandler.removeCallbacks(this.mTimeoutRunnable);
        }
        this.mHandler.postDelayed(this.mTimeoutRunnable, j);
        return this;
    }

    public void cancel() {
        if (!this.mCancellable) {
            throw new RuntimeException("Not a cancellable task");
        }
        this.mCancelRequested.set(true);
    }

    public boolean isCancelRequested() {
        if (!this.mCancellable) {
            throw new RuntimeException("Not a cancellable task");
        }
        return this.mCancelRequested.get();
    }

    public boolean isCancellable() {
        return this.mCancellable;
    }

    public void setCancellable(boolean z) {
        this.mCancellable = z;
        if (this.mCancellable && this.mCancelRequested == null) {
            this.mCancelRequested = new AtomicBoolean(false);
        } else if (!this.mCancellable) {
            this.mCancelRequested = null;
        }
    }

    public Task() {
        sTaskId++;
        sLongTaskId++;
        if (sTaskId == 0) {
            sTaskId++;
        }
        if (sLongTaskId == 0) {
            sLongTaskId++;
        }
        this.mTaskId = sTaskId;
        this.mLongTaskId = sLongTaskId;
    }

    public synchronized void makeWaitable() {
        if (this.mLatch == null) {
            this.mLatch = new CountDownLatch(1);
        }
        if (!isRunning()) {
            signalCompletionEvent();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public Task awaitTaskCompletion() {
        if (this.mLatch == null) {
            throw new RuntimeException("Not a waitable task");
        }
        Thread thread = Looper.getMainLooper().getThread();
        Thread currentThread = Thread.currentThread();
        if (thread == currentThread) {
            throw new RuntimeException("Would block on UI thread");
        }
        ?? r0 = 0;
        while (true) {
            try {
                currentThread = r0;
                this.mLatch.await();
                break;
            } catch (InterruptedException e) {
                r0 = 1;
            } catch (Throwable th) {
                if (currentThread != null) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (currentThread != null) {
            Thread.currentThread().interrupt();
        }
        return this;
    }

    private void signalCompletionEvent() {
        if (this.mLatch != null) {
            this.mLatch.countDown();
        }
    }

    public void register() {
        if (!this.mRegistered) {
            sIntIdTaskMap.put(this.mTaskId, new WeakReference<>(this));
            sLongIdTaskMap.put(Long.valueOf(this.mLongTaskId), new WeakReference<>(this));
            sRegisterCount++;
            if (sRegisterCount > 32) {
                ArrayList arrayList = new ArrayList();
                int size = sIntIdTaskMap.size();
                for (int i = 0; i < size; i++) {
                    int keyAt = sIntIdTaskMap.keyAt(i);
                    WeakReference<Task> valueAt = sIntIdTaskMap.valueAt(i);
                    if (valueAt == null || valueAt.get() == null) {
                        arrayList.add(Integer.valueOf(keyAt));
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    sIntIdTaskMap.remove(((Integer) it.next()).intValue());
                }
                ArrayList arrayList2 = new ArrayList();
                for (Map.Entry<Long, WeakReference<Task>> entry : sLongIdTaskMap.entrySet()) {
                    if (entry.getValue() == null || entry.getValue().get() == null) {
                        arrayList2.add(entry.getKey());
                    }
                }
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    sLongIdTaskMap.remove((Long) it2.next());
                }
                sRegisterCount = 0;
            }
            this.mRegistered = true;
        }
    }

    public static Task findTaskById(int i) {
        WeakReference<Task> weakReference = sIntIdTaskMap.get(i);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public static Task findTaskByLongId(long j) {
        WeakReference<Task> weakReference = sLongIdTaskMap.get(Long.valueOf(j));
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public int getTaskId() {
        return this.mTaskId;
    }

    public long getLongTaskId() {
        return this.mLongTaskId;
    }

    public Task onEvent(Event event, OnTaskEventListener onTaskEventListener) {
        if (event != null && onTaskEventListener != null) {
            if (didSignalEvent(event)) {
                onTaskEventListener.onTaskEvent(this, event);
            } else {
                this.mListeners.add(new Pair<>(onTaskEventListener, event));
            }
        }
        return this;
    }

    public boolean isRepeatableEvent(Event event) {
        return event == Event.PROGRESS || event == Event.UPDATE_OR_RESULT_AVAILABLE;
    }

    public boolean didSignalEvent(Event event) {
        return this.mSignalledEvents.contains(event);
    }

    public Task onSuccess(OnTaskEventListener onTaskEventListener) {
        return onEvent(Event.SUCCESS, onTaskEventListener);
    }

    public Task onFailure(OnFailListener onFailListener) {
        return onEvent(Event.FAIL, new k(this, onFailListener));
    }

    public Task onComplete(OnTaskEventListener onTaskEventListener) {
        return onEvent(Event.COMPLETE, onTaskEventListener);
    }

    public Task onCancel(OnTaskEventListener onTaskEventListener) {
        return onEvent(Event.CANCEL, onTaskEventListener);
    }

    public Task onProgress(OnProgressListener onProgressListener) {
        return onEvent(Event.PROGRESS, new l(this, onProgressListener));
    }

    public void setProgress(int i, int i2) {
        this.mProgress = i;
        this.mMaxProgress = i2;
        this.mProgressSignalled = true;
        signalOneEvent(Event.PROGRESS);
    }

    public boolean isProgressAvailable() {
        return this.mProgressSignalled;
    }

    public int getProgress() {
        if (!this.mProgressSignalled) {
            throw new ProgressNotAvailableException();
        }
        return this.mProgress;
    }

    public int getMaxProgress() {
        if (!this.mProgressSignalled) {
            throw new ProgressNotAvailableException();
        }
        return this.mMaxProgress;
    }

    public TaskError getTaskError() {
        if (didSignalEvent(Event.FAIL)) {
            return this.mTaskError == null ? UNKNOWN_ERROR : this.mTaskError;
        }
        throw new RuntimeException("Error not available (task did not fail)");
    }

    public void setTaskError(TaskError taskError) {
        this.mTaskError = taskError;
    }

    public void signalEvent(Event... eventArr) {
        for (Event event : eventArr) {
            if (event != Event.PROGRESS) {
                signalOneEvent(event);
            }
        }
    }

    public void sendFailure(TaskError taskError) {
        setTaskError(taskError);
        signalEvent(Event.FAIL);
    }

    public synchronized void removeListenerForFail() {
        ArrayList arrayList = new ArrayList(8);
        for (Pair<OnTaskEventListener, Event> pair : this.mListeners) {
            if (pair.second == Event.FAIL) {
                arrayList.add(pair);
            }
        }
        this.mListeners.removeAll(arrayList);
    }

    private synchronized void signalOneEvent(Event event) {
        if (event != null) {
            if (!didSignalEvent(event)) {
                if (didSignalEvent(Event.CANCEL)) {
                    Log.w("Task", "Ingoring attempt to signal a cancelled task.");
                } else if (event == Event.FAIL && didSignalEvent(Event.SUCCESS)) {
                    Log.w("Task", "Ingoring attempt to signal failure on task that already succeeded.");
                } else {
                    if (event == Event.COMPLETE && !didSignalEvent(Event.SUCCESS) && !didSignalEvent(Event.FAIL) && !didSignalEvent(Event.CANCEL)) {
                        signalOneEvent(Event.SUCCESS);
                    }
                    if (!isRepeatableEvent(event)) {
                        this.mSignalledEvents.add(event);
                    }
                    ArrayList arrayList = new ArrayList(8);
                    for (Pair<OnTaskEventListener, Event> pair : this.mListeners) {
                        if (pair.second == event) {
                            arrayList.add(pair);
                        }
                    }
                    if (!isRepeatableEvent(event)) {
                        this.mListeners.removeAll(arrayList);
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((OnTaskEventListener) ((Pair) it.next()).first).onTaskEvent(this, event);
                    }
                    if (event == Event.COMPLETE || event == Event.FAIL || event == Event.CANCEL) {
                        signalCompletionEvent();
                    }
                }
            }
        }
    }

    public boolean isRunning() {
        return (didSignalEvent(Event.COMPLETE) || didSignalEvent(Event.FAIL) || didSignalEvent(Event.CANCEL)) ? false : true;
    }

    public boolean isComplete() {
        return didSignalEvent(Event.COMPLETE);
    }

    /* loaded from: classes.dex */
    public static class ProgressNotAvailableException extends RuntimeException {
        private static final long serialVersionUID = 1;

        public ProgressNotAvailableException() {
        }

        public ProgressNotAvailableException(String str, Throwable th) {
            super(str, th);
        }

        public ProgressNotAvailableException(String str) {
            super(str);
        }

        public ProgressNotAvailableException(Throwable th) {
            super(th);
        }
    }

    /* loaded from: classes.dex */
    public static class MultiplexTask extends Task {
        final Task[] tasks;

        /* loaded from: classes.dex */
        public interface OnAllTasksSignalledListener {
            void onAllTasksSignalled(MultiplexTask multiplexTask, Task[] taskArr, Event event);
        }

        /* synthetic */ MultiplexTask(Task[] taskArr, e eVar) {
            this(taskArr);
        }

        private MultiplexTask(Task[] taskArr) {
            this.tasks = taskArr;
        }

        public Task[] getTasks() {
            return this.tasks;
        }

        public Task onAllTasksSignalled(OnAllTasksSignalledListener onAllTasksSignalledListener) {
            return onEvent(Event.COMPLETE, new p(this, onAllTasksSignalledListener));
        }
    }

    public static Task combinedTask(Collection<? extends Task> collection) {
        Task task = new Task();
        ArrayList<Task> arrayList = new ArrayList(collection);
        for (Task task2 : arrayList) {
            task2.onProgress(new m(arrayList, task));
            task2.onComplete(new n(arrayList, task));
            task2.onSuccess(new o(arrayList, task));
            task2.onFailure(new f(task));
        }
        return task;
    }

    public static MultiplexTask waitForAll(Task... taskArr) {
        MultiplexTask multiplexTask = new MultiplexTask(taskArr, null);
        Event[] eventArr = new Event[taskArr.length];
        for (int i = 0; i < taskArr.length; i++) {
            eventArr[i] = null;
        }
        g gVar = new g(taskArr, eventArr, multiplexTask);
        for (Task task : taskArr) {
            task.onEvent(Event.COMPLETE, gVar);
            task.onEvent(Event.FAIL, gVar);
            task.onEvent(Event.CANCEL, gVar);
        }
        return multiplexTask;
    }
}
