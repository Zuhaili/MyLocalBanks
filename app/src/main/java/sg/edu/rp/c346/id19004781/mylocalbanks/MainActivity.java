package sg.edu.rp.c346.id19004781.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.security.cert.Extension;
import java.time.ZoneOffset;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS, tvOCBC, tvUOB;
    String bankName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        bankName = "";


        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);


    }

    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_main, menu);

        if (v.getId() == tvDBS.getId()){
            bankName = "DBS";
        } else if(v.getId() == tvOCBC.getId()){
            bankName = "OCBC";
        } else if (v.getId() == tvUOB.getId()){
            bankName = "UOB";
        } else {
            bankName = "";
        }
    }

    public boolean onContextItemSelected(MenuItem item) {

        // Handle action bar item clicks here.
        int id = item.getItemId();
//        v.getId() == tvDBS.getId()

        if (id == R.id.WebsiteSelection) {
            if(bankName.equalsIgnoreCase("DBS")){
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);
            } else if (bankName.equalsIgnoreCase("OCBC")){
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);
            } else if (bankName.equalsIgnoreCase("UOB")){
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);
            }
        } else if (id == R.id.ContactSelection ) {
            if (bankName.equalsIgnoreCase("DBS")) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 68788888));
                startActivity(intentCall);
            } else if (bankName.equalsIgnoreCase("OCBC")) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 65381111));
                startActivity(intentCall);
            } else if (bankName.equalsIgnoreCase("UOB")) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 62526822));
                startActivity(intentCall);
            }
        }
        return super.onContextItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu1_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
            return true;
        } else {
            tvDBS.setText("Error translation");
            tvOCBC.setText("Error translation");
            tvUOB.setText("Error translation");
        }
        return super.onOptionsItemSelected(item);
    }







}
