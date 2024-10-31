package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* loaded from: classes.dex */
public final class LocalBroadcastManager {

    /* renamed from: a */
    private static final Object f1070a = new Object();

    /* renamed from: b */
    private static LocalBroadcastManager f1071b;

    /* renamed from: c */
    private final Context f1072c;

    /* renamed from: d */
    private final HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> f1073d = new HashMap<>();

    /* renamed from: e */
    private final HashMap<String, ArrayList<ReceiverRecord>> f1074e = new HashMap<>();

    /* renamed from: f */
    private final ArrayList<BroadcastRecord> f1075f = new ArrayList<>();

    /* renamed from: g */
    private final Handler f1076g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.support.v4.content.LocalBroadcastManager$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends Handler {
        AnonymousClass1(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                LocalBroadcastManager.this.a();
            } else {
                super.handleMessage(message);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class BroadcastRecord {

        /* renamed from: a */
        final Intent f1078a;

        /* renamed from: b */
        final ArrayList<ReceiverRecord> f1079b;

        BroadcastRecord(Intent intent, ArrayList<ReceiverRecord> arrayList) {
            this.f1078a = intent;
            this.f1079b = arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static final class ReceiverRecord {

        /* renamed from: a */
        final IntentFilter f1080a;

        /* renamed from: b */
        final BroadcastReceiver f1081b;

        /* renamed from: c */
        boolean f1082c;

        /* renamed from: d */
        boolean f1083d;

        ReceiverRecord(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f1080a = intentFilter;
            this.f1081b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.f1081b);
            sb.append(" filter=");
            sb.append(this.f1080a);
            if (this.f1083d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private LocalBroadcastManager(Context context) {
        this.f1072c = context;
        this.f1076g = new Handler(context.getMainLooper()) { // from class: android.support.v4.content.LocalBroadcastManager.1
            AnonymousClass1(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    LocalBroadcastManager.this.a();
                } else {
                    super.handleMessage(message);
                }
            }
        };
    }

    public static LocalBroadcastManager getInstance(Context context) {
        LocalBroadcastManager localBroadcastManager;
        synchronized (f1070a) {
            if (f1071b == null) {
                f1071b = new LocalBroadcastManager(context.getApplicationContext());
            }
            localBroadcastManager = f1071b;
        }
        return localBroadcastManager;
    }

    public void registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f1073d) {
            ReceiverRecord receiverRecord = new ReceiverRecord(intentFilter, broadcastReceiver);
            ArrayList<ReceiverRecord> arrayList = this.f1073d.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.f1073d.put(broadcastReceiver, arrayList);
            }
            arrayList.add(receiverRecord);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList<ReceiverRecord> arrayList2 = this.f1074e.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.f1074e.put(action, arrayList2);
                }
                arrayList2.add(receiverRecord);
            }
        }
    }

    public boolean sendBroadcast(Intent intent) {
        String str;
        ArrayList arrayList;
        int i;
        ArrayList<ReceiverRecord> arrayList2;
        String str2;
        synchronized (this.f1073d) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f1072c.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                Log.v("LocalBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<ReceiverRecord> arrayList3 = this.f1074e.get(intent.getAction());
            if (arrayList3 != null) {
                if (z) {
                    Log.v("LocalBroadcastManager", "Action list: " + arrayList3);
                }
                ArrayList arrayList4 = null;
                int i2 = 0;
                while (i2 < arrayList3.size()) {
                    ReceiverRecord receiverRecord = arrayList3.get(i2);
                    if (z) {
                        Log.v("LocalBroadcastManager", "Matching against filter " + receiverRecord.f1080a);
                    }
                    if (receiverRecord.f1082c) {
                        if (z) {
                            Log.v("LocalBroadcastManager", "  Filter's target already added");
                        }
                        i = i2;
                        arrayList2 = arrayList3;
                        str = action;
                        str2 = resolveTypeIfNeeded;
                        arrayList = arrayList4;
                    } else {
                        str = action;
                        arrayList = arrayList4;
                        i = i2;
                        arrayList2 = arrayList3;
                        str2 = resolveTypeIfNeeded;
                        int match = receiverRecord.f1080a.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (match >= 0) {
                            if (z) {
                                Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(receiverRecord);
                            receiverRecord.f1082c = true;
                            i2 = i + 1;
                            action = str;
                            arrayList3 = arrayList2;
                            resolveTypeIfNeeded = str2;
                        } else if (z) {
                            Log.v("LocalBroadcastManager", "  Filter did not match: " + (match != -4 ? match != -3 ? match != -2 ? match != -1 ? "unknown reason" : "type" : ShareConstants.WEB_DIALOG_PARAM_DATA : NativeProtocol.WEB_DIALOG_ACTION : "category"));
                        }
                    }
                    arrayList4 = arrayList;
                    i2 = i + 1;
                    action = str;
                    arrayList3 = arrayList2;
                    resolveTypeIfNeeded = str2;
                }
                ArrayList arrayList5 = arrayList4;
                if (arrayList5 != null) {
                    for (int i3 = 0; i3 < arrayList5.size(); i3++) {
                        ((ReceiverRecord) arrayList5.get(i3)).f1082c = false;
                    }
                    this.f1075f.add(new BroadcastRecord(intent, arrayList5));
                    if (!this.f1076g.hasMessages(1)) {
                        this.f1076g.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public void sendBroadcastSync(Intent intent) {
        if (sendBroadcast(intent)) {
            a();
        }
    }

    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f1073d) {
            ArrayList<ReceiverRecord> remove = this.f1073d.remove(broadcastReceiver);
            if (remove == null) {
                return;
            }
            for (int size = remove.size() - 1; size >= 0; size--) {
                ReceiverRecord receiverRecord = remove.get(size);
                receiverRecord.f1083d = true;
                for (int i = 0; i < receiverRecord.f1080a.countActions(); i++) {
                    String action = receiverRecord.f1080a.getAction(i);
                    ArrayList<ReceiverRecord> arrayList = this.f1074e.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            ReceiverRecord receiverRecord2 = arrayList.get(size2);
                            if (receiverRecord2.f1081b == broadcastReceiver) {
                                receiverRecord2.f1083d = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.f1074e.remove(action);
                        }
                    }
                }
            }
        }
    }

    public void a() {
        BroadcastRecord[] broadcastRecordArr;
        while (true) {
            synchronized (this.f1073d) {
                int size = this.f1075f.size();
                if (size <= 0) {
                    return;
                }
                broadcastRecordArr = new BroadcastRecord[size];
                this.f1075f.toArray(broadcastRecordArr);
                this.f1075f.clear();
            }
            for (BroadcastRecord broadcastRecord : broadcastRecordArr) {
                int size2 = broadcastRecord.f1079b.size();
                for (int i = 0; i < size2; i++) {
                    ReceiverRecord receiverRecord = broadcastRecord.f1079b.get(i);
                    if (!receiverRecord.f1083d) {
                        receiverRecord.f1081b.onReceive(this.f1072c, broadcastRecord.f1078a);
                    }
                }
            }
        }
    }
}
