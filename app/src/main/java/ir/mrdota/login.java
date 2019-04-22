package ir.mrdota;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;







import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class login  extends AppCompatActivity {

    Button signup , login ;
    RequestQueue requestQueue;
    EditText user , pass ;
    public static final String URI_SHOW_PARAMS = "http://mrdota.ir/SqliteSync/checkdb.php";
ProgressDialog pgdialog ;
String Err = "";
boolean oklist = false ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);

        signup = (Button) findViewById(R.id.signup);
        login = (Button) findViewById(R.id.login);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login.this,signup.class));
                finish();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checklist();
//                startActivity(new Intent(login.this,**.class));
            }
        });
    }
    private void login() {
        Thread TTT = new Thread(new Runnable() {
            @Override
            public void run() {
            }
        });

        // Sus Spw Smail ===> postto server
        //
        requestQueue = Volley.newRequestQueue(login.this);
        StringRequest req = new StringRequest(Request.Method.POST,
                URI_SHOW_PARAMS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name", user.getText().toString().trim());
                params.put("pw", pass.getText().toString().trim());


//                Toast.makeText(MainActivity.this, "ok", Toast.LENGTH_SHORT).show();
                return params;
            }

        };
//        pdialog.show();
        requestQueue.add(req);


    }
    public void checklist(){
        chempty();
        if (oklist == false) {
            Toast.makeText(this, "" + Err, Toast.LENGTH_SHORT).show();
            return;
        }
        chserver();
        if (oklist == false) {
            Toast.makeText(this, "" + Err, Toast.LENGTH_SHORT).show();
            return;
        }


        Err = "not err";
        oklist =true ;
        Toast.makeText(this, "err = "+Err + "oklist = "+oklist, Toast.LENGTH_SHORT).show();
    }
    public void chempty(){
        if (user.getText().toString().trim().isEmpty()){
            Err = "empty user name";
            oklist = false ;
            return ;
        }if (pass.getText().toString().trim().isEmpty()){
            Err = "empty pass ";
            oklist = false ;
            return ;
        }else oklist = true ;

    }
    public void chserver(){
//        login();
    }
}
