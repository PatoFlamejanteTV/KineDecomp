package b.b.c;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import b.b.c.o;

/* compiled from: CustomTabsServiceConnection.java */
/* loaded from: classes.dex */
public abstract class l implements ServiceConnection {
    public abstract void onCustomTabsServiceConnected(ComponentName componentName, h hVar);

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        onCustomTabsServiceConnected(componentName, new k(this, o.a.a(iBinder), componentName));
    }
}
