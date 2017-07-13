package com.chiragawale.folinsight.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import com.chiragawale.folinsight.GlobalVar;
import com.chiragawale.folinsight.entity.Users;

import java.util.List;

/**
 * Created by chira on 7/13/2017.
 */

public class UserLoaderLocal extends AsyncTaskLoader<List<Users>> {
    private int activity_id;
    public UserLoaderLocal(Context context, int activity_id) {

        super(context);
        this.activity_id = activity_id;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Users> loadInBackground() {
        Log.w("Local loader called by ", activity_id + "======================================");
        if(activity_id == GlobalVar.FOLLOWED_BY_FRAGMENT) {
            return GlobalVar.userDao.getFollowedByList();
        }else {
            return GlobalVar.userDao.getFollowsList();
        }
    }
}