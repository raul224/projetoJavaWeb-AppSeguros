package infnet.edu.seguros.loader;

import infnet.edu.seguros.model.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ClienteLoader implements ApplicationRunner {
    @Autowired
    private ClienteService service;

    @Override
    public void run(ApplicationArguments args) throws Exception{

    }
}
