package AFK.AFK.Map.controller;

import AFK.AFK.Map.model.MyTravel;
import AFK.AFK.Map.repository.MyTravelRepository;
import AFK.AFK.Settings.model.Ask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/settings/user")
public class MyTravelController {
    @Autowired
    private MyTravelRepository myTravelRepository;

    // user 별로 가져오기긴 한데 -> 후 처리
    @GetMapping("/my-travel")
    public List<MyTravel> getAllEntities() {
        return myTravelRepository.findAll();
    }
//    @PostMapping("/my-travel")
//    public MyTravel createEntity(@RequestBody MyTravel myTravel) {
//        return myTravelRepository.save(myTravel);
//    }
}
