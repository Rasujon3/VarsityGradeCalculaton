package com.sujon.varsitygradecalculaton;

import com.sujon.varsitygradecalculaton.home.HomeFragmentInterface;

public class DataController {
    public static DataController instance;

    public static DataController getInstance(){
        if (instance==null){
            instance=new DataController();
        }
        return instance;
    }

    HomeFragmentInterface homeFragmentInterface;

    public HomeFragmentInterface getHomeFragmentInterface() {
        return homeFragmentInterface;
    }

    public void setHomeFragmentInterface(HomeFragmentInterface homeFragmentInterface) {
        this.homeFragmentInterface = homeFragmentInterface;
    }
}
