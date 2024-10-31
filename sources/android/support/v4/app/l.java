package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

/* compiled from: FragmentActivity.java */
/* loaded from: classes.dex */
public class l extends Activity {
    static final String FRAGMENTS_TAG = "android:support:fragments";
    private static final int HONEYCOMB = 11;
    static final int MSG_REALLY_STOPPED = 1;
    static final int MSG_RESUME_PENDING = 2;
    private static final String TAG = "FragmentActivity";
    android.support.v4.f.i<String, ad> mAllLoaderManagers;
    boolean mCheckedForLoaderManager;
    boolean mCreated;
    ad mLoaderManager;
    boolean mLoadersStarted;
    boolean mOptionsMenuInvalidated;
    boolean mReallyStopped;
    boolean mResumed;
    boolean mRetaining;
    boolean mStopped;
    final Handler mHandler = new m(this);
    final q mFragments = new q();
    final o mContainer = new n(this);

    /* compiled from: FragmentActivity.java */
    /* loaded from: classes.dex */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        Object f59a;
        Object b;
        android.support.v4.f.i<String, Object> c;
        ArrayList<Fragment> d;
        android.support.v4.f.i<String, ad> e;

        a() {
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        this.mFragments.k();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            if (this.mFragments.f == null || i4 < 0 || i4 >= this.mFragments.f.size()) {
                Log.w(TAG, "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
                return;
            }
            Fragment fragment = this.mFragments.f.get(i4);
            if (fragment == null) {
                Log.w(TAG, "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
                return;
            } else {
                fragment.onActivityResult(65535 & i, i2, intent);
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (!this.mFragments.e()) {
            supportFinishAfterTransition();
        }
    }

    public void supportFinishAfterTransition() {
        android.support.v4.app.a.a((Activity) this);
    }

    public void setEnterSharedElementCallback(ay ayVar) {
        android.support.v4.app.a.a(this, ayVar);
    }

    public void setExitSharedElementCallback(ay ayVar) {
        android.support.v4.app.a.b(this, ayVar);
    }

    public void supportPostponeEnterTransition() {
        android.support.v4.app.a.b(this);
    }

    public void supportStartPostponedEnterTransition() {
        android.support.v4.app.a.c(this);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mFragments.a(configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        this.mFragments.a(this, this.mContainer, (Fragment) null);
        if (getLayoutInflater().getFactory() == null) {
            getLayoutInflater().setFactory(this);
        }
        super.onCreate(bundle);
        a aVar = (a) getLastNonConfigurationInstance();
        if (aVar != null) {
            this.mAllLoaderManagers = aVar.e;
        }
        if (bundle != null) {
            this.mFragments.a(bundle.getParcelable(FRAGMENTS_TAG), aVar != null ? aVar.d : null);
        }
        this.mFragments.l();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i == 0) {
            boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu) | this.mFragments.a(menu, getMenuInflater());
            if (Build.VERSION.SDK_INT < 11) {
                return true;
            }
            return onCreatePanelMenu;
        }
        return super.onCreatePanelMenu(i, menu);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return super.onCreateView(str, context, attributeSet);
        }
        View a2 = this.mFragments.a((View) null, str, context, attributeSet);
        if (a2 == null) {
            return super.onCreateView(str, context, attributeSet);
        }
        return a2;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        doReallyStop(false);
        this.mFragments.t();
        if (this.mLoaderManager != null) {
            this.mLoaderManager.h();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 5 || i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.u();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case 0:
                return this.mFragments.a(menuItem);
            case 6:
                return this.mFragments.b(menuItem);
            default:
                return false;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case 0:
                this.mFragments.b(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mResumed = false;
        if (this.mHandler.hasMessages(2)) {
            this.mHandler.removeMessages(2);
            onResumeFragments();
        }
        this.mFragments.p();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mFragments.k();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mHandler.sendEmptyMessage(2);
        this.mResumed = true;
        this.mFragments.g();
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        this.mHandler.removeMessages(2);
        onResumeFragments();
        this.mFragments.g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onResumeFragments() {
        this.mFragments.o();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        if (this.mOptionsMenuInvalidated) {
            this.mOptionsMenuInvalidated = false;
            menu.clear();
            onCreatePanelMenu(i, menu);
        }
        return onPrepareOptionsPanel(view, menu) | this.mFragments.a(menu);
    }

    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        boolean z;
        if (this.mStopped) {
            doReallyStop(true);
        }
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        ArrayList<Fragment> i = this.mFragments.i();
        if (this.mAllLoaderManagers != null) {
            int size = this.mAllLoaderManagers.size();
            ad[] adVarArr = new ad[size];
            for (int i2 = size - 1; i2 >= 0; i2--) {
                adVarArr[i2] = this.mAllLoaderManagers.c(i2);
            }
            z = false;
            for (int i3 = 0; i3 < size; i3++) {
                ad adVar = adVarArr[i3];
                if (adVar.g) {
                    z = true;
                } else {
                    adVar.h();
                    this.mAllLoaderManagers.remove(adVar.d);
                }
            }
        } else {
            z = false;
        }
        if (i == null && !z && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        a aVar = new a();
        aVar.f59a = null;
        aVar.b = onRetainCustomNonConfigurationInstance;
        aVar.c = null;
        aVar.d = i;
        aVar.e = this.mAllLoaderManagers;
        return aVar;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable j = this.mFragments.j();
        if (j != null) {
            bundle.putParcelable(FRAGMENTS_TAG, j);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.mStopped = false;
        this.mReallyStopped = false;
        this.mHandler.removeMessages(1);
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.m();
        }
        this.mFragments.k();
        this.mFragments.g();
        if (!this.mLoadersStarted) {
            this.mLoadersStarted = true;
            if (this.mLoaderManager != null) {
                this.mLoaderManager.b();
            } else if (!this.mCheckedForLoaderManager) {
                this.mLoaderManager = getLoaderManager("(root)", this.mLoadersStarted, false);
                if (this.mLoaderManager != null && !this.mLoaderManager.f) {
                    this.mLoaderManager.b();
                }
            }
            this.mCheckedForLoaderManager = true;
        }
        this.mFragments.n();
        if (this.mAllLoaderManagers != null) {
            int size = this.mAllLoaderManagers.size();
            ad[] adVarArr = new ad[size];
            for (int i = size - 1; i >= 0; i--) {
                adVarArr[i] = this.mAllLoaderManagers.c(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                ad adVar = adVarArr[i2];
                adVar.e();
                adVar.g();
            }
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.mStopped = true;
        this.mHandler.sendEmptyMessage(1);
        this.mFragments.q();
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public Object getLastCustomNonConfigurationInstance() {
        a aVar = (a) getLastNonConfigurationInstance();
        if (aVar != null) {
            return aVar.b;
        }
        return null;
    }

    public void supportInvalidateOptionsMenu() {
        if (Build.VERSION.SDK_INT >= 11) {
            c.a(this);
        } else {
            this.mOptionsMenuInvalidated = true;
        }
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (Build.VERSION.SDK_INT >= 11) {
        }
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print("mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        printWriter.print(" mReallyStopped=");
        printWriter.println(this.mReallyStopped);
        printWriter.print(str2);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.mLoadersStarted);
        if (this.mLoaderManager != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.mLoaderManager)));
            printWriter.println(":");
            this.mLoaderManager.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        this.mFragments.a(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.println("View Hierarchy:");
        dumpViewHierarchy(str + "  ", printWriter, getWindow().getDecorView());
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:39:0x00ed. Please report as an issue. */
    private static String viewToString(View view) {
        String resourcePackageName;
        StringBuilder sb = new StringBuilder(128);
        sb.append(view.getClass().getName());
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(view)));
        sb.append(' ');
        switch (view.getVisibility()) {
            case 0:
                sb.append('V');
                break;
            case 4:
                sb.append('I');
                break;
            case 8:
                sb.append('G');
                break;
            default:
                sb.append('.');
                break;
        }
        sb.append(view.isFocusable() ? 'F' : '.');
        sb.append(view.isEnabled() ? 'E' : '.');
        sb.append(view.willNotDraw() ? '.' : 'D');
        sb.append(view.isHorizontalScrollBarEnabled() ? 'H' : '.');
        sb.append(view.isVerticalScrollBarEnabled() ? 'V' : '.');
        sb.append(view.isClickable() ? 'C' : '.');
        sb.append(view.isLongClickable() ? 'L' : '.');
        sb.append(' ');
        sb.append(view.isFocused() ? 'F' : '.');
        sb.append(view.isSelected() ? 'S' : '.');
        sb.append(view.isPressed() ? 'P' : '.');
        sb.append(' ');
        sb.append(view.getLeft());
        sb.append(',');
        sb.append(view.getTop());
        sb.append('-');
        sb.append(view.getRight());
        sb.append(',');
        sb.append(view.getBottom());
        int id = view.getId();
        if (id != -1) {
            sb.append(" #");
            sb.append(Integer.toHexString(id));
            Resources resources = view.getResources();
            if (id != 0 && resources != null) {
                switch ((-16777216) & id) {
                    case 16777216:
                        resourcePackageName = "android";
                        String resourceTypeName = resources.getResourceTypeName(id);
                        String resourceEntryName = resources.getResourceEntryName(id);
                        sb.append(" ");
                        sb.append(resourcePackageName);
                        sb.append(":");
                        sb.append(resourceTypeName);
                        sb.append("/");
                        sb.append(resourceEntryName);
                        break;
                    case 2130706432:
                        resourcePackageName = "app";
                        String resourceTypeName2 = resources.getResourceTypeName(id);
                        String resourceEntryName2 = resources.getResourceEntryName(id);
                        sb.append(" ");
                        sb.append(resourcePackageName);
                        sb.append(":");
                        sb.append(resourceTypeName2);
                        sb.append("/");
                        sb.append(resourceEntryName2);
                        break;
                    default:
                        try {
                            resourcePackageName = resources.getResourcePackageName(id);
                            String resourceTypeName22 = resources.getResourceTypeName(id);
                            String resourceEntryName22 = resources.getResourceEntryName(id);
                            sb.append(" ");
                            sb.append(resourcePackageName);
                            sb.append(":");
                            sb.append(resourceTypeName22);
                            sb.append("/");
                            sb.append(resourceEntryName22);
                            break;
                        } catch (Resources.NotFoundException e) {
                            break;
                        }
                }
            }
        }
        sb.append("}");
        return sb.toString();
    }

    private void dumpViewHierarchy(String str, PrintWriter printWriter, View view) {
        ViewGroup viewGroup;
        int childCount;
        printWriter.print(str);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.println(viewToString(view));
        if ((view instanceof ViewGroup) && (childCount = (viewGroup = (ViewGroup) view).getChildCount()) > 0) {
            String str2 = str + "  ";
            for (int i = 0; i < childCount; i++) {
                dumpViewHierarchy(str2, printWriter, viewGroup.getChildAt(i));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doReallyStop(boolean z) {
        if (!this.mReallyStopped) {
            this.mReallyStopped = true;
            this.mRetaining = z;
            this.mHandler.removeMessages(1);
            onReallyStop();
        }
    }

    void onReallyStop() {
        if (this.mLoadersStarted) {
            this.mLoadersStarted = false;
            if (this.mLoaderManager != null) {
                if (!this.mRetaining) {
                    this.mLoaderManager.c();
                } else {
                    this.mLoaderManager.d();
                }
            }
        }
        this.mFragments.r();
    }

    public void onAttachFragment(Fragment fragment) {
    }

    public p getSupportFragmentManager() {
        return this.mFragments;
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        if (i != -1 && ((-65536) & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
        super.startActivityForResult(intent, i);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i) {
        if (i == -1) {
            super.startActivityForResult(intent, -1);
        } else {
            if (((-65536) & i) != 0) {
                throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
            }
            super.startActivityForResult(intent, ((fragment.mIndex + 1) << 16) + (65535 & i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void invalidateSupportFragment(String str) {
        ad adVar;
        if (this.mAllLoaderManagers != null && (adVar = this.mAllLoaderManagers.get(str)) != null && !adVar.g) {
            adVar.h();
            this.mAllLoaderManagers.remove(str);
        }
    }

    public ac getSupportLoaderManager() {
        if (this.mLoaderManager != null) {
            return this.mLoaderManager;
        }
        this.mCheckedForLoaderManager = true;
        this.mLoaderManager = getLoaderManager("(root)", this.mLoadersStarted, true);
        return this.mLoaderManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad getLoaderManager(String str, boolean z, boolean z2) {
        if (this.mAllLoaderManagers == null) {
            this.mAllLoaderManagers = new android.support.v4.f.i<>();
        }
        ad adVar = this.mAllLoaderManagers.get(str);
        if (adVar == null) {
            if (z2) {
                ad adVar2 = new ad(str, this, z);
                this.mAllLoaderManagers.put(str, adVar2);
                return adVar2;
            }
            return adVar;
        }
        adVar.a(this);
        return adVar;
    }
}
