package com.nexstreaming.app.general.tracelog;

import android.content.Context;
import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexeditorui.E;

/* compiled from: DeviceSupport.java */
/* loaded from: classes2.dex */
public class p extends TLP<DeviceSupportRequest, DeviceSupportResponse> {
    private static p l;

    private p(Context context) {
        super(context, DeviceSupportResponse.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.app.general.tracelog.TLP
    public void b(DeviceSupportResponse deviceSupportResponse) {
        super.b((p) deviceSupportResponse);
        a((p) deviceSupportResponse, System.currentTimeMillis() + (deviceSupportResponse.next * 86400000), Long.MAX_VALUE);
    }

    public static p a(Context context) {
        if (l == null) {
            l = new p(context);
            l.b(true);
            if (E.c().b(true)) {
                l.a(true);
            }
        }
        return l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.app.general.tracelog.TLP
    public boolean a(ResponseCode responseCode) {
        int i = o.f19788a[responseCode.ordinal()];
        return i == 1 || i == 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.app.general.tracelog.TLP
    public void a(DeviceSupportResponse deviceSupportResponse) {
        super.a((p) deviceSupportResponse);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.app.general.tracelog.TLP
    public void a(Task.TaskError taskError, DeviceSupportResponse deviceSupportResponse) {
        super.a(taskError, (Task.TaskError) deviceSupportResponse);
    }
}
