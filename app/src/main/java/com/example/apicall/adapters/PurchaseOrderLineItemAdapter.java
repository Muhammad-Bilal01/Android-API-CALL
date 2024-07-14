package com.example.apicall.adapters;
import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

import com.example.apicall.R;
import com.example.apicall.models.PurchaseOrderLineItemsModel;

import java.util.List;

public class PurchaseOrderLineItemAdapter extends RecyclerView.Adapter<PurchaseOrderLineItemAdapter.ViewHolder> {

    private List<PurchaseOrderLineItemsModel> lineItemList;

    public PurchaseOrderLineItemAdapter(List<PurchaseOrderLineItemsModel> lineItemList) {
        this.lineItemList = lineItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.line_item_purchase_order, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PurchaseOrderLineItemsModel lineItem = lineItemList.get(position);


        System.out.println(lineItem.getPO_LineItemCode());

     holder.pO_LineItemCode.setText(String.valueOf(lineItem.getPO_LineItemCode()));
     holder.requiredBy.setText(lineItem.getRequiredBy());
     holder.quantity.setText(String.valueOf( lineItem.getQuantity()));
     holder.uomid.setText(String.valueOf(lineItem.getUomid()));
     holder.rate.setText(String.valueOf(lineItem.getRate()));
     holder.amount.setText(String.valueOf(lineItem.getAmount()));
    }

    @Override
    public int getItemCount() {
        return lineItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView pO_LineItemCode, requiredBy, quantity, uomid, rate,amount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           pO_LineItemCode = itemView.findViewById(R.id.codeTextView);
           requiredBy = itemView.findViewById(R.id.requireTextView);
           quantity = itemView.findViewById(R.id.quantityTextView);
           uomid = itemView.findViewById(R.id.uomidTextView);
           rate = itemView.findViewById(R.id.rateTextView);
           amount = itemView.findViewById(R.id.amountTextView);
        }
    }
}
