package custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import cloudconcept.dwc.R;

/**
 * Created by Abanoub Wagdy on 9/9/2015.
 */
public class DrawView extends View {

    Paint paint = new Paint();

    public DrawView(Context context) {
        super(context);
        paint.setColor(getContext().getResources().getColor(R.color.light_grey));
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawLine(0, 0, 20, 20, paint);
        canvas.drawLine(20, 0, 0, 20, paint);
    }

}
