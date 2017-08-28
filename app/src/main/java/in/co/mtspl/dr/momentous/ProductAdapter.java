package in.co.mtspl.dr.momentous;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by amreshkumar on 27/08/17.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    private List<Product> productsList;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView productName, productPacking, productPrice,btnValue;
        public Button buttonplus, buttonminus;

        public MyViewHolder(View view) {
            super(view);
            productName = (TextView) view.findViewById(R.id.product_Name);
            productPacking = (TextView) view.findViewById(R.id.product_Packing);
            productPrice = (TextView) view.findViewById(R.id.product_Price);
            btnValue=(TextView) view.findViewById(R.id.btnvalue);
            buttonplus=(Button) view.findViewById(R.id.buttonplus);
            buttonminus=(Button) view.findViewById(R.id.buttonminus);

        }
    }


    public ProductAdapter(List<Product> productsList) {
        this.productsList = productsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Product product = productsList.get(position);
        holder.productName.setText(product.getProductName());
        holder.productPacking.setText(product.getProductPacking());
        holder.productPrice.setText(String.valueOf(product.getProductPrice()));
        holder.btnValue.setText(String.valueOf(product.productQuantity));
        holder.buttonplus.setTag(position);
        holder.buttonplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Product product = productsList.get((Integer)view.getTag());
                product.productQuantity += 1;
                notifyDataSetChanged();
            }
        });
        holder.buttonminus.setTag(position);
        holder.buttonminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Product product = productsList.get((Integer)view.getTag());
                if(product.productQuantity>0) {
                    product.productQuantity -= 1;
                    notifyDataSetChanged();
                }
            }
        });
}


    @Override
    public int getItemCount() {
        return productsList.size();
    }
}
