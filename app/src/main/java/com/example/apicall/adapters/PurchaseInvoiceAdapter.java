package com.example.apicall.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apicall.R;
import com.example.apicall.models.PurchaseInvoiceModel;

import java.util.List;

public class PurchaseInvoiceAdapter extends RecyclerView.Adapter<PurchaseInvoiceAdapter.ViewHolder> {

    private List<PurchaseInvoiceModel> purchaseInvoiceList;

    public PurchaseInvoiceAdapter(List<PurchaseInvoiceModel> purchaseInvoiceList) {
        this.purchaseInvoiceList = purchaseInvoiceList;
    }

    @NonNull
    @Override
    public PurchaseInvoiceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_purchase_invoice, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PurchaseInvoiceAdapter.ViewHolder holder, int position) {
        PurchaseInvoiceModel purchaseInvoice = purchaseInvoiceList.get(position);
        holder.codeTextView.setText(purchaseInvoice.getpI_Code());
        holder.companyTextView.setText(purchaseInvoice.getCompany());
        holder.dateTextView.setText(purchaseInvoice.getpI_Date().toString());
        holder.dueDateTextView.setText(purchaseInvoice.getDueDate().toString());
        holder.supplierNameTextView.setText(purchaseInvoice.getSupplierName());
        holder.statusTextView.setText(purchaseInvoice.isStatus() ? "Active" : "Inactive");
        holder.isSentTextView.setText(purchaseInvoice.getisSent() ? "Sent" : "Not Sent");
    }

    @Override
    public int getItemCount() {
        return purchaseInvoiceList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView codeTextView, companyTextView, dateTextView, dueDateTextView, supplierNameTextView, statusTextView, isSentTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            codeTextView = itemView.findViewById(R.id.codeTextView);
            companyTextView = itemView.findViewById(R.id.companyTextView);
            dateTextView = itemView.findViewById(R.id.dateTextView);
            dueDateTextView = itemView.findViewById(R.id.dueDateTextView);
            supplierNameTextView = itemView.findViewById(R.id.supplierNameTextView);
            statusTextView = itemView.findViewById(R.id.statusTextView);
            isSentTextView = itemView.findViewById(R.id.isSentTextView);
        }
    }

}
