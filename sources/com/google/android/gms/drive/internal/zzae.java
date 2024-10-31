package com.google.android.gms.drive.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.CompletionListener;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.ProgressEvent;
import com.google.android.gms.drive.events.QueryResultEventParcelable;
import com.google.android.gms.drive.internal.zzao;
import java.util.List;

/* loaded from: classes2.dex */
public class zzae extends zzao.zza {

    /* renamed from: a */
    private final int f1130a;
    private final com.google.android.gms.drive.events.zzf b;
    private final a c;
    private final List<Integer> d;

    /* loaded from: classes2.dex */
    private static class a extends Handler {

        /* renamed from: a */
        private final Context f1131a;

        private static void a(com.google.android.gms.drive.events.zzl zzlVar, QueryResultEventParcelable queryResultEventParcelable) {
            DataHolder b = queryResultEventParcelable.b();
            if (b != null) {
                zzlVar.a(new com.google.android.gms.drive.internal.a(new MetadataBuffer(b)));
            }
            if (queryResultEventParcelable.c()) {
                zzlVar.a(queryResultEventParcelable.d());
            }
        }

        public void a(com.google.android.gms.drive.events.zzf zzfVar, DriveEvent driveEvent) {
            sendMessage(obtainMessage(1, new Pair(zzfVar, driveEvent)));
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Pair pair = (Pair) message.obj;
                    com.google.android.gms.drive.events.zzf zzfVar = (com.google.android.gms.drive.events.zzf) pair.first;
                    DriveEvent driveEvent = (DriveEvent) pair.second;
                    switch (driveEvent.a()) {
                        case 1:
                            ((ChangeListener) zzfVar).a((ChangeEvent) driveEvent);
                            return;
                        case 2:
                            ((CompletionListener) zzfVar).a((CompletionEvent) driveEvent);
                            return;
                        case 3:
                            a((com.google.android.gms.drive.events.zzl) zzfVar, (QueryResultEventParcelable) driveEvent);
                            return;
                        case 4:
                            ((com.google.android.gms.drive.events.zzc) zzfVar).a((ChangesAvailableEvent) driveEvent);
                            return;
                        case 5:
                        case 6:
                            ((com.google.android.gms.drive.events.zzi) zzfVar).a((ProgressEvent) driveEvent);
                            return;
                        default:
                            zzz.a("EventCallback", "Unexpected event: " + driveEvent);
                            return;
                    }
                default:
                    zzz.a(this.f1131a, "EventCallback", "Don't know how to handle this event");
                    return;
            }
        }
    }

    @Override // com.google.android.gms.drive.internal.zzao
    public void a(OnEventResponse onEventResponse) throws RemoteException {
        DriveEvent a2 = onEventResponse.a();
        com.google.android.gms.common.internal.zzx.a(this.f1130a == a2.a());
        com.google.android.gms.common.internal.zzx.a(this.d.contains(Integer.valueOf(a2.a())));
        this.c.a(this.b, a2);
    }
}
