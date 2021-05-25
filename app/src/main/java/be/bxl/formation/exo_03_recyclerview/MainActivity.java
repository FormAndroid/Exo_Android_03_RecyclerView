package be.bxl.formation.exo_03_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import be.bxl.formation.exo_03_recyclerview.adapters.FoodAdpater;
import be.bxl.formation.exo_03_recyclerview.models.Food;

public class MainActivity extends AppCompatActivity {

    private List<Food> foods;

    private EditText etName, etCalory;
    private Spinner spCategory;
    private Button btnAdd;
    private RecyclerView rvFoods;

    private FoodAdpater foodAdpater;

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
        categoryChoices.add(getString(R.string.choice_category_fruit));
        categoryChoices.add(getString(R.string.choice_category_vegetable));
        categoryChoices.add(getString(R.string.choice_category_meat));

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_spinner_item,
                android.R.id.text1,
                categoryChoices
        );
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spCategory.setAdapter(spinnerAdapter);

        // Ajouter le comportement du bouton
        btnAdd.setOnClickListener(this::addFood); // -> Utilisation d'un pointeur référence


        // Création de l'adapter customiser (Aliment avec la CardView)
        foodAdpater = new FoodAdpater(
                getApplicationContext(),
                foods
        );

        // Configurer le RecyclerView
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(
                2, StaggeredGridLayoutManager.HORIZONTAL
        );
        rvFoods.setLayoutManager(layoutManager);

        rvFoods.setAdapter(foodAdpater);
    }

    private void addFood(View v) {
        String foodName   = etName.getText().toString();
        String foodCalory = etCalory.getText().toString();
        Food.Category foodCatEnum = getSelectedFoodCategory();
//        Log.d("DEBUG_FOOD", foodName);
//        Log.d("DEBUG_FOOD", foodCalory);
//        Log.d("DEBUG_FOOD", foodCatEnum.toString());

        Food food = new Food(
                foodName,
                Double.parseDouble(foodCalory),
                foodCatEnum
        );

        foods.add(0, food);
        foodAdpater.notifyDataSetChanged();
    }

    private Food.Category getSelectedFoodCategory() {
        String foodCat = spCategory.getSelectedItem().toString();

        Food.Category foodCatEnum;
        if (foodCat.equals(getString(R.string.choice_category_vegetable))) {
            foodCatEnum = Food.Category.VEGETABLE;
        }
        else if (foodCat.equals(getString(R.string.choice_category_fruit))) {
            foodCatEnum = Food.Category.FRUIT;
        }
        else if (foodCat.equals(getString(R.string.choice_category_meat))) {
            foodCatEnum = Food.Category.MEAT;
        }
        else {
            throw new RuntimeException("Category of food not supported !");
        }
        return foodCatEnum;
    }
}