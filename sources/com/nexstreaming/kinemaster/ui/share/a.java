package com.nexstreaming.kinemaster.ui.share;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.util.Log;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.DiagnosticLogger;
import com.nexstreaming.app.general.util.SupportLogger;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.a.a;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nexstreaming.kinemaster.ui.share.k;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexvideoeditor.NexEditor;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* compiled from: ExportDialogFragment.java */
/* loaded from: classes.dex */
public class a extends DialogFragment implements Task.OnFailListener, Task.OnProgressListener, Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    private k.a f4284a;
    private int b;
    private int c;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private Task.TaskError g = null;
    private boolean h = false;
    private boolean i = false;
    private boolean j = false;
    private long k = 0;
    private long l = 0;
    private long m = -1;

    public a a(k.a aVar) {
        SupportLogger.Event.ExportDialogFragment_SetExportTask.log(new int[0]);
        if (isAdded()) {
            throw new IllegalStateException();
        }
        aVar.register();
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        this.f4284a = aVar;
        arguments.putLong("km.exportdialog.task", aVar.getLongTaskId());
        setArguments(arguments);
        return this;
    }

    private k.a b() {
        Bundle arguments;
        Task findTaskByLongId;
        if (this.f4284a == null && (arguments = getArguments()) != null) {
            long j = arguments.getLong("km.exportdialog.task");
            if (j != 0 && (findTaskByLongId = Task.findTaskByLongId(j)) != null && (findTaskByLongId instanceof k.a)) {
                this.f4284a = (k.a) findTaskByLongId;
            }
        }
        return this.f4284a;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        SupportLogger.Event.ExportDialogFragment_OnCreate.log(new int[0]);
        super.onCreate(bundle);
        setCancelable(false);
        k.a b = b();
        if (b != null) {
            b.onComplete(this);
            b.onFailure(this);
            b.onProgress(this);
            b.onCancel(this);
        }
    }

    public com.nexstreaming.kinemaster.ui.a.e a() {
        Dialog dialog = super.getDialog();
        if (dialog == null || !(dialog instanceof com.nexstreaming.kinemaster.ui.a.e)) {
            return null;
        }
        return (com.nexstreaming.kinemaster.ui.a.e) dialog;
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        SupportLogger.Event.ExportDialogFragment_OnCreateDialog.log(new int[0]);
        b();
        e.a aVar = new e.a(getActivity());
        aVar.d(R.string.export_dialog_title);
        aVar.a(R.string.export_dialog_message);
        aVar.c(R.string.export_no_switch_app);
        aVar.b(R.string.export_est);
        aVar.a(R.string.button_cancel, new b(this));
        aVar.a(false);
        com.nexstreaming.kinemaster.ui.a.e a2 = aVar.a();
        a2.setOnShowListener(new c(this));
        c();
        return a2;
    }

    private void c() {
        com.nexstreaming.kinemaster.ui.a.e a2 = a();
        k.a b = b();
        if (b == null || a2 == null) {
            if (this.d && !this.e) {
                this.h = true;
            } else if (this.g != null && !this.f) {
                this.i = true;
            }
            if (b != null && this.c > 0 && this.b > 0) {
                k.a().c();
                return;
            }
            return;
        }
        if (this.c > 0) {
            int a3 = a(this.b, this.c);
            if (a3 >= 0) {
                int i = a3 / 60000;
                int i2 = (a3 % 60000) / LicenseErrCode.LICENSE_STATUS_NOT_LICENSED;
                a2.e(EditorGlobal.b(getResources(), a3));
            }
            a2.i(this.c);
            a2.h(this.b);
            if (a2.getWindow() != null && a2.getWindow().getDecorView().getVisibility() != 0) {
                a2.getWindow().getDecorView().setVisibility(0);
            }
        } else {
            a2.hide();
        }
        if (this.d && !this.e) {
            f();
        } else if (this.g != null && !this.f) {
            e();
        }
    }

    private int a(int i, int i2) {
        long nanoTime = System.nanoTime() / 1000000;
        if (this.k == 0) {
            this.k = nanoTime;
        }
        float f = i / i2;
        long j = nanoTime - this.k;
        long j2 = ((float) j) / f;
        if (this.k > 0 && j > 5000 && j2 > i2 / 6 && ((j2 < i2 * 5 || j > 15000) && f > 5.0E-4d && ((j2 - j < 30000 && j2 > this.m) || nanoTime - this.l > 15000))) {
            this.m = j2;
            this.l = nanoTime;
        }
        if (this.k == 0 || this.m < 5000) {
            return -1;
        }
        int i3 = (int) (this.m - j);
        if (i3 < 0) {
            return 0;
        }
        return i3;
    }

    private void d() {
        SupportLogger.Event.ExportDialogFragment_OnExportComplete.log(new int[0]);
        this.d = true;
        c();
    }

    private void e() {
        int i = 0;
        SupportLogger.Event.ExportDialogFragment_ShowFailureDialog.log(new int[0]);
        b();
        Activity activity = getActivity();
        if (activity == null || !(activity instanceof ad) || !isAdded() || !this.j) {
            this.i = true;
            return;
        }
        if (this.g == NexEditor.b.bd) {
            i = R.string.encoding_fail_notready;
        } else if (this.g == NexEditor.b.K) {
            i = R.string.encoding_fail_notready_transcode;
        } else if (this.g == NexEditor.b.bi) {
            i = R.string.encoding_fail_missingrsrc_text;
        } else if (this.g == NexEditor.b.bh) {
            i = R.string.encoding_fail_emptyproject_text;
        } else if (this.g == NexEditor.b.W) {
            i = R.string.encoding_fail_diskfull_text;
        }
        if (i != 0) {
            new a.C0074a(getActivity()).a(i).a(R.string.button_ok, new d(this)).a().show();
        } else {
            new a.C0074a(getActivity()).a(R.string.encoding_fail_error_text).b(this.g.getLocalizedMessage(getActivity())).a(R.string.button_ok, new e(this)).a().show();
        }
        this.f = true;
        dismissAllowingStateLoss();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onStart() {
        super.onStart();
        this.j = true;
        if (this.h) {
            this.h = false;
            f();
        }
        if (this.i) {
            this.i = false;
            e();
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onStop() {
        super.onStop();
        this.j = false;
    }

    private void f() {
        SupportLogger.Event.ExportDialogFragment_ShowCompletionDialog.log(new int[0]);
        k.a b = b();
        Activity activity = getActivity();
        if (activity != null && (activity instanceof ad) && isAdded() && this.j) {
            ((ad) activity).a(b.a(), b.b());
            this.e = true;
            dismissAllowingStateLoss();
            return;
        }
        this.h = true;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        if (getFragmentManager() == null || !isAdded()) {
            Log.d("ExportDialogFragment", "TESTTEST :: onTaskEvent :: " + isAdded() + " :: " + isDetached() + " :: " + isRemoving() + " :: " + getFragmentManager());
        } else if (event == Task.Event.COMPLETE) {
            d();
        } else if (event == Task.Event.CANCEL) {
            dismissAllowingStateLoss();
        }
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        if (taskError instanceof DiagnosticLogger.a) {
            SupportLogger.Event.ExportDialogFragment_OnFail.log(((DiagnosticLogger.a) taskError).getIntErrorCode());
        } else {
            SupportLogger.Event.ExportDialogFragment_OnFail.log(new int[0]);
        }
        this.g = taskError;
        c();
    }

    @Override // com.nexstreaming.app.general.task.Task.OnProgressListener
    public void onProgress(Task task, Task.Event event, int i, int i2) {
        this.b = i;
        this.c = i2;
        c();
    }
}
