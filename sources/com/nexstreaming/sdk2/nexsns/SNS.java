package com.nexstreaming.sdk2.nexsns;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes.dex */
public abstract class SNS {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<Activity> f4410a;

    /* loaded from: classes.dex */
    public enum PrivacyManagementProfile {
        ALWAYS_PUBLIC,
        MANAGED_BY_SNS,
        MANAGED_BY_APP
    }

    public abstract ad a(File file);

    public abstract String a(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(Activity activity, int i, int i2, Intent intent);

    public abstract boolean a();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a_(Bundle bundle);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void b(Bundle bundle);

    public abstract boolean b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b_(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void c(String str);

    public abstract boolean c();

    public abstract void c_(String str);

    public abstract boolean d();

    public abstract int e();

    public abstract Task f();

    public abstract String g();

    public abstract PrivacyManagementProfile h();

    public abstract List<Privacy> i();

    public abstract ResultTask<List<ac>> j();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void k();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void l();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void m();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void n();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void o();

    /* JADX INFO: Access modifiers changed from: package-private */
    public SNS(Activity activity) {
        this.f4410a = new WeakReference<>(activity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Activity r() {
        if (this.f4410a == null) {
            return null;
        }
        return this.f4410a.get();
    }

    /* loaded from: classes.dex */
    public enum SNSErrorCode implements Task.TaskError {
        WrongActivityResult,
        NetworkError,
        ServiceErrorPopupShown,
        ServiceErrorNoPopup,
        NullClient,
        AppMissing,
        AppNeedsUpdate,
        AppMissingOrNeedsUpdate,
        SignInRequired,
        NeedPermission;

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public Exception getException() {
            return null;
        }

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public String getMessage() {
            return name();
        }

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public String getLocalizedMessage(Context context) {
            return getMessage();
        }
    }

    /* loaded from: classes.dex */
    public static class a implements Task.TaskError {

        /* renamed from: a, reason: collision with root package name */
        private final int f4411a;
        private final String b;

        public a(int i) {
            this.f4411a = i;
            this.b = "Service error " + i;
        }

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public Exception getException() {
            return null;
        }

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public String getMessage() {
            return this.b;
        }

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public String getLocalizedMessage(Context context) {
            return this.b;
        }

        public int a() {
            return this.f4411a;
        }
    }
}
