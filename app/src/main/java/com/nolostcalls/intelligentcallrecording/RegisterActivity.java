package com.nolostcalls.intelligentcallrecording;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.nolostcalls.intelligentcallrecording.RightMenu.RightDrawer_Main;
import com.nolostcalls.intelligentcallrecording.app.AppConfig;
import com.nolostcalls.intelligentcallrecording.app.AppController;
import com.nolostcalls.intelligentcallrecording.helper.SessionManager;
import com.nolostcalls.intelligentcallrecording.helper.SQLiteHandler;
import com.nolostcalls.intelligentcallrecording.util.AlertDialogManagement;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegisterActivity extends Activity {
    private static final String TAG = RegisterActivity.class.getSimpleName();
       Button btnRegister;

    EditText inputFullName;
    EditText inputEmail;
    EditText inputPassword;
    EditText inputConfirm;
    EditText inputcompny_name;
    EditText inputcontact_no;
    EditText inputusername;
    CheckBox chk_condition;
    String name,email,password,contact_no,compny_name,username;
    AlertDialogManagement alert = new AlertDialogManagement();
    ProgressDialog pDialog;
    private SessionManager session;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        inputFullName = (EditText) findViewById(R.id.et_name);
        inputEmail = (EditText) findViewById(R.id.et_email);
        inputPassword = (EditText) findViewById(R.id.et_regi_pass);
        inputConfirm = (EditText) findViewById(R.id.et_confirmPass);
        inputcompny_name = (EditText) findViewById(R.id.et_compnyName);
        inputcontact_no = (EditText) findViewById(R.id.et_contactNo);
        inputusername = (EditText) findViewById(R.id.et_regi_user);
        chk_condition = (CheckBox) findViewById(R.id.chk_condition);
        btnRegister = (Button) findViewById(R.id.btn_regi_signup);


      /*  email = inputEmail.getText().toString().trim();

        inputEmail.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (email.matches(emailPattern) && s.length() > 0) {


                } else {
                    alert.showAlertDialog(RegisterActivity.this, "Invalid Email", "Please enter Valid Email Address", false);
                }
            }
        });

      */  pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        // Session manager
        session = new SessionManager(getApplicationContext());
        if (session.isLoggedIn()) {
            // User is already logged in. Take him to main activity
            Intent intent = new Intent(RegisterActivity.this,
                    RightDrawer_Main.class);
            startActivity(intent);
            finish();
        }

        btnRegister.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                name = inputFullName.getText().toString().trim();
                email = inputEmail.getText().toString().trim();
                password = inputPassword.getText().toString().trim();
                username = inputusername.getText().toString().trim();
                contact_no = inputcontact_no.getText().toString().trim();
                compny_name = inputcompny_name.getText().toString().trim();

                if(email.matches(emailPattern))
                {

                    if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty() && !username.isEmpty() && !contact_no.isEmpty() && !compny_name.isEmpty())
                    {

                        if(chk_condition.isChecked()) {
                            registerUser(name, email, password, username, contact_no, compny_name);
                          }
                        else
                        {
                            alert.showAlertDialog(RegisterActivity.this, "Alert !!","Please checked terms & condition !", false);

                        }
                    } else {
                        alert.showAlertDialog(RegisterActivity.this, "Alert !!","Please enter the credentials!", false);

                    }
                }else
                {
                    alert.showAlertDialog(RegisterActivity.this, "Invalid Email", "Please enter Valid Email Address", false);
                }



            }
        });

    }

    private void registerUser(final String name, final String email,
                              final String password, final String username, final String contact_no,final String compny_name) {
        // Tag used to cancel the request
        String tag_string_req = "req_register";

        pDialog.setMessage("Registering ...");
        showDialog();

        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_REGISTER, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Register Response: " + response.toString());
                hideDialog();
              Intent intent = new Intent(
                                RegisterActivity.this,
                                LoginActivity.class);
                        startActivity(intent);
                        finish();
                    } /*else {

                        // Error occurred in registration. Get the error
                        // message
                        String errorMsg = jObj.getString("error_msg");
                        Toast.makeText(getApplicationContext(),
                                errorMsg, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }*/


        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Registration Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting params to register url
                Map<String, String> params = new HashMap<String, String>();
                params.put("name", name);
                params.put("email", email);
                params.put("encrypted_password", password);
                params.put("username", username);
                params.put("contact_no",contact_no);
                params.put("compny_name",compny_name);
                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}


