package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public abstract class FragmentHostCallback<E> extends FragmentContainer {

    /* renamed from: a, reason: collision with root package name */
    private final Activity f727a;

    /* renamed from: b, reason: collision with root package name */
    final Context f728b;

    /* renamed from: c, reason: collision with root package name */
    private final Handler f729c;

    /* renamed from: d, reason: collision with root package name */
    final int f730d;

    /* renamed from: e, reason: collision with root package name */
    final FragmentManagerImpl f731e;

    public FragmentHostCallback(Context context, Handler handler, int i) {
        this(context instanceof Activity ? (Activity) context : null, context, handler, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Activity a() {
        return this.f727a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context b() {
        return this.f728b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentManagerImpl c() {
        return this.f731e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Handler d() {
        return this.f729c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onAttachFragment(Fragment fragment) {
    }

    public void onDump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @Override // android.support.v4.app.FragmentContainer
    public View onFindViewById(int i) {
        return null;
    }

    public abstract E onGetHost();

    public LayoutInflater onGetLayoutInflater() {
        return LayoutInflater.from(this.f728b);
    }

    public int onGetWindowAnimations() {
        return this.f730d;
    }

    @Override // android.support.v4.app.FragmentContainer
    public boolean onHasView() {
        return true;
    }

    public boolean onHasWindowAnimations() {
        return true;
    }

    public void onRequestPermissionsFromFragment(Fragment fragment, String[] strArr, int i) {
    }

    public boolean onShouldSaveFragmentState(Fragment fragment) {
        return true;
    }

    public boolean onShouldShowRequestPermissionRationale(String str) {
        return false;
    }

    public void onStartActivityFromFragment(Fragment fragment, Intent intent, int i) {
        onStartActivityFromFragment(fragment, intent, i, null);
    }

    public void onStartIntentSenderFromFragment(Fragment fragment, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (i == -1) {
            ActivityCompat.startIntentSenderForResult(this.f727a, intentSender, i, intent, i2, i3, i4, bundle);
            return;
        }
        throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
    }

    public void onSupportInvalidateOptionsMenu() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentHostCallback(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.mHandler, 0);
    }

    public void onStartActivityFromFragment(Fragment fragment, Intent intent, int i, Bundle bundle) {
        if (i == -1) {
            this.f728b.startActivity(intent);
            return;
        }
        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }

    FragmentHostCallback(Activity activity, Context context, Handler handler, int i) {
        this.f731e = new FragmentManagerImpl();
        this.f727a = activity;
        this.f728b = context;
        this.f729c = handler;
        this.f730d = i;
    }
}
