package dataputextra.nayan.com.sms_send;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText number,sms;
    private Button sms_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        allfindid();


    }

    private void allfindid() {
        number = (EditText)findViewById(R.id.et_number);
        sms = (EditText)findViewById(R.id.et_sms);
        sms_send = (Button)findViewById(R.id.btn_send);

        sms_send.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String Moblie_No=number.getText().toString().trim();

        if(Moblie_No.isEmpty() || Moblie_No==null){
            number_valid(Moblie_No);
        }else {
            String Moblie_sms =sms.getText().toString().trim();
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.putExtra("address",Moblie_No);
            intent.putExtra("sms_body",Moblie_sms);
            intent.setData(Uri.parse("smsto:" + Moblie_No));
            intent.setType("vnd.android-dir/mms-sms");
            startActivity(intent);

        }

    }

    private void number_valid(String Moblie_No){
        if (Moblie_No.isEmpty() || Moblie_No==null) {
            number.setError("Invalid Number");
        }

    }
}
