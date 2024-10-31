package android.support.v7.app;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegateImplBase;
import android.support.v7.view.SupportActionModeWrapper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ActionMode;
import android.view.View;
import android.view.Window;

/* loaded from: classes.dex */
public class AppCompatDelegateImplV14 extends AppCompatDelegateImplV9 {
    private int U;
    private boolean V;
    private boolean W;
    private AutoNightModeManager X;

    /* loaded from: classes.dex */
    class AppCompatWindowCallbackV14 extends AppCompatDelegateImplBase.AppCompatWindowCallbackBase {
        public AppCompatWindowCallbackV14(Window.Callback callback) {
            super(callback);
        }

        public final ActionMode a(ActionMode.Callback callback) {
            SupportActionModeWrapper.CallbackWrapper callbackWrapper = new SupportActionModeWrapper.CallbackWrapper(AppCompatDelegateImplV14.this.f2142f, callback);
            android.support.v7.view.ActionMode startSupportActionMode = AppCompatDelegateImplV14.this.startSupportActionMode(callbackWrapper);
            if (startSupportActionMode != null) {
                return callbackWrapper.getActionModeWrapper(startSupportActionMode);
            }
            return null;
        }

        @Override // android.support.v7.view.WindowCallbackWrapper, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (AppCompatDelegateImplV14.this.isHandleNativeActionModesEnabled()) {
                return a(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }
    }

    /* loaded from: classes.dex */
    public final class AutoNightModeManager {

        /* renamed from: a */
        private TwilightManager f2150a;

        /* renamed from: b */
        private boolean f2151b;

        /* renamed from: c */
        private BroadcastReceiver f2152c;

        /* renamed from: d */
        private IntentFilter f2153d;

        /* renamed from: android.support.v7.app.AppCompatDelegateImplV14$AutoNightModeManager$1 */
        /* loaded from: classes.dex */
        public class AnonymousClass1 extends BroadcastReceiver {
            AnonymousClass1() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                AutoNightModeManager.this.b();
            }
        }

        AutoNightModeManager(TwilightManager twilightManager) {
            this.f2150a = twilightManager;
            this.f2151b = twilightManager.a();
        }

        final void a() {
            BroadcastReceiver broadcastReceiver = this.f2152c;
            if (broadcastReceiver != null) {
                AppCompatDelegateImplV14.this.f2142f.unregisterReceiver(broadcastReceiver);
                this.f2152c = null;
            }
        }

        final void b() {
            boolean a2 = this.f2150a.a();
            if (a2 != this.f2151b) {
                this.f2151b = a2;
                AppCompatDelegateImplV14.this.applyDayNight();
            }
        }

        final int c() {
            this.f2151b = this.f2150a.a();
            return this.f2151b ? 2 : 1;
        }

