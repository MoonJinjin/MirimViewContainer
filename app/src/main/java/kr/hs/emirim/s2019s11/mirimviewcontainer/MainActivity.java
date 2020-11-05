package kr.hs.emirim.s2019s11.mirimviewcontainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    ViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flipper);
        flipper = findViewById(R.id.flipper);
        Button btnPrev = findViewById(R.id.btn_prev);
        Button btnNext = findViewById(R.id.btn_next);
        btnPrev.setOnClickListener(btnListener);
        btnNext.setOnClickListener(btnListener);
        flipper.setOnTouchListener(touchListener);
    }

    // 화면을 밀면 방향대로 넘어감
    // *** XML ViewFlipper 요소에 clickable = true로 반드시 설정해줘야함
    float downX, upX;
    View.OnTouchListener touchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent e) {
            if(e.getAction() == MotionEvent.ACTION_DOWN) {
                downX = e.getX();
            } else if(e.getAction() == MotionEvent.ACTION_UP) {
                upX = e.getX();
                if(downX > upX) {
                    flipper.showNext();
                } else if(downX < upX) {
                    flipper.showPrevious();
                }
            }
            return false;
        }
    };

    // 버튼을 누르면 넘어감
    /*View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_prev:
                    flipper.showPrevious();
                    break;
                case R.id.btn_next:
                    flipper.showNext();
                    break;
            }
        }
    };*/
    // 1초 간격으로 자동으로 넘어감
    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_prev:
                    flipper.setFlipInterval(1000);
                    flipper.startFlipping();
                    break;
                case R.id.btn_next:
                    flipper.stopFlipping();
                    break;
            }
        }
    };
}