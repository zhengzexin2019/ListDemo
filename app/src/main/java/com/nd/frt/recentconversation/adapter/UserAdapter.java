
package com.nd.frt.recentconversation.adapter;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.nd.frt.recentconversation.R;
import com.nd.frt.recentconversation.model.UserInfo;
import com.nd.frt.recentconversation.viewholder.UserViewHolder;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    private List<UserInfo> mUserInfos;

    public UserAdapter(List<UserInfo> userInfos) {
        mUserInfos = userInfos;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View inflate = layoutInflater.inflate(R.layout.item_user, viewGroup, false);
        return new UserViewHolder(inflate);

    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, @SuppressLint("RecyclerView") final int position) {
        final UserInfo userInfo = mUserInfos.get(position);
        Glide.with(userViewHolder.mIvAvatar)
                .load(userInfo.avatarUrl)
                .into(userViewHolder.mIvAvatar);
        userViewHolder.mTvUserName.setText(userInfo.userName);
        userViewHolder.mTvEmail.setText(userInfo.content);
    }

    @Override
    public int getItemCount() {
        return mUserInfos.size();
    }
}