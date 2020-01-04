package com.prj.carey.wificlient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    private EditText editText_ip;
    private OutputStream outputStream = null;
    private Socket socket = null;
    private String ip;
    private String data;
    private boolean socketStatus = false;
    private Button btn_connect;
    private Button btn_f;
    private Button btn_l;
    private Button btn_s;
    private Button btn_r;
    private Button btn_b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_ip = (EditText) findViewById(R.id.et_ip);
        btn_connect = (Button)findViewById(R.id.btn_connect);
        btn_f = (Button)findViewById(R.id.btn_f);
        btn_l = (Button)findViewById(R.id.btn_l);
        btn_s = (Button)findViewById(R.id.btn_s);
        btn_r = (Button)findViewById(R.id.btn_r);
        btn_b = (Button)findViewById(R.id.btn_b);
        btn_connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ip = editText_ip.getText().toString();
                if(ip == null){
                    Toast.makeText(MainActivity.this,"please input Server IP",Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(MainActivity.this,ip,Toast.LENGTH_SHORT).show();
                Thread thread = new Thread(){
                    @Override
                    public void run() {
                        super.run();

                        if (!socketStatus) {

                            try {
                                socket = new Socket(ip,8000);
                                if(socket == null){
                                }else {
                                    socketStatus = true;
                                }
                                outputStream = socket.getOutputStream();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }

                    }
                };
                thread.start();
                Toast.makeText(MainActivity.this,"成功連接到Zenbo!",Toast.LENGTH_SHORT).show();
            }
        });
        btn_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = "forward";
                data = data + '\0';

                Thread thread = new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        if(socketStatus){
                            try {
                                outputStream.write(data.getBytes());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }

                    }
                };
                thread.start();
            }
        });
        btn_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = "left";
                data = data + '\0';

                Thread thread = new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        if(socketStatus){
                            try {
                                outputStream.write(data.getBytes());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }

                    }
                };
                thread.start();
            }
        });
        btn_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = "stop";
                data = data + '\0';

                Thread thread = new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        if(socketStatus){
                            try {
                                outputStream.write(data.getBytes());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }

                    }
                };
                thread.start();
            }
        });
        btn_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = "right";
                data = data + '\0';

                Thread thread = new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        if(socketStatus){
                            try {
                                outputStream.write(data.getBytes());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }

                    }
                };
                thread.start();
            }
        });
        btn_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = "backward";
                data = data + '\0';

                Thread thread = new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        if(socketStatus){
                            try {
                                outputStream.write(data.getBytes());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }

                    }
                };
                thread.start();
            }
        });
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        try {
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
