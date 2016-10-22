package io.fruithcf.core.api.database;

/**
 * Copyright © 2016 Matthew E Development - All Rights Reserved
 * You may NOT use, distribute and modify this code.
 * <p>
 * Created by Matthew E on 10/22/2016 at 11:13 AM.
 */
public class Test {

    public void test() {
        String select = new Query().Select().All().From().Table("test").Where().Field("id").Equals().Field("test").End().getQuery();
        String delete = new Query().Delete().All().From().Table("test").Where().Field("id").Equals().Field("test").End().getQuery();
        String set = new Query().Insert().Into().Table("test").Fields("test", "test1").Values("testvalue", "test2value").End().getQuery();
    }
}
