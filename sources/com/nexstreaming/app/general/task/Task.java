package com.nexstreaming.app.general.task;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.crashlytics.android.Crashlytics;
import com.facebook.internal.AnalyticsEvents;
import com.nextreaming.nexeditorui.NexTimeline;
import java.lang.ref.WeakReference;
import java.security.InvalidParameterException;
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

/* loaded from: classes2.dex */
public class Task {
    public static final int INVALID_TASK_ID = 0;
    private static int sTaskId;
    private AtomicBoolean mCancelRequested;
    private boolean mCancellable;
    private Handler mHandler;
    private CountDownLatch mLatch;
    private List<Pair<OnTaskEventListener, Event>> mListeners;
    private final long mLongTaskId;
    private int mMaxProgress;
    private int mProgress;
    private boolean mProgressSignalled;
    private boolean mRegistered;
    private EnumSet<Event> mSignalledEvents;
    private TaskError mTaskError;
    private final int mTaskId;
    private Runnable mTimeoutRunnable;
    private static long sLongTaskId = (SystemClock.uptimeMillis() & (-1)) << 32;
    private static Map<Long, WeakReference<Task>> sLongIdTaskMap = new HashMap();
    private static SparseArray<WeakReference<Task>> sIntIdTaskMap = new SparseArray<>();
    private static int sRegisterCount = 0;
    public static final Task COMPLETED_TASK = new Task(Event.COMPLETE, Event.SUCCESS);
    public static final TaskError UNKNOWN_ERROR = new h();
    public static final TaskError TIMEOUT = new i();
    public static final TaskError NO_RESULT_AVAILABLE = new j();

    /* loaded from: classes2.dex */
    public enum Event {
        SUCCESS,
        FAIL,
        COMPLETE,
        CANCEL,
        PROGRESS,
        RESULT_AVAILABLE,
        UPDATE_OR_RESULT_AVAILABLE
    }

    /* loaded from: classes2.dex */
    public static class MultiplexTask extends Task {
        final Task[] tasks;

        /* loaded from: classes2.dex */
        public interface OnAllTasksSignalledListener {
            void onAllTasksSignalled(MultiplexTask multiplexTask, Task[] taskArr, Event event);
        }

        /* synthetic */ MultiplexTask(Task[] taskArr, h hVar) {
            this(taskArr);
        }

        public Task[] getTasks() {
            return this.tasks;
        }

        public Task onAllTasksSignalled(OnAllTasksSignalledListener onAllTasksSignalledListener) {
            return onEvent(Event.COMPLETE, new q(this, onAllTasksSignalledListener));
        }

        private MultiplexTask(Task[] taskArr) {
            this.tasks = taskArr;
        }
    }

    /* loaded from: classes2.dex */
    public interface OnFailListener {
        void onFail(Task task, Event event, TaskError taskError);
    }

    /* loaded from: classes2.dex */
    public interface OnProgressListener {
        void onProgress(Task task, Event event, int i, int i2);
    }

    /* loaded from: classes2.dex */
    public interface OnTaskEventListener {
        void onTaskEvent(Task task, Event event);
    }

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
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
        public String getLocalizedMessage(Context context) {
            String str = this.mMessage;
            if (str != null) {
                return str;
            }
            if (this.mException.getLocalizedMessage() != null) {
                return this.mException.getLocalizedMessage();
            }
            return this.mException.getMessage() != null ? this.mException.getMessage() : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public String getMessage() {
            String str = this.mMessage;
            return str != null ? str : this.mException.getMessage() != null ? this.mException.getMessage() : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }

        public String toString() {
            if (getException() != null) {
                return "<SimpleTaskError: " + getException().getClass().getName() + ">";
            }
            return "<SimpleTaskError: " + getMessage() + ">";
        }
    }

    /* loaded from: classes2.dex */
    public interface TaskError {
        Exception getException();

        String getLocalizedMessage(Context context);

        String getMessage();
    }

    public Task() {
        this.mListeners = new LinkedList();
        this.mSignalledEvents = EnumSet.noneOf(Event.class);
        this.mProgress = 0;
        this.mMaxProgress = 0;
        this.mProgressSignalled = false;
        this.mRegistered = false;
        this.mTaskError = null;
        this.mCancellable = false;
        this.mHandler = null;
        this.mTimeoutRunnable = null;
        this.mLatch = null;
        sTaskId++;
        sLongTaskId++;
        int i = sTaskId;
        if (i == 0) {
            sTaskId = i + 1;
        }
        long j = sLongTaskId;
        if (j == 0) {
            sLongTaskId = j + 1;
        }
        this.mTaskId = sTaskId;
        this.mLongTaskId = sLongTaskId;
    }

