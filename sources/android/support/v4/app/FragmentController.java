package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.support.v4.util.SimpleArrayMap;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/* loaded from: classes.dex */
public class FragmentController {

    /* renamed from: a, reason: collision with root package name */
    private final FragmentHostCallback<?> f726a;

    private FragmentController(FragmentHostCallback<?> fragmentHostCallback) {
        this.f726a = fragmentHostCallback;
    }

    public static FragmentController createController(FragmentHostCallback<?> fragmentHostCallback) {
        return new FragmentController(fragmentHostCallback);
    }

    public void attachHost(Fragment fragment) {
        FragmentHostCallback<?> fragmentHostCallback = this.f726a;
        fragmentHostCallback.f731e.attachController(fragmentHostCallback, fragmentHostCallback, fragment);
    }

    public void dispatchActivityCreated() {
        this.f726a.f731e.dispatchActivityCreated();
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        this.f726a.f731e.dispatchConfigurationChanged(configuration);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.f726a.f731e.dispatchContextItemSelected(menuItem);
    }

    public void dispatchCreate() {
        this.f726a.f731e.dispatchCreate();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.f726a.f731e.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public void dispatchDestroy() {
        this.f726a.f731e.dispatchDestroy();
    }

    public void dispatchDestroyView() {
        this.f726a.f731e.dispatchDestroyView();
    }

    public void dispatchLowMemory() {
        this.f726a.f731e.dispatchLowMemory();
    }

    public void dispatchMultiWindowModeChanged(boolean z) {
        this.f726a.f731e.dispatchMultiWindowModeChanged(z);
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.f726a.f731e.dispatchOptionsItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        this.f726a.f731e.dispatchOptionsMenuClosed(menu);
    }

    public void dispatchPause() {
        this.f726a.f731e.dispatchPause();
    }

    public void dispatchPictureInPictureModeChanged(boolean z) {
        this.f726a.f731e.dispatchPictureInPictureModeChanged(z);
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.f726a.f731e.dispatchPrepareOptionsMenu(menu);
    }

    public void dispatchReallyStop() {
        this.f726a.f731e.dispatchReallyStop();
    }

    public void dispatchResume() {
        this.f726a.f731e.dispatchResume();
    }

    public void dispatchStart() {
        this.f726a.f731e.dispatchStart();
    }

    public void dispatchStop() {
        this.f726a.f731e.dispatchStop();
    }

    @Deprecated
    public void doLoaderDestroy() {
    }

    @Deprecated
    public void doLoaderRetain() {
    }

    @Deprecated
    public void doLoaderStart() {
    }

    @Deprecated
    public void doLoaderStop(boolean z) {
    }

    @Deprecated
    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public boolean execPendingActions() {
        return this.f726a.f731e.execPendingActions();
    }

    public Fragment findFragmentByWho(String str) {
        return this.f726a.f731e.findFragmentByWho(str);
    }

    public List<Fragment> getActiveFragments(List<Fragment> list) {
        return this.f726a.f731e.c();
    }

    public int getActiveFragmentsCount() {
        return this.f726a.f731e.b();
    }

    public FragmentManager getSupportFragmentManager() {
        return this.f726a.c();
    }

    @Deprecated
    public LoaderManager getSupportLoaderManager() {
        return null;
    }

    public void noteStateNotSaved() {
        this.f726a.f731e.noteStateNotSaved();
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f726a.f731e.onCreateView(view, str, context, attributeSet);
    }

    @Deprecated
    public void reportLoaderStart() {
    }

    @Deprecated
    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        this.f726a.f731e.a(parcelable, new FragmentManagerNonConfig(list, null, null));
    }

    @Deprecated
    public void restoreLoaderNonConfig(SimpleArrayMap<String, LoaderManager> simpleArrayMap) {
    }

    @Deprecated
    public SimpleArrayMap<String, LoaderManager> retainLoaderNonConfig() {
        return null;
    }

    public FragmentManagerNonConfig retainNestedNonConfig() {
        return this.f726a.f731e.f();
    }

    @Deprecated
    public List<Fragment> retainNonConfig() {
        FragmentManagerNonConfig f2 = this.f726a.f731e.f();
        if (f2 != null) {
            return f2.b();
        }
        return null;
    }

    public Parcelable saveAllState() {
        return this.f726a.f731e.g();
    }

    public void restoreAllState(Parcelable parcelable, FragmentManagerNonConfig fragmentManagerNonConfig) {
        this.f726a.f731e.a(parcelable, fragmentManagerNonConfig);
    }
}
