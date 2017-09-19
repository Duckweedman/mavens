package test.com.jnidemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mView1 = (TextView) findViewById(R.id.text);

    }

    public void showStr(View view) {
        JniTest test = new JniTest();
        mView1.setText(test.getStringFromC());
    }
}
