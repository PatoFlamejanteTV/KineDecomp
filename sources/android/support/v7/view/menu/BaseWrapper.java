package android.support.v7.view.menu;

/* loaded from: classes.dex */
class BaseWrapper<T> {

    /* renamed from: a */
    final T f2431a;

    public BaseWrapper(T t) {
        if (t != null) {
            this.f2431a = t;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public T getWrappedObject() {
        return this.f2431a;
    }
}
