package com.example.jsonparsing;

import android.bluetooth.BluetoothClass;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.jsonparsing.domain.Device;
import com.example.jsonparsing.domain.Mouse;
import com.example.jsonparsing.domain.Our;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parseUsingGson();
    }


    private void parseUsingNativeAPI(){
        String json=Util.readAssests(this);
        Log.i(TAG,"our data: "+json);
        try {
            JSONObject obj=new JSONObject(json);
            Log.i(TAG,"Key String: "+obj.getString("keyString") );
            Log.i(TAG,"Key Number: "+obj.getString("keyNum") );


            JSONArray adds = obj.getJSONArray("adds");
                       for (int i = 0; i < adds.length(); i++) {
                                Log.i(TAG, "Address is - " + adds.getString(i));
                            }


                      JSONObject mouse = obj.getJSONObject("mouse");
                        Log.i(TAG, "Mouse Name - " + mouse.getString("name"));
                        Log.i(TAG, "Mouse Cost - " + mouse.getInt("cost"));

                                JSONArray devices = obj.getJSONArray("devices");
                        for (int i = 0; i < devices.length(); i++) {
                                JSONObject device = devices.getJSONObject(i);
                                Log.i(TAG, "Name - " + device.getString("name"));
                                Log.i(TAG, "Cost - " + device.getInt("cost"));
                            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    private void parseUsingGson() {
                Gson gson = new Gson();
                Our our = gson.fromJson(Util.readAssests(this), Our.class);
                Log.i(TAG, "Integer - " + our.getKeyNum());
                Log.i(TAG, "String - " + our.getKeyString());

                        for (String add : our.getAdds()) {
                        Log.i(TAG, "Add - " + add);
                    }

                        Mouse mouse = our.getMouse();
                Log.i(TAG, "Mouse Name - " + mouse.getName() + " Mouse Cost - " + mouse.getCost());

                        for (Device device : our.getDevices()) {
                        Log.i(TAG, "device Name - " + device.getName() + " device Cost - " + device.getCost());
                    }
            }
}


