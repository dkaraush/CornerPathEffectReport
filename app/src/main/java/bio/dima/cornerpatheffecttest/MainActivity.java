package bio.dima.cornerpatheffecttest;

import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Path path = new Path();
        path.addRect(0, 0, 200, 40, Path.Direction.CW);
        path.addRect(0, 40, 300, 80, Path.Direction.CW);
        final Paint paint = new Paint();
        paint.setColor(0xffff0000);
        paint.setPathEffect(new CornerPathEffect(20));

        final View testView = new View(this) {
            @Override
            protected void onDraw(@NonNull Canvas canvas) {
                canvas.drawColor(0xffffff00);
                canvas.drawPath(path, paint);
            }
        };
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(300, 300);
        ((FrameLayout) findViewById(R.id.container)).addView(testView, layoutParams);
    }
}
