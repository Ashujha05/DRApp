package in.co.mtspl.dr.momentous;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by amreshkumar on 28/08/17.
 */

public class filteredProductAdapter extends RecyclerView.Adapter<filteredProductAdapter.MyViewHolder>{

    private List<Product> filteredProductsList;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView productName, productPacking, productQuantity;

        public MyViewHolder(View view) {
            super(view);
            productName = (TextView) view.findViewById(R.id.product_Name);
            productPacking = (TextView) view.findViewById(R.id.product_Packing);
            productQuantity = (TextView) view.findViewById(R.id.product_quantity);

        }
    }
    public filteredProductAdapter(List<Product> productsList) {
        this.filteredProductsList = productsList;
    }
    @Override
    public filteredProductAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.filtered_product_list, parent, false);

        return new filteredProductAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(filteredProductAdapter.MyViewHolder holder, int position) {
        Product product = filteredProductsList.get(position);
        holder.productName.setText(product.getProductName());
        holder.productPacking.setText(product.getProductPacking());
        holder.productQuantity.setText("Quantity : "+String.valueOf(product.productQuantity));
    }

    @Override
    public int getItemCount() {
        return filteredProductsList.size();
    }


}
