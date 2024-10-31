package android.databinding;

/* compiled from: BaseObservable.java */
/* loaded from: classes.dex */
public class a implements f {

    /* renamed from: a */
    private transient h f156a;

    public void notifyPropertyChanged(int i) {
        synchronized (this) {
            if (this.f156a == null) {
                return;
            }
            this.f156a.a(this, i, null);
            throw null;
        }
    }
}
