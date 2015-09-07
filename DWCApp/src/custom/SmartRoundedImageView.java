package custom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

public class SmartRoundedImageView extends SmartImageView {

    public SmartRoundedImageView(Context context) {
        super(context);
    }

    public SmartRoundedImageView() {
        super(null);
    }

    public SmartRoundedImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SmartRoundedImageView(Context context, AttributeSet attrs,
                                 int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Drawable drawable = getDrawable();

        if (drawable == null) {
            return;
        }

        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        Bitmap b = ((BitmapDrawable) drawable).getBitmap();
        Bitmap bitmap = b.copy(Bitmap.Config.ARGB_8888, true);
        int w = getWidth(), h = getHeight();
        Bitmap roundBitmap = getCroppedBitmap(bitmap, w);
        canvas.drawBitmap(roundBitmap, 0, 0, null);
    }

    public static Bitmap getCroppedBitmap(Bitmap bmp, int size) {
        Bitmap newBmp;
        if (bmp.getWidth() != size || bmp.getHeight() != size) {
            newBmp = Bitmap.createScaledBitmap(bmp, size, size, false);
        } else newBmp = bmp;

        Rect rect = new Rect(0, 0, newBmp.getWidth(), newBmp.getHeight());
        Bitmap output = Bitmap.createBitmap(newBmp.getWidth(),
                newBmp.getHeight(), Bitmap.Config.ARGB_8888);

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);

        Canvas canvas = new Canvas(output);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle(newBmp.getWidth() / 2 + 0f, newBmp.getHeight() / 2 + 0f,
                newBmp.getWidth() / 2 + 0f, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(newBmp, rect, rect, paint);

        return output;
    }

}
