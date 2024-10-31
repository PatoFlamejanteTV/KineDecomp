package com.nexstreaming.kinemaster.mediainfo;

import android.content.Context;
import com.nexstreaming.app.general.task.Task;

/* loaded from: classes.dex */
enum ThumbnailError implements Task.TaskError {
    RawFileNotFound,
    RawFileTooSmall,
    NoThumbailsFound,
    UnknownFormat,
    ParameterError;

    @Override // com.nexstreaming.app.general.task.Task.TaskError
    public Exception getException() {
        return null;
    }

    @Override // com.nexstreaming.app.general.task.Task.TaskError
    public String getMessage() {
        return name();
    }

    @Override // com.nexstreaming.app.general.task.Task.TaskError
    public String getLocalizedMessage(Context context) {
        return name();
    }
}
