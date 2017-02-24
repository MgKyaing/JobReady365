package com.example.win.jobready365.Server;

import com.squareup.otto.Bus;

/**
 * Created by zarni on 1/25/17.
 */

public class BusProvider {


        private static final Bus BUS = new Bus();

        public static Bus getInstance(){
            return BUS;
        }

        public BusProvider(){}

}
