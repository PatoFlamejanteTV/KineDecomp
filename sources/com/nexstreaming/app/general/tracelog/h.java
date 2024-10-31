package com.nexstreaming.app.general.tracelog;

import android.content.Context;
import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexeditorui.av;

/* compiled from: DeviceSupport.java */
/* loaded from: classes.dex */
public class h extends TLP<DeviceSupportRequest, DeviceSupportResponse> {
    private static h b;

    @Override // com.nexstreaming.app.general.tracelog.TLP
    public /* bridge */ /* synthetic */ long a() {
        return super.a();
    }

    @Override // com.nexstreaming.app.general.tracelog.TLP
    public /* bridge */ /* synthetic */ void a(boolean z) {
        super.a(z);
    }

    @Override // com.nexstreaming.app.general.tracelog.TLP
    public /* bridge */ /* synthetic */ long b() {
        return super.b();
    }

    @Override // com.nexstreaming.app.general.tracelog.TLP
    public /* bridge */ /* synthetic */ void b(boolean z) {
        super.b(z);
    }

    @Override // com.nexstreaming.app.general.tracelog.TLP
    public /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    public static h a(Context context) {
        if (b == null) {
            b = new h(context);
            b.a(true);
            if (av.a().a(true)) {
                b.b(true);
            }
        }
        return b;
    }

    private h(Context context) {
        super(context, DeviceSupportResponse.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.app.general.tracelog.TLP
    public boolean a(ResponseCode responseCode) {
        switch (responseCode) {
            case SUCCESS:
            case NO_MATCH:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.app.general.tracelog.TLP
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void b(DeviceSupportResponse deviceSupportResponse) {
        super.b((h) deviceSupportResponse);
        a((h) deviceSupportResponse, (deviceSupportResponse.next * 86400000) + System.currentTimeMillis(), Long.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.app.general.tracelog.TLP
    /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void a(DeviceSupportResponse deviceSupportResponse) {
        super.a((h) deviceSupportResponse);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.app.general.tracelog.TLP
    public void a(Task.TaskError taskError, DeviceSupportResponse deviceSupportResponse) {
        super.a(taskError, (Task.TaskError) deviceSupportResponse);
    }
}
