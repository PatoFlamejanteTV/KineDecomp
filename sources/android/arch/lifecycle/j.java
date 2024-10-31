package android.arch.lifecycle;

/* compiled from: LiveData.java */
/* loaded from: classes.dex */
public class j implements Runnable {

    /* renamed from: a */
    final /* synthetic */ LiveData f52a;

    public j(LiveData liveData) {
        this.f52a = liveData;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        Object obj3;
        obj = this.f52a.f14b;
        synchronized (obj) {
            obj2 = this.f52a.f18f;
            LiveData liveData = this.f52a;
            obj3 = LiveData.f13a;
            liveData.f18f = obj3;
        }
        this.f52a.setValue(obj2);
    }
}