    public static Task combinedTask(Collection<? extends Task> collection) {
        Task task = new Task();
        ArrayList<Task> arrayList = new ArrayList(collection);
        for (Task task2 : arrayList) {
            task2.onProgress(new o(arrayList, task));
            task2.onComplete(new p(arrayList, task));
            task2.onSuccess(new e(arrayList, task));
            task2.onFailure(new f(task));
        }
        return task;
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

    public static Task makeFailedTask(Exception exc) {
        Task task = new Task();
        task.sendFailure(new SimpleTaskError(exc, null));
        return task;
    }

    public static TaskError makeTaskError(Exception exc) {
        return new SimpleTaskError(exc, null);
    }

    private void signalCompletionEvent() {
        CountDownLatch countDownLatch = this.mLatch;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    private synchronized void signalOneEvent(Event event) {
        if (event != null) {
            if (!didSignalEvent(event)) {
                if (didSignalEvent(Event.CANCEL)) {
                    Log.w("Task", "Ingoring attempt to signal a cancelled task.");
                    return;
                }
                if (event == Event.FAIL && didSignalEvent(Event.SUCCESS)) {
                    Log.w("Task", "Ingoring attempt to signal failure on task that already succeeded.");
                    return;
                }
                if (event == Event.COMPLETE && !didSignalEvent(Event.SUCCESS) && !didSignalEvent(Event.FAIL) && !didSignalEvent(Event.CANCEL)) {
                    signalOneEvent(Event.SUCCESS);
                }
                if (!isRepeatableEvent(event)) {
                    this.mSignalledEvents.add(event);
                }
                ArrayList arrayList = new ArrayList(8);
                for (Pair<OnTaskEventListener, Event> pair : this.mListeners) {
                    if (pair == null) {
                        Crashlytics.log("[Task] has null object thread:" + Thread.currentThread().getName());
                    }
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

    public Task awaitTaskCompletion() {
        if (this.mLatch != null) {
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                throw new RuntimeException("Would block on UI thread");
            }
            boolean z = false;
            while (true) {
                try {
                    this.mLatch.await();
                    break;
                } catch (InterruptedException unused) {
                    z = true;
                } catch (Throwable th) {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            return this;
        }
        throw new RuntimeException("Not a waitable task");
    }

    public void cancel() {
        if (this.mCancellable) {
            this.mCancelRequested.set(true);
            return;
        }
        throw new RuntimeException("Not a cancellable task");
    }

    public boolean didSignalEvent(Event event) {
        return this.mSignalledEvents.contains(event);
    }

    public long getLongTaskId() {
        return this.mLongTaskId;
    }

    public int getMaxProgress() {
        if (this.mProgressSignalled) {
            return this.mMaxProgress;
        }
        throw new ProgressNotAvailableException();
    }

    public int getProgress() {
        if (this.mProgressSignalled) {
            return this.mProgress;
        }
        throw new ProgressNotAvailableException();
    }

    public TaskError getTaskError() {
        if (didSignalEvent(Event.FAIL)) {
            TaskError taskError = this.mTaskError;
            return taskError == null ? UNKNOWN_ERROR : taskError;
        }
        throw new RuntimeException("Error not available (task did not fail)");
    }

    public int getTaskId() {
        return this.mTaskId;
    }

    public boolean isCancelRequested() {
        if (this.mCancellable) {
            return this.mCancelRequested.get();
        }
        throw new RuntimeException("Not a cancellable task");
    }

    public boolean isCancellable() {
        return this.mCancellable;
    }

    public boolean isComplete() {
        return didSignalEvent(Event.COMPLETE);
    }

    public boolean isProgressAvailable() {
        return this.mProgressSignalled;
    }

    public boolean isRepeatableEvent(Event event) {
        return event == Event.PROGRESS || event == Event.UPDATE_OR_RESULT_AVAILABLE;
    }

    public boolean isRunning() {
        return (didSignalEvent(Event.COMPLETE) || didSignalEvent(Event.FAIL) || didSignalEvent(Event.CANCEL)) ? false : true;
    }

    public synchronized void makeWaitable() {
        if (this.mLatch == null) {
            this.mLatch = new CountDownLatch(1);
        }
        if (!isRunning()) {
            signalCompletionEvent();
        }
    }

    public Task onCancel(OnTaskEventListener onTaskEventListener) {
        return onEvent(Event.CANCEL, onTaskEventListener);
    }

    public Task onComplete(OnTaskEventListener onTaskEventListener) {
        return onEvent(Event.COMPLETE, onTaskEventListener);
    }

    public Task onEvent(Event event, OnTaskEventListener onTaskEventListener) {
        if (event != null && onTaskEventListener != null) {
            if (didSignalEvent(event)) {
                onTaskEventListener.onTaskEvent(this, event);
                return this;
            }
            this.mListeners.add(new Pair<>(onTaskEventListener, event));
            Crashlytics.log("[Task] add object event:" + event.name() + ", thread:" + Thread.currentThread().getName());
            Log.d("TASK", "add object event:" + event.name() + ", thread:" + Thread.currentThread().getName());
        }
        return this;
    }

    public Task onFailure(OnFailListener onFailListener) {
        return onEvent(Event.FAIL, new l(this, onFailListener));
    }

    public Task onProgress(OnProgressListener onProgressListener) {
        return onEvent(Event.PROGRESS, new n(this, onProgressListener));
    }

    public Task onSuccess(OnTaskEventListener onTaskEventListener) {
        return onEvent(Event.SUCCESS, onTaskEventListener);
    }

    public void register() {
        if (this.mRegistered) {
            return;
        }
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

    public synchronized void removeListenerForFail() {
        ArrayList arrayList = new ArrayList(8);
        for (Pair<OnTaskEventListener, Event> pair : this.mListeners) {
            if (pair.second == Event.FAIL) {
                arrayList.add(pair);
            }
        }
        this.mListeners.removeAll(arrayList);
    }

    public void sendFailure(TaskError taskError) {
        setTaskError(taskError);
        signalEvent(Event.FAIL);
    }

    public void setCancellable(boolean z) {
        this.mCancellable = z;
        if (this.mCancellable && this.mCancelRequested == null) {
            this.mCancelRequested = new AtomicBoolean(false);
        } else {
            if (this.mCancellable) {
                return;
            }
            this.mCancelRequested = null;
        }
    }

    public void setProgress(int i, int i2) {
        this.mProgress = i;
        this.mMaxProgress = i2;
        this.mProgressSignalled = true;
        signalOneEvent(Event.PROGRESS);
    }

    public void setTaskError(TaskError taskError) {
        this.mTaskError = taskError;
    }

    public Task setTimeout(long j) {
        if (this.mHandler == null) {
            this.mHandler = new Handler();
        }
        Runnable runnable = this.mTimeoutRunnable;
        if (runnable == null) {
            this.mTimeoutRunnable = new k(this);
        } else {
            this.mHandler.removeCallbacks(runnable);
        }
        this.mHandler.postDelayed(this.mTimeoutRunnable, j);
        return this;
    }

    public void signalEvent(Event... eventArr) {
        for (Event event : eventArr) {
            if (event != Event.PROGRESS) {
                signalOneEvent(event);
            }
        }
    }

    public String toString() {
        Iterator it = this.mSignalledEvents.iterator();
        String str = "";
        boolean z = true;
        while (it.hasNext()) {
            Event event = (Event) it.next();
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(z ? "" : ",");
            sb.append(event.name());
            str = sb.toString();
            z = false;
        }
        if (str.length() < 1) {
            str = NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE;
        }
        if (this.mProgressSignalled) {
            return "[Task " + this.mTaskId + ": progress=" + this.mProgress + "/" + this.mMaxProgress + " events=" + str + "]";
        }
        return "[Task " + this.mTaskId + ": events=" + str + "]";
    }

    /* loaded from: classes2.dex */
    public static class TaskErrorException extends Exception {
        private static final long serialVersionUID = 1;
        private final TaskError taskError;

        public TaskErrorException(TaskError taskError) {
            super(taskError.getMessage());
            this.taskError = taskError;
        }

        public TaskError getTaskError() {
            return this.taskError;
        }

        public TaskErrorException(TaskError taskError, Throwable th) {
            super(taskError.getMessage(), th);
            this.taskError = taskError;
        }
    }

    public static TaskError makeTaskError(String str, Exception exc) {
        return new SimpleTaskError(exc, str);
    }

    public Task onFailure(Task task) {
        if (task != this) {
            return onEvent(Event.FAIL, new m(this, task));
        }
        throw new InvalidParameterException();
    }

    public static Task makeFailedTask(String str, Exception exc) {
        Task task = new Task();
        task.sendFailure(new SimpleTaskError(exc, str));
        return task;
    }

    public static TaskError makeTaskError(String str) {
        return new SimpleTaskError(null, str);
    }

    public static Task makeFailedTask(String str) {
        Task task = new Task();
        task.sendFailure(new SimpleTaskError(null, str));
        return task;
    }

    public static Task makeFailedTask(TaskError taskError) {
        Task task = new Task();
        task.sendFailure(taskError);
        return task;
    }

    private Task(Event... eventArr) {
        this();
        signalEvent(eventArr);
    }
}
