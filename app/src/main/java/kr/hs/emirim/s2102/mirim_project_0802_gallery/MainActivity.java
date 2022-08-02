package kr.hs.emirim.s2102.mirim_project_0802_gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int[] posterId = {R.drawable.mv1, R.drawable.mv2, R.drawable.mv3, R.drawable.mv4,
                    R.drawable.mv5, R.drawable.mv6, R.drawable.mv7,
                    R.drawable.mv8, R.drawable.mv9, R.drawable.mv10};
    String[] posterTitle = {"타이타닉", "노트북", "세렌디피티", "유령신부", "빅피쉬",
                            "이터널 선샤인", "로미오와 줄리엣", "보헤미안랩소디",
                            "Knockin' On Heaven's Door", "노인을 위한 나라는 없다"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("갤러리 영화 포스터");
        Gallery gallery = findViewById(R.id.gallery);
        GalleryAdapter adapter = new GalleryAdapter(this);
        gallery.setAdapter(adapter);
    }

    public class GalleryAdapter extends BaseAdapter {
        Context context;
        public GalleryAdapter (Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return posterId.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imgv = new ImageView(context);
            ViewGroup.LayoutParams params = new Gallery.LayoutParams(200, 300);
            imgv.setLayoutParams(params);
            imgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imgv.setImageResource(posterId[i]);

            final int pos = i;
            imgv.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    ImageView largeImgv = findViewById(R.id.imgv);
                    largeImgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    largeImgv.setImageResource(posterId[pos]);
                    Toast toast = Toast.makeText(getApplicationContext(),
                            posterTitle[i],Toast.LENGTH_SHORT);
                    toast.show();
                    return false;
                }
            });

            return imgv;
        }
    }

}