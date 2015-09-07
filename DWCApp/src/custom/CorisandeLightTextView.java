package custom;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class CorisandeLightTextView extends TextView {

    public CorisandeLightTextView(Context context, AttributeSet attrs,
                                  int defStyle) {
        super(context, attrs, defStyle);
        if (!isInEditMode()) {
            init();
        }
    }

    public CorisandeLightTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()) {
            init();
        }
    }

    public CorisandeLightTextView(Context context) {
        super(context);
        if (!isInEditMode()) {
            init();
        }
    }

    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                "Corisande-Light.ttf");
        setTypeface(tf, 1);

    }
}
