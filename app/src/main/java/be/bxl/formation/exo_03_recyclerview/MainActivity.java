package be.bxl.formation.exo_03_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import be.bxl.formation.exo_03_recyclerview.models.Food;

public class MainActivity extends AppCompatActivity {

    private List<Food> foods;

    private EditText etName, etCalory;
    private Spinner spCategory;
    private Button btnAdd;
    private RecyclerView rvFoods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialisation de la liste
        foods = new ArrayList<>();

        // Liaison avec le layoute
        etName = findViewById(R.id.et_main_food_name);
        etCalory = findViewById(R.id.et_main_food_calory);
        spCategory = findViewById(R.id.sp_main_food_type);
        btnAdd = findViewById(R.id.btn_main_add_food);
        rvFoods = findViewById(R.id.rv_main_foods);

        // Définition du Spinner
        List<String> categoryChoices = new ArrayList<>();
        categoryChoices.add(getString(R.string.choice_category_vegetable));
        categoryChoices.add(getString(R.string.choice_category_meat));
        categoryChoices.add(getString(R.string.choice_category_fruit));

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_spinner_item,
                android.R.id.text1,
                categoryChoices
        );

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spCategory.setAdapter(spinnerAdapter);

        // TODO Ajouter le comportement du bouton (-> Ajouter un aliment dans la liste)

        // TODO Configurer le RecyclerView
        // TODO Créer l'adapter customiser (Aliment avec la CardView)
    }
}