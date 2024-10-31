package android.support.v4.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* compiled from: LocalBroadcastManager.java */
/* loaded from: classes.dex */
public class f {
    private static final Object f = new Object();
    private static f g;

    /* renamed from: a, reason: collision with root package name */
    private final Context f21a;
    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> b = new HashMap<>();
    private final HashMap<String, ArrayList<b>> c = new HashMap<>();
    private final ArrayList<a> d = new ArrayList<>();
    private final Handler e;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LocalBroadcastManager.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        final IntentFilter f23a;
        final BroadcastReceiver b;
        boolean c;

        b(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f23a = intentFilter;
            this.b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.b);
            sb.append(" filter=");
            sb.append(this.f23a);
            sb.append("}");
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LocalBroadcastManager.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final Intent f22a;
        final ArrayList<b> b;

        a(Intent intent, ArrayList<b> arrayList) {
            this.f22a = intent;
            this.b = arrayList;
        }
    }

    public static f a(Context context) {
        f fVar;
        synchronized (f) {
            if (g == null) {
                g = new f(context.getApplicationContext());
            }
            fVar = g;
        }
        return fVar;
    }

    private f(Context context) {
        this.f21a = context;
        this.e = new g(this, context.getMainLooper());
    }

    public void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.b) {
            b bVar = new b(intentFilter, broadcastReceiver);
            ArrayList<IntentFilter> arrayList = this.b.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.b.put(broadcastReceiver, arrayList);
            }
            arrayList.add(intentFilter);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList<b> arrayList2 = this.c.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.c.put(action, arrayList2);
                }
                arrayList2.add(bVar);
            }
        }
    }

    public void a(BroadcastReceiver broadcastReceiver) {
        int i;
        synchronized (this.b) {
            ArrayList<IntentFilter> remove = this.b.remove(broadcastReceiver);
            if (remove != null) {
                for (int i2 = 0; i2 < remove.size(); i2++) {
                    IntentFilter intentFilter = remove.get(i2);
                    for (int i3 = 0; i3 < intentFilter.countActions(); i3++) {
                        String action = intentFilter.getAction(i3);
                        ArrayList<b> arrayList = this.c.get(action);
                        if (arrayList != null) {
                            int i4 = 0;
                            while (i4 < arrayList.size()) {
                                if (arrayList.get(i4).b == broadcastReceiver) {
                                    arrayList.remove(i4);
                                    i = i4 - 1;
                                } else {
                                    i = i4;
                                }
                                i4 = i + 1;
                            }
                            if (arrayList.size() <= 0) {
                                this.c.remove(action);
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean a(Intent intent) {
        String str;
        ArrayList arrayList;
        synchronized (this.b) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f21a.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                Log.v("LocalBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<b> arrayList2 = this.c.get(intent.getAction());
            if (arrayList2 != null) {
                if (z) {
                    Log.v("LocalBroadcastManager", "Action list: " + arrayList2);
                }
                ArrayList arrayList3 = null;
                int i = 0;
                while (i < arrayList2.size()) {
                    b bVar = arrayList2.get(i);
                    if (z) {
                        Log.v("LocalBroadcastManager", "Matching against filter " + bVar.f23a);
                    }
                    if (bVar.c) {
                        if (z) {
                            Log.v("LocalBroadcastManager", "  Filter's target already added");
                            arrayList = arrayList3;
                        }
                        arrayList = arrayList3;
                    } else {
                        int match = bVar.f23a.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (match >= 0) {
                            if (z) {
                                Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                            }
                            arrayList = arrayList3 == null ? new ArrayList() : arrayList3;
                            arrayList.add(bVar);
                            bVar.c = true;
                        } else {
                            if (z) {
                                switch (match) {
                                    case -4:
                                        str = "category";
                                        break;
                                    case -3:
                                        str = NativeProtocol.WEB_DIALOG_ACTION;
                                        break;
                                    case -2:
                                        str = ShareConstants.WEB_DIALOG_PARAM_DATA;
                                        break;
                                    case -1:
                                        str = "type";
                                        break;
                                    default:
                                        str = "unknown reason";
                                        break;
                                }
                                Log.v("LocalBroadcastManager", "  Filter did not match: " + str);
                            }
                            arrayList = arrayList3;
                        }
                    }
                    i++;
                    arrayList3 = arrayList;
                }
                if (arrayList3 != null) {
                    for (int i2 = 0; i2 < arrayList3.size(); i2++) {
                        ((b) arrayList3.get(i2)).c = false;
                    }
                    this.d.add(new a(intent, arrayList3));
                    if (!this.e.hasMessages(1)) {
                        this.e.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        a[] aVarArr;
        while (true) {
            synchronized (this.b) {
                int size = this.d.size();
                if (size <= 0) {
                    return;
                }
                aVarArr = new a[size];
                this.d.toArray(aVarArr);
                this.d.clear();
            }
            for (a aVar : aVarArr) {
                for (int i = 0; i < aVar.b.size(); i++) {
                    aVar.b.get(i).b.onReceive(this.f21a, aVar.f22a);
                }
            }
        }
    }
}
