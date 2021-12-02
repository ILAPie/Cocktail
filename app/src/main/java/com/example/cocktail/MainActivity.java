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
                int getCocktailSugar = Integer.parseInt(et_cSugar.getText().toString());
                int getCocktailAlcohol = Integer.parseInt(et_cAlcohol.getText().toString());
                String key = mDatabase.child("cocktails").push().getKey();

                HashMap result = new HashMap<>();
                result.put("name", getCocktailName);
                result.put("sugar", getCocktailSugar);
                result.put("alcohol", getCocktailAlcohol);

                writeNewCocktail("Vodka", getCocktailName, getCocktailSugar, getCocktailAlcohol);
            }
        });
    }
    //새 칵테일 추가
    public void writeNewCocktail(String cId, String cName, int cSugar, int cAlcohol){
        Cocktail cocktail = new Cocktail(cName, cSugar, cAlcohol);

        mDatabase.child("cocktails").child(cId).child(cName).setValue(cocktail);
    }

    /*
    private void writeNewCocktail(String cId, String cName, String cSugar, String cAlcohol){
        Cocktail cocktail = new Cocktail(cName, cSugar, cAlcohol);
        mDatabase.child("cocktails").child(cId).child("cName").setValue(cocktail)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this, "저장을 완료했습니다.",Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "저장을 실패했습니다.",Toast.LENGTH_SHORT).show();
                    }
                });
    }
     */
    /*
    private void readCocktail(){
        mDatabase.child("cocktails").child("a").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.getValue(Cocktail.class) != null){
                    Cocktail cocktail = dataSnapshot.getValue(Cocktail.class);
                    Log.d("FireBaseData", "getData" + cocktail.toString());
                }
                else{
                    Toast.makeText(MainActivity.this,"데이터 없음...", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("FireBaseData","loadPost::onCanclled", error.toException());
            }
        });*/
}