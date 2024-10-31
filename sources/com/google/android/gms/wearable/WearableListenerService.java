package com.google.android.gms.wearable;

import android.app.Service;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.NodeApi;

/* loaded from: classes.dex */
public abstract class WearableListenerService extends Service implements CapabilityApi.CapabilityListener, ChannelApi.ChannelListener, DataApi.DataListener, MessageApi.MessageListener, NodeApi.NodeListener, NodeApi.zza {

    /* renamed from: a, reason: collision with root package name */
    private volatile int f2329a = -1;
    private Object b = new Object();
}
