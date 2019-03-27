package com.joyoung.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PersonVM extends ViewModel {
    private MutableLiveData<Person> liveData;

    public LiveData<Person> getLiveData() {
        if (liveData == null) {
            liveData = new MutableLiveData<Person>();
            loadPerson();
        }
        return liveData;
    }

    /**
     * 在这里初始化Person
     */
    private void loadPerson() {
        Person person = new Person();
        person.setName("Jason");
        this.liveData.setValue(person);
    }

    /**
     * This method will be called when this ViewModel is no longer used and will be destroyed.
     */
    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
