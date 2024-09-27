package com.example.tp1exo3;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;

import android.view.View;
import android.widget.RadioButton;
import android.widget.Button;

import android.widget.CheckBox;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private CheckBox c1,c2,c3,c4;
    private RadioButton oui,non;
    private Button quitter,suivant;
    private String q1;
    private String q2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        c1=findViewById(R.id.c1);
        c2=findViewById(R.id.c2);
        c3=findViewById(R.id.c3);
        c4=findViewById(R.id.c4);
        oui=findViewById(R.id.oui);
        non=findViewById(R.id.non);
        quitter=findViewById(R.id.quitter);
        suivant=findViewById(R.id.suivant);


        quitter.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          MainActivity.this.finish();
                                      }


                                  }

        );
        suivant.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                                           if(c1.isChecked())
                                               q1=c1.getText().toString();
                                           else if(c2.isChecked())
                                               q1=c2.getText().toString();
                                           else if(c3.isChecked())
                                               q1=c3.getText().toString();
                                           else if(c4.isChecked())
                                               q1=c4.getText().toString();
                                           else
                                               q1="pas de reponse";
                                           if(oui.isChecked())
                                               q2="OUI";
                                           else if(non.isChecked())
                                               q2="NON";
                                           else
                                               q2="pas de reponse";
                                           intent.putExtra("q1", q1);
                                           intent.putExtra("q2", q2);
                                           startActivity(intent);

                                       }


                                   }

        );
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}