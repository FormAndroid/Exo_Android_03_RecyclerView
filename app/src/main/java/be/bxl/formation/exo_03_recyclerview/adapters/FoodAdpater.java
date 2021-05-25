package be.bxl.formation.exo_03_recyclerview.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import be.bxl.formation.exo_03_recyclerview.R;
import be.bxl.formation.exo_03_recyclerview.models.Food;

public class FoodAdpater extends RecyclerView.Adapter<FoodAdpater.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName, tvCalory;
        private CardView cvCategory;

        public ViewHolder(@NonNull View view) {
            super(view);

            tvName = view.findViewById(R.id.item_food_name);
            tvCalory = view.findViewById(R.id.item_food_calory);
            cvCategory = view.findViewById(R.id.item_cv_color);
        }

        public TextView getTvName() {
            return tvName;
        }

        public TextView getTvCalory() {
            return tvCalory;
        }

        public CardView getCvCategory() {
            return cvCategory;
        }
    }


    private List<Food> dataSet; // Utilisation du type interface (Découplage)
    private Context context;

    public FoodAdpater(Context context, List<Food> dataSet) {
        this.context = context;
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_food, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdpater.ViewHolder holder, int position) {
        Food food = dataSet.get(position);

        String foodCalory = String.format("%s %s", food.getCalory(), context.getString(R.string.unite_calory));

        holder.getTvName().setText(food.getName());
        holder.getTvCalory().setText(foodCalory);

        @ColorRes int colorRes;
        switch (food.getCategory()) {
            case MEAT:
                colorRes = R.color.food_meat;
                break;

            case FRUIT:
                colorRes = R.color.food_fruit;
                break;

            case VEGETABLE:
                colorRes = R.color.food_vegetable;
                break;

            default:
                throw new RuntimeException("Category food color not supported !");
        }

        holder.getCvCategory().setCardBackgroundColor(
                context.getResources().getColor(colorRes, context.getTheme())
        );
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
