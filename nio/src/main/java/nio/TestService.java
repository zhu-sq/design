package nio;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    private int i =10;

    public int getI() {
        return i++;
    }

}
