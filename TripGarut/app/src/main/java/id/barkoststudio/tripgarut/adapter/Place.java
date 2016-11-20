package id.barkoststudio.tripgarut.adapter;

import android.content.Context;

/**
 * Created by yosef on 11/19/2016.
 */

public class Place {
    public String id;
    public String name;
    public String imageName;
    public boolean isFav;

    public int getImageResourceId(Context context) {
        return context.getResources().getIdentifier(this.imageName, "drawable", context.getPackageName());
    }
}
