package com.example.cocktail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    EditText et_cName, et_cSugar, et_cAlcohol;
    Button btn_addCocktail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_cName = findViewById(R.id.cName);
        et_cSugar = findViewById(R.id.cSugar);
        et_cAlcohol = findViewById(R.id.cAlcohol);
        btn_addCocktail = findViewById(R.id.addCocktail);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.setValue("Cocktail database");

        btn_addCocktail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getCocktailName = et_cName.getText().toString();
                String getCocktailSugar = et_cSugar.getText().toString();
                String getCocktailAlcohol = et_cAlcohol.getText().toString();
                String key = mDatabase.child("cocktails").push().getKey();

                HashMap result = new HashMap<>();
                result.put("name", getCocktailName);
                result.put("sugar", getCocktailSugar);
                result.put("alcohol", getCocktailAlcohol);

                writeNewCocktail(key, getCocktailName, getCocktailSugar, getCocktailAlcohol);
            }
        });
    }
    //새 칵테일 추가
    public void writeNewCocktail(String cId, String cName, String cSugar, String cAlcohol){
        Cocktail cocktail = new Cocktail(cName, cSugar, cAlcohol);

        mDatabase.child("cocktails").child(cId).child(cName).setValue(cocktail);
    }
}