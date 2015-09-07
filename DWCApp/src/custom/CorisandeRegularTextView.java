package custom;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class CorisandeRegularTextView extends TextView {

    public CorisandeRegularTextView(Context context, AttributeSet attrs,
                                    int defStyle) {
        super(context, attrs, defStyle);
        if (!isInEditMode()) {
            init();
        }
    }

    public CorisandeRegularTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()) {
            init();
        }
    }

    public CorisandeRegularTextView(Context context) {
        super(context);
        if (!isInEditMode()) {
            init();
        }
    }

    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                "Corisande-Regular.ttf");
        setTypeface(tf, 1);

    }
}