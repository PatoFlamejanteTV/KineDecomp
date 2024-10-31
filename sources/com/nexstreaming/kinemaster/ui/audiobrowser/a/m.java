package com.nexstreaming.kinemaster.ui.audiobrowser.a;

import android.content.Context;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.kinemaster.ui.audiobrowser.s;
import com.nexstreaming.kinemaster.ui.audiobrowser.t;
import com.nexstreaming.kinemaster.ui.audiobrowser.u;
import java.util.List;

/* compiled from: MediaListerBase.java */
/* loaded from: classes.dex */
public abstract class m implements t {

    /* renamed from: a */
    protected ResultTask<List<u>> f21433a;

    /* renamed from: b */
    private ResultTask<List<s>> f21434b;

    /* renamed from: c */
    private long f21435c;

    @Override // com.nexstreaming.kinemaster.ui.audiobrowser.t
    public boolean a() {
        return false;
    }

    public List<s> b(Context context) {
        throw new IllegalStateException();
    }

    public abstract List<u> b(Context context, long j);

    @Override // com.nexstreaming.kinemaster.ui.audiobrowser.t
    public ResultTask<List<s>> a(Context context) {
        if (a()) {
            if (this.f21434b == null) {
                Context applicationContext = context.getApplicationContext();
                this.f21434b = new ResultTask<>();
                new k(this, applicationContext).execute(new Void[0]);
            }
            return this.f21434b;
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.nexstreaming.kinemaster.ui.audiobrowser.t
    public final ResultTask<List<u>> a(Context context, long j) {
        if (this.f21433a == null || this.f21435c != j) {
            Context applicationContext = context.getApplicationContext();
            this.f21435c = j;
            this.f21433a = new ResultTask<>();
            new l(this, applicationContext, j).execute(new Void[0]);
        }
        return this.f21433a;
    }
}
