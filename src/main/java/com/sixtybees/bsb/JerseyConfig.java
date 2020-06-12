package com.sixtybees.bsb;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.sixtybees.bsb.web.UserRestController;
import com.sixtybees.bsb.web.ResourceRestController;
import com.sixtybees.bsb.web.ShopRestController;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig()
    {
        register(UserRestController.class);
        register(ShopRestController.class);
        register(ResourceRestController.class);
    }
}
