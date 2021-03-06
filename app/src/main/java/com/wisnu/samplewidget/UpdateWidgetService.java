package com.wisnu.samplewidget;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.RemoteViews;

/**
 * Created by wisnu on 17/02/2017.
 */

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class UpdateWidgetService extends JobService {
    public boolean onStartJob(JobParameters jobParameters) {
        AppWidgetManager manager = AppWidgetManager.getInstance(this);

        ComponentName theWidget = new ComponentName(this, BilanganAcakWidget.class);

        RemoteViews view = new RemoteViews(getPackageName(), R.layout.bilangan_acak_widget);
        String lastUpdate = "Random: " + NumberGenerator.Generate(100);
        view.setTextViewText(R.id.appwidget_text, lastUpdate);

        manager.updateAppWidget(theWidget, view);
        jobFinished(jobParameters, false);
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}