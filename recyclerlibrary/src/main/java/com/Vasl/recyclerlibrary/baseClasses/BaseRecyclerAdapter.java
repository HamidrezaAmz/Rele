package com.Vasl.recyclerlibrary.baseClasses;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Vasl.recyclerlibrary.globalInterfaces.MyCustomAdapterCallBack;
import com.Vasl.recyclerlibrary.utils.LogHelper;
import com.Vasl.recyclerlibrary.utils.PublicValue;

import java.util.List;

public abstract class BaseRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    int lastPosition = -1;

    private LogHelper logHelper = new LogHelper(BaseRecyclerAdapter.class);

    private MyCustomAdapterCallBack myCustomAdapterCallBack;

    public void setMyCustomAdapterCallBack(MyCustomAdapterCallBack myCustomAdapterCallBack) {
        this.myCustomAdapterCallBack = myCustomAdapterCallBack;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
        checkScrollChanged(getItemCount(), position);
    }

    protected int checkScrollChanged(int adapterSize, int position) {
        try {
            if (lastPosition >= position) {
                return lastPosition;
            }
            lastPosition = position;
            float percentage = ((position + 1) * 100 / adapterSize);
            if (percentage > PublicValue.percentVerticalNotify) {
                if (myCustomAdapterCallBack != null)
                    myCustomAdapterCallBack.verticalScrollRichToEnd();
            }
            if (myCustomAdapterCallBack != null)
                myCustomAdapterCallBack.horizontalScrollRichToEnd();
            return lastPosition;
        } catch (Exception ex) {
            logHelper.e("checkScrollChanged() called with: Exception = " + ex.getMessage() + " - Position = [" + position + "]");
            return lastPosition;
        }
    }
}
