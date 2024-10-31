package com.nexstreaming.kinemaster.ui.audiobrowser.a;

import android.content.Context;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.kinemaster.ui.audiobrowser.m;
import com.nexstreaming.kinemaster.ui.audiobrowser.n;
import java.util.List;

/* compiled from: MediaListerBase.java */
/* loaded from: classes.dex */
public abstract class f implements m {

    /* renamed from: a, reason: collision with root package name */
    private ResultTask<List<n>> f3662a;
    private ResultTask<List<com.nexstreaming.kinemaster.ui.audiobrowser.l>> b;
    private long c;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract List<n> b(Context context, long j);

    @Override // com.nexstreaming.kinemaster.ui.audiobrowser.m
    public boolean a() {
        return false;
    }

    @Override // com.nexstreaming.kinemaster.ui.audiobrowser.m
    public ResultTask<List<com.nexstreaming.kinemaster.ui.audiobrowser.l>> a(Context context) {
        if (!a()) {
            throw new UnsupportedOperationException();
        }
        if (this.b == null) {
            Context applicationContext = context.getApplicationContext();
            this.b = new ResultTask<>();
            new g(this, applicationContext).execute(new Void[0]);
        }
        return this.b;
    }

    @Override // com.nexstreaming.kinemaster.ui.audiobrowser.m
    public final ResultTask<List<n>> a(Context context, long j) {
        if (this.f3662a == null || this.c != j) {
            Context applicationContext = context.getApplicationContext();
            this.c = j;
            this.f3662a = new ResultTask<>();
            new h(this, applicationContext, j).execute(new Void[0]);
        }
        return this.f3662a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<com.nexstreaming.kinemaster.ui.audiobrowser.l> b(Context context) {
        throw new IllegalStateException();
    }
}
