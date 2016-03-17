package com.example.callcenter.form;

import javax.validation.GroupSequence;

public abstract class Orders {
    public interface Order1 {
    }

    public interface Order2 {
    }

    public interface Order3 {
    }

    public interface Order4 {
    }

    @GroupSequence({ Order1.class, Order2.class, Order3.class, Order4.class })
    public interface All {

    }

}
