package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.BackStackRecord;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

/* compiled from: BackStackRecord.java */
/* loaded from: classes.dex */
public final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator<BackStackState>() { // from class: android.support.v4.app.BackStackState.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public BackStackState[] newArray(int i) {
            return new BackStackState[i];
        }
    };

    /* renamed from: a */
    final int[] f698a;

    /* renamed from: b */
    final int f699b;

    /* renamed from: c */
    final int f700c;

    /* renamed from: d */
    final String f701d;

    /* renamed from: e */
    final int f702e;

    /* renamed from: f */
    final int f703f;

    /* renamed from: g */
    final CharSequence f704g;

    /* renamed from: h */
    final int f705h;
    final CharSequence i;
    final ArrayList<String> j;
    final ArrayList<String> k;
    final boolean l;

    /* compiled from: BackStackRecord.java */
    /* renamed from: android.support.v4.app.BackStackState$1 */
    /* loaded from: classes.dex */
    static class AnonymousClass1 implements Parcelable.Creator<BackStackState> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public BackStackState[] newArray(int i) {
            return new BackStackState[i];
        }
    }

    public BackStackState(BackStackRecord backStackRecord) {
        int size = backStackRecord.f685b.size();
        this.f698a = new int[size * 6];
        if (backStackRecord.i) {
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                BackStackRecord.Op op = backStackRecord.f685b.get(i2);
                int[] iArr = this.f698a;
                int i3 = i + 1;
                iArr[i] = op.f692a;
                int i4 = i3 + 1;
                Fragment fragment = op.f693b;
                iArr[i3] = fragment != null ? fragment.mIndex : -1;
                int[] iArr2 = this.f698a;
                int i5 = i4 + 1;
                iArr2[i4] = op.f694c;
                int i6 = i5 + 1;
                iArr2[i5] = op.f695d;
                int i7 = i6 + 1;
                iArr2[i6] = op.f696e;
                i = i7 + 1;
                iArr2[i7] = op.f697f;
            }
            this.f699b = backStackRecord.f690g;
            this.f700c = backStackRecord.f691h;
            this.f701d = backStackRecord.k;
            this.f702e = backStackRecord.m;
            this.f703f = backStackRecord.n;
            this.f704g = backStackRecord.o;
            this.f705h = backStackRecord.p;
            this.i = backStackRecord.q;
            this.j = backStackRecord.r;
            this.k = backStackRecord.s;
            this.l = backStackRecord.t;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BackStackRecord instantiate(FragmentManagerImpl fragmentManagerImpl) {
        BackStackRecord backStackRecord = new BackStackRecord(fragmentManagerImpl);
        int i = 0;
        int i2 = 0;
        while (i < this.f698a.length) {
            BackStackRecord.Op op = new BackStackRecord.Op();
            int i3 = i + 1;
            op.f692a = this.f698a[i];
            if (FragmentManagerImpl.f732a) {
                Log.v("FragmentManager", "Instantiate " + backStackRecord + " op #" + i2 + " base fragment #" + this.f698a[i3]);
            }
            int i4 = i3 + 1;
            int i5 = this.f698a[i3];
            if (i5 >= 0) {
                op.f693b = fragmentManagerImpl.k.get(i5);
            } else {
                op.f693b = null;
            }
            int[] iArr = this.f698a;
            int i6 = i4 + 1;
            op.f694c = iArr[i4];
            int i7 = i6 + 1;
            op.f695d = iArr[i6];
            int i8 = i7 + 1;
            op.f696e = iArr[i7];
            op.f697f = iArr[i8];
            backStackRecord.f686c = op.f694c;
            backStackRecord.f687d = op.f695d;
            backStackRecord.f688e = op.f696e;
            backStackRecord.f689f = op.f697f;
            backStackRecord.a(op);
            i2++;
            i = i8 + 1;
        }
        backStackRecord.f690g = this.f699b;
        backStackRecord.f691h = this.f700c;
        backStackRecord.k = this.f701d;
        backStackRecord.m = this.f702e;
        backStackRecord.i = true;
        backStackRecord.n = this.f703f;
        backStackRecord.o = this.f704g;
        backStackRecord.p = this.f705h;
        backStackRecord.q = this.i;
        backStackRecord.r = this.j;
        backStackRecord.s = this.k;
        backStackRecord.t = this.l;
        backStackRecord.a(1);
        return backStackRecord;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f698a);
        parcel.writeInt(this.f699b);
        parcel.writeInt(this.f700c);
        parcel.writeString(this.f701d);
        parcel.writeInt(this.f702e);
        parcel.writeInt(this.f703f);
        TextUtils.writeToParcel(this.f704g, parcel, 0);
        parcel.writeInt(this.f705h);
        TextUtils.writeToParcel(this.i, parcel, 0);
        parcel.writeStringList(this.j);
        parcel.writeStringList(this.k);
        parcel.writeInt(this.l ? 1 : 0);
    }

    public BackStackState(Parcel parcel) {
        this.f698a = parcel.createIntArray();
        this.f699b = parcel.readInt();
        this.f700c = parcel.readInt();
        this.f701d = parcel.readString();
        this.f702e = parcel.readInt();
        this.f703f = parcel.readInt();
        this.f704g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f705h = parcel.readInt();
        this.i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.j = parcel.createStringArrayList();
        this.k = parcel.createStringArrayList();
        this.l = parcel.readInt() != 0;
    }
}
