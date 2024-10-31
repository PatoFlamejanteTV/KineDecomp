package com.nexstreaming.kinemaster.kmpackage;

import android.opengl.GLSurfaceView;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

/* compiled from: EffectPreviewView.java */
/* loaded from: classes.dex */
class w implements GLSurfaceView.EGLConfigChooser {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexEditorDeviceProfile f3467a;
    final /* synthetic */ EffectPreviewView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(EffectPreviewView effectPreviewView, NexEditorDeviceProfile nexEditorDeviceProfile) {
        this.b = effectPreviewView;
        this.f3467a = nexEditorDeviceProfile;
    }

    @Override // android.opengl.GLSurfaceView.EGLConfigChooser
    public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
        int[] iArr = new int[19];
        iArr[0] = 12352;
        iArr[1] = 4;
        iArr[2] = 12324;
        iArr[3] = 8;
        iArr[4] = 12323;
        iArr[5] = 8;
        iArr[6] = 12322;
        iArr[7] = 8;
        iArr[8] = 12321;
        iArr[9] = 8;
        iArr[10] = 12326;
        iArr[11] = 1;
        iArr[12] = 12338;
        iArr[13] = this.f3467a.getGLMultisample() ? 1 : 0;
        iArr[14] = 12337;
        iArr[15] = this.f3467a.getGLMultisample() ? 2 : 0;
        iArr[16] = 12325;
        iArr[17] = this.f3467a.getGLDepthBufferBits();
        iArr[18] = 12344;
        int[] iArr2 = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12326, 8, 12344};
        int[] iArr3 = new int[1];
        egl10.eglChooseConfig(eGLDisplay, iArr, null, 0, iArr3);
        if (iArr3[0] < 1) {
            egl10.eglChooseConfig(eGLDisplay, iArr2, null, 0, iArr3);
        } else {
            iArr2 = iArr;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[iArr3[0]];
        egl10.eglChooseConfig(eGLDisplay, iArr2, eGLConfigArr, eGLConfigArr.length, iArr3);
        return eGLConfigArr[0];
    }
}