        final void d() {
            a();
            if (this.f2152c == null) {
                this.f2152c = new BroadcastReceiver() { // from class: android.support.v7.app.AppCompatDelegateImplV14.AutoNightModeManager.1
                    AnonymousClass1() {
                    }

                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        AutoNightModeManager.this.b();
                    }
                };
            }
            if (this.f2153d == null) {
                this.f2153d = new IntentFilter();
                this.f2153d.addAction("android.intent.action.TIME_SET");
                this.f2153d.addAction("android.intent.action.TIMEZONE_CHANGED");
                this.f2153d.addAction("android.intent.action.TIME_TICK");
            }
            AppCompatDelegateImplV14.this.f2142f.registerReceiver(this.f2152c, this.f2153d);
        }
    }

    public AppCompatDelegateImplV14(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
        this.U = -100;
        this.W = true;
    }

    private boolean f(int i) {
        Resources resources = this.f2142f.getResources();
        Configuration configuration = resources.getConfiguration();
        int i2 = configuration.uiMode & 48;
        int i3 = i == 2 ? 32 : 16;
        if (i2 == i3) {
            return false;
        }
        if (p()) {
            ((Activity) this.f2142f).recreate();
            return true;
        }
        Configuration configuration2 = new Configuration(configuration);
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        configuration2.uiMode = i3 | (configuration2.uiMode & (-49));
        resources.updateConfiguration(configuration2, displayMetrics);
        if (Build.VERSION.SDK_INT >= 26) {
            return true;
        }
        ResourcesFlusher.a(resources);
        return true;
    }

    private void n() {
        if (this.X == null) {
            this.X = new AutoNightModeManager(TwilightManager.a(this.f2142f));
        }
    }

    private int o() {
        int i = this.U;
        return i != -100 ? i : AppCompatDelegate.getDefaultNightMode();
    }

    private boolean p() {
        if (this.V) {
            Context context = this.f2142f;
            if (context instanceof Activity) {
                try {
                    return (context.getPackageManager().getActivityInfo(new ComponentName(this.f2142f, this.f2142f.getClass()), 0).configChanges & 512) == 0;
                } catch (PackageManager.NameNotFoundException e2) {
                    Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e2);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.support.v7.app.AppCompatDelegateImplV9
    View a(View view, String str, Context context, AttributeSet attributeSet) {
        return null;
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase
    Window.Callback a(Window.Callback callback) {
        return new AppCompatWindowCallbackV14(callback);
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase, android.support.v7.app.AppCompatDelegate
    public boolean applyDayNight() {
        int o = o();
        int d2 = d(o);
        boolean f2 = d2 != -1 ? f(d2) : false;
        if (o == 0) {
            n();
            this.X.d();
        }
        this.V = true;
        return f2;
    }

    public int d(int i) {
        if (i == -100) {
            return -1;
        }
        if (i != 0) {
            return i;
        }
        n();
        return this.X.c();
    }

    @Override // android.support.v7.app.AppCompatDelegateImplV9, android.support.v7.app.AppCompatDelegate
    public boolean hasWindowFeature(int i) {
        return super.hasWindowFeature(i) || this.f2143g.hasFeature(i);
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase, android.support.v7.app.AppCompatDelegate
    public boolean isHandleNativeActionModesEnabled() {
        return this.W;
    }

    @Override // android.support.v7.app.AppCompatDelegateImplV9, android.support.v7.app.AppCompatDelegate
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null || this.U != -100) {
            return;
        }
        this.U = bundle.getInt("appcompat:local_night_mode", -100);
    }

    @Override // android.support.v7.app.AppCompatDelegateImplV9, android.support.v7.app.AppCompatDelegateImplBase, android.support.v7.app.AppCompatDelegate
    public void onDestroy() {
        super.onDestroy();
        AutoNightModeManager autoNightModeManager = this.X;
        if (autoNightModeManager != null) {
            autoNightModeManager.a();
        }
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase, android.support.v7.app.AppCompatDelegate
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        int i = this.U;
        if (i != -100) {
            bundle.putInt("appcompat:local_night_mode", i);
        }
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase, android.support.v7.app.AppCompatDelegate
    public void onStart() {
        super.onStart();
        applyDayNight();
    }

    @Override // android.support.v7.app.AppCompatDelegateImplV9, android.support.v7.app.AppCompatDelegateImplBase, android.support.v7.app.AppCompatDelegate
    public void onStop() {
        super.onStop();
        AutoNightModeManager autoNightModeManager = this.X;
        if (autoNightModeManager != null) {
            autoNightModeManager.a();
        }
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase, android.support.v7.app.AppCompatDelegate
    public void setHandleNativeActionModesEnabled(boolean z) {
        this.W = z;
    }

    @Override // android.support.v7.app.AppCompatDelegateImplBase, android.support.v7.app.AppCompatDelegate
    public void setLocalNightMode(int i) {
        if (i != -1 && i != 0 && i != 1 && i != 2) {
            Log.i("AppCompatDelegate", "setLocalNightMode() called with an unknown mode");
        } else if (this.U != i) {
            this.U = i;
            if (this.V) {
                applyDayNight();
            }
        }
    }
}
