package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: FragmentManager.java */
/* loaded from: classes.dex */
public final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new Parcelable.Creator<FragmentManagerState>() { // from class: android.support.v4.app.FragmentManagerState.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        public FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public FragmentManagerState[] newArray(int i) {
            return new FragmentManagerState[i];
        }
    };

    /* renamed from: a */
    FragmentState[] f771a;

    /* renamed from: b */
    int[] f772b;

    /* renamed from: c */
    BackStackState[] f773c;

    /* renamed from: d */
    int f774d;

    /* renamed from: e */
    int f775e;

    /* compiled from: FragmentManager.java */
    /* renamed from: android.support.v4.app.FragmentManagerState$1 */
    /* loaded from: classes.dex */
    static class AnonymousClass1 implements Parcelable.Creator<FragmentManagerState> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        public FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public FragmentManagerState[] newArray(int i) {
            return new FragmentManagerState[i];
        }
    }

    public FragmentManagerState() {
        this.f774d = -1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f771a, i);
        parcel.writeIntArray(this.f772b);
        parcel.writeTypedArray(this.f773c, i);
        parcel.writeInt(this.f774d);
        parcel.writeInt(this.f775e);
    }

    public FragmentManagerState(Parcel parcel) {
        this.f774d = -1;
        this.f771a = (FragmentState[]) parcel.createTypedArray(FragmentState.CREATOR);
        this.f772b = parcel.createIntArray();
        this.f773c = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
        this.f774d = parcel.readInt();
        this.f775e = parcel.readInt();
    }
}
