package com.win.transitapp.Controller;

import java.util.List;

import com.win.transitapp.Model.Bus;
import com.win.transitapp.Model.BusRequest;
import com.win.transitapp.Service.TransitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TransitController {
    @Autowired
    private TransitService apiService;

    @GetMapping("/buses")
    public String getBusesPage(Model model) {
        model.addAttribute("request", new BusRequest());
        return "index";
    }

    @PostMapping("/buses")
    public String getNearbyBuses(BusRequest request, Model model) {
        List<Bus> buses = apiService.getNearbyBuses(request);
        model.addAttribute("buses", buses);
        model.addAttribute("request", request);
        return "index";
    }
}