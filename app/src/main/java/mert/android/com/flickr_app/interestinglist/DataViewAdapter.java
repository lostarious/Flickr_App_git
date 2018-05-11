package mert.android.com.flickr_app.interestinglist;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import mert.android.com.flickr_app.R;
import mert.android.com.flickr_app.databinding.InterestingListItemBinding;
import mert.android.com.flickr_app.photo_data.PhotoItem;

/**
 * Created by lostarious on 30.04.2018
 * Copyright (c) 2018 YGA to present
 * All rights reserved.
 */
public class DataViewAdapter extends BaseRecyclerAdapter<DataViewHolder, PhotoItem> {
    private RecyclerOnClickListener listener;

    //veri almayı vermeyi fragment idare edecegi için listeneri oradan al
    public DataViewAdapter(List<PhotoItem> mDataset, RecyclerOnClickListener listener) {
        super(mDataset);
        this.listener = listener;
    }

    //Yeni view oluştur
    @Override
    public DataViewHolder createView(ViewGroup parent, int viewType) {
        //contextten inflateri al
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        //binding objesi oluştur
        InterestingListItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.interesting_list_item, parent, false);
        //bnding objesini viewholderin olarak return et
        return new DataViewHolder(binding);

    }

    //View içini doldur
    @Override
    public void bindView(DataViewHolder holder, int position) {
        holder.mBinding.setDisplayedItem(this.mDataSet.get(position));
        //Picasso implementasyonu
        ///imageview run edilmeden önce match_parent ile getWidth ve getHeight kullanamayacağımız için picassoyu böyle implemente et
        holder.mBinding.ivPlaceHolder.post(() -> Picasso.get().load(holder.mBinding.getDisplayedItem().getUrl())
                .resize(holder.mBinding.ivPlaceHolder.getWidth(), holder.mBinding.ivPlaceHolder.getHeight())
                .into(holder.mBinding.ivPlaceHolder));

        //DONE
        //Oncelikle elinde view holder objesi var
        // orada bu isi yapman gerekiyor.
        // Oraya gectikten sonra ise; ilk yontem klasik olan,
        // findViewById üzerinden viewlari tanimlayip, islem yapacaksin.
        // 2. yontem ise DataBinding ile interesting_list_item'in icine
        // PhotoItem'i variable olarak tanimlayip burada sadece binding.setPhoto(...) yapacaksin

        // Onclicklisteneri databinding kısmına nasıl gömebilirim?
        // Cevap - Lambda expression + acViewModel

        //iv için onclicklsitener
        holder.mBinding.ivPlaceHolder.setOnClickListener(v -> listener.itemClicked(holder.mBinding.getDisplayedItem()));
    }


    @Override
    public int getItemCount() {
        return this.mDataSet.size();
    }

    //onclicklistener interface oluştur
    //  11.05.2018 interface, class isimleri buyuk harfle baslat
    public interface RecyclerOnClickListener {
        void itemClicked(PhotoItem clickedItem);
    }

    // 11.05.2018 Generic isim problemi
    // 11.05.2018 Farkli bir folderin altinda tanimlayalim


}
