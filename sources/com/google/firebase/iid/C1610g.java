package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

/* renamed from: com.google.firebase.iid.g */
/* loaded from: classes2.dex */
final class C1610g {

    /* renamed from: a */
    private final Messenger f17354a;

    /* renamed from: b */
    private final zzl f17355b;

    public C1610g(IBinder iBinder) throws RemoteException {
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        if ("android.os.IMessenger".equals(interfaceDescriptor)) {
            this.f17354a = new Messenger(iBinder);
            this.f17355b = null;
        } else if ("com.google.android.gms.iid.IMessengerCompat".equals(interfaceDescriptor)) {
            this.f17355b = new zzl(iBinder);
            this.f17354a = null;
        } else {
            String valueOf = String.valueOf(interfaceDescriptor);
            Log.w("MessengerIpcClient", valueOf.length() != 0 ? "Invalid interface descriptor: ".concat(valueOf) : new String("Invalid interface descriptor: "));
            throw new RemoteException();
        }
    }

    public final void a(Message message) throws RemoteException {
        Messenger messenger = this.f17354a;
        if (messenger != null) {
            messenger.send(message);
            return;
        }
        zzl zzlVar = this.f17355b;
        if (zzlVar != null) {
            zzlVar.a(message);
            return;
        }
        throw new IllegalStateException("Both messengers are null");
    }
}
